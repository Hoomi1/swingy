package ft.school21.swing.java.controller;

import ft.school21.swing.java.Main;
import ft.school21.swing.java.database.ImplementDB;
import ft.school21.swing.java.model.Enemy;
import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;
import ft.school21.swing.java.model.PlayArmor.DarkArmor;
import ft.school21.swing.java.model.PlayArmor.DragonScaleArmor;
import ft.school21.swing.java.model.PlayArmor.RagsArmor;
import ft.school21.swing.java.model.PlayArmor.WolfArmor;
import ft.school21.swing.java.model.PlayHelm.DarkHelm;
import ft.school21.swing.java.model.PlayHelm.DragonScaleHelm;
import ft.school21.swing.java.model.PlayHelm.RagsHelm;
import ft.school21.swing.java.model.PlayHelm.WolfHelm;
import ft.school21.swing.java.model.PlayRaces.*;
import ft.school21.swing.java.model.Repositor.Classes;
import ft.school21.swing.java.model.Weapons.*;
import ft.school21.swing.java.view.ChoiceGame;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    public static Scanner scanner = new Scanner(System.in);
    public static Long idDel;
    public static Long idPlayer;
    public static String createName;
    public static int createRace;
    public static int createClass;

    public void EnterClass(GameActions newPlayer)
    {
        int classPl;
        if (!Main.flagGui)
            classPl = scanner.nextInt();
        else
            classPl = Controller.createClass;
        switch (classPl)
        {
            case 1:
                newPlayer.setPlayClasses(Classes.Warrior);
                break;
            case 2:
                newPlayer.setPlayClasses(Classes.Wizard);
                break;
            case 3:
                newPlayer.setPlayClasses(Classes.Berserk);
                break;
            case 4:
                newPlayer.setPlayClasses(Classes.Necromancer);
                break;
        }
    }

    public void EnterName(GameActions newPlayer)
    {
        if (!Main.flagGui) {
            newPlayer.setName(scanner.next());
            scanner.nextLine();
        }
        else {
            newPlayer.setName(createName);
            Main.flagGui = false;
        }
    }

    public void EnterRace(GameActions newPlayer)
    {
        int racePl = 0;
        if (!Main.flagGui)
            racePl = scanner.nextInt();
        else
            racePl = Controller.createRace;
        switch (racePl)
        {
            case 1:
                newPlayer.setPlayRaces(new DarkElf());
                break;
            case 2:
                newPlayer.setPlayRaces(new Dwarf());
                break;
            case 3:
                newPlayer.setPlayRaces(new Elf());
                break;
            case 4:
                newPlayer.setPlayRaces(new Human());
                break;
            case 5:
                newPlayer.setPlayRaces(new Orc());
                break;
        }
    }

    public void DeletePlayer()
    {
        if (Main.flagGui != true)
        {
            Long iterPlayer = scanner.nextLong();
            ImplementDB.getImplementDB().DeleteHero(iterPlayer);
        }
        else {
            ImplementDB.getImplementDB().DeleteHero(Controller.idDel);
        }
    }

    public boolean MovePlayer(GameActions player, Map map)
    {
        String command = scanner.nextLine();
        if (command.toLowerCase().equals("a")) // left
        {
            player.MinusPositionX(map);
        }
        else if (command.toLowerCase().equals("d")) // right
        {
            player.PlusPositionX(map);
        }
        else if (command.toLowerCase().equals("w")) // up
        {
            player.MinusPositionY(map);
        }
        else if (command.toLowerCase().equals("s")) // down
        {
            player.PlusPositionY(map);
        }
        else if (command.toLowerCase().equals("i"))
        {
            System.out.println(player.toString());
        }
        else
            return false;
        return true;
    }

    public boolean ChoiceBattle(ChoiceGame choiceGame)
    {
        choiceGame.getView().StartBattle();
        String command = scanner.nextLine();
        if (command.toLowerCase().equals("y"))
        {
            return true;
        }
        else if (command.toLowerCase().equals("n")) {
            return new Random().nextBoolean();
        }
        return true;
    }

    private void RandomChoice(int i, char c, GameActions player)
    {
        if (c == 'w')
        {
            switch (i)
            {
                case 1:
                    player.setPlayWeapon(new Bow());
                    break;
                case 2:
                    player.setPlayWeapon(new Mace());
                    break;
                case 3:
                    player.setPlayWeapon(new MagicWand());
                    break;
                case 4:
                    player.setPlayWeapon(new Staff());
                    break;
                case 5:
                    player.setPlayWeapon(new Sword());
                    break;
            }
        }
        else if (c == 'h')
        {
            switch (i)
            {
                case 1:
                    player.setPlayHelm(new DarkHelm());
                    break;
                case 2:
                    player.setPlayHelm(new DragonScaleHelm());
                    break;
                case 3:
                    player.setPlayHelm(new RagsHelm());
                    break;
                case 4:
                    player.setPlayHelm(new WolfHelm());
                    break;
            }
        }
        else
        {
            switch (i)
            {
                case 1:
                    player.setPlayArmor(new DarkArmor());
                    break;
                case 2:
                    player.setPlayArmor(new DragonScaleArmor());
                    break;
                case 3:
                    player.setPlayArmor(new RagsArmor());
                    break;
                case 4:
                    player.setPlayArmor(new WolfArmor());
                    break;
            }
        }
    }
    private void RandomChoiceArtifact(GameActions player)
    {
        Random random = new Random();
        int rand = random.nextInt(4) + 1;
        if (rand == 2)
        {
            int randWeapon = random.nextInt(5) + 1;
            RandomChoice(randWeapon, 'w', player);
        }
        else if (rand == 3)
        {
            int randHelm = random.nextInt(4) + 1;
            RandomChoice(randHelm, 'h', player);
        }
        else if (rand == 4)
        {
            int randWeapon = random.nextInt(4) + 1;
            RandomChoice(randWeapon, 'a', player);
        }
    }

    public boolean RandomBattle(Map map, GameActions player, ChoiceGame choiceGame) {
        Random random = new Random();
        Enemy enemy = new Enemy(player);

        while (true)
        {
            int i = random.nextInt(6) + 1;
            choiceGame.getView().RandomCube(i);
            if (i == 1 || i == 2 || i == 3 || i == 4)
                player.Attack(enemy);
            else
                enemy.Attack(player);
            if (player.getHP() == 0)
                return false;
            else if (enemy.getHP() == 0)
            {
                player.setHP(player.getMaxHP());
                player.setExperience(player.getExperience() + enemy.getLevel() * 342 + 1021);
                player.LevelMap(map);
                RandomChoiceArtifact(player);
                ImplementDB.getImplementDB().UpdateHeroDB(player);
                return true;
            }
        }
    }
}
