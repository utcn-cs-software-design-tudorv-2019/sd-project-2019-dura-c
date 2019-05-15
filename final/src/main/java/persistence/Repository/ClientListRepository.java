package persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.Entity.ClientList;

public interface ClientListRepository extends JpaRepository<ClientList,Integer> {
}
