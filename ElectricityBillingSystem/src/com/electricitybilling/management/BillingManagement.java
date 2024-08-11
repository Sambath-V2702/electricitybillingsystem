package com.electricitybilling.management;

import com.electricitybilling.database.DatabaseConnection;
import com.electricitybilling.model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class BillingManagement {
    public void addServiceUsage(int customerId, double amount) {
        String sql = "INSERT INTO Bills (customer_id, bill_amount, bill_date, payment_status) VALUES (?, ?, CURDATE(), 'Pending')";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerId);
            preparedStatement.setDouble(2, amount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bill> getBillsByCustomerId(int customerId) {
        List<Bill> bills = new ArrayList<>();
        String sql = "SELECT * FROM Bills WHERE customer_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bill bill = new Bill(resultSet.getInt("bill_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getDouble("bill_amount"),
                        resultSet.getDate("bill_date"),
                        resultSet.getString("payment_status"));
                bills.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }

    public void updatePaymentStatus(int billId, String newStatus) {
        String sql = "UPDATE Bills SET payment_status = ? WHERE bill_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, billId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}