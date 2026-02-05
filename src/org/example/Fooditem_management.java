package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class Fooditem_management extends JFrame implements ActionListener, MouseListener {

	JLabel l, l6;
	MyTextField t1, t2, t3, t4, t5;
	MyButton b1, b2, b3, b4, b5;
	JPanel p1;
	DefaultTableModel d;
	Cursor c1;
	JTable tb;
	String[] columns = {"Food Name","Food Id","Available Quantity","Price","Category"};
	JScrollPane sc;

	ImageIcon img20;
	ImageIcon back = new ImageIcon(Objects.requireNonNull(Fooditem_management.class.getResource("back1.png")));

	public Fooditem_management() {
		super("Food Item Management");
		this.setSize(1380,750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

		p1 = new JPanel();
		p1.setSize(new Dimension(1920,1080));
		p1.setBackground(new Color(28,28,28));
		p1.setLayout(null);

		l6 = new JLabel(back);
		l6.setBounds(30,30,33,33);
		l6.addMouseListener(this);
		p1.add(l6);

		d = new DefaultTableModel();
		d.setColumnIdentifiers(columns);

		tb = new JTable(d);
		tb.setRowHeight(40);
		tb.setFont(new Font("Arial", Font.PLAIN, 15));

		sc = new JScrollPane(tb);
		sc.setBounds(200,360,950,280);
		p1.add(sc);

		l = new JLabel("Food Item Management");
		l.setFont(new Font("Arial", Font.BOLD, 40));
		l.setForeground(Color.white);
		l.setBounds(500,60,500,50);
		p1.add(l);

		// MyTextFields with placeholders
		t1 = new MyTextField(); t1.setBounds(110,160,200,30); t1.setBackground(Color.gray);((MyTextField)t1).setHint("Food Name"); p1.add(t1);
		t2 = new MyTextField(); t2.setBounds(340,160,200,30); t2.setBackground(Color.gray);((MyTextField)t2).setHint("Food Id"); p1.add(t2);
		t3 = new MyTextField(); t3.setBounds(570,160,200,30); t3.setBackground(Color.gray);((MyTextField)t3).setHint("Quantity"); p1.add(t3);
		t4 = new MyTextField(); t4.setBounds(820,160,200,30); t4.setBackground(Color.gray);((MyTextField)t4).setHint("Price"); p1.add(t4);
		t5 = new MyTextField(); t5.setBounds(1050,160,200,30); t5.setBackground(Color.gray);((MyTextField)t5).setHint("Category"); p1.add(t5);

		c1 = new Cursor(Cursor.HAND_CURSOR);

		// Buttons
		b1 = new MyButton(); b1.setText("Insert"); b1.setBounds(200,250,150,35); b1.setCursor(c1); p1.add(b1); b1.addActionListener(this);
		b2 = new MyButton(); b2.setText("Clear"); b2.setBounds(400,250,150,35); b2.setCursor(c1); p1.add(b2); b2.addActionListener(this);
		b3 = new MyButton(); b3.setText("Update"); b3.setBounds(600,250,150,35); b3.setCursor(c1); p1.add(b3); b3.addActionListener(this);
		b4 = new MyButton(); b4.setText("Remove"); b4.setBounds(800,250,150,35); b4.setCursor(c1); p1.add(b4); b4.addActionListener(this);
		b5 = new MyButton(); b5.setText("Search"); b5.setBounds(1000,250,150,35); b5.setCursor(c1); p1.add(b5); b5.addActionListener(this);

		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int r = tb.getSelectedRow();
				t1.setText(d.getValueAt(r,0).toString());
				t2.setText(d.getValueAt(r,1).toString());
				t3.setText(d.getValueAt(r,2).toString());
				t4.setText(d.getValueAt(r,3).toString());
				t5.setText(d.getValueAt(r,4).toString());
			}
		});

		this.add(p1);
		loadFoodItems();
		this.setVisible(true);
	}

	void loadFoodItems() {
		d.setRowCount(0);
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM fooditems");
			while(rs.next()) {
				d.addRow(new Object[]{
						rs.getString("food_name"),
						rs.getString("food_id"),
						rs.getInt("quantity"),
						rs.getDouble("price"),
						rs.getString("category")
				});
			}
			con.close();
		} catch(Exception e) { e.printStackTrace(); }
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps;
			if(e.getSource()==b1) { // Insert
				String sql = "INSERT INTO fooditems (food_name,food_id,quantity,price,category) VALUES (?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, t1.getText());
				ps.setString(2, t2.getText());
				ps.setInt(3, Integer.parseInt(t3.getText()));
				ps.setDouble(4, Double.parseDouble(t4.getText()));
				ps.setString(5, t5.getText());
				ps.executeUpdate();
			} else if(e.getSource()==b3) { // Update
				int r = tb.getSelectedRow();
				if(r==-1) return;
				String sql = "UPDATE fooditems SET food_name=?, quantity=?, price=?, category=? WHERE food_id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, t1.getText());
				ps.setInt(2, Integer.parseInt(t3.getText()));
				ps.setDouble(3, Double.parseDouble(t4.getText()));
				ps.setString(4, t5.getText());
				ps.setString(5, t2.getText());
				ps.executeUpdate();
			} else if(e.getSource()==b4) { // Delete
				int r = tb.getSelectedRow();
				if(r==-1) return;
				String sql = "DELETE FROM fooditems WHERE food_id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, t2.getText());
				ps.executeUpdate();
			} else if(e.getSource()==b2) { // Clear
				t1.setText(""); t2.setText(""); t3.setText(""); t4.setText(""); t5.setText("");
			}
			else if(e.getSource() == b5) {  // Search button
				String foodName = t1.getText().trim();
				d.setRowCount(0);  // clear table before showing results
				try {
					ps = con.prepareStatement("SELECT * FROM fooditems WHERE food_name LIKE ?");
					ps.setString(1, "%" + foodName + "%");  // partial match
					ResultSet rs = ps.executeQuery();

					while(rs.next()) {
						d.addRow(new Object[]{
								rs.getString("food_name"),
								rs.getString("food_id"),
								rs.getInt("quantity"),
								rs.getDouble("price"),
								rs.getString("category")
						});
					}
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				return; // stop here, do not call loadFoodItems() after search
			}


			con.close();
			loadFoodItems();
		} catch(Exception ex) { ex.printStackTrace(); }
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
		new Fooditem_management();
	}
}
