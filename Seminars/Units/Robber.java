// класс РАЗБОЙНИКОВ - потомок класса InfantryClass

package Seminars.Units;

public class Robber extends InfantryClass implements HeroInterface{

    public Robber() {
        super(60, 80, 8, 10, 30);
    }

    @Override
    public String getInfo() {
        return String.format(">> Разбойник %-10s (id %-3d)  (Hp: %d  Speed: %d,  Damage: %d)",
                super.name, super.id, super.hp, super.speed, super.damage);
    }

    @Override
    public void step() {
        System.out.printf("Разбойник %s сделал шаг...\n", super.name);
    }
}