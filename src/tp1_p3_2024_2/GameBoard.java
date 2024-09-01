package tp1_p3_2024_2;

import java.util.Random;
import tp1_p3_2024_2.Score;

public class GameBoard {
	private int[][] board;
	private int size;
	private int blankX;
	private int blankY;
	public enum Direction {
		U, D, L, R
	}
	
	Score gameScore = new Score(0); 


	public GameBoard(int s) {
	    this.size = s;
	    this.board = new int[s][s];

	    // Poblar tablero con solución (ordenado horizontalmente)
	    int number = 1; // Comenzar desde 1
	    for (int i = 0; i < s; i++) {
	        for (int j = 0; j < s; j++) {
	            // Asignar el número actual
	            this.board[i][j] = number;
	            number++;

	            // Si es el último casillero, llenarlo con 0 y guardar la posición
	            if (i == s - 1 && j == s - 1) {
	                this.board[i][j] = 0;
	                this.blankX = i;
	                this.blankY = j;
	            }
	        }
	    }
	    this.randomize(20); //aca podemos agregar como dijo Ema mayor dificultad y mayor cantidad de random
	    gameScore.setRandomScore(true);
	    
	}

	// true si movio ok, false si no se pudo mover
	public boolean move(Direction dir) {
	    int nextX = this.blankX;
	    int nextY = this.blankY;

	    switch (dir) {
	        case U:
	            nextX--;  // Mover arriba significa decrementar X
	            break;
	        case D:
	            nextX++;  // Mover abajo significa incrementar X
	            break;
	        case L:
	            nextY--;  // Mover izquierda significa decrementar Y
	            break;
	        case R:
	            nextY++;  // Mover derecha significa incrementar Y
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
	    if(gameScore.getRandomScore()==true) {
	    	gameScore.addPoints();
	    }
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

	// la tabla de WindowBuilder NECESITA Object[][]
	public Object[][] getBoard(){
		Object[][] res = new Object[this.size][this.size];
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				res[j][i] = this.board[i][j];
			}
		}
		return res;
	}
	
	/*public boolean checkWinState() {
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

	}*/
	
	public boolean checkWinState() {
	    int count = 1;
	    int boardLength = this.size * this.size;

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


	//getters y setters
	public int getBoardValue(int x, int y) {
	    return this.board[x][y];
	}


	public int[][] getBoard1() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int getBlankX() {
		return blankX;
	}

	public void setBlankX(int blankX) {
		this.blankX = blankX;
	}

	public int getBlankY() {
		return blankY;
	}

	public void setBlankY(int blankY) {
		this.blankY = blankY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Score getGameScore() {
		return gameScore;
	}

	public void setGameScore(Score gameScore) {
		this.gameScore = gameScore;
	}

}
