// класс РАЗБОЙНИКОВ - потомок класса InfantryClass

package Seminars.Units;

public class Robber extends InfantryClass implements GameInterface{

    public Robber(int team, String name) {
        super(10, 10, 6, 2, 3, 8, team, name);
    }
}