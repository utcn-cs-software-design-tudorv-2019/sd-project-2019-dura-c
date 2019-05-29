package Data.DAO;

import Data.Entity.Game;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Data.Hybernate.Hybernate;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class MatchDAO {

    private SessionFactory sessionFactory= Hybernate.getSessionFactory();

    public Game getMatchByScore(String score){
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Game.class);
        criteria.add(Restrictions.like("score",score));
        Game result=(Game)criteria.list().get(0);
        session.close();
        return result;
    }

    public void updateGame(Game game){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.merge(game);
        session.getTransaction().commit();
        session.close();
    }

    public List<Game> getAllGames(){
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Game.class);
        List <Game> results = criteria.list();
        session.close();
        return results;
    }
}
