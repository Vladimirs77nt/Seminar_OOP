/**
* 3. ShooterClass - класс бойцов дальнего боя / стрелков (потомок класса BaseHero)
это родительский класс для:
3.1. Sniper - класс СНАЙПЕРОВ (потомок класса ShooterClass)
3.2. Crossbowman - класс АРБАЛЕТЧИКОВ (потомок класса ShooterClass)
*/

package Seminars.Units;

public class ShooterClass extends BaseHero {

    protected int arrows; // количество стрел
    protected int accuracy; // меткость

    public ShooterClass(int hp, int maxHp, int speed, int damage, int arrows, int accuracy) {
        super(hp, maxHp, speed, damage);
        this.arrows = arrows;
        this.accuracy = accuracy;
    }
}