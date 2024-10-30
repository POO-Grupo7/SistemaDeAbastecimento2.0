package ViewGestor;

import View.*;
import Controller.HidrometroController;
import Model.HidrometroModel;
import View.table.TableCustom;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class HidrometroGestorView extends javax.swing.JFrame {

    public HidrometroGestorView() {
        initComponents();
        listarHidrometro();
        testData(tabelaHidrometro);
        getContentPane().setBackground(Color.white);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
//        painelEsqDados.setLayout(new MigLayout());
//        painelEsqDados.add(lblId);
//        painelEsqDados.add(txtId, "wrap");
//        painelEsqDados.add(lblNome);
//        painelEsqDados.add(txtNome, "wrap, pushx, growx");

    }

    private void testData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        painelCabecalho = new javax.swing.JPanel();
        lblCabecalho = new javax.swing.JLabel();
        txtNomeAPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        painelConteudo = new javax.swing.JPanel();
        painelContCentral = new javax.swing.JPanel();
        painelSuperiorDados = new javax.swing.JPanel();
        painelEsqDados = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblDataRegisto = new javax.swing.JLabel();
        txtNumeroDeHidrometro = new javax.swing.JTextField();
        lblNumeroDeHidrometro = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        txtDataRegisto = new com.toedter.calendar.JDateChooser();
        btnApagados = new javax.swing.JButton();
        painelInferiorBotoesTabela = new javax.swing.JPanel();
        tabela = new javax.swing.JPanel();
        botoes = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHidrometro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HIDROMETROS");
        setMinimumSize(new java.awt.Dimension(600, 500));
        setResizable(false);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setMinimumSize(new java.awt.Dimension(500, 250));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(500, 250));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelCabecalho.setBackground(new java.awt.Color(52, 102, 138));
        painelCabecalho.setForeground(new java.awt.Color(255, 255, 255));

        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        lblCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        lblCabecalho.setText("Hidrometro");

        txtNomeAPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_paid_search_32px.png"))); // NOI18N

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addComponent(lblCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(txtNomeAPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addComponent(lblCabecalho)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeAPesquisar))
                .addContainerGap())
        );

        painelPrincipal.add(painelCabecalho, java.awt.BorderLayout.NORTH);

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setAlignmentX(0.0F);
        painelConteudo.setAlignmentY(0.0F);
        painelConteudo.setInheritsPopupMenu(true);
        painelConteudo.setLayout(new java.awt.BorderLayout(10, 10));

        painelContCentral.setBackground(new java.awt.Color(255, 255, 255));
        painelContCentral.setLayout(new java.awt.BorderLayout());

        painelSuperiorDados.setBackground(new java.awt.Color(255, 255, 255));
        painelSuperiorDados.setLayout(new java.awt.GridLayout(1, 2));

        painelEsqDados.setBackground(new java.awt.Color(255, 255, 255));
        painelEsqDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 43, 64)));
        painelEsqDados.setMaximumSize(new java.awt.Dimension(500, 250));
        painelEsqDados.setPreferredSize(new java.awt.Dimension(500, 250));

        lblId.setText("Id:");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblDataRegisto.setText("Data de Inicio:*");

        txtNumeroDeHidrometro.setEditable(false);
        txtNumeroDeHidrometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeHidrometroActionPerformed(evt);
            }
        });

        lblNumeroDeHidrometro.setText("Numero de Hidrometro:");

        lbStatus.setText("Estado:*");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione>", "Operacional", "Nao Operacional" }));

        txtDataRegisto.setDateFormatString("dd/MM/yyyy");

        btnApagados.setBackground(new java.awt.Color(255, 0, 51));
        btnApagados.setText("Ver Apagados");

        javax.swing.GroupLayout painelEsqDadosLayout = new javax.swing.GroupLayout(painelEsqDados);
        painelEsqDados.setLayout(painelEsqDadosLayout);
        painelEsqDadosLayout.setHorizontalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(lblDataRegisto))
                        .addGap(79, 79, 79)
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataRegisto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(lblNumeroDeHidrometro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNumeroDeHidrometro, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(lbStatus)
                        .addGap(117, 117, 117)
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnApagados, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(163, 163, Short.MAX_VALUE))
        );
        painelEsqDadosLayout.setVerticalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblId))
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataRegisto)
                    .addComponent(txtDataRegisto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumeroDeHidrometro)
                    .addComponent(txtNumeroDeHidrometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnApagados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelSuperiorDados.add(painelEsqDados);

        painelContCentral.add(painelSuperiorDados, java.awt.BorderLayout.PAGE_START);

        painelInferiorBotoesTabela.setBackground(new java.awt.Color(255, 255, 255));
        painelInferiorBotoesTabela.setLayout(new java.awt.BorderLayout());

        tabela.setBackground(new java.awt.Color(255, 255, 255));
        tabela.setLayout(new java.awt.BorderLayout());

        botoes.setBackground(new java.awt.Color(255, 255, 255));
        botoes.setPreferredSize(new java.awt.Dimension(500, 77));
        java.awt.GridBagLayout botoesLayout = new java.awt.GridBagLayout();
        botoesLayout.columnWidths = new int[] {0};
        botoesLayout.rowHeights = new int[] {0};
        botoes.setLayout(botoesLayout);

        btnCadastrar.setBackground(new java.awt.Color(52, 102, 138));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Imprimir");
        btnCadastrar.setMargin(new java.awt.Insets(3, 8, 3, 8));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        botoes.add(btnCadastrar, new java.awt.GridBagConstraints());

        tabela.add(botoes, java.awt.BorderLayout.PAGE_START);

        tabelaHidrometro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelaHidrometro.setForeground(new java.awt.Color(255, 255, 255));
        tabelaHidrometro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Data de Registo", "Numero de Hidrometro", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaHidrometro.setRowHeight(15);
        jScrollPane1.setViewportView(tabelaHidrometro);
        if (tabelaHidrometro.getColumnModel().getColumnCount() > 0) {
            tabelaHidrometro.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaHidrometro.getColumnModel().getColumn(2).setMinWidth(50);
            tabelaHidrometro.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        tabela.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        painelInferiorBotoesTabela.add(tabela, java.awt.BorderLayout.CENTER);

        painelContCentral.add(painelInferiorBotoesTabela, java.awt.BorderLayout.CENTER);

        painelConteudo.add(painelContCentral, java.awt.BorderLayout.CENTER);

        painelPrincipal.add(painelConteudo, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            tabelaHidrometro.print();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNomeAPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAPesquisarActionPerformed

    private void txtNumeroDeHidrometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeHidrometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeHidrometroActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HidrometroGestorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnApagados;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblDataRegisto;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNumeroDeHidrometro;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelContCentral;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelEsqDados;
    private javax.swing.JPanel painelInferiorBotoesTabela;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelSuperiorDados;
    private javax.swing.JPanel tabela;
    private javax.swing.JTable tabelaHidrometro;
    private com.toedter.calendar.JDateChooser txtDataRegisto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNomeAPesquisar;
    private javax.swing.JTextField txtNumeroDeHidrometro;
    // End of variables declaration//GEN-END:variables

    public void cadastrarHidrometro() {
        // Define o número do hidrômetro        
        //Numero aleatorio
        Random aleatorio = new Random();
        Date anoActual = new Date();
        String nrHidrometro = anoActual.getYear() + "/" + aleatorio.nextInt(10000001);
        txtNumeroDeHidrometro.setText(nrHidrometro);

        String selectedOption = cbxStatus.getSelectedItem().toString();
        String estado = "Operacional";
        if (selectedOption.equals("<Selecione>")) {
            JOptionPane.showMessageDialog(null, "Selecione uma opcao válida");
        } else {
            estado = cbxStatus.getSelectedItem().toString();
        }

        Date selectedDate = txtDataRegisto.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(selectedDate);

        HidrometroModel hidrometroModel = new HidrometroModel();
        hidrometroModel.setDataRegisto(formattedDate);
        hidrometroModel.setNrHiodrometro(nrHidrometro);
        hidrometroModel.setEstado(estado);

        HidrometroController hidrometroController = new HidrometroController();
        hidrometroController.cadastrarHidrometro(hidrometroModel);
    }

    //Metodo para Listar Hidrometro
    private void listarHidrometro() {
        try {
            HidrometroController hidrometroController = new HidrometroController();

            DefaultTableModel model = (DefaultTableModel) tabelaHidrometro.getModel();
            model.setRowCount(0); // Limpar a tabela antes de listar novamente

//            tabelaHidrometro.setModel(model);
            ArrayList<HidrometroModel> lista = hidrometroController.listarHidrometro();
            System.out.println("Hidrometro encontrados: " + lista.size());
            System.out.println(lista.isEmpty());

            // Preencher a tabela com os dados dos hidrometros
            for (HidrometroModel item : lista) {
                model.addRow(new Object[]{
                    item.getIdHidrometro(),
                    item.getDataRegisto(),
                    item.getNrHidrometro(),
                    item.getEstado()
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar hidrometros: " + erro.getMessage());
        }
    }

    //Metodo Actualizar Hidrometro
    private void actualizarHidrometro() {
        int id = Integer.parseInt(txtId.getText());
        String selectedOption = cbxStatus.getSelectedItem().toString();
        String estado = "Operacional";
        if (selectedOption.equals("<Selecione>")) {
            JOptionPane.showMessageDialog(null, "Selecione uma opcao válida");
        } else {
            estado = cbxStatus.getSelectedItem().toString();
        }

        Date selectedDate = txtDataRegisto.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(selectedDate);
        String nrHidrometro = txtNumeroDeHidrometro.getText();

        HidrometroModel hidrometroModel = new HidrometroModel();
        hidrometroModel.setIdHidrometro(id);
        hidrometroModel.setDataRegisto(formattedDate);
        hidrometroModel.setNrHiodrometro(nrHidrometro);
        hidrometroModel.setEstado(estado);

        HidrometroController hidrometroControler = new HidrometroController();
        hidrometroControler.actualizarHidrometro(hidrometroModel);

        JOptionPane.showMessageDialog(null, "Hidrometro actualizado com sucesso");
    }

    private void apagarHidrometro() {
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar o hidrometro?", "Confirmação de Saída", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            boolean apagado = true;
            System.out.println("Esta em estado apagado");
        }

    }

    //Metodo Carregar Campos
    private void carregarCampos() {
        int setar = tabelaHidrometro.getSelectedRow();

        txtId.setText(tabelaHidrometro.getModel().getValueAt(setar, 0).toString());
        txtDataRegisto.setDateFormatString(tabelaHidrometro.getModel().getValueAt(setar, 1).toString());
        txtNumeroDeHidrometro.setText(tabelaHidrometro.getModel().getValueAt(setar, 2).toString());
        cbxStatus.setSelectedItem(tabelaHidrometro.getModel().getValueAt(setar, 3).toString());
    }

    //Metodo Limpar Campos
    private void limparCampos() {
        txtId.setText("");
        txtDataRegisto.setDateFormatString("");
        txtNumeroDeHidrometro.setText("");
        cbxStatus.setSelectedIndex(0);
    }

}
