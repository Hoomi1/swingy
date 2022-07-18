package ft.school21.swing.java.view;

import ft.school21.swing.java.Main;
import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dimension.width/2 - SCREEN_WIDTH/2, dimension.height/2 - SCREEN_HEIGHT/2, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setVisible(false);
        this.setResizable(false);
        MacSizeWidth = dimension.width;
        MacSizeHeight = dimension.height;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void ClearWindow()
    {
        getContentPane().removeAll();
        repaint();
    }

    class MyImage extends JPanel {
        String	path;
        int		x, y;

        MyImage(String path, int x, int y) {
            super();
            this.path = path;
            this.x = x;
            this.y = y;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            try {
                BufferedImage img = ImageIO.read(new File(path));
                g.drawImage(img, x, y, null);
            } catch (IOException e) {
                System.out.println((e.getMessage()));
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(700, 400));
        }
    }

    public void drawStartMenu() {
        ClearWindow();
        //setVisible(true);
        JButton buttonEnterScreen = new JButton("Press to continue");
//        buttonEnterScreen.setSize(200, 30);
        buttonEnterScreen.setBounds(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT - 100, 200, 30);
        buttonEnterScreen.addActionListener(new SwitchButtonListener());
        add(buttonEnterScreen);
        MyImage image = new MyImage("src/resources/images/START_SWING.png", 200,200);
        image.setBounds(SCREEN_WIDTH / 2 - 400, SCREEN_HEIGHT / 2 - 400, 800, 800);
        add(image);

        setVisible(true);

    }

    private class SwitchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            ClearWindow();
            Main.flagGui = true;
        }
    }

    public void ChoicePlayer(ArrayList<GameActions> players) {
        setVisible(true);
        ClearWindow();
        setVisible(true);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.orange);
        JButton buttonEnterScreen = new JButton("WINDOW TWO");
        buttonEnterScreen.setBounds(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT - 100, 200, 30);
        buttonEnterScreen.addActionListener(new SwitchButtonTWO());
        MyImage image = new MyImage("src/resources/images/START_SWING.png", 200,200);
        image.setBounds(SCREEN_WIDTH / 2 - 400, SCREEN_HEIGHT / 2 - 400, 800, 800);
        jPanel.add(image);
        jPanel.add(buttonEnterScreen);
        add(jPanel);
        repaint();
        paintComponents(jPanel.getGraphics());
        setVisible(true);
//        MyImage image = new MyImage("src/resources/images/START_SWING.png", 200,200);
//        image.setBounds(SCREEN_WIDTH / 2 - 400, SCREEN_HEIGHT / 2 - 400, 800, 800);
//        add(image);
//        revalidate();
//        setVisible(true);
    }

    private class SwitchButtonTWO implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
//            ClearWindow();
        }
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
