/**
* 3. ShooterClass - класс бойцов дальнего боя / стрелков (потомок класса BaseHero)
это родительский класс для:
3.1. Sniper - класс СНАЙПЕРОВ (потомок класса ShooterClass)
3.2. Crossbowman - класс АРБАЛЕТЧИКОВ (потомок класса ShooterClass)

сравнение АРБАЛЕТЧИКА и СНАЙПЕРА:
    1) арбалетчик менее точен (7), чем снайпер (9) / accuracy
    2) у арбалетчика меньше стрел (24), чем у снайпера (38) / arrows
    3) урон арбалетчика больше (25), чем у снайпера (15) / damage
    4) арбалетчик двигается медленее (6), чем снайпер (8) / speed
*/

package Seminars.Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class ShooterClass extends BaseHero {

    protected int arrows; // количество стрел
    protected int accuracy; // меткость (от 1 до 10) 10 - снайпер

    public ShooterClass(int hp, int maxHp, int speed, int damage, int defence, int attack, int arrows, int team, String name) {
        super(hp, maxHp, speed, damage, defence, attack, team, name);
        this.arrows = arrows;
    }

    public int getArrows() {
        return arrows;
    }
    
    @Override
    public void step(ArrayList<BaseHero> teamArray) {
        int teamOpponent = 1;
        if (this.team == 1) teamOpponent = 2;
        if (hp<=0) Die();
        else if (arrows>0) {
            System.out.printf("%s к выстрелу готов !\n", className(this));
            int opponentIndex = opponentRandomIndex(teamArray, teamOpponent);
            BaseHero opponent = teamArray.get(opponentIndex);
            System.out.printf(">  Я выбрал цель! -> %s\n", className(opponent));
            int damageOpponent = new Random().nextInt(10, 20);
            opponent.GetDamage(damageOpponent);
            System.out.println(">  Выстрелил !!! Нанес урон: " + damageOpponent);
            teamArray.set(opponentIndex, opponent);
            System.out.println();
        }
    }
}