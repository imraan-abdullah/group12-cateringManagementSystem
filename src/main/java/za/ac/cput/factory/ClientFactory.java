package src.main.java.za.ac.cput.factory;

import src.main.java.za.ac.cput.entity.Client;
import src.main.java.za.ac.cput.util.Helper;

/*ClientFactory.java Factory for the ClientFactory
Author: Mariam Gallie (219094837)
Date: 28 March 2022
*/

public class ClientFactory {

    public static Client createClient(String clientNum ,String firstName,String lastName, String email,String phoneNum) {
        String clientId = Helper.generateId();
        Client client = new Client.Builder().setClientNum(clientId)
                .setClientNum(clientNum)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNum(phoneNum)
                .build();
        return client;
    }
}
