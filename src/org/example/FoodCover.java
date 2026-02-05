package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class FoodCover extends JFrame implements ActionListener, MouseListener {
	JLabel l;
	Cursor c1;
	ImageIcon img0, img20;

	JButton loginBtn, signUpBtn;

	public FoodCover() {
		super("Foodflow");
		this.setSize(1240, 640);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0, 0, 0));

		c1 = new Cursor(Cursor.HAND_CURSOR);

		// Load GIF background
		img0 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Welcome Foodflow.gif")));
		l = new JLabel(img0);
		l.setBounds(0, 0, 1300, 600);

		// Use JLayeredPane to put buttons on top of GIF
		JLayeredPane layered = new JLayeredPane();
		layered.setBounds(0, 0, 1340, 725);
		this.add(layered);

		layered.add(l, Integer.valueOf(0)); // GIF at bottom layer

		// Login button
		loginBtn = new MyButton();
		loginBtn.setText("Login");
		loginBtn.setBounds(150, 450, 150, 40); // adjust position on GIF
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginBtn.setForeground(Color.white);
		loginBtn.setBackground(Color.black);
		loginBtn.setCursor(c1);
		loginBtn.setOpaque(false);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setBorderPainted(true);
		loginBtn.addActionListener(_ -> {
			this.setVisible(false);
			SignIn s = new SignIn();
			s.setVisible(true);
		});
		layered.add(loginBtn, Integer.valueOf(1)); // top layer

		// SignUp button
		signUpBtn = new MyButton();
		signUpBtn.setText("Sign Up");
		signUpBtn.setBounds(350, 450, 150, 40); // adjust position on GIF
		signUpBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signUpBtn.setForeground(Color.white);
		signUpBtn.setBackground(Color.black);
		signUpBtn.setCursor(c1);
		signUpBtn.setOpaque(false);
		signUpBtn.setContentAreaFilled(false);
		signUpBtn.setBorderPainted(true);
		signUpBtn.addActionListener(_ -> {
			this.setVisible(false);
			SignUp su = new SignUp();
			su.setVisible(true);
		});
		layered.add(signUpBtn, Integer.valueOf(1)); // top layer

		// Window icon
		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// no additional actions
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// optional hover effect if needed
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// optional hover effect if needed
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// optional if you want labels clickable
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// nothing needed
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// nothing needed
	}

	public static void main(String[] args) {
		FoodCover form = new FoodCover();
		form.setVisible(true);
	}
}
