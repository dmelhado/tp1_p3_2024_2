package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		
		
	}
	
	
	
	  private void iniciarJuego() {
		  	getContentPane().removeAll();  // Quitar todos los componentes actuales
	        setTitle("Rompecabezas Deslizante");
	        setSize(640, 480);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(new BorderLayout(0, 0));
			
			JPanel panelPrincipal = new JPanel();
			getContentPane().add(panelPrincipal, BorderLayout.CENTER);
			panelPrincipal.setLayout(new BorderLayout(20, 20));
			
			JPanel panelSuperior = new JPanel();
			panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
			panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
			
			JPanel panelInferior = new JPanel();
			panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
			panelInferior.setLayout(new GridLayout(0, 2, 50, 50));
			
			JLabel lblNewLabel_2 = new JLabel("Tiempo:");
			panelInferior.add(lblNewLabel_2);
			
			JLabel lblNewLabel_1 = new JLabel("Puntaje:");
			panelInferior.add(lblNewLabel_1);
			
			JPanel panelCentral = new JPanel();
			panelPrincipal.add(panelCentral, BorderLayout.CENTER);
			panelCentral.setLayout(new GridLayout(4, 4, 0, 0));
			
			JButton espacioUno = new JButton("1");
			espacioUno.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioUno);
			
			JButton espacioDos = new JButton("2");
			espacioDos.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioDos);
			
			JButton espacioTres = new JButton("3");
			espacioTres.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioTres);
			
			JButton espacioCuatro = new JButton("4");
			espacioCuatro.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioCuatro);
			
			JButton espacioCinco = new JButton("5");
			espacioCinco.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioCinco);
			
			JButton espacioSeis = new JButton("6");
			espacioSeis.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioSeis);
			
			JButton espacioSiete = new JButton("7");
			espacioSiete.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioSiete);
			
			JButton espacioOcho = new JButton("8");
			espacioOcho.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioOcho);
			
			JButton espacioNueve = new JButton("9");
			espacioNueve.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioNueve);
			
			JButton espacioDiez = new JButton("10");
			espacioDiez.setFont(new Font("Lucida Fax", Font.BOLD, 25));	
			panelCentral.add(espacioDiez);
			
			JLabel espacioVacio = new JLabel("Espacio Vacio");
			espacioVacio.setHorizontalAlignment(SwingConstants.CENTER);
			espacioVacio.setForeground(new Color(0, 0, 0));
			espacioVacio.setBackground(new Color(0, 0, 0));
			panelCentral.add(espacioVacio);
			
			JButton espacioOnce = new JButton("11");
			espacioOnce.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioOnce);
			
			JButton espacioDoce = new JButton("12");
			espacioDoce.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioDoce);
			
			JButton espacioTrece = new JButton("13");
			espacioTrece.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioTrece);
			
			JButton espacioCatorce = new JButton("14");
			espacioCatorce.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioCatorce);
			
			JButton espacioQuince = new JButton("15");
			espacioQuince.setFont(new Font("Lucida Fax", Font.BOLD, 25));
			panelCentral.add(espacioQuince);
			
			JPanel panelIzquierda = new JPanel();
			panelPrincipal.add(panelIzquierda, BorderLayout.WEST);
			
			JPanel panelDerecha = new JPanel();
			panelPrincipal.add(panelDerecha, BorderLayout.EAST);
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("Juego");
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Volver al Menu");
			mnNewMenu.add(mntmNewMenuItem);
			
			JMenuItem mntmNewMenuItem_3 = new JMenuItem("Salir");
			mnNewMenu.add(mntmNewMenuItem_3);
			
			JMenu mnNewMenu_1 = new JMenu("Ayuda");
			menuBar.add(mnNewMenu_1);
			
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("Reglas");
			mnNewMenu_1.add(mntmNewMenuItem_2);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Acerca De");
			mnNewMenu_1.add(mntmNewMenuItem_1);

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
			getContentPane().add(btnVolver);
		  
		  revalidate();
		  repaint();
		  
	  }
	  
	  private void salirDelJuego()
	  {
		  dispose();
	  }
}