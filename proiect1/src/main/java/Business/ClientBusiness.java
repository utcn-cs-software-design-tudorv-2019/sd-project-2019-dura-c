package Business;

import Data.DAO.ClientDAO;
import Data.Entity.Client;

public class ClientBusiness {
    ClientDAO clientDAO = new ClientDAO();
    public void updateClient(Client client){
        clientDAO.updateClient(client);
    }
}
