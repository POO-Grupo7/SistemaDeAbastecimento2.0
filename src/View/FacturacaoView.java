/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ClienteController;
import Controller.FacturacaoController;
import Controller.TaxaController;
import Model.ClienteModel;
import Model.FacturacaoModel;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FacturacaoView extends javax.swing.JFrame {

    public FacturacaoView() {
        initComponents();
        listarFacturacao();
        RestaurarDadosComboBoxTaxa();
        // Obtém a data atual
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formato.format(data);
        txtDataFactura.setText("" + dataFormatada);
    }

    int taxaAplicar;
    //Accao para comboxTaxas
    Vector<Integer> idTaxas = new Vector<Integer>();

    private void AccaoComboxTaxa() {
        if (cbxTaxas.getSelectedIndex() == 0) {
            taxaAplicar = 0;
            return;
        }
        try {
            TaxaController taxaController = new TaxaController();
            ResultSet rs = taxaController.PesquisarTaxas(idTaxas.get(cbxTaxas.getSelectedIndex() - 1));

            while (rs.next()) {
                taxaAplicar = rs.getInt(4);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TaxasView pegar valores de Taxas" + erro);
        }
    }

    //Accao para prencher campos
    Vector<Integer> idLeitura = new Vector<Integer>();

    private void AccaoComboxClientes() {
        if (cbxNrLeitura.getSelectedIndex() == 0) {
            txtNomeCliente.setText(null);
            txtMesReferente.setText(null);
            txtConsumoDoMes.setText(null);
            txtSaldoAnterior.setText(null);
            return;
        }
        try {
            FacturacaoController facturacaoController = new FacturacaoController();
            ResultSet rs = facturacaoController.PrencherDados(idLeitura.get(cbxNrLeitura.getSelectedIndex() - 1));

            while (rs.next()) {
                txtNomeCliente.setText(rs.getString(2));
                txtMesReferente.setText(rs.getString(6));
                txtConsumoDoMes.setText(rs.getString(11));
                txtSaldoAnterior.setText(rs.getString(14));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoView prencher dados" + erro);
        }
    }
    //Metodo que pega clientes activos na BD para jcboxClientes


    private void RestaurarDadosComboBoxTaxa() {
        try {
            FacturacaoController facturacoController = new FacturacaoController();
            ResultSet rs = facturacoController.listarTaxas();

            while (rs.next()) {
                idTaxas.addElement(rs.getInt(1));
                cbxTaxas.addItem(rs.getString(4));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FacturacaoView listar nr da leitura na comboBox" + erro);
        }
    }

    //Metodo processar Factura
    final Double consumoMinimo = 4.0;
    double taxaIva = (0.75 * 0.16);

    private void processarFactura() {
        double calcSubtotal = 0, ivaAReduzir, iva, desconto = 0, totalFactura, saldoActual;
        double saldoAnterior = Double.parseDouble(txtSaldoAnterior.getText());
        double consumo = Double.parseDouble(txtConsumoDoMes.getText());
        //taxa fixa de 100,00 para consumo inferior ao minimo estipulado
        if (consumo <= consumoMinimo) {
            calcSubtotal = 100.0;
        } else if (consumo > consumoMinimo) {
            calcSubtotal = consumo * taxaAplicar;
        }
        //Desconto para consumo acima de 15m3 de consumo
        if (consumo > 15) {
            double descontoAReduzir = calcSubtotal * 0.1;
            BigDecimal bd4 = new BigDecimal(descontoAReduzir).setScale(2, RoundingMode.HALF_UP);
            desconto = bd4.doubleValue();
        }
        BigDecimal bd = new BigDecimal(calcSubtotal).setScale(2, RoundingMode.HALF_UP);
        double subtotal = bd.doubleValue();

        ivaAReduzir = subtotal * taxaIva;
        BigDecimal bd2 = new BigDecimal(ivaAReduzir).setScale(2, RoundingMode.HALF_UP);
        iva = bd2.doubleValue();

        totalFactura = subtotal + iva - desconto;
        txtSubTotal.setText("" + subtotal);
        txtIva.setText("" + iva);
        txtDescontos.setText("" + desconto);
        txtTotalFactura.setText("" + totalFactura);
        //Saldo actualizado
        double saldoActualAReduzir = totalFactura + saldoAnterior;
        BigDecimal bd5 = new BigDecimal(saldoActualAReduzir).setScale(2, RoundingMode.HALF_UP);
        saldoActual = bd5.doubleValue();
        txtSaldoActual.setText("" + saldoActual);

        // prazo de pagamento
        LocalDate dataEmissao = LocalDate.now();
        int diasPrazo = 15;
        LocalDate dataVencimento = dataEmissao.plusDays(diasPrazo);
        String dataVencimentoString = dataVencimento.toString();
        txtPrazoDePagamento.setText(dataVencimentoString);

        //Alerta para dividas > 3000Mts
        if (saldoAnterior > 3000) {
            JOptionPane.showMessageDialog(null, "O cliente tem uma divida de " + saldoActual + "Mts. Caso não seja o seu 1 Pagam. Efectuar Corte!");
        }
    }

    //Salvar Leitura
    private void salvarFacturacao() {

        String nrLeitura = cbxNrLeitura.getSelectedItem().toString();
        String nome = txtNomeCliente.getText();
        String dataEmissao = txtDataFactura.getText();
        String mes = txtMesReferente.getText();
        double consumo = Double.parseDouble(txtConsumoDoMes.getText());
        double subtotal = Double.parseDouble(txtSubTotal.getText());
        double iva = Double.parseDouble(txtIva.getText());
        double desconto = Double.parseDouble(txtDescontos.getText());
        double totalFactura = Double.parseDouble(txtTotalFactura.getText());
        double saldoAnterior = Double.parseDouble(txtSaldoAnterior.getText());
        double saldoActual = Double.parseDouble(txtSaldoActual.getText());
        double taxaa = Double.parseDouble(cbxTaxas.getSelectedItem().toString());

        Random aleatorio = new Random();
        //Numero aleatorio para factura
        int nrFacturaPadraoInicial = 202401;
        int nrFactura = nrFacturaPadraoInicial + aleatorio.nextInt(100001);
        txtNrFactura.setText(nrFactura + "");

        String prazoPagamento = txtPrazoDePagamento.getText();
        String disponibilidade = "Sim";
//        txtDisponibilidade.setText(disponibilidade);

        FacturacaoModel facturacaoModel = new FacturacaoModel();
        facturacaoModel.setNrLeitura(nrLeitura);
        facturacaoModel.setNome(nome);
        facturacaoModel.setDataFacturacao(dataEmissao);
        facturacaoModel.setMesDeReferencia(mes);
        facturacaoModel.setConsumoMensal(consumo);
        facturacaoModel.setTaxa(taxaa);
        facturacaoModel.setPrazoDePagamento(prazoPagamento);
        facturacaoModel.setSubTotal(subtotal);
        facturacaoModel.setIva(iva);
        facturacaoModel.setDescontos(desconto);
        facturacaoModel.setTotalFactura(totalFactura);
        facturacaoModel.setDividaAnterior(saldoAnterior);
        facturacaoModel.setDividaActual(saldoActual);
        facturacaoModel.setNrDaFactura(nrFactura);
        facturacaoModel.setDisp(disponibilidade);

        FacturacaoController facturacaoControler = new FacturacaoController();
        facturacaoControler.cadastrarFacturamento(facturacaoModel);

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setSaldo(saldoActual);
        clienteModel.setNome(nome);

        ClienteController clienteController = new ClienteController();
        clienteController.ActualizarCliente(clienteModel);
    }

    //Metodo Listar
    private void listarFacturacao() {
        try {
            FacturacaoController facturacaoController = new FacturacaoController();

            DefaultTableModel model = (DefaultTableModel) tabelaFacturacao.getModel();
            model.setRowCount(0);

            ArrayList<FacturacaoModel> lista = facturacaoController.listarFacturacao();

            for (FacturacaoModel item : lista) {
                model.addRow(new Object[]{
                    item.getIdFacturacao(),
                    item.getDataFacturacao(),
                    item.getNrLeitura(),
                    item.getMesDeReferencia(),
                    item.getNome(),
                    item.getDividaAnterior(),
                    item.getConsumoMensal(),
                    item.getTaxa(),
                    item.getSubTotal(),
                    item.getIva(),
                    item.getDescontos(),
                    item.getTotalFactura(),
                    item.getDividaActual(),
                    item.getPrazoDePagamento(),
                    item.getNrDaFactura(),
                    item.getDisp()
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ListarFacturacao View" + erro);
        }
    }

    //Metodo Limpar Campos
    private void limparCampos() {
        txtIdFactura.setText("");
        cbxNrLeitura.setSelectedIndex(0);
        txtDataFactura.setText("");
        txtMesReferente.setText("");
        txtNomeCliente.setText("");
        txtConsumoDoMes.setText("");
        cbxTaxas.setSelectedIndex(0);
        txtPrazoDePagamento.setText("");
        txtDescontos.setText("");
        txtTotalFactura.setText("");
        txtSaldoAnterior.setText("");
        txtSubTotal.setText("");
        txtIva.setText("");
        txtNrFactura.setText("");
        txtSaldoActual.setText("");

    }

    //Metodo Carregar Campos
    private void CarregarCampos() {
        int setar = tabelaFacturacao.getSelectedRow();

        txtIdFactura.setText(tabelaFacturacao.getModel().getValueAt(setar, 0).toString());
        txtDataFactura.setText(tabelaFacturacao.getModel().getValueAt(setar, 1).toString());
        cbxNrLeitura.setSelectedItem(tabelaFacturacao.getModel().getValueAt(setar, 2).toString());
        txtMesReferente.setText(tabelaFacturacao.getModel().getValueAt(setar, 3).toString());
        txtNomeCliente.setText(tabelaFacturacao.getModel().getValueAt(setar, 4).toString());
        txtSaldoAnterior.setText(tabelaFacturacao.getModel().getValueAt(setar, 5).toString());
        txtConsumoDoMes.setText(tabelaFacturacao.getModel().getValueAt(setar, 6).toString());
        cbxTaxas.setSelectedItem(tabelaFacturacao.getModel().getValueAt(setar, 7).toString());
        txtSubTotal.setText(tabelaFacturacao.getModel().getValueAt(setar, 8).toString());
        txtIva.setText(tabelaFacturacao.getModel().getValueAt(setar, 9).toString());
        txtDescontos.setText(tabelaFacturacao.getModel().getValueAt(setar, 10).toString());
        txtTotalFactura.setText(tabelaFacturacao.getModel().getValueAt(setar, 11).toString());
        txtSaldoActual.setText(tabelaFacturacao.getModel().getValueAt(setar, 12).toString());
        txtPrazoDePagamento.setText(tabelaFacturacao.getModel().getValueAt(setar, 13).toString());
        txtNrFactura.setText(tabelaFacturacao.getModel().getValueAt(setar, 14).toString());

    }

    //Metodo Actualizar Facturacao
    private void actualizarFacturacao() {

        int idFacturacao = Integer.parseInt(txtIdFactura.getText());
        String nrLeitura = cbxNrLeitura.getSelectedItem().toString();
        String nome = txtNomeCliente.getText();
        String dataEmissao = txtDataFactura.getText();
        String mes = txtMesReferente.getText();
        double consumo = Double.parseDouble(txtConsumoDoMes.getText());
        double subtotal = Double.parseDouble(txtSubTotal.getText());
        double iva = Double.parseDouble(txtIva.getText());
        double desconto = Double.parseDouble(txtDescontos.getText());
        double totalFactura = Double.parseDouble(txtTotalFactura.getText());
        double saldoAnterior = Double.parseDouble(txtSaldoAnterior.getText());
        double saldoActual = Double.parseDouble(txtSaldoActual.getText());
        int nrFactura = Integer.parseInt(txtNrFactura.getText());
        double taxaa = Double.parseDouble(cbxTaxas.getSelectedItem().toString());
        String prazoPagamento = txtPrazoDePagamento.getText();
        String disponibilidade = "Sim";

        FacturacaoModel facturacaoModel = new FacturacaoModel();
        facturacaoModel.setIdFacturacao(idFacturacao);
        facturacaoModel.setNrLeitura(nrLeitura);
        facturacaoModel.setNome(nome);
        facturacaoModel.setDataFacturacao(dataEmissao);
        facturacaoModel.setMesDeReferencia(mes);
        facturacaoModel.setConsumoMensal(consumo);
        facturacaoModel.setTaxa(taxaa);
        facturacaoModel.setPrazoDePagamento(prazoPagamento);
        facturacaoModel.setSubTotal(subtotal);
        facturacaoModel.setIva(iva);
        facturacaoModel.setDescontos(desconto);
        facturacaoModel.setTotalFactura(totalFactura);
        facturacaoModel.setDividaAnterior(saldoAnterior);
        facturacaoModel.setDividaActual(saldoActual);
        facturacaoModel.setNrDaFactura(nrFactura);
        facturacaoModel.setDisp(disponibilidade);

        FacturacaoController facturacaoController = new FacturacaoController();
        facturacaoController.ActualizarFacturacao(facturacaoModel);

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setSaldo(saldoActual);
        clienteModel.setNome(nome);

        ClienteController clienteController = new ClienteController();
        clienteController.ActualizarCliente(clienteModel);

    }

    //Metodo Apagar Facturacao
    private void ApagarFacturacao() {
        int idFacturacao = Integer.parseInt(txtIdFactura.getText());
        String nrLeitura = cbxNrLeitura.getSelectedItem().toString();
        String nome = txtNomeCliente.getText();
        String dataEmissao = txtDataFactura.getText();
        String mes = txtMesReferente.getText();
        double consumo = Double.parseDouble(txtConsumoDoMes.getText());
        double subtotal = Double.parseDouble(txtSubTotal.getText());
        double iva = Double.parseDouble(txtIva.getText());
        double desconto = Double.parseDouble(txtDescontos.getText());
        double totalFactura = Double.parseDouble(txtTotalFactura.getText());
        double saldoAnterior = Double.parseDouble(txtSaldoAnterior.getText());
        double saldoActual = Double.parseDouble(txtSaldoActual.getText());
        double taxaa = Double.parseDouble(cbxTaxas.getSelectedItem().toString());
        int nrFactura = Integer.parseInt(txtNrFactura.getText());
        String prazoPagamento = txtPrazoDePagamento.getText();
        String disponibilidade = "Não";

        FacturacaoModel facturacaoModel = new FacturacaoModel();
        facturacaoModel.setIdFacturacao(idFacturacao);
        facturacaoModel.setNrLeitura(nrLeitura);
        facturacaoModel.setNome(nome);
        facturacaoModel.setDataFacturacao(dataEmissao);
        facturacaoModel.setMesDeReferencia(mes);
        facturacaoModel.setConsumoMensal(consumo);
        facturacaoModel.setTaxa(taxaa);
        facturacaoModel.setPrazoDePagamento(prazoPagamento);
        facturacaoModel.setSubTotal(subtotal);
        facturacaoModel.setIva(iva);
        facturacaoModel.setDescontos(desconto);
        facturacaoModel.setTotalFactura(totalFactura);
        facturacaoModel.setDividaAnterior(saldoAnterior);
        facturacaoModel.setDividaActual(saldoActual);
        facturacaoModel.setNrDaFactura(nrFactura);
        facturacaoModel.setDisp(disponibilidade);

        FacturacaoController facturacaoController = new FacturacaoController();
        facturacaoController.ActualizarFacturacao(facturacaoModel);

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setSaldo(saldoActual);
        clienteModel.setNome(nome);

        ClienteController clienteController = new ClienteController();
        clienteController.ActualizarCliente(clienteModel);
        JOptionPane.showMessageDialog(null, "A Factura apagada com sucesso");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        painelPrincipal = new javax.swing.JPanel();
        painelConteudo = new javax.swing.JPanel();
        painelConteudoEsquerdo = new javax.swing.JPanel();
        lblIconLogo = new javax.swing.JLabel();
        painelVoltarMenu = new javax.swing.JPanel();
        btnVoltarMenu = new javax.swing.JButton();
        lblCabecalho = new javax.swing.JLabel();
        painelContCentral = new javax.swing.JPanel();
        painelSuperiorDados = new javax.swing.JPanel();
        painelEsqDados = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbxNrLeitura = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        txtMesReferente = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtSaldoAnterior = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtConsumoDoMes = new javax.swing.JTextField();
        btnProcessar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDescontos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTotalFactura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSaldoActual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrazoDePagamento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNrFactura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDataFactura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxTaxas = new javax.swing.JComboBox<>();
        painelDirDados = new javax.swing.JPanel();
        painelInferiorBotoesTabela = new javax.swing.JPanel();
        tabela = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFacturacao = new javax.swing.JTable();
        botoes = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FACTURAÇÃO");
        setMinimumSize(new java.awt.Dimension(1200, 680));
        setPreferredSize(new java.awt.Dimension(1260, 700));

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(1260, 720));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setLayout(new java.awt.BorderLayout(10, 10));

        painelConteudoEsquerdo.setBackground(new java.awt.Color(52, 102, 138));
        painelConteudoEsquerdo.setLayout(new java.awt.BorderLayout());

        lblIconLogo.setBackground(new java.awt.Color(52, 102, 138));
        lblIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/contabilidade 258px.png"))); // NOI18N
        painelConteudoEsquerdo.add(lblIconLogo, java.awt.BorderLayout.CENTER);

        painelVoltarMenu.setBackground(new java.awt.Color(52, 102, 138));

        btnVoltarMenu.setBackground(new java.awt.Color(52, 102, 138));
        btnVoltarMenu.setForeground(new java.awt.Color(52, 102, 138));
        btnVoltarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8-menu-48.png"))); // NOI18N
        btnVoltarMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        btnVoltarMenu.setContentAreaFilled(false);
        btnVoltarMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVoltarMenu.setDisabledIcon(null);
        btnVoltarMenu.setDisabledSelectedIcon(null);
        btnVoltarMenu.setOpaque(true);
        btnVoltarMenu.setSelected(true);
        btnVoltarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarMenuMouseExited(evt);
            }
        });
        btnVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarMenuActionPerformed(evt);
            }
        });
        painelVoltarMenu.add(btnVoltarMenu);
        btnVoltarMenu.getAccessibleContext().setAccessibleName("btnVoltarMenu");

        lblCabecalho.setBackground(new java.awt.Color(52, 102, 138));
        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        lblCabecalho.setText("Voltar");
        painelVoltarMenu.add(lblCabecalho);

        painelConteudoEsquerdo.add(painelVoltarMenu, java.awt.BorderLayout.NORTH);

        painelConteudo.add(painelConteudoEsquerdo, java.awt.BorderLayout.WEST);

        painelContCentral.setBackground(new java.awt.Color(255, 255, 255));
        painelContCentral.setLayout(new java.awt.BorderLayout());

        painelSuperiorDados.setBackground(new java.awt.Color(255, 255, 255));
        painelSuperiorDados.setPreferredSize(new java.awt.Dimension(994, 480));
        painelSuperiorDados.setLayout(new java.awt.GridLayout(1, 2));

        painelEsqDados.setBackground(new java.awt.Color(255, 255, 255));
        painelEsqDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 43, 64)));
        painelEsqDados.setPreferredSize(new java.awt.Dimension(497, 415));

        jLabel15.setText("Id:");

        txtIdFactura.setEditable(false);

        jLabel17.setText("Numero da Leitura:");

        cbxNrLeitura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel20.setText("Mes Referente:");

        txtMesReferente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesReferenteActionPerformed(evt);
            }
        });

        jLabel23.setText("Nome do Cliente:");

        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });

        jLabel25.setText("Saldo Anterior:");

        txtSaldoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoAnteriorActionPerformed(evt);
            }
        });

        jLabel24.setText("Consumo do Mes:");

        txtConsumoDoMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsumoDoMesActionPerformed(evt);
            }
        });

        btnProcessar.setBackground(new java.awt.Color(255, 153, 0));
        btnProcessar.setText("Processar");
        btnProcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessarActionPerformed(evt);
            }
        });

        jLabel2.setText("SubTotal:");

        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });

        jLabel3.setText("Iva:");

        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });

        jLabel1.setText("Descontos:");

        txtDescontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescontosActionPerformed(evt);
            }
        });

        jLabel5.setText("Total da Factura:");

        txtTotalFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalFacturaActionPerformed(evt);
            }
        });

        jLabel6.setText("Saldo Actual:");

        txtSaldoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActualActionPerformed(evt);
            }
        });

        jLabel4.setText("Prazo de Pagamentos:");

        txtPrazoDePagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrazoDePagamentoActionPerformed(evt);
            }
        });

        jLabel7.setText("Numero da Factura:");

        txtNrFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNrFacturaActionPerformed(evt);
            }
        });

        jLabel8.setText("Data da Factura:");

        txtDataFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataFacturaActionPerformed(evt);
            }
        });

        jLabel9.setText("Taxa:");

        cbxTaxas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxTaxas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTaxasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelEsqDadosLayout = new javax.swing.GroupLayout(painelEsqDados);
        painelEsqDados.setLayout(painelEsqDadosLayout);
        painelEsqDadosLayout.setHorizontalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(171, 171, 171)
                        .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txtIva, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txtDescontos, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txtTotalFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txtSaldoActual, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txtPrazoDePagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txtNrFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))))
                        .addGroup(painelEsqDadosLayout.createSequentialGroup()
                            .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel20)
                                .addComponent(jLabel23)
                                .addComponent(jLabel25)
                                .addComponent(jLabel24)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGap(75, 75, 75)
                            .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDataFactura)
                                .addComponent(txtConsumoDoMes)
                                .addComponent(txtSaldoAnterior)
                                .addComponent(txtMesReferente)
                                .addComponent(cbxNrLeitura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNomeCliente)
                                .addComponent(cbxTaxas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        painelEsqDadosLayout.setVerticalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDataFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(cbxNrLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtMesReferente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(txtSaldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(txtConsumoDoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbxTaxas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProcessar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotalFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSaldoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrazoDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNrFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        painelSuperiorDados.add(painelEsqDados);

        painelDirDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDirDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 43, 64)));

        javax.swing.GroupLayout painelDirDadosLayout = new javax.swing.GroupLayout(painelDirDados);
        painelDirDados.setLayout(painelDirDadosLayout);
        painelDirDadosLayout.setHorizontalGroup(
            painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        painelDirDadosLayout.setVerticalGroup(
            painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        painelSuperiorDados.add(painelDirDados);

        painelContCentral.add(painelSuperiorDados, java.awt.BorderLayout.PAGE_START);

        painelInferiorBotoesTabela.setBackground(new java.awt.Color(255, 255, 255));
        painelInferiorBotoesTabela.setLayout(new java.awt.BorderLayout());

        tabela.setBackground(new java.awt.Color(255, 255, 255));
        tabela.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(0, 102, 102));

        tabelaFacturacao.setAutoCreateRowSorter(true);
        tabelaFacturacao.setForeground(new java.awt.Color(51, 51, 51));
        tabelaFacturacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data da Factura", "Numero da Factura", "Mes Referente", "Nome do Cliente", "Saldo Anterior", "Consumo do mes", "Taxa", "Subtotal", "Iva", "Descontos", "Total da Factura", "Saldo Actual", "Prazo de Pagamentos", "Numero da Factura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFacturacao.setShowGrid(true);
        jScrollPane2.setViewportView(tabelaFacturacao);

        tabela.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        botoes.setBackground(new java.awt.Color(255, 255, 255));
        botoes.setPreferredSize(new java.awt.Dimension(606, 60));
        botoes.setLayout(new java.awt.GridBagLayout());

        jButton6.setBackground(new java.awt.Color(52, 102, 138));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Facturar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton6, gridBagConstraints);

        jButton7.setBackground(new java.awt.Color(52, 102, 138));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Actualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton7, gridBagConstraints);

        jButton8.setBackground(new java.awt.Color(52, 102, 138));
        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Carregar Campos");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton8, gridBagConstraints);

        jButton9.setBackground(new java.awt.Color(52, 102, 138));
        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Limpar Campos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton9, gridBagConstraints);

        jButton10.setBackground(new java.awt.Color(52, 102, 138));
        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Apagar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton10, gridBagConstraints);

        tabela.add(botoes, java.awt.BorderLayout.PAGE_START);

        painelInferiorBotoesTabela.add(tabela, java.awt.BorderLayout.CENTER);

        painelContCentral.add(painelInferiorBotoesTabela, java.awt.BorderLayout.CENTER);

        painelConteudo.add(painelContCentral, java.awt.BorderLayout.CENTER);

        painelPrincipal.add(painelConteudo, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        jMenuBar1.setAlignmentY(0.5F);
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenuMouseEntered
        btnVoltarMenu.setBackground(new Color(45, 45, 45));
    }//GEN-LAST:event_btnVoltarMenuMouseEntered

    private void btnVoltarMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenuMouseExited
        btnVoltarMenu.setBackground(new Color(52, 102, 138));
    }//GEN-LAST:event_btnVoltarMenuMouseExited

    private void btnVoltarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenuMouseClicked
        btnVoltarMenu.setBackground(new Color(52, 102, 138));
    }//GEN-LAST:event_btnVoltarMenuMouseClicked

    private void btnVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMenuActionPerformed
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarMenuActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        salvarFacturacao();
        listarFacturacao();
        limparCampos();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        actualizarFacturacao();
        listarFacturacao();
        limparCampos();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ApagarFacturacao();
        listarFacturacao();
        limparCampos();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtNrFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNrFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNrFacturaActionPerformed

    private void txtPrazoDePagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrazoDePagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrazoDePagamentoActionPerformed

    private void txtSaldoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActualActionPerformed

    private void txtTotalFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFacturaActionPerformed

    private void txtDescontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescontosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescontosActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtConsumoDoMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumoDoMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsumoDoMesActionPerformed

    private void txtSaldoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoAnteriorActionPerformed

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void txtMesReferenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesReferenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesReferenteActionPerformed

    private void txtDataFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataFacturaActionPerformed

    private void btnProcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessarActionPerformed
        processarFactura();
    }//GEN-LAST:event_btnProcessarActionPerformed

    private void cbxTaxasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTaxasActionPerformed
        AccaoComboxTaxa();
    }//GEN-LAST:event_cbxTaxasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            FlatCyanLightIJTheme.setup();
//            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturacaoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnProcessar;
    private javax.swing.JButton btnVoltarMenu;
    private javax.swing.JComboBox<String> cbxNrLeitura;
    private javax.swing.JComboBox<String> cbxTaxas;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblIconLogo;
    private javax.swing.JPanel painelContCentral;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelConteudoEsquerdo;
    private javax.swing.JPanel painelDirDados;
    private javax.swing.JPanel painelEsqDados;
    private javax.swing.JPanel painelInferiorBotoesTabela;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelSuperiorDados;
    private javax.swing.JPanel painelVoltarMenu;
    private javax.swing.JPanel tabela;
    private javax.swing.JTable tabelaFacturacao;
    private javax.swing.JTextField txtConsumoDoMes;
    private javax.swing.JTextField txtDataFactura;
    private javax.swing.JTextField txtDescontos;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtMesReferente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNrFactura;
    private javax.swing.JTextField txtPrazoDePagamento;
    private javax.swing.JTextField txtSaldoActual;
    private javax.swing.JTextField txtSaldoAnterior;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalFactura;
    // End of variables declaration//GEN-END:variables
}
