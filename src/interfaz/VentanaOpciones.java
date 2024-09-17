
package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JRadioButton;

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

		// PANELES Y LABELS
		JPanel panel_mid = new JPanel();
		add(panel_mid, BorderLayout.CENTER);

		JPanel panel_top = new JPanel();
		add(panel_top, BorderLayout.NORTH);

		JPanel panel_bottom = new JPanel();
		add(panel_bottom, BorderLayout.SOUTH);

		JPanel panel_west = new JPanel();
		panel_west.setPreferredSize(new Dimension(80, 0));
		add(panel_west, BorderLayout.WEST);

		JPanel panel_east = new JPanel();
		panel_east.setPreferredSize(new Dimension(80, 0));
		add(panel_east, BorderLayout.EAST);

		JPanel panel_titles = new JPanel();
		panel_titles.setLayout(new GridLayout(1, 3));
		panel_mid.add(panel_titles);

		panel_mid.setLayout(new BoxLayout(panel_mid, BoxLayout.Y_AXIS));

		JLabel label_tamanyo = new JLabel("TAMAÑO");
		panel_titles.add(label_tamanyo);
		label_tamanyo.setVerticalAlignment(SwingConstants.BOTTOM);
		label_tamanyo.setHorizontalAlignment(SwingConstants.CENTER);
		label_tamanyo.setFont(mainFrame.fuentePersonalizada().deriveFont(28f));

		JLabel label_opciones = new JLabel("DIFICULTAD");
		label_opciones.setVerticalAlignment(SwingConstants.BOTTOM);
		label_opciones.setHorizontalAlignment(SwingConstants.CENTER);
		label_opciones.setFont(mainFrame.fuentePersonalizada().deriveFont(28f));
		panel_titles.add(label_opciones);

		JPanel panel_buttons = new JPanel();
		panel_mid.add(panel_buttons);
		panel_buttons.setLayout(new GridLayout(1, 3));

		JPanel subpanel_tamanyos = new JPanel();
		subpanel_tamanyos.setPreferredSize(new Dimension(20, 50));
		panel_buttons.add(subpanel_tamanyos);
		subpanel_tamanyos.setLayout(new GridLayout(5, 1));

		JPanel subpanel_dificultades = new JPanel();
		subpanel_dificultades.setPreferredSize(new Dimension(20, 50));
		panel_buttons.add(subpanel_dificultades);
		subpanel_dificultades.setLayout(new GridLayout(3, 1));

		// BOTONES Y GRUPOS
		ButtonGroup bGroup_dificultades = new ButtonGroup();
		ButtonGroup bGroup_tamanyos = new ButtonGroup();

		JRadioButton[] bArray_tamanyos = new JRadioButton[5];
		JRadioButton[] bArray_dificultades = new JRadioButton[3];

		String[] strArray_dificultades = { "Fácil", "Normal", "Dificil" };

		// setear botones de tamaño y default (4x4)
		for (int i = 0; i < bArray_tamanyos.length; i++) {
			this.crearBoton((i + 3) + "x" + (i + 3), bArray_tamanyos, subpanel_tamanyos, bGroup_tamanyos, i);
		}
		bArray_tamanyos[1].setSelected(true);

		// setear botones de dificultad y default (normal)
		for (int i = 0; i < bArray_dificultades.length; i++) {
			this.crearBoton(strArray_dificultades[i], bArray_dificultades, subpanel_dificultades, bGroup_dificultades,
					i);
		}
		bArray_dificultades[1].setSelected(true);

		JButton button_confirmar = new JButton("OK");
		button_confirmar.setPreferredSize(new Dimension(200, 50));
		button_confirmar.setFont(mainFrame.fuentePersonalizada().deriveFont(12f));
		button_confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// verificar cual esta seleccionada
				for (int i = 0; i < bArray_tamanyos.length; i++) {
					if (bArray_tamanyos[i].isSelected()) {
						mainFrame.setBoardSize(i + 3);
						break;
					}
				}

				for (int i = 0; i < bArray_dificultades.length; i++) {
					if (bArray_dificultades[i].isSelected()) {
						mainFrame.setDifficulty(i + 1);
						break;
					}
				}

				mainFrame.cambiarVentana(MainFrame.S_VENTANAMENU);
			}
		});
		panel_bottom.add(button_confirmar);

		JPanel panel_bottomMidEmpty = new JPanel();

		panel_mid.add(panel_bottomMidEmpty);

		revalidate();
		repaint();
	}

	private void crearBoton(String label, JRadioButton[] buttonArray, JPanel buttonPanel, ButtonGroup buttonGroup,
			int index) {
		buttonArray[index] = new JRadioButton(label);
		buttonArray[index].setHorizontalAlignment(SwingConstants.CENTER);
		buttonPanel.add(buttonArray[index]);
		buttonGroup.add(buttonArray[index]);
	}
}