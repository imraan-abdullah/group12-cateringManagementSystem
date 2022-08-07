/*
AdminRepositoryTest.java
Test class for Admin Repository
Author: Ameer Samsodien (220005060)
Date : 8 April 2022
*//*


package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Admin;
import za.ac.cput.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminRepositoryTest {

    private static AdminRepository repository = AdminRepository.getRepository();
    private static Admin admin = AdminFactory.createAdmin("2022", "Lewis", "Hamilton", "345876@mycput.ac.za", "098 7633 447");

    @Test
    void a_createAdmin() {
        Admin created = repository.create(admin);
        assertEquals(admin.getAdminNum(),created.getAdminNum());
        System.out.println("Created: " + created);
    }

    @Test
    void b_readAdmin() {
        Admin read = repository.read(admin.getAdminNum());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Admin updated = new Admin.Builder().copy(admin)
                .setAdminNum("2023")
                .setFirstName("Charles")
                .setLastName("LeClerc")
                .setEmail("123456@mycput.ac.za")
                .setPhoneNum("087 646 2296")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(admin.getAdminNum());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}*/
