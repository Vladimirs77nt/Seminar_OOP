/** 1. MagicClacc - класс магических героев (потомок класса BaseHero)
это родительский класс для:
1.1. Priest - класс МОНАХОВ (потомок MagClass)
1.2. Magician - класс МАГОВ (потомок MagClass)
 */

 package Seminars.Units;

 public abstract class MagicClass extends BaseHero implements GameInterface{
 
     protected int magicPower; // магическая сила персонажа
 
     public MagicClass(int hp, int maxHp, int speed, int damage, int defence, int attack, int magicPower, int team, String name) {
        super(hp, maxHp, speed, damage, defence, attack, team, name);
        this.magicPower = magicPower;
     }
 }