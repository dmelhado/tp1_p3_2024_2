package interfaz;

import java.awt.BorderLayout;
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
import tp1_p3_2024_2.GameBoard.Direction;

public class VentanaJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private GameBoard gameBoard; 
    private JButton[][] buttons; 
    private JLabel scoreLabel;

	
	public VentanaJuego(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		iniciarJuego();

	}
	
	 private void iniciarJuego() {
	        removeAll(); 
	        setName("Rompecabezas Deslizante"); 
	        setBounds(100, 100, 640, 480);  
	        setLayout(new BorderLayout());

	        
	        JPanel topPanel = new JPanel();
	        add(topPanel, BorderLayout.NORTH);
	        topPanel.setLayout(new GridLayout(0, 2, 0, 0));

	        JLabel lblTitulo = new JLabel("Titulo de juego");
	        lblTitulo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 34));
	        topPanel.add(lblTitulo);

	        scoreLabel = new JLabel("Puntaje: 0"); 
	        scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 24));
	        topPanel.add(scoreLabel);

	        // Panel central para el tablero
	        JPanel gamePanel = new JPanel(new GridLayout(4, 4));
	        add(gamePanel, BorderLayout.CENTER);

	        gameBoard = new GameBoard(4); 
	        buttons = new JButton[4][4];

	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                JButton button = new JButton();
	                buttons[i][j] = button;
	                button.setFont(new Font("Arial", Font.PLAIN, 24)); 
	                button.addActionListener(new ButtonClickListener(i, j)); 
	                gamePanel.add(button);
	            }
	        }

	        actualizarTablero(); 

	        addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                Direction dir = null;
	                switch (e.getKeyCode()) {
	                    case KeyEvent.VK_W: dir = Direction.U; break; 
	                    case KeyEvent.VK_UP: dir = Direction.U; break; 
	                    case KeyEvent.VK_S: dir = Direction.D; break; 
	                    case KeyEvent.VK_DOWN: dir = Direction.D; break; 
	                    case KeyEvent.VK_A: dir = Direction.L; break; 
	                    case KeyEvent.VK_LEFT: dir = Direction.L; break; 
	                    case KeyEvent.VK_D: dir = Direction.R; break; 
	                    case KeyEvent.VK_RIGHT: dir = Direction.R; break; 
	                }
	                if (dir != null && gameBoard.move(dir)) {
	                    actualizarTablero(); 
	                }
	            }
	        });

	        setFocusable(true); 
	        requestFocusInWindow(); 

	        revalidate(); 
	        repaint(); 
	    }

	    private void actualizarTablero() {
	    	
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                int valor = gameBoard.getBoardValue(i, j);
	                buttons[i][j].setText(valor == 0 ? "" : String.valueOf(valor));
	            }
	        }

	        scoreLabel.setText("Puntaje: " + gameBoard.getGameScore().getScore());
	        
	        if (gameBoard.checkWinState()) {
	            JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado el juego con un puntaje de " + gameBoard.getGameScore().getScore() + ".", "Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
	            mainFrame.cambiarVentana(MainFrame.VENTANAMENU);
	        }
	        
	        revalidate();
	        repaint();
	        
	    }
	    
	    public void addNotify() {
	        super.addNotify();
	        requestFocusInWindow();  // Asegura que el foco está en esta ventana
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
	                dir = Direction.U;  // Arriba
	            } else if (x == blankX && y == blankY - 1) {
	                dir = Direction.D;  // Abajo
	            } else if (y == blankY && x == blankX + 1) {
	                dir = Direction.L;  // Izquierda
	            } else if (y == blankY && x == blankX - 1) {
	                dir = Direction.R;  // Derecha
	            }

	            if (dir != null && gameBoard.move(dir)) {
	                actualizarTablero(); 
	            }
	        }
	    }


}
