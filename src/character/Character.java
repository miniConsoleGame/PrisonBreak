package character;

public class Character {

    int HP;

    public void getDamage(){}
    public void getDefense(){}
    public void attack(){}

    public Character() {
    }

    public Character(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
