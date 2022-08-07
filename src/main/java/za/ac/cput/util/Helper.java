package za.ac.cput.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

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

    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if (isEmptyOrNull(str)) return StringUtils.EMPTY;
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue){
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }

    public static String checkId(String id) {
        if(isEmptyOrNull(id))
            throw new IllegalArgumentException("invalid credentials provided");
        return id;
    }

    public static String checkEmailValidation(String email) {
        if(EmailValidator.getInstance().isValid(email) == false)
            throw new IllegalArgumentException("Invalid email address provided");
        return email;
    }

    public static int checkPostalCode(int postalCode) {
        int min = 1000;
        int max = 9999;
        if(postalCode < min || postalCode > max)
            throw new IllegalArgumentException("invalid postalCode provided");
        return postalCode;
    }
}
