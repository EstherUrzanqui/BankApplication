public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("John", "12345");
        bankAccount.deposit(100);
        bankAccount.withdraw(50);
        bankAccount.getPreviousTransaction();
        bankAccount.menu();
    }
}