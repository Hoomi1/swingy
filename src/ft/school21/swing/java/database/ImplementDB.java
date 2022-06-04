package ft.school21.swing.java.database;

import ft.school21.swing.java.model.GameActions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ImplementDB {

    //TODO: close factory in finally
    private static SessionFactory factory;
    private static ImplementDB implementDB;
    private ImplementDB()
    {

    }

    public static ImplementDB getImplementDB() {
        if (implementDB == null) {
            implementDB = new ImplementDB();
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Heroes.class)
                    .buildSessionFactory();
        }
        return implementDB;
    }

    public SessionFactory getFactory()
    {
        return factory;
    }

    public void AddHeroDB(Heroes heroes)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(heroes);
        session.getTransaction().commit();
    }

    public Heroes getHeroDB(Long id)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Heroes heroes = session.get(Heroes.class, id);
        session.getTransaction().commit();
        return heroes;
    }

    public ArrayList<GameActions> getAllHeroesDB()
    {
        GameActions gameActions = new GameActions();
        ArrayList<GameActions> players = new ArrayList<GameActions>();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Heroes> list = session.createQuery("from Heroes").getResultList();
        //TODO: заполнить поля сущности GameActions из бд;
        for (int i = 0; i < list.size(); i++) {
        }
        return players;
    }
}
