package flashscore.Model.business;

import flashscore.Model.Entity.Game;
import flashscore.Model.Repository.GameRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GameService {
    @Inject
    GameRepository gameRepository;

    public Game addGame(Game match){
        return gameRepository.save(match);
    }

    public List<Game> findAllGames(){
        return gameRepository.findAll();
    }

    public void deleteGame(int id){
        gameRepository.deleteGameByIdgame(id);
    }
    public Game findGame(int id){
        return gameRepository.findGameByIdgame(id);
    }

    public void findGameByFeatures(String category,String firstTeam, String secondTeam){
         gameRepository.findByCategoryAndAndFirstTeamAndSecondTeam(category, firstTeam, secondTeam);
    }
}
