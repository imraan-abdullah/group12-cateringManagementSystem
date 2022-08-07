package za.ac.cput.repository;

/*
 * IDateRepository.java repository interface
 * Author: Shasta Abrahams 217059376
 * Date: 1 April 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Date;
import java.util.Set;

public interface IDateRepository extends JpaRepository<Date, String> {
    public Set<Date> getAll();
}
