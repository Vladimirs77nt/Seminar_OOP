package Seminars.Game.Units;

public class Position{
    protected int x, y;

    public Position(int x, int y) {
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

    public boolean isEquals(Position position){
        return (position.x == x && position.y == y);
    }
}