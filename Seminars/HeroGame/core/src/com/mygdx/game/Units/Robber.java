// класс РАЗБОЙНИКОВ - потомок класса InfantryClass

package com.mygdx.game.Units;

public class Robber extends InfantryClass implements GameInterface{

    public Robber(int team, String name, int x, int y) {
        super(20, 20, 6, 2, 4, 3, 8, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Robber";
    }

    @Override
    public String getCharName(){
        return "R";
    }
}