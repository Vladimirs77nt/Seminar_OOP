// Класс АРБАЛЕТЧИК - потомок класса ShooterClass

package Seminars.Units;

import java.util.ArrayList;

public class Crossbowman extends ShooterClass implements GameInterface{

    public Crossbowman(int team, String name) {
        super(60, 80, 7, 25, 25, 7, 10, team, name);
    }
}