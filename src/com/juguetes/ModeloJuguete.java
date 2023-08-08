package com.juguetes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ModeloJuguete 
{
	public static List<Juguete> listaJuguetes = new ArrayList<Juguete>();
	static Connection con;
	private static Connection conectar() 
	{
		String server = "jdbc:mysql://localhost/jugueteriajc";
		String user = "andres";
		String pass = "qwerty123456";
		
		try
		{
			con = DriverManager.getConnection(server,user,pass);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		
		if(con!=null)
		{
			System.out.println("Conexion exitosa!");
		}
		
		return con;
	}
	public void leerJuguetes() 
	{
		conectar();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT * FROM juguetes;";
		
		try {
			pstm= con.prepareStatement(query);
			rs=pstm.executeQuery();
		
			while(rs.next())
			{
				listaJuguetes.add(new Juguete(rs.getInt("id_jug"),rs.getString("nom_jug"),
						rs.getFloat("pre_jug"),rs.getString("marc_jug"),rs.getInt("cat_jug"),
						rs.getInt("stock_jug")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
			}
		}
		desconectar();
	}
	private String validarValor(String lb, String def)
	{
		String i = null;
		do
		{
			i=JOptionPane.showInputDialog(lb,def);
			
		}while(i.isBlank());
		return i;
	}
	public void crearJuguete()
	{
		conectar();
		int id = Integer.parseInt(validarValor("Clave: ",""));
		String nom = validarValor("Nombre: ","");
		float pre = Float.parseFloat(validarValor("Precio: ",""));
		String marc = validarValor("Marca: ","");
		int cat = Integer.parseInt(validarValor("Categoria: ",""));
		int stock = Integer.parseInt(validarValor("Stock: ",""));
		
		String query = "INSERT INTO juguetes(id_jug,nom_jug,pre_jug,marc_jug,cat_jug,stock_jug)"
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		try 
		{
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.setString(2, nom);
			pstm.setDouble(3, pre);
			pstm.setString(4, marc);
			pstm.setInt(5, cat);
			pstm.setInt(6, stock);
			
			if(JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea crear el juguete de id: "+id+"?")==0)
			{
				listaJuguetes.add(new Juguete(id,nom,pre,marc,cat,stock));
				pstm.execute();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm != null) pstm.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		desconectar();
	}
	public void modificarJuguete(Juguete toy)
	{
		conectar();
		int id = Integer.parseInt(validarValor("Clave: ",""+toy.getId_jug()));
		String nom = validarValor("Nombre: ",toy.getNom_jug());
		float pre = Float.parseFloat(validarValor("Precio: ",""+toy.getPre_jug()));
		String marc = validarValor("Marca: ",toy.getMarc_jug());
		int cat = Integer.parseInt(validarValor("Categoria: ",""+toy.getCat_jug()));
		int stock = Integer.parseInt(validarValor("Stock: ",""+toy.getStock_jug()));
		
		String query = "UPDATE `juguetes` SET `id_jug`= ?,`nom_jug`= ?,`pre_jug`= ?,`marc_jug`= ?,`cat_jug`= ?,`stock_jug`= ? WHERE id_jug = ? ";
		PreparedStatement pstm = null;
		
		try 
		{
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.setString(2, nom);
			pstm.setDouble(3, pre);
			pstm.setString(4, marc);
			pstm.setInt(5, cat);
			pstm.setInt(6, stock);
			pstm.setInt(7, id);
			
			if(JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar el juguete de id: "+id+"?")==0)
			{
				listaJuguetes.set(id-1, new Juguete(id,nom,pre,marc,cat,stock));
				pstm.execute();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm != null) pstm.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		desconectar();
	}
	public void eliminarJuguete(String idActual) 
	{
		conectar();
		int id = Integer.parseInt(validarValor("Clave: ",idActual));
		PreparedStatement pstm = null;
		String query = "DELETE FROM juguetes WHERE id_jug = ?";
		
		try 
		{
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			if(JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea borrar el juguete de id: "+id+"?")==0)
			{
				listaJuguetes.remove(id-1);
				pstm.execute();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm != null) pstm.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		desconectar();
	}
	private void desconectar() 
	{
		try {
			if(con != null) con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public int getInventarioSize() 
	{
		return listaJuguetes.size();
	}
	public Juguete getJuguete(int i)
	{
		return listaJuguetes.get(i);
	}
	public int getIndexOf(Juguete bean)
	{
		return listaJuguetes.indexOf(bean);
	}
}
