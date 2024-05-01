import java.util.Scanner;

public class Menu {
    private  Scanner myScan = new Scanner(System.in);
    private final Bank bank;

    // Constructor
    public Menu() {
        this.bank = new Bank();
    }

    // Method to display the main menu
    public void displayMainMenu() {
        int selection = 0;
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Access an account");
            System.out.println("2. Open a new account");
            System.out.println("3. Create a new customer");
            System.out.println("4. Close all accounts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            selection = myScan.nextInt();
            myScan.nextLine();

            if (selection == 1) {
                accessAccount();
            } else if (selection == 2) {
                openNewAccount();
            } else if (selection == 3) {
                createNewCustomer();
            } else if (selection == 4) {
                closeAllAccounts();
            } else if (selection == 5) {
                System.out.println("Exiting program... bye bye :)");
                break;
            } else {
                System.out.println("Invalid entry.  Enter a number between 1 and 5.");
            }
        }
    }

    // Method to access an account
    private void accessAccount() {
        System.out.print("Enter your PIN: ");
        int pin = Integer.parseInt(myScan.nextLine());


        Customer customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("PIN is not valid");
            return;
        }

        System.out.println("Customer's Accounts:");
        System.out.println(customer.getAllAccountsInfo());

        System.out.print("Enter the account number: ");
        int accountNumber = Integer.parseInt(myScan.nextLine());

        Account account = customer.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account number invalid");
            return;
        }

        // Call AccountMenu
        accountMenu(account);
    }

    // Method  new account
    private void openNewAccount() {
        System.out.print("Are you a new customer? (yes/no): ");
        String response = myScan.nextLine().toLowerCase();

        if (response.equals("yes")) {
            Customer newCustomer = createNewCustomer();
            if (newCustomer != null) {
                System.out.print("Enter deposit amount for new account: ");
                double initialDeposit = myScan.nextDouble();
                myScan.nextLine();

                Account newAccount = new Account(initialDeposit);
                newCustomer.addAccount(newAccount);
                System.out.println("New Account Opened: " + newAccount.getAccountNum());
            }
        } else if (response.equals("no")) {
            System.out.print("Enter your PIN: ");
            int pin = Integer.parseInt(myScan.nextLine());

            Customer existingCustomer = bank.getCustomer(pin);
            if (existingCustomer == null) {
                System.out.println("PIN is not valid");
                return;
            }

            System.out.print("Enter deposit amount for new account: ");
            double initialDeposit = myScan.nextDouble();
            myScan.nextLine();

            Account newAccount = new Account(initialDeposit);
            existingCustomer.addAccount(newAccount);
            System.out.println("New Account Opened: " + newAccount.getAccountNum());
        } else {
            System.out.println("Invalid entry. Please enter 'yes' or 'no'.");
        }
    }

    // Method to create a new customer
    private Customer createNewCustomer() {
        System.out.print("Enter first name: ");
        String firstName = myScan.nextLine();

        System.out.print("Enter last name: ");
        String lastName = myScan.nextLine();

        System.out.print("Enter PIN: ");
        int pin = Integer.parseInt(myScan.nextLine());

        Customer newCustomer = new Customer(firstName, lastName, pin);
        bank.addCustomer(newCustomer);
        System.out.println("New customer created.");
        return newCustomer;
    }

    // Method to close all accounts
    private void closeAllAccounts() {
        System.out.print("Enter your PIN: ");
        int pin = Integer.parseInt(myScan.nextLine());

        Customer customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("PIN is not valid");
            return;
        }

        bank.removeCustomer(pin);
        System.out.println("Customer has been removed from bank registry.");
    }
    // Method to display the account menu
    private void accountMenu(Account account) {
        int selection = 0;
        while (selection != 4) {
            System.out.println("\nAccount Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Account Information");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            selection = Integer.parseInt(myScan.nextLine());
            if (selection == 1) {
                System.out.print("Enter deposit amount: ");
                double depositAmount = myScan.nextDouble();
                myScan.nextLine();
                account.deposit(depositAmount);
            } else if (selection == 2) {
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = myScan.nextDouble();
                myScan.nextLine();
                account.withDraw(withdrawalAmount);
            } else if (selection == 3) {
                System.out.println(account.toString());
            } else if (selection == 4) {
                System.out.println("Exiting account menu...");
            } else {
                System.out.println("Invalid entry. Please enter a number between 1 and 4.");
            }
        }
    }
}
