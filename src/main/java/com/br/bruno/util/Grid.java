package com.br.bruno.util;

public class Grid {
	private int[][] numberOfObjects = new int[5][5];

	public void put(int x, int y) {
		numberOfObjects[y][x]++;
	}

	public void pick(int x, int y) {
		numberOfObjects[y][x]--;
	}
}