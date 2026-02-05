package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CartView extends JFrame implements ActionListener {

    JTable table;
    DefaultTableModel model;
    JButton btnClear, btnCheckout, btnClose;
    JLabel totalLabel;

    JFrame parent;

    public CartView(JFrame parent) {
        super("Your Cart");
        this.parent = parent;

        setSize(600, 450);
        setLocationRelativeTo(parent);
        setLayout(null);

        String[] cols = {"Item Name", "Quantity", "Price", "Subtotal"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        table.setRowHeight(30);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30, 30, 520, 220);
        add(sp);

        totalLabel = new JLabel();
        totalLabel.setBounds(30, 260, 300, 30);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(totalLabel);

        btnClear = new JButton("Clear Cart");
        btnClear.setBounds(30, 310, 140, 35);
        btnClear.addActionListener(this);
        add(btnClear);

        btnCheckout = new JButton("Checkout");
        btnCheckout.setBounds(210, 310, 140, 35);
        btnCheckout.addActionListener(this);
        add(btnCheckout);

        btnClose = new JButton("Close");
        btnClose.setBounds(390, 310, 140, 35);
        btnClose.addActionListener(this);
        add(btnClose);

        loadCart();
    }

    private void loadCart() {
        model.setRowCount(0);
        for (CartItem item : Cart.getItems()) {
            model.addRow(new Object[]{
                    item.name,
                    item.quantity,
                    item.price,
                    item.quantity * item.price
            });
        }
        totalLabel.setText("Total: " + Cart.getTotal());
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnClear) {
            Cart.clear();
            loadCart();
        }

        if (e.getSource() == btnCheckout) {
            if (Cart.getItems().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cart is empty");
                return;
            }

            String payment = JOptionPane.showInputDialog(
                    this,
                    "Enter payment type (Cash / Card / Bkash):"
            );

            if (payment != null && !payment.trim().isEmpty()) {
                int userId = Session.loggedUserId; // whatever you already use
                OrderDAO.saveOrder(userId, payment);
                JOptionPane.showMessageDialog(this, "Order placed successfully");
                loadCart();
                dispose();
            }
        }

        if (e.getSource() == btnClose) {
            dispose();
        }
    }
}
