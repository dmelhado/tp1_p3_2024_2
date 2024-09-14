
package tp1_p3_2024_2.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import tp1_p3_2024_2.Fuente;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;


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
        setLayout(new BorderLayout(0, 0));

        JPanel midPanel = new JPanel();
        add(midPanel, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(80, 0));
        add(westPanel, BorderLayout.WEST);

        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(80, 0));
        add(eastPanel, BorderLayout.EAST);
        
        JPanel tituloDificultadPanel = new JPanel();
        tituloDificultadPanel.setPreferredSize(new Dimension(20, 50));
        tituloDificultadPanel.setLayout(new GridLayout(1, 3));
        
        JPanel tildesPanel = new JPanel();
        tildesPanel.setLayout(new GridLayout(1, 3));
        midPanel.add(tildesPanel);
        

        JButton btnConfirmar = new JButton("Volver al Menú");
        btnConfirmar.setPreferredSize(new Dimension(200, 50));
        btnConfirmar.setFont(mainFrame.fuentePersonalizada().deriveFont(12f));
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.cambiarVentana(MainFrame.S_VENTANAMENU);
            }
        });
        bottomPanel.add(btnConfirmar);

     
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));

        midPanel.add(tituloDificultadPanel);

        
        JCheckBox checkFacil = new JCheckBox("Fácil");
        tituloDificultadPanel.add(checkFacil);
        checkFacil.setHorizontalAlignment(SwingConstants.CENTER);
        checkFacil.setFont(mainFrame.fuentePersonalizada().deriveFont(16f));
        
        JCheckBox checkNormal = new JCheckBox("Normal");
        tituloDificultadPanel.add(checkNormal);
        checkNormal.setSelected(true);
        checkNormal.setHorizontalAlignment(SwingConstants.CENTER);
        checkNormal.setFont(mainFrame.fuentePersonalizada().deriveFont(16f));
        
        JCheckBox checkDificil = new JCheckBox("Difícil");
        tituloDificultadPanel.add(checkDificil);
        checkDificil.setHorizontalAlignment(SwingConstants.CENTER);
        checkDificil.setFont(mainFrame.fuentePersonalizada().deriveFont(16f));
        
        JLabel lblOpciones = new JLabel("DIFICULTAD");
        tildesPanel.add(lblOpciones);
        lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
        lblOpciones.setVerticalAlignment(SwingConstants.BOTTOM);
        lblOpciones.setFont(mainFrame.fuentePersonalizada().deriveFont(28f));

        
        
        checkDificil.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (checkDificil.isSelected()) {
              	 checkNormal.setSelected(false);
              	 checkFacil.setSelected(false);
              	 mainFrame.setBoardSize(5);
              
          }
          }
        });
        
        checkNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkNormal.isSelected()) {
                	 checkFacil.setSelected(false);
                	 checkDificil.setSelected(false);
                	 mainFrame.setBoardSize(4);
                
            }
            }
        });
        
        
        checkFacil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkFacil.isSelected()) {
                	 checkNormal.setSelected(false);
                	 checkDificil.setSelected(false);
                	 mainFrame.setBoardSize(3);
                
            }
            }
        });
        
              
       
        // Aca se puede agregar boton reglas o dejarlo asi
        JPanel emptyPanel = new JPanel();
        
        midPanel.add(emptyPanel);

        revalidate();
        repaint();
    }
}