package za.ac.cput.util;

import java.util.UUID;
public class Helper {
    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String s) {
        return(s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static boolean isNullOrNegitive(int i) {
        return(i == 0 || i<0);
    }
}
