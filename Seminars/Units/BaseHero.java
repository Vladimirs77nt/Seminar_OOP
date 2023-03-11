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

    protected static ArrayList<String> namesHero = new ArrayList<>(); // список имен для созданных героев (чтобы проверять на повторы)
    protected static int number = 0;

    // базовые характеристики ЛЮБЫХ (всех) героев
    protected String name;  // - имя героя
    protected int id;       // - id номер героя
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
    public BaseHero(int hp, int maxHp, int speed, int damage) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.damage = damage;
        this.id = number;
        number++;
        this.name = getNames();
        namesHero.add(this.name);
    }

    /**
     * Получение информации о герое
     * @return String текстовая строка с информацией о герое
     */
    public String getInfo() {
        return String.format("Names: %s,  Type: %s (id: %d),   Hp: %d  Speed: %d,  Damage: %d",
                this.name, this.getClass().getSimpleName(), this.id, this.hp, this.speed, this.damage);
    }

    /**
     * метод рандомного выбора имени из списка NamesFantazy.java
     * @return String name
     */
    private String getNames() {
        String nameRandom;
        do {
            nameRandom = NamesFantazy.values()[new Random().nextInt(NamesFantazy.values().length)].toString();
        } while (namesHero.size()>0 && namesHero.contains(nameRandom));
        return nameRandom;
    }

    public void step() {
        System.out.printf("%s %s сделал шаг", this.getClass().getSimpleName(), this.name);
    }
}