/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ClienteController;
import Controller.FacturacaoController;
import Controller.PagamentoController;
import Model.ClienteModel;
import Model.PagamentoModel;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PagamentoView extends javax.swing.JFrame {

    public PagamentoView() {
        initComponents();
        RestaurarDadosComboBoxFactura();
        listarPagamentos();
        
        // Obtém a data atual
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formato.format(data);
        txtDataPagamento.setText("" + dataFormatada);
    }

    //Metodo Prencher Campos obrigatorios
    private boolean camposObrigatoriosPreenchidos() {
        boolean nomePreenchido = !txtNomeCliente.getText().isEmpty();
        boolean valorAPagarPreenchido = !txtNomeCliente.getText().isEmpty();

        return nomePreenchido && valorAPagarPreenchido;
    }

    //Accao para prencher campos
    Vector<Integer> idFactura = new Vector<Integer>();

//    private void AccaoComboxClientes() {
//        if (cbxFacturas.getSelectedIndex() == 0) {
//            txtNomeCliente.setText(null);
//            txtValor.setText(null);
//            txtPrazoPagamento.setText(null);
//            return;
//        }
//        try {
//            FacturacaoController facturacaoController = new FacturacaoController();
//            ResultSet rs = facturacaoController.PrencherDados(idFactura.get(cbxFacturas.getSelectedIndex() - 1));
//
//            while (rs.next()) {
//                txtNomeCliente.setText(rs.getString(2));
//                txtValor.setText(rs.getString(4));
//                txtPrazoPagamento.setText(rs.getString(5));
//                txtDataPagamento.setText(rs.getString(6));
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "FacturacaoView prencher dados" + erro);
//        }
//    }
    // Ação ao selecionar um item no ComboBox
    private void AccaoComboxFactura() {
        if (cbxFacturas.getSelectedIndex() == 0) {
            txtNomeCliente.setText(null);
            txtValorFactura.setText(null);
            txtPrazoPagamento.setText(null);
            txtDataPagamento.setText(null);
            return;
        }

        try {
            PagamentoController pagamentoController = new PagamentoController();
            int selectedId = idFactura.get(cbxFacturas.getSelectedIndex() - 1);
            ResultSet rs = pagamentoController.PrencherDadosFactura(selectedId);

            if (rs.next()) {
                txtNomeCliente.setText(rs.getString(3));
                txtValorFactura.setText(rs.getString(14));
                txtPrazoPagamento.setText(rs.getString(8));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher dados: " + erro);
        }
    }

    //Metodo que pega clientes activos na BD para jcboxClientes
//    private void RestaurarDadosComboBoxTaxa() {
//        try {
//            FacturacaoController facturacoController = new FacturacaoController();
//            ResultSet rs = facturacoController.listarTaxas();
//
//            while (rs.next()) {
//                idFactura.addElement(rs.getInt(1));
//                cbxFacturas.addItem(rs.getString(4));
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "FacturacaoView listar nr da leitura na comboBox" + erro);
//        }
//    }
    // Método para restaurar dados no ComboBox
    private void RestaurarDadosComboBoxFactura() {
//        idFactura.clear();  // Limpa o vetor para evitar duplicação de IDs
//        cbxFacturas.removeAllItems();  // Limpa o ComboBox antes de preencher

        try {
            PagamentoController pagamentoController = new PagamentoController();
            ResultSet rs = pagamentoController.listarFacturas();

            while (rs.next()) {
                idFactura.addElement(rs.getInt(1));
                cbxFacturas.addItem(rs.getString(15));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados no ComboBox: " + erro);
        }
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
        txtIdPagamentos = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbxFacturas = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtValorFactura = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtPrazoPagamento = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtDataPagamento = new javax.swing.JTextField();
        btnCalcularValorPAgar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMultas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalAPagar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtValorEntregue = new javax.swing.JTextField();
        btnCalcularTrocos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTrocos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSaldoActual = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNrRecibos = new javax.swing.JTextField();
        painelDirDados = new javax.swing.JPanel();
        painelInferiorBotoesTabela = new javax.swing.JPanel();
        tabela = new javax.swing.JPanel();
        botoes = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPagamentos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PAGAMENTOS");
        setMinimumSize(new java.awt.Dimension(1200, 680));

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(1260, 720));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setLayout(new java.awt.BorderLayout(10, 10));

        painelConteudoEsquerdo.setBackground(new java.awt.Color(52, 102, 138));
        painelConteudoEsquerdo.setLayout(new java.awt.BorderLayout());

        lblIconLogo.setBackground(new java.awt.Color(52, 102, 138));
        lblIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/folha-de-pagamentoMedium.png"))); // NOI18N
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
        painelEsqDados.setPreferredSize(new java.awt.Dimension(497, 400));

        jLabel15.setText("Id:");

        txtIdPagamentos.setEditable(false);

        jLabel16.setText("Factura:");

        cbxFacturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFacturasActionPerformed(evt);
            }
        });

        jLabel17.setText("Nome do Cliente:");

        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });

        jLabel20.setText("Valor:");

        txtValorFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorFacturaActionPerformed(evt);
            }
        });

        jLabel23.setText("Prazo de pagamento:");

        txtPrazoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrazoPagamentoActionPerformed(evt);
            }
        });

        jLabel25.setText("Data de pagamento:");

        txtDataPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataPagamentoActionPerformed(evt);
            }
        });

        btnCalcularValorPAgar.setBackground(new java.awt.Color(255, 153, 0));
        btnCalcularValorPAgar.setText("Processar");
        btnCalcularValorPAgar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularValorPAgarActionPerformed(evt);
            }
        });

        jLabel2.setText("Multa:");

        txtMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMultasActionPerformed(evt);
            }
        });

        jLabel3.setText("Total:");

        txtTotalAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalAPagarActionPerformed(evt);
            }
        });

        jLabel1.setText("Insira o valor a pagar:");

        txtValorEntregue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorEntregueActionPerformed(evt);
            }
        });

        btnCalcularTrocos.setBackground(new java.awt.Color(255, 153, 0));
        btnCalcularTrocos.setText("Calcular Trocos");
        btnCalcularTrocos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTrocosActionPerformed(evt);
            }
        });

        jLabel4.setText("Trocos:");

        txtTrocos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrocosActionPerformed(evt);
            }
        });

        jLabel7.setText("Saldo Actual:");

        txtSaldoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActualActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero de Recibo:");

        txtNrRecibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNrRecibosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelEsqDadosLayout = new javax.swing.GroupLayout(painelEsqDados);
        painelEsqDados.setLayout(painelEsqDadosLayout);
        painelEsqDadosLayout.setHorizontalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))
                        .addGap(72, 72, 72)
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrazoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcularValorPAgar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(80, 80, 80)
                                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTrocos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSaldoActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNrRecibos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(txtMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEsqDadosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtValorEntregue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCalcularTrocos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        painelEsqDadosLayout.setVerticalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(cbxFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtValorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txtPrazoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnCalcularValorPAgar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtValorEntregue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcularTrocos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTrocos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNrRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
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

        botoes.setBackground(new java.awt.Color(255, 255, 255));
        botoes.setPreferredSize(new java.awt.Dimension(606, 60));
        botoes.setLayout(new java.awt.GridBagLayout());

        jButton6.setBackground(new java.awt.Color(52, 102, 138));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Efectivar Pagamento");
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

        tabelaPagamentos.setAutoCreateRowSorter(true);
        tabelaPagamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelaPagamentos.setForeground(new java.awt.Color(51, 51, 51));
        tabelaPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Data de pagamento", "Prazo de Pagamento", "Nr da Factura", "Valor da Factura", "Multa", "Valor Total", "Valor pago", "Trocos", "Saldo", "Nr de Recibo", "Processada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaPagamentos);

        tabela.add(jScrollPane2, java.awt.BorderLayout.CENTER);

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
        

        if (camposObrigatoriosPreenchidos()) {
          
        salvarPagamento();
        listarPagamentos();
        limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos campos Obrigatorios!");
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        actualizarPagamento();
        listarPagamentos();
        limparCampos();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        apagarPagamento();
        listarPagamentos();
        limparCampos();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void txtValorFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorFacturaActionPerformed

    private void txtPrazoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrazoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrazoPagamentoActionPerformed

    private void txtDataPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataPagamentoActionPerformed

    private void btnCalcularValorPAgarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularValorPAgarActionPerformed
        calcularMultaETotal();
    }//GEN-LAST:event_btnCalcularValorPAgarActionPerformed

    private void txtMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMultasActionPerformed

    private void txtTotalAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalAPagarActionPerformed

    private void txtValorEntregueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorEntregueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorEntregueActionPerformed

    private void btnCalcularTrocosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTrocosActionPerformed
        verificarTrocos();
    }//GEN-LAST:event_btnCalcularTrocosActionPerformed

    private void txtTrocosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrocosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrocosActionPerformed

    private void txtSaldoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActualActionPerformed

    private void txtNrRecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNrRecibosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNrRecibosActionPerformed

    private void cbxFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFacturasActionPerformed
        AccaoComboxFactura();
    }//GEN-LAST:event_cbxFacturasActionPerformed

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
                new PagamentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnCalcularTrocos;
    private javax.swing.JButton btnCalcularValorPAgar;
    private javax.swing.JButton btnVoltarMenu;
    private javax.swing.JComboBox<String> cbxFacturas;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTable tabelaPagamentos;
    private javax.swing.JTextField txtDataPagamento;
    private javax.swing.JTextField txtIdPagamentos;
    private javax.swing.JTextField txtMultas;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNrRecibos;
    private javax.swing.JTextField txtPrazoPagamento;
    private javax.swing.JTextField txtSaldoActual;
    private javax.swing.JTextField txtTotalAPagar;
    private javax.swing.JTextField txtTrocos;
    private javax.swing.JTextField txtValorEntregue;
    private javax.swing.JTextField txtValorFactura;
    // End of variables declaration//GEN-END:variables

    private void calcularMultaETotal() {
        //pegando data na textField
        String dataStringEmissaoFactura = txtPrazoPagamento.getText();

        // Extrair ano, mês e dia
        int ano = Integer.parseInt(dataStringEmissaoFactura.substring(0, 4));
        int mes = Integer.parseInt(dataStringEmissaoFactura.substring(5, 7));
        int dia = Integer.parseInt(dataStringEmissaoFactura.substring(8, 10));

        // Criar uma instância do LocalDate com esses valores
        LocalDate data = LocalDate.of(ano, mes, dia);

        // Sua data
        LocalDate suaData = LocalDate.now(); // ou qualquer outra data que você tenha

        //Número de dias desde a data de referência
        long dias = ChronoUnit.DAYS.between(data, suaData);

        // Convertendo para int
        int diasInt = (int) dias;
        System.out.println(diasInt);

        //Condicao para multa
        double valorAntesMultaAReduzir = Double.parseDouble(txtValorFactura.getText());
        BigDecimal bd = new BigDecimal(valorAntesMultaAReduzir).setScale(2, RoundingMode.HALF_UP);
        double valorAntesMulta = bd.doubleValue();

        double valorMulta = 0;
        double valorMultaAreduzir = 0;
        double valorDividaDepoisMultaAReduzir;
        if (dias > 0) {
            System.out.println("Tem Multa");
            valorMultaAreduzir = valorAntesMulta * 0.20;
            BigDecimal bd2 = new BigDecimal(valorMultaAreduzir).setScale(2, RoundingMode.HALF_UP);
            valorMulta = bd2.doubleValue();
            JOptionPane.showMessageDialog(null, "Tem Multa de " + valorMulta);
            txtMultas.setText("" + valorMulta);
            txtMultas.setForeground(Color.red);
            valorDividaDepoisMultaAReduzir = valorAntesMulta + valorMulta;
        } else {
            System.out.println("Sem multa");
            txtMultas.setText("" + valorMulta);
            txtMultas.setForeground(Color.black);
            valorDividaDepoisMultaAReduzir = valorAntesMulta + valorMulta;
        }
        BigDecimal bd3 = new BigDecimal(valorDividaDepoisMultaAReduzir).setScale(2, RoundingMode.HALF_UP);
        double valorDividaDepoisMulta = bd3.doubleValue();
        txtTotalAPagar.setText("" + valorDividaDepoisMulta);
    }
    

    //Salvar Leitura
    private void salvarPagamento() {
        try {
            String nome = txtNomeCliente.getText();
            String datapagamento = txtDataPagamento.getText();
            String prazoPagamento = txtPrazoPagamento.getText();
            String nrFact = cbxFacturas.getSelectedItem().toString();
            int nrFactura = Integer.parseInt(nrFact);
            double valorfactura = Double.parseDouble(txtValorFactura.getText());
            double multa = Double.parseDouble(txtMultas.getText());
            double valorTotal = Double.parseDouble(txtSaldoActual.getText());
            double valorPago = Double.parseDouble(txtValorEntregue.getText());
            double trocos = Double.parseDouble(txtTrocos.getText());
            double saldo = Double.parseDouble(txtTotalAPagar.getText());

            Random aleatorio = new Random();
            int nrReciboPadraoInicial = 20240001;
            int nrRecibo = nrReciboPadraoInicial + aleatorio.nextInt(10000001);
            txtNrRecibos.setText(String.valueOf(nrRecibo));
            boolean disp = true;

            PagamentoModel pagamentoModel = new PagamentoModel();
            pagamentoModel.setNomeDoCliente(nome);
            pagamentoModel.setDataPagamento(datapagamento);
            pagamentoModel.setPrazoPagamento(prazoPagamento);
            pagamentoModel.setNrDaFactura(nrFactura);
            pagamentoModel.setValorDaFactura(valorfactura);
            pagamentoModel.setMulta(multa);
            pagamentoModel.setValorTotal(valorTotal);
            pagamentoModel.setValorPago(valorPago);
            pagamentoModel.setTrocos(trocos);
            pagamentoModel.setSaldo(saldo);
            pagamentoModel.setNrRecibo(nrRecibo);
            pagamentoModel.setProcessada(disp);

            PagamentoController pagamentoControler = new PagamentoController();
            pagamentoControler.registarPagamento(pagamentoModel);

            ClienteModel clienteModel = new ClienteModel();
            clienteModel.setNome(nome);
            clienteModel.setSaldo(saldo);

            ClienteController clienteController = new ClienteController();
            clienteController.ActualizarSaldo(clienteModel);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter valores numéricos: " + e.getMessage());
        }
    }
    //Metodo Listar

    private void listarPagamentos() {
        try {
            PagamentoController pagamentoController = new PagamentoController();

            DefaultTableModel model = (DefaultTableModel) tabelaPagamentos.getModel();
            model.setRowCount(0);

            ArrayList<PagamentoModel> lista = pagamentoController.listarPagamento();

            for (PagamentoModel item : lista) {
                model.addRow(new Object[]{
                    item.getIdPagamento(),
                    item.getNomeDoCliente(),
                    item.getDataPagamento(),
                    item.getPrazoPagamento(),
                    item.getNrDaFactura(),
                    item.getValorDaFactura(),
                    item.getMulta(),
                    item.getValorTotal(),
                    item.getValorPago(),
                    item.getTrocos(),
                    item.getSaldo(),
                    item.getNrRecibo(),
                    item.getProcessada()
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ListarPagamento View" + erro);
        }
    }

    //Metodo Limpar Campos
    private void limparCampos() {
        txtIdPagamentos.setText("");
        cbxFacturas.setSelectedIndex(0);
        txtPrazoPagamento.setText("");
        txtPrazoPagamento.setText("");
        txtNomeCliente.setText("");
        txtSaldoActual.setText("");
        txtMultas.setText("");
        txtTotalAPagar.setText("");
        txtValorFactura.setText("");
        txtTrocos.setText("");
        txtValorEntregue.setText("");
        txtNrRecibos.setText("");

    }

    //Metodo Carregar Campos
    private void CarregarCampos() {
        int setar = tabelaPagamentos.getSelectedRow();

        txtIdPagamentos.setText(tabelaPagamentos.getModel().getValueAt(setar, 0).toString());
        txtNomeCliente.setText(tabelaPagamentos.getModel().getValueAt(setar, 1).toString());
        txtDataPagamento.setText(tabelaPagamentos.getModel().getValueAt(setar, 2).toString());
        txtPrazoPagamento.setText(tabelaPagamentos.getModel().getValueAt(setar, 3).toString());
        cbxFacturas.setSelectedItem(tabelaPagamentos.getModel().getValueAt(setar, 4).toString());
        txtValorFactura.setText(tabelaPagamentos.getModel().getValueAt(setar, 5).toString());
        txtMultas.setText(tabelaPagamentos.getModel().getValueAt(setar, 6).toString());
        txtTotalAPagar.setText(tabelaPagamentos.getModel().getValueAt(setar, 7).toString());
        txtValorEntregue.setText(tabelaPagamentos.getModel().getValueAt(setar, 8).toString());
        txtTrocos.setText(tabelaPagamentos.getModel().getValueAt(setar, 9).toString());
        txtSaldoActual.setText(tabelaPagamentos.getModel().getValueAt(setar, 10).toString());
        txtNrRecibos.setText(tabelaPagamentos.getModel().getValueAt(setar, 11).toString());
    }

    //Metodo Actualizar Pagamento
    private void actualizarPagamento() {
        try {
            int idPagamento = Integer.parseInt(txtIdPagamentos.getText());
            String nome = txtNomeCliente.getText();
            String datapagamento = txtDataPagamento.getText();
            String prazoPagamento = txtPrazoPagamento.getText();
            String nrFact = cbxFacturas.getSelectedItem().toString();
            int nrFactura = Integer.parseInt(nrFact);
            double valorfactura = Double.parseDouble(txtValorFactura.getText());
            double multa = Double.parseDouble(txtMultas.getText());
            double valorTotal = Double.parseDouble(txtSaldoActual.getText());
            double valorPago = Double.parseDouble(txtValorEntregue.getText());
            double trocos = Double.parseDouble(txtTrocos.getText());
            double saldo = Double.parseDouble(txtTotalAPagar.getText());

            int nrRecibo = Integer.parseInt(txtNrRecibos.getText());
            boolean disp = true;

            // Criando e configurando o modelo de pagamento
            PagamentoModel pagamentoModel = new PagamentoModel();
            pagamentoModel.setIdPagamento(idPagamento);
            pagamentoModel.setNomeDoCliente(nome);
            pagamentoModel.setDataPagamento(datapagamento);
            pagamentoModel.setPrazoPagamento(prazoPagamento);
            pagamentoModel.setNrDaFactura(nrFactura);
            pagamentoModel.setValorDaFactura(valorfactura);
            pagamentoModel.setMulta(multa);
            pagamentoModel.setValorTotal(valorTotal);
            pagamentoModel.setValorPago(valorPago);
            pagamentoModel.setTrocos(trocos);
            pagamentoModel.setSaldo(saldo);
            pagamentoModel.setNrRecibo(nrRecibo);
            pagamentoModel.setStatusPagamento(disp);

            // Atualizando pagamento no banco de dados
            PagamentoController pagamentoController = new PagamentoController();
            pagamentoController.ActualizarPagamentos(pagamentoModel);

            // Atualizando saldo na tabela de clientes
            ClienteModel clienteModel = new ClienteModel();
            clienteModel.setNome(nome); // Corrigido para setNome
            clienteModel.setSaldo(saldo);

            ClienteController clienteController = new ClienteController();
            clienteController.ActualizarSaldo(clienteModel);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter valores numéricos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar pagamento: " + e.getMessage());
        }
    }
    //Metodo Apagar Pagamento

    private void apagarPagamento() {
        try {
            int idPagamento = Integer.parseInt(txtIdPagamentos.getText());
            String nome = txtNomeCliente.getText();
            String datapagamento = txtDataPagamento.getText();
            String prazoPagamento = txtPrazoPagamento.getText();
            String nrFact = cbxFacturas.getSelectedItem().toString();
            int nrFactura = Integer.parseInt(nrFact);
            double valorfactura = Double.parseDouble(txtValorFactura.getText());
            double multa = Double.parseDouble(txtMultas.getText());
            double valorTotal = Double.parseDouble(txtSaldoActual.getText());
            double valorPago = Double.parseDouble(txtValorEntregue.getText());
            double trocos = Double.parseDouble(txtTrocos.getText());
            double saldo = Double.parseDouble(txtTotalAPagar.getText());
            int nrRecibo = Integer.parseInt(txtNrRecibos.getText());
            boolean disp = false;

            // Criando e configurando o modelo de pagamento
            PagamentoModel pagamentoModel = new PagamentoModel();
            pagamentoModel.setIdPagamento(idPagamento);
            pagamentoModel.setNomeDoCliente(nome);
            pagamentoModel.setDataPagamento(datapagamento);
            pagamentoModel.setPrazoPagamento(prazoPagamento);
            pagamentoModel.setNrDaFactura(nrFactura);
            pagamentoModel.setValorDaFactura(valorfactura);
            pagamentoModel.setMulta(multa);
            pagamentoModel.setValorTotal(valorTotal);
            pagamentoModel.setValorPago(valorPago);
            pagamentoModel.setTrocos(trocos);
            pagamentoModel.setSaldo(saldo);
            pagamentoModel.setNrRecibo(nrRecibo);
            pagamentoModel.setStatusPagamento(disp);

            // Atualizando pagamento no banco de dados
            PagamentoController pagamentoController = new PagamentoController();
            pagamentoController.ActualizarPagamentos(pagamentoModel);

            // Atualizando saldo na tabela de clientes
            ClienteModel clienteModel = new ClienteModel();
            clienteModel.setNome(nome); // Corrigido para setNome
            clienteModel.setSaldo(saldo);

            ClienteController clienteController = new ClienteController();
            clienteController.ActualizarSaldo(clienteModel);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter valores numéricos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar pagamento: " + e.getMessage());
        }
    }

    //Metodo verificar trocos
    private void verificarTrocos() {
        //verificao de um valor positivo e apenas numeros
        String valorPag = txtValorEntregue.getText();
        if (valorPag.isEmpty() || !valorPag.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Valor inválido.");
            return;
        }

        double trocosAReduzir = 0;
        double valorPagoAReduzir = Double.parseDouble(txtValorEntregue.getText());
        BigDecimal bd = new BigDecimal(valorPagoAReduzir).setScale(2, RoundingMode.HALF_UP);
        double valorPago = bd.doubleValue();

        double valorAPagar = Double.parseDouble(txtTotalAPagar.getText());

        if (valorPago <= 0) {
            JOptionPane.showMessageDialog(null, "Valor pago deve ser maior que 0.", "Erro na Inserção de Valor", JOptionPane.ERROR_MESSAGE);
        } else {
            double dividaDepoisPagAReduzir;
            if (valorPago > valorAPagar) {
                trocosAReduzir = valorPago - valorAPagar;
                dividaDepoisPagAReduzir = 0;
            } else {
                dividaDepoisPagAReduzir = valorAPagar - valorPago;

            }
            bd = new BigDecimal(trocosAReduzir).setScale(2, RoundingMode.HALF_EVEN);
            double trocos = bd.doubleValue();
            txtTrocos.setText("" + trocos);

            bd = new BigDecimal(dividaDepoisPagAReduzir).setScale(2, RoundingMode.HALF_EVEN);
            double dividaDepoisPag = bd.doubleValue();
            txtSaldoActual.setText("" + dividaDepoisPag);
        }
    }

}
