package flashscore.persistence.Repository;

import flashscore.persistence.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {
    public Game save(Game match);
    public List<Game> findAll();
    public void deleteGameByIdgame(int id);
    public Game findGameByIdgame(int id);
}
