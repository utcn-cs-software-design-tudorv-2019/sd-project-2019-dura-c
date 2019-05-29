package flashscore.Model.Repository;

import flashscore.Model.Entity.Client;
import flashscore.Model.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import flashscore.Model.Entity.Bet;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet,Integer> {
    public Bet save(Bet bet);
    public List<Bet> findAllByIdc(Client client);
    public List<Bet> findAll();
    public void deleteAllByIdc(Client c);
    public void deleteAllByIdGame(Game game);
}
