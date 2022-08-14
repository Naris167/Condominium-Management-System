package org.stamford;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FXMLController {

    @FXML
    private Label currentUserLabel;
    @FXML
    private Label systemMsgLabel;
    @FXML
    private VBox myVBox;
    public void initialize() {
        myVBox.setSpacing(10);
        // String javaVersion = System.getProperty("java.version");
        // String javafxVersion = System.getProperty("javafx.version");
        // label.setText("Hello, JavaFX " + javafxVersion +
        // "\nRunning on Java " + javaVersion + ".");
    }
}