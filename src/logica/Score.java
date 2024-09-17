package logica;

//El Score es estilo Golf, por eso se guarda en el betterScore la partida que haya hecho menos movimientos para ganar

public class Score {
	private int score;
	private int bestScore;

	// Constructor
	public Score(int bestScore) {
		this.score = 0;
		this.bestScore = bestScore;
	}

	public void addPoints() {
		this.score += 1;
	}

	public void resetScore() {
		this.score = 0;
	}

	// deberia llamarlo cuando termine la partida para comparar, no lo puedo llamar
	// antes porque si no se guardaria siempre 1 movimiento solo
	public void updateBestScore() {
		if (this.score < this.bestScore) {
			this.bestScore = this.score;
		}
	}

	public int getScore() {
		return this.score;
	}

	public int getBestScore() {
		return this.bestScore;
	}

	@Override
	public String toString() {
		return "Score: " + this.score + ", High Score: " + this.bestScore;
	}
}
