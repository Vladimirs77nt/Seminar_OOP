/**
* 3. ShooterClass - класс бойцов дальнего боя / стрелков (потомок класса BaseHero)
это родительский класс для:
3.1. Sniper - класс СНАЙПЕРОВ (потомок класса ShooterClass)
3.2. Crossbowman - класс АРБАЛЕТЧИКОВ (потомок класса ShooterClass)
*/

package Seminars.Units;

import java.util.ArrayList;

public abstract class ShooterClass extends BaseHero {

    protected int arrows; // количество стрел

    public ShooterClass(float hp, float maxHp, int speed, int damage, int damageMax, int defence, int attack, int arrows, int team,
                        String name, int x, int y) {
        super(hp, maxHp, speed, damage, damageMax, defence, attack, team, name, x, y);
        this.arrows = arrows;
    }

    protected int getArrows() {
        return this.arrows;
    }
    
    @Override
    public void step(ArrayList<BaseHero> teamArray) {
        if (hp<=0) Die();
        else if (arrows>0) {
            System.out.printf("%s к выстрелу готов ! у меня %d стрел!\n", className(this), arrows);
            int opponentIndex = nearestIndexEnemy(teamArray);
            if (opponentIndex<0) this.setGameOver(team);
            else {
                BaseHero opponent = teamArray.get(opponentIndex);
                System.out.printf(">  Я выбрал цель! -> %s", className(opponent));
                System.out.printf("  (расстояние до цели: %d)\n", (int)position.getDistance(opponent));
                System.out.print(">  Выстрелил ! ");
                this.attack(opponent);
                int indexPeasant  = mineIndexPeasant(teamArray);
                if (indexPeasant<0) {
                    arrows -= 1;
                    System.out.println(">  У меня запас стрел уменьшился на одну...");
                }
                opponentIndex = nearestIndexEnemy(teamArray);
                if (opponentIndex<0) this.setGameOver(team);
            }
        }
        else 
            System.out.printf("%s стрелять не могу... У меня закончились стрелы!\n", className(this));
    }

    /**
     * Метод поиска индекса крестьянина из своей команды
     * @param teamArray
     * @return индекс крестьянина, если нет то будет -1
     */
    protected int mineIndexPeasant(ArrayList<BaseHero> teamArray){
        for (int i = 0; i < teamArray.size(); i++) {
            // если: 1) герой из своей команды, 2) это крестьянин, 3) он живой
            if (teamArray.get(i).getTeam() == team && teamArray.get(i).getClassHero().equals("Крестьянин") && teamArray.get(i).getHp()>0)
                return i;
        }
        System.out.println(" ... т.к. все крестьяне убиты, запас стрел будет уменьшаться");
        return -1;
    }
}