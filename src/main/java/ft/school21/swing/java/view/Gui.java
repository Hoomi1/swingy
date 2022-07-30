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
import java.net.URL;
import java.util.ArrayList;

public class Gui extends JFrame implements GameView{

    private static final int    SCREEN_HEIGHT = 800;
    private static final int    SCREEN_WIDTH =  800;
    private static int MacSizeWidth;
    private static int MacSizeHeight;
    public static JFormattedTextField EnterId = new JFormattedTextField("        ");
    public static JFormattedTextField EnterName = new JFormattedTextField("        ");
    public static JFormattedTextField EnterRace = new JFormattedTextField("        ");
    public static JFormattedTextField EnterClass = new JFormattedTextField("        ");

    public static int getMacSizeWidth() {
        return MacSizeWidth;
    }

    public static int getMacSizeHeight() {
        return MacSizeHeight;
    }

    private void SizeMyWindow()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dimension.width/2 - SCREEN_WIDTH/2, dimension.height/2 - SCREEN_HEIGHT/2, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setVisible(false);
        this.setResizable(false);
        MacSizeWidth = dimension.width;
        MacSizeHeight = dimension.height;
    }

    public Gui(){
        super("SWINGY");
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setBounds(dimension.width/2 - SCREEN_WIDTH/2, dimension.height/2 - SCREEN_HEIGHT/2, SCREEN_WIDTH, SCREEN_HEIGHT);
//        this.setVisible(false);
//        this.setResizable(false);
//        MacSizeWidth = dimension.width;
//        MacSizeHeight = dimension.height;
        SizeMyWindow();
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
            return (new Dimension(1000, 1000));
        }
    }

    private String StrPathRes(URL url)
    {
        String file = null;
        if (url.toString().contains("!")) {
            file = url.getPath().replace("swingy.jar!", "classes");
            file = file.replace("file:", "");
        }
        else
            file = url.getPath();
        return file;
    }

    public void drawStartMenu() {
        ClearWindow();
        //setVisible(true);
        JButton buttonEnterScreen = new JButton("Press to continue");
//        buttonEnterScreen.setSize(200, 30);
        buttonEnterScreen.setBounds(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT - 100, 200, 30);
        buttonEnterScreen.addActionListener(new SwitchButtonListener());
        add(buttonEnterScreen);
        URL url = getClass().getResource("/images/START_SWING.png");
        String file = StrPathRes(url);
        MyImage image = new MyImage(file, 200,200);
        image.setBounds(SCREEN_WIDTH / 2 - 400, SCREEN_HEIGHT / 2 - 400, 800, 800);
        add(image);

        setVisible(true);
    }

    private class SwitchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(true);
            Main.flagGui = true;
        }
    }

    public void ChoicePlayer(ArrayList<GameActions> players) {
        ClearWindow();
        JPanel jPanel = new JPanel(new FlowLayout());
        JPanel jPanelSettings = new JPanel();
        JPanel jPanelBorder = new JPanel(new BorderLayout());
        JButton jButtonCreate = new JButton("Create a hero");
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
            jButtonPlayers[i].addActionListener(new ButtonPlayer());
            jPanel.add(jButtonPlayers[i]);
        }

        add(jPanelBorder, BorderLayout.SOUTH);
        add(jPanel);
        setVisible(true);
        pack();
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
            try {
                setVisible(true);
                StartGame.commandGui = "b";
                String isSpace = EnterId.getText().trim();
                Controller.idDel = Long.parseLong(isSpace);
                Main.flagGui = true;
            }
            catch (NumberFormatException ex)
            {
                Main.flagGui = false;
            }
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

//        String strImg1 = getClass().getResource("/images/face_DarkElf.png").getPath();
//        String strImg2 = getClass().getResource("/images/face_Dwarf.png").getPath();
//        String strImg3 = getClass().getResource("/images/face_Elf.png").getPath();
//        String strImg4 = getClass().getResource("/images/face_Human.png").getPath();
//        String strImg5 = getClass().getResource("/images/face_Orc.png").getPath();

        String strImg1 = StrPathRes(getClass().getResource("/images/face_DarkElf.png"));
        String strImg2 = StrPathRes(getClass().getResource("/images/face_Dwarf.png"));
        String strImg3 = StrPathRes(getClass().getResource("/images/face_Elf.png"));
        String strImg4 = StrPathRes(getClass().getResource("/images/face_Human.png"));
        String strImg5 = StrPathRes(getClass().getResource("/images/face_Orc.png"));

        JPanel jPanelImages = new JPanel(new GridLayout());
        MyImage image1 = new MyImage(strImg1, 0,0);
        MyImage image2 = new MyImage(strImg2, 0,0);
        MyImage image3 = new MyImage(strImg3, 0,0);
        MyImage image4 = new MyImage(strImg4, 0,0);
        MyImage image5 = new MyImage(strImg5, 0,0);
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
        pack();
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

//        String strImg1 = getClass().getResource("/images/class_Warrior.png").getPath();
//        String strImg2 = getClass().getResource("/images/class_Wizard.png").getPath();
//        String strImg3 = getClass().getResource("/images/class_Berserk.png").getPath();
//        String strImg4 = getClass().getResource("/images/class_Necromancer.png").getPath();

        String strImg1 = StrPathRes(getClass().getResource("/images/class_Warrior.png"));
        String strImg2 = StrPathRes(getClass().getResource("/images/class_Wizard.png"));
        String strImg3 = StrPathRes(getClass().getResource("/images/class_Berserk.png"));
        String strImg4 = StrPathRes(getClass().getResource("/images/class_Necromancer.png"));

        JPanel jPanelImages = new JPanel(new GridLayout());
        MyImage image1 = new MyImage(strImg1, 0,0);
        MyImage image2 = new MyImage(strImg2, 0,0);
        MyImage image3 = new MyImage(strImg3, 0,0);
        MyImage image4 = new MyImage(strImg4, 0,0);
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
        pack();
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
        pack();
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
        JLabel textEnterId = new JLabel("Hero removed!?");
        add(textEnterId);
        setVisible(true);
    }

    @Override
    public void DataPlayer(GameActions players) {
        ClearWindow();
        SizeMyWindow();

        setVisible(true);
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
        int wh = 0;
        int whDimension = 140;
        this.setBounds(getMacSizeWidth()/2 - 1200/2, getMacSizeHeight()/2 - 1200/2, 1200, 1200);
        JPanel jPanelLeft = new JPanel(new BorderLayout());
        JPanel jPanelRight = new JPanel(new BorderLayout());
        JPanel jPanelUp = new JPanel(new BorderLayout());
        JPanel jPanelDown = new JPanel(new BorderLayout());
        JPanel jPanelCenter = new JPanel();
        JPanel jPanelMove = new JPanel(new GridBagLayout());

        JButton buttonUp = new JButton("UP");
        JButton buttonDown = new JButton("DOWN");
        JButton buttonLeft = new JButton("LEFT");
        JButton buttonRight = new JButton("RIGHT");
        JButton buttonInfo = new JButton("INFO");
        JButton buttonConsole = new JButton("CONSOLE");

        buttonUp.addActionListener(new ButtonMoveUp());
        buttonDown.addActionListener(new ButtonMoveDown());
        buttonLeft.addActionListener(new ButtonMoveLeft());
        buttonRight.addActionListener(new ButtonMoveRight());
        buttonInfo.addActionListener(new ButtonInfo());
        buttonConsole.addActionListener(new ButtonConsole());

//        MyImage imageObs = new MyImage("src/resources/images/face_DarkElf.png", 0,0);
//        MyImage imageEval = new MyImage("src/resources/images/face_Orc.png", 0,0);

//        String strImg1 = getClass().getResource("/images/face_DarkElf.png").getPath();
//        String strImg2 = getClass().getResource("/images/face_Dwarf.png").getPath();
//        String strImg3 = getClass().getResource("/images/face_Elf.png").getPath();
//        String strImg4 = getClass().getResource("/images/face_Human.png").getPath();
//        String strImg5 = getClass().getResource("/images/face_Orc.png").getPath();

        String strImg1 = StrPathRes(getClass().getResource("/images/face_DarkElf.png"));
        String strImg2 = StrPathRes(getClass().getResource("/images/face_Dwarf.png"));
        String strImg3 = StrPathRes(getClass().getResource("/images/face_Elf.png"));
        String strImg4 = StrPathRes(getClass().getResource("/images/face_Human.png"));
        String strImg5 = StrPathRes(getClass().getResource("/images/face_Orc.png"));

        MyImage imagePlayer = null;
        if (players.getPlayRaces().getPlayName().toLowerCase().equals("darkelf"))
            imagePlayer = new MyImage(strImg1, 0,0);
        else if (players.getPlayRaces().getPlayName().toLowerCase().equals("dwarf"))
            imagePlayer = new MyImage(strImg2, 0,0);
        else if (players.getPlayRaces().getPlayName().toLowerCase().equals("elf"))
            imagePlayer = new MyImage(strImg3, 0,0);
        else if (players.getPlayRaces().getPlayName().toLowerCase().equals("human"))
            imagePlayer = new MyImage(strImg4, 0,0);
        else if (players.getPlayRaces().getPlayName().toLowerCase().equals("orc"))
            imagePlayer = new MyImage(strImg5, 0,0);

            jPanelMove.setBackground(new Color(153,102,0));
        jPanelMove.add(buttonUp, new GridBagConstraints(2,0,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        jPanelMove.add(buttonDown, new GridBagConstraints(2,2,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        jPanelMove.add(buttonLeft, new GridBagConstraints(1,1,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        jPanelMove.add(buttonRight, new GridBagConstraints(3,1,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        jPanelMove.add(buttonInfo, new GridBagConstraints(2,1,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        jPanelMove.add(buttonConsole, new GridBagConstraints(15,4,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));

        jPanelDown.add(jPanelMove);

        if (map.getMapSize() == 5)
            wh = 160;
        else if (map.getMapSize() == 9)
            wh = 89;
        else if (map.getMapSize() == 15)
            wh = 53;
        else if (map.getMapSize() == 19)
            wh = 42;
        else if (map.getMapSize() == 25) {
            wh = 32;
            whDimension = 120;
        }
        JPanel jPanelCoord[] = new JPanel[map.getMapSize()];
        for (int i = 0; i < map.getMapSize(); i++) {
            for (int j = 0; j < map.getMapSize(); j++) {
                jPanelCoord[j] = new JPanel(new BorderLayout());
//                JLabel text = new JLabel(String.valueOf(j+1));
//                jPanelCoord[j].add(text);
                jPanelCoord[j].setPreferredSize(new Dimension(wh, wh));
                if (players.getPosX() == j && players.getPosY() == i) {
                    if (wh < 89)
                        jPanelCoord[j].setBackground(new Color(102, 0, 153));
                    else
                    jPanelCoord[j].add(imagePlayer, BorderLayout.CENTER);
                }
                else {
                    if (map.getMapSymbol(i, j) == '\u00b7')
                        jPanelCoord[j].setBackground(new Color(0,102,0));
                    else if (map.getMapSymbol(i, j) == 'E') {
                        jPanelCoord[j].setBackground(Color.RED);
//                        jPanelCoord[j].add(imageEval);
                    }
                    else if (map.getMapSymbol(i, j) == 'O') {
                        jPanelCoord[j].setBackground(Color.BLUE);
//                        jPanelCoord[j].add(imageObs);
                    }
                }
//                jPanelCoord[j].setLayout(new FlowLayout());
                jPanelCoord[j].setBorder(BorderFactory.createLineBorder(Color.black));
                jPanelCenter.add(jPanelCoord[j]);
                setVisible(true);
            }
        }

        jPanelCenter.setBackground(new Color(102,255,102));
        jPanelLeft.setBackground(new Color(153,102,0));
        jPanelRight.setBackground(new Color(153,102,0));
        jPanelUp.setBackground(new Color(153,102,0));
        jPanelDown.setBackground(new Color(153,102,0));
        jPanelRight.setPreferredSize(new Dimension(whDimension, 1000));
        jPanelLeft.setPreferredSize(new Dimension(whDimension, 1000));
        jPanelUp.setPreferredSize(new Dimension(1000, whDimension));
        jPanelDown.setPreferredSize(new Dimension(1000, whDimension)); //20
        add(jPanelUp, BorderLayout.NORTH);
        add(jPanelRight, BorderLayout.LINE_END);
        add(jPanelDown, BorderLayout.SOUTH);
        add(jPanelLeft, BorderLayout.LINE_START);
        add(jPanelCenter, BorderLayout.CENTER);
        setVisible(true);
    }

    private class ButtonConsole implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            ClearWindow();
            Controller.createMove = "g";
            Main.flagGui = true;
            setVisible(false);
        }
    }

    private class ButtonMoveUp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createMove = "w";
            Main.flagGui = true;
        }
    }

    private class ButtonMoveDown implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createMove = "s";
            Main.flagGui = true;
        }
    }

    private class ButtonMoveLeft implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createMove = "a";
            Main.flagGui = true;
        }
    }

    private class ButtonMoveRight implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createMove = "d";
            Main.flagGui = true;
        }
    }

    private class ButtonInfo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createMove = "i";
            Main.flagGui = true;
        }
    }

    @Override
    public void StartBattle() {
        ClearWindow();
        JPanel jPanel= new JPanel(new FlowLayout());

        JButton jButtonYes = new JButton("YES");
        JButton jButtonNo = new JButton("NO");

        JLabel textFight = new JLabel();
        textFight.setText("Start a fight?");

        jButtonYes.addActionListener(new ButtonYes());
        jButtonNo.addActionListener(new ButtonNo());

        jPanel.add(jButtonYes);
        jPanel.add(jButtonNo);

        add(textFight, BorderLayout.NORTH);
        add(jPanel);
        setVisible(true);
        pack();
    }

    private class ButtonYes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createYesNo = "y";
            Main.flagGui = true;
        }
    }

    private class ButtonNo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createYesNo = "n";
            Main.flagGui = true;
        }
    }

    @Override
    public void WindowBattle() {
        ClearWindow();
        SizeMyWindow();

        JPanel jPanelHero = new JPanel(new BorderLayout());
        JPanel jPanelEvil = new JPanel(new BorderLayout());
        JPanel jPanelAll = new JPanel(new GridBagLayout());
        JPanel jPanelCube = new JPanel(new BorderLayout());
        JLabel textVS = new JLabel("----VS----");
        JButton jButton = new JButton("FIGHT!!!");

//        String strImg1 = getClass().getResource("/images/class_Warrior.png").getPath();
//        String strImg2 = getClass().getResource("/images/evil.png").getPath();

        String strImg1 = StrPathRes(getClass().getResource("/images/class_Warrior.png"));
        String strImg2 = StrPathRes(getClass().getResource("/images/evil.png"));

        MyImage imageHero = new MyImage(strImg1,0,0);
        MyImage imageEvil = new MyImage(strImg2,0,0);

        jPanelEvil.setPreferredSize(new Dimension(150, 150));
        jPanelHero.setPreferredSize(new Dimension(150, 150));
        jPanelCube.setPreferredSize(new Dimension(75, 75));
        jPanelEvil.add(imageEvil);
        jPanelHero.add(imageHero);
        jPanelCube.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelEvil.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelHero.setBorder(BorderFactory.createLineBorder(Color.black));

        jButton.addActionListener(new ButtonFight());

        jPanelAll.add(jPanelHero, new GridBagConstraints(0,0,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,5,5),0,0));
        jPanelAll.add(textVS, new GridBagConstraints(1,0,1,1,0,0,
                GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,
                new Insets(5,5,5,5),0,0));
        jPanelAll.add(jPanelEvil, new GridBagConstraints(2,0,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,5,5,2),0,0));
        jPanelAll.add(jButton, new GridBagConstraints(1,1,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(5,5,0,5),0,0));
        jPanelAll.add(jPanelCube, new GridBagConstraints(0,3,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        add(jPanelAll);
        setVisible(true);
        pack();
    }

    private class ButtonFight implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.flagGui = true;
        }
    }

    private MyImage ChoiceCube(int i)
    {
        MyImage imageCube = null;
        String file = null;
        if (i == 1)
        {
//            file = getClass().getResource("/images/Cube/Cube1.png").getPath();
            file = StrPathRes(getClass().getResource("/images/Cube/Cube1.png"));
            imageCube = new MyImage(file, 0,0);
        }
        else if (i == 2)
        {
//            file = getClass().getResource("/images/Cube/Cube2.png").getPath();
            file = StrPathRes(getClass().getResource("/images/Cube/Cube2.png"));
            imageCube = new MyImage(file, 0,0);
        }
        else if (i == 3)
        {
//            file = getClass().getResource("/images/Cube/Cube3.png").getPath();
            file = StrPathRes(getClass().getResource("/images/Cube/Cube3.png"));
            imageCube = new MyImage(file, 0,0);
        }
        else if (i == 4)
        {
//            file = getClass().getResource("/images/Cube/Cube4.png").getPath();
            file = StrPathRes(getClass().getResource("/images/Cube/Cube4.png"));
            imageCube = new MyImage(file, 0,0);
        }
        else if (i == 5)
        {
//            file = getClass().getResource("/images/Cube/Cube5.png").getPath();
            file = StrPathRes(getClass().getResource("/images/Cube/Cube5.png"));
            imageCube = new MyImage(file, 0,0);
        }
        else
        {
//            file = getClass().getResource("/images/Cube/Cube6.png").getPath();
            file = StrPathRes(getClass().getResource("/images/Cube/Cube6.png"));
            imageCube = new MyImage(file, 0,0);
        }
        return imageCube;
    }

    @Override
    public void RandomCube(int i) {
        ClearWindow();
        SizeMyWindow();

        JPanel jPanelHero = new JPanel(new BorderLayout());
        JPanel jPanelEvil = new JPanel(new BorderLayout());
        JPanel jPanelAll = new JPanel(new GridBagLayout());
        JPanel jPanelCube = new JPanel(new BorderLayout());
        JLabel textVS = new JLabel("----VS----");
        JButton jButton = new JButton("FIGHT!!!");

//        String strImg1 = getClass().getResource("/images/class_Warrior.png").getPath();
//        String strImg2 = getClass().getResource("/images/evil.png").getPath();

        String strImg1 = StrPathRes(getClass().getResource("/images/class_Warrior.png"));
        String strImg2 = StrPathRes(getClass().getResource("/images/evil.png"));

        MyImage imageHero = new MyImage(strImg1,0,0);
        MyImage imageEvil = new MyImage(strImg2,0,0);

        jPanelEvil.setPreferredSize(new Dimension(150, 150));
        jPanelHero.setPreferredSize(new Dimension(150, 150));
        jPanelCube.setPreferredSize(new Dimension(75, 75));
        jPanelEvil.add(imageEvil);
        jPanelHero.add(imageHero);
        jPanelCube.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelEvil.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelHero.setBorder(BorderFactory.createLineBorder(Color.black));

        jButton.addActionListener(new ButtonFight());

        if (i == 1 || i == 2 || i == 3 || i == 4)
            jPanelCube.setBorder(BorderFactory.createLineBorder(Color.green));
        else
            jPanelCube.setBorder(BorderFactory.createLineBorder(Color.red));
        jPanelCube.add(ChoiceCube(i), BorderLayout.CENTER);
        jPanelAll.add(jPanelHero, new GridBagConstraints(0,0,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,5,5),0,0));
        jPanelAll.add(textVS, new GridBagConstraints(1,0,1,1,0,0,
                GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,
                new Insets(5,5,5,5),0,0));
        jPanelAll.add(jPanelEvil, new GridBagConstraints(2,0,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,5,5,2),0,0));
        jPanelAll.add(jButton, new GridBagConstraints(1,1,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(5,5,0,5),0,0));
        jPanelAll.add(jPanelCube, new GridBagConstraints(0,3,1,1,0,0,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        add(jPanelAll);
        setVisible(true);
        pack();
    }

    @Override
    public void youWin() {
        ClearWindow();
        SizeMyWindow();
        JLabel textVictory = new JLabel("Victory!");
        JPanel jPanelVic = new JPanel(new BorderLayout());

//        String img = getClass().getResource("/images/EndOfBattle/Victory.png").getPath();

        String img = StrPathRes(getClass().getResource("/images/EndOfBattle/Victory.png"));

        MyImage imageVictory = new MyImage(img, 0,0);
        jPanelVic.setPreferredSize(new Dimension(400, 300));
        add(textVictory, BorderLayout.SOUTH);
        jPanelVic.add(imageVictory, BorderLayout.CENTER);
        add(jPanelVic);
        setVisible(true);
        pack();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void youDied() {
        ClearWindow();
        SizeMyWindow();
        JLabel textDead = new JLabel("You Dead!");
        JPanel jPanelDead = new JPanel(new BorderLayout());

//        String img = getClass().getResource("/images/EndOfBattle/Defeat.png").getPath();

        String img = StrPathRes(getClass().getResource("/images/EndOfBattle/Defeat.png"));

        MyImage imageDefeat = new MyImage(img, 0,0);
        jPanelDead.setPreferredSize(new Dimension(400, 300));
        add(textDead, BorderLayout.SOUTH);
        jPanelDead.add(imageDefeat, BorderLayout.CENTER);
        add(jPanelDead);
        setVisible(true);
        pack();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void youRunAway() {
        ClearWindow();
        SizeMyWindow();
        JLabel textRun = new JLabel("You run away!");
        JPanel jPanelRunAway = new JPanel(new BorderLayout());

//        String img = getClass().getResource("/images/EndOfBattle/RunAway.png").getPath();

        String img = StrPathRes(getClass().getResource("/images/EndOfBattle/RunAway.png"));

        MyImage imageRunAway = new MyImage(img, 0,0);
        jPanelRunAway.setPreferredSize(new Dimension(400, 300));
        add(textRun, BorderLayout.SOUTH);
        jPanelRunAway.add(imageRunAway, BorderLayout.CENTER);
        add(jPanelRunAway);
        setVisible(true);
        pack();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gameOver() {
        ClearWindow();
        SizeMyWindow();

        JPanel jPanel = new JPanel(new BorderLayout());

//        String img = getClass().getResource("/images/EndOfBattle/GameOver.png").getPath();

        String img = StrPathRes(getClass().getResource("/images/EndOfBattle/GameOver.png"));

        MyImage image = new MyImage(img, 0,0);
        jPanel.setPreferredSize(new Dimension(480, 480));
        jPanel.add(image, BorderLayout.CENTER);
        add(jPanel);
        setVisible(true);
        pack();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
