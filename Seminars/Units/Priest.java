// класс МОНАХ - потомок класса MagicClass

package Seminars.Units;

public class Priest extends MagicClass implements HeroInterface{

    public Priest() {
        super(55, 70, 6, 6, 20);
    }

    @Override
    public String getInfo() {
        return String.format(">> Монах %-14s (id %-3d)  (Hp: %d  Speed: %d,  Damage: %d)",
                super.name, super.id, super.hp, super.speed, super.damage);
    }

    @Override
    public void step() {
        System.out.printf("Монах %s сделал шаг...\n", super.name);
    }
}