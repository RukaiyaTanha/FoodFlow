package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class OrderManagement extends JFrame implements ActionListener, MouseListener {

    JLabel l, l6;
    JTextField t1; // for searching order_name or username
    JButton bClear, bSearch;
    JPanel p1;
    DefaultTableModel d;
    Cursor c1;
    JTable tb;
    String[] columns = {"Order ID","Order Name","User Name","Total","Payment Type","Timestamp"};
    JScrollPane sc;
    ImageIcon img20;
    ImageIcon back = new ImageIcon(Objects.requireNonNull(OrderManagement.class.getResource("back1.png")));

    public OrderManagement() {
        super("Order Management");
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

        l = new JLabel("Customer Order Management");
        l.setFont(new Font("Arial",Font.BOLD,40));
        l.setForeground(Color.white);
        l.setBounds(320,60,600,50);
        p1.add(l);

        t1 = new MyTextField();
        t1.setBounds(120,140,280,30);
        ((MyTextField)t1).setHint("Search by Order Name or User Name");
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
        loadOrders();

        this.setVisible(true);
    }

    void loadOrders() {
        d.setRowCount(0);
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT o.order_id, o.order_name, u.username, o.total, o.payment_type, o.timestamp " +
                    "FROM orders o JOIN users u ON o.user_id = u.user_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                d.addRow(new Object[]{
                        rs.getInt("order_id"),
                        rs.getString("order_name"),
                        rs.getString("username"),
                        rs.getDouble("total"),
                        rs.getString("payment_type"),
                        rs.getTimestamp("timestamp")
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
            loadOrders();
        } else if(e.getSource() == bSearch) {
            String search = t1.getText().trim();
            d.setRowCount(0);
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT o.order_id, o.order_name, u.username, o.total, o.payment_type, o.timestamp " +
                        "FROM orders o JOIN users u ON o.user_id = u.user_id " +
                        "WHERE o.order_name LIKE ? OR u.username LIKE ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                ps.setString(2, "%" + search + "%");
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    d.addRow(new Object[]{
                            rs.getInt("order_id"),
                            rs.getString("order_name"),
                            rs.getString("username"),
                            rs.getDouble("total"),
                            rs.getString("payment_type"),
                            rs.getTimestamp("timestamp")
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
        new OrderManagement();
    }
}
