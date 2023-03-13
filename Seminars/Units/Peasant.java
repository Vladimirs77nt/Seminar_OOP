// КРЕСТЬЯНИН - пока данный класс не имеет промежуточного подкласса, он сразу потомок класса BaseHero

package Seminars.Units;

import java.util.ArrayList;

public class Peasant extends BaseHero implements GameInterface{

    public Peasant(int team, String name) {
        super(40, 50, 2, 0, team, name);
    } 
}