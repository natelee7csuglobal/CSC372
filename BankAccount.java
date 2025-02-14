package module1;

// Create BankAccount.java and make private fields (string firstName, string lastName, int accountID, double balance)
public class BankAccount {
 private String firstName;
 private String lastName;
 private int accountID;
 private double balance;

 // Create a constructor(): method in order to initialize a zero balance
 public BankAccount(String firstName, String lastName, int accountID) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.accountID = accountID;
     this.balance = 0.0;
 }

 // Create a deposit(): method that will accept a single value double parameter; the parameter value is added to the existing balance
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
     } else {
         System.out.println("Deposit amount must be positive.");
     }
 }

 // We need a withdraw(): method here that accepts a single value double dollar amount; the parameter value is subtracted from the existing balance
 public void withdrawal(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
     } else {
         System.out.println("Insufficient funds or invalid amount.");
     }
 }

 // Create getters and setters for the firstName, lastName and accountID fields
 public String getFirstName() {
     return firstName;
 }

 public void setFirstName(String firstName) {
     this.firstName = firstName;
 }

 public String getLastName() {
     return lastName;
 }

 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 public int getAccountID() {
     return accountID;
 }

 public void setAccountID(int accountID) {
     this.accountID = accountID;
 }

 // create a getBalance(): method to return the users balance
 public double getBalance() {
     return balance;
 }

 // print out all of the account information.
 public void accountSummary() {
     System.out.println("Account Summary:");
     System.out.println("Name: " + firstName + " " + lastName);
     System.out.println("Account ID: " + accountID);
     System.out.println("Balance: $" + balance);
 }
}
