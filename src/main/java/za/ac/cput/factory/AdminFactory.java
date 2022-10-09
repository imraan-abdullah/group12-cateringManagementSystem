/*
AdminFactory.java
Factory class for Admin
Author: Ameer Samsodien (220005060)
Date : 29 March 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.Admin;
import za.ac.cput.util.StringHelper;

public class AdminFactory {

    public static Admin createAdmin (String adminNum, String firstName, String lastName, String email, String phoneNum) {

        StringHelper.checkStringParam("adminNum", adminNum);
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.checkStringParam("lastName", lastName);
        StringHelper.checkStringParam("email", email);
        StringHelper.checkStringParam("phoneNum", phoneNum);

        StringHelper.isEmptyOrNull(firstName);
        StringHelper.isEmptyOrNull(lastName);
        StringHelper.isEmptyOrNull(email);
        StringHelper.isEmptyOrNull(phoneNum);
        StringHelper.checkId(adminNum);

        /*
        if (adminNum.equals("") || adminNum == null)
            return null;

        if (firstName.equals("") || firstName == null)
            return null;

        if (lastName.equals("") || lastName == null)
            return null;

        if (email.equals("") || email == null)
            return null;

        if (phoneNum.equals("") || phoneNum == null)
            return null;

         */

        return new Admin.Builder()
                .setAdminNum(adminNum)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNum(phoneNum)
                .build();
    }



}
