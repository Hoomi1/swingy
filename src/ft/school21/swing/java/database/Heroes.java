package ft.school21.swing.java.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "heroes")
public class Heroes {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "clas")
    private String clas;

    @Column(name = "level")
    private Double level;

    @Column(name = "experience")
    private Double experience;

    @Column(name = "attack")
    private int attack;

    @Column(name = "defense")
    private int defense;

    @Column(name = "hit_points")
    private int hit_points;

    @Column(name = "weapon")
    private String weapon;

    @Column(name = "armor")
    private String armor;

    @Column(name = "helm")
    private String helm;

    public Heroes() {
    }

    public Heroes(String name, String clas, Double level, Double experience, int attack,
                  int defense, int hit_points, String weapon, String armor, String helm) {
        this.name = name;
        this.clas = clas;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defense = defense;
        this.hit_points = hit_points;
        this.weapon = weapon;
        this.armor = armor;
        this.helm = helm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getHelm() {
        return helm;
    }

    public void setHelm(String helm) {
        this.helm = helm;
    }

    @Override
    public String toString() {
        return "Heroes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clas='" + clas + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", attack=" + attack +
                ", defense=" + defense +
                ", hit_points=" + hit_points +
                ", weapon='" + weapon + '\'' +
                ", armor='" + armor + '\'' +
                ", helm='" + helm + '\'' +
                '}';
    }
}
