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
    public static ArrayList<BaseHero> team = new ArrayList<>();
    public static void main(String[] args) {

        // создаем команду №1 и выводим список в терминал
        for (int i = 0; i < 10; i++)
            team.add(createRandomHeroTeam1(1, createNames()));
        System.out.println("--- Команда №1 ---");
        printTeam(team, 1);

        // создаем команду №2 и выводим список в терминал
        System.out.println();
        for (int i = 0; i < 10; i++)
            team.add(createRandomHeroTeam2(2, createNames()));
        System.out.println("--- Команда №2 ---");
        printTeam(team, 2);

        team.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u2.getSpeed() - u1.getSpeed() == 0)
                    return (u2.getHp() - u1.getHp());
                return (u2.getSpeed() - u1.getSpeed());
            }
        });
        System.out.println();
        int count = 1;
        System.out.println("--- НАЧАЛО БОЯ ---");
        printTeam(team, 0);
        System.out.println();

        while (true) {
            System.out.println();
            System.out.println("Игровой Ход №" + count);
            for (BaseHero hero : team) {
                if (hero.getTeam() == 1) hero.step(team);
                else hero.step(team);
            }
            System.out.println();
            System.out.println("Итог Хода");
            printTeam(team, 0);
            count++;
            if (count >1) break; // пока делаем только один игровой ход
        }
    }

    // -----------------------------------------------------------------------------------
    /**
     * Метод вывода в терминал списка членов команды
     * 
     * @param team - список членов команды
     */
    private static void printTeam(ArrayList<BaseHero> teamArray, int team) {
        for (BaseHero hero : teamArray) {
            if (hero.getTeam() == team || team ==0) System.out.println(hero.getInfo());
        }
    }

    /**
     * Метод генерации случайного героя
     * 
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
     * Метод генерации случайного героя для команды Вариант 1
     * Персонажи: Колдун (magician), Разбойник (Robber), Снайпер (Sniper),
     * Крестьянин (Peasant)
     * 
     * @return
     */
    private static BaseHero createRandomHeroTeam1(int team, String name) {
        switch (new Random().nextInt(4)) {
            case 0:
                return new Magician(team, name);
            case 1:
                return new Robber(team, name);
            case 2:
                return new Sniper(team, name);
            default:
                return new Peasant(team, name);
        }
    }

    /**
     * Метод генерации случайного героя для команды Вариант 2
     * Персонажи: Маг (magician), Разбойник (Robber), Снайпер (Sniper), Крестьянин
     * (Peasant)
     * 
     * @return
     */
    private static BaseHero createRandomHeroTeam2(int team, String name) {
        switch (new Random().nextInt(4)) {
            case 0:
                return new Priest(team, name);
            case 1:
                return new Spearman(team, name);
            case 2:
                return new Crossbowman(team, name);
            default:
                return new Peasant(team, name);
        }
    }

    /**
     * метод рандомного выбора имени из списка NamesFantazy.java
     * 
     * @return String name
     */
    private static String createNames() {
        String nameRandom;
        do {
            nameRandom = NamesFantazy.values()[new Random().nextInt(NamesFantazy.values().length)].toString();
        } while (namesHero.size() > 0 && namesHero.contains(nameRandom));
        namesHero.add(nameRandom);
        return nameRandom;
    }
}