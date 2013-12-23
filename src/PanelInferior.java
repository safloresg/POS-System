import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelInferior {
	JPanel panelInferior ;

	PanelInferior(){
		panelInferior = new JPanel();
		panelInferior.setLayout(new CardLayout());
		
	}

	public JPanel crearPanelInferior(){
		return panelInferior;
		
	}

	public void agregarPanel(Panel p, String nombreDelPanel){
		
		panelInferior.add(p.crearPanel(),nombreDelPanel);
	}
	
	public void cambiarPanelMostrado(Panel p, String nombreDelPanel){
		p.panelMostrado(nombreDelPanel);
		p.limpiarCampos();
		
	}

	
	
}
