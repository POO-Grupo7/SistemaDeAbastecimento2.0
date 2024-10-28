package Controller;

import Model.HistoricoHidrometroModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HistoricoHidrometroController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<HistoricoHidrometroModel> lista = new ArrayList<>();

//    //Metodo que verifia a existencia de um HistoricoHidometro com mesmos dados
//    public boolean historicoHidometroExiste(String emailHistoricoHidometro, String hidrometro) {
//        conexao = new ConexaoController().conectaBaseDados();
//        String sql = "SELECT COUNT(*) FROM historicoHidometros WHERE emailHistoricoHidometro = ? OR hidrometro = ?";
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//            pstm.setString(1, emailHistoricoHidrometro);
//            pstm.setString(2, hidrometro);
//            rs = pstm.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1) > 0;
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "HistoricoHidometroController historicoHidometroExiste" + erro);
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
//                JOptionPane.showMessageDialog(null, "HistoricoHidometroController historicoHidometroExiste (finally)" + erro);
//            }
//        }
//        return false;
//    }
//    // Metodo de cadastro
//    public void cadastrarHistoricoHidometro(HistoricoHidrometroModel historicoHidrometroModel) {
//        String sql = "INSERT INTO historicoHidometros (nomeHistoricoHidometro, bairro, quarteirao, numeroCasa, dataContrato, emailHistoricoHidometro, telefone, consumo, saldo, activo, disp) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//
//            // Ordem correta dos parâmetros de acordo com o SQL
//            pstm.setString(1, historicoHidometroModel.getNome());            // nomeHistoricoHidometro
//            pstm.setString(2, historicoHidometroModel.getBairro());          // bairro
//            pstm.setInt(3, historicoHidometroModel.getQuarteirao());         // quarteirao
//            pstm.setInt(4, historicoHidometroModel.getNrDaCasa());           // numeroCasa
//            pstm.setString(5, historicoHidometroModel.getDataContracto());   // dataContrato
//            pstm.setString(6, historicoHidometroModel.getEmail());           // emailHistoricoHidometro
//            pstm.setInt(7, historicoHidometroModel.getNrTelefone());           // telefone
////            pstm.setString(8, historicoHidometroModel.getHidrometro());      // hidrometro
//            pstm.setDouble(9, historicoHidometroModel.getConsumo());         // consumo
//            pstm.setDouble(10, historicoHidometroModel.getSaldo());          // saldo
//            pstm.setBoolean(11, historicoHidometroModel.getStatus());        // activo
//            pstm.setBoolean(12, historicoHidometroModel.getDisp());          // disp
//
//            pstm.execute();
//            pstm.close();
//
//            JOptionPane.showMessageDialog(null, "O Cadastro foi efetuado com sucesso");
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro ao cadastrar historicoHidometro: " + erro.getMessage());
//        }
//    }
//
//    // pesquisar historicoHidometro 
//    public ArrayList<HistoricoHidrometroModel> listarHistoricoHidometro() {
////    ArrayList<HistoricoHidometroModel> list = new ArrayList<>();
//        String sql = "SELECT * FROM historicoHidometros WHERE disp = 1";  // Ajustado para boolean
//
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            if (conexao == null) {
//                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados falhou.");
//                return lista;
//            }
//
//            pstm = conexao.prepareStatement(sql);
//            rs = pstm.executeQuery();
//
//            while (rs.next()) {
//                HistoricoHidrometroModel historicoHidometroModel = new HistoricoHidrometroModel();
//                historicoHidometroModel.setIdHistoricoHidometro(rs.getInt("idHistoricoHidometro"));
//                historicoHidometroModel.setNome(rs.getString("nomeHistoricoHidometro"));
//                historicoHidometroModel.setBairro(rs.getString("bairro"));
//                historicoHidometroModel.setQuarteirao(rs.getInt("quarteirao"));
//                historicoHidometroModel.setNrDaCasa(rs.getInt("numeroCasa"));
//                historicoHidometroModel.setDataContracto(rs.getString("dataContrato"));
//                historicoHidometroModel.setEmail(rs.getString("emailHistoricoHidometro"));
//                historicoHidometroModel.setNrTelefone(rs.getInt("telefone"));  // Ajustado para String se telefone for String
////                historicoHidometroModel.setHidrometro(rs.getString("hidrometro"));
//                historicoHidometroModel.setConsumo(rs.getDouble("consumo"));
//                historicoHidometroModel.setSaldo(rs.getDouble("saldo"));
//                historicoHidometroModel.setStatus(rs.getBoolean("activo"));
//                historicoHidometroModel.setDisp(rs.getBoolean("disp"));  // Já tratado como booleano
//
//                lista.add(historicoHidometroModel);
//            }
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro ao pesquisar historicoHidometros: " + erro.getMessage());
//            erro.printStackTrace();  // Para depurar o erro
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
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
//            }
//        }
//        return lista;
//    }

//    //Metodo para actualizar historicoHidometros
//    public void ActualizarHistoricoHidometro(HistoricoHidrometroModel historicoHidometroModel) {
//        String sql = "update historicoHidometros set nomeHistoricoHidometro = ?, bairro = ?, quarteirao = ?, numeroCasa = ?, dataContrato = ?, emailHistoricoHidometro = ?, telefone = ?, hidrometro = ?, consumo = ?, saldo = ?, activo = ?, disp = ? where idHistoricoHidometro = ?";
//        Connection conexao = null;
//        PreparedStatement pstm = null;
//
//        try {
//            conexao = new ConexaoController().conectaBaseDados();
//            pstm = conexao.prepareStatement(sql);
//
//            // Ordem correta dos parâmetros de acordo com o SQL
//            pstm.setString(1, historicoHidometroModel.getNome());            // nomeHistoricoHidometro
//            pstm.setString(2, historicoHidometroModel.getBairro());          // bairro
//            pstm.setInt(3, historicoHidometroModel.getQuarteirao());         // quarteirao
//            pstm.setInt(4, historicoHidometroModel.getNrDaCasa());           // numeroCasa
//            pstm.setString(5, historicoHidometroModel.getDataContracto());   // dataContrato
//            pstm.setString(6, historicoHidometroModel.getEmail());           // emailHistoricoHidometro
//            pstm.setInt(7, historicoHidometroModel.getNrTelefone());           // telefone
////            pstm.setString(8, historicoHidometroModel.getHidrometro());      // hidrometro
//            pstm.setDouble(9, historicoHidometroModel.getConsumo());         // consumo
//            pstm.setDouble(10, historicoHidometroModel.getSaldo());          // saldo
//            pstm.setBoolean(11, historicoHidometroModel.getStatus());        // activo
//            pstm.setBoolean(12, historicoHidometroModel.getDisp());
//            pstm.setInt(13, historicoHidometroModel.getIdHistoricoHidometro());// disp
//
//            pstm.executeUpdate();
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "HistoricoHidrometro Controller Atualizar HistoricoHidometro: " + erro);
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
//    }
    
        //Listar Clientes na ComboBox
    public ResultSet listarClientes() {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from clientes WHERE activo = '1' and disp = '1' ORDER BY nomeCliente;";

        try {
            pstm = conexao.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "HistoricoHidrometroController pesquisar clientes" + erro.getMessage());
            return null;
        }
    }
        //Listar Hidrometros na ComboBox
    public ResultSet listarHidrometros() {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from hidrometro WHERE estado = 'Operacional' and apagado = '0' ORDER BY idHidrometro;";

        try {
            pstm = conexao.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "HistoricoHidrometroController pesquisar hidrometro" + erro.getMessage());
            return null;
        }
    }

    //Metodo que pega valores da BD e preenche nos campos
    public ResultSet pesquisarClientes(int idCliente) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from clientes where idCliente = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idCliente);

            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "HistoricoHidrometroController pesquisar cliente dados a prencher" + erro);
        }
        return null;
    }
    //Metodo que pega valores da BD e preenche nos campos
    public ResultSet pesquisarHidrometro(int idHidrometro) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from hidrometro where idHidrometro = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idHidrometro);

            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "HistoricoHidrometroController pesquisar hidrometro dados a prencher" + erro);
        }
        return null;
    }
}
