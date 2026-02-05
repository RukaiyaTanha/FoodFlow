package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class UserManagement extends JFrame implements ActionListener, MouseListener {

    JLabel l, l6;
    JTextField t1; // for searching name
    JButton bClear, bSearch;
    JPanel p1;
    DefaultTableModel d;
    Cursor c1;
    JTable tb;
    String[] columns = {"User ID","First Name","Last Name","Username","Email","Gender","Religion","Address"};
    JScrollPane sc;
    ImageIcon img20;
    ImageIcon back = new ImageIcon(Objects.requireNonNull(UserManagement.class.getResource("back1.png")));

    public UserManagement() {
        super("User Management");
        this.setSize(1200,750);
        this.setLocation(300, 100);
        this.setLayout(null);
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
        tb.setFont(new Font("Arial",Font.PLAIN,13));

        sc = new JScrollPane(tb);
        sc.setBounds(100,260,1000,370);
        p1.add(sc);

        l = new JLabel("User Management");
        l.setFont(new Font("Arial",Font.BOLD,40));
        l.setForeground(Color.white);
        l.setBounds(420,60,500,50);
        p1.add(l);

        t1 = new MyTextField();
        t1.setBounds(120,140,280,30);
        ((MyTextField)t1).setHint("Search by Name");
        t1.setBackground(Color.gray);
        p1.add(t1);

        c1 = new Cursor(Cursor.HAND_CURSOR);

        bSearch = new MyButton();
        bSearch.setText("Search");
        bSearch.setBounds(420,140,150,35);
        bSearch.addActionListener(this);
        p1.add(bSearch);

        bClear = new MyButton();
        bClear.setText("Clear");
        bClear.setBounds(600,140,150,35);
        bClear.addActionListener(this);
        p1.add(bClear);

        this.add(p1);
        loadUsers();

        this.setVisible(true);
    }

    void loadUsers() {
        d.setRowCount(0);
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT user_id, first_name, last_name, username, email, gender, religion, address FROM users");

            while(rs.next()) {
                d.addRow(new Object[]{
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getString("religion"),
                        rs.getString("address")
                });
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == bClear) {
            t1.setText("");
            loadUsers();
        }

        else if(e.getSource() == bSearch) {
            String name = t1.getText().trim();
            d.setRowCount(0);
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT user_id, first_name, last_name, username, email, gender, religion, address FROM users WHERE first_name LIKE ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    d.addRow(new Object[]{
                            rs.getInt("user_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("gender"),
                            rs.getString("religion"),
                            rs.getString("address")
                    });
                }
                con.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == l6) {
            this.setVisible(false);
            new management().setVisible(true);
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

    public static void main(String[] args) {
        new UserManagement();
    }
}
