package flashscore.persistence.Repository;

import flashscore.persistence.Entity.Client;
import flashscore.persistence.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import flashscore.persistence.Entity.ClientList;

import java.util.List;

public interface ClientListRepository extends JpaRepository<ClientList,Integer> {
    public ClientList save(ClientList clientList);
    public void deleteByGame(Game game);
    public List<ClientList> findAllByClient(Client client);
    public void deleteAllByClient(Client client);
    public void deleteAllByGame(Game game);
    public ClientList findByGame(Game game);
}
