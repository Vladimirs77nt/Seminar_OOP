// класс КОПЕЙЩИКОВ - потомок класса InfantryClass

package Seminars.Units;

public class Spearman extends InfantryClass implements HeroInterface{

    public Spearman() {
        super(70, 100, 6, 15, 20);
    }

    @Override
    public String getInfo() {
        return String.format(">> Копейщик %-11s (id %-3d)  (Hp: %d  Speed: %d,  Damage: %d)",
                super.name, super.id, super.hp, super.speed, super.damage);
    }

    @Override
    public void step() {
        System.out.printf("Копейщик %s сделал шаг...\n", super.name);
    }
}