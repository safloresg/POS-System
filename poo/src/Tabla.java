import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;


public class Tabla {
	Conexion con;
	ResultSetMetaData meta;
	ResultSet rs;
	DefaultTableModel modelo;
	private String query;
	Tabla(DefaultTableModel modelo){
		this.modelo = modelo;
		
	}
	
	
	public void agregarColumnas(String nombreTabla, String columnas[]){
		try {
			con = new Conexion();
			
			String columnasSQL = new String();
			for(String col:columnas){//se copia el arreglo a una sola variable String
				columnasSQL +=col+",";
			}
			/*Eliminamos la coma que se pone al final de la cadena de caracteres*/
			columnasSQL = columnasSQL.substring(0,columnasSQL.length()-1);
			System.out.println(columnasSQL);
			query="SELECT "+columnasSQL+" FROM "+nombreTabla;
			rs = con.consulta(query);
			meta = rs.getMetaData();
			//se agregan las columnas
			for (int i=0;i < meta.getColumnCount();i++){
				modelo.addColumn(meta.getColumnLabel(i+1));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void buscarProducto(String codigoProducto){
		try {
			rs = con.consulta(query+" WHERE codigo ="+codigoProducto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void agregarDatos(String codigoProducto){
		try {
			buscarProducto(codigoProducto);
			while(rs.next()){
				Object[] fila = new Object[meta.getColumnCount()];
				for (int i=0;i<meta.getColumnCount();i++){
					fila[i] = rs.getObject(i+1);
				}
				modelo.addRow(fila);
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
