package com.juguetes;

public class LanzadorJuguete 
{
	public void LlamarJuguete() 
	{
		VistaJuguete vis = new VistaJuguete();
//		JulioCepeda mod = new JulioCepeda();
		ModeloJuguete mod = new ModeloJuguete();
		ControladorJuguete con = new ControladorJuguete(vis, mod);
	}
} 