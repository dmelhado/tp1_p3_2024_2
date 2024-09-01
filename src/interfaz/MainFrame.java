package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tp1_p3_2024_2.GameBoard;
import tp1_p3_2024_2.GameBoard.Direction;
import tp1_p3_2024_2.Score;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private GameBoard gameBoard; 
    private JButton[][] buttons; 
    private JLabel scoreLabel; // Nuevo JLabel para el puntaje

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

  
    public MainFrame() {
        MenuPrincipal();
    }

   
    private void MenuPrincipal() {
        getContentPane().removeAll(); 
        getContentPane().repaint(); 
        setTitle("Rompecabezas Deslizante"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setBounds(100, 100, 640, 480); 
        getContentPane().setLayout(null); 

        
        JLabel lblTitulo = new JLabel("titulo del juego");
        lblTitulo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 34));
        lblTitulo.setBounds(154, 23, 312, 51);
        getContentPane().add(lblTitulo);

      
        JButton btnIniciar = new JButton("INICIAR");
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJuego(); //
            }
        });
        btnIniciar.setBounds(222, 150, 154, 43);
        getContentPane().add(btnIniciar);

        
        JButton btnOpciones = new JButton("OPCIONES");
        btnOpciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarOpciones(); 
            }
        });
        btnOpciones.setBounds(222, 215, 154, 43);
        getContentPane().add(btnOpciones);

     
        JButton btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salirDelJuego(); 
            }
        });
        btnSalir.setBounds(222, 286, 154, 43);
        getContentPane().add(btnSalir);
    }

    private void iniciarJuego() {
        getContentPane().removeAll(); 
        setTitle("Rompecabezas Deslizante"); 

       
        getContentPane().setLayout(new BorderLayout());

        
        JPanel topPanel = new JPanel(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);

        JLabel lblTitulo = new JLabel("Titulo de juego");
        lblTitulo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 34));
        topPanel.add(lblTitulo, BorderLayout.WEST);

        scoreLabel = new JLabel("Puntaje: 0"); 
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        topPanel.add(scoreLabel, BorderLayout.EAST);

        // Panel central para el tablero
        JPanel gamePanel = new JPanel(new GridLayout(4, 4));
        getContentPane().add(gamePanel, BorderLayout.CENTER);

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
        requestFocus(); 

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
        }

        revalidate();
        repaint();
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

    
    private void iniciarOpciones() {
        getContentPane().removeAll(); 
        setTitle("Opciones");
        setSize(640, 480);
        getContentPane().setLayout(null); 

        JLabel lblOpciones = new JLabel("Estas en opciones");
        lblOpciones.setFont(new Font("Arial", Font.PLAIN, 24));
        lblOpciones.setBounds(220, 150, 200, 30);
        getContentPane().add(lblOpciones);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal(); 
            }
        });
        btnVolver.setBounds(222, 215, 154, 43);
        getContentPane().add(btnVolver);

        revalidate(); 
        repaint(); 
    }

    
    private void salirDelJuego() {
        dispose();
    }
}
