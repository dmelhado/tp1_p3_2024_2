package tp1_p3_2024_2.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class VentanaMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	
	// usado para ensanchar los paneles
	private String fillString = "                                               ";

	public VentanaMenu(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		MenuPrincipal();

	}

	public void MenuPrincipal() {
		removeAll();
		repaint();
		setName("Rompecabezas Deslizante");
		setBounds(100, 100, 640, 480);
		setLayout(new BorderLayout(0, 0));

		JLabel lblTitulo = new JLabel("Rompecabezas Deslizante");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
		add(lblTitulo, BorderLayout.NORTH);

		JPanel mid_panel = new JPanel();
		add(mid_panel, BorderLayout.CENTER);
		mid_panel.setLayout(new GridLayout(0, 1, 0, 0));
		mid_panel.add(new JLabel(""));

		JButton btnIniciar = new JButton("INICIAR");
		mid_panel.add(btnIniciar);

		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.cambiarVentana(MainFrame.S_VENTANAJUEGO);

			}
		});

		mid_panel.add(new JLabel(""));

		JButton btnOpciones = new JButton("OPCIONES");
		mid_panel.add(btnOpciones);
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.cambiarVentana(MainFrame.S_VENTANAOPCIONES);

			}
		});
		mid_panel.add(new JLabel(""));

		JButton btnSalir = new JButton("SALIR");
		mid_panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirDelJuego();
			}
		});

		JPanel bottom_panel = new JPanel();
		add(bottom_panel, BorderLayout.SOUTH);
		bottom_panel.setLayout(new GridLayout(5, 1, 0, 0));
		bottom_panel.add(new JLabel(this.fillString));

		JPanel left_panel = new JPanel();
		add(left_panel, BorderLayout.WEST);
		left_panel.add(new JLabel(this.fillString));

		JPanel right_panel = new JPanel();
		add(right_panel, BorderLayout.EAST);
		right_panel.add(new JLabel(this.fillString));

	}

	private void salirDelJuego() {
		mainFrame.dispose();
	}
}