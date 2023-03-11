package Seminars;

import java.util.ArrayList;
import java.util.Random;

import Seminars.Units.BaseHero;
import Seminars.Units.Crossbowman;
import Seminars.Units.Magician;
import Seminars.Units.Peasant;
import Seminars.Units.Priest;
import Seminars.Units.Robber;
import Seminars.Units.Sniper;
import Seminars.Units.Spearman;

public class Program {
    public static void main(String[] args) {

        // создаем команду №1 и выводим список в терминал
        ArrayList<BaseHero> team1 = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            team1.add(createRandomHero());
        System.out.println("--- Команда №1 ---");
        printTeam(team1);

        // создаем команду №2 и выводим список в терминал
        System.out.println();
        ArrayList<BaseHero> team2 = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            team2.add(createRandomHero());
        System.out.println("--- Команда №2 ---");
        printTeam(team2);

        // тестируем на 5 случайных персонажах метод .step()
        System.out.println();
        System.out.println("--- тестирование .step() ---");
        for (int i = 0; i < 5; i++) {
            BaseHero h1 = team1.get(new Random().nextInt(team1.size()));
            h1.step();
        }
    }

    /**
     * Метод вывода в терминал списка членов команды
     * @param team - список членов команды
     */
    private static void printTeam(ArrayList<BaseHero> team) {
        for (BaseHero hero : team) {
            System.out.println(hero.getInfo());
        }
    }

    /**
     * Метод генерации случайного героя
     * @return
     */
    private static BaseHero createRandomHero() {
            switch (new Random().nextInt(7)) {
                case 0:
                    return new Crossbowman();
                case 1:
                    return new Magician();
                case 2:
                    return new Peasant();
                case 3:
                    return new Priest();
                case 4:
                    return new Robber();
                case 5:
                    return new Sniper();
                default:
                    return new Spearman();
        }
    }
}