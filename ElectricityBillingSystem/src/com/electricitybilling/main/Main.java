package com.electricitybilling.main;

import java.util.Scanner;

import com.electricitybilling.management.BillingManagement;
import com.electricitybilling.management.CustomerManagement;
import com.electricitybilling.management.PaymentManagement;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerManagement customerManagement = new CustomerManagement();
        BillingManagement billingManagement = new BillingManagement();
        PaymentManagement paymentManagement = new PaymentManagement();

        while (true) {
            System.out.println("Welcome to the Electricity Billing System");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Add Bill");
            System.out.println("4. Process Payment");
            System.out.println("5. Exit");

            System.out.print("Select an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    customerManagement.addCustomer(name, email, phone, address);
                    System.out.println("Customer added successfully.");
                    break;

                case 2:
                    System.out.println("Customer List:");
                    customerManagement.viewCustomers().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter Bill Amount: ");
                    double billAmount = scanner.nextDouble();
                    billingManagement.addServiceUsage(customerId, billAmount);
                    System.out.println("Bill added successfully.");
                    break;

                case 4:
                    System.out.print("Enter Bill ID: ");
                    int billId = scanner.nextInt();
                    System.out.print("Enter Payment Amount: ");
                    double paymentAmount = scanner.nextDouble();
                    paymentManagement.processPayment(billId, paymentAmount);
                    System.out.println("Payment processed successfully.");
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}