package weapon;

public class Shield extends Weapon {

    public Shield() {
        super("\uD83D\uDEE1\uFE0F방패",30,70);
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
