package ft.school21.swing.java.model.Weapons;

import ft.school21.swing.java.model.Repositor.ImpStates;
import ft.school21.swing.java.model.Repositor.States;

public class PlayWeapon implements ImpStates {
    private String weaponName;
    private int weaponAttack;
    private States states;

    public PlayWeapon() {
        states = States.Weapon;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponAttack() {
        return weaponAttack;
    }

    public void setWeaponAttack(int weaponAttack) {
        this.weaponAttack = weaponAttack;
    }

    public States getStates() {
        return states;
    }
}
