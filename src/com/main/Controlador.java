package com.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import jugueteria.JulioCepeda;

public class Controlador implements ActionListener 
{	
	Vista vis;
	JulioCepeda mod;
	jugueteria.Juguete bean;
	public Controlador(Vista vis, JulioCepeda mod)
	{
		this.vis = vis;
		this.mod = mod;
		ejecutar();
	}
	//¿Por qué es necesario crear un método?
	private void ejecutar() 
	{
		JulioCepeda.conectar();
		vis.Lanzar();
//		parche para el problema de sincronizacion de hilos
		while(!vis.termino)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		==================================================
		
		vis.btnPrimero.addActionListener(this);
		vis.btnAnterior.addActionListener(this);
		vis.btnSiguiente.addActionListener(this);
		vis.btnUltimo.addActionListener(this);
		
		JulioCepeda.leerJuguetes();//******
		if(JulioCepeda.getInventarioSize()>0) //mod.getInventarioSize()>0
		{
			bean = JulioCepeda.getJuguete(0);
			rellenarCampos();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Inventario vacio");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==vis.btnPrimero)
		{
			if(JulioCepeda.getInventarioSize()>0)
			{
				bean = JulioCepeda.getJuguete(0);
				rellenarCampos();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Inventario vacio");
			}
		}
		if(e.getSource()==vis.btnAnterior)
		{
			int indexAct = JulioCepeda.getIndexOf(bean);
			if(JulioCepeda.getInventarioSize()>0 && indexAct-1>-1)
			{
				if(indexAct-1>-1)
				{
					bean = JulioCepeda.getJuguete(indexAct-1);
					rellenarCampos();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Estas en el primer registro");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Inventario vacio");
			}
		}
		if(e.getSource()==vis.btnSiguiente)
		{
			int indexAct = JulioCepeda.getIndexOf(bean);
			if(JulioCepeda.getInventarioSize()>0)
			{
				
				if (indexAct+1<JulioCepeda.getInventarioSize()) 
				{
					bean = JulioCepeda.getJuguete(indexAct + 1);
					rellenarCampos();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Estas en el ultimo registro");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Inventario vacio");
			}
		}
		if(e.getSource()==vis.btnUltimo)
		{
			if(JulioCepeda.getInventarioSize()>0)
			{
				bean = JulioCepeda.getJuguete(JulioCepeda.getInventarioSize()-1);
				rellenarCampos();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Inventario vacio");
			}
		}		
	}
	
	private void rellenarCampos() 
	{
		vis.txtId.setText(""+bean.getId_jug());
		vis.txtNom.setText(bean.getNom_jug());
		vis.txtPre.setText(""+bean.getPre_jug());
		vis.txtMarc.setText(bean.getMarc_jug());
		vis.txtCat.setText(""+bean.getCat_jug());
		vis.txtStock.setText(""+bean.getStock_jug());
		bloquearCampos();
	}
	private void vaciarCampos() 
	{
		vis.txtId.setText("");
		vis.txtNom.setText("");
		vis.txtPre.setText("");
		vis.txtMarc.setText("");
		vis.txtCat.setText("");
		vis.txtStock.setText("");
	}
	private void bloquearCampos() 
	{
		vis.txtId.setEditable(false);
		vis.txtNom.setEditable(false);
		vis.txtPre.setEditable(false);
		vis.txtMarc.setEditable(false);
		vis.txtCat.setEditable(false);
		vis.txtStock.setEditable(false);
	}
	private void desbloquearCampos() 
	{
		vis.txtId.setEditable(true);
		vis.txtNom.setEditable(true);
		vis.txtPre.setEditable(true);
		vis.txtMarc.setEditable(true);
		vis.txtCat.setEditable(true);
		vis.txtStock.setEditable(true);
	}
}
