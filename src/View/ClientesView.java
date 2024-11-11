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
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        listarClientes();
//        testData(tabelaClientes);
//        getContentPane().setBackground(Color.white);
//        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);

// Dentro do método de inicialização da interface, certifique-se de que o cbxDespesasIniciais esteja corretamente configurado
        cbxDespesasIniciais.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

    }

    private void testData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
    }

    private void AccaoComboxDespesas() {
        if (cbxDespesasIniciais.getSelectedIndex() == 0) {
            txtSaldo.setText(null);
            return;
        }
        try {
            if (cbxDespesasIniciais.getSelectedIndex() == 1) {
                txtSaldo.setText("" + 0);
            } else if (cbxDespesasIniciais.getSelectedIndex() == 2) {
                txtSaldo.setText("" + 3000);
            } else {
                txtSaldo.setText("" + 8000);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Clientes View prencher saldo" + erro);
        }
    }

    //Metodo Cadastrar
    private void cadastrarCliente() {

        String nome = txtNome.getText().trim();
        String bairro = cbxBairro.getSelectedItem().toString();
        String quarteiraoText = txtQuarterao.getText().trim();
        String nr = txtNumeroDeCasa.getText().trim();

        Date selectedDate = dateChooserDataContracto.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = dateFormat.format(selectedDate);

        String email = txtEmailParticular.getText().trim();
        String nrTel = TxtNumeroDeTelefone.getText().trim();
        int nrtelefone = Integer.parseInt(nrTel);
        int nrDaCasa = Integer.parseInt(nr);
        int quarteirao = Integer.parseInt(quarteiraoText);
        double saldo = Double.parseDouble(txtSaldo.getText());
        boolean disponibilidade = true;
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

        // Criar o modelo de cliente
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setNome(nome);
        clienteModel.setBairro(bairro);
        clienteModel.setQuarteirao(quarteirao);
        clienteModel.setNrDaCasa(nrDaCasa);
        clienteModel.setDataContracto(data);
        clienteModel.setEmail(email);
        clienteModel.setNrTelefone(nrtelefone);
        clienteModel.setSaldo(saldo);
        clienteModel.setStatus(status);
        clienteModel.setDisp(disponibilidade);

        ClienteController clienteControler = new ClienteController();
        clienteControler.cadastrarCliente(clienteModel);
    }

    //Metodo Actualizar Cliente
    private void ActualizarCliente() {
        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText().trim();
        String bairro = cbxBairro.getSelectedItem().toString();
        String quarteiraoText = txtQuarterao.getText().trim();
        String nr = txtNumeroDeCasa.getText().trim();

        Date selectedDate = dateChooserDataContracto.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = dateFormat.format(selectedDate);

        String email = txtEmailParticular.getText().trim();
        String nrTel = TxtNumeroDeTelefone.getText().trim();
        double saldo = Double.parseDouble(txtSaldo.getText());
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
        clienteModel.setSaldo(saldo);
        clienteModel.setStatus(status);
        clienteModel.setDisp(disponibilidade);

        ClienteController clienteControler = new ClienteController();
        clienteControler.ActualizarCliente(clienteModel);
    }

    //Metodo Apagar Cliente
    private void ApagarCliente() {
        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText().trim();
        String bairro = cbxBairro.getSelectedItem().toString();
        String quarteiraoText = txtQuarterao.getText().trim();
        String nr = txtNumeroDeCasa.getText().trim();

        Date selectedDate = dateChooserDataContracto.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = dateFormat.format(selectedDate);

        String email = txtEmailParticular.getText().trim();
        String nrTel = TxtNumeroDeTelefone.getText().trim();
        double saldo = Double.parseDouble(txtSaldo.getText());
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
        clienteModel.setSaldo(saldo);
        clienteModel.setStatus(status);
        clienteModel.setDisp(disponibilidade);

        ClienteController clienteControler = new ClienteController();
        clienteControler.ActualizarCliente(clienteModel);

        JOptionPane.showMessageDialog(null, "Cliente apagado com sucesso");
    }

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
                    item.getSaldo(),
                    item.getStatus(),
                    item.getDisp() // Verifique se este campo existe no modelo
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + erro.getMessage());
        }
    }

    //Metodo Prencher Campos obrigatorios
    private boolean camposObrigatoriosPreenchidos() {
        boolean nomePreenchido = !txtNome.getText().isEmpty();
        boolean apelidoPreenchido = !txtEmailParticular.getText().isEmpty();
        boolean nomeUauario = !txtNumeroDeCasa.getText().isEmpty();
        boolean senhaUsuario = !txtQuarterao.getText().isEmpty();

        return nomePreenchido && apelidoPreenchido && nomeUauario && senhaUsuario;
    }

    //Metodo Carregar Campos
    private void CarregarCampos() {
        int setar = tabelaClientes.getSelectedRow();

        txtId.setText(tabelaClientes.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tabelaClientes.getModel().getValueAt(setar, 1).toString());
        cbxBairro.setSelectedItem(tabelaClientes.getModel().getValueAt(setar, 2).toString());
        txtQuarterao.setText(tabelaClientes.getModel().getValueAt(setar, 3).toString());
        txtNumeroDeCasa.setText(tabelaClientes.getModel().getValueAt(setar, 4).toString());
        
        // Carregar data de contracto no JDateChooser
        Object dataContractoObj = tabelaClientes.getModel().getValueAt(setar, 5);
        if (dataContractoObj != null) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date dataContracto = null;
            try {
                dataContracto = formatador.parse(dataContractoObj.toString());
            } catch (ParseException ex) {
                Logger.getLogger(ClientesView.class.getName()).log(Level.SEVERE, null, ex);
            }
            dateChooserDataContracto.setDate(dataContracto);
        }
        
        txtEmailParticular.setText(tabelaClientes.getModel().getValueAt(setar, 6).toString());
        TxtNumeroDeTelefone.setText(tabelaClientes.getModel().getValueAt(setar, 7).toString());;
        txtSaldo.setText(tabelaClientes.getModel().getValueAt(setar, 8).toString());
        cbxStatus.setSelectedItem(tabelaClientes.getModel().getValueAt(setar, 9).toString());
    }

    //Metodo Limpar Campos
    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtQuarterao.setText("");
        txtNumeroDeCasa.setText("");
        dateChooserDataContracto.setDate(null);
        txtEmailParticular.setText("");
        TxtNumeroDeTelefone.setText("");
        cbxDespesasIniciais.setSelectedIndex(0);
        cbxBairro.setSelectedIndex(0);
        cbxStatus.setSelectedIndex(0);
        txtSaldo.setText("");
        txtNome.requestFocus();
        System.out.println("Campos Limpos");
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
        lblIconLogo = new javax.swing.JLabel();
        painelVoltarMenu = new javax.swing.JPanel();
        btnVoltarMenu = new javax.swing.JButton();
        lblCabecalho1 = new javax.swing.JLabel();
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
        TxtNumeroDeTelefone = new javax.swing.JTextField();
        dateChooserDataContracto = new com.toedter.calendar.JDateChooser();
        painelDirDados = new javax.swing.JPanel();
        lbDespesasIniciais = new javax.swing.JLabel();
        lbSaldo = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        cbxDespesasIniciais = new javax.swing.JComboBox<>();
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

        lblIconLogo.setBackground(new java.awt.Color(52, 102, 138));
        lblIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/social-media.png"))); // NOI18N
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

        lblCabecalho1.setBackground(new java.awt.Color(52, 102, 138));
        lblCabecalho1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblCabecalho1.setForeground(new java.awt.Color(255, 255, 255));
        lblCabecalho1.setText("Voltar");
        painelVoltarMenu.add(lblCabecalho1);

        painelConteudoEsquerdo.add(painelVoltarMenu, java.awt.BorderLayout.NORTH);

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

        cbxBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "CMC", "Albasine" }));
        cbxBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBairroActionPerformed(evt);
            }
        });

        jLabel2.setText("Quarteirao:");

        txtQuarterao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuarteraoActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
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
                .addGap(12, 12, 12)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addGap(109, 109, 109)
                        .addComponent(txtNome))
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(lbEmailParticular)
                        .addGap(65, 65, 65)
                        .addComponent(txtEmailParticular))
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addComponent(lbNumeroDeTelefone)
                        .addGap(34, 34, 34)
                        .addComponent(TxtNumeroDeTelefone))
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                .addComponent(lbId)
                                .addGap(137, 137, 137)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                .addComponent(lbBairro)
                                .addGap(111, 111, 111)
                                .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9)
                                .addComponent(txtQuarterao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNumeroDaCasa)
                                    .addComponent(lblDataDeContrato))
                                .addGap(51, 51, 51)
                                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroDeCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooserDataContracto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addGap(79, 79, 79))
        );
        painelEsqDadosLayout.setVerticalGroup(
            painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsqDadosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtQuarterao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumeroDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroDeCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataDeContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserDataContracto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEmailParticular, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailParticular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEsqDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEsqDadosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbNumeroDeTelefone))
                    .addComponent(TxtNumeroDeTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        painelSuperiorDados.add(painelEsqDados);

        painelDirDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDirDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 43, 64)));

        lbDespesasIniciais.setText("Despesas Iniciais:*");

        lbSaldo.setText("Saldo:");

        lbStatus.setText("Activo:*");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Nao" }));

        cbxDespesasIniciais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Sem despesa", "Ligacao", "Instalacao + Ligacao" }));
        cbxDespesasIniciais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDespesasIniciaisActionPerformed(evt);
            }
        });

        txtSaldo.setEditable(false);
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
                        .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDespesasIniciais)
                            .addComponent(lbSaldo))
                        .addGap(47, 47, 47)
                        .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxDespesasIniciais, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaldo))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        painelDirDadosLayout.setVerticalGroup(
            painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDirDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDespesasIniciais)
                    .addComponent(cbxDespesasIniciais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDirDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSaldo)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbStatus)
                .addGap(18, 18, 18)
                .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        painelDirDadosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbDespesasIniciais, lbSaldo});

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
                "Id", "Nome", "Bairro", "Quarteirao", "Numero da Casa", "Data de Contrato", "Email Particular", "Numero de Telefone", "Saldo", "Status", "Disp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ApagarCliente();
        listarClientes();
        limparCampos();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (camposObrigatoriosPreenchidos()) {
            cadastrarCliente();
            listarClientes();
//        limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos campos Obrigatorios!");
        }
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

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ActualizarCliente();
        listarClientes();
        limparCampos();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbxDespesasIniciaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDespesasIniciaisActionPerformed
        AccaoComboxDespesas();
    }//GEN-LAST:event_cbxDespesasIniciaisActionPerformed

    private void btnVoltarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenuMouseClicked
        btnVoltarMenu.setBackground(new Color(52, 102, 138));
    }//GEN-LAST:event_btnVoltarMenuMouseClicked

    private void btnVoltarMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenuMouseEntered
        btnVoltarMenu.setBackground(new Color(45, 45, 45));
    }//GEN-LAST:event_btnVoltarMenuMouseEntered

    private void btnVoltarMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenuMouseExited
        btnVoltarMenu.setBackground(new Color(52, 102, 138));
    }//GEN-LAST:event_btnVoltarMenuMouseExited

    private void btnVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMenuActionPerformed
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarMenuActionPerformed

    private void cbxBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxBairroActionPerformed

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
    private com.toedter.calendar.JDateChooser dateChooserDataContracto;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbDespesasIniciais;
    private javax.swing.JLabel lbEmailParticular;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumeroDaCasa;
    private javax.swing.JLabel lbNumeroDeTelefone;
    private javax.swing.JLabel lbSaldo;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblCabecalho1;
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
    private javax.swing.JPanel painelVoltarMenu;
    private javax.swing.JPanel tabela;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtEmailParticular;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeAPesquisar;
    private javax.swing.JTextField txtNumeroDeCasa;
    private javax.swing.JTextField txtQuarterao;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
