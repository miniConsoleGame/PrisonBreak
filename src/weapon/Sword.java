package weapon;

public class Sword extends Weapon {

    public Sword() {
        super("\uD83D\uDDE1\uFE0F특수 대검",70,10);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
