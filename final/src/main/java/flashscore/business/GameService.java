package flashscore.business;

import flashscore.persistence.Entity.Game;
import flashscore.persistence.Repository.GameRepository;
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
}
