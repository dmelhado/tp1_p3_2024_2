package tp1_p3_2024_2;

// clase encargada de conectar tablero, puntaje e interfaz. toda la logica sucede aca
public class Controller {
	private GameBoard board;
	private Score score;
	
	public Controller(int size, int bestScore) {
		this.board = new GameBoard(size);
		this.score = new Score(bestScore);
		
		// puede que haga falta sacarlo del constructor y que sea su propio metodo.
		this.board.randomize(size * size * 4);
	}
	
	// conviene devolver un boolean.
	// asi se puede determinar si hace falta volver a dibujar el tablero
	// o tiramos un mensaje de que intente otro movivimento
	public boolean move(Direction dir) {
		boolean success = this.board.move(dir);
		if (success) {
			score.addPoints();
		}
		return success;
	}
	
	// GETTERS:
	
	// para devolverle a la interfaz lo que tiene que dibujar
	public Object[][] getBoard(){
		return this.board.getBoard();
	}
	
	// necesario para informar que termino el juego.
	public boolean getWinState() {
		return this.board.checkWinState();
	}
	
	public int getScore() {
		return this.score.getScore();
	}
	
	public int getBestScore() {
		return this.score.getBestScore();
	}
	
}
