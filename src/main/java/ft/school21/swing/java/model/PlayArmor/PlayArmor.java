package ft.school21.swing.java.model.PlayArmor;

import ft.school21.swing.java.model.Repositor.ImpStates;
import ft.school21.swing.java.model.Repositor.States;

public class PlayArmor implements ImpStates {

    private String name;
    private int defense;
    private States states;

    public PlayArmor() {
        states = States.Armor;
    }

    public States getStates() {
        return states;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
