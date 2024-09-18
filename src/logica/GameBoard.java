package logica;

import java.util.Random;

public class GameBoard {
	private int[][] board;
	private int size;
	private int blankX;
	private int blankY;

	public GameBoard(int s, int diff) {
		this.size = s;
		this.board = new int[s][s];

		// Poblar tablero con solución (ordenado horizontalmente)
		int number = 1; 
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				// Asignar el número actual
				this.board[i][j] = number;
				number++;

				
				if (i == s - 1 && j == s - 1) {
					this.board[i][j] = 0;
					this.blankX = i;
					this.blankY = j;
				}
			}
		}
		this.randomize((int) (Math.pow(s, 2) * Math.pow(2, diff)));
	}

	
	public boolean move(Direction dir) {
		int nextX = this.blankX;
		int nextY = this.blankY;

		switch (dir) {
		case U:
			nextX--; // Mover arriba significa decrementar X
			break;
		case D:
			nextX++; // Mover abajo significa incrementar X
			break;
		case L:
			nextY--; // Mover izquierda significa decrementar Y
			break;
		case R:
			nextY++; // Mover derecha significa incrementar Y
			break;
		}

		if (nextX < 0 || nextX >= this.size || nextY < 0 || nextY >= this.size) {
			return false;
		}

		// Realizar el movimiento
		this.board[this.blankX][this.blankY] = this.board[nextX][nextY];
		this.board[nextX][nextY] = 0;
		this.blankX = nextX;
		this.blankY = nextY;

		return true;
	}

	
	private void randomize(int c) {
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
		int count = 1;

		// Verificar cada posición excepto la última
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				// La última posición debe ser 0 (espacio en blanco)
				if (i == this.size - 1 && j == this.size - 1) {
					return this.board[i][j] == 0;
				}
				// Si el valor en la posición no es el esperado, no ha ganado
				if (this.board[i][j] != count) {
					return false;
				}
				count++;
			}
		}

		return true;
	}

	// getters y setters
	public int getBoardValue(int x, int y) {
		return this.board[x][y];
	}

	public int getBlankX() {
		return blankX;
	}

	public int getBlankY() {
		return blankY;
	}

	// Meter setters a lo loco es mala idea (rompe encapsulamiento)
	// Por ahora los dejo aca abajo, pero creo que hay que evitarlos

	public void setSize(int size) {
		this.size = size;
	}

	public void setBlankX(int blankX) {
		this.blankX = blankX;
	}

	public void setBlankY(int blankY) {
		this.blankY = blankY;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
}
