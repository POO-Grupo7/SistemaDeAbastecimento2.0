/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ViewGestor.ClientesGestorView;
import ViewGestor.FacturacaoGestorView;
import ViewGestor.GestaoInternaGestorView;
//import ViewGestor.HistoricoHidrometroGestorView;
import ViewGestor.LeiturasGestorView;
import ViewGestor.PagamentoGestorView;
import ViewGestor.RelatoriosGestorView;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;

/**
 *
 * @author lenovo
 */
public class MenuGestorView extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuGestorView() {
        initComponents();
        setLocationRelativeTo(null);
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
        painelEsquerdo = new javax.swing.JPanel();
        painelDadosUtilizador = new javax.swing.JPanel();
        lblImagem = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        lblPerfilAcesso = new javax.swing.JLabel();
        lblEmaildeeAcesso = new javax.swing.JLabel();
        btnAlterarDados = new javax.swing.JButton();
        painelBotoesSairVoltar = new javax.swing.JPanel();
        btnTerminarSeccao = new javax.swing.JButton();
        painelCentralDireito = new javax.swing.JPanel();
        painelCentralDireitoBotoesMenu = new javax.swing.JPanel();
        btnUsuarios = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnHidrometro = new javax.swing.JButton();
        btnLeituras = new javax.swing.JButton();
        btnFacturacao = new javax.swing.JButton();
        btnRecebimentos = new javax.swing.JButton();
        btnGestaoInterna = new javax.swing.JButton();
        btnRelatorios = new javax.swing.JButton();
        btnDefinicoes = new javax.swing.JButton();
        btnTeam = new javax.swing.JButton();
        painelDashboard = new javax.swing.JPanel();
        painelPagTotalMes = new javax.swing.JPanel();
        lblIconPag = new javax.swing.JLabel();
        lblTotalPagamentosMes = new javax.swing.JLabel();
        painelRecTotalMes = new javax.swing.JPanel();
        lblIconRec = new javax.swing.JLabel();
        lblTotalRecebimentosMes = new javax.swing.JLabel();
        painelSituacaoMes = new javax.swing.JPanel();
        lblIconSituacao = new javax.swing.JLabel();
        lblSituacaoMes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setMinimumSize(new java.awt.Dimension(1000, 650));

        painelPrincipal.setPreferredSize(new java.awt.Dimension(1000, 680));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelEsquerdo.setBackground(new java.awt.Color(52, 102, 138));
        painelEsquerdo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 102, 138)));
        painelEsquerdo.setPreferredSize(new java.awt.Dimension(300, 680));

        painelDadosUtilizador.setBackground(new java.awt.Color(52, 102, 138));

        lblImagem.setBackground(new java.awt.Color(255, 255, 255));
        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_person_128px.png"))); // NOI18N
        lblImagem.setAutoscrolls(true);
        lblImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagemMouseClicked(evt);
            }
        });

        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeUsuario.setText("Usuario: Ussene Carlos Matato");

        lblPerfilAcesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPerfilAcesso.setForeground(new java.awt.Color(255, 255, 255));
        lblPerfilAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_forgot_password_16px.png"))); // NOI18N
        lblPerfilAcesso.setText("Perfil: Administrador(a)");

        lblEmaildeeAcesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmaildeeAcesso.setForeground(new java.awt.Color(255, 255, 255));
        lblEmaildeeAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_gmail_16px.png"))); // NOI18N
        lblEmaildeeAcesso.setText("ussene.c.matato@gmail.com");

        btnAlterarDados.setText("Alterar Dados");

        javax.swing.GroupLayout painelDadosUtilizadorLayout = new javax.swing.GroupLayout(painelDadosUtilizador);
        painelDadosUtilizador.setLayout(painelDadosUtilizadorLayout);
        painelDadosUtilizadorLayout.setHorizontalGroup(
            painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblNomeUsuario))
            .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblPerfilAcesso))
            .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblEmaildeeAcesso))
            .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnAlterarDados))
        );
        painelDadosUtilizadorLayout.setVerticalGroup(
            painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblImagem)
                .addGap(22, 22, 22)
                .addComponent(lblNomeUsuario)
                .addGap(10, 10, 10)
                .addComponent(lblPerfilAcesso)
                .addGap(10, 10, 10)
                .addComponent(lblEmaildeeAcesso)
                .addGap(20, 20, 20)
                .addComponent(btnAlterarDados)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        painelBotoesSairVoltar.setBackground(new java.awt.Color(52, 102, 138));
        painelBotoesSairVoltar.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout painelBotoesSairVoltarLayout = new javax.swing.GroupLayout(painelBotoesSairVoltar);
        painelBotoesSairVoltar.setLayout(painelBotoesSairVoltarLayout);
        painelBotoesSairVoltarLayout.setHorizontalGroup(
            painelBotoesSairVoltarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelBotoesSairVoltarLayout.setVerticalGroup(
            painelBotoesSairVoltarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btnTerminarSeccao.setBackground(new java.awt.Color(52, 102, 138));
        btnTerminarSeccao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTerminarSeccao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_login_rounded_up_32px.png"))); // NOI18N
        btnTerminarSeccao.setText("TERMINAR A SECÇÃO");
        btnTerminarSeccao.setBorder(null);
        btnTerminarSeccao.setBorderPainted(false);
        btnTerminarSeccao.setContentAreaFilled(false);
        btnTerminarSeccao.setDefaultCapable(false);
        btnTerminarSeccao.setFocusPainted(false);
        btnTerminarSeccao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarSeccaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelEsquerdoLayout = new javax.swing.GroupLayout(painelEsquerdo);
        painelEsquerdo.setLayout(painelEsquerdoLayout);
        painelEsquerdoLayout.setHorizontalGroup(
            painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBotoesSairVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(painelDadosUtilizador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEsquerdoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTerminarSeccao, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelEsquerdoLayout.setVerticalGroup(
            painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsquerdoLayout.createSequentialGroup()
                .addComponent(painelDadosUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoesSairVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnTerminarSeccao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelPrincipal.add(painelEsquerdo, java.awt.BorderLayout.LINE_START);

        painelCentralDireito.setBackground(new java.awt.Color(255, 255, 255));
        painelCentralDireito.setPreferredSize(new java.awt.Dimension(700, 200));
        painelCentralDireito.setLayout(new java.awt.BorderLayout());

        painelCentralDireitoBotoesMenu.setBackground(new java.awt.Color(255, 255, 255));
        painelCentralDireitoBotoesMenu.setPreferredSize(new java.awt.Dimension(730, 680));
        painelCentralDireitoBotoesMenu.setLayout(new java.awt.GridLayout(3, 4, 10, 10));

        btnUsuarios.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/programmer.png"))); // NOI18N
        btnUsuarios.setText("USUÁRIOS");
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuarios.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseMoved(evt);
            }
        });
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUsuariosMousePressed(evt);
            }
        });
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        btnUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnUsuariosKeyPressed(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnUsuarios);

        btnClientes.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_admin_settings_male_64px.png"))); // NOI18N
        btnClientes.setText("CLIENTES");
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnClientes);

        btnHidrometro.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnHidrometro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_speed_64px.png"))); // NOI18N
        btnHidrometro.setText("HIDROMETROS");
        btnHidrometro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHidrometro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHidrometro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHidrometroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHidrometroMouseExited(evt);
            }
        });
        btnHidrometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHidrometroActionPerformed(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnHidrometro);

        btnLeituras.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnLeituras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/bill_3331603.png"))); // NOI18N
        btnLeituras.setText("LEITURAS");
        btnLeituras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLeituras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLeituras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLeiturasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLeiturasMouseExited(evt);
            }
        });
        btnLeituras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeiturasActionPerformed(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnLeituras);

        btnFacturacao.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnFacturacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/contabilidade.png"))); // NOI18N
        btnFacturacao.setText("FACTURAÇÃO");
        btnFacturacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFacturacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFacturacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFacturacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFacturacaoMouseExited(evt);
            }
        });
        btnFacturacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturacaoActionPerformed(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnFacturacao);

        btnRecebimentos.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnRecebimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/dia-do-pagamento.png"))); // NOI18N
        btnRecebimentos.setText("RECEBIMENTOS");
        btnRecebimentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecebimentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRecebimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRecebimentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRecebimentosMouseExited(evt);
            }
        });
        btnRecebimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecebimentosActionPerformed(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnRecebimentos);

        btnGestaoInterna.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnGestaoInterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_journey_management_planning_64px.png"))); // NOI18N
        btnGestaoInterna.setText("GESTÃO INTERNA");
        btnGestaoInterna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGestaoInterna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGestaoInterna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGestaoInternaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGestaoInternaMouseExited(evt);
            }
        });
        btnGestaoInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestaoInternaActionPerformed(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnGestaoInterna);

        btnRelatorios.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_combo_chart_64px.png"))); // NOI18N
        btnRelatorios.setText("RELATÓRIOS");
        btnRelatorios.setDefaultCapable(false);
        btnRelatorios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRelatorios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRelatoriosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRelatoriosMouseExited(evt);
            }
        });
        btnRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatoriosActionPerformed(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnRelatorios);

        btnDefinicoes.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnDefinicoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_installing_updates_64px.png"))); // NOI18N
        btnDefinicoes.setText("DEFINIÇÕES");
        btnDefinicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDefinicoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDefinicoesMouseExited(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnDefinicoes);

        btnTeam.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        btnTeam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/team.png"))); // NOI18N
        btnTeam.setText("EQUIPE TÉCNICA");
        btnTeam.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeam.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTeam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTeamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTeamMouseExited(evt);
            }
        });
        painelCentralDireitoBotoesMenu.add(btnTeam);

        painelCentralDireito.add(painelCentralDireitoBotoesMenu, java.awt.BorderLayout.CENTER);

        painelDashboard.setBackground(new java.awt.Color(255, 255, 255));
        painelDashboard.setInheritsPopupMenu(true);
        painelDashboard.setPreferredSize(new java.awt.Dimension(600, 200));
        painelDashboard.setLayout(new java.awt.GridLayout(1, 3, 10, 15));

        painelPagTotalMes.setBackground(new java.awt.Color(255, 255, 255));
        painelPagTotalMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconPag.setBackground(new java.awt.Color(0, 0, 204));
        lblIconPag.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIconPag.setForeground(new java.awt.Color(204, 51, 0));
        lblIconPag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconPag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_hongkong_dollar_64px.png"))); // NOI18N
        lblIconPag.setText("Pagamentos do mes:");
        lblIconPag.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIconPag.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        painelPagTotalMes.add(lblIconPag, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 208, -1));

        lblTotalPagamentosMes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalPagamentosMes.setForeground(new java.awt.Color(153, 0, 0));
        lblTotalPagamentosMes.setText("00.00");
        painelPagTotalMes.add(lblTotalPagamentosMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 100, 150, 21));

        painelDashboard.add(painelPagTotalMes);

        painelRecTotalMes.setBackground(new java.awt.Color(255, 255, 255));
        painelRecTotalMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconRec.setBackground(new java.awt.Color(0, 0, 204));
        lblIconRec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIconRec.setForeground(new java.awt.Color(0, 51, 153));
        lblIconRec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconRec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/pagamento.png"))); // NOI18N
        lblIconRec.setText("Recebimentos do Mes:");
        lblIconRec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIconRec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        painelRecTotalMes.add(lblIconRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 208, -1));

        lblTotalRecebimentosMes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalRecebimentosMes.setForeground(new java.awt.Color(0, 51, 153));
        lblTotalRecebimentosMes.setText("00.00");
        painelRecTotalMes.add(lblTotalRecebimentosMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 100, 150, 21));

        painelDashboard.add(painelRecTotalMes);

        painelSituacaoMes.setBackground(new java.awt.Color(255, 255, 255));
        painelSituacaoMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconSituacao.setBackground(new java.awt.Color(0, 0, 204));
        lblIconSituacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIconSituacao.setForeground(new java.awt.Color(67, 160, 71));
        lblIconSituacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconSituacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_money_bag_64px.png"))); // NOI18N
        lblIconSituacao.setText("Situação do mes:");
        lblIconSituacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIconSituacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        painelSituacaoMes.add(lblIconSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 208, -1));

        lblSituacaoMes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSituacaoMes.setForeground(new java.awt.Color(67, 160, 71));
        lblSituacaoMes.setText("00.00");
        painelSituacaoMes.add(lblSituacaoMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 150, 21));

        painelDashboard.add(painelSituacaoMes);

        painelCentralDireito.add(painelDashboard, java.awt.BorderLayout.SOUTH);

        painelPrincipal.add(painelCentralDireito, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFacturacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturacaoActionPerformed
        new FacturacaoGestorView().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFacturacaoActionPerformed

    private void btnUsuariosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseDragged
        // TODO add your handling code here:       
    }//GEN-LAST:event_btnUsuariosMouseDragged

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        // TODO add your handling code here:
        btnUsuarios.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        // TODO add your handling code here:
        btnUsuarios.setBackground(Color.WHITE);
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseEntered
        // TODO add your handling code here:
        btnClientes.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnClientesMouseEntered

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        // TODO add your handling code here:
        btnClientes.setBackground(Color.white);
    }//GEN-LAST:event_btnClientesMouseExited

    private void btnLeiturasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLeiturasMouseEntered
        btnLeituras.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnLeiturasMouseEntered

    private void btnLeiturasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLeiturasMouseExited
        btnLeituras.setBackground(Color.white);
    }//GEN-LAST:event_btnLeiturasMouseExited

    private void btnFacturacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturacaoMouseEntered
        btnFacturacao.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnFacturacaoMouseEntered

    private void btnFacturacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturacaoMouseExited
        btnFacturacao.setBackground(Color.white);
    }//GEN-LAST:event_btnFacturacaoMouseExited

    private void btnRecebimentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecebimentosMouseEntered
        btnRecebimentos.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnRecebimentosMouseEntered

    private void btnRecebimentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecebimentosMouseExited
        btnRecebimentos.setBackground(Color.white);
    }//GEN-LAST:event_btnRecebimentosMouseExited

    private void btnGestaoInternaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestaoInternaMouseEntered
        btnGestaoInterna.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnGestaoInternaMouseEntered

    private void btnGestaoInternaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestaoInternaMouseExited
        btnGestaoInterna.setBackground(Color.white);
    }//GEN-LAST:event_btnGestaoInternaMouseExited

    private void btnRelatoriosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelatoriosMouseEntered
        btnRelatorios.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnRelatoriosMouseEntered

    private void btnRelatoriosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelatoriosMouseExited
        btnRelatorios.setBackground(Color.white);
    }//GEN-LAST:event_btnRelatoriosMouseExited

    private void btnDefinicoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDefinicoesMouseEntered
        btnDefinicoes.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnDefinicoesMouseEntered

    private void btnDefinicoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDefinicoesMouseExited
        btnDefinicoes.setBackground(Color.white);
    }//GEN-LAST:event_btnDefinicoesMouseExited

    private void btnTeamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeamMouseEntered
        btnTeam.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnTeamMouseEntered

    private void btnTeamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeamMouseExited
        btnTeam.setBackground(Color.white);
    }//GEN-LAST:event_btnTeamMouseExited

    private void btnTerminarSeccaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarSeccaoActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que terminar a secção?", "Confirmação de Saída", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            new LogInView1().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnTerminarSeccaoActionPerformed

    private void lblImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagemMouseClicked
        // TODO add your handling code here:   
    }//GEN-LAST:event_lblImagemMouseClicked

    private void btnRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatoriosActionPerformed
        new RelatoriosGestorView().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRelatoriosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
//        new UsuariosView().setVisible(true);
//        dispose();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        new ClientesGestorView().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnLeiturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeiturasActionPerformed
        new LeiturasGestorView().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLeiturasActionPerformed

    private void btnGestaoInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestaoInternaActionPerformed
        new GestaoInternaGestorView().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGestaoInternaActionPerformed

    private void btnRecebimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecebimentosActionPerformed
        new PagamentoGestorView().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRecebimentosActionPerformed

    private void btnUsuariosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseMoved
        // TODO add your handling 
    }//GEN-LAST:event_btnUsuariosMouseMoved

    private void btnHidrometroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHidrometroMouseEntered
        btnHidrometro.setBackground(new Color(42, 130, 218));
    }//GEN-LAST:event_btnHidrometroMouseEntered

    private void btnHidrometroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHidrometroMouseExited
        btnHidrometro.setBackground(Color.white);
    }//GEN-LAST:event_btnHidrometroMouseExited

    private void btnHidrometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHidrometroActionPerformed
//        new HistoricoHidrometroGestorView().setVisible(true);
//        dispose();
    }//GEN-LAST:event_btnHidrometroActionPerformed

    private void btnUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnUsuariosKeyPressed

    }//GEN-LAST:event_btnUsuariosKeyPressed

    private void btnUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMousePressed
        // Exibe uma mensagem informando que o gestor não tem acesso a este campo

        JOptionPane.showMessageDialog(null, "Acesso Negado: Você não tem permissão para acessar este campo.", "Erro", JOptionPane.ERROR_MESSAGE);
        btnUsuarios.setEnabled(false);

    }//GEN-LAST:event_btnUsuariosMousePressed

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
                new MenuGestorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarDados;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnDefinicoes;
    private javax.swing.JButton btnFacturacao;
    private javax.swing.JButton btnGestaoInterna;
    private javax.swing.JButton btnHidrometro;
    private javax.swing.JButton btnLeituras;
    private javax.swing.JButton btnRecebimentos;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton btnTeam;
    private javax.swing.JButton btnTerminarSeccao;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel lblEmaildeeAcesso;
    private javax.swing.JLabel lblIconPag;
    private javax.swing.JLabel lblIconRec;
    private javax.swing.JLabel lblIconSituacao;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblPerfilAcesso;
    private javax.swing.JLabel lblSituacaoMes;
    private javax.swing.JLabel lblTotalPagamentosMes;
    private javax.swing.JLabel lblTotalRecebimentosMes;
    private javax.swing.JPanel painelBotoesSairVoltar;
    private javax.swing.JPanel painelCentralDireito;
    private javax.swing.JPanel painelCentralDireitoBotoesMenu;
    private javax.swing.JPanel painelDadosUtilizador;
    private javax.swing.JPanel painelDashboard;
    private javax.swing.JPanel painelEsquerdo;
    private javax.swing.JPanel painelPagTotalMes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelRecTotalMes;
    private javax.swing.JPanel painelSituacaoMes;
    // End of variables declaration//GEN-END:variables
}
