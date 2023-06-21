 class ResidentialCustomer extends Customer{
     private int unitsConsumed;

     public ResidentialCustomer(String customerId, String name, String address, int unitsConsumed) {
         super(customerId, name, address);
         this.unitsConsumed = unitsConsumed;
     }

     public double calculateBill() {
         // Calculation logic for residential customer bill
         double billAmount = unitsConsumed * 2.5;
         return applyLateFine(billAmount);
     }

     private double applyLateFine(double billAmount) {
         // Apply late fine logic for residential customer
         double lateFine = 0.0;
         if (billAmount > 100.0) {
             lateFine = billAmount * 0.05; // Late fine is 5% of the bill amount
         }
         return billAmount + lateFine;
     }
}
