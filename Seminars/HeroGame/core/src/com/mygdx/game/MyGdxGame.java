package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import com.mygdx.game.Units.*;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, magic, priest, peasant, robber, sniper, spearMan;
	Music music;

	public static final int GANG_SIZE = 10;
	public static ArrayList<BaseHero> whiteSide;
	public static ArrayList<BaseHero> darkSide;
	public static ArrayList<BaseHero> allUnits;
	public static ArrayList<String> namesHero;
	public static Scanner iScanner = new Scanner(System.in, "cp866");
	static boolean GameOver = false;
	public static int step = 0;
	private Scanner iSscanner;
	private static float dx, dy;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("fons/" + String.valueOf(new Random().nextInt(5)) + ".png");
		music = Gdx.audio.newMusic(
				Gdx.files.internal(
						"music/paul-romero-rob-king-combat-theme-0" + String.valueOf(new Random().nextInt(4)+1) + ".mp3"));
		music.setVolume(0.125f);
		music.setLooping(true);
		music.play();
		init();                             // инициализация двух команд
		Gdx.graphics.setTitle("Герои ООП");

		crossBowMan = new Texture("units/CrossBowMan.png");
		magic = new Texture("units/Magic.png");
		priest = new Texture("units/Priest.png");
		peasant = new Texture("units/Peasant.png");
		robber = new Texture("units/Robber.png");
		sniper = new Texture("units/Sniper.png");
		spearMan = new Texture("units/SpearMan.png");

//		dx = 65;
//		dy = 45;

		dx = Gdx.graphics.getWidth()/10;
		System.out.println(dx);
		dy = Gdx.graphics.getHeight()/11;
		System.out.println(dy);
	}

	@Override
	public void render () {
		if (step <= 0 ) Gdx.graphics.setTitle("Первый ход!");
		else Gdx.graphics.setTitle("Ход №"+step);
		ScreenUtils.clear(1, 0, 0, 1);

		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		whiteSide.forEach(n -> {
			if (n.getHp() > 0) {
				switch (n.getClassName()) {
					case "Robber":
						batch.draw(robber, n.getPosition().getX() * dx, n.getPosition().getY() * dy);
						break;
					case "Priest":
						batch.draw(priest, n.getPosition().getX() * dx, n.getPosition().getY() * dy);
						break; //white
					case "Sniper":
						batch.draw(sniper, n.getPosition().getX() * dx, n.getPosition().getY() * dy);
						break; // white
					case "Peasant":
						batch.draw(peasant, n.getPosition().getX() * dx, n.getPosition().getY() * dy);
						break;
				}
			}
		});

		darkSide.forEach(n -> {
			if (n.getHp() > 0) {
				switch (n.getClassName()) {
					case "Magic":
						batch.draw(magic, n.getPosition().getX() * dx, n.getPosition().getY() * dy);
						break;
					case "Spearman":
						batch.draw(spearMan, n.getPosition().getX() * dx, n.getPosition().getY() * dy);
						break;
					case "Crossbowman":
						batch.draw(crossBowMan, n.getPosition().getX() * dx, n.getPosition().getY() * dy);
						break;
					case "Peasant":
						batch.draw(peasant, n.getPosition().getX() * dx, n.getPosition().getY() * dy);
						break;
				}
			}
		});

		batch.end();

		if (Gdx.input.justTouched() && !GameOver) {
			makeStep();                     // сделать STEP для всех юнитов
			step++;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}




	// -----------------------------------------------------------------------------------
	// ИНИЦИАЛИЗАЦИЯ ДВУХ КОМАНД
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
		// сортировка команды
//		whiteSide.sort(new Comparator<BaseHero>() {
//			@Override
//			public int compare(BaseHero u1, BaseHero u2) {
//				if (u2.getSpeed() - u1.getSpeed() == 0)
//					return (int)(u2.getHp() - (int)(u1.getHp()));
//				return (u2.getSpeed() - u1.getSpeed());
//			}
//		});

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
		// сортировка команды
		darkSide.sort(new Comparator<BaseHero>() {
			@Override
			public int compare(BaseHero u1, BaseHero u2) {
				if (u2.getSpeed() - u1.getSpeed() == 0)
					return (int)(u2.getHp() - (int)(u1.getHp()));
				return (u2.getSpeed() - u1.getSpeed());
			}
		});

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

	// метод STEP для обеих команд
	private static void makeStep(){
		BaseHero hero = whiteSide.get(0);
		for (int i = 0; i < GANG_SIZE; i++) {
			hero = whiteSide.get(i);
			hero.step(allUnits);
			if (hero.getGameOver() > 0) break;
			hero = darkSide.get(i);
			hero.step(allUnits);
			if (hero.getGameOver() > 0) break;
		}
		if (hero.getGameOver() > 0){
			GameOver = true;
			if (hero.getGameOver() == 1)
				System.out.println("\n  <<< Победила команда Green !!! >>>\n");
			else
				System.out.println("\n  <<< Победила команда Blue !!! >>>\n");
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