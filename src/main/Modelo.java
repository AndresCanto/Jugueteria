package main;

import java.util.ArrayList;
import java.util.List;

public class Modelo 
{
//	persistencia
//	JPA spring boot
//	spring data
	
	
	private List<Bean> Inventario = new ArrayList<>();
//	Iterator<Bean> iter;
	void leerJuguete() 
	{
		Inventario.add(new Bean(1,"Hotweels",234,"mattel",5,200));
		Inventario.add(new Bean(2,"barbie",134,"mattel",5,300));
//		Inventario.add(new Bean(3,"cpcinota",2345,"mattel",6,400));
//		Inventario.add(new Bean(4,"lego",456,"lego",6,500));
	}
	Bean getJuguete(int index) 
	{
		return Inventario.get(index); 
	}
	int getInventarioSize()
	{
		return Inventario.size();
	}
	int getIndexOf(Bean b)
	{
		return Inventario.indexOf(b);
	}
}