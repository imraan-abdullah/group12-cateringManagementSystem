/*
LoginRepositoryTest.java
Test class for Login Repository
Author: Ameer Samsodien (220005060)
Date : 8 April 2022
*//*


package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LoginRepositoryTest {

    private static LoginRepository repository = LoginRepository.getRepository();
    private static Login login = LoginFactory.createLogin("Lewis","mercedes");

    @Test
    void a_createLogin() {
        Login created = repository.create(login);
        assertEquals(login.getLoginId(), created.getLoginId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_readLogin(){
        Login read = repository.read(login.getLoginId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Login updated = new Login.Builder().copy(login)
                .setAdminNum("2022")
                .setAdminPassword("Ferrari")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(login.getLoginId());
        assertTrue(success);
        System.out.println("Deleted: " + success);

    }

    @Test
    void d_getAll() {
        System.out.println("Show all: " );
        System.out.println(repository.getAll());
    }

}*/
