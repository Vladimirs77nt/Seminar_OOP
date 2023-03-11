// КРЕСТЬЯНИН - пока данный класс не имеет промежуточного подкласса, он сразу потомок класса BaseHero

package Seminars.Units;

public class Peasant extends BaseHero implements HeroInterface{

    public Peasant() {
        super(40, 50, 5, 0);
    } 

    @Override
    public String getInfo() {
        return String.format(">> Крестьянин %-9s (id %-3d)  (Hp: %d  Speed: %d,  Damage: %d)",
                super.name, super.id, super.hp, super.speed, super.damage);
    }

    @Override
    public void step() {
        System.out.printf("Крестьянин %s сделал шаг...\n", super.name);
    }
}