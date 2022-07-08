package ft.school21.swing.java.model;

import ft.school21.swing.java.model.PlayArmor.WolfArmor;
import ft.school21.swing.java.model.PlayHelm.WolfHelm;
import ft.school21.swing.java.model.PlayRaces.Orc;
import ft.school21.swing.java.model.Repositor.Classes;
import ft.school21.swing.java.model.Weapons.Bow;

import java.util.Random;

public class Enemy extends GameActions{
    public Enemy(GameActions enemy)
    {
        setName("Monster");
        setPlayRaces(new Orc());
        setLevel(enemy.getLevel() + (new Random().nextBoolean() ? 1 : 0));
        setHP((int)getLevel() * 50 + 100);
        setAttack(2 * (int)getLevel() + new Random().nextInt(3));
        setPlayClasses(Classes.Berserk);
        setPlayWeapon(new Bow());
        setPlayArmor(new WolfArmor());
        setPlayHelm(new WolfHelm());
    }
}
