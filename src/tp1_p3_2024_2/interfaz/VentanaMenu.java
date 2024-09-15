package tp1_p3_2024_2.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import tp1_p3_2024_2.Fuente;

import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.BoxLayout;

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
		setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));

		JPanel mid_panel = new JPanel();
		add(mid_panel, BorderLayout.CENTER);
		mid_panel.setLayout(new GridLayout(0, 1, 0, 0));
		mid_panel.add(new JLabel(""));

		JPanel bottom_panel = new JPanel();
		add(bottom_panel, BorderLayout.SOUTH);
		bottom_panel.setPreferredSize(new Dimension(190, 80));
		bottom_panel.setLayout(new GridLayout(5, 1, 0, 0));

		JPanel left_panel = new JPanel();
		add(left_panel, BorderLayout.WEST);
		left_panel.setPreferredSize(new Dimension(190, 0));

		JPanel right_panel = new JPanel();
		add(right_panel, BorderLayout.EAST);
		right_panel.setPreferredSize(new Dimension(200, 0));

		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.setBackground(SystemColor.activeCaption);
		mid_panel.add(btnIniciar);
		btnIniciar.setFont(mainFrame.fuentePersonalizada().deriveFont(25f));

		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.cambiarVentana(MainFrame.S_VENTANAJUEGO);

			}
		});

		mid_panel.add(new JLabel(""));

		JButton btnOpciones = new JButton("OPCIONES");
		btnOpciones.setBackground(SystemColor.activeCaption);
		mid_panel.add(btnOpciones);
		btnOpciones.setFont(mainFrame.fuentePersonalizada().deriveFont(25f));
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.cambiarVentana(MainFrame.S_VENTANAOPCIONES);

			}
		});
		mid_panel.add(new JLabel(""));

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBackground(SystemColor.activeCaption);
		mid_panel.add(btnSalir);
		btnSalir.setFont(mainFrame.fuentePersonalizada().deriveFont(25f));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				salirDelJuego();
			}
		});

		JLabel lblTitulo = new JLabel("Rompecabezas Deslizante");
		topPanel.add(lblTitulo, BorderLayout.CENTER);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(mainFrame.fuentePersonalizada().deriveFont(40f));

	}

	private void salirDelJuego() {
		mainFrame.dispose();
	}
}