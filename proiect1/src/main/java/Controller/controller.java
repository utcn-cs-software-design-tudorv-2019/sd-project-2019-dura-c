package Controller;

import Business.BetBusiness;
import Business.ClientBusiness;
import Business.MatchBusiness;
import Data.Entity.Bet;
import Data.Entity.Game;

import java.util.List;
import java.util.Random;

public class controller {

    MatchBusiness matchBusiness=new MatchBusiness();
    ClientBusiness clientBusiness=new ClientBusiness();
    BetBusiness betBusiness=new BetBusiness();

    public void setAllUnfinishedMatches(){
        matchBusiness.setAllGamesUnfinised();
        try {
            while (matchBusiness.getMatchByScore("-")!=null) {
                Game aux=matchBusiness.getMatchByScore("-");
                Thread.sleep(10000);
                String firsteam=aux.getFirstTeam();
                String secondTeam=aux.getSecondTeam();
                Random random=new Random();
                int x= random.nextInt(2)+1;
                if(x==1) aux.setScore(firsteam);
                else aux.setScore(secondTeam);
                matchBusiness.updateGame(aux);
                List<Bet> matchBets=betBusiness.getBets(aux);
                for(Bet aux1:matchBets){
                    if(aux1.getWinner().equals(aux.getScore()))
                        aux1.getIdc().setSold(""+(aux1.getValue()+Integer.parseInt(aux1.getIdc().getSold())));
                    else    aux1.getIdc().setSold(""+(aux1.getValue()-Integer.parseInt(aux1.getIdc().getSold())));
                    clientBusiness.updateClient(aux1.getIdc());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        controller controller1=new controller();
        controller1.setAllUnfinishedMatches();
    }
}
