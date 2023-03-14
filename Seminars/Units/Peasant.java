// КРЕСТЬЯНИН - пока данный класс не имеет промежуточного подкласса, он сразу потомок класса BaseHero

package Seminars.Units;

public class Peasant extends BaseHero implements GameInterface{

    protected int contain; // сколько стрел может нести

    public Peasant(int team, String name) {
        super(1, 1, 3, 1, 1, 1, team, name);
        this.contain = 1;
    } 
}