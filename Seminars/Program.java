package Seminars;

import Seminars.Units.Crossbowman;
import Seminars.Units.Magician;
import Seminars.Units.Peasant;
import Seminars.Units.Priest;
import Seminars.Units.Robber;
import Seminars.Units.Sniper;
import Seminars.Units.Spearman;

public class Program {
    public static void main(String[] args) {

        Magician magician1 = new Magician();
        System.out.println(magician1.getInfo());

        Crossbowman crossbowman1 = new Crossbowman();
        System.out.println(crossbowman1.getInfo());

        Priest priest1 = new Priest();
        System.out.println(priest1.getInfo());

        Robber robber1 = new Robber();
        System.out.println(robber1);

        Sniper sniper1 = new Sniper();
        System.out.println(sniper1.getInfo());

        Spearman spearman1 = new Spearman();
        System.out.println(spearman1.getInfo());

        Peasant peasant1 = new Peasant();
        System.out.println(peasant1.getInfo());
    }
}