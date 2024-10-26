package View;

import Controller.ClienteController;
import Controller.FuncionarioController;
import Model.ClienteModel;
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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class ClientesView extends javax.swing.JFrame {

    public ClientesView() {
        initComponents();
        testData(tabelaClientes);
        listarClientes();
        getContentPane().setBackground(Color.white);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);

    }
    
        private void testData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
//       
    }

    //Metodo Cadastrar
    private void cadastrarCliente() {

        String nome = txtNome.getText().trim();
        String bairro = cbxBairro.getSelectedItem().toString();
        String quarteiraoText = txtQuarterao.getText().trim();
        String nr = txtNumeroDeCasa.getText().trim();
        String data = txtDataDeContrato.getText().trim();
        String email = txtEmailParticular.getText().trim();
        String nrTel = TxtNumeroDeTelefone.getText().trim();
        boolean status;
        if (cbxStatus.getItemAt(0) == "Sim") {
            status = true;

        } else {
            status = false;
        }
        // Verificações de campos
        if (nome.isEmpty() || !nome.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }
        if (bairro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bairro inválido.");
            return;
        }
        if (quarteiraoText.isEmpty() || !quarteiraoText.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Quarteirão inválido.");
            return;
        }
        if (nr.isEmpty() || !nr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Número da casa inválido.");
            return;
        }
        if (email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Email inválido.");
            return;
        }
        if (nrTel.isEmpty() || !nrTel.matches("(21|82|83|84|85|86|87)\\d{7}")) {
            JOptionPane.showMessageDialog(null, "Telefone inválido.");
            return;
        }

        // Conversão de valores numéricos com tratamento de exceção
        int nrtelefone;
        int nrDaCasa;
        int quarteirao;
//        double saldo;
        try {
            nrtelefone = Integer.parseInt(nrTel);
            nrDaCasa = Integer.parseInt(nr);
            quarteirao = Integer.parseInt(quarteiraoText);
//            saldo = Double.parseDouble(txtSaldo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter número de telefone, número da casa, quarteirão ou saldo.");
            return;
        }

        // Define o número do hidrômetro
        String nrHidrometro = quarteirao + "/" + nrDaCasa;
        txtNumeroDeHidrometro.setText(nrHidrometro);
        // Define o saldo automaticamente
        double saldo = Double.parseDouble(txtSaldo.getText());
        txtSaldo.setText(String.valueOf(saldo));
        boolean disponibilidade = true;

//        // Status: Verifica o item selecionado corretamente
//        boolean status = cbxStatus.getSelectedItem().toString().equalsIgnoreCase("Activo");

        // Criar o modelo de cliente
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setNome(nome);
        clienteModel.setBairro(bairro);
        clienteModel.setQuarteirao(quarteirao);
        clienteModel.setNrDaCasa(nrDaCasa);
        clienteModel.setDataContracto(data);
        clienteModel.setEmail(email);
        clienteModel.setNrTelefone(nrtelefone);
//        clienteModel.setHidrometro(nrHidrometro);
        clienteModel.setConsumo(0); // Consumo inicial
        clienteModel.setSaldo(saldo);
        clienteModel.setStatus(status);
        clienteModel.setDisp(disponibilidade);
        
        

        // Cadastrar cliente através do controlador
        ClienteController clienteControler = new ClienteController();
        clienteControler.cadastrarCliente(clienteModel);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        listarClientes();
    }

<<<<<<< Updated upstream
=======
    //Metodo Actualizar Cliente
    private void ActualizarCliente() {
        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText().trim();
        String bairro = cbxBairro.getSelectedItem().toString();
        String quarteiraoText = txtQuarterao.getText().trim();
        String nr = txtNumeroDeCasa.getText().trim();
        String data = txtDataDeContrato.getText().trim();
        String email = txtEmailParticular.getText().trim();
        String nrTel = TxtNumeroDeTelefone.getText().trim();
        String cons = txtConsumo.getText();
        boolean status;
        if (cbxStatus.getItemAt(0) == "Sim") {
            status = true;

        } else {
            status = false;
        }

        // Verificações
        if (nome.isEmpty() || !nome.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }
        if (bairro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bairro inválido.");
            return;
        }
        if (quarteiraoText.isEmpty() || !quarteiraoText.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Quarteirão inválido.");
            return;
        }
        int quarteirao = Integer.parseInt(quarteiraoText);
        if (nr.isEmpty() || !nr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Número da casa inválido.");
            return;
        }
        int nrDaCasa = Integer.parseInt(nr);

        if (email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Email inválido.");
            return;
        }
        if (nrTel.isEmpty() || !nrTel.matches("(21|82|83|84|85|86|87)\\d{7}")) {
            JOptionPane.showMessageDialog(null, "Telefone inválido.");
            return;
        }
        int nrtelefone = Integer.parseInt(nrTel);

        double consumo = Double.parseDouble(cons);

        // Define o número do hidrômetro
        String nrHidrometro = quarteirao + "/" + nrDaCasa;
        txtNumeroDeHidrometro.setText(nrHidrometro);

        // Define o saldo automaticamente
        double saldo;
        if (cbxDespesasIniciais.getSelectedItem().toString().equals("Ligação")) {
            saldo = 3000;
        } else {
            saldo = 8000;
        }
        txtSaldo.setText(String.valueOf(saldo));
        boolean disponibilidade = true;

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setIdCliente(id);
        clienteModel.setNome(nome);
        clienteModel.setBairro(bairro);
        clienteModel.setQuarteirao(quarteirao);
        clienteModel.setNrDaCasa(nrDaCasa);
        clienteModel.setDataContracto(data);
        clienteModel.setEmail(email);
        clienteModel.setNrTelefone(nrtelefone);
//        clienteModel.setHidrometro(nrHidrometro);
        clienteModel.setConsumo(consumo);
        clienteModel.setSaldo(saldo);
        clienteModel.setStatus(status);
        clienteModel.setDisp(disponibilidade);

        ClienteController clienteControler = new ClienteController();
        clienteControler.ActualizarCliente(clienteModel);

        JOptionPane.showMessageDialog(null, "Cliente actualizado com sucesso");
    }

    //Metodo Apagar Cliente
    private void ApagarCliente() {

        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText().trim();
        String bairro = cbxBairro.getSelectedItem().toString();
        String quarteiraoText = txtQuarterao.getText().trim();
        String nr = txtNumeroDeCasa.getText().trim();
        String data = txtDataDeContrato.getText().trim();
        String email = txtEmailParticular.getText().trim();
        String nrTel = TxtNumeroDeTelefone.getText().trim();
        String cons = txtConsumo.getText();
        boolean status;
        if (cbxStatus.getItemAt(0) == "Sim") {
            status = true;

        } else {
            status = false;
        }

        // Verificações
        if (nome.isEmpty() || !nome.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }
        if (bairro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bairro inválido.");
            return;
        }
        if (quarteiraoText.isEmpty() || !quarteiraoText.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Quarteirão inválido.");
            return;
        }
        int quarteirao = Integer.parseInt(quarteiraoText);
        if (nr.isEmpty() || !nr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Número da casa inválido.");
            return;
        }
        int nrDaCasa = Integer.parseInt(nr);

        if (email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Email inválido.");
            return;
        }
        if (nrTel.isEmpty() || !nrTel.matches("(21|82|83|84|85|86|87)\\d{7}")) {
            JOptionPane.showMessageDialog(null, "Telefone inválido.");
            return;
        }
        int nrtelefone = Integer.parseInt(nrTel);

        double consumo = Double.parseDouble(cons);

        // Define o número do hidrômetro
        String nrHidrometro = quarteirao + "/" + nrDaCasa;
        txtNumeroDeHidrometro.setText(nrHidrometro);

        // Define o saldo automaticamente
        double saldo;
        if (cbxDespesasIniciais.getSelectedItem().toString().equals("Ligação")) {
            saldo = 3000;
        } else {
            saldo = 8000;
        }
        txtSaldo.setText(String.valueOf(saldo));
        boolean disponibilidade = false;

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setIdCliente(id);
        clienteModel.setNome(nome);
        clienteModel.setBairro(bairro);
        clienteModel.setQuarteirao(quarteirao);
        clienteModel.setNrDaCasa(nrDaCasa);
        clienteModel.setDataContracto(data);
        clienteModel.setEmail(email);
        clienteModel.setNrTelefone(nrtelefone);
//        clienteModel.setHidrometro(nrHidrometro);
        clienteModel.setConsumo(consumo);
        clienteModel.setSaldo(saldo);
        clienteModel.setStatus(status);
        clienteModel.setDisp(disponibilidade);

        ClienteController clienteControler = new ClienteController();
        clienteControler.ActualizarCliente(clienteModel);

        JOptionPane.showMessageDialog(null, "Cliente apagado com sucesso");
    }

>>>>>>> Stashed changes
    //Metodo para Listar Clientes
    private void listarClientes() {
        try {
            ClienteController clienteController = new ClienteController();

            DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
            model.setRowCount(0); // Limpar a tabela antes de listar novamente

//            tabelaClientes.setModel(model);



            ArrayList<ClienteModel> lista = clienteController.PesquisarCliente();
             System.out.println("Clientes encontrados: " + lista.size());
             System.out.println(lista.isEmpty());


            // Preencher a tabela com os dados dos clientes
            for (ClienteModel item : lista) {
                model.addRow(new Object[]{
                    item.getIdCliente(),
                    item.getNome(),
                    item.getBairro(),
                    item.getQuarteirao(), // Certifique-se de usar o índice correto
                    item.getNrDaCasa(), // Certifique-se de usar o índice correto
                    item.getDataContracto(),
                    item.getEmail(),
                    item.getNrTelefone(),
//                    item.getHidrometro(),
                    item.getConsumo(),
                    item.getSaldo(),
                    item.getStatus(),
                    item.getDisp() // Verifique se este campo existe no modelo
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + erro.getMessage());
        }
    }

    private void AccaoComboxDespesas() {
        if (cbxDespesasIniciais.getSelectedIndex() == 0) {
            txtNome.setText(null);
            txtSaldo.setText(null);

            return;
        }
        try {
            int setar = tabelaClientes.getSelectedRow();
            if (cbxDespesasIniciais.getSelectedItem().toString().equals("Ligação")) {
                txtSaldo.setText(String.valueOf(3000));
            } else if (cbxDespesasIniciais.getSelectedItem().toString().equals("Instalação + Ligaçao")) {
                txtSaldo.setText(String.valueOf(8000));
            } else {
                txtSaldo.setText("" + 0);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Clientes View prencher saldo" + erro);
        }
    }

    //Metodo Carregar Campos
    private void CarregarCampos() {
        int setar = tabelaClientes.getSelectedRow();

        txtId.setText(tabelaClientes.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tabelaClientes.getModel().getValueAt(setar, 1).toString());
        cbxBairro.setSelectedItem(tabelaClientes.getModel().getValueAt(setar, 2).toString());
        txtQuarterao.setText(tabelaClientes.getModel().getValueAt(setar, 3).toString());
        txtNumeroDeCasa.setText(tabelaClientes.getModel().getValueAt(setar, 4).toString());
        txtDataDeContrato.setText(tabelaClientes.getModel().getValueAt(setar, 5).toString());
        txtEmailParticular.setText(tabelaClientes.getModel().getValueAt(setar, 6).toString());
        TxtNumeroDeTelefone.setText(tabelaClientes.getModel().getValueAt(setar, 7).toString());
        txtNumeroDeHidrometro.setText(tabelaClientes.getModel().getValueAt(setar, 8).toString());
        txtConsumo.setText(tabelaClientes.getModel().getValueAt(setar, 9).toString());
        txtSaldo.setText(tabelaClientes.getModel().getValueAt(setar, 10).toString());
        cbxStatus.setSelectedItem(tabelaClientes.getModel().getValueAt(setar, 11).toString());
    }

    //Metodo Limpar Campos
    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtQuarterao.setText("");
        txtNumeroDeCasa.setText("");
        txtDataDeContrato.setText("");
        txtEmailParticular.setText("");
        TxtNumeroDeTelefone.setText("");
        txtNumeroDeHidrometro.setText("");
        txtConsumo.setText("");
        cbxDespesasIniciais.setSelectedIndex(0);
        cbxBairro.setSelectedIndex(0);
        cbxStatus.setSelectedIndex(0);
        txtSaldo.setText("");
        txtNome.requestFocus();
        System.out.println("Campos Limpos");
    }

//    private void testData(JTable table) {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
////       
//    }

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
        lbNumeroDeTelefone = new javax.swing.JLabel();
        txtEmailParticular = new javax.swing.JTextField();
        TxtNumeroDeTelefone = new javax.swing.JTextField();
        txtData = new rojeru_san.componentes.RSDateChooser();
        txtDataDeContrato = new javax.swing.JTextField();
        painelDirDados = new javax.swing.JPanel();
        lbNumeroDeHidrometro = new javax.swing.JLabel();
        txtNumeroDeHidrometro = new javax.swing.JTextField();
        lbDespesasIniciais = new javax.swing.JLabel();
        lbConsumo = new javax.swing.JLabel();
        lbSaldo = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        cbxDespesasIniciais = new javax.swing.JComboBox<>();
        txtConsumo = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        painelInferiorBotoesTabela = new javax.swing.JPanel();
        tabela = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1090, Short.MAX_VALUE)
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
        btnVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarMenuActionPerformed(evt);
            }
        });
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
        painelEsqDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbId.setText("Id:");
        painelEsqDados.add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, -1, 22));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        painelEsqDados.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 14, 82, -1));

        lbNome.setText("Nome:*");
        painelEsqDados.add(lbNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 54, -1, 22));

        lbBairro.setText("Bairro:*");
        painelEsqDados.add(lbBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 94, -1, 22));

        lbNumeroDaCasa.setText("Numero da Casa:*");
        painelEsqDados.add(lbNumeroDaCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 134, -1, 22));

        lblDataDeContrato.setText("Data do Contrato:*");
        painelEsqDados.add(lblDataDeContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 174, -1, 22));
        painelEsqDados.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 54, 350, -1));

        lbEmailParticular.setText("Email Particular:");
        painelEsqDados.add(lbEmailParticular, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 254, -1, 22));

        cbxBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "CMC" }));
        painelEsqDados.add(cbxBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 94, -1, -1));

        jLabel2.setText("Quarteirao:");
        painelEsqDados.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 97, -1, -1));

        txtQuarterao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuarteraoActionPerformed(evt);
            }
        });
        painelEsqDados.add(txtQuarterao, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 94, 70, -1));
        painelEsqDados.add(txtNumeroDeCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 134, 91, -1));

        lbNumeroDeTelefone.setText("Numero de Telefone:*");
        painelEsqDados.add(lbNumeroDeTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 297, -1, -1));
        painelEsqDados.add(txtEmailParticular, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 254, 360, -1));
        painelEsqDados.add(TxtNumeroDeTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 294, 360, -1));
        painelEsqDados.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 340, 20));
        painelEsqDados.add(txtDataDeContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, -1));

        painelSuperiorDados.add(painelEsqDados);

        painelDirDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDirDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 43, 64)));

        lbNumeroDeHidrometro.setText("Numero de Hidrometro:*");

        txtNumeroDeHidrometro.setEditable(false);
        txtNumeroDeHidrometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeHidrometroActionPerformed(evt);
            }
        });

        lbDespesasIniciais.setText("Despesas Iniciais:*");

        lbConsumo.setText("Consumo:");

        lbSaldo.setText("Saldo:");

        lbStatus.setText("Activo:*");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Nao" }));

        cbxDespesasIniciais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Sem despesa", "Ligacao", "Instalacao + Ligacao" }));
        cbxDespesasIniciais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDespesasIniciaisActionPerformed(evt);
            }
        });

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
                    .addGroup(painelDirDadosLayout.createSequentialGroup()
                        .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbStatus)
                            .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(513, 513, 513))
                    .addGroup(painelDirDadosLayout.createSequentialGroup()
                        .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumeroDeHidrometro)
                            .addComponent(lbDespesasIniciais)
                            .addComponent(lbConsumo)
                            .addComponent(lbSaldo))
                        .addGap(18, 18, 18)
                        .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldo)
                            .addGroup(painelDirDadosLayout.createSequentialGroup()
                                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNumeroDeHidrometro)
                                        .addComponent(cbxDespesasIniciais, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(79, 79, 79))))
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
                .addContainerGap(156, Short.MAX_VALUE))
        );

        painelDirDadosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbConsumo, lbDespesasIniciais, lbNumeroDeHidrometro, lbSaldo});

        painelSuperiorDados.add(painelDirDados);

        painelContCentral.add(painelSuperiorDados, java.awt.BorderLayout.PAGE_START);

        painelInferiorBotoesTabela.setBackground(new java.awt.Color(255, 255, 255));
        painelInferiorBotoesTabela.setLayout(new java.awt.BorderLayout());

        tabela.setBackground(new java.awt.Color(255, 255, 255));
        tabela.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(0, 102, 102));

        tabelaClientes.setAutoCreateRowSorter(true);
        tabelaClientes.setForeground(new java.awt.Color(51, 51, 51));
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Bairro", "Quarteirao", "Numero da Casa", "Data de Contrato", "Email Particular", "Numero de Telefone", "Consumo", "Saldo", "Status", "Disp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.setShowGrid(true);
        jScrollPane2.setViewportView(tabelaClientes);

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

    private void txtNumeroDeHidrometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeHidrometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeHidrometroActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cadastrarCliente();
        listarClientes();
        limparCampos();
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

    private void txtConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsumoActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void btnVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMenuActionPerformed
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarMenuActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbxDespesasIniciaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDespesasIniciaisActionPerformed
        AccaoComboxDespesas();
    }//GEN-LAST:event_cbxDespesasIniciaisActionPerformed

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
                new ClientesView().setVisible(true);
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
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbConsumo;
    private javax.swing.JLabel lbDespesasIniciais;
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
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtConsumo;
    private rojeru_san.componentes.RSDateChooser txtData;
    private javax.swing.JTextField txtDataDeContrato;
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
