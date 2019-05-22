package flashscore.controller;

import flashscore.Form.BetForm;
import flashscore.Form.IdForm;
import flashscore.business.BetService;
import flashscore.business.ClientListService;
import flashscore.business.ClientService;
import flashscore.business.GameService;
import flashscore.persistence.Entity.Bet;
import flashscore.persistence.Entity.Client;
import flashscore.persistence.Entity.ClientList;
import flashscore.persistence.Entity.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ClientController {
    @Inject
    ClientService clientService;
    @Inject
    GameService gameService;
    @Inject
    ClientListService clientListService;
    @Inject
    BetService betService;
    @RequestMapping(value="/clientMatchList",method= RequestMethod.GET)
    public String viewAllAvailableMatches(Model model){
        model.addAttribute("games",gameService.findAllGames());
        return "clientMatchList";
    }

    @RequestMapping(value="/clientFavouriteList",method= RequestMethod.GET)
    public String viewFavouriteMatches(Model model){
        model.addAttribute("favouriteGames",clientListService.findClientFavouriteGames(clientService.getLoggedClient()));
        return "clientFavouriteList";
    }

    @RequestMapping(value="/clientBetList",method= RequestMethod.GET)
    public String viewBetGames(Model model){
        model.addAttribute("gamesBet",betService.findAllClientBets(clientService.getLoggedClient()));
        return "clientBetList";
    }

    @RequestMapping(value="/updateAccount",method=RequestMethod.GET)
    public String updateAccountForm(Model model){
        model.addAttribute("client",clientService.getLoggedClient());
        return "updateAccount";
    }
    @RequestMapping(params="add match to list",method=RequestMethod.POST)
    public String addToFavouriteList(@ModelAttribute (name="IdForm") IdForm idForm, Model model){
        if(clientListService.findClientGameByGame(gameService.findGame(Integer.parseInt(idForm.getId())))==null) {
            ClientList insert = new ClientList(clientService.getLoggedClient(),
                    gameService.findGame(Integer.parseInt(idForm.getId())));
            clientListService.addGame(insert);
            model.addAttribute("games", gameService.findAllGames());
        }
            return "client";

    }

    @Transactional
    @RequestMapping(params="delete match from list",method=RequestMethod.POST)
    public String deleteFromFavouriteList(@ModelAttribute (name="IdForm") IdForm idForm, Model model){
        Game deleted=gameService.findGame(Integer.parseInt(idForm.getId()));
        clientListService.deleteGame(deleted);
        System.out.println(clientListService.findClientFavouriteGames(clientService.getLoggedClient()));
        model.addAttribute("favouriteGames",clientListService.findClientFavouriteGames(clientService.getLoggedClient()));
        return "client";
    }

    @Transactional
    @RequestMapping(params="update account",method =RequestMethod.POST)
    public String UpdateClient(@ModelAttribute (name="Client") Client client, Model model){
        if(client.getPassword().equals("")){
            client.setPassword(clientService.getLoggedClient().getPassword());
        }
        if(client.getAge().equals("")){
            client.setAge(clientService.getLoggedClient().getAge());
        }
        if(client.getEmail().equals("")){
            client.setEmail(clientService.getLoggedClient().getEmail());
        }
        if(client.getUsername().equals("")){
            client.setUsername(clientService.getLoggedClient().getUsername());
        }
        if(client.getSold().equals(""))
            client.setSold(clientService.getLoggedClient().getSold());
        else {
            int sold = Integer.parseInt(clientService.getLoggedClient().getSold()) + Integer.parseInt(client.getSold());
            client.setSold("" + sold);
        }
        List<ClientList> clients=clientListService.findClientListByClient(clientService.getLoggedClient());
        List<Bet> bets=betService.findAllClientBets(clientService.getLoggedClient());
        clientListService.deleteAll(clientService.getLoggedClient());
        betService.deleteAllClientBets(clientService.getLoggedClient());
        clientService.deleteClient();
        clientService.setLoggedClient(client);
        clientService.addClient(client);
        clientListService.addAll(clients,client);
        betService.addAllBets(bets,client);
        model.addAttribute("client",client);
        return "client";
    }

    @RequestMapping(params="bet",method=RequestMethod.POST)
    public String betOnAGame(@ModelAttribute(name="BetForm")BetForm betForm,Model model){
        System.out.println(betForm.toString());
        Bet add=new Bet(clientService.getLoggedClient(),gameService.findGame(Integer.parseInt(betForm.getId())),
                Integer.parseInt(betForm.getValue()),betForm.getWinner());
        betService.addBet(add);
        model.addAttribute("gamesBet",betService.findAllClientBets(clientService.getLoggedClient()));
        return "client";
    }

}
