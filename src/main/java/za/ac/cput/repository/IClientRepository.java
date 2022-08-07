package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Client;

import java.util.Set;
@Repository
public interface IClientRepository extends JpaRepository<Client , String> {

}
