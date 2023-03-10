/** 2. InfantryClass - класс бойцов ближнего боя / пехотинцев (потомок класса BaseHero)
это родительский класс для:
2.1. Robber - класс РАЗБОЙНИКОВ (потомок класса InfantryClass)
2.2. Spearman - класс КОПЕЙЩИКОВ (потомок класса InfantryClass)
*/

package Seminars.Units;

public class InfantryClass extends BaseHero {

    protected int power; // физическая СИЛА персонажа

    public InfantryClass(int hp, int maxHp, int speed, int damage, int power) {
        super(hp, maxHp, speed, damage);
        this.power = power;
    }
}