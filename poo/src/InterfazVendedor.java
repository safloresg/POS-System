import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfazVendedor extends JFrame implements ActionListener{
	
	JTable tabla;//
	JScrollPane scrollTabla;
	JTextField codigoField;//
	JLabel etiquetaLogo;//
	JLabel etiquetaTitulo;//
	JLabel etiquetaFecha;//
	JLabel etiquetaFolio;
	JLabel etiquetaImagenProducto;
	JLabel etiquetaTotal;
	JButton botonCobrar;
	ImageIcon imagenProducto;
	ImageIcon imagenLogo;//
	DefaultTableModel modelo;
	ResultSetMetaData meta;
	Conexion con;
	ResultSet rs;
	Tabla t ;
	InterfazVendedor(){
		
		setGUI();
		pack();
		setTitle("Venta");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void setGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container contenedor = getContentPane();
		GridBagLayout gb = new GridBagLayout();
		contenedor.setLayout(gb);
		
		Date fecha = new Date();
		imagenLogo = new ImageIcon("fime");
		etiquetaLogo = new JLabel(imagenLogo);
		etiquetaTitulo = new JLabel ("Nueva Venta");
		etiquetaFecha = new JLabel(fecha.toString());
		etiquetaFolio = new JLabel("0");
		tabla = new JTable();
		imagenLogo = new ImageIcon("carrito.gif");
		etiquetaImagenProducto = new JLabel(imagenLogo);
		codigoField = new JTextField();
		etiquetaTotal = new JLabel("0.00");
		tabla = new JTable();
		botonCobrar= new JButton("Cobrar");
		scrollTabla = new JScrollPane(tabla);
		
		GridBagConstraints constr = new GridBagConstraints();
		//Restricciones etiqueta logo
		// coordenada x en la cuadricula
		constr.gridx=0;
		// coordenada y en la cuadricula
		constr.gridy=0;
		// numero de celdas que ocupara a lo ancho
		constr.gridheight =1;
		// numero de celdas que ocupara a lo largo 
		constr.gridwidth= 1;
		// llenar el espacio vacio en la celda
		constr.fill= constr.BOTH;
		// proportion of horizontal space taken by this
		// component
		constr.weightx = 1.0;
		// proportion of vertical space taken by this component
		constr.weighty = 1.0;
		// posicion del la etiqueta en la celda 
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaLogo, constr);
		//restricciones etiquetaTitulo
		constr.gridx=1;
		constr.gridy=0;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaTitulo, constr);
		//restriccionesEtiquetaFecha
		constr.gridx=2;
		constr.gridy=0;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaFecha, constr);
		//restriccionesetiquetaFolio
		constr.gridx=3;
		constr.gridy=1;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaFolio, constr);
		//restriccionesetiquetaImagenProducto
		constr.gridx=0;
		constr.gridy=3;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaImagenProducto, constr);
		//restricciones tabla
		constr.gridx=1;
		constr.gridy=3;
		constr.gridheight =1;
		constr.gridwidth= 2;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(scrollTabla, constr);
		//restricciones codigoField
		constr.gridx=1;
		constr.gridy=4;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(codigoField, constr);
		//restricciones etiquetaTotal
		constr.gridx=2;
		constr.gridy=4;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaTotal, constr);
		//restricciones botonCobrar
		constr.gridx=3;
		constr.gridy=4;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(botonCobrar, constr);
		
		botonCobrar.addActionListener(this);
		
		contenedor.add(etiquetaLogo);
		contenedor.add(etiquetaTitulo);
		contenedor.add(etiquetaFecha);
		contenedor.add(etiquetaFolio);
		contenedor.add(etiquetaImagenProducto);
		contenedor.add(scrollTabla);
		contenedor.add(codigoField);
		contenedor.add(etiquetaTotal);
		contenedor.add(botonCobrar);
		String col[] = {"nombre","precio"};
		modelo = new DefaultTableModel();
		t = new Tabla(modelo);
		t.agregarColumnas("productos",col);
		
		tabla.setModel(modelo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		t.agregarDatos(codigoField.getText());
		
	}
	
	public void prueba (){
		
		try {
		con = new Conexion();
		modelo = new DefaultTableModel();
		tabla.setModel(modelo);
		ResultSet rs = con.consulta("SELECT nombre,precio FROM productos WHERE codigo= "+ codigoField.getText());
		meta = rs.getMetaData();
		
		for (int i=0;i < meta.getColumnCount();i++){
			modelo.addColumn(meta.getColumnLabel(i+1));
		}
		while(rs.next()){
			Object[] fila = new Object[meta.getColumnCount()];
			for (int i=0;i<meta.getColumnCount();i++){
				fila[i] = rs.getObject(i+1);
			}
			modelo.addRow(fila);
		
		
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(this, e.toString());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(this, e.toString());
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(this, e.toString());
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(this, e.toString());
	}
	
		
	}
	
	
}
