package View;

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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class TaxaView extends javax.swing.JFrame {

    public TaxaView() {
        initComponents();
        testData(jTable2);
//        getContentPane().setBackground(Color.white);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);        
    }
    
    private void testData(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();        
        model.addRow(new Object[]{1,"Alto Escalao",200});
        model.addRow(new Object[]{2,"Alto Escalao",200});
        model.addRow(new Object[]{3,"Alto Escalao",200});
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
        painelCabecalho = new javax.swing.JPanel();
        lblCabecalho = new javax.swing.JLabel();
        painelConteudo = new javax.swing.JPanel();
        painelContCentral = new javax.swing.JPanel();
        painelSuperiorDados = new javax.swing.JPanel();
        painelEsqDados = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblTipoConsumo = new javax.swing.JLabel();
        cbxTipoConsumo = new javax.swing.JComboBox<>();
        lblDataNascimento = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JTextField();
        txtNomeAPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        painelInferiorBotoesTabela = new javax.swing.JPanel();
        tabela = new javax.swing.JPanel();
        botoes = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TAXAS DE CONSUMO DE ÁGUA");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(1260, 720));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelCabecalho.setBackground(new java.awt.Color(52, 102, 138));
        painelCabecalho.setPreferredSize(new java.awt.Dimension(500, 40));
        painelCabecalho.setLayout(null);

        lblCabecalho.setBackground(new java.awt.Color(255, 255, 255));
        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        lblCabecalho.setText("TAXAS");
        painelCabecalho.add(lblCabecalho);
        lblCabecalho.setBounds(260, 10, 81, 28);

        painelPrincipal.add(painelCabecalho, java.awt.BorderLayout.NORTH);

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setAlignmentX(0.0F);
        painelConteudo.setAlignmentY(0.0F);
        painelConteudo.setInheritsPopupMenu(true);
        painelConteudo.setLayout(new java.awt.BorderLayout(10, 10));

        painelContCentral.setBackground(new java.awt.Color(255, 255, 255));
        painelContCentral.setLayout(new java.awt.BorderLayout());

        painelSuperiorDados.setBackground(new java.awt.Color(255, 255, 255));
        painelSuperiorDados.setLayout(new java.awt.GridLayout(1, 0));

        painelEsqDados.setBackground(new java.awt.Color(255, 255, 255));
        painelEsqDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 43, 64)));
        painelEsqDados.setMaximumSize(new java.awt.Dimension(500, 150));
        painelEsqDados.setMinimumSize(new java.awt.Dimension(500, 150));
        painelEsqDados.setPreferredSize(new java.awt.Dimension(500, 160));

        lblId.setText("Id:");

        txtId.setEditable(false);

        lblNome.setText("Nome:");

        lblTipoConsumo.setText("Tipo de Consumo:");

        cbxTipoConsumo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDataNascimento.setText("Valor da Taxa");

        txtNomeAPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_paid_search_32px.png"))); // NOI18N

        javax.swing.GroupLayout painelEsqDadosLayout = new javax.swing.GroupLayout(painelEsqDados);
        painelEsqDados.setLayout(painelEsqDadosLayout);
        painelEsqDadosLayout.setHorizontalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                .addComponent(lblId)
                                .addGap(102, 102, 102)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDataNascimento))
                        .addGap(0, 405, Short.MAX_VALUE))
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelEsqDadosLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(79, 79, 79)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelEsqDadosLayout.createSequentialGroup()
                                .addComponent(lblTipoConsumo)
                                .addGap(18, 18, 18)
                                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTipoConsumo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(txtNomeAPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        painelEsqDadosLayout.setVerticalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomeAPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoConsumo)
                    .addComponent(cbxTipoConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNascimento)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        painelEsqDadosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxTipoConsumo, lblDataNascimento, lblId, lblNome, lblTipoConsumo, txtDataNascimento, txtId, txtNome});

        painelSuperiorDados.add(painelEsqDados);

        painelContCentral.add(painelSuperiorDados, java.awt.BorderLayout.PAGE_START);

        painelInferiorBotoesTabela.setBackground(new java.awt.Color(255, 255, 255));
        painelInferiorBotoesTabela.setLayout(new java.awt.BorderLayout());

        tabela.setBackground(new java.awt.Color(255, 255, 255));
        tabela.setLayout(new java.awt.BorderLayout());

        botoes.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout botoesLayout = new java.awt.GridBagLayout();
        botoesLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        botoesLayout.rowHeights = new int[] {0};
        botoes.setLayout(botoesLayout);

        jButton6.setBackground(new java.awt.Color(52, 102, 138));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Cadastrar");
        jButton6.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton6, gridBagConstraints);

        jButton7.setBackground(new java.awt.Color(52, 102, 138));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Actualizar");
        jButton7.setMargin(new java.awt.Insets(2, 5, 2, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton7, gridBagConstraints);

        jButton8.setBackground(new java.awt.Color(52, 102, 138));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Carregar Campos");
        jButton8.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton8, gridBagConstraints);

        jButton9.setBackground(new java.awt.Color(52, 102, 138));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Limpar Campos");
        jButton9.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton9, gridBagConstraints);

        jButton10.setBackground(new java.awt.Color(52, 102, 138));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Apagar");
        jButton10.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 25, 10);
        botoes.add(jButton10, gridBagConstraints);

        tabela.add(botoes, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBackground(new java.awt.Color(0, 102, 102));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo de Consumo", "Valor da taxa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("");
        jTable2.setRowSelectionAllowed(false);
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        tabela.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        painelInferiorBotoesTabela.add(tabela, java.awt.BorderLayout.CENTER);

        painelContCentral.add(painelInferiorBotoesTabela, java.awt.BorderLayout.CENTER);

        painelConteudo.add(painelContCentral, java.awt.BorderLayout.CENTER);

        painelPrincipal.add(painelConteudo, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtNomeAPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
//            FlatCyanLightIJTheme.setup();
//            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
           e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaxaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoes;
    private javax.swing.JComboBox<String> cbxTipoConsumo;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTipoConsumo;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelContCentral;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelEsqDados;
    private javax.swing.JPanel painelInferiorBotoesTabela;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelSuperiorDados;
    private javax.swing.JPanel tabela;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeAPesquisar;
    // End of variables declaration//GEN-END:variables
}
