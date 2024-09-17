package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReglas extends JDialog {

	private static final long serialVersionUID = 1L;

	public VentanaReglas(JFrame ventana) {
		super(ventana, "Reglas del Rompecabezas Deslizante", true);

		setSize(350, 330);
		setLocationRelativeTo(ventana); // Centra el diálogo respecto al marco principal

		JPanel panel = new JPanel(new BorderLayout());
		getContentPane().add(panel);

		JTextArea areaTexto = new JTextArea();
		areaTexto.setText(
				"El objetivo es ordenar los cuadrados en orden ascedente moviendo el casillero vacío. Puedes intercambiar el casillero vacío con "
						+ "los cuadrados contiguos para lograr el orden correcto\n\n" + "**Cómo Jugar**:\n"
						+ "   - Mueve el casillero vacío intercambiando su posición con los cuadrados contiguos.\n"
						+ "   - Usa las teclas `W`, `A`, `S`, `D` o las flechas del teclado (`↑`, `←`, `↓`, `→`) para mover el casillero.\n\n"
						+ "**Meta**:\n    -Ordena los números con la menor cantidad de movimientos posibles.\n\n");
		areaTexto.setEditable(false); // No se puede editar
		areaTexto.setLineWrap(true); // Ajusta las líneas al tamaño del área
		areaTexto.setWrapStyleWord(true);
		panel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

		JButton btnCerrar = new JButton("Volver");
		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnCerrar, BorderLayout.SOUTH);
	}
}
