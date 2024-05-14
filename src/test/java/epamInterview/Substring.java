package epamInterview;

import java.util.Arrays;

public class Substring {


    public static void main(String[] args) {
        String str="AkhiyanGulab";
        String formattedStr=str.toLowerCase().trim();
        int strLength = str.length();
        int maxLength = 0;
        int start = 0;
        int maxStart = 0;

        for (int i = 0; i < strLength; i++) {
            char currentChar = formattedStr.charAt(i);

            for (int j = start; j < i; j++) {
                if (str.charAt(j) == currentChar) {

                    start = j + 1;
                    break;
                }
            }
            int currentLength = i - (start + 1);

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        System.out.println(formattedStr.substring(maxStart, maxStart + maxLength));
    }

}





