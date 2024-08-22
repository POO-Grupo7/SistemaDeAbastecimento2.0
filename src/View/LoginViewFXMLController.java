package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class LoginViewFXMLController implements Initializable {

    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogIn;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtUserName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLogIn(ActionEvent event) {
        if (txtUserName.getText().equals("Ussene") && txtPassword.getText().equals("123")) {
            JOptionPane.showMessageDialog(null, "Entrando");
            txtUserName.setText("");
            txtPassword.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "UserName e/ou senha incorrecta!");
            txtUserName.setText("");
            txtPassword.setText("");
        }

    }

    @FXML
    private void btnCancel(ActionEvent event) {
        System.exit(0);
    }

}
