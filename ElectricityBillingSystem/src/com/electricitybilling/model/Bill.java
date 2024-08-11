package com.electricitybilling.model;

import java.util.Date;

public class Bill {
    private int billId;
    private int customerId;
    private double billAmount;
    private Date billDate;
    private String paymentStatus;

    public Bill(int billId, int customerId, double billAmount, Date billDate, String paymentStatus) {
        this.billId = billId;
        this.customerId = customerId;
        this.billAmount = billAmount;
        this.billDate = billDate;
        this.paymentStatus = paymentStatus;
    }

    // Getters and toString method
    public int getBillId() {
        return billId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "Bill ID: " + billId + ", Amount: " + billAmount + ", Date: " + billDate + ", Status: " + paymentStatus;
    }
}