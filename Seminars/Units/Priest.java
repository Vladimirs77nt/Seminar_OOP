// класс МОНАХ - потомок класса MagicClass

package Seminars.Units;

import java.util.ArrayList;

public class Priest extends MagicClass implements GameInterface{

    public Priest(int team, String name) {
        super(30, 30, 5, -4, 7, 12, 1, team, name);
    }
}