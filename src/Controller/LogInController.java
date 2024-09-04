package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class LogInController extends AnchorPane implements Initializable {

    @FXML
    private Button btnLogIn;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void logIn(ActionEvent event) {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
