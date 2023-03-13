// класс МОНАХ - потомок класса MagicClass

package Seminars.Units;

import java.util.ArrayList;

public class Priest extends MagicClass implements GameInterface{

    public Priest(int team, String name) {
        super(55, 70, 5, 6, 20, team, name);
    }
}