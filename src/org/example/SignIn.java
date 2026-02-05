package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class SignIn extends JFrame implements ActionListener, MouseListener {

	JLabel l, l1, l4, l6;
	JTextField t1;
	JButton b1, b2, b3;
	JPanel p1;
	JPasswordField pf;
	JCheckBox c;
	Cursor c1;
	ImageIcon img, img20;
	ImageIcon back = new ImageIcon(Objects.requireNonNull(getClass().getResource("backButton.png")));

	public SignIn() {

		super("Login");
		this.setSize(1100, 720);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(109, 109, 121));

		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

		p1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(33, 22, 16, 150));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		p1.setBounds(80, 80, 430, 500);
		p1.setLayout(null);
		p1.setOpaque(false);
		this.add(p1);

		l1 = new JLabel("User Login");
		l1.setFont(new Font("Mono-type Corsiva", Font.BOLD, 50));
		l1.setForeground(Color.white);
		l1.setBounds(100, 50, 300, 50);
		p1.add(l1);

		l4 = new JLabel();
		l4.setForeground(Color.red);
		l4.setBounds(45, 350, 340, 30);
		p1.add(l4);

		t1 = new MyTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1.setForeground(Color.white);
		t1.setOpaque(false);
		t1.setBounds(45, 170, 340, 50);
		((MyTextField) t1).setHint("User name");
		p1.add(t1);

		pf = new MyPasswordField();
		pf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pf.setForeground(Color.white);
		pf.setOpaque(false);
		pf.setBounds(45, 250, 340, 50);
		((MyPasswordField) pf).setHint("Password");
		p1.add(pf);

		c1 = new Cursor(Cursor.HAND_CURSOR);

		c = new JCheckBox("Show Password");
		c.setFocusPainted(false);
		c.setContentAreaFilled(false);
		c.setCursor(c1);
		c.setForeground(new Color(255, 255, 255));
		c.setFont(new Font("Tahoma",Font.PLAIN,17));
		c.setBorder(null);
		c.setBounds(45,295,340,40);
		p1.add(c);
		c.addActionListener(this);

		l6 = new JLabel(back);
		l6.setBounds(50, 30, 33, 33);
		l6.addMouseListener(this);
		this.add(l6);

		b1 = new MyButton();
		b1.setText("Login");
		b1.setFocusPainted(false);
		b1.setBounds(45, 400, 160, 40); // Login button, left
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		b1.setCursor(c1);
		((MyButton) b1).setRedius(8);
		b1.setBorder(null);
		p1.add(b1);
		b1.addActionListener(this);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(33,22,16));
				b1.setForeground(new Color(255, 255, 255));
			}
			public void mouseExited(MouseEvent e) {
				b1.setForeground(new Color(33,22,16));
				b1.setBackground(new Color(255, 255, 255));
			}
		});

		b2 = new MyButton();
		b2.setText("Sign up");
		b2.setFocusPainted(false);
		b2.setBounds(225, 400, 160, 40); // Sign up button, right
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		b2.setCursor(c1);
		((MyButton) b2).setRedius(8);
		b2.setBorder(null);
		p1.add(b2);
		b2.addActionListener(this);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				b2.setBackground(new Color(33,22,16));
				b2.setForeground(new Color(255, 255, 255));
			}
			public void mouseExited(MouseEvent e) {
				b2.setForeground(new Color(33,22,16));
				b2.setBackground(new Color(255, 255, 255));
			}
		});

		b3=new JButton("If you are Owner, Click Me");
		b3.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		b3.setFocusable(false);
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		b3.setForeground(Color.white);
		b3.setCursor(c1);
		b3.setBounds(45, 450, 340, 30);
		p1.add(b3);
		b3.addActionListener(this);

		img = new ImageIcon(Objects.requireNonNull(getClass().getResource("meat (4).jpg")));
		l = new JLabel(img);
		l.setBounds(-2050, -1600, 5496, 3744);
		this.add(l);

		this.setVisible(true);
	}

	// ===== DATABASE LOGIN LOGIC =====
	private void loginUser() {

		String username = t1.getText().trim();
		String password = new String(pf.getPassword()).trim();

		if (username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter username and password");
			return;
		}

		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int userId = rs.getInt("user_id");   // get PK from DB
				Session.loggedUserId = userId;       // store globally

				this.setVisible(false);
				user u = new user();
				u.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid username or password");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			loginUser();
		}
		else if (e.getSource() == b2) {
			this.setVisible(false);
			new SignUp().setVisible(true);
		}
		else if (e.getSource() == b3) {
			this.setVisible(false);
			new Owner().setVisible(true);
		}

		if (e.getSource() == c) {
			pf.setEchoChar(c.isSelected() ? (char) 0 : '●');
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == l6) {
			this.setVisible(false);
			new FoodCover().setVisible(true);
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public static void main(String[] args) {
		new SignIn().setVisible(true);
	}
}


