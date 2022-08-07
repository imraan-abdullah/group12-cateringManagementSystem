package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Booking;

import java.util.Set;
//Mariam Gallie - 219094837
//updated: 6 August 2022
@Repository
public interface IBookingRepository extends JpaRepository<Booking,String> {

}
