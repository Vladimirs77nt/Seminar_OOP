// класс РАЗБОЙНИКОВ - потомок класса InfantryClass

package Seminars.Units;

import java.util.ArrayList;

public class Robber extends InfantryClass implements GameInterface{

    public Robber(int team, String name) {
        super(60, 80, 8, 10, 30, team, name);
    }
}