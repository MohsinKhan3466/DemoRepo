package epamInterview;

public class Bank {

    double balance;

    public void deposit(double amount){
        balance +=amount;
        System.out.println("After deposit the your Balance is:"+balance);
    }
    public void withdraw(double amount) throws  Exception {
        if (balance-amount < 0 || balance-amount==0){
            throw new Exception("InsufficientBalanceException");
        }
        else {
            balance-=amount;
            System.out.println("After Withraw your Balance is:"+balance);
        }
    }

    public static void main(String[] args) throws Exception {
        Bank obj1= new Bank();
        obj1.deposit(10.00);
        obj1.withdraw(1000);
        obj1.withdraw(10);
    }
}
