
package tp1_p3_2024_2.interfaz;


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

		JPanel titlesPanel = new JPanel();
		titlesPanel.setLayout(new GridLayout(1, 3));
		midPanel.add(titlesPanel);

		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
		
		JLabel lblTamanyo = new JLabel("TAMAÑO");
		titlesPanel.add(lblTamanyo);
		lblTamanyo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTamanyo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTamanyo.setFont(mainFrame.fuentePersonalizada().deriveFont(28f));
		
		JLabel lblOpciones_1 = new JLabel("DIFICULTAD");
		lblOpciones_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblOpciones_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones_1.setFont(mainFrame.fuentePersonalizada().deriveFont(28f));
		titlesPanel.add(lblOpciones_1);
		
		ButtonGroup btngrp_dificultad = new ButtonGroup();
		ButtonGroup btngrp_tamanyo = new ButtonGroup();
		
		JPanel buttonsPanel = new JPanel();
		midPanel.add(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(1, 3));
		
		JPanel tamanyoButtons = new JPanel();
		tamanyoButtons.setPreferredSize(new Dimension(20, 50));
		buttonsPanel.add(tamanyoButtons);
		tamanyoButtons.setLayout(new GridLayout(5, 1));
		
		JRadioButton rdbtn_3 = new JRadioButton("3x3");
		rdbtn_3.setHorizontalAlignment(SwingConstants.CENTER);
		tamanyoButtons.add(rdbtn_3);
		btngrp_tamanyo.add(rdbtn_3);
		
		JRadioButton rdbtn_4 = new JRadioButton("4x4");
		rdbtn_4.setSelected(true);
		rdbtn_4.setHorizontalAlignment(SwingConstants.CENTER);
		tamanyoButtons.add(rdbtn_4);
		btngrp_tamanyo.add(rdbtn_4);
		
		JRadioButton rdbtn_5 = new JRadioButton("5x5");
		rdbtn_5.setHorizontalAlignment(SwingConstants.CENTER);
		tamanyoButtons.add(rdbtn_5);
		btngrp_tamanyo.add(rdbtn_5);
		
		JRadioButton rdbtn_6 = new JRadioButton("6x6");
		rdbtn_6.setHorizontalAlignment(SwingConstants.CENTER);
		tamanyoButtons.add(rdbtn_6);
		btngrp_tamanyo.add(rdbtn_6);
		
		JRadioButton rdbtn_7 = new JRadioButton("7x7");
		rdbtn_7.setHorizontalAlignment(SwingConstants.CENTER);
		tamanyoButtons.add(rdbtn_7);
		btngrp_tamanyo.add(rdbtn_7);
		
		JPanel dificultadButtons = new JPanel();
		dificultadButtons.setPreferredSize(new Dimension(20, 50));
		buttonsPanel.add(dificultadButtons);
		dificultadButtons.setLayout(new GridLayout(3, 1));
		
		JRadioButton rdbtn_facil = new JRadioButton("Facil");
		rdbtn_facil.setHorizontalAlignment(SwingConstants.CENTER);
		dificultadButtons.add(rdbtn_facil);
		btngrp_dificultad.add(rdbtn_facil);
		
		JRadioButton rdbtn_medio = new JRadioButton("Medio");
		rdbtn_medio.setSelected(true);
		rdbtn_medio.setHorizontalAlignment(SwingConstants.CENTER);
		dificultadButtons.add(rdbtn_medio);
		btngrp_dificultad.add(rdbtn_medio);
		
		JRadioButton rdbtn_dificil = new JRadioButton("Dificil");
		rdbtn_dificil.setHorizontalAlignment(SwingConstants.CENTER);
		dificultadButtons.add(rdbtn_dificil);
		btngrp_dificultad.add(rdbtn_dificil);
		
		JButton btnConfirmar = new JButton("Volver al Menú");
		btnConfirmar.setPreferredSize(new Dimension(200, 50));
		btnConfirmar.setFont(mainFrame.fuentePersonalizada().deriveFont(12f));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtn_facil.isSelected()) {
					mainFrame.setDifficulty(1);
				}
				if(rdbtn_medio.isSelected()) {
					mainFrame.setDifficulty(2);
				}
				if(rdbtn_dificil.isSelected()) {
					mainFrame.setDifficulty(3);
				}
				
				if(rdbtn_3.isSelected()) {
					mainFrame.setBoardSize(3);
				}
				if(rdbtn_4.isSelected()) {
					mainFrame.setBoardSize(4);
				}
				if(rdbtn_5.isSelected()) {
					mainFrame.setBoardSize(5);
				}
				if(rdbtn_6.isSelected()) {
					mainFrame.setBoardSize(6);
				}
				if(rdbtn_7.isSelected()) {
					mainFrame.setBoardSize(7);
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