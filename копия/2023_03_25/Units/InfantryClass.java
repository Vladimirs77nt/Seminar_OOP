/** 2. InfantryClass - класс бойцов ближнего боя / пехотинцев (потомок класса BaseHero)
это родительский класс для:
2.1. Robber - класс РАЗБОЙНИКОВ (потомок класса InfantryClass)
2.2. Spearman - класс КОПЕЙЩИКОВ (потомок класса InfantryClass)
*/

package Seminars.Game.Units;

public abstract class InfantryClass extends BaseHero {

    public InfantryClass(float hp, float maxHp, int speed, int damage, int damageMax, int defence, int attack, int team,
                        String name, int x, int y) {
        super(hp, maxHp, speed, damage, damageMax, defence, attack, team, name, x, y);
    }

    @Override
    public String getInfo(){
        return super.getInfo() + String.format("\t    ");
    }
}