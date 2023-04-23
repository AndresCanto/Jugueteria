package com.juguetes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatDarkLaf;

public class VistaJuguete extends JFrame 
{
	private JFrame frmJugueteria;
	private JPanel pnlData;
	private JLabel lblId;
	private JLabel lblNom;
	private JLabel lblPrecio;
	private JLabel lblCat;
	private JLabel lblMarc;
	private JLabel lblStock;
	JTextField txtId;
	JTextField txtNom;
	JTextField txtPre;
	JTextField txtCat;
	JTextField txtMarc;
	JTextField txtStock;
	JButton btnSiguiente;
	JButton btnPrimero;
	JButton btnAnterior;
	JButton btnUltimo;
	JButton btnCreate;
	JButton btnRead;
	JButton btnUpdate;
	JButton btnDelete;
	boolean termino = false;	
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public void Lanzar() 
	{
		try {
		    UIManager.setLookAndFeel( new FlatDarkLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
//		EventQueue.invokeLater(new Runnable() 
//		{
//			public void run() 
//			{
//				try {
//					crearGUI();
//					frmJugueteria.setVisible(true);
//					frmJugueteria.setLocationRelativeTo(null);
//					frmJugueteria.setResizable(false);
//					termino = true;
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		crearGUI();
		frmJugueteria.setVisible(true);
		frmJugueteria.setLocationRelativeTo(null);
		frmJugueteria.setResizable(false);
		termino = true;
	}

	/**
	 * Create the application.
	 */
	public void crearGUI() 
	{	
		frmJugueteria = new JFrame();
		frmJugueteria.setTitle("Jugueteria");
		frmJugueteria.setBounds(100, 100, 478, 307);
		frmJugueteria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJugueteria.getContentPane().setLayout(null);
		
		pnlData = new JPanel();
		pnlData.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnlData.setBounds(31, 19, 408, 112);
		frmJugueteria.getContentPane().add(pnlData);
		pnlData.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(98, 16, 86, 20);
		pnlData.add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(98, 47, 86, 20);
		pnlData.add(txtNom);
		txtNom.setColumns(10);
		
		txtPre = new JTextField();
		txtPre.setBounds(98, 78, 86, 20);
		pnlData.add(txtPre);
		txtPre.setColumns(10);
		
		txtCat = new JTextField();
		txtCat.setBounds(287, 16, 86, 20);
		pnlData.add(txtCat);
		txtCat.setColumns(10);
		
		txtMarc = new JTextField();
		txtMarc.setBounds(287, 47, 86, 20);
		pnlData.add(txtMarc);
		txtMarc.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(287, 78, 86, 20);
		pnlData.add(txtStock);
		txtStock.setColumns(10);
		
		lblId = new JLabel("id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(21, 20, 67, 14);
		pnlData.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblNom = new JLabel("Nombre:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(21, 49, 67, 14);
		pnlData.add(lblNom);
		lblNom.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(21, 78, 67, 14);
		pnlData.add(lblPrecio);
		lblPrecio.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCat = new JLabel("Categoria:");
		lblCat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCat.setBounds(194, 20, 83, 14);
		pnlData.add(lblCat);
		lblCat.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblMarc = new JLabel("Marca:");
		lblMarc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarc.setBounds(204, 49, 73, 14);
		pnlData.add(lblMarc);
		lblMarc.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStock.setBounds(204, 78, 73, 14);
		pnlData.add(lblStock);
		lblStock.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel pnlNav = new JPanel();
		pnlNav.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Navegation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnlNav.setBounds(31, 136, 408, 46);
		frmJugueteria.getContentPane().add(pnlNav);
		pnlNav.setLayout(null);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPrimero.setBounds(14, 16, 84, 23);
		pnlNav.add(btnPrimero);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAnterior.setBounds(112, 16, 84, 23);
		pnlNav.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSiguiente.setBounds(210, 16, 84, 23);
		pnlNav.add(btnSiguiente);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUltimo.setBounds(308, 16, 84, 23);
		pnlNav.add(btnUltimo);
		
		JPanel pnlCrud = new JPanel();
		pnlCrud.setLayout(null);
		pnlCrud.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Crud", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnlCrud.setBounds(31, 193, 408, 46);
		frmJugueteria.getContentPane().add(pnlCrud);
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreate.setBounds(14, 16, 84, 23);
		pnlCrud.add(btnCreate);
		
		btnRead = new JButton("Read");
		btnRead.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRead.setBounds(112, 16, 84, 23);
		pnlCrud.add(btnRead);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUpdate.setBounds(210, 16, 84, 23);
		pnlCrud.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDelete.setBounds(308, 16, 84, 23);
		pnlCrud.add(btnDelete);
	}
}
