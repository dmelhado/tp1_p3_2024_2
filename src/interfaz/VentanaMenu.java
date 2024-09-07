package interfaz;

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

	public VentanaMenu(MainFrame mainFrame) 
	{
		this.mainFrame = mainFrame;
		MenuPrincipal();

	}

	public void MenuPrincipal() 
	{
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

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label_1 = new JLabel("");
		panel.add(label_1);

		JButton btnIniciar = new JButton("INICIAR");
		panel.add(btnIniciar);

		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.cambiarVentana(MainFrame.VENTANAJUEGO);

			}
		});

		JLabel label_11 = new JLabel("");
		panel.add(label_11);

		JButton btnOpciones = new JButton("OPCIONES");
		panel.add(btnOpciones);
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.cambiarVentana(MainFrame.VENTANAOPCIONES);

			}
		});

		JLabel label_15 = new JLabel("");
		panel.add(label_15);

		JButton btnSalir = new JButton("SALIR");
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirDelJuego();
			}
		});

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel label = new JLabel("                        ");
		panel_1.add(label);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("                                               ");
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);

		JLabel lblNewLabel_1 = new JLabel("                                                        ");
		panel_3.add(lblNewLabel_1);

	}

	private void salirDelJuego() {
		mainFrame.dispose();
	}
}