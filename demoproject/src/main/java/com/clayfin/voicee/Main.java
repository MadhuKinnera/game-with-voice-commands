package com.clayfin.voicee;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class Main {

	static Game game = new Game();

	public static void main(String... args) throws Exception {

		Configuration configuration = new Configuration();

		// Set path to acoustic model.
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		// Set path to dictionary.
		configuration.setDictionaryPath("src\\main\\resources\\1386.dic");
		// Set path to language model.
		configuration.setLanguageModelPath("src\\main\\resources\\1386.lm");

		LiveSpeechRecognizer recognizer = null;
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recognizer.startRecognition(true);

		System.out.println("The Intial Maze is ");
		Game.maze[0][0] = 'X';

		game.printMaze(Game.maze);

		System.out.println("Listening...");
		// Thread.sleep(1000);

		while (true) {
			String voiceInput = recognizer.getResult().getHypothesis();
			System.out.println("You Said : " + voiceInput);

			if (voiceInput.equalsIgnoreCase("stop"))
				break;

			game.play(voiceInput);

			if (Game.currentCol == Game.maze.length - 1 && Game.currentRow == Game.maze.length - 1) {
				System.out.println("Hooray..! You are a Path Finder ");
				break;
			}

		}

	}
}
