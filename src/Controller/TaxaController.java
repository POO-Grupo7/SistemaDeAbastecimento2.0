/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TaxaModel;
import Model.TaxaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mac
 */
public class TaxaController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<TaxaModel> lista = new ArrayList<>();

    // Metodo de cadastro 
    public void cadastrarTaxa(TaxaModel taxaModel) {
        String sql = "INSERT INTO taxa (nomeTaxa, tipoTaxa, valorTaxa, processada) VALUES (?,?,?,?)";

        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            // Ordem correta dos parâmetros de acordo com o SQL
            pstm.setString(1, taxaModel.getNome());
            pstm.setInt(2, taxaModel.getTipoconsumo());
            pstm.setDouble(3, taxaModel.getValortaxa());
            pstm.setString(4, taxaModel.getProcessada());

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "A Taxa foi efetuada com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Taxa: " + erro.getMessage());
        }
    }

    //METODO PARA LISTAR
    public ArrayList<TaxaModel> listarTaxa() {
        String sql = "select * from taxa where processada = 'Sim'";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                TaxaModel taxaModel = new TaxaModel();
                taxaModel.setId(rs.getInt("idTaxa"));
                taxaModel.setNome(rs.getString("nomeTaxa"));
                taxaModel.setTipoconsumo(rs.getInt("tipoTaxa"));
                taxaModel.setValortaxa(rs.getDouble("valorTaxa"));
                taxaModel.setProcessada(rs.getString("processada"));

                lista.add(taxaModel);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TaxaController listar" + erro);
        }
        return lista;
    }

    //Metodo para actualizar clientes
//    public void ActualizarTaxa(TaxaModel taxaModel) {
//        String sql = "update taxa set nomeTaxa = ?, tipoTaxa = ?, valorTaxa = ?, processada = ? where idTaxa = ?";
//        Connection conexao = null;
//        PreparedStatement pstm = null;
//
//        try {
//            conexao = new ConexaoController().conectaBaseDados();
//            pstm = conexao.prepareStatement(sql);
//
//            // Ordem correta dos parâmetros de acordo com o SQL
//            pstm.setString(1, taxaModel.getNome());
//            pstm.setInt(2, taxaModel.getTipoconsumo());
//            pstm.setDouble(3, taxaModel.getValortaxa());
//            pstm.setString(4, taxaModel.getProcessada());
//            pstm.setInt(5, taxaModel.getId());
//
//            pstm.executeUpdate();
//
////             Mostrar mensagem de sucesso após a execução bem-sucedida
//            JOptionPane.showMessageDialog(null, "Taxa atualizada com sucesso");
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro ao atualizar Taxa: " + erro);
//        } finally {
//            try {
//                if (pstm != null) {
//                    pstm.close();
//                }
//                if (conexao != null) {
//                    conexao.close();
//                }
//            } catch (SQLException erro) {
//                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + erro);
//            }
//        }
//
//    }
// Método para atualizar os dados de uma taxa existente
public void AtualizarTaxa(TaxaModel taxaModel) {
    String sql = "UPDATE taxa SET nomeTaxa = ?, tipoTaxa = ?, valorTaxa = ?, processada = ? WHERE idTaxa = ?";

    conexao = new ConexaoController().conectaBaseDados();

    try {
        pstm = conexao.prepareStatement(sql);

        // Definindo os valores dos parâmetros de acordo com o SQL
        pstm.setString(1, taxaModel.getNome());
        pstm.setInt(2, taxaModel.getTipoconsumo());
        pstm.setDouble(3, taxaModel.getValortaxa());
        pstm.setString(4, taxaModel.getProcessada());
        pstm.setInt(5, taxaModel.getId()); // Identificador da taxa a ser atualizada

        pstm.executeUpdate();
        pstm.close();


    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar Taxa: " + erro.getMessage());
    }
}

    
}

//create table taxas ( idTaxa int AUTO_INCREMENT PRIMARY KEY, nomeTaxa varchar(45), tipoTaxa int, valorTaxa double,processada varchar(5)  );
