package ft.school21.swing.java.view;

import ft.school21.swing.java.Main;
import ft.school21.swing.java.StartGame;
import ft.school21.swing.java.controller.Controller;
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
//    public static JLabel textEnterId = new JLabel("Enter id for delete Hero");
    public static JFormattedTextField EnterId = new JFormattedTextField("        ");
    public static JFormattedTextField EnterName = new JFormattedTextField("        ");
    public static JFormattedTextField EnterRace = new JFormattedTextField("        ");
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
            //ClearWindow();
            Main.flagGui = true;
        }
    }

    public void ChoicePlayer(ArrayList<GameActions> players) {
        ClearWindow();
        JPanel jPanel = new JPanel(new FlowLayout());
        JPanel jPanelSettings = new JPanel();
        JPanel jPanelBorder = new JPanel(new BorderLayout());
        JButton jButtonCreate = new JButton("Create");
        JLabel textEnterId = new JLabel("Enter id for delete Hero");
        EnterId.addActionListener(new ButtonDeleteHero());
        jButtonCreate.addActionListener(new ButtonCreateHero());
        jPanelSettings.setBackground(Color.GREEN);
        jPanelSettings.add(jButtonCreate);
        jPanelSettings.add(textEnterId);
        jPanelSettings.add(EnterId);
        jPanelBorder.setPreferredSize(new Dimension(800, 80));
        jPanelBorder.add(jPanelSettings);
        jPanel.setBackground(Color.ORANGE);
        JButton[] jButtonPlayers = new JButton[players.size()];
        for (int i = 0; i < jButtonPlayers.length; i++) {
            jButtonPlayers[i] = new JButton(players.get(i).getId() + ") -> " + players.get(i).getName());
            jPanel.add(jButtonPlayers[i]);
        }

        add(jPanelBorder, BorderLayout.SOUTH);
        add(jPanel);
        setVisible(true);
    }

    private class ButtonCreateHero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            StartGame.commandGui = "a";
//            String isSpace = EnterId.getText().trim();
//            Controller.idDel = Long.parseLong(isSpace);
            Main.flagGui = true;
        }
    }

    private class ButtonDeleteHero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            StartGame.commandGui = "b";
            String isSpace = EnterId.getText().trim();
            Controller.idDel = Long.parseLong(isSpace);
            Main.flagGui = true;
        }
    }

    @Override
    public void ChoiceRace() {
        ClearWindow();
//        JPanel jPanelRace = new JPanel(new FlowLayout());
//        JLabel textRaceDarkElf = new JLabel();
//        JLabel textRaceDwarf = new JLabel();
//        JLabel textRaceElf = new JLabel();
//        JLabel textRaceHuman = new JLabel();
//        JLabel textRaceOrc = new JLabel();
//        textRaceDarkElf.setText("1) DarkElf\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
//        textRaceDwarf.setText("2) Dwarf\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
//        textRaceElf.setText("3) Elf\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
//        textRaceHuman.setText("4) Human\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
//        textRaceOrc.setText("5) Orc\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
//        jPanelRace.add(textRaceDarkElf, BorderLayout.SOUTH);
//        jPanelRace.add(textRaceDwarf, BorderLayout.SOUTH);
//        jPanelRace.add(textRaceElf, BorderLayout.SOUTH);
//        jPanelRace.add(textRaceHuman, BorderLayout.SOUTH);
//        jPanelRace.add(textRaceOrc, BorderLayout.SOUTH);

        JPanel jPanelBorderLayout = new JPanel(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.GREEN);
        JLabel textEnterRace = new JLabel("Enter race: ");
        EnterRace.addActionListener(new ButtonEnterRace());
        jPanel.setPreferredSize(new Dimension(800, 100));
        jPanel.add(textEnterRace);
        jPanel.add(EnterRace);
//        jPanel.add(jPanelRace);
        jPanelBorderLayout.add(jPanel);
        add(jPanelBorderLayout, BorderLayout.NORTH);
        setVisible(true);
    }

    private class ButtonEnterRace implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            Controller.createRace = Integer.parseInt(EnterRace.getText().trim());
            Main.flagGui = true;
        }
    }

    @Override
    public void ChoiceClass() {
        ClearWindow();
        JLabel textEnterClasses = new JLabel("Enter class: ");
    }

    @Override
    public void CreateNamePlayer() {
        ClearWindow();
        JPanel jPanelBorderLayout = new JPanel(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.GREEN);
        JLabel textEnterName = new JLabel("Enter name: ");
        EnterName.addActionListener(new ButtonEnterName());
        jPanel.setPreferredSize(new Dimension(800, 100));
        jPanel.add(textEnterName);
        jPanel.add(EnterName);
        jPanelBorderLayout.add(jPanel);
        add(jPanelBorderLayout, BorderLayout.NORTH);
        setVisible(true);
    }

    private class ButtonEnterName implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            Controller.createName = EnterName.getText().trim();
            Main.flagGui = true;
        }
    }

    @Override
    public void ChoiceDeletePlayer() {
        ClearWindow();
        JLabel textEnterId = new JLabel("Hero removed!!!");
        add(textEnterId);
        setVisible(true);
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
