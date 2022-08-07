package za.ac.cput.factory;

import za.ac.cput.entity.Client;
import za.ac.cput.util.Helper;
import za.ac.cput.util.Helper;
import za.ac.cput.util.StringHelper;

/*ClientFactory.java Factory for the ClientFactory
Author: Mariam Gallie (219094837)
Date: 28 March 2022
Updated: 6 August 2022
*/

public class ClientFactory {
    //    public static Client createClient(String firstName,String lastName, String email,String phoneNum) {
//        String clientId = Helper.generateId();
//        Client client = new Client.Builder().setClientNum(clientId)
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setEmail(email)
//                .setPhoneNum(phoneNum)
//                .build();
//        return client;
//    }
    public static Client build(String clientNum,String firstName, String lastName, String email, String phoneNum) {
        StringHelper.checkStringParam("clientNum", clientNum);
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.checkStringParam("lastName", lastName);
        StringHelper.checkStringParam("email", email);
        StringHelper.checkStringParam("phoneNum", phoneNum);
        StringHelper.isEmptyOrNull(firstName);
        StringHelper.isEmptyOrNull(lastName);
        StringHelper.isEmptyOrNull(email);
        StringHelper.isEmptyOrNull(phoneNum);
        StringHelper.checkId(clientNum);

        return new Client.Builder()
                .setClientNum(clientNum)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNum(phoneNum)
                .build();
    }
}
