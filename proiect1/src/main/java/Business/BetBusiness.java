package Business;

import Data.DAO.BetDAO;
import Data.Entity.Bet;
import Data.Entity.Game;

import java.util.List;

public class BetBusiness {
    BetDAO betDAO=new BetDAO();

    public List<Bet> getBets(Game game){
        return betDAO.getAllBets(game);
    }
}
