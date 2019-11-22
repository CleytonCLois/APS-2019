/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AgendaController;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dinopc
 */
public class Agenda extends javax.swing.JFrame {

    private final AgendaController controller;

    /**
     * Creates new form Agenda
     */
    public Agenda() {
        initComponents();
        controller = new AgendaController(this);
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InputValor = new javax.swing.JTextField();
        InputHorario = new javax.swing.JFormattedTextField();
        Button1 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        Button = new java.awt.Button();
        SelectTipo = new javax.swing.JComboBox<String>();
        SelectCliente = new javax.swing.JComboBox<String>();
        InputData = new javax.swing.JFormattedTextField();
        TxtObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InputObservacao = new javax.swing.JTextArea();
        TxtHorario = new javax.swing.JLabel();
        TxtData = new javax.swing.JLabel();
        TxtValor = new javax.swing.JLabel();
        TxtTipo = new javax.swing.JLabel();
        TxtCliente = new javax.swing.JLabel();
        FundoSecundario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(InputValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 390, 30));

        try {
            InputHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(InputHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 390, 30));

        Button1.setActionCommand("Deletar Locação");
        Button1.setBackground(new java.awt.Color(255, 0, 51));
        Button1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button1.setForeground(new java.awt.Color(255, 255, 255));
        Button1.setLabel("Deletar Locação");
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });
        getContentPane().add(Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 500, 40));

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Tipo Quadra", "Valor", "Data", "Horário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Short.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tabela);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1040, 230));

        Button.setBackground(new java.awt.Color(51, 154, 139));
        Button.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Button.setForeground(new java.awt.Color(255, 255, 255));
        Button.setLabel("Agendar Locação");
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 500, 40));

        SelectTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SelectTipoItemStateChanged(evt);
            }
        });
        SelectTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectTipoActionPerformed(evt);
            }
        });
        getContentPane().add(SelectTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 390, 30));

        SelectCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectClienteActionPerformed(evt);
            }
        });
        getContentPane().add(SelectCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 390, 30));

        try {
            InputData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        InputData.setToolTipText("");
        getContentPane().add(InputData, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 390, 30));

        TxtObservacao.setBackground(new java.awt.Color(255, 255, 255));
        TxtObservacao.setForeground(new java.awt.Color(255, 255, 255));
        TxtObservacao.setText("Observações:");
        getContentPane().add(TxtObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, -1));

        InputObservacao.setColumns(20);
        InputObservacao.setRows(5);
        jScrollPane1.setViewportView(InputObservacao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 400, 30));

        TxtHorario.setBackground(new java.awt.Color(255, 255, 255));
        TxtHorario.setForeground(new java.awt.Color(255, 255, 255));
        TxtHorario.setText("Horário:");
        getContentPane().add(TxtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));

        TxtData.setBackground(new java.awt.Color(255, 255, 255));
        TxtData.setForeground(new java.awt.Color(255, 255, 255));
        TxtData.setText("Data:");
        getContentPane().add(TxtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        TxtValor.setBackground(new java.awt.Color(255, 255, 255));
        TxtValor.setForeground(new java.awt.Color(255, 255, 255));
        TxtValor.setText("Valor (R$):");
        getContentPane().add(TxtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        TxtTipo.setBackground(new java.awt.Color(255, 255, 255));
        TxtTipo.setForeground(new java.awt.Color(255, 255, 255));
        TxtTipo.setText("Quadra:");
        getContentPane().add(TxtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        TxtCliente.setBackground(new java.awt.Color(255, 255, 255));
        TxtCliente.setForeground(new java.awt.Color(255, 255, 255));
        TxtCliente.setText("Cliente:");
        getContentPane().add(TxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        FundoSecundario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/Agenda-PainelFundo.png"))); // NOI18N
        getContentPane().add(FundoSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1170, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SelectTipoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectTipoItemStateChanged

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
        this.controller.agendar();
    }//GEN-LAST:event_ButtonActionPerformed

    private void SelectTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectTipoActionPerformed

    private void SelectClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectClienteActionPerformed

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button1ActionPerformed
        this.controller.deletar();
    }//GEN-LAST:event_Button1ActionPerformed

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
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Button;
    private java.awt.Button Button1;
    private javax.swing.JLabel FundoSecundario;
    private javax.swing.JFormattedTextField InputData;
    private javax.swing.JFormattedTextField InputHorario;
    private javax.swing.JTextArea InputObservacao;
    private javax.swing.JTextField InputValor;
    private javax.swing.JComboBox<String> SelectCliente;
    private javax.swing.JComboBox<String> SelectTipo;
    private javax.swing.JTable Tabela;
    private javax.swing.JLabel TxtCliente;
    private javax.swing.JLabel TxtData;
    private javax.swing.JLabel TxtHorario;
    private javax.swing.JLabel TxtObservacao;
    private javax.swing.JLabel TxtTipo;
    private javax.swing.JLabel TxtValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void iniciar() {
        this.controller.atualizarTabela();
        this.controller.atualizarCliente();
        this.controller.atualizarTipos();
    }

    public JTable getTabela() {
        return Tabela;
    }

    public void setTabela(JTable Tabela) {
        this.Tabela = Tabela;
    }

    public JComboBox<String> getSelectCliente() {
        return SelectCliente;
    }

    public void setSelectCliente(JComboBox<String> SelectCliente) {
        this.SelectCliente = SelectCliente;
    }

    public JComboBox<String> getSelectTipo() {
        return SelectTipo;
    }

    public void setSelectTipo(JComboBox<String> SelectTipo) {
        this.SelectTipo = SelectTipo;
    }

    public JTextField getInputHorario() {
        return InputHorario;
    }

    public void setInputHorario(JFormattedTextField InputHorario) {
        this.InputHorario = InputHorario;
    }

    public JFormattedTextField getInputData() {
        return InputData;
    }

    public void setInputData(JFormattedTextField InputData) {
        this.InputData = InputData;
    }

    public JTextField getInputValor() {
        return InputValor;
    }

    public void setInputValor(JFormattedTextField InputValor) {
        this.InputValor = InputValor;
    }

    public JTextArea getInputObservacao() {
        return InputObservacao;
    }

    public void setInputObservacao(JTextArea InputObservacao) {
        this.InputObservacao = InputObservacao;
    }

    
}
