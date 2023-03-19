/** BaseHero - БАЗОВЫЙ класс героя

это родительский класс для обобщенных классов:
1. MagicClacc - класс магических героев / МАГИ, МОНАХИ...
2. InfantryClass - класс бойцов ближнего боя / пехотинцев = КОПЕЙЩИКИ, РАЗБОЙНИКИ...
3. ShooterClass - класс бойцов дальнего боя / стрелков = СНАЙПЕРЫ, АРБАЛЕТЧИКИ...
*/

package Seminars.Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero {

    protected static int number = 0;

    // базовые характеристики ЛЮБЫХ (всех) героев
    protected String name;  // - имя героя
    protected int id;       // - id номер героя
    protected int team;     // - номер команды героя
    protected int team_enemy;     // - номер команды ПРОТИВНИКОВ
    protected float hp;       // - здоровье текущее
    protected float maxHp;    // - максимальный уровень здоровья
    protected int speed;    // - скорость передвижения
    protected int damage;   // - наносимый урон
    protected int damageMax;   // - наносимый Максимальный урон
    protected int defence;  // - защита
    protected int attaсk;   // - уровень атаки
    protected Position position; // - координаты героя
    protected int gameover;
    
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
    public BaseHero(float hp, float maxHp, int speed, int damage, int damageMax, int defence, int attack, int team, String name, int x, int y) {
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
        position = new Position(name, x, y);
        if (team == 1) team_enemy = 2;
        else team_enemy = 1;
        gameover = 0;
    }

    /**
     * Получение информации о герое
     * @return String текстовая строка с информацией о герое
     */
    public String getInfo() {
        return String.format(">> %-20s ( команда: %d)   Hp: %-2f  Speed: %2d,  Damage: %2d,  Defence: %2d",
                            className(this), this.team, this.hp, this.speed, this.damage, this.defence);
    }

    /**
     * Получение информации о номере команды
     * @return
     */
    public int getTeam() {
        return team;
    }

    /**
     * Имя героя
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Скорость героя
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Здоровье героя
     * @return
     */
    public float getHp() {
        return hp;
    }

    public int getArrowReserve() {
        return -1;
    }

    protected void setArrowReserve(int arrowReserve) {
    }

    public int getGameOver() {
        return gameover;
    }

    public void setGameOver(int t) {
        gameover = t;
    }

    /** Метод STEP - абстрактный для всех */
    public void step(ArrayList<BaseHero> teamOpponent) {
        System.out.printf("%s выполнил STEP...\n", className(this));
    }

    /**
     * * Метод получение названия класса героя + его имя
     * @return String "класс героя + имя"
     */
    protected String className(BaseHero hero) {
        return (hero.getClassHero() + " " + hero.getName());
    }

    protected String getClassHero() {
        String className = this.getClass().getSimpleName();
        if (className.contains("Sniper")) className = "Снайпер";
        else if (className.contains("Spearman")) className = "Копейщик";
        else if (className.contains("Robber")) className = "Разбойник";
        else if (className.contains("Magician")) className = "Колдун";
        else if (className.contains("Crossbowman")) className = "Арбалетчик";
        else if (className.contains("Peasant")) className = "Крестьянин";
        else if (className.contains("Priest")) className = "Монах";
        return className;
    }

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
        System.out.printf(" ----> Персонаж %s убит !!! ...\n", className(this));
    }

    /**
     * Метод выбора индекса оппонента из команды противника с HP больше нуля
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
     * @return - индекс противника
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