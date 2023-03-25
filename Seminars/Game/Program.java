package Seminars.Game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import Seminars.Game.Units.*;
import Seminars.Game.ConsoleView;

public class Program {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;
    public static ArrayList<BaseHero> allUnits;
    public static ArrayList<String> namesHero;
    public static Scanner iScanner = new Scanner(System.in, "cp866");
    static boolean GameOver = false;

    public static void main(String[] args) {

        init();

        do {
            ConsoleView.view();

            makeStep();

            System.out.println();
            System.out.println("Нажмите кнопку Enter... (0 - завершение игры)");
            String str = iScanner.nextLine();
            if (str.equals("0"))
                GameOver = true;
            
        } while (!GameOver);

        iScanner.close();
    }

    // -----------------------------------------------------------------------------------
    public static void init(){
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();
        allUnits = new ArrayList<>();

        // список имен для созданных героев (чтобы проверять на повторы)
        namesHero = new ArrayList<>();

        // создаем команду №1
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    whiteSide.add(new Priest(1, createNames(), 0, i));
                    break;
                case 1:
                    whiteSide.add(new Robber(1, createNames(), 0, i));
                    break;
                case 2:
                    whiteSide.add(new Sniper(1, createNames(), 0, i));
                    break;
                case 3:
                    whiteSide.add(new Peasant(1, createNames(), 0, i));
                    break;
            }
        }

        // создаем команду №2 и выводим список в терминал
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    darkSide.add(new Magician(2, createNames(), 9, i));
                    break;
                case 1:
                    darkSide.add(new Spearman(2, createNames(), 9, i));
                    break;
                case 2:
                    darkSide.add(new Crossbowman(2, createNames(), 9, i));
                    break;
                case 3:
                    darkSide.add(new Peasant(2, createNames(), 9, i));
                    break;
            }
        }

        // создание ОБШЕЙ команды и сортировка ее по скорости героя
        allUnits.addAll(whiteSide);
        allUnits.addAll(darkSide);
        allUnits.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u2.getSpeed() - u1.getSpeed() == 0)
                    return (int)(u2.getHp() - (int)(u1.getHp()));
                return (u2.getSpeed() - u1.getSpeed());
            }
        });
    }

    // метод STEP 
    private static void makeStep(){
        for (BaseHero hero : allUnits) {
                hero.step(allUnits);
                if (hero.getGameOver() > 0){
                    if (hero.getGameOver() == 1){
                        System.out.println("\n  <<< Победила команда Green !!! >>>");
                    break;
                    }
                    else {
                        System.out.println("\n  <<< Победила команда Blue !!! >>>");
                        break;
                    }
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