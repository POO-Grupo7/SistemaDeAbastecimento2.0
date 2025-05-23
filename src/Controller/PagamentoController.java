/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ClienteModel;
import Model.FacturacaoModel;
import Model.LeituraModel;
import Model.PagamentoModel;
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
public class PagamentoController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PagamentoModel> lista = new ArrayList<>();

    //Listar Facturas na ComboBox
    public ResultSet listarFacturas() {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from facturacao WHERE disp = 'Sim' and paga = '0';";

        try {
            pstm = conexao.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PagamentoController pesquisar factura" + erro.getMessage());
            return null;
        }
    }

    //Metodo que pega valores da BD e preenche nos campos
    public ResultSet PrencherDadosFactura(int idFacturacao) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from facturacao where idFacturacao = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idFacturacao);

            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PagamentoController pegar dados a prencher" + erro);
        }
        return null;
    }

    //Metodo que verifia a existencia de um factura com mesmos dados
    public boolean pagamentoExiste(int nrRecibo) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT COUNT(*) FROM pagamentos WHERE nrRecibo = ?";

        try {
            pstm = conexao.prepareStatement(sql);
//            pstm.setInt(1, nrDaFactura);
            pstm.setInt(1, nrRecibo);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PagamentoController pagamentoExiste" + erro);
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
                JOptionPane.showMessageDialog(null, "PagamentoController pagamentoExiste (finally)" + erro);
            }
        }
        return false;
    }

    //METODO PARA CADASTRAR
    public void registarPagamento(PagamentoModel pagamentoModel) {
        if (pagamentoExiste(pagamentoModel.getNrRecibo())) {
            JOptionPane.showMessageDialog(null, "O pagamento ja existe!");
        } else {
            String sql = "insert into pagamentos (nomeCliente, dataPag, prazoPag, nrDaFactura, valorFactura, multa, valorTotal, valorPago , trocos , saldo, nrRecibo, processada) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            conexao = new ConexaoController().conectaBaseDados();

            try {
                pstm = conexao.prepareStatement(sql);

                pstm.setString(1, pagamentoModel.getCliente().getNome());
                pstm.setString(2, pagamentoModel.getDataPagamento());
                pstm.setString(3, pagamentoModel.getPrazoPagamento());
                pstm.setInt(4, pagamentoModel.getNrDaFactura());
                pstm.setDouble(5, pagamentoModel.getValorDaFactura());
                pstm.setDouble(6, pagamentoModel.getMulta());
                pstm.setDouble(7, pagamentoModel.getValorTotal());
                pstm.setDouble(8, pagamentoModel.getValorPago());
                pstm.setDouble(9, pagamentoModel.getTrocos());
                pstm.setDouble(10, pagamentoModel.getCliente().getSaldo());
                pstm.setInt(11, pagamentoModel.getNrRecibo());
                pstm.setBoolean(12, pagamentoModel.getProcessada());

                pstm.executeUpdate();  // Usar executeUpdate para inserção
                JOptionPane.showMessageDialog(null, "O Pagamento foi registado com sucesso");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao registrar pagamento: " + erro.getMessage());
            } finally {
                try {
                    if (pstm != null) {
                        pstm.close();
                    }
                    if (conexao != null) {
                        conexao.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//    public void registarPagamento(PagamentoModel pagamentoModel) {
//
//        String sql = "insert into pagamentos (nomeCliente, dataPag, prazoPag, nrDaFactura, valorFactura, multa, valorTotal, valorPago , trocos , saldo, nrRecibo, processada) values (?,?,?,?,?,?,?,?,?,?,?,?) ";
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//
//            pstm.setString(1, pagamentoModel.getNomeDoCliente());
//            pstm.setString(2, pagamentoModel.getDataPagamento());
//            pstm.setString(3, pagamentoModel.getPrazoPagamento());
//            pstm.setInt(4, pagamentoModel.getNrDaFactura());
//            pstm.setDouble(5, pagamentoModel.getValorDaFactura());
//            pstm.setDouble(6, pagamentoModel.getMulta());
//            pstm.setDouble(7, pagamentoModel.getValorTotal());
//            pstm.setDouble(8, pagamentoModel.getValorPago());
//            pstm.setDouble(9, pagamentoModel.getTrocos());
//            pstm.setDouble(10, pagamentoModel.getSaldo());
//            pstm.setInt(11, pagamentoModel.getNrRecibo());
//            pstm.setBoolean(12, pagamentoModel.getProcessada());
//
//            pstm.execute();
//            pstm.close();
//
//            JOptionPane.showMessageDialog(null, "O Pagamento foi registado com sucesso");
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "PagamentoController registar pagamento" + erro);
//        }
//    }
    //METODO PARA LISTAR

    public ArrayList<PagamentoModel> listarPagamento() {
        ArrayList<PagamentoModel> list = new ArrayList<>();
        String sql = "select * from pagamentos where processada = '1'";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PagamentoModel pagamentoModel = new PagamentoModel();
                pagamentoModel.setIdPagamento(rs.getInt("idPagamento"));
                ClienteModel clienteModel = new ClienteModel();
                clienteModel.setNome(rs.getString("nomeCliente"));
                pagamentoModel.setCliente(clienteModel);

                pagamentoModel.setDataPagamento(rs.getString("dataPag"));
                pagamentoModel.setPrazoPagamento(rs.getString("prazoPag"));
                pagamentoModel.setNrDaFactura(rs.getInt("nrDaFactura"));
                pagamentoModel.setValorDaFactura(rs.getDouble("valorFactura"));
                pagamentoModel.setMulta(rs.getDouble("multa"));
                pagamentoModel.setValorTotal(rs.getDouble("valorTotal"));
                pagamentoModel.setValorPago(rs.getDouble("valorPago"));
                pagamentoModel.setTrocos(rs.getDouble("trocos"));

                clienteModel.setSaldo(rs.getDouble("saldo"));
                pagamentoModel.setCliente(clienteModel);
                pagamentoModel.setNrRecibo(rs.getInt("nrRecibo"));
                pagamentoModel.setProcessada(rs.getBoolean("processada"));

                list.add(pagamentoModel);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PagamentoController listar" + erro);
        }
        return list;
    }

    //METODO PARA LISTAR PAGAMENTOS APAGADOS
    public ArrayList<PagamentoModel> listarPagamentoApagados() {
        ArrayList<PagamentoModel> list = new ArrayList<>();
        String sql = "select * from pagamentos where processada = '1'";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PagamentoModel pagamentoModel = new PagamentoModel();
                pagamentoModel.setIdPagamento(rs.getInt("idPagamento"));
                ClienteModel clienteModel = new ClienteModel();
                clienteModel.setNome(rs.getString("nomeCliente"));

                pagamentoModel.setDataPagamento(rs.getString("dataPag"));
                pagamentoModel.setPrazoPagamento(rs.getString("prazoPag"));
                pagamentoModel.setNrDaFactura(rs.getInt("nrDaFactura"));
                pagamentoModel.setValorDaFactura(rs.getDouble("valorFactura"));
                pagamentoModel.setMulta(rs.getDouble("multa"));
                pagamentoModel.setValorTotal(rs.getDouble("valorTotal"));
                pagamentoModel.setValorPago(rs.getDouble("valorPago"));
                pagamentoModel.setTrocos(rs.getDouble("trocos"));

                clienteModel.setSaldo(rs.getDouble("saldo"));
                pagamentoModel.setCliente(clienteModel);
                pagamentoModel.setNrRecibo(rs.getInt("nrRecibo"));
                pagamentoModel.setProcessada(rs.getBoolean("processada"));

                list.add(pagamentoModel);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PagamentoController listar apagados" + erro);
        }
        return list;
    }
    //Metodo para actualizar clientes
//    public void ActualizarPagamentos(PagamentoModel pagamentoModel) {
//        String sql = "update pagamentos set nomeCliente=?, dataPag=?, prazoPag=?, nrDaFactura=?, valorFactura= ?, multa=?, valorTotal = ?, valorPago=?, trocos = ?, saldo = ?, processada = ? where idPagamento =?";
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//            pstm.setString(1, pagamentoModel.getNomeDoCliente());
//            pstm.setString(2, pagamentoModel.getDataPagamento());
//            pstm.setString(3, pagamentoModel.getPrazoPagamento());
//            pstm.setInt(4, pagamentoModel.getNrDaFactura());
//            pstm.setDouble(5, pagamentoModel.getValorDaFactura());
//            pstm.setDouble(6, pagamentoModel.getMulta());
//            pstm.setDouble(7, pagamentoModel.getValorTotal());
//            pstm.setDouble(8, pagamentoModel.getValorPago());
//            pstm.setDouble(9, pagamentoModel.getTrocos());
//            pstm.setDouble(10, pagamentoModel.getSaldo());
//            pstm.setBoolean(11, pagamentoModel.getProcessada());
//            pstm.setInt(12, pagamentoModel.getIdPagamento());
//
//            pstm.execute();
//            pstm.close();
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "PagamentoController Actuaizar pagamento" + erro);
//        }
//    }

    public void ActualizarPagamentos(PagamentoModel pagamentoModel) {
        String sql = "update pagamentos set nomeCliente = ?, dataPag = ?, prazoPag = ?, nrDaFactura = ?, valorFactura = ?, multa = ?, valorTotal = ?, valorPago = ?, trocos = ?, saldo = ?, nrRecibo = ?, processada = ? where idPagamento = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = new ConexaoController().conectaBaseDados();
            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, pagamentoModel.getCliente().getNome());
            pstm.setString(2, pagamentoModel.getDataPagamento());
            pstm.setString(3, pagamentoModel.getPrazoPagamento());
            pstm.setInt(4, pagamentoModel.getNrDaFactura());
            pstm.setDouble(5, pagamentoModel.getValorDaFactura());
            pstm.setDouble(6, pagamentoModel.getMulta());
            pstm.setDouble(7, pagamentoModel.getValorTotal());
            pstm.setDouble(8, pagamentoModel.getValorPago());
            pstm.setDouble(9, pagamentoModel.getTrocos());
            pstm.setDouble(10, pagamentoModel.getCliente().getSaldo());
            pstm.setInt(11, pagamentoModel.getNrRecibo());
            pstm.setBoolean(12, pagamentoModel.getProcessada());
            pstm.setInt(13, pagamentoModel.getIdPagamento());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pagamento actualizado com sucesso.");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PagamentoController Atualizar pagamento: " + erro);
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

    public void actualizarSaldo(PagamentoModel pagamentoModel) {
        String sql = "UPDATE clientes SET saldo = ? WHERE nomeCliente = ?";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            pstm.setDouble(1, pagamentoModel.getCliente().getSaldo());
            pstm.setString(2, pagamentoModel.getCliente().getNome());

            pstm.execute();
            pstm.close();
            System.out.println("Saldo de cliente actualizado.");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PagamentoController Actuaizar saldoCliente" + erro);
        }

    }

    //Metodo para actualizar factura se ja foi paga
    public void actualizarEstadoFactura(FacturacaoModel facturacaoModel) {
        String sql = "UPDATE facturacao SET paga = ?, saldoActual = ? WHERE nrDaFactura = ?";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            pstm.setBoolean(1, facturacaoModel.getPaga());
            pstm.setDouble(2, facturacaoModel.getHistoricoHidrometro().getCliente().getSaldo());
            pstm.setInt(3, facturacaoModel.getNrDaFactura());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PagamentoController Actualizar estadoPagamento da Factura" + erro);
        }

    }

}
/*
create table pagamentos ( idPagamento int AUTO_INCREMENT PRIMARY KEY, 
                       nomeCliente varchar(45), 
                       dataPag varchar(45),
                       prazoPag varchar(45),
                       nrDaFactura varchar(45), 
                       valorFactura double,
                       multa double,
                       valorTotal double,
                       valorPago double,
                       trocos double,
                       saldo double,
                       nrRecibo int,
                       processada varchar(5));
 */
