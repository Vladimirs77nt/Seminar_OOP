/** 2. InfantryClass - класс бойцов ближнего боя / пехотинцев (потомок класса BaseHero)
это родительский класс для:
2.1. Robber - класс РАЗБОЙНИКОВ (потомок класса InfantryClass)
2.2. Spearman - класс КОПЕЙЩИКОВ (потомок класса InfantryClass)
*/

package Seminars.Units;

public abstract class InfantryClass extends BaseHero {

    public InfantryClass(int hp, int maxHp, int speed, int damage, int defence, int attack, int team, String name) {
        super(hp, maxHp, speed, damage, defence, attack, team, name);
    }
}