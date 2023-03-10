// класс КОПЕЙЩИКОВ - потомок класса InfantryClass

package Seminars.Units;

public class Spearman extends InfantryClass {

    public Spearman(int hp, int maxHp, int speed, int damage, int power) {
        super(hp, maxHp, speed, damage, power);
    }

    public Spearman() {
        super(70, 100, 5, 15, 5);
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