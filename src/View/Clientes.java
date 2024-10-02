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

public class Clientes extends javax.swing.JFrame {

    public Clientes() {
        initComponents();
        testData(jTable2);
        getContentPane().setBackground(Color.white);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
//        painelEsqDados.setLayout(new MigLayout());
//        painelEsqDados.add(lblId);
//        painelEsqDados.add(txtId, "wrap");
//        painelEsqDados.add(lblNome);
//        painelEsqDados.add(txtNome, "wrap, pushx, growx");
        
    }
    
    private void testData(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        "ID", "Nome", "Apelido", "Naturalidade", "Data Nascimento", "Email", "Função", "Usuario", "Senha", "Perfil", "Activo", "Disp"
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
        model.addRow(new Object[]{1, "Ussene Carlos","Matato","Maputo","12/11/1999","ussene.c.matat@gmail.com","Administrador","Ussas","Ussas","Admin","Sim","Sim"});
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
        txtNomeAPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        painelConteudo = new javax.swing.JPanel();
        painelConteudoEsquerdo = new javax.swing.JPanel();
        btnVoltarMenu = new javax.swing.JButton();
        lblIconLogo = new javax.swing.JLabel();
        painelContCentral = new javax.swing.JPanel();
        painelSuperiorDados = new javax.swing.JPanel();
        painelEsqDados = new javax.swing.JPanel();
        lbId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        lbBairro = new javax.swing.JLabel();
        lbNumeroDaCasa = new javax.swing.JLabel();
        lblDataDeContrato = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbEmailParticular = new javax.swing.JLabel();
        cbxBairro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtQuarterao = new javax.swing.JTextField();
        txtNumeroDeCasa = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        lbNumeroDeTelefone = new javax.swing.JLabel();
        txtEmailParticular = new javax.swing.JTextField();
        txtDataDeContrato = new javax.swing.JTextField();
        TxtNumeroDeTelefone = new javax.swing.JTextField();
        painelDirDados = new javax.swing.JPanel();
        lbNumeroDeHidrometro = new javax.swing.JLabel();
        txtNumeroDeHidrometro = new javax.swing.JTextField();
        lbDespesasIniciais = new javax.swing.JLabel();
        lbConsumo = new javax.swing.JLabel();
        lbSaldo = new javax.swing.JLabel();
        lbDisp = new javax.swing.JLabel();
        txtDisp = new javax.swing.JTextField();
        lbStatus = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        cbxDespesasIniciais = new javax.swing.JComboBox<>();
        txtConsumo = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        painelInferiorBotoesTabela = new javax.swing.JPanel();
        tabela = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
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
        setTitle("USUÁRIOS");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(1180, 650));

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(1260, 720));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelCabecalho.setBackground(new java.awt.Color(52, 102, 138));
        painelCabecalho.setForeground(new java.awt.Color(255, 255, 255));

        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        lblCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        lblCabecalho.setText("Clientes");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1081, Short.MAX_VALUE)
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

        btnVoltarMenu.setBackground(new java.awt.Color(52, 102, 138));
        btnVoltarMenu.setForeground(new java.awt.Color(52, 102, 138));
        btnVoltarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8-menu-48.png"))); // NOI18N
        btnVoltarMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        btnVoltarMenu.setContentAreaFilled(false);
        btnVoltarMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVoltarMenu.setDefaultCapable(false);
        btnVoltarMenu.setOpaque(true);
        btnVoltarMenu.setSelected(true);
        painelConteudoEsquerdo.add(btnVoltarMenu, java.awt.BorderLayout.NORTH);
        btnVoltarMenu.getAccessibleContext().setAccessibleName("btnVoltarMenu");

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

        lbId.setText("Id:");

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lbNome.setText("Nome:*");

        lbBairro.setText("Bairro:*");

        lbNumeroDaCasa.setText("Numero da Casa:*");

        lblDataDeContrato.setText("Data do Contrato:*");

        lbEmailParticular.setText("Email Particular:");

        cbxBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "CMC" }));

        jLabel2.setText("Quarterao:");

        txtQuarterao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuarteraoActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        lbNumeroDeTelefone.setText("Numero de Telefone:*");

        javax.swing.GroupLayout painelEsqDadosLayout = new javax.swing.GroupLayout(painelEsqDados);
        painelEsqDados.setLayout(painelEsqDadosLayout);
        painelEsqDadosLayout.setHorizontalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(lblDataDeContrato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDataDeContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(lbEmailParticular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmailParticular, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelEsqDadosLayout.createSequentialGroup()
                            .addComponent(lbNumeroDeTelefone)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtNumeroDeTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelEsqDadosLayout.createSequentialGroup()
                            .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                    .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbBairro)
                                        .addComponent(lbNome)
                                        .addComponent(lbId))
                                    .addGap(51, 51, 51)
                                    .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                            .addGap(58, 58, 58)
                                            .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                                    .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtQuarterao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtNumeroDeCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(177, 177, 177))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEsqDadosLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(lbNumeroDaCasa))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painelEsqDadosLayout.setVerticalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBairro)
                    .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtQuarterao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumeroDaCasa)
                    .addComponent(txtNumeroDeCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataDeContrato)
                    .addComponent(txtDataDeContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmailParticular)
                    .addComponent(txtEmailParticular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumeroDeTelefone)
                    .addComponent(TxtNumeroDeTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        painelEsqDadosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbBairro, lbEmailParticular, lbId, lbNome, lbNumeroDaCasa, lblDataDeContrato, txtId, txtNome});

        painelSuperiorDados.add(painelEsqDados);

        painelDirDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDirDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 43, 64)));

        lbNumeroDeHidrometro.setText("Numero de Hidrometro:*");

        txtNumeroDeHidrometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeHidrometroActionPerformed(evt);
            }
        });

        lbDespesasIniciais.setText("Despesas Iniciais:*");

        lbConsumo.setText("Consumo:");

        lbSaldo.setText("Saldo:");

        lbDisp.setText("Disponibilidade:");

        txtDisp.setEditable(false);

        lbStatus.setText("Activo:*");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Nao" }));

        cbxDespesasIniciais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Nao" }));

        txtConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsumoActionPerformed(evt);
            }
        });

        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDirDadosLayout = new javax.swing.GroupLayout(painelDirDados);
        painelDirDados.setLayout(painelDirDadosLayout);
        painelDirDadosLayout.setHorizontalGroup(
            painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDirDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDirDadosLayout.createSequentialGroup()
                        .addComponent(lbDisp)
                        .addGap(79, 79, 79)
                        .addComponent(txtDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDirDadosLayout.createSequentialGroup()
                        .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumeroDeHidrometro)
                            .addComponent(lbDespesasIniciais)
                            .addComponent(lbConsumo)
                            .addComponent(lbSaldo))
                        .addGap(18, 18, 18)
                        .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldo)
                            .addComponent(txtConsumo, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                            .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNumeroDeHidrometro)
                                .addComponent(cbxDespesasIniciais, 0, 416, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDirDadosLayout.setVerticalGroup(
            painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDirDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumeroDeHidrometro)
                    .addComponent(txtNumeroDeHidrometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDespesasIniciais)
                    .addComponent(cbxDespesasIniciais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbConsumo)
                    .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSaldo)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbStatus)
                .addGap(18, 18, 18)
                .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDisp)
                    .addComponent(txtDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 115, Short.MAX_VALUE))
        );

        painelDirDadosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbConsumo, lbDespesasIniciais, lbDisp, lbNumeroDeHidrometro, lbSaldo});

        painelSuperiorDados.add(painelDirDados);

        painelContCentral.add(painelSuperiorDados, java.awt.BorderLayout.PAGE_START);

        painelInferiorBotoesTabela.setBackground(new java.awt.Color(255, 255, 255));
        painelInferiorBotoesTabela.setLayout(new java.awt.BorderLayout());

        tabela.setBackground(new java.awt.Color(255, 255, 255));
        tabela.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(0, 102, 102));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Bairro", "Numero da Casa", "Data do Contrato", "Email Particular", "Numero de Telefone", "Numero de Hidrometro", "Despesas Iniciais", "Consumo", "Saldo", "Activo", "Dip"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(180);
            jTable2.getColumnModel().getColumn(10).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(11).setPreferredWidth(40);
        }

        tabela.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        botoes.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout botoesLayout = new java.awt.GridBagLayout();
        botoesLayout.columnWidths = new int[] {0};
        botoesLayout.rowHeights = new int[] {0};
        botoes.setLayout(botoesLayout);

        jButton6.setBackground(new java.awt.Color(52, 102, 138));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Cadastrar");
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

    private void txtNumeroDeHidrometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeHidrometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeHidrometroActionPerformed

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

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtQuarteraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuarteraoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuarteraoActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void txtConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsumoActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
//            FlatCyanLightIJTheme.setup();
//            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
           e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtNumeroDeTelefone;
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnVoltarMenu;
    private javax.swing.JComboBox<String> cbxBairro;
    private javax.swing.JComboBox<String> cbxDespesasIniciais;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbConsumo;
    private javax.swing.JLabel lbDespesasIniciais;
    private javax.swing.JLabel lbDisp;
    private javax.swing.JLabel lbEmailParticular;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumeroDaCasa;
    private javax.swing.JLabel lbNumeroDeHidrometro;
    private javax.swing.JLabel lbNumeroDeTelefone;
    private javax.swing.JLabel lbSaldo;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblDataDeContrato;
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
    private javax.swing.JPanel tabela;
    private javax.swing.JTextField txtConsumo;
    private javax.swing.JTextField txtDataDeContrato;
    private javax.swing.JTextField txtDisp;
    private javax.swing.JTextField txtEmailParticular;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeAPesquisar;
    private javax.swing.JTextField txtNumeroDeCasa;
    private javax.swing.JTextField txtNumeroDeHidrometro;
    private javax.swing.JTextField txtQuarterao;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
