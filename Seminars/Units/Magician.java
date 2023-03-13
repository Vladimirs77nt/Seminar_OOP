/** Magician - класс МАГОВ (потомок MagClass) */

package Seminars.Units;

import java.util.ArrayList;

public class Magician extends MagicClass implements GameInterface{

    public Magician(int team, String name) {
        super(45, 60, 6, 8, 18, team, name);
    }
}