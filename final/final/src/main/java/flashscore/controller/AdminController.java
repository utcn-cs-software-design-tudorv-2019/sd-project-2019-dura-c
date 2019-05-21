package flashscore.controller;

import flashscore.Form.IdForm;
import flashscore.Form.LoginForm;
import flashscore.business.*;
import flashscore.persistence.Entity.Client;
import flashscore.persistence.Entity.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class AdminController {
    @Inject
    private  ClientService clientService;
    @Inject
    private GameService gameService;
    @Inject
    private BetService betService;
    @Inject
    private ClientListService clientListService;

    @RequestMapping(params="add match",method =RequestMethod.POST)
    public String CreateMatch(@ModelAttribute(name="Game") Game game, Model model){
        game.setScore("-");
        gameService.addGame(game);
        model.addAttribute("games", gameService.findAllGames());
        return "matchList";
    }

    @Transactional
    @RequestMapping(params="delete match",method =RequestMethod.POST)
    public String DeleteMatch(@ModelAttribute(name="IdForm") IdForm idForm, Model model){
        betService.deleteBetsByGame(gameService.findGame(Integer.parseInt(idForm.getId())));
        clientListService.deleteAllByGame(gameService.findGame(Integer.parseInt(idForm.getId())));
        gameService.deleteGame(Integer.parseInt(idForm.getId()));
        model.addAttribute("games", gameService.findAllGames());
        return "matchList";
    }

    @Transactional
    @RequestMapping(params="update match",method =RequestMethod.POST)
    public String UpdateMatch(@ModelAttribute(name="IdForm") IdForm idForm,@ModelAttribute(name="Game") Game game, Model model){
        Game insert=gameService.findGame(Integer.parseInt(idForm.getId()));
        gameService.deleteGame(Integer.parseInt(idForm.getId()));
        game.setIdamatch(Integer.parseInt(idForm.getId()));
        if(game.getSecondTeam().equals("")){
            game.setSecondTeam(insert.getSecondTeam());
        }
        if(game.getFirstTeam().equals("")){
            game.setFirstTeam((insert.getFirstTeam()));
        }
        if(game.getCategory().equals("")){
            game.setCategory(insert.getCategory());
        }
        gameService.addGame(game);
        model.addAttribute("games", gameService.findAllGames());
        return "matchList";
    }

    @RequestMapping(value = "/matchList",method=RequestMethod.GET)
    public String getGames(Model model)
    {
        model.addAttribute("games", gameService.findAllGames());
        return "matchList";

    }

    @RequestMapping(value = "/clientList",method=RequestMethod.GET)
    public String getClients(Model model)
    {
        model.addAttribute("clients", clientService.findAll());
        return "clientList";

    }

    @RequestMapping(value = "/betsList",method=RequestMethod.GET)
    public String getBets(Model model)
    {
        model.addAttribute("bets",betService.findAll());
        return "betsList";

    }

}
