package module1;

// create the test program that will run through the code and display results
public class BankAccountTest {
 public static void main(String[] args) {
     // create a new bank account here that is a standard bank account
     BankAccount account1 = new BankAccount("Marcus", "Pheonix", 1001);
     account1.deposit(500);
     account1.withdrawal(200);
     account1.accountSummary();

     System.out.println("------------------------------");

     // create a new CheckingAccount here for testing purposes
     CheckingAccount checkingAccount = new CheckingAccount("Master", "Chief", 2002, 1.5);
     checkingAccount.deposit(300);
     checkingAccount.processWithdrawal(350); // Overdraft fee will trigger here
     checkingAccount.displayAccount();
 }
}

