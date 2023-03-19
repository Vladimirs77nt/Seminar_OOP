// Класс АРБАЛЕТЧИК - потомок класса ShooterClass

package Seminars.Units;

public class Crossbowman extends ShooterClass implements GameInterface{

    public Crossbowman(int team, String name, int x, int y) {
        super(60, 80, 7, 2, 3, 25, 7, 16, team, name, x, y);
    }
}