
package Controller;

import Model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ClienteModel> lista = new ArrayList<>();

    //Metodo que verifia a existencia de um Cliente com mesmos dados
    public boolean clienteExiste(String emailCliente, String hidrometro) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT COUNT(*) FROM clientes WHERE emailCliente = ? OR hidrometro = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, emailCliente);
            pstm.setString(2, hidrometro);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteController clienteExiste" + erro);
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
                JOptionPane.showMessageDialog(null, "ClienteController clienteExiste (finally)" + erro);
            }
        }
        return false;
    }
    
    // Metodo de cadastro
    public void cadastrarCliente(ClienteModel clienteModel) {
        String sql = "INSERT INTO clientes (nomeCliente, bairro, quarteirao, numeroCasa, dataContrato, emailCliente, telefone, consumo, saldo, activo, disp) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            // Ordem correta dos parâmetros de acordo com o SQL
            pstm.setString(1, clienteModel.getNome());            // nomeCliente
            pstm.setString(2, clienteModel.getBairro());          // bairro
            pstm.setInt(3, clienteModel.getQuarteirao());         // quarteirao
            pstm.setInt(4, clienteModel.getNrDaCasa());           // numeroCasa
            pstm.setString(5, clienteModel.getDataContracto());   // dataContrato
            pstm.setString(6, clienteModel.getEmail());           // emailCliente
            pstm.setInt(7, clienteModel.getNrTelefone());           // telefone
//            pstm.setString(8, clienteModel.getHidrometro());      // hidrometro
            pstm.setDouble(9, clienteModel.getConsumo());         // consumo
            pstm.setDouble(10, clienteModel.getSaldo());          // saldo
            pstm.setBoolean(11, clienteModel.getStatus());        // activo
            pstm.setBoolean(12, clienteModel.getDisp());          // disp

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "O Cadastro foi efetuado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + erro.getMessage());
        }
    }

    // pesquisar cliente 
    public ArrayList<ClienteModel> PesquisarCliente() {
//    ArrayList<ClienteModel> list = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE disp = 1";  // Ajustado para boolean

        conexao = new ConexaoController().conectaBaseDados();

        try {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados falhou.");
                return lista;
            }

            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ClienteModel clienteModel = new ClienteModel();
                clienteModel.setIdCliente(rs.getInt("idCliente"));
                clienteModel.setNome(rs.getString("nomeCliente"));
                clienteModel.setBairro(rs.getString("bairro"));
                clienteModel.setQuarteirao(rs.getInt("quarteirao"));
                clienteModel.setNrDaCasa(rs.getInt("numeroCasa"));
                clienteModel.setDataContracto(rs.getString("dataContrato"));
                clienteModel.setEmail(rs.getString("emailCliente"));
                clienteModel.setNrTelefone(rs.getInt("telefone"));  // Ajustado para String se telefone for String
//                clienteModel.setHidrometro(rs.getString("hidrometro"));
                clienteModel.setConsumo(rs.getDouble("consumo"));
                clienteModel.setSaldo(rs.getDouble("saldo"));
                clienteModel.setStatus(rs.getBoolean("activo"));
                clienteModel.setDisp(rs.getBoolean("disp"));  // Já tratado como booleano

                lista.add(clienteModel);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar clientes: " + erro.getMessage());
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

    //Metodo para actualizar clientes
    public void ActualizarCliente(ClienteModel clienteModel) {
        String sql = "update clientes set nomeCliente = ?, bairro = ?, quarteirao = ?, numeroCasa = ?, dataContrato = ?, emailCliente = ?, telefone = ?, hidrometro = ?, consumo = ?, saldo = ?, activo = ?, disp = ? where idCliente = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = new ConexaoController().conectaBaseDados();
            pstm = conexao.prepareStatement(sql);

            // Ordem correta dos parâmetros de acordo com o SQL
            
            pstm.setString(1, clienteModel.getNome());            // nomeCliente
            pstm.setString(2, clienteModel.getBairro());          // bairro
            pstm.setInt(3, clienteModel.getQuarteirao());         // quarteirao
            pstm.setInt(4, clienteModel.getNrDaCasa());           // numeroCasa
            pstm.setString(5, clienteModel.getDataContracto());   // dataContrato
            pstm.setString(6, clienteModel.getEmail());           // emailCliente
            pstm.setInt(7, clienteModel.getNrTelefone());           // telefone
//            pstm.setString(8, clienteModel.getHidrometro());      // hidrometro
            pstm.setDouble(9, clienteModel.getConsumo());         // consumo
            pstm.setDouble(10, clienteModel.getSaldo());          // saldo
            pstm.setBoolean(11, clienteModel.getStatus());        // activo
            pstm.setBoolean(12, clienteModel.getDisp()); 
            pstm.setInt(13, clienteModel.getIdCliente());// disp

            pstm.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cliente Controller Atualizar Cliente: " + erro);
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
create table clientes ( idCliente int AUTO_INCREMENT PRIMARY KEY, nomeCliente varchar(45), bairro varchar(45), 
quarteirao int(50), numeroCasa int, dataContrato varchar(45), emailCliente varchar(45), telefone int, hidrometro varchar(45),
consumo int, saldo double, activo varchar(45), disp varchar(45) );

reate table clientes ( idCliente int AUTO_INCREMENT PRIMARY KEY, nomeCliente varchar(45), bairro varchar(45), 
quarteirao int(50), numeroCasa int, dataContrato varchar(45), emailCliente varchar(45), telefone int,
consumo int, saldo double, activo varchar(45), disp varchar(45) );


 */
