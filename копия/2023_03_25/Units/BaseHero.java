/** BaseHero - БАЗОВЫЙ класс героя

это родительский класс для обобщенных классов:
1. MagicClacc - класс магических героев / МАГИ, МОНАХИ...
2. InfantryClass - класс бойцов ближнего боя / пехотинцев = КОПЕЙЩИКИ, РАЗБОЙНИКИ...
3. ShooterClass - класс бойцов дальнего боя / стрелков = СНАЙПЕРЫ, АРБАЛЕТЧИКИ...
*/

package Seminars.Game.Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero {

    protected static int number = 0;

    // базовые характеристики ЛЮБЫХ (всех) героев
    protected String name;  // - имя героя
    protected int id;       // - id номер героя
    protected int team;     // - номер команды героя
    protected int team_enemy;     // - номер команды ПРОТИВНИКОВ
    public float hp;       // - здоровье текущее
    protected float maxHp;    // - максимальный уровень здоровья
    protected int speed;    // - скорость передвижения
    protected int damage;   // - наносимый урон
    protected int damageMax;   // - наносимый Максимальный урон
    protected int defence;  // - защита
    protected int attaсk;   // - уровень атаки
    protected Position position; // - координаты героя
    protected int gameover; // - - победы пока нет, или номер победившей команды!!!
    
    /**
     * Конструктор для базового шаблона героя
     * @param hp - текущее здоровье
     * @param maxHp - максимальное здоровье
     * @param speed - скорость
     * @param damage - уровень урона
     * @param damageMax - уровень максимального урона
     * @param defence - уровень защиты
     * @param attack - уровень атаки
     * @param team - номер команды
     * @param name - имя героя
     */
    protected BaseHero(float hp, float maxHp, int speed, int damage, int damageMax, int defence, int attack, int team, String name, int x, int y) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.damage = damage;
        this.damageMax = damageMax;
        this.defence = defence;
        this.attaсk = attack;
        this.team = team;
        this.name = name;
        this.id = number;
        number++;
        this.position = new Position(x, y);
        if (team == 1) team_enemy = 2;
        else team_enemy = 1;
        gameover = 0;
    }

    public int getTeam(){
        return team;
    }

    public String getName(){
        return name;
    }

    public String getClassName(){
        return "";
    }

    public int getSpeed() {
        return speed;
    }

    public float getHp() {
        return hp;
    }

    public String getCharName(){
        return "";
    }

    public int getGameOver() {
        return gameover;
    }

    // Получение информации о герое
    public String getInfo(){
        String outStr = String.format("(%s) %-10s  ⚔️  %-3d \u26E8 %-3d \u26E8 %-3d%%  ☠️  %-3d", this.getCharName(), this.getClassName(), this.attaсk, defence, (int)(hp * 100/maxHp), (damage + damageMax)/2);
        return outStr;
    }

    public Position getPosition() {
        return position;
    }

    public void setGameOver(int t) {
        gameover = t;
    }

    /** Метод STEP - базовый для всех */
    public void step(ArrayList<BaseHero> teamOpponent) {
        System.out.printf("(%d) %s выполнил STEP...\n", this.getTeam(), this.getClassName(), this.getName());
    }


// ------------------- АТАКА и ПОЛУЧЕНИЕ DAMAGE ---------------------------
    /**
     * Метод АТАКА - нанесение повреждения персонажу target
     * @param target
     * @return - возвращается величина нанесенного повреждения damage
     */
    public void attack(BaseHero target) {
        float causedDamage;
        if (this.damage < target.defence) causedDamage = this.damage;
        else if (this.damage > target.defence) causedDamage = this.damageMax;
        else causedDamage = (this.damage + this.damageMax)/2;
        if (position.getDistance(target)>5) causedDamage -= damage/2;
        else if (position.getDistance(target)<4) causedDamage += damage/2;
        target.getDamage(causedDamage);
    }

    /**
     * Метод получения удара персонажем
     * @param damage - здоровье уменьшается на величину damage
     */
    public void getDamage(float damageGet) {
        if (hp - damageGet > 0) {
            hp = hp - damageGet;
            System.out.println(" --> Нанес урон: " + damageGet);
        }
        else Die();
    }

    /**
     * Метод СМЕРТИ
     * выводится сообщение о гибели персонажа
     */
    public void Die(){
        hp = 0;
        System.out.printf(" ----> %s %s убит !!! ...\n", this.getClassName(),this.getName());
    }

    /**
     * Метод выбора СЛУЧАЙНОГО индекса оппонента из команды противника с HP больше нуля
     * @param teamArray - ArrayList() список всех игроков, из всех команд
     * @param team - номер команды противника
     * @return - объект противник
     */
    protected int opponentRandomIndex(ArrayList<BaseHero> teamArray, int team){
        int indexOpponent;
        do {
            indexOpponent = new Random().nextInt(teamArray.size());
        } while ((teamArray.get(indexOpponent).getHp()<=0) || (teamArray.get(indexOpponent).getTeam() != team));
        return indexOpponent;
    }

    /**
     * Метод выбора индекса ближайшего оппонента из команды противника с HP больше нуля
     * @param teamArray - ArrayList() список всех игроков, из всех команд
     * @return - индекс противника (если вернется -1 - значит противников больше нет!)
     */
    protected int nearestIndexEnemy(ArrayList<BaseHero> teamArray){
        double lengthMin = 100;
        int indexEnemy = -1;
        for (int i = 0; i < teamArray.size(); i++) {
            if (teamArray.get(i).getTeam() == team_enemy && teamArray.get(i).getHp()>0)
                if (position.getDistance(teamArray.get(i))<lengthMin){
                    lengthMin = position.getDistance(teamArray.get(i));
                    indexEnemy = i;
                }
        }    
        return indexEnemy;
    }
}