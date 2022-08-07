/*
package za.ac.cput.repository;

*/
/*
 * EntertainmentRepositoryTest.java - test class for EntertainmentRepository
 * Author: Imraan Abdullah
 * 219361738
 * Date: 1 April 2022
 * *//*


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Entertainment;
import za.ac.cput.factory.EntertainmentFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EntertainmentRepositoryTest {

    private static EntertainmentRepository repository = EntertainmentRepository.getRepository();
    private static Entertainment entertainment = EntertainmentFactory.createEntertainment("Live Band", 8000);

    @Test
    void a_create()
    {
        Entertainment created = repository.create(entertainment);
        assertEquals(entertainment.getEntertainmentType(), created.getEntertainmentType());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read()
    {
        Entertainment read = repository.read(entertainment.getEntertainmentType());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update()
    {
        Entertainment updated = new Entertainment.Builder().copy(entertainment).setCost(6500)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("updated: " + updated);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(entertainment.getEntertainmentType());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}*/
