/*
package za.ac.cput.repository;

*/
/* ManagerRepositoryTest.java
 Test for ManagerRepository
 Author: Velenkosini Prince Jeza (218191669)
 Date: 08 April 2022
*//*


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Manager;
import za.ac.cput.factory.ManagerFactory;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class ManagerRepositoryTest {

    private static ManagerRepository repository = ManagerRepository.getRepository();
    private static Manager manager = ManagerFactory.createManager("98484584","Sbusiso", "Nkomo");


    @Test
    void a_create() {
        Manager created = repository.create(manager);
        assertEquals(manager.getEmployeeId(), created.getEmployeeId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Manager read = repository.read(manager.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Manager updated = new Manager.Builder().copy(manager).setFirstName("Sphamandla")
                .setLastName("Jili")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("updated: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(manager.getEmployeeId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}*/
