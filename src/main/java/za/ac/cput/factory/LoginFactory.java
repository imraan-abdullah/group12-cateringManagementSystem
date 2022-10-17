/*
LoginFactory.java
Factory class for Login
Author: Ameer Samsodien (220005060)
Date : 29 March 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.Login;
import za.ac.cput.util.Helper;
import za.ac.cput.util.StringHelper;

public class LoginFactory {

    public static Login createLogin(String loginId, String adminNum, String adminPassword) {

        //String loginId = Helper.generateId();

        /*
        Login login = new Login.Builder().setLoginId(loginId)
                .setAdminNum(adminNum)
                .setAdminPassword(adminPassword)
                .build();
        return login;

    }

         */

        StringHelper.checkStringParam("loginId", loginId);
        StringHelper.checkStringParam("adminNum", adminNum);
        StringHelper.checkStringParam("adminPassword", adminPassword);

        StringHelper.isEmptyOrNull(adminNum);
        StringHelper.isEmptyOrNull(adminPassword);
        StringHelper.checkId(loginId);

        return new Login.Builder()
                .setLoginId(loginId)
                .setAdminNum(adminNum)
                .setAdminPassword(adminPassword)
                .build();
    }

}
