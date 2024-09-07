package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;

	
	public VentanaMenu(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		MenuPrincipal();

	}
	
	
	 public void MenuPrincipal() {
	        removeAll(); 
	        repaint(); 
	        setName("Rompecabezas Deslizante"); 	        
	        setBounds(100, 100, 640, 480); 
	       setLayout(null); 

	        
	        JLabel lblTitulo = new JLabel("titulo del juego");
	        lblTitulo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 34));
	        lblTitulo.setBounds(154, 23, 312, 51);
	        add(lblTitulo);

	      
	        JButton btnIniciar = new JButton("INICIAR");
	        btnIniciar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	mainFrame.cambiarVentana(MainFrame.VENTANAJUEGO);
	                
	            }
	        });
	        btnIniciar.setBounds(222, 150, 154, 43);
	        add(btnIniciar);

	        
	        JButton btnOpciones = new JButton("OPCIONES");
	        btnOpciones.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	mainFrame.cambiarVentana(MainFrame.VENTANAOPCIONES);
	            	
	               
	            }
	        });
	        btnOpciones.setBounds(222, 215, 154, 43);
	        add(btnOpciones);

	     
	        JButton btnSalir = new JButton("SALIR");
	        btnSalir.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	salirDelJuego();
	            }
	        });
	        btnSalir.setBounds(222, 286, 154, 43);
	        add(btnSalir);
	    }	
	 
	 
	 
	 private void salirDelJuego() {
	        mainFrame.dispose();
	    }

}