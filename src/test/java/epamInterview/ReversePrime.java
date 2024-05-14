package epamInterview;

import java.util.Arrays;

public class ReversePrime {

    public static boolean isPrime(int number){
        if (number<=1){
            return false;
        }
        for (int i=2;i<=Math.sqrt(number);i++){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int [] primeNumber= new int[100];
        Arrays.sort(primeNumber);
        for (int i=0;i<=primeNumber.length;i++){

            if (isPrime(primeNumber[i])){
                System.out.println(primeNumber[i]+":Is a PrimeNumber");
            }
            else {
                System.out.println(primeNumber[i]+":Is not a PrimeNumber");
            }
        }
    }
}
