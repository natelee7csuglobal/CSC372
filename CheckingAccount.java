package module1;

// create public class that extends to BankAccount.java called CheckingAccount.java and make its private field interestRate
public class CheckingAccount extends BankAccount {
 private double interestRate;

 // create a constructor(): method here for CheckingAccount for the interestRate
 public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
     super(firstName, lastName, accountID);
     this.interestRate = interestRate;
 }

 // create a processWithdrawal(): method that will display a negative balance that includes a $30 overdraft fee and denotes that a fee has been accessed
 public void processWithdrawal(double amount) {
     if (amount > 0) {
         if (amount > getBalance()) {
             double overdraftFee = 30.0;
             System.out.println("Overdraft! A $30 fee has been applied.");
             withdrawal(amount + overdraftFee);
         } else {
             withdrawal(amount);
         }
     } else {
         System.out.println("Withdrawal amount must be positive.");
     }
 }

 // create a displayAccount(): method in order to print out all superclass attributes and provides an additional interest rate
 public void displayAccount() {
     accountSummary();
     System.out.println("Interest Rate: " + interestRate + "%");
 }
}

