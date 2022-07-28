package ft.school21.swing.java.model.PlayHelm;

import ft.school21.swing.java.model.Repositor.ImpStates;
import ft.school21.swing.java.model.Repositor.States;

public class PlayHelm implements ImpStates {

    private String name;
    private int statesHP;
    private States states;

    public PlayHelm() {
        states = States.Helm;
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

    public int getStatesHP() {
        return statesHP;
    }

    public void setStatesHP(int statesHP) {
        this.statesHP = statesHP;
    }
}
