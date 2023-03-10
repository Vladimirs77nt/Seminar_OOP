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

import java.util.Random;
 
public class BaseHero {

    // базовые характеристики ВСЕХ героев
    protected int hp;       // - здоровье текущее
    protected int maxHp;    // - максимальный уровень здоровья
    protected int speed;    // - скорость передвижения
    protected int damage;   // - урон

    protected static int number;
    protected static Random r;  

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    // конструктор
    public BaseHero(int hp, int maxHp, int speed, int damage) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.damage = damage;
    }

    /**
     * Получение информации о герое
     * @return
     */
    public String getInfo() {
        return String.format("Type: %s,  Hp: %d  Speed: %d  Damage: %d  ",
                this.getClass().getSimpleName(), this.hp, this.speed, this.damage);
    }

    /**
     * Лечение
     * @param Hp
     */
    public void healed(int Hp) {
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
    }

    /**
     * Получение урона!
     * @param damage
     */
    public void GetDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }
}