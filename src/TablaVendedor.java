import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TablaVendedor {
	Conexion con;
	ResultSetMetaData meta;
	ResultSet rs;
	DefaultTableModel modelo;
	private String query;
	TablaVendedor(DefaultTableModel modelo){
		this.modelo = modelo;
	}
	
	
	public void agregarColumnas(){
		try {
			con = new Conexion();
			//se agregan las columnas
			modelo.addColumn("Articulo");
			modelo.addColumn("Precio");
			modelo.addColumn("Cantidad");
			modelo.addColumn("Importe");

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
	
	public ResultSet buscarProducto(String codigoProducto){
		try {
			rs = con.consulta("SELECT nombre,precio FROM productos WHERE codigo ="+codigoProducto);
			return rs;
		} catch (SQLException e) {
			return null;
			// TODO Auto-generated catch block
		}
		
		
	}
	
	public void agregarDatos(String codigoProducto, int cantidad){
		try {
			buscarProducto(codigoProducto);
			while(rs.next()){
				Object[] fila = new Object[2];
				
				for (int i=0;i < 2;i++){
					fila[i] = rs.getObject(i+1);
					
				}
				modelo.addRow(new Object[]{fila[0],fila[1],cantidad,(double)fila[1]*cantidad});
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	
	public double obtenerTotal(){
		double total = 0;

		for (int i=0; i< modelo.getRowCount();i++){
			total += (double) modelo.getValueAt(i,3);
			System.out.println("funcion:"+total);
			}
		
		
	return total;
	}
	
	public void limpiarTabla(){

		
		for (int i=modelo.getRowCount()-1;i >= 0 ;i--){
			modelo.removeRow(i);
			
		}
		
	}
}
