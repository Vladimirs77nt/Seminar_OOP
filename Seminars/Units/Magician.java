/** Magician - класс МАГОВ (потомок MagClass) */

package Seminars.Units;

public class Magician extends MagicClass {

    public Magician(int hp, int maxHp, int speed, int damage, int magicPower) {
        super(hp, maxHp, speed, damage, magicPower);
    }

    public Magician() {
        super(45, 60, 5, 8, 18);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}