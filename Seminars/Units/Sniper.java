// класс СНАЙПЕРОВ - потомок класса ShooterClass

package Seminars.Units;

public class Sniper extends ShooterClass {

    public Sniper(int hp, int maxHp, int speed, int damage, int arrows, int accuracy) {
        super(hp, maxHp, speed, damage, arrows, accuracy);
    } 

    public Sniper() {
        super(60, 80, 7, 10, 25, 90);
    } 

    /**
     * Атака снайпером - стрелы
     * @param target
     */
    public void Attack(BaseHero target) {
        int damage = BaseHero.r.nextInt(10, 20);
        target.GetDamage(damage);
    }
}