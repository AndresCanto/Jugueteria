package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener 
{
	Vista vis;
	Modelo mod;
	Bean bean;
	public Controlador(Vista vis, Modelo mod)
	{
		this.vis = vis;
		this.mod = mod;
		ejecutar();
	}
	//¿Por qué es necesario crear un método?
	private void ejecutar() 
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
		
		vis.btnPrimero.addActionListener(this);
		vis.btnAnterior.addActionListener(this);
		vis.btnSiguiente.addActionListener(this);
		vis.btnUltimo.addActionListener(this);
		
		mod.leerJuguete();//******
		if(mod.getInventarioSize()>0)
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
				JOptionPane.showMessageDialog(null, "Inventario vacio");
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
