package com.menu;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.vistas.VistaPrototipoMenu;

public class VistaMenu extends JFrame 
{
	boolean termino = false;
	private JPanel contentPane;

	JButton btnJuguetes;

	public void lanzarGUI() 
	{
		try {
		    UIManager.setLookAndFeel( new FlatDarkLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		crearGUI();
		this.setVisible(true);
		termino = true;
	}

	/**
	 * Create the frame.
	 */
	public void crearGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnJuguetes = new JButton("Juguetes");
		btnJuguetes.setBounds(170, 176, 89, 23);
		panel.add(btnJuguetes);
	}

	
}
