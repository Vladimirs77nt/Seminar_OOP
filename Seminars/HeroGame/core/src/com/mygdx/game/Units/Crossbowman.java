// Класс АРБАЛЕТЧИК - потомок класса ShooterClass

package com.mygdx.game.Units;

public class Crossbowman extends ShooterClass implements GameInterface{

    public Crossbowman(int team, String name, int x, int y) {
        super(10, 10, 7, 2, 3, 25, 7, 16, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Crossbowman";
    }

    @Override
    public String getCharName(){
        return "A";
    }
}