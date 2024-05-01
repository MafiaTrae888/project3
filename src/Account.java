public class Account {
// intance
    private double balance;
    private  int accountNum;

    private static int numberOfAccounts = 1000;

    // constrctor
    public Account (double deposit){
        this.balance = deposit;
        this.accountNum = ++numberOfAccounts;

    }
    //method
//the deposit
    public void deposit(double amount) {
        balance+= amount;
        System.out.println("Amount Deposited  " + amount);
        System.out.println("Updated Balance  " + amount);

    }
// the withdraw
    public void withDraw(double amount) {
        if (amount > balance) {
            System.out.println("insufficient funds");
        }
        else {
            balance -= amount;
            System.out.println("AMOUNT WITHDRAWN:  "+amount );
            System.out.println("UPDATED BALANCE:  "+balance);
        }

    }
    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    public double getBalance() {
        return balance;
    }
    public int getAccountNum() {
        return accountNum;
    }

    @Override
    //getter

    public String toString(){
        return "Account Number: " + accountNum + ", Balance: " + balance;
    }
}
