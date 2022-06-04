package ft.school21.swing.java.model;

import ft.school21.swing.java.model.PlayArmor.PlayArmor;
import ft.school21.swing.java.model.PlayClasses.PlayClasses;
import ft.school21.swing.java.model.PlayHelm.PlayHelm;
import ft.school21.swing.java.model.PlayRaces.PlayRaces;
import ft.school21.swing.java.model.Weapons.PlayWeapon;

import java.util.Random;

public class GameActions {
    private int         posX;
    private int         posY;
    private int         newPosX;
    private int         newPosY;
    private Random      random;
    private String      name;
    private double      level;
    private int         attack;
    private PlayRaces   playRaces;
    private PlayClasses playClasses;
    private PlayArmor   playArmor;
    private PlayHelm    playHelm;
    private PlayWeapon  playWeapon;

    public GameActions() {
    }

    public void InitStartPos(Map map)
    {
        this.posX = map.getMapSize() / 2;
        this.posY = map.getMapSize() / 2;
    }

    private boolean ValidPosition(int pos, Map map)
    {
        return (pos >= 0 && pos < map.getMapSize());
    }

    public void PlusPositionX(Map map)
    {
        if (ValidPosition(posX + 1, map))
        {
            newPosX = posX;
            newPosY = posY;
            posX++;
        }
    }

    public void PlusPositionY(Map map)
    {
        if (ValidPosition(posY + 1, map))
        {
            newPosX = posX;
            newPosY = posY;
            posY++;
        }
    }

    public void MinusPositionX(Map map)
    {
        if (ValidPosition(posX - 1, map))
        {
            newPosX = posX;
            newPosY = posY;
            posX--;
        }
    }

    public void MinusPositionY(Map map)
    {
        if (ValidPosition(posY - 1, map))
        {
            newPosX = posX;
            newPosY = posY;
            posY--;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
