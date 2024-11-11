/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author lenovo
 */
public class RelatoriosView extends javax.swing.JFrame {

    /**
     * Creates new form Relatorios
     */
    public RelatoriosView() {
        initComponents();
        showPieChart();
        showLineChart();
        showBarChart();
        showHistogram();
    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        barDataset.setValue("Albazine", new Double(40));
        barDataset.setValue("Guava", new Double(20));
        barDataset.setValue("CMC", new Double(40));

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Consumo por Bairro", barDataset, false, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        piePlot.setSectionPaint("Albazine", new Color(255, 255, 102));
        piePlot.setSectionPaint("Guava", new Color(102, 255, 102));
        piePlot.setSectionPaint("CMC", new Color(255, 102, 153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0, 204, 204));

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }

    public void showLineChart() {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");

        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("contribution", "monthly", "amount",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
//        Color lineChartColor = new Color(204, 0, 51);
        Color lineChartColor = new Color(0, 120, 215);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }

    public void showBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");

        JFreeChart chart = ChartFactory.createBarChart("contribution", "monthly", "amount",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
//        categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(0, 85, 86);
//        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barpChartPanel = new ChartPanel(chart);
        chartPanel.removeAll();
        chartPanel.add(barpChartPanel, BorderLayout.CENTER);
        chartPanel.validate();
    }

    public void showHistogram() {

        double[] values = {95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
            77, 44, 58, 91, 10, 67, 57, 19, 88, 84
        };

        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 20);

        JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram", "Data", "Frequency", dataset, PlotOrientation.VERTICAL, false, true, false);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);

        ChartPanel barpChartPanel2 = new ChartPanel(chart);
//        painelHistograma.removeAll();
//        painelHistograma.add(barpChartPanel2, BorderLayout.CENTER);
//        painelHistograma.validate();
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
        painelConteudo = new javax.swing.JPanel();
        painelConteudoEsquerdo = new javax.swing.JPanel();
        lblIconLogo = new javax.swing.JLabel();
        painelVoltarMenu = new javax.swing.JPanel();
        btnVoltarMenu = new javax.swing.JButton();
        lblCabecalho = new javax.swing.JLabel();
        painelContCentral = new javax.swing.JPanel();
        painelSuperio = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();
        chartPanel = new javax.swing.JPanel();
        panelLineChart = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();
        lblIconPag = new javax.swing.JLabel();
        lblTotalPagamentosMes = new javax.swing.JLabel();
        lblIconRec = new javax.swing.JLabel();
        lblTotalRecebimentosMes = new javax.swing.JLabel();
        lblIconSituacao = new javax.swing.JLabel();
        lblSituacaoMes = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatorios");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(1285, 680));
        setPreferredSize(new java.awt.Dimension(1285, 680));

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(1260, 720));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setLayout(new java.awt.BorderLayout(10, 10));

        painelConteudoEsquerdo.setBackground(new java.awt.Color(52, 102, 138));
        painelConteudoEsquerdo.setLayout(new java.awt.BorderLayout());

        lblIconLogo.setBackground(new java.awt.Color(52, 102, 138));
        lblIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_combo_chart_256px.png"))); // NOI18N
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

        painelSuperio.setBackground(new java.awt.Color(255, 255, 255));
        painelSuperio.setPreferredSize(new java.awt.Dimension(994, 600));

        panelBarChart.setLayout(new java.awt.BorderLayout());

        chartPanel.setLayout(new java.awt.BorderLayout());

        panelLineChart.setLayout(new java.awt.BorderLayout());

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ussene", "Polana", "120"},
                {"Ussene", "Polana", "120"},
                {"Ussene", "Polana", "120"},
                {null, null, null}
            },
            new String [] {
                "Nome do Clinte", "Bairro", "Consumo m3"
            }
        ));
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(0, 85, 86));
        rSTableMetro1.setColorBordeFilas(new java.awt.Color(0, 85, 86));
        rSTableMetro1.setColorBordeHead(new java.awt.Color(0, 85, 86));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setColorFilasForeground1(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(rSTableMetro1);
        if (rSTableMetro1.getColumnModel().getColumnCount() > 0) {
            rSTableMetro1.getColumnModel().getColumn(0).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(1).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(2).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        lblIconPag.setBackground(new java.awt.Color(0, 0, 204));
        lblIconPag.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIconPag.setForeground(new java.awt.Color(204, 51, 0));
        lblIconPag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconPag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_hongkong_dollar_64px.png"))); // NOI18N
        lblIconPag.setText("Pagamentos do mes:");
        lblIconPag.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIconPag.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblTotalPagamentosMes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalPagamentosMes.setForeground(new java.awt.Color(153, 0, 0));
        lblTotalPagamentosMes.setText("00.00");

        lblIconRec.setBackground(new java.awt.Color(0, 0, 204));
        lblIconRec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIconRec.setForeground(new java.awt.Color(0, 51, 153));
        lblIconRec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconRec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/pagamento.png"))); // NOI18N
        lblIconRec.setText("Recebimentos do Mes:");
        lblIconRec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIconRec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblTotalRecebimentosMes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalRecebimentosMes.setForeground(new java.awt.Color(0, 51, 153));
        lblTotalRecebimentosMes.setText("00.00");

        lblIconSituacao.setBackground(new java.awt.Color(0, 0, 204));
        lblIconSituacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIconSituacao.setForeground(new java.awt.Color(67, 160, 71));
        lblIconSituacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconSituacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icons8_money_bag_64px.png"))); // NOI18N
        lblIconSituacao.setText("Situação do mes:");
        lblIconSituacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIconSituacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblSituacaoMes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSituacaoMes.setForeground(new java.awt.Color(67, 160, 71));
        lblSituacaoMes.setText("00.00");

        javax.swing.GroupLayout painelSuperioLayout = new javax.swing.GroupLayout(painelSuperio);
        painelSuperio.setLayout(painelSuperioLayout);
        painelSuperioLayout.setHorizontalGroup(
            painelSuperioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelSuperioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIconPag, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalPagamentosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(painelSuperioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalRecebimentosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIconRec))
                .addGap(24, 24, 24)
                .addGroup(painelSuperioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSituacaoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIconSituacao))
                .addGap(677, 677, 677))
            .addGroup(painelSuperioLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelSuperioLayout.setVerticalGroup(
            painelSuperioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBarChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addComponent(chartPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(painelSuperioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperioLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelSuperioLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(painelSuperioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelSuperioLayout.createSequentialGroup()
                                .addComponent(lblIconRec)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotalRecebimentosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelSuperioLayout.createSequentialGroup()
                                .addComponent(lblIconSituacao)
                                .addGap(18, 18, 18)
                                .addComponent(lblSituacaoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelSuperioLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(lblTotalPagamentosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblIconPag))))
                .addGap(98, 98, 98))
        );

        painelContCentral.add(painelSuperio, java.awt.BorderLayout.CENTER);

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
        btnVoltarMenu.setBackground(new Color(52,102,138));
    }//GEN-LAST:event_btnVoltarMenuMouseExited

    private void btnVoltarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMenuMouseClicked
        btnVoltarMenu.setBackground(new Color(52,102,138));
    }//GEN-LAST:event_btnVoltarMenuMouseClicked

    private void btnVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMenuActionPerformed
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltarMenu;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblIconLogo;
    private javax.swing.JLabel lblIconPag;
    private javax.swing.JLabel lblIconRec;
    private javax.swing.JLabel lblIconSituacao;
    private javax.swing.JLabel lblSituacaoMes;
    private javax.swing.JLabel lblTotalPagamentosMes;
    private javax.swing.JLabel lblTotalRecebimentosMes;
    private javax.swing.JPanel painelContCentral;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelConteudoEsquerdo;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelSuperio;
    private javax.swing.JPanel painelVoltarMenu;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelLineChart;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    // End of variables declaration//GEN-END:variables
}
