package ft.school21.swing.java;

import ft.school21.swing.java.database.ImplementDB;
import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.view.ChoiceGame;
import ft.school21.swing.java.view.Console;
import ft.school21.swing.java.view.GameView;
import ft.school21.swing.java.view.Gui;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class StartGame {

    private static ChoiceGame choiceGame;
//    private static GameView view;
    private static SessionFactory sessionFactory = null;
    public static void Game(String arg)
    {
        if (arg.equals("console"))
        {
            choiceGame = new ChoiceGame(new Console());
        }
        else
        {
            choiceGame = new ChoiceGame(new Gui());
        }
        choiceGame.getView().drawStartMenu();
        ArrayList<GameActions> players = null;
        try {
            sessionFactory = ImplementDB.getImplementDB().getFactory();
            players = ImplementDB.getImplementDB().getAllHeroesDB();
        }
        finally {
            sessionFactory.close();
        }
        choiceGame.getView().ChoicePlayer(players);
    }
}
