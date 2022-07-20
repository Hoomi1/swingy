package ft.school21.swing.java;

import ft.school21.swing.java.controller.Controller;
import ft.school21.swing.java.database.Heroes;
import ft.school21.swing.java.database.ImplementDB;
import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;
import ft.school21.swing.java.model.PlayArmor.RagsArmor;
import ft.school21.swing.java.model.PlayHelm.RagsHelm;
import ft.school21.swing.java.model.Repositor.Classes;
import ft.school21.swing.java.model.Weapons.Bow;
import ft.school21.swing.java.view.ChoiceGame;
import ft.school21.swing.java.view.Console;
import ft.school21.swing.java.view.GameView;
import ft.school21.swing.java.view.Gui;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class StartGame {

    private static ChoiceGame choiceGame;
//    private static SessionFactory sessionFactory = null;
    public static String commandGui;

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
        ArrayList<GameActions> players = null;
//        try {
//            sessionFactory = ImplementDB.getImplementDB().getFactory();
            players = ImplementDB.getImplementDB().getAllHeroesDB();
//        }
//        finally {
//            sessionFactory.close();
//        }
        choiceGame.getView().drawStartMenu();
//        while (true) {
//            if (Main.flagGui)
//                break;
//        }
        Inf();
        Main.flagGui = false;
        choiceGame.getView().ChoicePlayer(players);
        Inf();
        if (Main.flagGui == false) {
            Scanner scanner = new Scanner(System.in);
            GameActions newPl = CommandScanner(scanner.nextLine().toLowerCase(), players);
            if (newPl != null) {
                WorkMap(newPl);
            }
            scanner.close();
        }
        else
        {
            GameActions newPl = CommandScanner(commandGui, players);
            if (newPl != null) {
                WorkMap(newPl);
            }
        }
    }

    private static void Inf()
    {
        while (true) {
            if (Main.flagGui)
                break;
        }
    }

    private static void WorkMap(GameActions players) {
        Map map = new Map(players);
        Controller controller = new Controller();
        while (true)
        {
            int posx = players.getPosX();
            int posy = players.getPosY();
            if (players.getLevel() >= 5)
            {
                choiceGame.getView().gameOver();
                System.exit(0);
            }
            choiceGame.getView().ShowMap(map, players);
            if (controller.MovePlayer(players, map))
            {
                if (map.getMapSymbol(players.getPosY(), players.getPosX()) == 'E')
                {
                    if (controller.ChoiceBattle(choiceGame))
                    {
                        choiceGame.getView().WindowBattle();
                        if (controller.RandomBattle(map, players, choiceGame))
                        {
                            choiceGame.getView().youWin();
                            map.setMapSymbol(players.getPosY(), players.getPosX(), '\u00b7');
                        }
                        else
                        {
                            choiceGame.getView().youDied();
                            ImplementDB.getImplementDB().DeleteHero(players.getId());
                            System.exit(-1);
                        }
                    }
                    else
                    {
                        choiceGame.getView().youRunAway();
                        players.setPosX(posx);
                        players.setPosY(posy);
                    }
                }
            }
        }
    }

    public static GameActions CommandScanner(String command, ArrayList<GameActions> players)
    {
        Controller controller = new Controller();
        if (command.equals("a"))
        {
            GameActions pl = new GameActions();
            Long max;
            try {
                max = players.get(0).getId();
                for (int i = 1; i < players.size(); ++i)
                {
                    if (max <  players.get(i).getId())
                        max = players.get(i).getId();
                }
                pl.setId(max + 1);
            }
            catch (IndexOutOfBoundsException e)
            {
                max = 1L;
                pl.setId(max);
            }
            Main.flagGui = false;
            choiceGame.getView().CreateNamePlayer();
            Inf();
            controller.EnterName(pl);
            Main.flagGui = false;
            choiceGame.getView().ChoiceRace();
            Inf();
            controller.EnterRace(pl);
            Main.flagGui = false;
            choiceGame.getView().ChoiceClass();
            Inf();
            controller.EnterClass(pl);
            Main.flagGui = false;
            pl.setPlayWeapon(new Bow());
            pl.setPlayArmor(new RagsArmor());
            pl.setPlayHelm(new RagsHelm());
            pl.setAttack(pl.getAttack());
            ImplementDB.getImplementDB().AddHeroDB(ParseActions(pl));
            return pl;
        }
        else if (command.equals("b"))
        {
            choiceGame.getView().ChoiceDeletePlayer();
            controller.DeletePlayer();
        }
        else
        {
            try {
                int comInt = Integer.parseInt(command);
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getId() == comInt)
                    {
                        choiceGame.getView().DataPlayer(players.get(i));
                        return players.get(i);
                    }
                }
                System.exit(1);
            }
            catch (NumberFormatException e)
            {
                System.exit(1);
            }
        }
        return null;
    }

    public static Heroes ParseActions(GameActions player)
    {
        Heroes heroes = new Heroes();
        heroes.setId(player.getId());
        switch (player.getPlayRaces().getPlayName().toLowerCase())
        {
            case "darkelf":
                heroes.setRace("DarkElf");
                heroes.setAttack(player.getAttack() + player.getPlayRaces().getPlayAttack());
                heroes.setHit_points(player.getHP());
                heroes.setDefense(player.getPlayRaces().getDefense());
                break;
            case "dwarf":
                heroes.setRace("Dwarf");
                heroes.setAttack(player.getAttack() + player.getPlayRaces().getPlayAttack());
                heroes.setHit_points(player.getHP());
                heroes.setDefense(player.getPlayRaces().getDefense());
                break;
            case "elf":
                heroes.setRace("Elf");
                heroes.setAttack(player.getAttack() + player.getPlayRaces().getPlayAttack());
                heroes.setHit_points(player.getHP());
                heroes.setDefense(player.getPlayRaces().getDefense());
                break;
            case "human":
                heroes.setRace("Human");
                heroes.setAttack(player.getAttack() + player.getPlayRaces().getPlayAttack());
                heroes.setHit_points(player.getHP());
                heroes.setDefense(player.getPlayRaces().getDefense());
                break;
            case "orc":
                heroes.setRace("Orc");
                heroes.setAttack(player.getAttack() + player.getPlayRaces().getPlayAttack());
                heroes.setHit_points(player.getHP());
                heroes.setDefense(player.getPlayRaces().getDefense());
                break;
        }
        heroes.setName(player.getName());
        if (player.getPlayClasses().equals(Classes.Berserk))
            heroes.setClas("Berserk");
        else if (player.getPlayClasses().equals(Classes.Necromancer))
            heroes.setClas("Necromancer");
        else if (player.getPlayClasses().equals(Classes.Warrior))
            heroes.setClas("Warrior");
        else if (player.getPlayClasses().equals(Classes.Wizard))
            heroes.setClas("Wizard");
        heroes.setLevel(player.getLevel());
        heroes.setExperience(player.getExperience());
        if (!player.getPlayWeapon().getWeaponName().isEmpty()) {
            heroes.setWeapon(player.getPlayWeapon().getWeaponName());
            heroes.setAttack(heroes.getAttack() + player.getPlayWeapon().getWeaponAttack());
        }
        if (!player.getPlayArmor().getName().isEmpty()) {
            heroes.setArmor(player.getPlayArmor().getName());
            heroes.setDefense(heroes.getDefense() + player.getPlayArmor().getDefense());
        }
        if (!player.getPlayHelm().getName().isEmpty()) {
            heroes.setHelm(player.getPlayHelm().getName());
            heroes.setHit_points(heroes.getHit_points() + player.getPlayHelm().getStatesHP());
        }
        return heroes;
    }
}
