package org.example;

import java.sql.*;
import java.util.List;

public class OrderDAO {

    // Save the cart items as an order after payment
    public static void saveOrder(int userId, String paymentType) {
        List<CartItem> items = Cart.getItems();
        if (items.isEmpty()) return;

        Connection conn = null;
        PreparedStatement psOrder = null;
        PreparedStatement psItem = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            if (conn == null) throw new SQLException("Connection failed");

            conn.setAutoCommit(false); // start transaction

            // Generate order_name from timestamp or userId for display
            String orderName = "Order_" + System.currentTimeMillis(); // simple unique name

            // 1. Insert into orders table
            psOrder = conn.prepareStatement(
                    "INSERT INTO orders(user_id, order_name, total, payment_type) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            psOrder.setInt(1, userId);
            psOrder.setString(2, orderName);       // new order_name
            psOrder.setDouble(3, Cart.getTotal());
            psOrder.setString(4, paymentType);
            psOrder.executeUpdate();

            rs = psOrder.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // 2. Insert items into order_items table
            psItem = conn.prepareStatement(
                    "INSERT INTO order_items(order_id, item_name, price, quantity) VALUES (?, ?, ?, ?)"
            );
            for (CartItem item : items) {
                psItem.setInt(1, orderId);
                psItem.setString(2, item.name);
                psItem.setDouble(3, item.price);
                psItem.setInt(4, item.quantity);
                psItem.addBatch();
            }
            psItem.executeBatch();

            conn.commit(); // commit transaction

            // 3. Clear cart after successful payment
            Cart.clear();

        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
        } finally {
            try { if(rs != null) rs.close(); } catch(Exception e) {}
            try { if(psOrder != null) psOrder.close(); } catch(Exception e) {}
            try { if(psItem != null) psItem.close(); } catch(Exception e) {}
            try { if(conn != null) conn.close(); } catch(Exception e) {}
        }
    }
}
