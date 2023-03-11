package Units;

public class XBowMan extends Shooter{
    public XBowMan(String name) {
        super(50, 6, 8, 56, name);
    }

    @Override
    public void step() {
        System.out.println("Арбалетчик высрелил!");
    }
}
