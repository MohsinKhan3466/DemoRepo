package epamInterview;

public class CheckStrings {

    public static void main(String[] args) {

        String str1="hello";
        String str2="HELLO";

        boolean isEqual= str1.equalsIgnoreCase(str2);

        System.out.println("Is both the strings are equal: "+isEqual);
    }
}
