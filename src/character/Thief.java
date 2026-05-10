package character;

public class Thief extends Character {

    int HP = 300;

    public Thief() {

    }
    public Thief(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
