package Business;

import Data.DAO.MatchDAO;
import Data.Entity.Game;

import java.util.List;

public class MatchBusiness {
    MatchDAO matchDAO=new MatchDAO();

    public Game getMatchByScore(String score){
       return matchDAO.getMatchByScore(score);
    }

    public void updateGame(Game game){
        matchDAO.updateGame(game);
    }

    public void setAllGamesUnfinised(){
        List<Game> games=matchDAO.getAllGames();
        for(Game aux:games){
            aux.setScore("-");
            matchDAO.updateGame(aux);
        }
    }
}
