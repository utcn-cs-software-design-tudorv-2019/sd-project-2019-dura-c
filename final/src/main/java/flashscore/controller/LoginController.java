package flashscore.controller;

import flashscore.Model.business.AdminService;
import flashscore.Model.business.ClientService;
import flashscore.Model.Entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
public class LoginController {
    @Inject
    private  ClientService clientService;
    @Inject
    private AdminService adminService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String getLoginForm(){
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String Login(@RequestParam String username,@RequestParam String password,Model model) {
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


    @RequestMapping(value="/reg",method = RequestMethod.GET)
    public String getRegistationForm(){
        return "reg";
    }


    @RequestMapping(value="/reg",method =RequestMethod.POST)
    public String CreateAccount( Client client,Model model){
        if(clientService.findByUsername(client.getUsername())==null)
        clientService.addClient(client);
        else{
            model.addAttribute("username already exists",client.getUsername());
            return "reg";
        }
        return "login";
    }
}
