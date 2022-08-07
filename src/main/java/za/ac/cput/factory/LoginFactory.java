/*
LoginFactory.java
Factory class for Login
Author: Ameer Samsodien (220005060)
Date : 29 March 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.Login;
import za.ac.cput.util.Helper;

public class LoginFactory {

    public static Login createLogin(String adminNum, String adminPassword) {

        String loginId = Helper.generateId();

        Login login = new Login.Builder().setLoginId(loginId)
                .setAdminNum(adminNum)
                .setAdminPassword(adminPassword)
                .build();
        return login;

    }

}

