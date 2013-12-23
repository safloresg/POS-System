import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class InterfazAdministrador extends JFrame implements ActionListener {
	JPanel panelAdmProductos,panelAdmEmpleados,panelAdmVentas,panelAdmProveedores,panelAdm,panelOpciones;
	PanelInferior panelInferior = new PanelInferior();
	CardLayout cardLayout = new CardLayout();
	JButton botonAgregarProducto;
	JButton botonNuevaVenta;
	JButton botonBuscarProducto;
	JButton botonModificarProducto;
	JButton botonEliminarProducto;
	JButton botonAgregarEmpleado;
	JButton botonBuscarEmpleado;
	JButton botonModificarEmpleado;
	JButton botonEliminarEmpleado;
	JComboBox<String> combo;
	Panel panelProducto;
	
	public InterfazAdministrador(){
	}
	public void initInterfazAdministrador(){
	
		crearPanelAdmProductos();
		crearPanelAdmEmpleados();
		crearPanelAdm();
		crearPanelOpciones();
		crearPanelInferior();
		crearVentana();
	}
	
	public void crearPanelAdm(){
		panelAdm = new JPanel();
		panelAdm.setLayout(cardLayout);
		panelAdm.add(panelAdmProductos,"panelProductos");
		panelAdm.add(panelAdmEmpleados,"panelEmpleados");
	}
public void crearPanelAdmProductos(){
	panelAdmProductos = new JPanel();
	panelAdmProductos.setLayout(new BoxLayout(panelAdmProductos,BoxLayout.X_AXIS));
	botonAgregarProducto = new JButton("Alta de Producto");
	botonEliminarProducto = new JButton("Baja de Producto");
	botonModificarProducto = new JButton("Modificar Producto");
	botonBuscarProducto = new JButton("Buscar Producto");
	panelAdmProductos.add(botonAgregarProducto);
	panelAdmProductos.add(botonEliminarProducto);
	panelAdmProductos.add(botonModificarProducto);
	panelAdmProductos.add(botonBuscarProducto);
	botonAgregarProducto.addActionListener(this);
	botonBuscarProducto.addActionListener(this);
	botonModificarProducto.addActionListener(this);
	botonEliminarProducto.addActionListener(this);
	}

public void crearPanelAdmEmpleados(){
	panelAdmEmpleados = new JPanel();
	panelAdmEmpleados.setLayout(new BoxLayout(panelAdmEmpleados,BoxLayout.X_AXIS));
	botonAgregarEmpleado = new JButton("Alta de Empleado");
	botonBuscarEmpleado = new JButton("Baja de Empleado");
	botonModificarEmpleado = new JButton("Modificar Emplead");
	botonEliminarEmpleado = new JButton("buscar Empleados");
	panelAdmEmpleados.add(botonAgregarEmpleado);
	panelAdmEmpleados.add(botonBuscarEmpleado);
	panelAdmEmpleados.add(botonModificarEmpleado);
	panelAdmEmpleados.add(botonEliminarEmpleado);
	botonAgregarEmpleado.addActionListener(this);
	botonBuscarEmpleado.addActionListener(this);
	botonModificarEmpleado.addActionListener(this);
	botonEliminarEmpleado.addActionListener(this);
	
}

public void crearPanelAdmProveedores(){
	panelAdmProveedores = new JPanel();
	panelAdmProveedores.setLayout(new BoxLayout(panelAdmProveedores,BoxLayout.X_AXIS));
	JButton botonAgregarProveedor = new JButton("Alta de Proveedor");
	
	
}

public void crearPanelAdmVentas(){
	
	
}

public void crearPanelInferior(){
	panelProducto = new PanelProducto();
	panelProducto.crearPanel();
	panelInferior.agregarPanel(panelProducto, "panelProducto");
	
}

public void crearPanelOpciones(){
	combo = new JComboBox<String>(new String[]{"Productos","Empleados","Proveedores"});
	botonNuevaVenta = new JButton("Nueva Venta");
	panelOpciones = new JPanel();
	panelOpciones.setLayout(new FlowLayout());
	combo.addActionListener(this);
	panelOpciones.add(botonNuevaVenta);
	panelOpciones.add(combo);
	panelOpciones.setBackground(Color.yellow);
	botonNuevaVenta.addActionListener(this);
}

public void crearVentana(){
	Container contenedor = getContentPane();
	contenedor.setLayout(new FlowLayout());
	contenedor.add(panelOpciones);
	contenedor.add(panelAdm);
	contenedor.add(panelInferior.crearPanelInferior());
	setTitle("Administrador");
	setSize(750,600);
	setLocationRelativeTo(null);
	setVisible(true);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
}


@Override
public void actionPerformed(ActionEvent e) {
	Object accion = e.getSource();
	
		

		
	
	 if (combo.getSelectedIndex() == 0){
		cardLayout.show(panelAdm,"panelProductos");
	}else if(combo.getSelectedIndex() == 1){
		System.out.println("panelEmpleados");
		JOptionPane.showMessageDialog(this, "Menu empleado no disponible");
		cardLayout.show(panelAdm,"panelEmpleados");
	}else if(combo.getSelectedIndex() == 2){
		JOptionPane.showMessageDialog(this, "Menu Proveedores no disponible");

		
	}
	
		if (accion == botonAgregarProducto){
			panelInferior.cambiarPanelMostrado(panelProducto,"panelAgregar");
			
		}
		if (accion == botonEliminarProducto){
			panelInferior.cambiarPanelMostrado(panelProducto,"panelEliminar");
		}
		
		if (accion == botonBuscarProducto){
			
			panelInferior.cambiarPanelMostrado(panelProducto, "panelBuscar");
		}
		
		if (accion == botonModificarProducto){
			panelInferior.cambiarPanelMostrado(panelProducto, "panelModificar");
		}
		
		if (accion == botonNuevaVenta){
			this.dispose();
			InterfazVendedor vendedor= new InterfazVendedor();
		}
	
}
	
}