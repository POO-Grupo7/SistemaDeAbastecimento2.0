package View;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class FxmlLoader {
    private Pane view;
    
    public Pane getPane(String fileName){
        try {
            URL fileUrl = Main.class.getResource("/main/"+fileName+".fxml");
            if (fileUrl == null){
                throw new java.io.FileNotFoundException("Fxml can't found");
            }
            view = new FxmlLoader.load(fileUrl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No page " +fileName+ "please check FxmlLoader" + e);
        }
        return view;
    }
}
