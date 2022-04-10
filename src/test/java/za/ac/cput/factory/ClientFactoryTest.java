package za.ac.cput.factory;

import za.ac.cput.entity.Client;

import static org.junit.jupiter.api.Assertions.*;

/*ClientFactoryTest.java Test for the ClientFactoryTest
Author: Mariam Gallie (219094837)
Date: 5 April 2022
*/

class ClientFactoryTest {

    void createClient(){
        Client client = ClientFactory.createClient("Mariam","Smith","mariamSm@gmail.com","084 05666");
        assertNotNull(client);
        System.out.println(client);
    }

}