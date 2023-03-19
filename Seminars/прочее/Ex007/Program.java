import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        ArrayList<BaseHero> team1 = new ArrayList<>();
        ArrayList<BaseHero> team2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    team1.add(new Acrobat(BaseHero.generateName(), 0, i));
                    break;
                case 1:
                    team1.add(new Magician(BaseHero.generateName(), 0, i));
                    break;
                case 2:
                    team1.add(new Crossbowman(BaseHero.generateName(), 0, i));
                    break;
                default:
                    team1.add(new Peasant(BaseHero.generateName(), 0, i));
                    break;
            }

            switch (new Random().nextInt(4)) {
                case 0:
                    team2.add(new Robber(BaseHero.generateName(), 9, i));
                    break;
                case 1:
                    team2.add(new Priest(BaseHero.generateName(), 9, i));
                    break;
                case 2:
                    team2.add(new SniperHero(BaseHero.generateName(), 9, i));
                    break;
                default:
                    team2.add(new Peasant(BaseHero.generateName(), 9, i));
                    break;
            }
        }

        System.out.println("-------------\n TEAM 1:");
        for (BaseHero unit : team1) {
            System.out.printf(String.format("%s --- ", unit.getInfo()));
            unit.getName();
        }

        System.out.println("-------------\n TEAM 2:");
        for (BaseHero unit2 : team2) {
            System.out.printf(String.format("%s --- ", unit2.getInfo()));
            unit2.getName();
        }

        ArrayList<BaseHero> list = new ArrayList<>();

        list.addAll(team2);
        list.addAll(team1);
        list.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u1.getSpeed() == u2.getSpeed()) {
                    return 0;
                } else if (u1.getSpeed() > u2.getSpeed()) {
                    return 1;
                } else
                    return -1;
            }
        });

        team1.forEach(u -> u.step(team2, team1));

        for (BaseHero unit : team1) {
            System.out.printf("%d, %d\n", unit.position.x, unit.position.y);
        }

        for (BaseHero unit : team2) {
            System.out.printf("%d, %d\n", unit.position.x, unit.position.y);
        }
    }
}