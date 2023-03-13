/** 1. MagicClacc - класс магических героев (потомок класса BaseHero)
это родительский класс для:
1.1. Priest - класс МОНАХОВ (потомок MagClass)
1.2. Magician - класс МАГОВ (потомок MagClass)
 */

 package Seminars.Units;

 public abstract class MagicClass extends BaseHero implements GameInterface{
 
     protected int magicPower; // магическая сила персонажа
 
     public MagicClass(int hp, int maxHp, int speed, int damage, int magicPower) {
         super(hp, maxHp, speed, damage);
         this.magicPower = magicPower;
     }
 }