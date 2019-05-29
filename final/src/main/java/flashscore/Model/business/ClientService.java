package flashscore.Model.business;

import flashscore.Model.Entity.Client;
import org.springframework.stereotype.Service;
import flashscore.Model.Repository.ClientRepository;

import javax.inject.Inject;
import java.util.List;

@Service
public class ClientService {
    @Inject
    private ClientRepository clientRepository;

    private Client loggedClient;

    public void setLoggedClient(Client client){
        loggedClient=client;
    }
    public Client findByUsername(String username)
    {
        return clientRepository.findByUsername(username);
    }

    public Client addClient(Client client){
            return clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client getLoggedClient() {
        return loggedClient;
    }
    public void deleteClient(){
        clientRepository.deleteByIdclient(loggedClient.getIdclient());
    }
}
