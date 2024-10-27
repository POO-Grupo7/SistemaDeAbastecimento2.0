
package Controller;

import Model.HidrometroModel;
import Model.HidrometroModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HidrometroController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<HidrometroModel> lista = new ArrayList<>();

//    //Metodo que verifia a existencia de um Hidrometro com mesmos dados
//    public boolean clienteExiste(String emailHidrometro, String hidrometro) {
//        conexao = new ConexaoController().conectaBaseDados();
//        String sql = "SELECT COUNT(*) FROM hidrometro WHERE emailHidrometro = ? OR hidrometro = ?";
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//            pstm.setString(1, emailHidrometro);
//            pstm.setString(2, hidrometro);
//            rs = pstm.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1) > 0;
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "HidrometroController clienteExiste" + erro);
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (pstm != null) {
//                    pstm.close();
//                }
//                if (conexao != null) {
//                    conexao.close();
//                }
//            } catch (SQLException erro) {
//                JOptionPane.showMessageDialog(null, "HidrometroController clienteExiste (finally)" + erro);
//            }
//        }
//        return false;
//    }
    
    // Metodo de cadastro
    public void cadastrarHidrometro(HidrometroModel hidrometroModel) {
        String sql = "INSERT INTO hidrometro (nomeHidrometro, bairro, quarteirao, numeroCasa, dataContrato, emailHidrometro, telefone, consumo, saldo, activo, disp) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            // Ordem correta dos parâmetros de acordo com o SQL
            pstm.setString(1, hidrometroModel.getNome());            // nomeHidrometro
            pstm.setString(2, hidrometroModel.getBairro());          // bairro
            pstm.setInt(3, hidrometroModel.getQuarteirao());         // quarteirao
            pstm.setInt(4, hidrometroModel.getNrDaCasa());           // numeroCasa
            pstm.setString(5, hidrometroModel.getDataContracto());   // dataContrato
            pstm.setString(6, hidrometroModel.getEmail());           // emailHidrometro
            pstm.setInt(7, hidrometroModel.getNrTelefone());           // telefone
//            pstm.setString(8, hidrometroModel.getHidrometro());      // hidrometro
            pstm.setDouble(9, hidrometroModel.getConsumo());         // consumo
            pstm.setDouble(10, hidrometroModel.getSaldo());          // saldo
            pstm.setBoolean(11, hidrometroModel.getStatus());        // activo
            pstm.setBoolean(12, hidrometroModel.getDisp());          // disp

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "O Cadastro foi efetuado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + erro.getMessage());
        }
    }

    // pesquisar cliente 
    public ArrayList<HidrometroModel> PesquisarHidrometro() {
//    ArrayList<HidrometroModel> list = new ArrayList<>();
        String sql = "SELECT * FROM hidrometro WHERE disp = 1";  // Ajustado para boolean

        conexao = new ConexaoController().conectaBaseDados();

        try {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados falhou.");
                return lista;
            }

            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                HidrometroModel hidrometroModel = new HidrometroModel();
                hidrometroModel.setIdHidrometro(rs.getInt("idHidrometro"));
                hidrometroModel.setNome(rs.getString("nomeHidrometro"));
                hidrometroModel.setBairro(rs.getString("bairro"));
                hidrometroModel.setQuarteirao(rs.getInt("quarteirao"));
                hidrometroModel.setNrDaCasa(rs.getInt("numeroCasa"));
                hidrometroModel.setDataContracto(rs.getString("dataContrato"));
                hidrometroModel.setEmail(rs.getString("emailHidrometro"));
                hidrometroModel.setNrTelefone(rs.getInt("telefone"));  // Ajustado para String se telefone for String
//                hidrometroModel.setHidrometro(rs.getString("hidrometro"));
                hidrometroModel.setConsumo(rs.getDouble("consumo"));
                hidrometroModel.setSaldo(rs.getDouble("saldo"));
                hidrometroModel.setStatus(rs.getBoolean("activo"));
                hidrometroModel.setDisp(rs.getBoolean("disp"));  // Já tratado como booleano

                lista.add(hidrometroModel);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar hidrometro: " + erro.getMessage());
            erro.printStackTrace();  // Para depurar o erro
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
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return lista;
    }

    //Metodo para actualizar hidrometro
    public void ActualizarHidrometro(HidrometroModel hidrometroModel) {
        String sql = "update hidrometro set nomeHidrometro = ?, bairro = ?, quarteirao = ?, numeroCasa = ?, dataContrato = ?, emailHidrometro = ?, telefone = ?, hidrometro = ?, consumo = ?, saldo = ?, activo = ?, disp = ? where idHidrometro = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = new ConexaoController().conectaBaseDados();
            pstm = conexao.prepareStatement(sql);

            // Ordem correta dos parâmetros de acordo com o SQL
            
            pstm.setString(1, hidrometroModel.getNome());            // nomeHidrometro
            pstm.setString(2, hidrometroModel.getBairro());          // bairro
            pstm.setInt(3, hidrometroModel.getQuarteirao());         // quarteirao
            pstm.setInt(4, hidrometroModel.getNrDaCasa());           // numeroCasa
            pstm.setString(5, hidrometroModel.getDataContracto());   // dataContrato
            pstm.setString(6, hidrometroModel.getEmail());           // emailHidrometro
            pstm.setInt(7, hidrometroModel.getNrTelefone());           // telefone
//            pstm.setString(8, hidrometroModel.getHidrometro());      // hidrometro
            pstm.setDouble(9, hidrometroModel.getConsumo());         // consumo
            pstm.setDouble(10, hidrometroModel.getSaldo());          // saldo
            pstm.setBoolean(11, hidrometroModel.getStatus());        // activo
            pstm.setBoolean(12, hidrometroModel.getDisp()); 
            pstm.setInt(13, hidrometroModel.getIdHidrometro());// disp

            pstm.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Hidrometro Controller Atualizar Hidrometro: " + erro);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + erro);
            }
        }
    }

}


/*
create table hidrometro ( idHidrometro int AUTO_INCREMENT PRIMARY KEY, nomeHidrometro varchar(45), bairro varchar(45), 
quarteirao int(50), numeroCasa int, dataContrato varchar(45), emailHidrometro varchar(45), telefone int, hidrometro varchar(45),
consumo int, saldo double, activo varchar(45), disp varchar(45) );

reate table hidrometro ( idHidrometro int AUTO_INCREMENT PRIMARY KEY, nomeHidrometro varchar(45), bairro varchar(45), 
quarteirao int(50), numeroCasa int, dataContrato varchar(45), emailHidrometro varchar(45), telefone int,
consumo int, saldo double, activo varchar(45), disp varchar(45) );


 */
