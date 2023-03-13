// класс СНАЙПЕРОВ - потомок класса ShooterClass

package Seminars.Units;

public class Sniper extends ShooterClass implements GameInterface{

    public Sniper(int team, String name) {
        super(60, 80, 9, 15, 38, 9, team, name);
    }
}