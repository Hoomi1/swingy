package ft.school21.swing.java.view;

import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;

import java.util.ArrayList;

public class Console implements GameView{

    private Map map;

    public void drawStartMenu()
    {
        System.out.println("| ! GAME SWINGY ! |\n");
    }

    public void ChoicePlayer(ArrayList<GameActions> players)
    {
        System.out.println("--- Player choice---");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("-> " + players.get(i).getName());
        }
        System.out.println("-> " + "Create a hero");
    }
}
