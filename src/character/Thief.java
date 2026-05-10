package character;

public class Thief extends Character {

    public Thief() {
        super(300);
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
