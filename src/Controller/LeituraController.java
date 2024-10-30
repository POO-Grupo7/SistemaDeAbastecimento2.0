/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.LeituraModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class LeituraController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LeituraModel> lista = new ArrayList<>();

    //Listar Clientes na ComboBox
    public ResultSet listarHidrometros() {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from historicohidrometro WHERE apagado = '0'";

        try {
            pstm = conexao.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LeituraController listar hidrometros" + erro.getMessage());
            return null;
        }
    }

    //Metodo que pega valores da BD e preenche nos campos
    public ResultSet PesquisarHidrometro(int idHistoricoHidrometro) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from historicohidrometro where idHistoricoHidrometro = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idHistoricoHidrometro);

            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LeituraController pesquisarHidrometros dados a prencher" + erro);
        }
        return null;
    }

    public boolean LeituraExiste(String mesRef, String nomeCliente) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT COUNT(*) FROM leituras WHERE mesRef = ? OR nomeCliente = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, mesRef);
            pstm.setString(2, nomeCliente);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LeituraController LeituraExiste" + erro);
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
                JOptionPane.showMessageDialog(null, "LeituraController LeituraExiste (finally)" + erro);
            }
        }
        return false;
    }

    //METODO PARA CADASTRAR
    public void cadastrarLeitura(LeituraModel leituraModel) {

        String sql = "insert into leituras (nrHidrometro, nomeCliente, bairro, quarteirao, numeroCasa, mesRef, dataLeitura, hidrometro, leitAnterior, leitActual, consumo, ocorrencia, nrLeitura, saldo, disp ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, leituraModel.getHistoricoHidrometro().getHidrometro().getNrHidrometro());
            pstm.setString(2, leituraModel.getHistoricoHidrometro().getCliente().getNome());
            pstm.setString(3, leituraModel.getHistoricoHidrometro().getCliente().getBairro());
            pstm.setInt(4, leituraModel.getHistoricoHidrometro().getCliente().getQuarteirao());
            pstm.setInt(5, leituraModel.getHistoricoHidrometro().getCliente().getNrDaCasa());
            pstm.setString(6, leituraModel.getMesReferencia());
            pstm.setString(7, leituraModel.getDataEmissao());
            pstm.setDouble(8, leituraModel.getLeituraAnterior());
            pstm.setDouble(9, leituraModel.getLeituraActual());
            pstm.setDouble(10, leituraModel.getConsumoMes());
            pstm.setString(11, leituraModel.getOcorrencia());
            pstm.setString(12, leituraModel.getNrLeitura());
//            pstm.setString(14, leituraModel.getDisp());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Leitura Salva com sucesso.");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LeituraController Cadastrar" + erro);
        }
    }
    //METODO PARA LISTAR
//    public ArrayList<LeituraModel> listarLeituras() {
//        ArrayList<LeituraModel> list = new ArrayList<>();
//        String sql = "select * from leituras where disp = 'Sim'";
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//            rs = pstm.executeQuery();
//
//            while (rs.next()) {
//                LeituraModel leituraModel = new LeituraModel();
//                leituraModel.setId(rs.getInt("idLeitura"));
//                leituraModel.SetNome(rs.getString("nomeCliente"));
//                leituraModel.SetMoradia(rs.getString("bairro"));
//                leituraModel.setQuarteirao(rs.getInt("quarteirao"));
//                leituraModel.setNrDaCasa(rs.getInt("numeroCasa"));
//                leituraModel.setMesReferencia(rs.getString("mesRef"));
//                leituraModel.setDataEmissao(rs.getString("dataLeitura"));
//                leituraModel.setHidrometro(rs.getString("hidrometro"));
//                leituraModel.setLeituraAnterior(rs.getDouble("leitAnterior"));
//                leituraModel.setLeituraActual(rs.getDouble("leitActual"));
//                leituraModel.setConsumoMes(rs.getDouble("consumo"));
//                leituraModel.setOcorrencia(rs.getString("ocorrencia"));
//                leituraModel.setNrLeitura(rs.getString("nrLeitura"));
//                leituraModel.setSaldo(rs.getDouble("saldo"));
//                leituraModel.setDisp(rs.getString("disp"));
//
//                list.add(leituraModel);
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "LeituraController Listar" + erro);
//        }
//        return list;
//    }
//
//    //METODO PARA LISTAR Leituras Apagadas
//    public ArrayList<LeituraModel> listarLeiturasApagadas() {
//        ArrayList<LeituraModel> list = new ArrayList<>();
//        String sql = "select * from leituras where disp = 'Não'";
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//            rs = pstm.executeQuery();
//
//            while (rs.next()) {
//                LeituraModel leituraModel = new LeituraModel();
//                leituraModel.setId(rs.getInt("idLeitura"));
//                leituraModel.SetNome(rs.getString("nomeCliente"));
//                leituraModel.SetMoradia(rs.getString("bairro"));
//                leituraModel.setQuarteirao(rs.getInt("quarteirao"));
//                leituraModel.setNrDaCasa(rs.getInt("numeroCasa"));
//                leituraModel.setMesReferencia(rs.getString("mesRef"));
//                leituraModel.setDataEmissao(rs.getString("dataLeitura"));
//                leituraModel.setHidrometro(rs.getString("hidrometro"));
//                leituraModel.setLeituraAnterior(rs.getDouble("leitAnterior"));
//                leituraModel.setLeituraActual(rs.getDouble("leitActual"));
//                leituraModel.setConsumoMes(rs.getDouble("consumo"));
//                leituraModel.setOcorrencia(rs.getString("ocorrencia"));
//                leituraModel.setNrLeitura(rs.getString("nrLeitura"));
//                leituraModel.setSaldo(rs.getDouble("saldo"));
//                leituraModel.setDisp(rs.getString("disp"));
//
//                list.add(leituraModel);
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "LeituraController Listar leituras apagados" + erro);
//        }
//        return list;
//    }
//
//    //Metodo para actualizar leituras
//    public void actualizarLeitura(LeituraModel leituraModel) {
//
//        String sql = "update leituras set nomeCliente = ?, bairro = ?, quarteirao = ?, numeroCasa = ?, mesRef = ? ,dataLeitura = ?, hidrometro = ?, leitAnterior =?, leitActual = ?, consumo = ?, ocorrencia = ?, nrLeitura = ?, saldo = ?, disp = ? where idLeitura =?";
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//            pstm.setString(1, leituraModel.getNome());
//            pstm.setString(2, leituraModel.getMoradia());
//            pstm.setInt(3, leituraModel.getQuarteirao());
//            pstm.setInt(4, leituraModel.getNrDaCasa());
//            pstm.setString(5, leituraModel.getMesReferencia());
//            pstm.setString(6, leituraModel.getDataEmissao());
//            pstm.setString(7, leituraModel.getHidrometro());
//            pstm.setDouble(8, leituraModel.getLeituraAnterior());
//            pstm.setDouble(9, leituraModel.getLeituraActual());
//            pstm.setDouble(10, leituraModel.getConsumoMes());
//            pstm.setString(11, leituraModel.getOcorrencia());
//            pstm.setString(12, leituraModel.getNrLeitura());
//
//            pstm.setDouble(13, leituraModel.getSaldo());
//            pstm.setString(14, leituraModel.getDisp());
//            pstm.setInt(15, leituraModel.getId());
//
//            pstm.execute();
//            pstm.close();
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "LeituraController Actuaizar Leitura" + erro);
//        }
//    }
//    //Metodo para actualizar Saldo
//
//    public void ActualizarSaldo(LeituraModel leituraModel) {
//        String sql = "UPDATE leituras SET saldo = ? WHERE nomeCliente = ?";
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//
//            pstm.setDouble(1, leituraModel.getSaldo());
//            pstm.setString(2, leituraModel.getNomeDoCliente());
//
//            pstm.execute();
//            pstm.close();
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Leitura Controller Actuaizar saldo" + erro);
//        }
//    }
//
}

    /*
    create table leituras (idLeitura int AUTO_INCREMENT PRIMARY KEY,
                       nomeCliente varchar(45), 
                       bairro varchar(45), 
                       quarteirao int, 
                       numeroCasa int, 
                       mesRef varchar(45),
                       dataLeitura  varchar(45), 
                       hidrometro varchar(45), 
                       leitAnterior double, 
                       leitActual double, 
                       consumo double, 
                       ocorrencia  varchar(45),
                       nrLeitura varchar(45),
                       saldo double,
                       activo varchar(45));


alterar nome da coluna e tipo de variavel
ALTER TABLE leituras CHANGE COLUMN activo disp VARCHAR(45);
     */
