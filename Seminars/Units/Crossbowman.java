// Класс АРБАЛЕТЧИК - потомок класса ShooterClass

package Seminars.Units;

public class Crossbowman extends ShooterClass {

    public Crossbowman(int hp, int maxHp, int speed, int damage, int arrows, int accuracy) {
        super(hp, maxHp, speed, damage, arrows, accuracy);
    }

    public Crossbowman() {
        super(50, 60, 5, 12, 34, 60);
    }

    /**
     * Атака арбалетчиком - стрелы
     * @param target
     */
    public void Attack(BaseHero target) {
        int damage = BaseHero.r.nextInt(10, 20);
        target.GetDamage(damage);
    }
}