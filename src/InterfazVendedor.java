import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfazVendedor extends JFrame implements ActionListener, KeyListener{
	
	JTable tabla;//
	JScrollPane scrollTabla;
	JTextField codigoField;
	JTextField folioField;
	JTextField totalField;
	JTextField productoField;
	JTextField cantidadField;
	JTextField importeField;
	JTextField pagoField;
	JTextField cambioField;
	
	JLabel etiquetaLogo;
	JLabel etiquetaTitulo;
	JLabel etiquetaFecha;
	JLabel etiquetaFolio;
	JLabel etiquetaImagenProducto;
	JLabel etiquetaTotal;
	JLabel etiquetaCodigo;
	JLabel etiquetaProducto;
	JLabel etiquetaCantidad;
	JLabel etiquetaImporte;
	JLabel etiquetaCambio;
	JLabel etiquetaPago;
	JPanel panelSuperior;
	JPanel panelPrincipal;
	JButton botonCobrar;
	ImageIcon imagenProducto;
	ImageIcon imagenLogo;//
	DefaultTableModel modelo;
	ResultSetMetaData meta;
	Conexion con;
	ResultSet rs;
	TablaVendedor t ;
	boolean enter = true;

	InterfazVendedor(){
		
		setGUI();//incializar componentes
		pack();
		setTitle("Venta");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void setGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelPrincipal = new JPanel();
		Container contenedor = getContentPane();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constr = new GridBagConstraints();
		contenedor.setLayout(gb);
		crearPanelSuperior(gb,constr);//se crea el panel superior 
		panelPrincipal.setLayout(gb);
		panelPrincipal.setBackground(Color.LIGHT_GRAY);
		
		tabla = new JTable();
		imagenLogo = new ImageIcon("carrito.gif");
		etiquetaImagenProducto = new JLabel(imagenLogo);
		codigoField = new JTextField();
		etiquetaTotal = new JLabel("Total:");
		tabla = new JTable();
		botonCobrar= new JButton("Cobrar",new ImageIcon("venta.png"));
		scrollTabla = new JScrollPane(tabla);
		totalField = new JTextField("0.00");
		etiquetaCodigo = new JLabel("Codigo:");
		etiquetaProducto = new JLabel("Producto:");
		etiquetaCantidad = new JLabel("Cantidad:");
		etiquetaImporte = new JLabel("Importe:");
		etiquetaCambio = new JLabel("Cambio:");
		etiquetaPago = new JLabel("Ud. Pago:");
		cambioField = new JTextField();
		pagoField = new JTextField();
		productoField = new JTextField();
		importeField = new JTextField();
		cantidadField = new JTextField();
		
		totalField.setEditable(false);
		cambioField.setEditable(false);
		pagoField.setEditable(false);
		tabla.setEnabled(false);
		cantidadField.setEditable(false);
		productoField.setEditable(false);
		importeField.setEditable(false);
		etiquetaTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		etiquetaFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		//restriccionesPanelSuperior
		constr.gridx=0;
		constr.gridy=0;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(panelSuperior, constr);
		
		//restriccionesPanelPrincipal
		constr.gridx=0;
		constr.gridy=1;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(panelPrincipal, constr);
		
		
		//restriccionesetiquetaImagenProducto
		constr.gridx=0;
		constr.gridy=0;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaImagenProducto, constr);
		
		//restricciones tabla
		constr.gridx=0;
		constr.gridy=0;
		constr.gridheight =8;
		constr.gridwidth= 5;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(scrollTabla, constr);
		
		//restricciones etiquetaCodigo
		constr.gridx=0;
		constr.gridy=8;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.NONE;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaCodigo, constr);
		
		//restricciones codigoField
		constr.gridx=0;
		constr.gridy=9;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = .5;
		constr.weighty = .5;
		constr.anchor=constr.CENTER;
		gb.setConstraints(codigoField, constr);
		
		//restricciones etiquetaProducto
		constr.gridx=1;
		constr.gridy=8;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.NONE;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaProducto, constr);
		
		//restricciones productoField
		constr.gridx=1;
		constr.gridy=9;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = .5;
		constr.anchor=constr.CENTER;
		gb.setConstraints(productoField, constr);
		
		//restricciones etiquetaCantidad
		constr.gridx=2;
		constr.gridy=8;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.NONE;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaCantidad, constr);
		
		//restricciones cantidadField
		constr.gridx=2;
		constr.gridy=9;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = .5;
		constr.weighty = .5;
		constr.anchor=constr.CENTER;
		gb.setConstraints(cantidadField, constr);
		
		//restricciones etiquetaImporte
		constr.gridx=3;
		constr.gridy=8;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.NONE;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaImporte, constr);
		
		//restricciones importeField
		constr.gridx=3;
		constr.gridy=9;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = .5;
		constr.weighty = .5;
		constr.anchor=constr.CENTER;
		gb.setConstraints(importeField, constr);
		
		
		//restricciones etiquetaTotal
		constr.gridx=5;
		constr.gridy=0;
		constr.gridheight= 1;
		constr.gridwidth= 1;
		constr.fill= constr.NONE;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.SOUTH;
		gb.setConstraints(etiquetaTotal, constr);
		
		//restricciones totalField
		constr.gridx=5;
		constr.gridy=1;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.HORIZONTAL;
		constr.weightx = .5;
		constr.weighty = 1.0;
		constr.anchor=constr.NORTH;
		gb.setConstraints(totalField, constr);
		
		//restricciones etiquetaPago
		constr.gridx=5;
		constr.gridy=2;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.NONE;
		constr.weightx = .5;
		constr.weighty = 1.0;
		constr.anchor=constr.SOUTH;
		gb.setConstraints(etiquetaPago, constr);
		
		//restricciones pagoField
		constr.gridx=5;
		constr.gridy=3;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.HORIZONTAL;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.NORTH;
		gb.setConstraints(pagoField,constr);
		
		//restricciones etiquetaCambio
		constr.gridx=5;
		constr.gridy=4;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.NONE;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.SOUTH;
		gb.setConstraints(etiquetaCambio,constr);
		
		//restricciones cambioField
		constr.gridx=5;
		constr.gridy=5;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.HORIZONTAL;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.NORTH;
		gb.setConstraints(cambioField,constr);
		
						
		//restricciones botonCobrar
		constr.gridx=5;
		constr.gridy=6;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(botonCobrar, constr);
		
		//panelPrincipal.add(etiquetaImagenProducto);
		panelPrincipal.add(scrollTabla);
		panelPrincipal.add(etiquetaCodigo);
		panelPrincipal.add(codigoField);
		panelPrincipal.add(etiquetaProducto);
		panelPrincipal.add(productoField);
		panelPrincipal.add(etiquetaCantidad);
		panelPrincipal.add(cantidadField);
		panelPrincipal.add(etiquetaImporte);
		panelPrincipal.add(importeField);
		panelPrincipal.add(etiquetaTotal);
		panelPrincipal.add(totalField);
		panelPrincipal.add(etiquetaPago);
		panelPrincipal.add(pagoField);
		panelPrincipal.add(etiquetaCambio);
		panelPrincipal.add(cambioField);
		panelPrincipal.add(botonCobrar);
		
		codigoField.addKeyListener(this);
		botonCobrar.addActionListener(this);
		
		contenedor.add(panelPrincipal);
		contenedor.add(panelSuperior);
		modelo = new DefaultTableModel();
		t = new TablaVendedor(modelo);//asignamos un DefaultTableModel a la tabla
		t.agregarColumnas();
		
		tabla.setModel(modelo);
	}
	
	
	public void crearPanelSuperior(GridBagLayout gb, GridBagConstraints constr){
		panelSuperior = new JPanel();
		panelSuperior.setLayout(gb);
		panelSuperior.setBackground(Color.yellow);
		Date fecha = new Date();
		imagenLogo = new ImageIcon("fime");
		etiquetaLogo = new JLabel(imagenLogo);
		etiquetaTitulo = new JLabel ("Nueva Venta");
		etiquetaFecha = new JLabel(fecha.toString());
		etiquetaFolio = new JLabel("No. de Venta");
		folioField = new JTextField("00001");
		
		folioField.setEnabled(false);
		//Restricciones etiqueta logo
		constr.gridx=0;
		constr.gridy=0;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaLogo, constr);
		
		//restricciones etiqueta Titulo
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
		
		//restriccionesfolioField
		constr.gridx=4;
		constr.gridy=1;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(folioField, constr);
		
		
		panelSuperior.add(etiquetaLogo);
		panelSuperior.add(etiquetaTitulo);
		panelSuperior.add(etiquetaFecha);
		panelSuperior.add(etiquetaFolio);
		panelSuperior.add(folioField);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {//cobramos
		double pago;
		pago = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el pago"));
		pagoField.setText(Double.toString(pago));
		cambioField.setText(Double.toString(pago-(Double.parseDouble(totalField.getText()))));
		t.limpiarTabla();
		totalField.setText("");
		
	}
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
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
	
	public void verificarDatosDelProducto(){
		ResultSet rs;
		rs = t.buscarProducto(codigoField.getText());
		try {
			if (rs.last()){
			productoField.setText(rs.getString(1));
			importeField.setText(rs.getString(2));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	//buscar producto al presionar la tecla enter
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			if (enter == true){
				if(codigoField.getText().length() >0 && isNumeric(codigoField.getText()) ){
				cantidadField.requestFocus();
				verificarDatosDelProducto();
//deshabilitamos codigoField para que una vez ingresado el producto solo se pueda modificar la cantidad
				codigoField.setEditable(false);
				cantidadField.addKeyListener(this);
				cantidadField.setEditable(true);
				enter = false;}
				else{
					JOptionPane.showMessageDialog(this, "Ingrese un codigo Valido");
					codigoField.setText("");
				}
				
			}else{
				if (cantidadField.getText().length() > 0 && isNumeric(cantidadField.getText())){
				codigoField.requestFocus();
				cantidadField.removeKeyListener(this);
				cantidadField.setEditable(false);
				codigoField.setEditable(true);
				t.agregarDatos(codigoField.getText(), Integer.parseInt(cantidadField.getText()));
				totalField.setText(Double.toString(t.obtenerTotal()));
				codigoField.setText("");
				productoField.setText("");
				cantidadField.setText("");
				importeField.setText("");
				enter = true;}
				else{
					
				}
			}
			
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	
}
