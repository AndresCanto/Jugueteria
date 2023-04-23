package com.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.juguetes.LanzadorJuguete;

public class ControladorMenu implements ActionListener
{
	VistaMenu visM;
	ModeloMenu modM;
	public ControladorMenu(VistaMenu visM, ModeloMenu modM) 
	{
		this.visM = visM;
		this.modM = modM;
		ejecutar();
	}
	private void ejecutar() 
	{
		visM.lanzarGUI();
		while(!visM.termino)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		visM.btnJuguetes.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==visM.btnJuguetes)
		{
			System.out.println("great");
			LanzadorJuguete l = new LanzadorJuguete();
			l.LlamarJuguete();
			visM.dispose();
			
		}
	}
}
