package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Client;

import static org.junit.jupiter.api.Assertions.*;

/*ClientFactoryTest.java Test for the ClientFactoryTest
Author: Mariam Gallie (219094837)
Date: 5 April 2022
Updated: 6 August 2022
*/

class ClientFactoryTest {
//
//    void createClient(){
//        Client client = ClientFactory.createClient("Mariam","Smith","mariamSm@gmail.com","084 05666");
//        assertNotNull(client);
//        System.out.println(client);
//    }

    @Test
    public void buildWithSuccess() {
        Client client = ClientFactory.build("60","Mariam","Gallie","mm@gmail.com"
        ,"082674553");
        System.out.println(client);
        assertNotNull(client);
    }
    @Test
    public void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ClientFactory.build("", "","","",""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("clientNum"));
    }

}