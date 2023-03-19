package Units;

public class Monk extends Unit{

    public Monk(String name) {
        super(79.f, 5, 6, name);
    }

    public void cast(){
        System.out.println("Бум!");
    }
}