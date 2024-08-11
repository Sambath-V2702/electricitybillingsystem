package com.electricitybilling.model;

import java.util.Date;

public class Payment {
    private int paymentId;
    private int billId;
    private double paymentAmount;
    private Date paymentDate;
    private String paymentStatus;

    public Payment(int paymentId, int billId, double paymentAmount, Date paymentDate, String paymentStatus) {
        this.paymentId = paymentId;
        this.billId = billId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    // Getters and toString method
    public int getPaymentId() {
        return paymentId;
    }

    public int getBillId() {
        return billId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment ID: " + paymentId + ", Amount: " + paymentAmount + ", Status: " + paymentStatus;
    }
}