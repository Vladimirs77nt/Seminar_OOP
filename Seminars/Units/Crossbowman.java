// Класс АРБАЛЕТЧИК - потомок класса ShooterClass

package Seminars.Units;

public class Crossbowman extends ShooterClass implements HeroInterface{

    public Crossbowman() {
        super(60, 80, 6, 25, 25, 7);
    }

    @Override
    public String getInfo() {
        return String.format(">> Арбалетчик %-9s (id %-3d)  (Hp: %d  Speed: %d,  Damage: %d)",
                super.name, super.id, super.hp, super.speed, super.damage);
    }

    @Override
    public void step() {
        System.out.printf("Арбалетчик %s сделал шаг...\n", super.name);
    }
}