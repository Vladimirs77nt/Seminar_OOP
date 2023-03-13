package Seminars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import Seminars.Units.BaseHero;
import Seminars.Units.Crossbowman;
import Seminars.Units.Magician;
import Seminars.Units.NamesFantazy;
import Seminars.Units.Peasant;
import Seminars.Units.Priest;
import Seminars.Units.Robber;
import Seminars.Units.Sniper;
import Seminars.Units.Spearman;

public class Program {

    // список имен для созданных героев (чтобы проверять на повторы)
    public static ArrayList<String> namesHero = new ArrayList<>(); 

    public static void main(String[] args) {

        // создаем команду №1 и выводим список в терминал
        ArrayList<BaseHero> team1 = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            team1.add(createRandomHero(1, createNames()));
        System.out.println("--- Команда №1 ---");
        printTeam(team1);

        // создаем команду №2 и выводим список в терминал
        System.out.println();
        ArrayList<BaseHero> team2 = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            team2.add(createRandomHero());
        System.out.println("--- Команда №2 ---");
        printTeam(team2);

        System.out.println();
        team1.forEach(u -> u.step(team2));

        ArrayList<BaseHero> teamAll = new ArrayList<>();
        teamAll.addAll(team1);
        teamAll.addAll(team2);
        teamAll.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2){
                if (u2.getSpeed()-u1.getSpeed() == 0)
                    return (u2.getHp()-u1.getHp());
                return (u2.getSpeed()-u1.getSpeed());
            }
        });
        System.out.println();
        System.out.println("--- НАЧАЛО БОЯ ---");
        printTeam(teamAll);
        for (BaseHero hero : teamAll) {
            hero.step(team2);
        }
    }

// -----------------------------------------------------------------------------------
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
    private static BaseHero createRandomHero(int team, String name) {
            switch (new Random().nextInt(7)) {
                case 0:
                    return new Crossbowman(team, name);
                case 1:
                    return new Magician(team, name);
                case 2:
                    return new Peasant(team, name);
                case 3:
                    return new Priest(team, name);
                case 4:
                    return new Robber(team, name);
                case 5:
                    return new Sniper(team, name);
                default:
                    return new Spearman(team, name);
        }
    }

    /**
     * метод рандомного выбора имени из списка NamesFantazy.java
     * @return String name
     */
    private static String createNames() {
        String nameRandom;
        do {
            nameRandom = NamesFantazy.values()[new Random().nextInt(NamesFantazy.values().length)].toString();
        } while (namesHero.size()>0 && namesHero.contains(nameRandom));
        return nameRandom;
    }
}