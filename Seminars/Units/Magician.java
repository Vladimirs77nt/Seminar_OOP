/** Magician - класс МАГОВ (потомок MagClass) */

package Seminars.Units;

import java.util.ArrayList;

public class Magician extends MagicClass implements GameInterface{

    int magicPower;
    public Magician(int team, String name) {
        super(30, 30, 9, -5, 12, 17, 1, team, name);

    }
}