package persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.Entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

}
