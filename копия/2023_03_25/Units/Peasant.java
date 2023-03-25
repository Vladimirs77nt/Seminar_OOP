// КРЕСТЬЯНИН - не имеет промежуточного подкласса, он сразу потомок класса BaseHero

package Seminars.Game.Units;

public class Peasant extends BaseHero implements GameInterface{

    public Peasant(int team, String name, int x, int y) {
        super(1, 1, 3, 1, 1, 1, 1, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Крестьянин";
    }

    @Override
    public String getCharName(){
        return "K";
    }

    @Override
    public String getInfo(){
        return super.getInfo() + String.format("\t    ");
    }
}