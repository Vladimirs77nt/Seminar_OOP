package com.mygdx.game.hmm;

//import chars.HeroTeam;
import com.mygdx.game.MyGdxGame;

import com.mygdx.game.Units.*;
import java.util.Collections;

public class ConsoleView {

    private static int step = -1;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view(){
        System.out.println();
        if (step == 0) {
            System.out.print(AnsiColors.ANSI_RED+"Итоги первого хода!"+AnsiColors.ANSI_RESET);
        } else if (step < 0) {
            System.out.println("Начальное состояние двух армий");
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Итоги хода № "+(step+1)+AnsiColors.ANSI_RESET);
        }

        step++;
        System.out.println();

        System.out.print(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(30, formatDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
        System.out.println(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(43, formatDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 0; i <= MyGdxGame.GANG_SIZE - 2; i++) {
            for (int j = 0; j <= MyGdxGame.GANG_SIZE - 1; j++) {
                System.out.print(getChar(new Position(j, i)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 0; j <= MyGdxGame.GANG_SIZE - 1; j++) {
            System.out.print(getChar(new Position(j, MyGdxGame.GANG_SIZE-1)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bottom10);
        System.out.println();
        // System.out.println("Нажмите кнопку Enter...");
        // Program.iScanner.nextLine();
    }

    private static String getChar(Position position){
        String str = "| ";
        boolean alive = false;
        for (int i = 0; i < MyGdxGame.GANG_SIZE; i++) {
            if (MyGdxGame.whiteSide.get(i).getPosition().isEquals(position))
            {
                if(MyGdxGame.whiteSide.get(i).getHp() == 0)
                    str ="|"+AnsiColors.ANSI_RED+MyGdxGame.whiteSide.get(i).getCharName()+AnsiColors.ANSI_RESET;
                else {
                    str ="|"+AnsiColors.ANSI_GREEN+MyGdxGame.whiteSide.get(i).getCharName()+AnsiColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (MyGdxGame.darkSide.get(i).getPosition().isEquals(position) && !alive)
            {
                if(MyGdxGame.darkSide.get(i).getHp() == 0)
                    str ="|"+AnsiColors.ANSI_RED+ MyGdxGame.darkSide.get(i).getCharName()+AnsiColors.ANSI_RESET;
                else str ="|"+AnsiColors.ANSI_BLUE+ MyGdxGame.darkSide.get(i).getCharName()+AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String PrintInfo(int npcIndex)
    {
        String str = "";

        if(MyGdxGame.whiteSide.get(npcIndex).getHp() == 0)
            str +="     " + AnsiColors.ANSI_RED+MyGdxGame.whiteSide.get(npcIndex).getInfo()+AnsiColors.ANSI_RESET;
        else str +="     " + AnsiColors.ANSI_GREEN+MyGdxGame.whiteSide.get(npcIndex).getInfo()+AnsiColors.ANSI_RESET;
        if(MyGdxGame.darkSide.get(npcIndex).getHp() == 0)
            str +="     " + AnsiColors.ANSI_RED+MyGdxGame.darkSide.get(npcIndex).getInfo()+AnsiColors.ANSI_RESET;
        else str +="     " + AnsiColors.ANSI_BLUE+MyGdxGame.darkSide.get(npcIndex).getInfo()+AnsiColors.ANSI_RESET;

        return str;
    }

    private static String formatDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}