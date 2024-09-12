
package tp1_p3_2024_2.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaOpciones extends JPanel {

    private static final long serialVersionUID = 1L;
    private MainFrame mainFrame;

    public VentanaOpciones(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        iniciarOpciones();
    }

    public void iniciarOpciones() {
        removeAll();
 
        setSize(640, 480);
        setLayout(null);

        JLabel lblOpciones = new JLabel("Elegir dificultad");
        lblOpciones.setFont(new Font("Arial", Font.PLAIN, 24));
        lblOpciones.setBounds(220, 150, 200, 30);
        add(lblOpciones);

        JButton btn3x3 = new JButton("Fácil");
        btn3x3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setBoardSize(3);
            }
        });
        btn3x3.setBounds(222, 185, 154, 43); 
        add(btn3x3);

        JButton btn4x4 = new JButton("Normal");
        btn4x4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setBoardSize(4);
            }
        });
        btn4x4.setBounds(222, 235, 154, 43); 
        add(btn4x4);

        JButton btn5x5 = new JButton("Difícil");
        btn5x5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setBoardSize(5);
            }
        });
        btn5x5.setBounds(222, 285, 154, 43);
        add(btn5x5);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.cambiarVentana(MainFrame.S_VENTANAMENU);
            }
        });
        btnConfirmar.setBounds(222, 335, 154, 43);
        add(btnConfirmar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.cambiarVentana(MainFrame.S_VENTANAMENU);
            }
        });
        btnVolver.setBounds(222, 385, 154, 43); 

        revalidate();
        repaint();
    }
}