import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public  class Informacion {
	Conexion con;
	
	public ResultSet buscar(int codigo, String tabla){
		
		try {
			ResultSet rs;
			Conexion con = new Conexion();
			rs = con.consulta("SELECT * FROM "+tabla+" WHERE codigo="+codigo);
			return rs;
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
		
	}

	
	public boolean eliminar(String tabla, int codigo){
		try {			
			Conexion con = new Conexion();
			if (con.ejecutar("DELETE FROM "+tabla+" WHERE codigo="+codigo)>0){
				return true;
			}else return false;
			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
		
}
