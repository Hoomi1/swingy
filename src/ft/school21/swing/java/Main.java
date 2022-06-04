package ft.school21.swing.java;

import ft.school21.swing.java.database.Heroes;
import ft.school21.swing.java.database.ImplementDB;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("Invalid argument:\n" +
                    "java -jar swingy.jar console | gui");
            System.exit(1);
        }
        if (args[0].equals("console") || args[0].equals("gui")) {
            StartGame.Game(args[0]);
        }
//        else if (args[0].equals("gui")) {
//            StartGame.Menu(args[0]);
//        }
        else
        {
            System.out.println("Implemented commands \"gui\" and \"console\"");
            System.exit(1);
        }

        //TODO: дальнейшая работа с бд
//        SessionFactory sessionFactory = null;
//        try {
////        Heroes heroes = new Heroes("asd", "asd", 12.0, 12.0, 12, 2, 45, "qwer", "sdasd", "asd");
////            Heroes heroes = ImplementDB.getImplementDB().getHeroDB(1L);
//            sessionFactory = ImplementDB.getImplementDB().getFactory();
//            List<Heroes> list = ImplementDB.getImplementDB().getAllHeroesDB();
//            System.out.println(list);
//        }
//        finally {
//            sessionFactory.close();
//        }
    }
}
