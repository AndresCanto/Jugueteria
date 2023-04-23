package com.juguetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorJuguete implements ActionListener 
{	
	VistaJuguete vis;
	ModeloJuguete mod;
//	JulioCepeda mod;
	Juguete bean;
	public ControladorJuguete(VistaJuguete vis, ModeloJuguete mod)
	{
		this.vis = vis;
		this.mod = mod;
		ejecutar();
	}
	//¿Por qué es necesario crear un método?
	private void ejecutar() //run gui, add listeners, connect db, default values
	{
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
		bloquearCampos();
		vis.btnPrimero.addActionListener(this);
		vis.btnAnterior.addActionListener(this);
		vis.btnSiguiente.addActionListener(this);
		vis.btnUltimo.addActionListener(this);
		
		vis.btnCreate.addActionListener(this);
		vis.btnUpdate.addActionListener(this);
		vis.btnDelete.addActionListener(this);
		mod.leerJuguetes();
		if(mod.getInventarioSize()>0) //mod.getInventarioSize()>0
		{
			bean = mod.getJuguete(0);
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
			if(mod.getInventarioSize()>0)
			{
				bean = mod.getJuguete(0);
				rellenarCampos();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Estas en el primer registro");
			}
		}
		if(e.getSource()==vis.btnAnterior)
		{
			int indexAct = mod.getIndexOf(bean);
			if(mod.getInventarioSize()>0 && indexAct-1>-1)
			{
				if(indexAct-1>-1)
				{
					bean = mod.getJuguete(indexAct-1);
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
			int indexAct = mod.getIndexOf(bean);
			if(mod.getInventarioSize()>0)
			{
				
				if (indexAct+1<mod.getInventarioSize()) 
				{
					bean = mod.getJuguete(indexAct + 1);
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
			if(mod.getInventarioSize()>0)
			{
				bean = mod.getJuguete(mod.getInventarioSize()-1);
				rellenarCampos();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Estas en el ultimo registro");
			}
		}	
		if(e.getSource()==vis.btnCreate)
		{
			mod.crearJuguete();
			bean = mod.getJuguete(mod.getInventarioSize()-1);
			rellenarCampos();
		}
		if(e.getSource()==vis.btnUpdate)
		{
			mod.modificarJuguete(bean);
			bean = mod.getJuguete(mod.getInventarioSize()-1);
			rellenarCampos();
		}
		if(e.getSource()==vis.btnDelete)
		{
			mod.eliminarJuguete(""+bean.getId_jug());
			bean = mod.getJuguete(mod.getInventarioSize()-1);
			rellenarCampos();
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
