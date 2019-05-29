package flashscore.Model.business;

import flashscore.Model.Entity.Client;
import flashscore.Model.Entity.ClientList;
import flashscore.Model.Entity.Game;
import flashscore.Model.Repository.ClientListRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientListService {
    @Inject
    ClientListRepository clientListRepository;

    public ClientList addGame(ClientList clientList){
        return clientListRepository.save(clientList);
    }

    public void deleteGame(Game game){ clientListRepository.deleteByGame(game);
    }

    public List<Game> findClientFavouriteGames(Client client){
        List<ClientList> x=clientListRepository.findAllByClient(client);
        List<Game> result=new ArrayList<Game>();
        for(ClientList aux:x){
            result.add(aux.getMatch());
        }
        return result;
    }

    public List<ClientList> findClientListByClient(Client old){
        return clientListRepository.findAllByClient(old);
    }

    public void deleteAll(Client client){
        clientListRepository.deleteAllByClient(client);
    }

    public void addAll(List<ClientList> updatedList,Client client){
        for(ClientList aux:updatedList){
            ClientList added=new ClientList(client,aux.getMatch());
            clientListRepository.save(added);
        }
    }

    public void deleteAllByGame(Game game){
        clientListRepository.deleteAllByGame(game);
    }

    public ClientList findClientGameByGame(Game game){
        return clientListRepository.findByGame(game);
    }

    public List<ClientList> findAll(){
        return clientListRepository.findAll();
    }
}
