package flashscore.business;

import flashscore.persistence.Entity.Bet;
import flashscore.persistence.Entity.Client;
import flashscore.persistence.Entity.Game;
import flashscore.persistence.Repository.BetRepository;
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
