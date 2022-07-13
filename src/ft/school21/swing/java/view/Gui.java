package ft.school21.swing.java.view;

import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame implements GameView{

    private static final int    SCREEN_HEIGHT = 800;
    private static final int    SCREEN_WIDTH =  800;
    private static int MacSizeWidth;
    private static int MacSizeHeight;

    public static int getMacSizeWidth() {
        return MacSizeWidth;
    }

    public static int getMacSizeHeight() {
        return MacSizeHeight;
    }

    public Gui(){
        super("SWINGY");
//        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width/2 - SCREEN_WIDTH/2, dimension.height/2 - SCREEN_HEIGHT/2, SCREEN_WIDTH, SCREEN_HEIGHT);
        setVisible(false);
        setResizable(false);
        MacSizeWidth = dimension.width;
        MacSizeHeight = dimension.height;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void drawStartMenu() {
        setVisible(true);
        JButton buttonEnterScreen = new JButton("Press to continue");
        buttonEnterScreen.setBounds(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT - 100, 200, 30);
        buttonEnterScreen.addActionListener(new SwitchButtonListener());
        add(buttonEnterScreen);
    }

    private class SwitchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
        }
    }

    public void ChoicePlayer(ArrayList<GameActions> players) {

    }

    @Override
    public void ChoiceRace() {

    }

    @Override
    public void ChoiceClass() {

    }

    @Override
    public void CreateNamePlayer() {

    }

    @Override
    public void ChoiceDeletePlayer() {

    }

    @Override
    public void DataPlayer(GameActions players) {

    }

    @Override
    public void ShowMap(Map map, GameActions players) {

    }

    @Override
    public void StartBattle() {

    }

    @Override
    public void WindowBattle() {

    }

    @Override
    public void RandomCube(int i) {

    }

    @Override
    public void youWin() {

    }

    @Override
    public void youDied() {

    }

    @Override
    public void youRunAway() {

    }

    @Override
    public void gameOver() {

    }
}
