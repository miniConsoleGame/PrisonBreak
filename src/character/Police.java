package character;

public class Police extends Character {

    int HP = 300;

    public Police() {
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
