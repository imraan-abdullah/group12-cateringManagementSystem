package za.ac.cput.repository;

/*
 * ChefRepositoryTest.java - test class for ChefRepository
 * Author: Imraan Abdullah
 * 219361738
 * Date: 1 April 2022
 * */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Chef;
import za.ac.cput.factory.ChefFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ChefRepositoryTest
{
    private static ChefRepository repository = ChefRepository.getRepository();
    private static Chef chef = ChefFactory.createChef("John", "Adams");

    @Test
    void a_create()
    {
        Chef created = repository.create(chef);
        assertEquals(chef.getEmployeeId(), created.getEmployeeId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read()
    {
        Chef read = repository.read(chef.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update()
    {
        Chef updated = new Chef.Builder().copy(chef).setFirstName("Ashley")
                .setLastName("oliver")
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
        boolean success = repository.delete(chef.getEmployeeId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

}