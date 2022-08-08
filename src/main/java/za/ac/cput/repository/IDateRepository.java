package za.ac.cput.repository;

/*
 * IDateRepository.java repository interface
 * Author: Shasta Abrahams 217059376
 * Date: 1 April 2022
 */

import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Date;
import java.util.Set;

@Repository
public interface IDateRepository extends IRepository<Date, String> {

}
