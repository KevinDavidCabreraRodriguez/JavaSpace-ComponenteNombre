package javaspace.nombre;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class ComponenteNombre extends VBox implements Initializable {

	@FXML
	private Label nombreText;

	@FXML
	private ProgressBar shieldBar;

	private DoubleProperty shield = new SimpleDoubleProperty(this, "shield", 1);

	public ComponenteNombre() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ComponenteNombreView.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		shieldBar.progressProperty().bind(shield);

	}

	public void setText(String text) {
		nombreText.setText(text);
	}

	public final String getText() {
		return nombreText.getText();
	}

	public final DoubleProperty shieldProperty() {
		return this.shield;
	}

	public final double getShield() {
		return this.shieldProperty().get();
	}

	public final void setShield(final double shield) {
		this.shieldProperty().set(shield);
	}

}
