// КРЕСТЬЯНИН - не имеет промежуточного подкласса, он сразу потомок класса BaseHero

package Seminars.Units;

public class Peasant extends BaseHero implements GameInterface{

    public Peasant(int team, String name, int x, int y) {
        super(1, 1, 3, 1, 1, 1, 1, team, name, x, y);
    }
}