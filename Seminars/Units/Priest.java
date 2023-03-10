// класс МОНАХ - потомок класса MagicClass

package Seminars.Units;

public class Priest extends MagicClass {

    public Priest(int hp, int maxHp, int speed, int damage, int magicPower) {
        super(hp, maxHp, speed, damage, magicPower);
    }

    public Priest() {
        super(55, 70, 6, 6, 20);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}