package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		MenuPrincipal();
		
	}
	private void MenuPrincipal()
	{
		getContentPane().removeAll();
        getContentPane().repaint();
		setTitle("Rompecabezas Deslizante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Rompecabezas Deslizante");
		lblTitulo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 34));
		lblTitulo.setBounds(154, 23, 312, 51);
		getContentPane().add(lblTitulo);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego();
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
		
		revalidate();
		repaint();
	}
	
	
	
	  private void iniciarJuego() {
		  	getContentPane().removeAll();  // Quitar todos los componentes actuales
	        setTitle("Rompecabezas Deslizante");
	        setSize(640, 480);
	        getContentPane().setLayout(null);
	        JLabel btnEjemplo = new JLabel("Estas In Game");
	        btnEjemplo.setBounds(200, 180, 100, 30);
	        getContentPane().add(btnEjemplo);
	        

	        // Refrescar la ventana
	        revalidate();
	        repaint();

	  }
	  
	  private void iniciarOpciones()
	  {
		  getContentPane().removeAll();
		  setTitle("Rompecabezas Deslizante");
		  setSize(640, 480);
		  getContentPane().setLayout(null);
		  JLabel btnOpcionesYa = new JLabel("Estas en opciones");
		  btnOpcionesYa.setBounds(200, 180, 100, 30);
		  getContentPane().add(btnOpcionesYa);
		  JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuPrincipal();
				}
			});
			btnVolver.setBounds(222, 150, 154, 43);
			add(btnVolver);
		  
		  revalidate();
		  repaint();
		  
	  }
	  
	  private void salirDelJuego()
	  {
		  dispose();
	  }
	  
	 
}