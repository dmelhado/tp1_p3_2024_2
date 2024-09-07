package tp1_p3_2024_2.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tp1_p3_2024_2.GameBoard;
import tp1_p3_2024_2.Direction;

public class VentanaJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private GameBoard gameBoard;
	private JButton[][] buttons;
	private JLabel scoreLabel;

	private int size;

	public VentanaJuego(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.size = 4;
		gameBoard = new GameBoard(this.size);
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
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
		topPanel.add(lblTitulo);

		// Panel central para el tablero
		JPanel gamePanel = new JPanel(new GridLayout(this.size, this.size));
		add(gamePanel, BorderLayout.CENTER);

		JPanel botPanel = new JPanel();
		add(botPanel, BorderLayout.SOUTH);

		scoreLabel = new JLabel("Puntaje: 0");
		botPanel.add(scoreLabel);
		scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

		JPanel leftPanel = new JPanel();
		add(leftPanel, BorderLayout.WEST);

		JPanel RightPanel = new JPanel();
		add(RightPanel, BorderLayout.EAST);

		buttons = new JButton[this.size][this.size];

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				JButton button = new JButton();
				buttons[i][j] = button;

				button.setBackground(new Color(255, 255, 255));
				button.setFont(new Font("Lucida Fax", Font.BOLD, 25));
				button.addActionListener(new ButtonClickListener(i, j));
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
				if (valor == 0) {
					buttons[i][j].setText(""); // Espacio vacío, sin texto
					buttons[i][j].setBackground(new Color(204, 204, 204)); // Color del botón vacío
				} else {
					buttons[i][j].setText(String.valueOf(valor)); // numero boton
					buttons[i][j].setBackground(null); // Color demas botones
					buttons[i][j].setForeground(new Color(255, 153, 0));

				}
			}
		}

		scoreLabel.setText("Puntaje: " + gameBoard.getGameScore().getScore());

		if (gameBoard.checkWinState()) {
			JOptionPane.showMessageDialog(this,
					"¡Felicidades! Has ganado el juego con un puntaje de " + gameBoard.getGameScore().getScore() + ".",
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

	private class ButtonClickListener implements ActionListener {
		private int x, y;

		public ButtonClickListener(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void actionPerformed(ActionEvent e) {
			Direction dir = null;
			int blankX = gameBoard.getBlankX();
			int blankY = gameBoard.getBlankY();

			if (x == blankX && y == blankY + 1) {
				dir = Direction.U; // Arriba
			} else if (x == blankX && y == blankY - 1) {
				dir = Direction.D; // Abajo
			} else if (y == blankY && x == blankX + 1) {
				dir = Direction.L; // Izquierda
			} else if (y == blankY && x == blankX - 1) {
				dir = Direction.R; // Derecha
			}

			if (dir != null && gameBoard.move(dir)) {
				actualizarTablero();
			}
		}
	}

}
