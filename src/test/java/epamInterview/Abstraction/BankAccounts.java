package epamInterview.Abstraction;

public abstract class BankAccounts {

    String accountNumber;
    double balance;

    public void bankDetails(String accountNumber,double balance){

        this.accountNumber=accountNumber;
        this.balance=balance;

    }
    public abstract void deposit(double amount);
    public abstract void withraw(double amount);
}
