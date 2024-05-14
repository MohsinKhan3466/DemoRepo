package epamInterview;

import java.util.Scanner;

public class LotterySystem {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any Random Number");
        int userInput= sc.nextInt();

        int randomNumber= (int) Math.random();
        System.out.println(randomNumber);
    }
}
