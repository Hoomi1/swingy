package ft.school21.swing.java.controller;

import ft.school21.swing.java.database.ImplementDB;
import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.PlayRaces.*;
import ft.school21.swing.java.model.Repositor.Classes;

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
}
