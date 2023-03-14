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
    protected int speed;    // - скорость передвижения
    protected int damage;   // - наносимый урон
    protected int defence;  // - защита
    protected int attaсk;   // - уровень атаки

    /**
     * Конструктор для базового шаблона героя
     * @param hp - текущее здоровье
     * @param maxHp - максимальное здоровье
     * @param speed - скорость
     * @param damage - уровень удара
     * @param defence - уровень защиты
     * @param attack - уровень атаки
     * @param team - номер команды
     * @param name - имя героя
     */
    public BaseHero(int hp, int maxHp, int speed, int damage, int defence, int attack, int team, String name) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.damage = damage;
        this.defence = defence;
        this.attaсk = attack;
        this.team = team;
        this.name = name;
        this.id = number;
        number++;
    }

    /**
     * Получение информации о герое
     * @return String текстовая строка с информацией о герое
     */
    public String getInfo() {
        return String.format(">> %-20s ( команда: %d)   Hp: %-2d  Speed: %2d,  Damage: %2d,  Defence: %2d",
                            className(this), this.team, this.hp, this.speed, this.damage, this.defence);
    }

    /**
     * какая команда?
     * @return
     */
    public int getTeam() {
        return team;
    }

    public String getName() {
        return name;
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
        else if (className.contains("Magician")) className = "Колдун";
        else if (className.contains("Crossbowman")) className = "Арбалетчик";
        else if (className.contains("Peasant")) className = "Крестьянин";
        else if (className.contains("Priest")) className = "Монах";
        return (className + " " + hero.getName());
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
}