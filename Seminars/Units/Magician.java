/** Magician - класс МАГОВ или КОЛДУНОВ (потомок MagClass) */

package Seminars.Units;

public class Magician extends MagicClass implements GameInterface{

    int magicPower;
    public Magician(int team, String name, int x, int y) {
        super(30, 30, 9, -5, -5, 12, 17, 1, team, name, x, y);
    }
}