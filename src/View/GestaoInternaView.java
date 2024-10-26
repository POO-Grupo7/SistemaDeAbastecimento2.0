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

public class GestaoInternaView extends javax.swing.JFrame {

    public GestaoInternaView() {
        initComponents();
//        painelEsqDados.setLayout(new MigLayout());
//        painelEsqDados.add(lblId);
//        painelEsqDados.add(txtId, "wrap");
//        painelEsqDados.add(lblNome);
//        painelEsqDados.add(txtNome, "wrap, pushx, growx");
        
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
        painelConteudoEsquerdo = new javax.swing.JPanel();
        painelVoltarMenu = new javax.swing.JPanel();
        btnVoltarMenu1 = new javax.swing.JButton();
        lblCabecalho1 = new javax.swing.JLabel();
        lblIconLogo = new javax.swing.JLabel();
        painelContCentral = new javax.swing.JPanel();
        painelSuperiorDados = new javax.swing.JPanel();
        painelEsqDados = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        painelDirDados = new javax.swing.JPanel();
        painelInferiorBotoesTabela = new javax.swing.JPanel();
        tabela = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão Interna");
        setMinimumSize(new java.awt.Dimension(1180, 650));
        setPreferredSize(new java.awt.Dimension(1260, 700));

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(1260, 720));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelCabecalho.setBackground(new java.awt.Color(52, 102, 138));
        painelCabecalho.setForeground(new java.awt.Color(255, 255, 255));

        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        lblCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        lblCabecalho.setText("Gestão Interna");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 777, Short.MAX_VALUE)
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

        painelConteudoEsquerdo.setBackground(new java.awt.Color(52, 102, 138));
        painelConteudoEsquerdo.setLayout(new java.awt.BorderLayout());

        painelVoltarMenu.setBackground(new java.awt.Color(52, 102, 138));

        btnVoltarMenu1.setBackground(new java.awt.Color(52, 102, 138));
        btnVoltarMenu1.setForeground(new java.awt.Color(52, 102, 138));
        btnVoltarMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8-menu-48.png"))); // NOI18N
        btnVoltarMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        btnVoltarMenu1.setContentAreaFilled(false);
        btnVoltarMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVoltarMenu1.setDisabledIcon(null);
        btnVoltarMenu1.setDisabledSelectedIcon(null);
        btnVoltarMenu1.setOpaque(true);
        btnVoltarMenu1.setSelected(true);
        btnVoltarMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMenu1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarMenu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarMenu1MouseExited(evt);
            }
        });
        btnVoltarMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarMenu1ActionPerformed(evt);
            }
        });
        painelVoltarMenu.add(btnVoltarMenu1);

        lblCabecalho1.setBackground(new java.awt.Color(52, 102, 138));
        lblCabecalho1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblCabecalho1.setForeground(new java.awt.Color(255, 255, 255));
        lblCabecalho1.setText("Voltar");
        painelVoltarMenu.add(lblCabecalho1);

        painelConteudoEsquerdo.add(painelVoltarMenu, java.awt.BorderLayout.NORTH);

        lblIconLogo.setBackground(new java.awt.Color(52, 102, 138));
        lblIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/social-media.png"))); // NOI18N
        painelConteudoEsquerdo.add(lblIconLogo, java.awt.BorderLayout.CENTER);

        painelConteudo.add(painelConteudoEsquerdo, java.awt.BorderLayout.WEST);

        painelContCentral.setBackground(new java.awt.Color(255, 255, 255));
        painelContCentral.setLayout(new java.awt.BorderLayout());

        painelSuperiorDados.setBackground(new java.awt.Color(255, 255, 255));
        painelSuperiorDados.setLayout(new java.awt.GridLayout(1, 2));

        painelEsqDados.setBackground(new java.awt.Color(255, 255, 255));
        painelEsqDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 43, 64)));

        jButton1.setText("Gerir Taxas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Despesas de Manutenção");

        jButton3.setText("Receitas de Cobranças");

        jButton4.setText("Dashboard");

        javax.swing.GroupLayout painelEsqDadosLayout = new javax.swing.GroupLayout(painelEsqDados);
        painelEsqDados.setLayout(painelEsqDadosLayout);
        painelEsqDadosLayout.setHorizontalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        painelEsqDadosLayout.setVerticalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(98, Short.MAX_VALUE))
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
            .addGap(0, 311, Short.MAX_VALUE)
        );

        painelSuperiorDados.add(painelDirDados);

        painelContCentral.add(painelSuperiorDados, java.awt.BorderLayout.PAGE_START);

        painelInferiorBotoesTabela.setBackground(new java.awt.Color(255, 255, 255));
        painelInferiorBotoesTabela.setLayout(new java.awt.BorderLayout());

        tabela.setBackground(new java.awt.Color(255, 255, 255));
        tabela.setLayout(new java.awt.BorderLayout());
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

    private void txtNomeAPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAPesquisarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TaxaView().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVoltarMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenu1MouseClicked
        btnVoltarMenu1.setBackground(new Color(52,102,138));
    }//GEN-LAST:event_btnVoltarMenu1MouseClicked

    private void btnVoltarMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenu1MouseEntered
        btnVoltarMenu1.setBackground(new Color(45, 45, 45));
    }//GEN-LAST:event_btnVoltarMenu1MouseEntered

    private void btnVoltarMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenu1MouseExited
        btnVoltarMenu1.setBackground(new Color(52,102,138));
    }//GEN-LAST:event_btnVoltarMenu1MouseExited

    private void btnVoltarMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMenu1ActionPerformed
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarMenu1ActionPerformed

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
                new GestaoInternaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltarMenu1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblCabecalho1;
    private javax.swing.JLabel lblIconLogo;
    private javax.swing.JPanel painelCabecalho;
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
    private javax.swing.JTextField txtNomeAPesquisar;
    // End of variables declaration//GEN-END:variables
}
