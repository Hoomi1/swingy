package ft.school21.swing.java.view;

import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;

import java.util.ArrayList;

public interface GameView {

    void drawStartMenu(); // приветствие
    void ChoicePlayer(ArrayList<GameActions> players); // выбор игрока
    void ChoiceRace(); // окно для выбора рассы
    void ChoiceClass(); // окно для выбора класса
    void CreateNamePlayer(); // окно для создание имени
    void ChoiceDeletePlayer(); // окно для удаления героя
    void DataPlayer(GameActions players); // данные о выбранном герое
    void ShowMap(Map map, GameActions players);
}
