package tp1_p3_2024_2;

//El Score es estilo Golf, por eso se guarda en el betterScore la partida que haya hecho menos movimientos para ganar

public class Score {
    private int score;
    private int betterScore;

    // Constructor
    public Score() {
        this.score = 0;
        this.betterScore = 0;
    }

    public Score(int initialScore) {
        this.score = initialScore;
        this.betterScore = initialScore;
    }

    public void addPoints() {
        this.score += 1;
    }

    public void resetScore() {
        this.score = 0;
    }
    
    
    // deberia llamarlo cuando termine la partida para comparar, no lo puedo llamar antes porque si no se guardaria siempre 1 movimiento solo
    public void updateBetterScore() {
        if (this.score < this.betterScore) {
            this.betterScore = this.score;
        }
    }

    public int getScore() {
        return this.score;
    }

    public int getBetterScore() {
        return this.betterScore;
    }

    @Override
    public String toString() {
        return "Score: " + this.score + ", High Score: " + this.betterScore;
    }
}
