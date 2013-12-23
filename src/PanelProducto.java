import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelProducto implements Panel{
	private CardLayout cardLayout = new CardLayout();
	private JPanel panelProducto;
	private JLabel etiquetaProducto;
	private JLabel etiquetaPrecio;
	private JLabel etiquetaCategoria;
	private JLabel etiquetaCodigo;
	private JLabel etiquetaProveedor;
	private JTextField productoAgregarField;
	private JTextField precioAgregarField;
	private JTextField proveedorAgregarField;
	private JComboBox<String> categoriaAgregar;
	private JTextField codigoAgregarField;
	
	private JTextField productoEliminarField;
	private JTextField precioEliminarField;
	private JTextField proveedorEliminarField;
	private JComboBox<String> categoriaEliminar;
	private JTextField codigoEliminarField;
	
	private JTextField productoModificarField;
	private JTextField precioModificarField;
	private JTextField proveedorModificarField;
	private JComboBox<String> categoriaModificar;
	private JTextField codigoModificarField;
	
	private JTextField productoBuscarField;
	private JTextField precioBuscarField;
	private JTextField proveedorBuscarField;
	private JComboBox<String> categoriaBuscar;
	private JTextField codigoBuscarField;
	
	private boolean modificarProducto = false;
	
	PanelProducto(){//constructor	
	}
	
	public JPanel crearPanel(){
		panelProducto = new JPanel();
		panelProducto.setLayout(cardLayout);
		panelProducto.add(crearPanelAgregar(),"panelAgregar");
		panelProducto.add(crearPanelEliminar(),"panelEliminar");
		panelProducto.add(crearPanelBuscar(),"panelBuscar");
		panelProducto.add(crearPanelModificar(),"panelModificar");
		return panelProducto;
	}
	
	public JPanel crearPanelModificar(){
		JPanel panelModificar;
		JButton botonModificar;
		
		
		
		panelModificar = new JPanel();
		panelModificar.setBackground(Color.LIGHT_GRAY);
		panelModificar.setLayout(new GridLayout(6,2,30,30));
		
		productoModificarField = new JTextField(30);
		proveedorModificarField = new JTextField();
		precioModificarField = new JTextField();
		categoriaModificar = new JComboBox<String>(new String[]{"Lapices","Libretas","Regalos","Oficina"});
		codigoModificarField = new JTextField();
		botonModificar = new JButton("Modificar");
		etiquetaProducto = new JLabel("Producto:",JLabel.CENTER);
		etiquetaPrecio = new JLabel("Precio:",JLabel.CENTER);
		etiquetaCategoria = new JLabel("Categoria:",JLabel.CENTER);
		etiquetaCodigo = new JLabel("Codigo:",JLabel.CENTER);
		etiquetaProveedor = new JLabel("Proveedor:",JLabel.RIGHT);
/*
		productoModificarField.setEnabled(false);
		precioModificarField.setEnabled(false);
		proveedorModificarField.setEnabled(false);
		categoriaModificar.setEnabled(false);
*/
		panelModificar.add(etiquetaProducto);
		panelModificar.add(etiquetaPrecio);
		panelModificar.add(productoModificarField);
		panelModificar.add(precioModificarField);
		panelModificar.add(etiquetaCodigo);
		panelModificar.add(etiquetaCategoria);
		panelModificar.add(codigoModificarField);
		panelModificar.add(categoriaModificar);
		panelModificar.add(etiquetaProveedor);
		panelModificar.add(proveedorModificarField);
		panelModificar.add(botonModificar);
		
		botonModificar.addActionListener(this);
		
		return panelModificar;
		
	}

	@Override
	public JPanel crearPanelBuscar() {
		JPanel panelBuscar;
		JButton botonBuscar;
		
		
		
		panelBuscar = new JPanel();
		panelBuscar.setBackground(Color.LIGHT_GRAY);
		panelBuscar.setLayout(new GridLayout(6,2,30,30));
		
		productoBuscarField = new JTextField(30);
		proveedorBuscarField = new JTextField();
		precioBuscarField = new JTextField();
		categoriaBuscar = new JComboBox<String>(new String[]{"Lapices","Libretas","Regalos","Oficina"});
		codigoBuscarField = new JTextField();
		botonBuscar = new JButton("Buscar");
		etiquetaProducto = new JLabel("Producto:",JLabel.CENTER);
		etiquetaPrecio = new JLabel("Precio:",JLabel.CENTER);
		etiquetaCategoria = new JLabel("Categoria:",JLabel.CENTER);
		etiquetaCodigo = new JLabel("Codigo:",JLabel.CENTER);
		etiquetaProveedor = new JLabel("Proveedor:",JLabel.RIGHT);
		
		productoBuscarField.setEnabled(false);
		precioBuscarField.setEnabled(false);
		proveedorBuscarField.setEnabled(false);
		categoriaBuscar.setEnabled(false);
		
		panelBuscar.add(etiquetaCodigo);//
		panelBuscar.add(codigoBuscarField);
		panelBuscar.add(new JLabel());
		panelBuscar.add(botonBuscar);
		panelBuscar.add(etiquetaProducto);
		panelBuscar.add(etiquetaPrecio);
		panelBuscar.add(productoBuscarField);
		panelBuscar.add(precioBuscarField);
		panelBuscar.add(etiquetaProveedor);
		panelBuscar.add(etiquetaCategoria);
		panelBuscar.add(proveedorBuscarField);
		panelBuscar.add(categoriaBuscar);
		
		botonBuscar.addActionListener(this);
		
		return panelBuscar;
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel crearPanelEliminar() {
		// TODO Auto-generated method stub
		JPanel panelEliminar;
		JButton botonEliminar;

		 panelEliminar = new JPanel();
		 panelEliminar.setBackground(Color.LIGHT_GRAY);
		 panelEliminar.setLayout(new GridLayout(6,2,30,30));
		 
		 productoEliminarField = new JTextField(30);
		 proveedorEliminarField = new JTextField();
		 precioEliminarField = new JTextField();
		 categoriaEliminar = new JComboBox<String>(new String[]{"Lapices","Libretas","Regalos","Oficina"});
		 codigoEliminarField = new JTextField();
		 botonEliminar = new JButton("Eliminar");
		 etiquetaProducto = new JLabel("Producto:",JLabel.CENTER);
		 etiquetaPrecio = new JLabel("Precio:",JLabel.CENTER);
		 etiquetaCategoria = new JLabel("Categoria:",JLabel.CENTER);
		 etiquetaCodigo = new JLabel("Codigo:",JLabel.CENTER);
		 etiquetaProveedor = new JLabel("Proveedor:",JLabel.RIGHT);
		

		 productoEliminarField.setEnabled(false);
		 precioEliminarField.setEnabled(false);
		 proveedorEliminarField.setEnabled(false);
		 categoriaEliminar.setEnabled(false);
		 
		 panelEliminar.add(etiquetaProducto);
		 panelEliminar.add(etiquetaPrecio);
		 panelEliminar.add(productoEliminarField);
		 panelEliminar.add(precioEliminarField);
		 panelEliminar.add(etiquetaCodigo);
		 panelEliminar.add(etiquetaCategoria);
		 panelEliminar.add(codigoEliminarField);
		 panelEliminar.add(categoriaEliminar);
		 panelEliminar.add(etiquetaProveedor);
		 panelEliminar.add(proveedorEliminarField);
		 panelEliminar.add(botonEliminar);	
		 
		 botonEliminar.addActionListener(this);
		 return panelEliminar;
	}

	@Override
	public JPanel crearPanelAgregar() {
		// TODO Auto-generated method stub
		JPanel panelAgregar;
		JButton botonAgregar;
		
		panelAgregar = new JPanel();
		panelAgregar.setBackground(Color.LIGHT_GRAY);
		panelAgregar.setLayout(new GridLayout(6,2,30,30));
		
		
		productoAgregarField = new JTextField(30);
		proveedorAgregarField = new JTextField();
		precioAgregarField = new JTextField();
		categoriaAgregar = new JComboBox(new String[]{"Lapices","Libretas","Regalos","Oficina"});
		codigoAgregarField = new JTextField();
		botonAgregar = new JButton("Agregar");
		etiquetaProducto = new JLabel("Producto:",JLabel.CENTER);
		etiquetaPrecio = new JLabel("Precio:",JLabel.CENTER);
		etiquetaCategoria = new JLabel("Categoria:",JLabel.CENTER);
		etiquetaCodigo = new JLabel("Codigo:",JLabel.CENTER);
		etiquetaProveedor = new JLabel("Proveedor:",JLabel.RIGHT);
		
		
		panelAgregar.add(etiquetaProducto);
		panelAgregar.add(etiquetaPrecio);
		panelAgregar.add(productoAgregarField);
		panelAgregar.add(precioAgregarField);
		panelAgregar.add(etiquetaCodigo);
		panelAgregar.add(etiquetaCategoria);
		panelAgregar.add(codigoAgregarField);
		panelAgregar.add(categoriaAgregar);
		panelAgregar.add(etiquetaProveedor);
		panelAgregar.add(proveedorAgregarField);
		panelAgregar.add(botonAgregar);
		
		botonAgregar.addActionListener(this);
		return panelAgregar;
	}
	
	public void panelMostrado(String panelMostrado){
		cardLayout.show(panelProducto, panelMostrado);
		System.out.println("Mostrando Panel"+ panelMostrado);
	}
	
	private boolean llenarDatosBuscar(ResultSet rs){
		try {
			if (rs.last()){
				
			productoBuscarField.setText(rs.getString(1));
			precioBuscarField.setText(rs.getString(2));
			proveedorBuscarField.setText(rs.getString(3));
			categoriaBuscar.setSelectedIndex(rs.getInt(4));
			codigoBuscarField.setText(rs.getString(5));
			return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void limpiarCampos(){
		productoAgregarField.setText("");
		precioAgregarField.setText("");
		codigoAgregarField.setText("");
		categoriaAgregar.setSelectedIndex(0);
		proveedorAgregarField.setText("");
		
		productoEliminarField.setText("");
		precioEliminarField.setText("");
		codigoEliminarField.setText("");
		categoriaEliminar.setSelectedIndex(0);
		proveedorEliminarField.setText("");
		
		productoBuscarField.setText("");
		precioBuscarField.setText("");
		codigoBuscarField.setText("");
		categoriaBuscar.setSelectedIndex(0);
		proveedorBuscarField.setText("");
	}
	
	
	public boolean validarCamposAgregarProducto(){
		if(precioAgregarField.getText().length() > 0 && codigoAgregarField.getText().length() > 0 &&
				Validar.isDouble(precioAgregarField.getText()) && Validar.isInteger(codigoAgregarField.getText())){
			return true;
		}
		else return false;
	}
	
	public boolean validarCamposBuscarProducto(){
		if (codigoBuscarField.getText().length()>0 && Validar.isInteger(codigoBuscarField.getText())){
			
			return true;
		}
		else return false;
	}
	
	public boolean validarCamposModificarProducto(){
if (codigoModificarField.getText().length()>0 && Validar.isInteger(codigoModificarField.getText())){
			
			return true;
		}
		else return false;		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton boton = (JButton)e.getSource();
		Producto producto = new Producto();
		if (boton.getText() == "Agregar"){
			if (validarCamposAgregarProducto()){
				if(producto.agregar(productoAgregarField.getText(),
						proveedorAgregarField.getText(),
						Double.parseDouble(precioAgregarField.getText()),
						categoriaAgregar.getSelectedIndex(),
						Integer.parseInt(codigoAgregarField.getText()))){
					JOptionPane.showMessageDialog(panelProducto, "Producto Agregado con exito");
					
				}
					
			}else
				JOptionPane.showMessageDialog(null, "Informacion no valida");
		}
		else if(boton.getText() == "Eliminar"){
			if (producto.eliminar("productos",Integer.parseInt(codigoEliminarField.getText()))){
				JOptionPane.showMessageDialog(panelProducto, "Producto eliminado con exito");
				
			}else{
				System.out.println("No se encontro el producto");
				JOptionPane.showMessageDialog(panelProducto, "No se encontro el producto");
			}
					
					System.out.println("Eliminar");
							
		}
		else if (boton.getText() == "Buscar"){
			if (validarCamposBuscarProducto()){
			ResultSet rs; 			
			rs = producto.buscar(Integer.parseInt(codigoBuscarField.getText()), "productos");
			if(llenarDatosBuscar(rs)){
				
			}else{
				JOptionPane.showMessageDialog(panelProducto, "No se encontro el producto");
			}
			}else {
				JOptionPane.showMessageDialog(panelProducto, "Informacion No valida");
				System.out.println("Informacion no valida");			
			}
		}
		
		else if (boton.getText() == "Modificar"){
			if (validarCamposModificarProducto()){
				if (producto.modificar(productoModificarField.getText(),
									proveedorModificarField.getText(),
									Double.parseDouble(precioModificarField.getText()),
									categoriaModificar.getSelectedIndex(),
									Integer.parseInt(codigoModificarField.getText()))){
					JOptionPane.showMessageDialog(panelProducto, "Producto Modificado con exito");
				}else{
					JOptionPane.showMessageDialog(panelProducto, "Producto no encontrado");
				}
			}else {
					JOptionPane.showMessageDialog(panelProducto, "Informacion No valida");
					System.out.println("Informacion no valida");			
				}
		}			
	}
			
		}
		
	
		

		
	


