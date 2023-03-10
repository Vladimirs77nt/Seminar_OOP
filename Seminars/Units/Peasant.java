// КРЕСТЬЯНИН - потомок класса работников WORKER

package Seminars.Units;

public class Peasant  extends BaseHero {

    public Peasant(int hp, int maxHp, int speed, int damage) {
        super(hp, maxHp, speed, damage);
    } 

    public Peasant() {
        super(50, 50, 5, 0);
    } 

    // методы выполнения какой-то работы
    public void Work() {
        int work = BaseHero.r.nextInt(1, 10);
    }
}