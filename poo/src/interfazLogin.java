

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class interfazLogin extends JFrame implements ActionListener {
	
	
	
	// declaracion de los botones,etiquetas...
	JLabel etiquetaTitulo;
	JLabel  etiquetaUsuario;
	JLabel  etiquetaContrasena;
	JLabel etiquetaImagenCarrito;
	JLabel etiquetaImagenFime;
	JPasswordField contrasenaField;
	JTextField usuarioField;
	JButton botonAceptar;
	ImageIcon imagenCarrito;
	ImageIcon imagenFime;
	
	interfazLogin(){
		setSize(600,300);
		setGUI();
		setTitle("Bienvenido");
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
	public void setGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contenedor = getContentPane();
		GridBagLayout gb = new GridBagLayout();
		contenedor.setLayout(gb);
		
		GridBagConstraints constr = new GridBagConstraints();
		//instanciamos los componentes 
		etiquetaTitulo = new JLabel ("BIENVENIDO");
		etiquetaUsuario = new JLabel("Usuario:");
		etiquetaContrasena = new JLabel("Contrasena:");
		usuarioField = new JTextField(20);
		contrasenaField = new JPasswordField(20);
		botonAceptar = new JButton("Aceptar");
		imagenCarrito = new ImageIcon("carrito.gif");
		imagenFime = new ImageIcon("fime");
		etiquetaImagenFime = new JLabel(imagenFime);
		etiquetaImagenCarrito = new JLabel(imagenCarrito);
		
		
		etiquetaTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		
		etiquetaUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		etiquetaContrasena.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

		
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
		gb.setConstraints(etiquetaImagenFime, constr);
		//restricciones para la etiqueta titulo
		constr.gridx=1;
		constr.gridy=0;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaTitulo, constr);
		//restricciones para la etiquetaimagen carrito
		constr.gridx=2;
		constr.gridy=0;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaImagenCarrito, constr);
		//restricciones para la etiqueta Usuario
		constr.gridx=0;
		constr.gridy=1;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.RELATIVE;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaUsuario, constr);
		//Restricciones para el campo usuario
		constr.gridx=1;
		constr.gridy=1;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.HORIZONTAL;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(usuarioField, constr);
		//Restricciones etiqueta contraseña
		constr.gridx=0;
		constr.gridy=2;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.RELATIVE;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(etiquetaContrasena, constr);
		//restricciones para campo contraseña
		constr.gridx=1;
		constr.gridy=2;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.HORIZONTAL;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(contrasenaField, constr);
		//restricciones boton aceptar
		constr.gridx=1;
		constr.gridy=3;
		constr.gridheight =1;
		constr.gridwidth= 1;
		constr.fill= constr.HORIZONTAL;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		gb.setConstraints(botonAceptar, constr);

		botonAceptar.addActionListener(this);
		
		contenedor.add(etiquetaTitulo);
		contenedor.add(etiquetaImagenCarrito);
		contenedor.add(etiquetaUsuario);
		contenedor.add(etiquetaImagenFime);
		contenedor.add(usuarioField);
    	contenedor.add(etiquetaContrasena);
		contenedor.add(contrasenaField);
		contenedor.add(botonAceptar);
	}



@Override
public void actionPerformed(ActionEvent e) {
	String usuario =usuarioField.getText();
	
	String contrasena = new String(contrasenaField.getPassword()); 
	
	//verificar que los campos usuario y contraseña no esten vacios
	if (usuario.length() > 0 && contrasena.length() > 0){
		if(validarUsuario(usuario,contrasena)){
			System.out.println("Conexion realizada con exito!!!");
			this.dispose();
			InterfazVendedor vendedor = new InterfazVendedor();
		}else{
			JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
			usuarioField.setText("");
			contrasenaField.setText("");
		}
				
	}
	else {
		
		JOptionPane.showMessageDialog(this, "Ingrese un usuario y contrasena");
		
	}
	
	
}
//verificar que el usuario y contrasena introducidos se encuentren en la BD
public boolean validarUsuario(String usr, String pswd){
	try {
		Conexion con = new Conexion();
		ResultSet rs= con.consulta("SELECT * FROM usuarios WHERE usuario= '"+usr+"' AND contraseña= "+pswd);
		if (rs.first()){
			return true;

		}else{
			return false;
			
		}
		
	} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null,"error:"+e.toString());
		return false;
		// TODO Auto-generated catch block
		
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null,"error:"+e.toString());
		return false;
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null,"error:"+e.toString());
		return false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null,"error:"+e.toString());
		return false;
	}
	
	
}
}
