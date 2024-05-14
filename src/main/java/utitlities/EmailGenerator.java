package utitlities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailGenerator {
   public static String emailGenerator() {


        // Get the current timestamp
        LocalDateTime timestamp = LocalDateTime.now();

        // Format the timestamp as per your requirement
        String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("HHmmss"));

        // Generate the email using the timestamp
        String email = "tester" + formattedTimestamp + "@gmail.com";
        //System.out.println(email);
        return email;
    }

}
