package ft.school21.swing.java.view;

import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.Map;

import java.util.ArrayList;

public class Console implements GameView{

    private Map map;

    public void drawStartMenu()
    {
        System.out.println("| ! GAME SWINGY ! |\n");
    }

    public void ChoicePlayer(ArrayList<GameActions> players)
    {

        System.out.println("--- Choice Player ---");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ") -> " + players.get(i).getName());
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
}
