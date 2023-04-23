package com.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrototipoMenu extends JFrame {

//	private JPanel contentPane;
	JButton btnJuguetes;
	JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrototipoMenu frame = new VistaPrototipoMenu();
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
	public VistaPrototipoMenu()
	{
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Menu");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		panel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnJuguetes = new JButton("Juguetes");
		btnJuguetes.setBounds(170, 176, 89, 23);
		panel.add(btnJuguetes);
	}

}
