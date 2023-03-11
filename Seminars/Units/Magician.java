/** Magician - класс МАГОВ (потомок MagClass) */

package Seminars.Units;

public class Magician extends MagicClass implements HeroInterface{

    public Magician() {
        super(45, 60, 5, 8, 18);
    }

    @Override
    public String getInfo() {
        return String.format(">> Маг %-16s (id %-3d)  (Hp: %d  Speed: %d,  Damage: %d)",
                super.name, super.id, super.hp, super.speed, super.damage);
    }

    @Override
    public void step() {
        System.out.printf("Маг %s сделал шаг...\n", super.name);
    }
}