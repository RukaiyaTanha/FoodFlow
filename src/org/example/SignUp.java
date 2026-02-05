package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;

public class SignUp extends JFrame implements ActionListener, MouseListener {

	JPanel p1;
	JTextField t1, t2, t3, t4, t5;
	JPasswordField pa1, pa2;
	JLabel l, l1,l11, l12;
	JButton b1,b3;
	JCheckBox j1;
	Cursor c1;
	ImageIcon img6, img20;
	JComboBox<String> cb, cb1;

	String[] gender = {"Choose", "Male", "Female", "Other"};
	String[] Religion = {"Choose Religion", "Islam", "Hinduism", "Christianity", "Sikhism", "Buddhism"};

	public SignUp() {

		this.setTitle("Create An Account");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1320, 700);
		this.setLocationRelativeTo(null);

		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

		p1 = new JPanel();
		p1.setSize(new Dimension(1415, 760));
		p1.setBackground(new Color(189, 180, 139));
		p1.setLayout(null);
		this.add(p1);

		c1 = new Cursor(Cursor.HAND_CURSOR);

		l1 = new JLabel("Create your Account");
		l1.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		l1.setBounds(160, 30, 500, 40);
		p1.add(l1);

		t1 = new MyTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		t1.setOpaque(false);
		t1.setBounds(80,110,200,40);
		((MyTextField) t1).setHint("First Name");
		p1.add(t1);

		t2 = new MyTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		t2.setOpaque(false);
		t2.setBounds(370,110,200,40);
		((MyTextField) t2).setHint("Last Name");
		p1.add(t2);

		t3 = new MyTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		t3.setOpaque(false);
		t3.setBounds(120,230,380,40);
		((MyTextField) t3).setHint("Email");
		p1.add(t3);

		t4 = new MyTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		t4.setOpaque(false);
		t4.setBounds(120,180,380,40);
		((MyTextField) t4).setHint("Username");
		p1.add(t4);

		t5 = new MyTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		t5.setOpaque(false);
		t5.setBounds(120,450,380,40);
		((MyTextField) t5).setHint("Address");
		p1.add(t5);

		pa1 = new MyPasswordField();
		pa1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pa1.setOpaque(false);
		pa1.setBounds(120,280,380,40);
		((MyPasswordField) pa1).setHint("Password");
		p1.add(pa1);

		pa2 = new MyPasswordField();
		pa2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pa2.setOpaque(false);
		pa2.setBounds(120,330,380,40);
		((MyPasswordField) pa2).setHint("Repassword");
		p1.add(pa2);

		j1 = new JCheckBox("Show Password");
		j1.setFocusPainted(false);
		j1.setContentAreaFilled(false);
		j1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		j1.setCursor(c1);
		j1.setForeground(Color.white);
		j1.setBorder(null);
		j1.setBounds(120,370,380,30);
		p1.add(j1);
		j1.addActionListener(this);

		l11 = new JLabel("Gender");
		l11.setBounds(80,410,300,30);
		l11.setForeground(Color.white);
		l11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		p1.add(l11);

		cb = new JComboBox<>(gender);
		cb.setBounds(150,410,150,30);
		cb.setSelectedIndex(0);
		cb.setBackground(new Color(189,180,139));
		cb.setForeground(Color.white);
		cb.setFont(new Font("Tahoma",Font.PLAIN,15));
		p1.add(cb);

		l12 = new JLabel("Religion");
		l12.setBounds(360,410,300,30);
		l12.setForeground(Color.white);
		l12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		p1.add(l12);

		cb1 = new JComboBox<>(Religion);
		cb1.setBounds(440,410,150,30);
		cb1.setSelectedIndex(0);
		cb1.setBackground(new Color(189,180,139));
		cb1.setForeground(Color.white);
		cb1.setFont(new Font("Tahoma",Font.PLAIN,15));
		p1.add(cb1);

		b1 = new MyButton();
		b1.setText("Confirm");
		b1.setFocusPainted(false);
		b1.setBounds(120,550,380,40);
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		b1.setCursor(c1);
		((MyButton) b1).setRedius(10);
		b1.setBorder(null);
		p1.add(b1);
		b1.addActionListener(this);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(0,0,0));
				b1.setForeground(new Color(255, 255, 255));
			}
			public void mouseExited(MouseEvent e) {
				b1.setForeground(new Color(0,0,0));
				b1.setBackground(new Color(255, 255, 255));
			}
		});

		b3=new JButton("Already have an account? LogIn");
		b3.setFont(new Font("Franklin Gothic Medium",Font.PLAIN,17));
		b3.setFocusable(false);
		b3.addActionListener(this);
		b3.setBackground(new Color(189,180,139));
		b3.setForeground(Color.black);
		b3.setBorder(BorderFactory.createEmptyBorder());
		b3.setBounds(150,600,300,20);
		b3.setCursor(c1);
		p1.add(b3);

		img6 = new ImageIcon(Objects.requireNonNull(getClass().getResource("ops (3).jpg")));
		l = new JLabel(img6);
		l.setBounds(630,-170,753,1130);
		p1.add(l);
	}

	// ===== SIGN UP USING DBConnection =====
	private void registerUser() {

		String first = t1.getText().trim();
		String last = t2.getText().trim();
		String username = t4.getText().trim();
		String email = t3.getText().trim();
		String address = t5.getText().trim();
		String g = cb.getSelectedItem().toString();
		String r = cb1.getSelectedItem().toString();
		String pass1 = new String(pa1.getPassword());
		String pass2 = new String(pa2.getPassword());

		if (first.isEmpty() || last.isEmpty() || username.isEmpty() ||
				email.isEmpty() || address.isEmpty() ||
				pass1.isEmpty() || pass2.isEmpty()) {

			JOptionPane.showMessageDialog(this, "Please fill all fields");
			return;
		}

		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(this, "Passwords do not match");
			return;
		}

		String sql = "INSERT INTO users " +
				"(first_name, last_name, username, email, password, gender, religion, address) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3, username);
			ps.setString(4, email);
			ps.setString(5, pass2);   // later you can hash
			ps.setString(6, g);
			ps.setString(7, r);
			ps.setString(8, address);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(this, "Account Created Successfully");
			this.setVisible(false);
			new SignIn().setVisible(true);

		} catch (SQLIntegrityConstraintViolationException ex) {
			JOptionPane.showMessageDialog(this, "Username or Email already exists");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			registerUser();
		}

		if (e.getSource() == b3) {
			this.setVisible(false);
			new SignIn().setVisible(true);
		}

		if (e.getSource() == j1) {
			char ch = j1.isSelected() ? (char) 0 : '●';
			pa1.setEchoChar(ch);
			pa2.setEchoChar(ch);
		}
	}

	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public static void main(String[] args) {
		new SignUp().setVisible(true);
	}
}
