public class CommercialCustomer extends Customer{
    private int unitsConsumed;

    public CommercialCustomer(String customerId, String name, String address, int unitsConsumed) {
        super(customerId, name, address);
        this.unitsConsumed = unitsConsumed;
    }

    public double calculateBill() {
        // Calculation logic for commercial customer bill
        double billAmount = unitsConsumed * 5.0;
        return applyLateFine(billAmount);
    }

    private double applyLateFine(double billAmount) {
        // Apply late fine logic for commercial customer
        double lateFine = 0.0;
        if (billAmount > 500.0) {
            lateFine = billAmount * 0.1; // Late fine is 10% of the bill amount
        }
        return billAmount + lateFine;
    }
}
