package Units;

public abstract class Shooter extends Unit{
    protected int arrows;

    public Shooter(float hp, int speed, int damage, int arrows, String name) {
        super(hp, speed, damage, name);
        this.arrows = arrows;
    }
}
