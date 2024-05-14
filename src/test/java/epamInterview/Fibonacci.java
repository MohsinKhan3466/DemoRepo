package epamInterview;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number upto you want fibonacci series");
        int userInput = sc.nextInt();

        if (userInput <= 0) {
            System.out.println("Please enter a valid input");
        }
        int num1 = 0;
        int num2 = 1;

        for (int i = 0; i <= userInput; i++) {

            System.out.println(num1 + "");

            int num3 = num1 + num2;

            num1 = num2;
            num2 = num3;

         if (isPrime(num1)){
             System.out.println(num1+":Is a prime number");
         }
         else {
             System.out.println(num1+":Is not a prime number");
         }

            }
        }

        public static boolean isPrime(int number){
        if (number<=1){
            return false;
        }
        else {
            for (int i=2;i<=Math.sqrt(number);i++){
                if (number%i==0){
                    return false;
                }
            }
        }
        return true;
        }
    }