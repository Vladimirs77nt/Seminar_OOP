/** 1. MagicClacc - класс магических героев (потомок класса BaseHero)
это родительский класс для:
1.1. Priest - класс МОНАХОВ (потомок MagClass)
1.2. Magician - класс МАГОВ (потомок MagClass)
 */

 package Seminars.Game.Units;

 public abstract class MagicClass extends BaseHero{
 
     protected int magicPower; // магическая сила персонажа
 
     public MagicClass(float hp, float maxHp, int speed, int damage, int damageMax, int defence, int attack, int magicPower, int team,
                        String name, int x, int y) {
        super(hp, maxHp, speed, damage, damageMax, defence, attack, team, name, x, y);
        this.magicPower = magicPower;
     }

     @Override
     public String getInfo(){
         return super.getInfo() + String.format("\t    ");
     }
 }