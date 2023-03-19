import java.util.ArrayList;

public class Peasant extends BaseHero {

    public Peasant(String name, int x, int y) {
        super(250, 255, 0, 0, 20, name, x, y);
    }

    @Override
    public String getInfo() {
        return "Peasant";
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> friends) {
    }
}
