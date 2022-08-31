package org.stamford;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.Objects;

public class FXMLController {
    @FXML
    private Label currentUserLabel;
    @FXML
    private Label systemMsgLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    public void initialize() {
    // myVBox.setSpacing(10);
    // String javaVersion = System.getProperty("java.version");
    // String javafxVersion = System.getProperty("javafx.version");
    // label.setText("Hello, JavaFX " + javafxVersion +
    // "\nRunning on Java " + javaVersion + ".");
    }
    @FXML protected void handleLoginButtonAction(ActionEvent event) {
        if (Objects.equals(passwordPasswordField.getText(), "123")) {
            currentUserLabel.setText("Current User: " + usernameTextField.getText());
            systemMsgLabel.setText("User '" + usernameTextField.getText() + "' is authenticated successfully.");
        } else {
             systemMsgLabel.setText("Authentication failed, try again.");
        }
    }
//    @FXML protected void handler(ActionEvent event) {
//        String password = passwordPasswordField.getText();
//        // use the read data...
//    }
//    @FXML protected void handler(ActionEvent event) {
//        currentUserLabel.setText("new String value");
//    }
}