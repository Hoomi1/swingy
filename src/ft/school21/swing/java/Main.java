package ft.school21.swing.java;

import ft.school21.swing.java.database.Heroes;
import ft.school21.swing.java.database.ImplementDB;
import ft.school21.swing.java.model.GameActions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static volatile boolean flagGui;

    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("Invalid argument:\n" +
                    "java -jar swingy.jar console | gui");
            System.exit(1);
        }
        if (args[0].equals("console") || args[0].equals("gui")) {
            try {
                StartGame.Game(args[0]);
            }
            finally {
                ImplementDB.getImplementDB().getFactory().close();
            }
        }
        else
        {
            System.out.println("Implemented commands \"gui\" and \"console\"");
            System.exit(1);
        }

        //TODO: дальнейшая работа с бд
//        SessionFactory sessionFactory = null;
//        try {
//        Heroes heroes = new Heroes("orc", "asd3", "asd", 12.0, 12.0, 12, 2, 45, "bow", "dark", "dark");

//                    Heroes heroes = ImplementDB.getImplementDB().getHeroDB(1L);
//            sessionFactory = ImplementDB.getImplementDB().getFactory();
//            Session session = sessionFactory.getCurrentSession();
//            //----delete
//            session.beginTransaction();
//            Heroes hero = session.get(Heroes.class, 3L);
//            session.delete(hero);
//            session.getTransaction().commit();
            //-------------------
            //------create
//            session.beginTransaction();
//            session.save(heroes);
//            session.getTransaction().commit();
            //-----------------------
//            List<GameActions> list = ImplementDB.getImplementDB().getAllHeroesDB();
//            System.out.println(list);
//        }
//        finally {
//            sessionFactory.close();
//        }
    }
}
