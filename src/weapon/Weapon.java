package weapon;

public class Weapon {
    String name;
    int damage;
    int defense;

    public Weapon(String name, int damage, int defense) {
        this.name = name;
        this.damage = damage;
        this.defense = defense;
    }

    public Weapon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return  "무기명='" + name + '\'' +
                ", 공격력=" + damage +
                ", 방어력=" + defense;
    }
}
