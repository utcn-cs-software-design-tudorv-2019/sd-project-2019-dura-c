package flashscore.controller;

import flashscore.Form.LoginForm;
import flashscore.business.AdminService;
import flashscore.business.ClientService;
import flashscore.business.GameService;
import flashscore.persistence.Entity.Client;
import flashscore.persistence.Entity.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class LoginController {
    @Inject
    private  ClientService clientService;
    @Inject
    private AdminService adminService;

    @RequestMapping(value="",method = RequestMethod.GET)
    public String getIndexForm(){
        return "index";
    }
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String getLoginForm(){
        return "login";
    }

    @RequestMapping(value="/reg",method = RequestMethod.GET)
    public String getRegistationForm(){
        return "reg";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String Login(@ModelAttribute(name="LoginForm") LoginForm loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if (clientService.findByUsername(username) != null)
            if(clientService.findByUsername(username).getPassword().equals(password)) {
                clientService.setLoggedClient(clientService.findByUsername(username));
                return "client";
            }
        if (adminService.findByUsername(username) != null)
            if(adminService.findByUsername(username).getPassword().equals(password)) {
                return "admin";
            }
        return "login";
    }

    @RequestMapping(value="/reg",method =RequestMethod.POST)
    public String CreateAccount(@ModelAttribute(name="Client") Client client,Model model){
        if(clientService.findByUsername(client.getUsername())==null)
        clientService.addClient(client);
        else{
            model.addAttribute("username already exists",client.getUsername());
            return "reg";
        }
        return "login";
    }


}
