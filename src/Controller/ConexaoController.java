package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoController {

    public Connection conectaBaseDados(){
       Connection conexao = null;
       
       try {
           String url = "jdbc:mysql://localhost:3306/SistemaDeAbastecimento2.0?user=root&pasword=123=";
           conexao = DriverManager.getConnection(url);
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null,"conexaoBD" + erro.getMessage());
       }
       return conexao;
   }
}
