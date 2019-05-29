package flashscore.Model.business;

import flashscore.Model.Entity.Bet;
import flashscore.Model.Entity.Client;
import flashscore.Model.Entity.Game;
import flashscore.Model.Repository.BetRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BetService {
    @Inject
    BetRepository betRepository;

    public Bet addBet(Bet bet){
        return betRepository.save(bet);
    }

    public List<Bet> findAllClientBets(Client client){
        return betRepository.findAllByIdc(client);
    }

    public List<Bet> findAll(){
        return betRepository.findAll();
    }

    public void deleteAllClientBets(Client client){
        betRepository.deleteAllByIdc(client);
    }
    public void addAllBets(List<Bet> bets,Client client){
        for(Bet aux:bets){
            Bet add=new Bet(client,aux.getIdGame(),aux.getValue(),aux.getWinner());
            betRepository.save(add);
        }
    }

    public void deleteBetsByGame(Game game){
        betRepository.deleteAllByIdGame(game);
    }

}
