package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;

public class feedback extends JFrame implements ActionListener {
	JPanel p1;
	JLabel titleLabel;
	JTextArea feedbackArea;
	JButton backButton, submitButton;
	JScrollPane scrollPane;
	Cursor cursor;
	ImageIcon img20;

	public feedback() {
		super("Feedback");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		cursor = new Cursor(Cursor.HAND_CURSOR);

		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

		// Main panel
		p1 = new JPanel();
		p1.setBounds(0, 0, 600, 450);
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
		this.add(p1);

		// Title
		titleLabel = new JLabel("Give us your feedback:");
		titleLabel.setBounds(30, 20, 400, 30);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		titleLabel.setForeground(new Color(0, 50, 100));
		p1.add(titleLabel);

		// Feedback area
		feedbackArea = new JTextArea();
		feedbackArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		feedbackArea.setLineWrap(true);
		feedbackArea.setWrapStyleWord(true);
		feedbackArea.setBackground(new Color(245, 245, 245));

		scrollPane = new JScrollPane(feedbackArea);
		scrollPane.setBounds(30, 60, 520, 250);
		p1.add(scrollPane);

		// Back button
		backButton = new JButton("Back");
		backButton.setBounds(30, 330, 120, 35);
		backButton.setCursor(cursor);
		backButton.setBackground(new Color(230, 230, 230));
		backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		backButton.addActionListener(this);
		p1.add(backButton);

		// Submit button
		submitButton = new JButton("Submit");
		submitButton.setBounds(430, 330, 120, 35);
		submitButton.setCursor(cursor);
		submitButton.setBackground(new Color(0, 105, 150));
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		submitButton.addActionListener(this);
		p1.add(submitButton);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			new user().setVisible(true); // Go back to user page
			this.dispose();
		} else if(e.getSource()==submitButton) {
			String message = feedbackArea.getText().trim();
			if(message.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Please enter feedback.","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			try {
				Connection con = DBConnection.getConnection();
				String sql = "INSERT INTO feedbacks (user_id, message) VALUES (?, ?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, Session.loggedUserId); // the logged-in user
				ps.setString(2, message);
				ps.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(null,"Feedback submitted successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
				feedbackArea.setText(""); // clear textarea
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Database error: " + ex.getMessage());
			}
		}

	}

	public static void main(String[] args) {
		new feedback();
	}
}
