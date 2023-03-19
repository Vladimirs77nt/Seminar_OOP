import Units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Unit> list = new ArrayList<>();
        ArrayList<Unit> list2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(3)){
                case 0:
                    list.add(new XBowMan(getName()));
                    break;
                case 1:
                    list.add(new Monk(getName()));
                    break;
                default:
                    list.add(new Sniper(getName()));
                    break;
            }
            switch (new Random().nextInt(3)){
                case 0:
                    list2.add(new XBowMan(getName()));
                    break;
                case 1:
                    list2.add(new Monk(getName()));
                    break;
                default:
                    list2.add(new Sniper(getName()));
                    break;
            }
        }

        list.forEach(u -> u.getNAME());
    }

    private static String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}
