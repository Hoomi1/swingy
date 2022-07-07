package ft.school21.swing.java.controller;

import ft.school21.swing.java.database.ImplementDB;
import ft.school21.swing.java.model.Enemy;
import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;
import ft.school21.swing.java.model.PlayRaces.*;
import ft.school21.swing.java.model.Repositor.Classes;
import ft.school21.swing.java.view.ChoiceGame;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    public static Scanner scanner = new Scanner(System.in);
    public void EnterClass(GameActions newPlayer)
    {
        int classPl = scanner.nextInt();
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
        newPlayer.setName(scanner.next());
        scanner.nextLine();
    }

    public void EnterRace(GameActions newPlayer)
    {
        int racePl = scanner.nextInt();
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
        Long iterPlayer = scanner.nextLong();
        ImplementDB.getImplementDB().DeleteHero(iterPlayer);
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
        else
            return false;
        return true;
    }

    public boolean ChoiceBattle(Map map, GameActions player, ChoiceGame choiceGame)
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

    public boolean RandomBattle(Map map, GameActions player, ChoiceGame choiceGame) {
        Random random = new Random();
        int i = random.nextInt(6) + 1;
        Enemy enemy = new Enemy(player);

        while (true)
        {
            choiceGame.getView().RandomCube(i);
            if (i == 1 || i == 2 || i == 3 || i == 4)
                player.Attack(enemy);
            else
                enemy.Attack(player);
            if (player.getHP() == 0)
                return false;
            else if (enemy.getHP() == 0)
            {
                return true;
            }
        }
    }
}
