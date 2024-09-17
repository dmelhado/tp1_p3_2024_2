package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	// IDENTIFICADORES DE VENTANA//
	final static String S_VENTANAMENU = "Ventana Menu";
	final static String S_VENTANAJUEGO = "Ventana Juego";
	final static String S_VENTANAOPCIONES = "Ventana Opciones";
	private VentanaMenu ventanaMenu;
	private VentanaOpciones ventanaOpciones;
	private VentanaJuego ventanaJuego;
	private CardLayout cardLayout;

	private int boardSize;
	private int difficulty;

	public MainFrame() {
		setTitle("Rompecabezas Deslizante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(new CardLayout(0, 0));
		this.cardLayout = new CardLayout();
		getContentPane().setLayout(cardLayout);

		this.ventanaMenu = new VentanaMenu(this);
		this.ventanaOpciones = new VentanaOpciones(this);

		// añade ventanas al contenedor
		getContentPane().add(ventanaMenu, S_VENTANAMENU);
		getContentPane().add(ventanaOpciones, S_VENTANAOPCIONES);

		this.boardSize = 4;
		this.difficulty = 2;

		revalidate();
		repaint();

	}

	public void cambiarVentana(String ventana) {
		if (ventana.equals(S_VENTANAJUEGO)) {
			agregarMenuJuego();
			ventanaJuego = new VentanaJuego(this, this.boardSize, this.difficulty);
			getContentPane().add(ventanaJuego, S_VENTANAJUEGO);
			revalidate();
			repaint();

		} else {
			setJMenuBar(null);
		}

		cardLayout.show(getContentPane(), ventana);
		getContentPane().revalidate();
		getContentPane().repaint();
	}

	public void agregarMenuJuego() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu opcionMenu = new JMenu("Juego");
		menuBar.add(opcionMenu);

		JMenuItem VolverMenu = new JMenuItem("Volver al Menú");
		opcionMenu.add(VolverMenu);
		VolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarVentana(S_VENTANAMENU);
			}
		});

		JMenuItem SalirJuego = new JMenuItem("Salir del Juego");
		opcionMenu.add(SalirJuego);
		SalirJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Si", "No" };
				int opcion = JOptionPane.showOptionDialog(ventanaJuego, "¿Estas seguro que deseas salir del juego?",
						"Advertencia", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						null);
				if (JOptionPane.YES_OPTION == opcion) {
					dispose();
				}
			}
		});

		JMenu opcionAyuda = new JMenu("Ayuda");
		menuBar.add(opcionAyuda);

		JMenuItem reglas = new JMenuItem("Cómo jugar");
		opcionAyuda.add(reglas);
		reglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaReglas dialog = new VentanaReglas(MainFrame.this);
				dialog.setVisible(true);
			}
		});
		JMenuItem acercaDe = new JMenuItem("Acerca de");
		opcionAyuda.add(acercaDe);
		acercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] option = { "Volver" };
				String mensaje = "Proyecto creado para Programación III por: \n     -Dante Melhado,  \n     -Ignacio Aranda Bao,  \n     -Emanuel Suarez.";
				JOptionPane.showOptionDialog(ventanaJuego, mensaje, "Información del Proyecto",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
			}

		});
	}

	public void setDifficulty(int d) {
		this.difficulty = d;
	}

	public void setBoardSize(int s) {
		this.boardSize = s;
	}

	public Font fuentePersonalizada() {
		Font fuentePersonalizada = Fuente.cargarFuente("fonts/upheavtt.ttf");
		return fuentePersonalizada;
	}
}
