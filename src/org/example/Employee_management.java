package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class Employee_management extends JFrame implements ActionListener, MouseListener {

	JLabel l,l6;
	JTextField t1,t2,t3,t4; // t4 for role
	JButton b1,b2,b3,b4,b5;
	JPanel p1;
	DefaultTableModel d;
	Cursor c1;
	JTable tb;
	String[] columns = {"Employee Name","Employee Id","Employee Salary","Role"}; // added Role
	JScrollPane sc;
	ImageIcon img20;
	ImageIcon back = new ImageIcon(Objects.requireNonNull(getClass().getResource("back1.png")));

	public Employee_management() {
		super("Employee Management");
		this.setSize(1200,750);
		this.setLocation(300, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

		p1 = new JPanel();
		p1.setSize(new Dimension(1920,1080));
		p1.setBackground(new Color(28,28,28));
		p1.setLayout(null);

		l6 = new JLabel(back);
		l6.setBounds(30, 30, 33, 33);
		l6.addMouseListener(this);
		p1.add(l6);

		d = new DefaultTableModel();
		d.setColumnIdentifiers(columns);

		tb = new JTable(d);
		tb.setRowHeight(40);
		tb.setFont(new Font("Arial",Font.PLAIN,15));

		sc = new JScrollPane(tb);
		sc.setBounds(120,360,950,280);
		p1.add(sc);

		l = new JLabel("Employee Management");
		l.setFont(new Font("Arial",Font.BOLD,40));
		l.setForeground(Color.white);
		l.setBounds(420,60,500,50);
		p1.add(l);

		t1 = new MyTextField();
		t1.setBounds(100,140,200,30);
		((MyTextField)t1).setHint("Employee Name");
		t1.setBackground(Color.gray);
		p1.add(t1);

		t2 = new MyTextField();
		t2.setBounds(370,140,150,30);
		t2.setBackground(Color.gray);
		((MyTextField)t2).setHint("Employee Id");
		p1.add(t2);

		t3 = new MyTextField();
		t3.setBounds(600,140,200,30);
		t3.setBackground(Color.gray);
		((MyTextField)t3).setHint("Salary");
		p1.add(t3);

		t4 = new MyTextField(); // new field for role
		t4.setBounds(850,140,250,30);
		t4.setBackground(Color.gray);
		((MyTextField)t4).setHint("Role");
		p1.add(t4);

		c1 = new Cursor(Cursor.HAND_CURSOR);

		b1 = new MyButton();
		b1.setText("Insert");
		b1.setBounds(120,250,150,35);
		b1.addActionListener(this);
		p1.add(b1);

		b2 = new MyButton();
		b2.setText("Clear");
		b2.setBounds(320,250,150,35);
		b2.addActionListener(this);
		p1.add(b2);

		b3 = new MyButton();
		b3.setText("Update");
		b3.setBounds(520,250,150,35);
		b3.addActionListener(this);
		p1.add(b3);

		b4 = new MyButton();
		b4.setText("Remove");
		b4.setBounds(720,250,150,35);
		b4.addActionListener(this);
		p1.add(b4);

		b5 = new MyButton();
		b5.setText("Search");
		b5.setBounds(920,250,150,35);
		b5.addActionListener(this);
		p1.add(b5);

		this.add(p1);
		loadEmployees();

		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int r = tb.getSelectedRow();
				t1.setText(d.getValueAt(r,0).toString());
				t2.setText(d.getValueAt(r,1).toString());
				t3.setText(d.getValueAt(r,2).toString());
				t4.setText(d.getValueAt(r,3).toString()); // role
			}
		});

		this.setVisible(true);
	}

	void loadEmployees() {
		d.setRowCount(0);
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM employees");

			while(rs.next()) {
				d.addRow(new Object[]{
						rs.getString("name"),
						rs.getString("emp_id"),
						rs.getDouble("salary"),
						rs.getString("role") // role
				});
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1) {
			// INSERT
			try {
				Connection con = DBConnection.getConnection();
				String sql = "INSERT INTO employees (emp_id,name,salary,role) VALUES (?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, t2.getText());
				ps.setString(2, t1.getText());
				ps.setDouble(3, Double.parseDouble(t3.getText()));
				ps.setString(4, t4.getText()); // use role from text field
				ps.executeUpdate();
				con.close();
				loadEmployees();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}

		else if(e.getSource()==b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText(""); // clear role
		}

		else if(e.getSource()==b3) {
			// UPDATE
			int r = tb.getSelectedRow();
			if(r==-1) return;
			try {
				Connection con = DBConnection.getConnection();
				String sql = "UPDATE employees SET name=?, salary=?, role=? WHERE emp_id=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, t1.getText());
				ps.setDouble(2, Double.parseDouble(t3.getText()));
				ps.setString(3, t4.getText()); // update role
				ps.setString(4, t2.getText());
				ps.executeUpdate();
				con.close();
				loadEmployees();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}

		else if(e.getSource()==b4) {
			// DELETE
			int r = tb.getSelectedRow();
			if(r==-1) return;
			try {
				Connection con = DBConnection.getConnection();
				String sql = "DELETE FROM employees WHERE emp_id=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, t2.getText());
				ps.executeUpdate();
				con.close();
				loadEmployees();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(e.getSource() == b5) {  // Search button
			String name = t1.getText().trim();
			d.setRowCount(0);  // clear table first
			try {
				Connection con = DBConnection.getConnection();
				String sql = "SELECT * FROM employees WHERE name LIKE ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, "%" + name + "%");  // search by partial name
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					d.addRow(new Object[]{
							rs.getString("name"),
							rs.getString("emp_id"),
							rs.getDouble("salary"),
							rs.getString("role")
					});
				}
				con.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==l6) {
			this.setVisible(false);
			new management().setVisible(true);
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public static void main(String[] args) {
		new Employee_management();
	}
}

