package tp1_p3_2024_2;

import java.util.Random;

public class GameBoard {
	private int[][] board;
	private int size;
	private int blankX;
	private int blankY;

	public enum Direction {
		U, D, L, R
	}

	public GameBoard(int s) {
		this.size = s;
		this.board = new int[s][s];

		// poblar tablero con solucion (pues es una instancia valida)
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				this.board[i][j] = i + (j * this.size) + 1;

				// si es el ultimo casillero, llenar con 0 y guardar posicion
				if (i == s - 1 && j == s - 1) {
					this.board[i][j] = 0;
					this.blankX = i;
					this.blankY = j;
				}
			}
		}
	}

	// true si movio ok, false si no se pudo mover
	public boolean move(Direction dir) {

		int nextX = this.blankX;
		int nextY = this.blankY;

		// TODO: Quiza haya que invertir los movimientos, o agregar una opcion
		switch (dir) {
		case U:
			nextY--;
			break;
		case D:
			nextY++;
			break;
		case L:
			nextX--;
			break;
		case R:
			nextX++;
			break;
		}

		if (nextX < 0 || nextX >= this.size || nextY < 0 || nextY >= this.size) {
			return false;
		}

		// todo ok. mover piezas y posicion del vacio
		this.board[this.blankX][this.blankY] = this.board[nextX][nextY];
		this.board[nextX][nextY] = 0;
		this.blankX = nextX;
		this.blankY = nextY;

		return true;

	}

	// se pueden hacer cosas un poco mas locas para hacer un random mas "equilibrado"
	// como secuencias de valores (como en tetris the grand master)
	// pero esto por ahora deberia servir
	// TODO: esta funcion no va a servir si se quiere ver como se randomiza todo en vivo 
	// desde la interfaz
	public void randomize(int c) {
		Random r = new Random();
		while (c > 0) {
			Direction randomDir = Direction.values()[r.nextInt(4)];
			// queremos MOVER c veces, no INTENTAR MOVER c veces
			// recordar que this.move devuelve true si se movio exitosamente.
			if (this.move(randomDir)) {
				c--;
			}
		}
	}

	public boolean checkWinState() {

		boolean res = true;
		int count = 1;
		int boardLength = this.size * this.size;

		// un for no sirve realmente aca, o no se me ocurrio como implementarlo de
		// manera limpia.
		int i = 0;
		int j = 0;
		while (count < boardLength && res) {
			res = this.board[i][j] == count;
			count++;
			i++;
			if (i == this.size) {
				i = 0;
				j++;
			}
		}

		return res;

	}

}
