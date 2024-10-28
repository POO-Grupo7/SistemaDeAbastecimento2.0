package Controller;

import Model.ClienteModel;
import Model.HidrometroModel;
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
    // Metodo de cadastro
    public void cadastrarHistoricoHidometro(HistoricoHidrometroModel historicoHidrometroModel) {
        String sql = "INSERT INTO historicoHidrometro (nomeCliente , bairro, quarteirao, numeroCasa, dataInicioUso, dataFimUso, nrHidrometro, apagado) VALUES (?,?,?,?,?,?,?,?)";

        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, historicoHidrometroModel.getCliente().getNome());            // nomeHistoricoHidometro
            pstm.setString(2, historicoHidrometroModel.getCliente().getBairro());          // bairro
            pstm.setInt(3, historicoHidrometroModel.getCliente().getQuarteirao());         // quarteirao
            pstm.setInt(4, historicoHidrometroModel.getCliente().getNrDaCasa());           // numeroCasa
            pstm.setString(5, historicoHidrometroModel.getDataInicial());   // dataContrato
            pstm.setString(6, historicoHidrometroModel.getDataFinal());           // emailHistoricoHidometro
            pstm.setString(7, historicoHidrometroModel.getHidrometro().getNrHidrometro());           // telefone
            pstm.setBoolean(8, historicoHidrometroModel.getApagado());          // disp

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Historico salvo com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar historicoHidometro: " + erro.getMessage());
        }
    }

    // listar historicoHidometro 
    public ArrayList<HistoricoHidrometroModel> listarHistoricoHidometro() {
        String sql = "SELECT * FROM historicoHidrometro WHERE apagado = 0";

        conexao = new ConexaoController().conectaBaseDados();

        try {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados falhou.");
                return lista;
            }

            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                HistoricoHidrometroModel historicoHidrometroModel = new HistoricoHidrometroModel();
                historicoHidrometroModel.setIdHistoricoHidrometro(rs.getInt("idHistoricoHidometro"));
                ClienteModel cliente = new ClienteModel();
                cliente.setNome(rs.getString("nomeCliente"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setQuarteirao(rs.getInt("quarteirao"));
                cliente.setNrDaCasa(rs.getInt("numeroCasa"));
                historicoHidrometroModel.setCliente(cliente);

                historicoHidrometroModel.setDataInicial(rs.getString("dataInicioUso"));
                historicoHidrometroModel.setDataFinal(rs.getString("dataFimUso"));

                HidrometroModel hidrometroModel = new HidrometroModel();
                hidrometroModel.setNrHiodrometro(rs.getString("nrHidrometro"));
                historicoHidrometroModel.setHidrometro(hidrometroModel);

                historicoHidrometroModel.setApagado(rs.getBoolean("apagado"));

                lista.add(historicoHidrometroModel);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar historicoHidometros: " + erro.getMessage());
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

//    //Metodo para actualizar historicoHidometros
//    public void ActualizarHistoricoHidometro(HistoricoHidrometroModel historicoHidrometroModel) {
//        String sql = "update historicoHidometros set nomeHistoricoHidometro = ?, bairro = ?, quarteirao = ?, numeroCasa = ?, dataContrato = ?, emailHistoricoHidometro = ?, telefone = ?, hidrometro = ?, consumo = ?, saldo = ?, activo = ?, disp = ? where idHistoricoHidometro = ?";
//        Connection conexao = null;
//        PreparedStatement pstm = null;
//
//        try {
//            conexao = new ConexaoController().conectaBaseDados();
//            pstm = conexao.prepareStatement(sql);
//
//            // Ordem correta dos parâmetros de acordo com o SQL
//            pstm.setString(1, historicoHidrometroModel.getNome());            // nomeHistoricoHidometro
//            pstm.setString(2, historicoHidrometroModel.getBairro());          // bairro
//            pstm.setInt(3, historicoHidrometroModel.getQuarteirao());         // quarteirao
//            pstm.setInt(4, historicoHidrometroModel.getNrDaCasa());           // numeroCasa
//            pstm.setString(5, historicoHidrometroModel.getDataContracto());   // dataContrato
//            pstm.setString(6, historicoHidrometroModel.getEmail());           // emailHistoricoHidometro
//            pstm.setInt(7, historicoHidrometroModel.getNrTelefone());           // telefone
////            pstm.setString(8, historicoHidrometroModel.getHidrometro());      // hidrometro
//            pstm.setDouble(9, historicoHidrometroModel.getConsumo());         // consumo
//            pstm.setDouble(10, historicoHidrometroModel.getSaldo());          // saldo
//            pstm.setBoolean(11, historicoHidrometroModel.getStatus());        // activo
//            pstm.setBoolean(12, historicoHidrometroModel.getDisp());
//            pstm.setInt(13, historicoHidrometroModel.getIdHistoricoHidometro());// disp
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

/*
create table historicoHidrometro (idHistoricoHidrometro int AUTO_INCREMENT PRIMARY KEY, nomeCliente varchar(45), bairro varchar(45), 
quarteirao int(50), numeroCasa int, dataInicioUso varchar(45), dataFimUso varchar(45), nrHidrometro varchar(45), apagado tinyint);
 */
