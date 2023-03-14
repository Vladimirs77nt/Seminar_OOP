// класс КОПЕЙЩИКОВ - потомок класса InfantryClass

package Seminars.Units;

import java.util.ArrayList;

public class Spearman extends InfantryClass implements GameInterface{

    public Spearman(int team, String name) {
        super(10, 10, 4, 1, 5, 4, team, name);
    }
}