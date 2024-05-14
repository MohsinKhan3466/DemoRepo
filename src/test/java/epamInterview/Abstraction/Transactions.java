package epamInterview.Abstraction;

import java.util.Scanner;

public class Transactions implements AccountDetails {
     int option1 =1;
        double amount;
        double balance;
        @Override
        public void bankDetails () throws Exception {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Account Number: ");
            String accountNumber = sc.next();
            Scanner sc1=new Scanner(System.in);
            int userInput1= sc.nextInt();

            if (userInput1==option1){
                Transactions depo= new Transactions();
                depo.deposit();
            }
            else {
                Transactions withd= new Transactions();
                withd.withraw();
            }
        }


        @Override
        public void deposit () {

            balance+=amount;
            System.out.println("Balance after Deposit:"+balance);
        }

        @Override
        public void withraw () throws Exception {

            if (balance<0||balance==0){
                throw new Exception("Transaction Declined:Balance is not sufficient");
            }
            else
            {
                balance-=amount;
                System.out.println("Balance after Withdrawal"+balance);
            }

        }

    public static void main(String[] args) throws Exception {


        Transactions obj1= new Transactions();
        obj1.bankDetails();

        System.out.println("Please following options:");
        System.out.println("Press 1 for Deposit  OR Press 2 for withdrawal ");

        Transactions obj= new Transactions();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter an amount to be Transact");
        obj.amount=scanner.nextInt();
    }
    }
