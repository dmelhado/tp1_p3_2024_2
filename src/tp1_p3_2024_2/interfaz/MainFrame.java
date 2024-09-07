package tp1_p3_2024_2.interfaz;

import java.awt.EventQueue;
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
	// TODO: Quiza convenga cambiar estos por Enum
	final static String S_VENTANAMENU = "Ventana Menu";
	final static String S_VENTANAJUEGO = "Ventana Juego";
	final static String S_VENTANAOPCIONES = "Ventana Opciones";
	private VentanaMenu ventanaMenu;
	private VentanaOpciones ventanaOpciones;
	private VentanaJuego ventanaJuego;
	private CardLayout cardLayout;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(new CardLayout(0, 0));
		cardLayout = new CardLayout();
		getContentPane().setLayout(cardLayout);

		ventanaMenu = new VentanaMenu(this);
		ventanaOpciones = new VentanaOpciones(this);

		// añade ventanas al contenedor

		getContentPane().add(ventanaMenu, S_VENTANAMENU);
		getContentPane().add(ventanaOpciones, S_VENTANAOPCIONES);

		revalidate();
		repaint();

	}

	public void cambiarVentana(String ventana) {
		if (ventana.equals(S_VENTANAJUEGO)) {
			agregarMenuJuego();
			ventanaJuego = new VentanaJuego(this);
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
	}

}
