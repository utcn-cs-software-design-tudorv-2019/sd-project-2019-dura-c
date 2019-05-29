package Data.DAO;

import Data.Entity.Bet;
import Data.Entity.Game;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Data.Hybernate.Hybernate;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BetDAO {

    private SessionFactory sessionFactory= Hybernate.getSessionFactory();

    public List<Bet> getAllBets(Game game){
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Bet.class);
        criteria.add(Restrictions.like("idGame",game));
        List <Bet> results = criteria.list();
        session.close();
        return results;
    }
}
