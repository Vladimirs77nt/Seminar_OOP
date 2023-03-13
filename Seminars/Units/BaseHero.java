/** BaseHero - БАЗОВЫЙ класс героя

это родительский класс для обобщенных классов:
1. MagicClacc - класс магических героев / МАГИ, МОНАХИ...
2. InfantryClass - класс бойцов ближнего боя / пехотинцев = КОПЕЙЩИКИ, РАЗБОЙНИКИ...
3. ShooterClass - класс бойцов дальнего боя / стрелков = СНАЙПЕРЫ, АРБАЛЕТЧИКИ...
4. Worker - класс работницков и ремеслеников / не бойцы! / КРЕСТЬЯНЕ...

имеет ТРИ поля:
- hp: здоровье
- maxHP: максимальное здоровье

БАЗОВЫЕ МЕТОДЫ:
1) лечение
2) получение урона
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
    protected int hp;       // - здоровье текущее
    protected int maxHp;    // - максимальный уровень здоровья
    protected int speed;    // - скорость передвижения (от 1 до 10)
    protected int damage;   // - наносимый урон (от )

    /**
     * Конструктор для базового шаблона героя
     * @param hp
     * @param maxHp
     * @param speed
     * @param damage
     */
    public BaseHero(int hp, int maxHp, int speed, int damage, int team, String name) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.damage = damage;
        this.team = team;
        this.id = number;
        number++;
        // this.name = createNames();
        namesHero.add(this.name);
    }

    public BaseHero(int hp, int maxHp, int speed, int damage, int team){
        name = createNames();
        this(hp, maxHp, speed, damage, team, name);
    }

    /**
     * Получение информации о герое
     * @return String текстовая строка с информацией о герое
     */
    public String getInfo() {
        return String.format(">> %-20s ( id: %-3d)   Hp: %d  Speed: %d,  Damage: %d",
                            className(this), this.id, this.hp, this.speed, this.damage);
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void step(ArrayList<BaseHero> teamOpponent) {
        System.out.printf("%s выполнил STEP...\n", className(this));
    }

    /**
     * * Метод получение названия класса героя + его имя
     * @return String "класс героя + имя"
     */
    protected String className(BaseHero hero) {
        String className = hero.getClass().getSimpleName();
        if (className.contains("Sniper")) className = "Снайпер";
        else if (className.contains("Spearman")) className = "Копейщик";
        else if (className.contains("Robber")) className = "Разбойник";
        else if (className.contains("Magician")) className = "Маг";
        else if (className.contains("Crossbowman")) className = "Арбалетчик";
        else if (className.contains("Peasant")) className = "Крестьянин";
        else if (className.contains("Priest")) className = "Монах";
        return (className + " " + name);
    }

    /**
     * Метод выбора оппонента из команды противника с HP больше нуля
     * @param teamOpponent - ArrayList() команда противника
     * @return - объект противник
     */
    protected BaseHero opponentRandom(ArrayList<BaseHero> teamOpponent){
        BaseHero opponent;
        do {
            opponent = teamOpponent.get(new Random().nextInt(teamOpponent.size()));
        } while (!(opponent.getHp()>0));
        return opponent;
    }

    /**
     * Метод АТАКА - нанесение повреждения персонажу target
     * @param target
     * @return - возвращается величина нанесенного повреждения damage
     */
    public int Attack(BaseHero target) {
        int damage = new Random().nextInt(10, 20);
        target.GetDamage(damage);
        return damage;
    }

    /**
     * Метод получения удара персонажем
     * @param damage - здоровье уменьшается на величину damage
     */
    public void GetDamage(int damage) {
        if (hp - damage > 0) {
            hp -= damage;
        }
        else Die();
    }

    /**
     * Метод СМЕРТИ
     * выводится сообщение о гибели персонажа
     */
    public void Die(){
        if (hp<=0) {
            hp = 0;
            System.out.printf("Персонаж %s погиб!!!", className(this));
        }
    }
}