package main;
import flashscore.Model.Entity.Client;
import flashscore.Model.Entity.ClientList;
import flashscore.Model.Entity.Game;
import flashscore.app.FinalApplication;
import flashscore.Model.business.AdminService;
import flashscore.Model.business.ClientListService;
import flashscore.Model.business.ClientService;
import flashscore.Model.business.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FinalApplication.class)
public class FinalApplicationTests {

	@Inject
	ClientService clientService;
	@Inject
	AdminService adminService;
	@Inject
	GameService gameService;
	@Inject
	ClientListService clientListService;

	@Test
	public void testLoginAdmin(){
		String name="fane";
		String password="333";
		String returnedPassword=adminService.findByUsername(name).getPassword();
		assertEquals(password,returnedPassword);
	}

	@Test
	public void testLoginClient(){
		String name="motora";
		String password="222";
		String returnedPassword=clientService.findByUsername(name).getPassword();
		assertEquals(password,returnedPassword);
	}

	@Test
	public void testAddGame(){
		Game add=new Game("tenis","romania","germania");
		int initial=gameService.findAllGames().size();
		gameService.addGame(add);
		int after=gameService.findAllGames().size();
		assertEquals(initial,after-1);
	}

	@Test
	public void addGameToFavouriteList(){
		Client x=clientService.findByUsername("motora");
		int initial=clientListService.findAll().size();
		ClientList add=new ClientList(x,gameService.findAllGames().get(0));
		clientListService.addGame(add);
		int after=clientListService.findAll().size();
		assertEquals(initial,after-1);

	}
}
