package com.clayfin.voicee;

public class Path {

	static int n = Game.maze.length;

	static int[][] sol = new int[n][n];

	static char[][] maze = Game.maze;

	public static boolean solveMaze() {
		
		
		//System.out.println("Solving Rat in Maze Problem");

		if (solveMazeUtil(0, 0)) {
			sol[n - 1][n - 1] = 1;
			return true;
		}
		return false;
		
	
	}

	public static boolean solveMazeUtil(int row, int col) {

		if (row == n - 1 && col == n - 1)
			return true;

		if (sol[row][col] == 1)
			return false;

		sol[row][col] = 1;

		if (isSafe(row + 1, col)) {
			return solveMazeUtil(row + 1, col);
		}

		if (isSafe(row, col + 1)) {
			return solveMazeUtil(row, col + 1);
		}

		sol[row][col] = 0;// backtracking line

		return false;

	}

	public static boolean isSafe(int row, int col) {
		return (row >= 0 && row < maze.length && col >= 0 && col < maze.length
				&& (maze[row][col] == '1' || maze[row][col] == 'X'));

	}
}
