package com.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;

public class VistaPrototipo {

	private JFrame frmJugueteria;
	JTextField txtId;
	JTextField txtNom;
	JTextField txtPrecio;
	JTextField txtCategoria;
	JTextField txtMarca;
	JTextField txtStock;
	private JLabel lblId;
	private JLabel lblNom;
	private JLabel lblPrecio;
	private JLabel lblCategoria;
	private JLabel lblMarca;
	private JLabel lblStock;
	JButton btnSiguiente;
	JButton btnPrimero;
	JButton btnAnterior;
	JButton btnUltimo;
	private JPanel panelData;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] ars) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					VistaPrototipo vis = new VistaPrototipo();
					vis.frmJugueteria.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public VistaPrototipo() 
	{
		initialize();
	}
	/**
	 * Create the application.
	 */
	private void initialize() {
		
		frmJugueteria = new JFrame();
		frmJugueteria.setTitle("Jugueteria");
		frmJugueteria.setVisible(true);
		frmJugueteria.setBounds(100, 100, 478, 307);
		frmJugueteria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJugueteria.getContentPane().setLayout(null);
		
		panelData = new JPanel();
		panelData.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelData.setBounds(31, 19, 408, 112);
		frmJugueteria.getContentPane().add(panelData);
		panelData.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(98, 16, 86, 20);
		panelData.add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(98, 47, 86, 20);
		panelData.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(98, 78, 86, 20);
		panelData.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(287, 16, 86, 20);
		panelData.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(287, 47, 86, 20);
		panelData.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(287, 78, 86, 20);
		panelData.add(txtStock);
		txtStock.setColumns(10);
		
		lblId = new JLabel("id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(21, 20, 67, 14);
		panelData.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblNom = new JLabel("Nombre:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(21, 49, 67, 14);
		panelData.add(lblNom);
		lblNom.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(21, 78, 67, 14);
		panelData.add(lblPrecio);
		lblPrecio.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoria.setBounds(194, 20, 83, 14);
		panelData.add(lblCategoria);
		lblCategoria.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(204, 49, 73, 14);
		panelData.add(lblMarca);
		lblMarca.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStock.setBounds(204, 78, 73, 14);
		panelData.add(lblStock);
		lblStock.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panelNav = new JPanel();
		panelNav.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Navegation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNav.setBounds(31, 136, 408, 46);
		frmJugueteria.getContentPane().add(panelNav);
		panelNav.setLayout(null);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPrimero.setBounds(14, 16, 84, 23);
		panelNav.add(btnPrimero);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAnterior.setBounds(112, 16, 84, 23);
		panelNav.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSiguiente.setBounds(210, 16, 84, 23);
		panelNav.add(btnSiguiente);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUltimo.setBounds(308, 16, 84, 23);
		panelNav.add(btnUltimo);
	}
	public JLabel getLblStock() {
		return lblStock;
	}
	public JLabel getLblMarca() {
		return lblMarca;
	}
	public JLabel getLblNom() {
		return lblNom;
	}
	public JLabel getLblId() {
		return lblId;
	}
	public JLabel getLblPrecio() {
		return lblPrecio;
	}
	public JLabel getLblCategoria() {
		return lblCategoria;
	}
	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}
	public JButton getBtnPrimero() {
		return btnPrimero;
	}
	public JButton getBtnAnterior() {
		return btnAnterior;
	}
	public JButton getBtnUltimo() {
		return btnUltimo;
	}
}
