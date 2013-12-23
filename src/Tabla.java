import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;


public  class Tabla {
	
	public void agregarColumnas(DefaultTableModel modelo, ResultSet rs){
		try {
			ResultSetMetaData rsMeta = rs.getMetaData();
			rsMeta.getColumnCount();
			for (int i=0; i < rsMeta.getColumnCount();i++){
				modelo.addColumn(rsMeta.getColumnLabel(i+1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
