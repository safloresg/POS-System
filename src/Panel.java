import java.awt.event.ActionListener;
import javax.swing.*;


public interface Panel extends ActionListener {
	JPanel crearPanel();
	JPanel crearPanelBuscar();
	JPanel crearPanelEliminar();
	JPanel crearPanelAgregar();
	JPanel crearPanelModificar();
	void panelMostrado(String panelMostrado);
	void limpiarCampos();

}
