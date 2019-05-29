package flashscore.Model.Repository;

import flashscore.Model.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {
    public Game save(Game match);
    public List<Game> findAll();
    public void deleteGameByIdgame(int id);
    public Game findGameByIdgame(int id);
    public void findByCategoryAndAndFirstTeamAndSecondTeam(String category,String firsTeam,String secondTeam);
}
