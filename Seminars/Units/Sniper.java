// класс СНАЙПЕРОВ - потомок класса ShooterClass

package Seminars.Units;

public class Sniper extends ShooterClass implements HeroInterface{

    public Sniper() {
        super(60, 80, 8, 15, 38, 9);
    } 

    @Override
    public String getInfo() {
        return String.format(">> Снайпер %-12s (id %-3d)  (Hp: %d  Speed: %d,  Damage: %d)",
                super.name, super.id, super.hp, super.speed, super.damage);
    }

    @Override
    public void step() {
        System.out.printf("Снайпер %s сделал шаг...\n", super.name);
    }
}