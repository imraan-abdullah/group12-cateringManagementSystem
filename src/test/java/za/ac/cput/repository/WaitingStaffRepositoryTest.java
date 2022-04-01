package za.ac.cput.repository;

/*
 * WaitingStaffRepositoryTest.java - test class for WaitingStaffRepository
 * Author: Imraan Abdullah
 * 219361738
 * Date: 1 April 2022
 * */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.WaitingStaff;
import za.ac.cput.factory.WaitingStaffFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class WaitingStaffRepositoryTest {

    private static WaitingStaffRepository repository = WaitingStaffRepository.getRepository();
    private static WaitingStaff waitingStaff = WaitingStaffFactory.createWaitingStaff("Edrico", "Tomson");

    @Test
    void a_create()
    {
        WaitingStaff created = repository.create(waitingStaff);
        assertEquals(waitingStaff.getEmployeeId(), created.getEmployeeId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read()
    {
        WaitingStaff read = repository.read(waitingStaff.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update()
    {
        WaitingStaff updated = new WaitingStaff.Builder().copy(waitingStaff).setFirstName("Delron")
                .setLastName("Fillies")
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
        boolean success = repository.delete(waitingStaff.getEmployeeId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}