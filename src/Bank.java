public class Bank {
    private final Customer[] customers;
    private int numberOfCustomers;

    // Constructor
    public Bank() {
        this.customers = new Customer[1000];
        this.numberOfCustomers = 0;
    }

    // Method
    public void addCustomer(Customer customer) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers++] = customer;
        } else {
            System.out.println("Cannot add more customers. Maximum limit reached.");
        }
    }

    public void removeCustomer(int pin) {
        for (int i = 0; i < numberOfCustomers; i++) {
            if (customers[i].getPin() == pin) {
                // Shift customers to remove the selected customer
                for (int j = i; j < numberOfCustomers - 1; j++) {
                    customers[j] = customers[j + 1];
                }
                customers[numberOfCustomers - 1] = null;
                numberOfCustomers--;
                System.out.println("Customer with PIN " + pin + " removed successfully.");
                return;
            }
        }
        System.out.println("Customer with PIN " + pin + " not found.");
    }

    // Method  PIN
    public Customer getCustomer(int pin) {
        for (int i = 0; i < numberOfCustomers; i++) {
            if (customers[i].getPin() == pin) {
                return customers[i];
            }
        }
        return null;
    }

    // Method to get all customer info
    public String getAllCustomerInfo() {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < numberOfCustomers; i++) {
            info.append(customers[i].toString()).append("\n");
        }
        return info.toString();
    }
}

