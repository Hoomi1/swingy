package ft.school21.swing.java.model;

import ft.school21.swing.java.model.PlayRaces.Orc;

import java.util.Random;

public class Enemy extends GameActions{
    public Enemy(GameActions enemy)
    {
        setName("Monster");
        setPlayRaces(new Orc());
        setLevel(enemy.getLevel() + (new Random().nextBoolean() ? 1 : 0));
        setHP((int)getLevel() * 50 + 100);
        setAttack(2 * (int)getLevel() + new Random().nextInt(3));
    }
}
