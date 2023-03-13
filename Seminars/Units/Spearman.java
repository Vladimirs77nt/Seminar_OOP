// класс КОПЕЙЩИКОВ - потомок класса InfantryClass

package Seminars.Units;

import java.util.ArrayList;

public class Spearman extends InfantryClass implements GameInterface{

    public Spearman(int team, String name) {
        super(70, 100, 4, 15, 20, team, name);
    }
}