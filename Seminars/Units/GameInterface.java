package Seminars.Units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<BaseHero> team);
    String getInfo();
}