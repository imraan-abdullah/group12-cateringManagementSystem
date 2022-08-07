package za.ac.cput.repository;

/*
 * DateRepositoryTest.java test class for DateRepository
 * Author: Shasta Abrahams 217059376
 * Date: 1 April 2022
 */

//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Date;
//import za.ac.cput.factory.DateFactory;

//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.MethodName.class)

//class DateRepositoryTest {
//    private static DateRepository repository = DateRepository.getRepository();
//    private static Date date = DateFactory.createDate("Available", "45459", "90903");

//    @Test
//    void a_create() {
//        Date created = repository.create(date);
//        assertEquals(date.getDateNum(), created.getDateNum());
//        System.out.println("Created: "+ created);
//    }

//    @Test
//    void b_read() {
//        Date read = repository.read(date.getDateNum());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }

//    @Test
//    void c_update() {
//        Date updated = new Date.Builder().copy(date).setVenueAvailability("Unavailable")
//                .setVenueId("76432")
//                .setBookingNum("90972")
//                .build();
//        assertNotNull(repository.update(updated));
//        System.out.println("Updated: " + updated);
//    }

//    @Test
//    void e_delete() {
//        boolean success = repository.delete(date.getDateNum());
//        assertTrue(success);
//        System.out.println("Deleted:" + success);
//    }

//    @Test
//    void d_getAll() {
//        System.out.println("Show all: ");
//        System.out.println(repository.getAll());
//    }
//}
