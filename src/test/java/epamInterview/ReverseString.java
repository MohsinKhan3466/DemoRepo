package epamInterview;

public class ReverseString {

    public static void main(String[] args) {
        String givenString="Mohsin";

        StringBuilder sb=new StringBuilder(givenString);

        String resultString= sb.reverse().toString().toUpperCase();

        System.out.println(resultString);
    }
}
