
package tp1_p3_2024_2.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import tp1_p3_2024_2.Fuente;
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

		JPanel midPanel = new JPanel();
		add(midPanel, BorderLayout.CENTER);

		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);

		JPanel bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.SOUTH);

		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(80, 0));
		add(westPanel, BorderLayout.WEST);

		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(80, 0));
		add(eastPanel, BorderLayout.EAST);

		JPanel tituloDificultadPanel = new JPanel();
		tituloDificultadPanel.setPreferredSize(new Dimension(20, 50));
		tituloDificultadPanel.setLayout(new GridLayout(1, 3));

		JPanel tildesPanel = new JPanel();
		tildesPanel.setLayout(new GridLayout(1, 3));
		midPanel.add(tildesPanel);

		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));

		midPanel.add(tituloDificultadPanel);
		
		JLabel lblOpciones = new JLabel("DIFICULTAD");
		tildesPanel.add(lblOpciones);
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setVerticalAlignment(SwingConstants.BOTTOM);
		lblOpciones.setFont(mainFrame.fuentePersonalizada().deriveFont(28f));
		
		JRadioButton rdbtn_facil = new JRadioButton("Facil");
		rdbtn_facil.setHorizontalAlignment(SwingConstants.CENTER);
		tituloDificultadPanel.add(rdbtn_facil);
		
		JRadioButton rdbtn_medio = new JRadioButton("Medio");
		rdbtn_medio.setHorizontalAlignment(SwingConstants.CENTER);
		tituloDificultadPanel.add(rdbtn_medio);
		rdbtn_medio.setSelected(true);
		
		JRadioButton rdbtn_dificil = new JRadioButton("Dificil");
		rdbtn_dificil.setHorizontalAlignment(SwingConstants.CENTER);
		tituloDificultadPanel.add(rdbtn_dificil);
		
		ButtonGroup btngrp_dificultad = new ButtonGroup();
		btngrp_dificultad.add(rdbtn_facil);
		btngrp_dificultad.add(rdbtn_medio);
		btngrp_dificultad.add(rdbtn_dificil);

		JButton btnConfirmar = new JButton("Volver al Menú");
		btnConfirmar.setPreferredSize(new Dimension(200, 50));
		btnConfirmar.setFont(mainFrame.fuentePersonalizada().deriveFont(12f));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn_facil.isSelected()) {
					mainFrame.setBoardSize(3);
				}
				if(rdbtn_medio.isSelected()) {
					mainFrame.setBoardSize(4);
				}
				if(rdbtn_dificil.isSelected()) {
					mainFrame.setBoardSize(5);
				}
				mainFrame.cambiarVentana(MainFrame.S_VENTANAMENU);
			}
		});
		bottomPanel.add(btnConfirmar);
		
		// Aca se puede agregar boton reglas o dejarlo asi
		JPanel emptyPanel = new JPanel();

		midPanel.add(emptyPanel);

		revalidate();
		repaint();
	}
}