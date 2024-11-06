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

    //Metodo que verifia a existencia de um ususario com mesmos dados
    public boolean clienteExiste(String nome, String email) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT COUNT(*) FROM clientes WHERE nomeCliente = ? OR emailCliente = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setString(2, email);
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

    //Metodo para cadastrar cliente
    public void cadastrarCliente(ClienteModel clienteModel) {
        if (clienteExiste(clienteModel.getNome(), clienteModel.getEmail())) {
            JOptionPane.showMessageDialog(null, "Já existe um usuário com os mesmos dados.");
        } else {
            String sql = "INSERT INTO clientes (nomeCliente, bairro, quarteirao, numeroCasa, dataContrato, emailCliente, telefone, saldo, activo, disp) VALUES (?,?,?,?,?,?,?,?,?,?)";
            Connection conexao = new ConexaoController().conectaBaseDados();
            PreparedStatement pstm = null;

            try {
                pstm = conexao.prepareStatement(sql);

                // Ordem correta dos parâmetros de acordo com o SQL
                pstm.setString(1, clienteModel.getNome());
                pstm.setString(2, clienteModel.getBairro());
                pstm.setInt(3, clienteModel.getQuarteirao());
                pstm.setInt(4, clienteModel.getNrDaCasa());
                pstm.setString(5, clienteModel.getDataContracto());
                pstm.setString(6, clienteModel.getEmail());
                pstm.setString(7, String.valueOf(clienteModel.getNrTelefone()));  // Converter para String se necessário
//                pstm.setDouble(8, clienteModel.getConsumo());
                pstm.setDouble(8, clienteModel.getSaldo());
                pstm.setBoolean(9, clienteModel.getStatus());
                pstm.setBoolean(10, clienteModel.getDisp());

                pstm.executeUpdate(); // Use executeUpdate para operações de INSERT, UPDATE, DELETE
                JOptionPane.showMessageDialog(null, "O Cadastro foi efetuado com sucesso");

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + erro);
                erro.printStackTrace(); // Mostra detalhes no console para ajudar na depuração

            } finally {
                try {
                    if (pstm != null) {
                        pstm.close();
                    }
                    if (conexao != null) {
                        conexao.close();
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + erro.getMessage());
                }
            }
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
//                clienteModel.setConsumo(rs.getDouble("consumo"));
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
        String sql = "update clientes set nomeCliente = ?, bairro = ?, quarteirao = ?, numeroCasa = ?, dataContrato = ?, emailCliente = ?, telefone = ?, saldo = ?, activo = ?, disp = ? where idCliente = ?";
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
//            pstm.setDouble(8, clienteModel.getConsumo());         // consumo
            pstm.setDouble(8, clienteModel.getSaldo());          // saldo
            pstm.setBoolean(9, clienteModel.getStatus());        // activo
            pstm.setBoolean(10, clienteModel.getDisp());
            pstm.setInt(11, clienteModel.getIdCliente());// disp

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

    //Metodo para actualizar Saldo
    public void ActualizarSaldo(ClienteModel clienteModel) {
        String sql = "UPDATE clientes SET saldo = ? WHERE nomeCliente = ?";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            pstm.setDouble(1, clienteModel.getSaldo());
            pstm.setString(2, clienteModel.getNome());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cliente Controller Actuaizar saldo" + erro);
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
