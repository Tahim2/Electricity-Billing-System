public abstract class Customer implements Billable{
    protected String customerId;
    protected String name;
    protected String address;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public abstract double calculateBill();

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


}
