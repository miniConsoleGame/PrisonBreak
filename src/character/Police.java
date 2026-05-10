package character;

public class Police extends Character {

    public Police() {
        super(300);
    }

    public Police(int HP) {
       this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
