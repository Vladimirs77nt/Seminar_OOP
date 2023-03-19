// класс КОПЕЙЩИКОВ - потомок класса InfantryClass

package Seminars.Units;

public class Spearman extends InfantryClass implements GameInterface{

    public Spearman(int team, String name, int x, int y) {
        super(10, 10, 4, 1, 3, 5, 4, team, name, x, y);
    }
}