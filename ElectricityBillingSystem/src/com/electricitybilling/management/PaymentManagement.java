package com.electricitybilling.management;

import com.electricitybilling.database.DatabaseConnection;
import com.electricitybilling.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class PaymentManagement {
    public void processPayment(int billId, double amount) {
        String sql = "INSERT INTO Payments (bill_id, payment_amount, payment_date, payment_status) VALUES (?, ?, CURDATE(), 'Completed')";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, billId);
            preparedStatement.setDouble(2, amount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getPaymentsForBill(int billId) {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payments WHERE bill_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, billId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment(resultSet.getInt("payment_id"),
                        resultSet.getInt("bill_id"),
                        resultSet.getDouble("payment_amount"),
                        resultSet.getDate("payment_date"),
                        resultSet.getString("payment_status"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}