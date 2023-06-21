import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ElectricityBillingSystem {
    public static void main(String[] args) {
        log('\n'+"-------------Welcome to Electricity Billing System-------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of customers: ");
        int numCustomers = scanner.nextInt();

        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < numCustomers; i++) {
            System.out.println("\nCustomer " + (i + 1) + " Details:");
            System.out.print("Customer ID: ");
            String customerId = scanner.next();
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Address: ");
            String address = scanner.next();
            System.out.print("Units Consumed: ");
            int unitsConsumed = scanner.nextInt();
            System.out.print("Customer Type (Residential/Commercial): ");
            String customerType = scanner.next();

            if (customerType.equalsIgnoreCase("Residential")) {
                customers.add(new ResidentialCustomer(customerId, name, address, unitsConsumed));
            } else if (customerType.equalsIgnoreCase("Commercial")) {
                customers.add(new CommercialCustomer(customerId, name, address, unitsConsumed));
            }
        }

        scanner.close();

        FileHandler fileHandler = new FileHandler("customers.txt");

        for (Customer customer : customers) {
            double billAmount = customer.calculateBill();
            fileHandler.writeBillToFile(customer, billAmount);
            System.out.println("\nBill generated for customer: " + customer.getCustomerId());
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Customer Address: " + customer.getAddress());
            System.out.println("Bill Amount: $" + billAmount);
        }

        log("Thank You for Paying the Bill" +'\n'+
                "-----------------------Project By Abu Tahim Habiby");
    }

    private static void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);
        System.out.println("[" + timestamp + "] " + message);
    }
}
