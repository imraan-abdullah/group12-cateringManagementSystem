package za.ac.cput.factory;

import za.ac.cput.entity.Login;


/*
LoginFactory.java
Factory class for Login
Author: Ameer Samsodien (220005060)
Date : 29 March 2022
*/

public class LoginFactory {

    public static Login createLogin(String loginId, String adminNum, String adminPassword){
        if (loginId.equals("") || loginId == null)
            return null;

        if (adminNum.equals("") || adminNum == null)
            return null;

        if (adminPassword.equals("") || adminPassword == null)
            return null;

        return new Login.Builder().setLoginId(loginId)
                .setAdminNum(adminNum)
                .setAdminPassword(adminPassword)
                .build();
    }

}
