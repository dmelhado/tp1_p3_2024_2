package interfaz;

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

	        JLabel lblOpciones = new JLabel("Estas en opciones");
	        lblOpciones.setFont(new Font("Arial", Font.PLAIN, 24));
	        lblOpciones.setBounds(220, 150, 200, 30);
	        add(lblOpciones);

	        JButton btnVolver = new JButton("Volver");
	        btnVolver.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	mainFrame.cambiarVentana(MainFrame.VENTANAMENU);
	               
	            }
	        });
	        btnVolver.setBounds(222, 215, 154, 43);
	        add(btnVolver);

	        revalidate(); 
	        repaint(); 
	    }


}