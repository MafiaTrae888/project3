public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account(1000);
        Account account2 = new Account(500);

        System.out.println("Number of accounts created: " + Account.getNumberOfAccounts());

        System.out.println(account1);
        System.out.println(account2);

        account1.deposit(500);
        account2.withDraw(100);
    }
}

