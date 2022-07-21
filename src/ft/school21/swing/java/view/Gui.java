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
    public static JFormattedTextField EnterClass = new JFormattedTextField("        ");
    private JButton[] jButtonPlayers;

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
        jButtonPlayers = new JButton[players.size()];
        for (int i = 0; i < jButtonPlayers.length; i++) {
            jButtonPlayers[i] = new JButton(players.get(i).getId() + ") -> " + players.get(i).getName());
            jButtonPlayers[i].addActionListener(new ButtonPlayer());
            jPanel.add(jButtonPlayers[i]);
        }

        add(jPanelBorder, BorderLayout.SOUTH);
        add(jPanel);
        setVisible(true);
    }

    private class ButtonPlayer implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);

            char idHero = ((JButton) e.getSource()).getText().charAt(0);
            StartGame.commandGui = String.valueOf(idHero);
            Main.flagGui = true;
        }
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
        JPanel jPanelRace = new JPanel(new GridLayout());

        JTextArea textRaceDarkElf = new JTextArea();
        JTextArea textRaceDwarf = new JTextArea();
        JTextArea textRaceElf = new JTextArea();
        JTextArea textRaceHuman = new JTextArea();
        JTextArea textRaceOrc = new JTextArea();
        textRaceDarkElf.setText("1) DarkElf\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
        textRaceDwarf.setText("2) Dwarf\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
        textRaceElf.setText("3) Elf\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
        textRaceHuman.setText("4) Human\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
        textRaceOrc.setText("5) Orc\t" + "\nAttack=15;\t" + "\nDefense=2;\t" + "\nHP=40.   \t");
        jPanelRace.add(textRaceDarkElf);
        jPanelRace.add(textRaceDwarf);
        jPanelRace.add(textRaceElf);
        jPanelRace.add(textRaceHuman);
        jPanelRace.add(textRaceOrc);
        jPanelRace.setPreferredSize(new Dimension(800, 70));

        JPanel jPanelImages = new JPanel(new GridLayout());
        MyImage image1 = new MyImage("src/resources/images/face_DarkElf.png", 0,0);
        MyImage image2 = new MyImage("src/resources/images/face_Dwarf.png", 0,0);
        MyImage image3 = new MyImage("src/resources/images/face_Elf.png", 0,0);
        MyImage image4 = new MyImage("src/resources/images/face_Human.png", 0,0);
        MyImage image5 = new MyImage("src/resources/images/face_Orc.png", 0,0);
        jPanelImages.add(image1);
        jPanelImages.add(image2);
        jPanelImages.add(image3);
        jPanelImages.add(image4);
        jPanelImages.add(image5);
        jPanelImages.setPreferredSize(new Dimension(800, 160));


        JPanel jPanelBorderLayout = new JPanel(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.GREEN);
        jPanelRace.setBackground(Color.GREEN);
        JLabel textEnterRace = new JLabel("Enter race: ");
        EnterRace.addActionListener(new ButtonEnterRace());
        jPanel.setPreferredSize(new Dimension(800, 30));
        jPanel.add(textEnterRace);
        jPanel.add(EnterRace);
        jPanelBorderLayout.add(jPanel, BorderLayout.NORTH);
        jPanelBorderLayout.add(jPanelImages, BorderLayout.CENTER);
        jPanelBorderLayout.add(jPanelRace, BorderLayout.SOUTH);
        add(jPanelBorderLayout, BorderLayout.NORTH);
        setVisible(true);
    }

    private class ButtonEnterRace implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            try {
                Controller.createRace = Integer.parseInt(EnterRace.getText().trim());
                Main.flagGui = true;
            }
            catch (NumberFormatException ex)
            {
                Main.flagGui = false;
            }
        }
    }

    @Override
    public void ChoiceClass() {
        ClearWindow();
        JPanel jPanelClasses = new JPanel(new GridLayout());

        JTextArea textClassWarrior = new JTextArea();
        JTextArea textClassWizard = new JTextArea();
        JTextArea textClassBerserk = new JTextArea();
        JTextArea textClassNecromancer = new JTextArea();
        textClassWarrior.setText("1) Warrior");
        textClassWizard.setText("2) Wizard");
        textClassBerserk.setText("3) Berserk");
        textClassNecromancer.setText("4) Necromancer");
        jPanelClasses.add(textClassWarrior);
        jPanelClasses.add(textClassWizard);
        jPanelClasses.add(textClassBerserk);
        jPanelClasses.add(textClassNecromancer);
        jPanelClasses.setPreferredSize(new Dimension(800, 30));

        JPanel jPanelImages = new JPanel(new GridLayout());
        MyImage image1 = new MyImage("src/resources/images/class_Warrior.png", 0,0);
        MyImage image2 = new MyImage("src/resources/images/class_Wizard.png", 0,0);
        MyImage image3 = new MyImage("src/resources/images/class_Berserk.png", 0,0);
        MyImage image4 = new MyImage("src/resources/images/class_Necromancer.png", 0,0);
        jPanelImages.add(image1);
        jPanelImages.add(image2);
        jPanelImages.add(image3);
        jPanelImages.add(image4);
        jPanelImages.setPreferredSize(new Dimension(800, 200));


        JPanel jPanelBorderLayout = new JPanel(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.GREEN);
        jPanelClasses.setBackground(Color.GREEN);
        JLabel textEnterRace = new JLabel("Enter class: ");
        EnterClass.addActionListener(new ButtonEnterClass());
        jPanel.setPreferredSize(new Dimension(800, 30));
        jPanel.add(textEnterRace);
        jPanel.add(EnterClass);
        jPanelBorderLayout.add(jPanel, BorderLayout.NORTH);
        jPanelBorderLayout.add(jPanelImages, BorderLayout.CENTER);
        jPanelBorderLayout.add(jPanelClasses, BorderLayout.SOUTH);
        add(jPanelBorderLayout, BorderLayout.NORTH);
        setVisible(true);
    }

    private class ButtonEnterClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            try {
                Controller.createClass = Integer.parseInt(EnterClass.getText().trim());
                Main.flagGui = true;
            }
            catch (NumberFormatException ex)
            {
                Main.flagGui = false;
            }
        }
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
        ClearWindow();
        JPanel jPanelData = new JPanel(new BorderLayout());
        JPanel jPanelButton = new JPanel(new BorderLayout());
        JButton jButtonOk = new JButton("OK");
        jButtonOk.addActionListener(new ButtonOk());
        jButtonOk.setBackground(Color.ORANGE);
        jPanelButton.setBackground(Color.ORANGE);
        jButtonOk.setSize(50, 50);
        JTextArea textData = new JTextArea("\n\n\n\n\n\n\n"
                + "Name: " + players.getName() + "\n\n"
                + "HP: " + String.valueOf(players.getHP()) + "\n\n"
                + "Level: " + String.valueOf(players.getLevel()) +"\n\n"
                + "EXP: " + String.valueOf(players.getExperience()) + "\n\n"
                + "Attack: " + String.valueOf(players.getAttack() + players.getPlayRaces().getPlayAttack()) + "\n\n"
                + "Race: " + players.getPlayRaces().getPlayName() + "\n\n"
                + "Class: " + players.getPlayClasses().name() + "\n\n"
                + "Armor: " + players.getPlayArmor().getName() + "\n\n"
                + "Helm: " + players.getPlayHelm().getName() + "\n\n"
                + "Weapon: " + players.getPlayWeapon().getWeaponName()
        );
        textData.setBackground(Color.GREEN);

        jPanelData.add(textData);
        jPanelButton.add(jButtonOk);
        add(jPanelData, BorderLayout.CENTER);
        add(jPanelButton, BorderLayout.NORTH);
        setVisible(true);

    }

    private class ButtonOk implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            Main.flagGui = true;
        }
    }

    @Override
    public void ShowMap(Map map, GameActions players) {
        ClearWindow();
        
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
