package epamInterview;

public class PalindromeString {

    public static void main(String[] args) {

        String str="Mohsin";
        StringBuilder sb= new StringBuilder(str);

        String rvsString= sb.reverse().toString();

        System.out.println(rvsString);

        if (rvsString.equals(str)){
            System.out.println("Its an Palindrome String");
        }
        else {
            System.out.println("Not a palindrome String");
        }
    }
}
