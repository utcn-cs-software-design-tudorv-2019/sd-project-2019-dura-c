package Data.DAO;

import Data.Entity.Client;
import Data.Hybernate.Hybernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClientDAO {

    private SessionFactory sessionFactory= Hybernate.getSessionFactory();

    public void updateClient(Client client){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.merge(client);
        session.getTransaction().commit();
        session.close();
    }
}

