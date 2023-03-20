package com.main;

import jugueteria.JulioCepeda;

public class Lanzador 
{
	public static void main(String[] args) 
	{
		Vista vis = new Vista();
		JulioCepeda mod = new JulioCepeda();
		Controlador con = new Controlador(vis, mod);
	}
}