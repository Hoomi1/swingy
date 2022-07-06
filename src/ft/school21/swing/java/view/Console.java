package ft.school21.swing.java.view;

import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;

import java.util.ArrayList;

public class Console implements GameView{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public void drawStartMenu()
    {
        System.out.println("| ! GAME SWINGY ! |\n");
    }

    public void ChoicePlayer(ArrayList<GameActions> players)
    {

        System.out.println("--- Choice Player ---");
        System.out.println("|ID\t|NAME |");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("|" + players.get(i).getId() + ") -> " + players.get(i).getName() + "|");
        }
        System.out.println("\n--- Setup ---");
        System.out.println("a) -> " + "Create a hero");
        System.out.println("b) -> " + "Delete a hero");
    }

    @Override
    public void ChoiceRace() {
        System.out.println("--- Choice Race ---");
        System.out.println
                (
                        "1) DarkElf\t" + "2) Dwarf\t" + "3) Elf    \t" + "4) Human\t" + "5) Orc" +
                        "\nAttack=15;\t" + "Attack=15;\t" + "Attack=15;\t" + "Attack=15;\t" + "Attack=15;\t" +
                        "\nDefense=2;\t" + "Defense=2;\t" + "Defense=2;\t" + "Defense=2;\t" + "Defense=2;\t" +
                        "\nHP=40.   \t" + "HP=40.    \t" + "HP=40.  \t" + "HP=40.  \t" + "HP=40.  \t"
                );
    }

    @Override
    public void ChoiceClass() {
        System.out.println("--- Choice Class ---");
        System.out.println("1) Warrior" + "\n2) Wizard" + "\n3) Berserk" + "\n4) Necromancer");
    }

    @Override
    public void CreateNamePlayer() {
        System.out.println("--- Create Name Player ---");
    }

    @Override
    public void ChoiceDeletePlayer() {
        System.out.println("--- Enter ID Hero ---");
    }

    @Override
    public void DataPlayer(GameActions players) {
        System.out.println(players.toString());
    }

    @Override
    public void ShowMap(Map map, GameActions players) {
        System.out.println(ANSI_YELLOW);
//        System.out.print("⌈");
//        System.out.println();
        System.out.print("*");
        for(int i = 0; i < map.getMapSize() * 2; ++i) {
//            System.out.print("\u2015");//-
            System.out.print("*");
        }
        System.out.println("*");
        for (int i = 0; i < map.getMapSize(); i++) {
            System.out.print("*");
            for (int j = 0; j < map.getMapSize(); ++j) {
                if (players.getPosX() == j && players.getPosY() == i)
                    ColorHero();
                else
                    ObstacleEnemies(map, i, j);
//                    System.out.print(map.getMapSymbol(i, j) + " ");
            }
            System.out.print("*\n");
        }
        System.out.print("*");
        for(int i = 0; i < map.getMapSize() * 2; ++i) {
//            System.out.print("\u2015");//-
            System.out.print("*");
        }
        System.out.println("*");
        InfoConsole();
    }

    public void InfoConsole()
    {
        System.out.println(ANSI_PURPLE);
        System.out.println("left\t-> a");
        System.out.println("right\t-> d");
        System.out.println("up\t\t-> w");
        System.out.println("down\t-> s");
        System.out.println(ANSI_RESET);
    }

    private void ColorHero()
    {
        System.out.print(ANSI_GREEN);
        System.out.print("H ");
        System.out.print(ANSI_YELLOW);
    }

    private void ObstacleEnemies(Map map, int i, int j)
    {
        if (map.getMapSymbol(i, j) == 'E')
        {
            System.out.print(ANSI_RED);
            System.out.print(map.getMapSymbol(i, j) + " ");
            System.out.print(ANSI_YELLOW);
        }
        else if (map.getMapSymbol(i, j) == 'O')
        {
            System.out.print(ANSI_CYAN);
            System.out.print(map.getMapSymbol(i, j) + " ");
            System.out.print(ANSI_YELLOW);
        }
        else
            System.out.print(map.getMapSymbol(i, j) + " ");
    }
}
