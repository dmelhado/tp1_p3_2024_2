package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import logica.Direction;
import logica.GameBoard;
import logica.Score;

public class VentanaJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private JButton[][] buttons;
	private JLabel scoreLabel;

	private GameBoard gameBoard;
	private Score gameScore;
	private int size;

	public VentanaJuego(MainFrame mainFrame, int opt_size, int opt_diff) {
		this.mainFrame = mainFrame;
		this.size = opt_size;
		this.gameBoard = new GameBoard(opt_size, opt_diff);
		this.gameScore = new Score(0); 
		iniciarJuego();

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				Direction dir = null;
				switch (e.getKeyCode()) {
				case KeyEvent.VK_W:
					dir = Direction.U;
					break;
				case KeyEvent.VK_UP:
					dir = Direction.U;
					break;
				case KeyEvent.VK_S:
					dir = Direction.D;
					break;
				case KeyEvent.VK_DOWN:
					dir = Direction.D;
					break;
				case KeyEvent.VK_A:
					dir = Direction.L;
					break;
				case KeyEvent.VK_LEFT:
					dir = Direction.L;
					break;
				case KeyEvent.VK_D:
					dir = Direction.R;
					break;
				case KeyEvent.VK_RIGHT:
					dir = Direction.R;
					break;
				}
				if (dir != null && gameBoard.move(dir)) {
					gameScore.addPoints();
					actualizarTablero();
				}
			}
		});

	}

	private void iniciarJuego() {
		removeAll();
		setName("Rompecabezas Deslizante");
		setBounds(100, 100, 640, 480);
		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblTitulo = new JLabel("Rompecabezas Deslizante");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(mainFrame.fuentePersonalizada().deriveFont(40f));
		topPanel.add(lblTitulo);

		// Panel central para el tablero. Si se quiere usar el design, agregar this.size + 1. GridLayout no puede empezar en (0,0)
		JPanel gamePanel = new JPanel(new GridLayout(this.size, this.size)); 
		gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agregar espaciado entre los botones
		add(gamePanel, BorderLayout.CENTER);

		JPanel botPanel = new JPanel();
		add(botPanel, BorderLayout.SOUTH);

		scoreLabel = new JLabel("Puntaje: 0");
		botPanel.add(scoreLabel);
		scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreLabel.setFont(mainFrame.fuentePersonalizada().deriveFont(26f));

		JPanel leftPanel = new JPanel();
		add(leftPanel, BorderLayout.WEST);

		JPanel RightPanel = new JPanel();
		add(RightPanel, BorderLayout.EAST);

		buttons = new JButton[this.size][this.size];

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				JButton button = new JButton();
				buttons[i][j] = button;

				button.setFocusable(false);
				button.setBackground(new Color(255, 255, 255));
				button.setFont(mainFrame.fuentePersonalizada().deriveFont(25f));
				gamePanel.add(button);
			}
		}

		actualizarTablero();

		setFocusable(true);
		requestFocusInWindow();
		revalidate();
		repaint();
	}

	private void actualizarTablero() {

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				int valor = gameBoard.getBoardValue(i, j);
				buttons[i][j].setFocusable(false);
				if (valor == 0) {
					buttons[i][j].setText(""); 
					buttons[i][j].setBackground(new Color(204, 204, 204)); // Color del botón vacío
				} else {
					buttons[i][j].setText(String.valueOf(valor)); 
					buttons[i][j].setBackground(null); // Color demas botones
					buttons[i][j].setForeground(new Color(255, 153, 0));
					buttons[i][j].setFont(mainFrame.fuentePersonalizada().deriveFont(30f)); 
					buttons[i][j].setForeground(Color.WHITE); // Cambiar el color del texto
					buttons[i][j].setBackground(new Color(70, 130, 180)); // Cambiar el color de fondo
				}
			}
		}

		scoreLabel.setText("Puntaje: " + this.gameScore.getScore());

		if (gameBoard.checkWinState()) {
			JOptionPane.showMessageDialog(this,
					"¡Felicidades! Has ganado el juego con un puntaje de " + this.gameScore.getScore() + ".",
					"Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
			mainFrame.cambiarVentana(MainFrame.S_VENTANAMENU);
		}

		revalidate();
		repaint();

	}

	// Se asegura que se mantenga el foco en esta ventana para lo que es el manejo
	// de teclas y actualizartablero
	public void addNotify() {
		super.addNotify();
		requestFocusInWindow();
	}

}
