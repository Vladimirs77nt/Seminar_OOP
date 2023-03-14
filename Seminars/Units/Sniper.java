// класс СНАЙПЕРОВ - потомок класса ShooterClass

package Seminars.Units;

public class Sniper extends ShooterClass implements GameInterface{

    public Sniper(int team, String name) {
        super(15, 15, 9, 8, 10, 12, 32, team, name);
    }
}