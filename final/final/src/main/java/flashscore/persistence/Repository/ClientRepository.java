package flashscore.persistence.Repository;

import flashscore.persistence.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    public List<Client> findAll();
    public  Client save(Client user);
    public Client findByUsername(String username);
    public void deleteByIdclient(int id);

}
