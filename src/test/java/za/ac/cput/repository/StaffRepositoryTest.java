/*
package za.ac.cput.repository;

*/
/* StaffRepositoryTest.java
 Test for StaffRepository
 Author: Velenkosini Prince Jeza (218191669)
 Date: 07 April 2022
*//*


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class StaffRepositoryTest {

    private static StaffRepository repository = StaffRepository.getRepository();
    private static Staff staff = StaffFactory.createStaff("65451645","Nomzamo", "Gwala", "Permanent");

    @Test
    void a_create() {
        Staff created = repository.create(staff);
        assertEquals(staff.getEmployeeId(), created.getEmployeeId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Staff read = repository.read(staff.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {

        Staff updated = new Staff.Builder().copy(staff).setFirstName("Nokuthula")
                .setLastName("Ngcobo")
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

        boolean success = repository.delete(staff.getEmployeeId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }


}*/
