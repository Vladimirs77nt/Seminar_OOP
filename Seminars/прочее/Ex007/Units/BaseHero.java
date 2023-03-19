import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements Interface {
    protected static Random r = new Random();

    protected int hp;
    protected int speed;
    protected int damage;
    protected int maxDamage;
    protected int armor;
    protected final String NAME;
    protected Position position;

    public BaseHero(int hp, int speed, int damage, int maxDamage, int armor, String name, int x, int y) {
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.maxDamage = maxDamage;
        this.armor = armor;
        NAME = name;
        position = new Position(x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> friends) {
        System.out.println("Ход");
    }

    @Override
    public String getInfo() {
        return "---------------";
    }

    public void getName() {
        System.out.println(NAME);
    }

    public int getSpeed() {
        return this.speed;
    }

    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        } else
            this.hp = 0;
    }

    public void attack(BaseHero target, int damage, int maxDamage) {
        int causedDamage;
        if (damage < target.armor) causedDamage = damage;
        else {
            switch (new Random().nextInt(4)){
                case 0:
                    causedDamage = maxDamage;
                    break;
                default:
                    causedDamage = damage;
                    break;
            }
        }
        System.out.printf("%s attack %s\t", this.getClass().getSimpleName(), target.getClass().getSimpleName());
        System.out.printf("Power of knock = %d\n", causedDamage);
        System.out.printf("%s hp= %d\n", target.getClass().getSimpleName(), target.hp);
        target.getDamage(causedDamage);
    }

    public static String generateName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}