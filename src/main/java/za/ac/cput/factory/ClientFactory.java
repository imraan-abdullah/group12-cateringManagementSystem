package za.ac.cput.factory;

import za.ac.cput.entity.Client;
import za.ac.cput.util.Helper;
import za.ac.cput.util.Helper;

/*ClientFactory.java Factory for the ClientFactory
Author: Mariam Gallie (219094837)
Date: 28 March 2022
*/

public class ClientFactory {

    public static Client createClient(String firstName,String lastName, String email,String phoneNum) {
        String clientId = Helper.generateId();
        Client client = new Client.Builder().setClientNum(clientId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNum(phoneNum)
                .build();
        return client;
    }
}
