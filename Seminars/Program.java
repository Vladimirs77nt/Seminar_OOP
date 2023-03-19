package Seminars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

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
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    team.add(new Magician(1, createNames(), 0, i));
                    break;
                case 1:
                    team.add(new Robber(1, createNames(), 0, i));
                    break;
                case 2:
                    team.add(new Sniper(1, createNames(), 0, i));
                    break;
                case 3:
                    team.add(new Peasant(1, createNames(), 0, i));
                    break;
            }
        }
        System.out.println("--- Команда №1 ---");
        printTeam(team, 1);
        System.out.println();

        // создаем команду №2 и выводим список в терминал
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    team.add(new Priest(2, createNames(), 9, i));
                    break;
                case 1:
                    team.add(new Spearman(2, createNames(), 9, i));
                    break;
                case 2:
                    team.add(new Crossbowman(2, createNames(), 9, i));
                    break;
                case 3:
                    team.add(new Peasant(2, createNames(), 9, i));
                    break;
            }
        }
        System.out.println("--- Команда №2 ---");
        printTeam(team, 2);
        System.out.println();

        // сортировка команды по скорости героя
        team.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u2.getSpeed() - u1.getSpeed() == 0)
                    return (int)(u2.getHp() - (int)(u1.getHp()));
                return (u2.getSpeed() - u1.getSpeed());
            }
        });

        System.out.println("--- ВСЕ УЧАСТНИКИ ---");
        printTeam(team, 0);
        System.out.println();

        System.out.println("--- НАЧАЛО БОЯ ---");
        int count = 1;
        System.out.println();

        Scanner iScanner = new Scanner(System.in, "cp866");
        System.out.println("Нажмите кнопку Enter...");
        while (!iScanner.nextLine().equals("0")) {
            System.out.println("Игровой Ход №" + count);
            for (BaseHero hero : team) {
                if (hero.getHp()>0) hero.step(team);
                if (hero.getGameOver()>0){
                    System.out.println();
                    System.out.println(" --- <<< ИГРА ЗАВЕРШЕНА !!! >>> ---");
                    System.out.println("Пnобедила команда № " + hero.getGameOver());
                    count = 0;
                    break;
                }
            }
            if (count == 0) break;
            System.out.println("Нажмите кнопку Enter...");
            iScanner.nextLine();
            System.out.println("Итог Игрового Хода:");
            System.out.println("--- Команда №1 ---");
            printTeam(team, 1);
            System.out.println();
            System.out.println("--- Команда №2 ---");
            printTeam(team, 2);
            System.out.println();
            count++;
            System.out.println();
            System.out.println("Нажмите кнопку Enter... (завершение 0)");
        }
    }

    // -----------------------------------------------------------------------------------
    /**
     * Метод вывода в терминал списка членов команды
     * 
     * @param team - номер команды (1,2,3...), если 0 - то все!
     */
    private static void printTeam(ArrayList<BaseHero> teamArray, int team) {
        for (BaseHero hero : teamArray) {
            if (hero.getTeam() == team || team == 0){
                if (hero.getHp() > 0) System.out.println(hero.getInfo());
            }
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