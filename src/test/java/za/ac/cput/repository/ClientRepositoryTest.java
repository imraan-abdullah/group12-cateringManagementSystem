package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;

/*ClientRepositoryTest.java Test for the ClientRepositoryTest
Author: Mariam Gallie (219094837)
Date: 5 April 2022
*/

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class ClientRepositoryTest {
private static ClientRepository repository = ClientRepository.getRepository();
private static Client client = ClientFactory.createClient("Sam","Hills","SamH@gmail.com","0826724333");
    @Test
    void a_create() {
        Client created = repository.create(client);
        assertEquals(client.getClientNum(),created.getClientNum());
        System.out.println("Created: " + created);

    }

    @Test
    void b_read() {
        Client read = repository.read(client.getClientNum());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Client updated = new Client.Builder().copy(client).setFirstName("Katty")
                .setLastName("Hope")
                .setEmail("Katty@gmail.com")
                .setPhoneNum("021 703 0505")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(client.getClientNum());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("show all: ");
        System.out.println(repository.getAll());
    }
}