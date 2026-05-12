package weapon;

public class Taser extends Weapon {

    public Taser() {
        super("⚡ 테이저건",55,25);
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
