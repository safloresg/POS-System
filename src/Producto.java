import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;


public class Producto extends Informacion {
	 

	public boolean agregar(String nombre,String proveedor,double precio, int categoria, int codigo) {
		// TODO Auto-generated method stub
		try {
			con = new Conexion();
			con.ejecutar("INSERT INTO productos VALUES('"+nombre+"',"+precio+",'"+proveedor+"',"+categoria+","+codigo+")" );
			return true;
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean modificar(String nombre,String proveedor,double precio, int categoria, int codigo) {
		// TODO Auto-generated method stub
		try {
			con = new Conexion();
			con.ejecutar("UPDATE productos SET " +
					"nombre='"+nombre+"', " +
					"proveedor='"+proveedor+"', " +
					"precio="+precio+", " +
					"categoria="+categoria+
					" WHERE codigo="+codigo);


			return true;
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	

}