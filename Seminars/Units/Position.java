package Seminars.Units;

public class Position{
    protected String name;
    protected int x, y;

    public Position(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * Метод вычисления расстояния до указанного героя
     * @param unit - указанный герой
     * @return - double - расстояние до героя
     */
    public double getDistance(BaseHero unit){
        return Math.sqrt(Math.pow(x - unit.position.x, 2) + Math.pow(y - unit.position.y, 2));
    }
}