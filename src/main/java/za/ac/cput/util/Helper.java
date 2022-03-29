package src.main.java.za.ac.cput.util;

/*Helper.java Util for the Helper
Author: Mariam Gallie (219094837)
Date: 28 March 2022
*/
import java.util.UUID;

public class Helper {
    public static String generateId(){ return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String s){
        return s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null");
    }

    public static boolean isEmptyOrNegitive(int i) {
        return i == 0 || i < 0;
    }


}
