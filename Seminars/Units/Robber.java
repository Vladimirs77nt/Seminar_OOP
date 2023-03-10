// класс РАЗБОЙНИКОВ - потомок класса InfantryClass

package Seminars.Units;

public class Robber extends InfantryClass {

    public Robber(int hp, int maxHp, int speed, int damage, int power) {
        super(hp, maxHp, speed, damage, power);
    }

    public Robber() {
        super(60, 80, 7, 10, 7);
    }

    /**
     * Атака копьем!
     * @param target
     */
    public void Attack(BaseHero target) {
        int damage = BaseHero.r.nextInt(10, 20);
        target.GetDamage(damage);
    }
}