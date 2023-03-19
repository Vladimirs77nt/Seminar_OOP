public abstract class InfantClass extends BaseHero {

    int stamina;

    public InfantClass(int hp, int speed, int damage, int maxDamage, int armor, int stamina, String name, int x, int y) {
        super(hp, speed, damage, maxDamage, armor, name, x, y);
        this.stamina = stamina;
    }
}
