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

    //Metodo que verifia a existencia de um Hidrometro com mesmos dados
    public boolean TaxaExiste(String nome, double valor) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT COUNT(*) FROM taxas WHERE nomeTaxa = ? OR valorTaxa = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setDouble(2, valor);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TaxaController TaxaExiste" + erro);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "TaxaController taxaExiste (finally)" + erro);
            }
        }
        return false;
    }

    //Metodo que pega valores da BD e preenche nos campos
    public ResultSet PesquisarTaxas(int idTaxas) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from taxas where idTaxa = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idTaxas);

            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TaxaController pesquisar Taxa dados a prencher" + erro);
        }
        return null;
    }

    // Metodo de cadastro 
    public void cadastrarTaxa(TaxaModel taxaModel) {
        if (TaxaExiste(taxaModel.getNome(), taxaModel.getValortaxa())) {
            JOptionPane.showMessageDialog(null, "A Taxa ja existe!");
        } else {

            String sql = "INSERT INTO taxas (nomeTaxa, tipoTaxa, valorTaxa, processada) VALUES (?,?,?,?)";

            conexao = new ConexaoController().conectaBaseDados();

            try {
                pstm = conexao.prepareStatement(sql);

                // Ordem correta dos parâmetros de acordo com o SQL
                pstm.setString(1, taxaModel.getNome());
                pstm.setString(2, taxaModel.getTipoconsumo());
                pstm.setDouble(3, taxaModel.getValortaxa());
                pstm.setString(4, taxaModel.getProcessada());

                pstm.execute();
                pstm.close();

                JOptionPane.showMessageDialog(null, "A Taxa foi efetuada com sucesso");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Taxa: " + erro.getMessage());
            }
        }
    }

    //METODO PARA LISTAR
    public ArrayList<TaxaModel> listarTaxa() {
        String sql = "select * from taxas where processada = 'Sim'";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                TaxaModel taxaModel = new TaxaModel();
                taxaModel.setId(rs.getInt("idTaxa"));
                taxaModel.setNome(rs.getString("nomeTaxa"));
                taxaModel.setTipoconsumo(rs.getString("tipoTaxa"));
                taxaModel.setValortaxa(rs.getDouble("valorTaxa"));
                taxaModel.setProcessada(rs.getString("processada"));

                lista.add(taxaModel);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TaxaController listar" + erro);
        }
        return lista;
    }

// Método para atualizar os dados de uma taxa existente
    public void AtualizarTaxa(TaxaModel taxaModel) {
        String sql = "UPDATE taxas SET nomeTaxa = ?, tipoTaxa = ?, valorTaxa = ?, processada = ? WHERE idTaxa = ?";

        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            // Definindo os valores dos parâmetros de acordo com o SQL
            pstm.setString(1, taxaModel.getNome());
            pstm.setString(2, taxaModel.getTipoconsumo());
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
//create table taxas ( idTaxa int AUTO_INCREMENT PRIMARY KEY, nomeTaxa varchar(45), tipoTaxa varchar(45), valorTaxa double,processada varchar(5));
