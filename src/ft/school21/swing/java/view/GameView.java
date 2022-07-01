package ft.school21.swing.java.view;

import ft.school21.swing.java.model.GameActions;

import java.util.ArrayList;

public interface GameView {

    void drawStartMenu();
    void ChoicePlayer(ArrayList<GameActions> players);
    void ChoiceRace();
    void ChoiceClass();
    void CreateNamePlayer();
    void ChoiceDeletePlayer();
}
