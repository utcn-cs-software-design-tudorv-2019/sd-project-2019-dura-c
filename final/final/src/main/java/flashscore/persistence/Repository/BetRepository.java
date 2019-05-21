package flashscore.persistence.Repository;

import flashscore.persistence.Entity.Client;
import flashscore.persistence.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import flashscore.persistence.Entity.Bet;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet,Integer> {
    public Bet save(Bet bet);
    public List<Bet> findAllByIdc(Client client);
    public List<Bet> findAll();
    public void deleteAllByIdc(Client c);
    public void deleteAllByIdGame(Game game);
}
