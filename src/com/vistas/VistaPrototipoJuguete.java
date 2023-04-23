package com.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;

public class VistaPrototipoJuguete extends JFrame
{
	private JPanel panel;
	private JPanel pnlData;
	JTextField txtId;
	JTextField txtNom;
	JTextField txtPrecio;
	JTextField txtCategoria;
	JTextField txtMarca;
	JTextField txtStock;
	JButton btnSiguiente;
	JButton btnPrimero;
	JButton btnAnterior;
	JButton btnUltimo;
	JButton btnCreate;
	JButton btnRead;
	JButton btnUpdate;
	JButton btnDelete;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] ars) 
	{
		try {
		    UIManager.setLookAndFeel( new FlatDarkLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					VistaPrototipoJuguete vis = new VistaPrototipoJuguete();
					vis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public VistaPrototipoJuguete() 
	{
		initialize();
	}
	/**
	 * Create the application.
	 */
	private void initialize() 
	{	
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Jugueteria");
		setBounds(100, 100, 478, 307);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		
		setContentPane(panel);
		panel.setLayout(null);
		
		pnlData = new JPanel();
		pnlData.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnlData.setBounds(31, 19, 408, 112);
		getContentPane().add(pnlData);
		pnlData.setLayout(null);
		
		txtId = new JTextField();
		txtId.setText("asd");
		txtId.setEditable(false);
		txtId.setBounds(98, 16, 86, 20);
		pnlData.add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(98, 47, 86, 20);
		pnlData.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(98, 78, 86, 20);
		pnlData.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setBounds(287, 16, 86, 20);
		pnlData.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setBounds(287, 47, 86, 20);
		pnlData.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setBounds(287, 78, 86, 20);
		pnlData.add(txtStock);
		txtStock.setColumns(10);
		
		JLabel lblId = new JLabel("id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBounds(21, 20, 67, 14);
		pnlData.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNom = new JLabel("Nombre:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNom.setBounds(21, 49, 67, 14);
		pnlData.add(lblNom);
		lblNom.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(21, 78, 67, 14);
		pnlData.add(lblPrecio);
		lblPrecio.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoria.setBounds(194, 20, 83, 14);
		pnlData.add(lblCategoria);
		lblCategoria.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarca.setBounds(204, 49, 73, 14);
		pnlData.add(lblMarca);
		lblMarca.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStock.setBounds(204, 78, 73, 14);
		pnlData.add(lblStock);
		lblStock.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel pnlNav = new JPanel();
		pnlNav.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Navegation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnlNav.setBounds(31, 136, 408, 46);
		getContentPane().add(pnlNav);
		pnlNav.setLayout(null);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPrimero.setBounds(14, 16, 84, 23);
		pnlNav.add(btnPrimero);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBounds(112, 16, 84, 23);
		pnlNav.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBounds(210, 16, 84, 23);
		pnlNav.add(btnSiguiente);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUltimo.setBounds(308, 16, 84, 23);
		pnlNav.add(btnUltimo);
		
		JPanel pnlCrud = new JPanel();
		pnlCrud.setLayout(null);
		pnlCrud.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Crud", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnlCrud.setBounds(31, 193, 408, 46);
		getContentPane().add(pnlCrud);
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreate.setBounds(14, 16, 84, 23);
		pnlCrud.add(btnCreate);
		
		btnRead = new JButton("Read");
		btnRead.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRead.setBounds(112, 16, 84, 23);
		pnlCrud.add(btnRead);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(210, 16, 84, 23);
		pnlCrud.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(308, 16, 84, 23);
		pnlCrud.add(btnDelete);
	}
}
