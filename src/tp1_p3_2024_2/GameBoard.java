package tp1_p3_2024_2;

public class GameBoard {
	private int[][] board;
	private int size;
	private BlankSquare blankPosition;
	
	private class BlankSquare{
		int x;
		int y;
		
		
	}
	
	public GameBoard(int s) {
		this.size = s;
		this.board = new int[s][s];
		
		// poblar tablero con solucion (pues es una instancia valida)
		for (int i = 0; i < s; i++) {
			for(int j = 0; j < s; j++) {
				this.board[i][j] = i + j + 1;
			}
		}
	}
}
