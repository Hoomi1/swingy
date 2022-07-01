package ft.school21.swing.java.model.PlayRaces;

public class PlayRaces {
    private String playName;
    private int playAttack;
    private int playDefense;
    private int playHP;

    public PlayRaces(){}
    public PlayRaces(String playName, int playAttack, int defense, int playHP) {
        this.playName = playName;
        this.playAttack = playAttack;
        this.playDefense = defense;
        this.playHP = playHP;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public int getPlayAttack() {
        return playAttack;
    }

    public void setPlayAttack(int playAttack) {
        this.playAttack = playAttack;
    }

    public int getDefense() {
        return playDefense;
    }

    public void setDefense(int defense) {
        this.playDefense = defense;
    }

    public int getPlayDefense() {
        return playDefense;
    }

    public void setPlayDefense(int playDefense) {
        this.playDefense = playDefense;
    }

    public int getPlayHP() {
        return playHP;
    }

    public void setPlayHP(int playHP) {
        this.playHP = playHP;
    }
}
