import java.util.ArrayList;


import java.io.*;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Customer> readCustomersFromFile() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String customerId = parts[0];
                String name = parts[1];
                String address = parts[2];
                int unitsConsumed = Integer.parseInt(parts[3]);

                if (parts[4].equals("Residential")) {
                    customers.add(new ResidentialCustomer(customerId, name, address, unitsConsumed));
                } else if (parts[4].equals("Commercial")) {
                    customers.add(new CommercialCustomer(customerId, name, address, unitsConsumed));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return customers;
    }

    public void writeBillToFile(Customer customer, double billAmount) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(customer.getCustomerId() + "," + customer.getName() + "," + customer.getAddress()
                    + "," + billAmount);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
