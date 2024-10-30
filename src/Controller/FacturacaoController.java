/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FacturacaoModel;
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
public class FacturacaoController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FacturacaoModel> lista = new ArrayList<>();

    //Listar Leituras na ComboBox
    public ResultSet listarLeituras() {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from leituras WHERE status = '1' ORDER BY nrLeitura;";

        try {
            pstm = conexao.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoController listar leituras" + erro.getMessage());
            return null;
        }
    }

    //Metodo que pega valores da BD e preenche nos campos atraves da leitura
    public ResultSet prencherDadosLeitura(int idLeitura) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from leituras where idLeitura = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idLeitura);

            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoController pegar dados a  na leitura" + erro);
        }
        return null;
    }

    //Metodo que verifia a existencia de um factura com mesmos dados
    public boolean facturaExiste(String nrLeitura, int nrDaFactura) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT COUNT(*) FROM facturacao WHERE nrLeitura = ? OR nrDaFactura = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, nrLeitura);
            pstm.setInt(2, nrDaFactura);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoController facturaExiste" + erro);
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
                JOptionPane.showMessageDialog(null, "FacturacaoController facturaExiste (finally)" + erro);
            }
        }
        return false;
    }

    //METODO PARA CADASTRAR
    public void cadastrarFacturamento(FacturacaoModel facturacaoModel) {

        String sql = "insert into facturacao (nrLeitura, nomeCliente, dataEmissao, mesReferente, consumoDoMes,taxa, prazoPagamento, subTotal , iva, descontos, TotalFactura, saldoAnterior, saldoActual, nrDaFactura, disp) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, facturacaoModel.getNrLeitura());
            pstm.setString(2, facturacaoModel.getNome());
            pstm.setString(3, facturacaoModel.getDataFacturacao());
            pstm.setString(4, facturacaoModel.getMesDeReferencia());
            pstm.setDouble(5, facturacaoModel.getConsumoMensal());
            pstm.setDouble(6, facturacaoModel.getTaxa());
            pstm.setString(7, facturacaoModel.getPrazoDePagamento());
            pstm.setDouble(8, facturacaoModel.getSubTotal());
            pstm.setDouble(9, facturacaoModel.getIva());
            pstm.setDouble(10, facturacaoModel.getDescontos());
            pstm.setDouble(11, facturacaoModel.getTotalFactura());
            pstm.setDouble(12, facturacaoModel.getDividaAnterior());
            pstm.setDouble(13, facturacaoModel.getDividaActual());
            pstm.setInt(14, facturacaoModel.getNrDaFactura());
            pstm.setString(15, facturacaoModel.getDisp());

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Factura salva com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoController Cadastrar" + erro);
        }
    }
    
    //METODO PARA LISTAR
    public ArrayList<FacturacaoModel> listarFacturacao() {
        ArrayList<FacturacaoModel> list = new ArrayList<>();
        String sql = "select * from facturacao where disp = 'Sim'";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FacturacaoModel facturacaoModel = new FacturacaoModel();
                facturacaoModel.setIdFacturacao(rs.getInt("idFacturacao"));
                facturacaoModel.setNrLeitura(rs.getString("nrLeitura"));
                facturacaoModel.setNome(rs.getString("nomeCliente"));
                facturacaoModel.setDataFacturacao(rs.getString("dataEmissao"));
                facturacaoModel.setMesDeReferencia(rs.getString("mesReferente"));
                facturacaoModel.setConsumoMensal(rs.getDouble("consumoDoMes"));
                facturacaoModel.setTaxa(rs.getDouble("taxa"));
                facturacaoModel.setPrazoDePagamento(rs.getString("prazoPagamento"));
                facturacaoModel.setSubTotal(rs.getDouble("subTotal"));
                facturacaoModel.setIva(rs.getDouble("iva"));
                facturacaoModel.setDescontos(rs.getDouble("descontos"));
                facturacaoModel.setTotalFactura(rs.getDouble("TotalFactura"));
                facturacaoModel.setDividaAnterior(rs.getDouble("saldoAnterior"));
                facturacaoModel.setDividaActual(rs.getDouble("saldoActual"));
                facturacaoModel.setNrDaFactura(rs.getInt("nrDaFactura"));
                facturacaoModel.setDisp(rs.getString("disp"));

                list.add(facturacaoModel);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoController listar" + erro);
        }
        return list;
    }
//Listar Taxas na ComboBox
    public ResultSet listarTaxas() {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "select * from taxas where processada = 'Sim'";

        try {
            pstm = conexao.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoController pesquisar Taxas" + erro.getMessage());
            return null;
        }
    }
    
    //METODO PARA LISTAR APAGADAS
    public ArrayList<FacturacaoModel> listarFacturacaoApagadas() {
        ArrayList<FacturacaoModel> list = new ArrayList<>();
        String sql = "select * from facturacao where disp = 'Não'";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FacturacaoModel facturacaoModel = new FacturacaoModel();
                facturacaoModel.setIdFacturacao(rs.getInt("idFacturacao"));
                facturacaoModel.setNrLeitura(rs.getString("nrLeitura"));
                facturacaoModel.setNome(rs.getString("nomeCliente"));
                facturacaoModel.setDataFacturacao(rs.getString("dataEmissao"));
                facturacaoModel.setMesDeReferencia(rs.getString("mesReferente"));
                facturacaoModel.setConsumoMensal(rs.getDouble("consumoDoMes"));
                facturacaoModel.setTaxa(rs.getDouble("taxa"));
                facturacaoModel.setPrazoDePagamento(rs.getString("prazoPagamento"));
                facturacaoModel.setSubTotal(rs.getDouble("subTotal"));
                facturacaoModel.setIva(rs.getDouble("iva"));
                facturacaoModel.setDescontos(rs.getDouble("descontos"));
                facturacaoModel.setTotalFactura(rs.getDouble("TotalFactura"));
                facturacaoModel.setDividaAnterior(rs.getDouble("saldoAnterior"));
                facturacaoModel.setDividaActual(rs.getDouble("saldoActual"));
                facturacaoModel.setNrDaFactura(rs.getInt("nrDaFactura"));
                facturacaoModel.setDisp(rs.getString("disp"));

                list.add(facturacaoModel);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoController listar apagadas" + erro);
        }
        return list;
    }

    //Metodo para actualizar clientes
    public void ActualizarFacturacao(FacturacaoModel facturacaoModel) {

        String sql = "update facturacao set nrLeitura = ?, nomeCliente = ?, dataEmissao  = ?, mesReferente  = ?, consumoDoMes  = ?, taxa  = ?,prazoPagamento = ?, subTotal  = ?, iva = ?, descontos = ?, TotalFactura =?, saldoAnterior  = ?, saldoActual = ?, nrDaFactura = ?, disp = ? where idFacturacao =?";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, facturacaoModel.getNrLeitura());
            pstm.setString(2, facturacaoModel.getNome());
            pstm.setString(3, facturacaoModel.getDataFacturacao());
            pstm.setString(4, facturacaoModel.getMesDeReferencia());
            pstm.setDouble(5, facturacaoModel.getConsumoMensal());
            pstm.setDouble(6, facturacaoModel.getTaxa());
            pstm.setString(7, facturacaoModel.getPrazoDePagamento());
            pstm.setDouble(8, facturacaoModel.getSubTotal());
            pstm.setDouble(9, facturacaoModel.getIva());
            pstm.setDouble(10, facturacaoModel.getDescontos());
            pstm.setDouble(11, facturacaoModel.getTotalFactura());
            pstm.setDouble(12, facturacaoModel.getDividaAnterior());
            pstm.setDouble(13, facturacaoModel.getDividaActual());
            pstm.setInt(14, facturacaoModel.getNrDaFactura());
            pstm.setString(15, facturacaoModel.getDisp());
            pstm.setInt(16, facturacaoModel.getIdFacturacao());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoController Actuaizar facturacao" + erro);
        }
    }
}


/*
create table facturacao ( idFacturacao int AUTO_INCREMENT PRIMARY KEY, 
                       nrLeitura varchar(45), 
                       nomeCliente varchar(45), 
                       dataEmissao varchar(45),
                       mesReferente varchar(45), 
                       consumoDoMes double, 
                       prazoPagamento varchar(45),
                       subTotal double,
                       iva double,
                       descontos double,
                       TotalFactura double,
                       saldoAnterior varchar(45),
                       saldoActual varchar(45), 
                       nrDaFactura varchar(45),
                       disp varchar(45));
 */
