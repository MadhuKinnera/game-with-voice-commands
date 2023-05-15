package com.clayfin.voicee;

public class Game {

	static int n;

	static int currentRow;
	static int currentCol;

	static char[][] maze = { { '1', '0', '0', '0' }, { '1', '1', '0', '1' }, { '0', '1', '0', '0' },
			{ '1', '1', '1', '1' } };

//	static char[][] maze = { { '1', '1', '1', '1' }, { '1', '1', '1', '1' }, { '1', '1', '1', '1' },
//			{ '1', '1', '1', '1' } };

	public void play(String inputCommand) {

		if (inputCommand == null || inputCommand.equalsIgnoreCase("stop"))
			return;

		n = maze.length;

		// Scanner sc = new Scanner(System.in);

		printMaze(maze);

//		while (true) {
//			System.out.println("\nEnter Command . Press X to quit");
//			try {
//				if (inputCommand.equals("x"))
//					break;
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
		acceptCommand(inputCommand, maze);
//
//			if (currentRow == maze.length - 1 && currentCol == maze.length - 1) {
//				System.out.println("\nHooray You are a Path Finder ");
//				break;
//			}
//		}

		System.out.println("The Updated Maze is ");
		printMaze(maze);

	}

	public void acceptCommand(String command, char[][] maze) {
		command = command.toUpperCase();

		boolean flag = false;

		if (command.equals("LEFT") && Path.isSafe(currentRow, currentCol - 1)) {
			currentCol--;
			flag = true;
		}
		if (command.equals("RIGHT") && Path.isSafe(currentRow, currentCol + 1)) {
			currentCol++;
			flag = true;
		}
		if (command.equals("UP") && Path.isSafe(currentRow - 1, currentCol)) {
			currentRow--;
			flag = true;
		}
		if (command.equals("DOWN") && Path.isSafe(currentRow + 1, currentCol)) {
			currentRow++;
			flag = true;
		}

		if (command.equals("PATH")) {
			if (Path.solveMaze()) {
				System.out.println("==============");
				System.out.println("Path Exist ");
				System.out.println("==============");
			} else {
				System.out.println("Path Dudent Exist");
				return;
			}
		}

		if (flag) {
			maze[currentRow][currentCol] = 'X';
			printMaze(maze);
		} else {
			System.out.println("Invalid Move");
			printMaze(maze);
		}

	}

	public void printMaze(char[][] maze) {

		System.out.println("=================");

		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze.length; col++) {
				System.out.print(maze[row][col] + " ");
			}
			System.out.println();
		}

		System.out.println("=================");

	}

}
