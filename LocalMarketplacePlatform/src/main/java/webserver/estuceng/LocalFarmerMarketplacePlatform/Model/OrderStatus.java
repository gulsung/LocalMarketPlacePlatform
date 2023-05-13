package webserver.estuceng.LocalFarmerMarketplacePlatform.Model;

import webserver.estuceng.LocalFarmerMarketplacePlatform.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderStatus {
    private int statusId;
    private int orderId;
    private String statusDescription;
    private Timestamp statusTimestamp;

    // Constructor
    public OrderStatus(int orderId, String statusDescription, Timestamp statusTimestamp) {
        this.orderId = orderId;
        this.statusDescription = statusDescription;
        this.statusTimestamp = statusTimestamp;
    }

    // Getters and setters
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Timestamp getStatusTimestamp() {
        return statusTimestamp;
    }

    public void setStatusTimestamp(Timestamp statusTimestamp) {
        this.statusTimestamp = statusTimestamp;
    }

    // Method for creating a new order status record
    public static void createOrderStatus(OrderStatus orderStatus, DatabaseConnection db) throws SQLException {
        String query = "INSERT INTO ORDER_STATUS (order_id, status_description, status_timestamp) VALUES (?, ?, ?)";
        PreparedStatement statement = db.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, orderStatus.getOrderId());
        statement.setString(2, orderStatus.getStatusDescription());
        statement.setTimestamp(3, orderStatus.getStatusTimestamp());
        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            orderStatus.setStatusId(rs.getInt(1));
        }
    }

    // Method for retrieving all order status records for an order
    public static List<OrderStatus> getOrderStatusesByOrder(int orderId, DatabaseConnection db) throws SQLException {
        List<OrderStatus> orderStatuses = new ArrayList<>();
        String query = "SELECT * FROM ORDER_STATUS WHERE order_id = ?";
        PreparedStatement statement = db.getConnection().prepareStatement(query);
        statement.setInt(1, orderId);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            OrderStatus orderStatus = new OrderStatus(orderId, rs.getString("status_description"), rs.getTimestamp("status_timestamp"));
            orderStatus.setStatusId(rs.getInt("status_id"));
            orderStatuses.add(orderStatus);
        }

        return orderStatuses;
    }
}
