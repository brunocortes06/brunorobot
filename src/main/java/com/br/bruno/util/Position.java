package com.br.bruno.util;

public class Position {

	public int x = 0;
	public int y = 0;

	public boolean isValidPostinion(int linha, int coluna) {
		int[][] numberOfObjects = new int[5][5];
		int[][] mat = new int[linha+1][coluna+1];

		if((mat.length >= 0) && (mat.length <= numberOfObjects.length)){
			if((mat[0].length >= 0) && (mat[0].length <= numberOfObjects[1].length)) {
				return true;
			}
		}
		return false;
	}
}
