public class Customer {
    private String firstName;
    private String lastName;
    private int pin;
    private Account[] accounts;
    private int numberOfAccounts;

    // Constructor
    public Customer(String firstName, String lastName, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.accounts = new Account[1000];
        this.numberOfAccounts = 0;
    }

    // Method to add an account
    public void addAccount(Account account) {
        if (numberOfAccounts < accounts.length) {
            accounts[numberOfAccounts++] = account;
        } else {
            System.out.println("Cannot add more accounts. Maximum limit reached.");
        }
    }

    // Method to remove an account
    public void removeAccount(int accountNum) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getAccountNum() == accountNum) {
                // Shift accounts to remove the selected account
                for (int j = i; j < numberOfAccounts - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                accounts[numberOfAccounts - 1] = null;
                numberOfAccounts--;
                System.out.println("Account " + accountNum + " removed successfully.");
                return;
            }
        }
        System.out.println("Account " + accountNum + " not found.");
    }

    // Method to get an account by account number
    public Account getAccount(int accountNum) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getAccountNum() == accountNum) {
                return accounts[i];
            }
        }
        return null;
    }

    // Method to get all accounts' info
    public String getAllAccountsInfo() {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < numberOfAccounts; i++) {
            info.append(accounts[i].toString()).append("\n");
        }
        return info.toString();
    }

    // toString method
    @Override
    public String toString() {
        return "Customer Name: " + firstName + " " + lastName + ", PIN: " + pin;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
