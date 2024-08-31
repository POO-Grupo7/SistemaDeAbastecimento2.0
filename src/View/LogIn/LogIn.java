package View.LogIn;

import View.MainFxml;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class LogIn extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            System.out.println(getClass().getResource("/View/LogIn/Login.fxml"));

            Parent root = FXMLLoader.load(getClass().getResource("/View/LogIn/Login.fxml"));
            Scene scene2 = new Scene(root);

            stage.setTitle("Seja Bem vindo(a)");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene2);
            stage.show();
        } catch (Exception e) {
            Logger.getLogger(MainFxml.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
