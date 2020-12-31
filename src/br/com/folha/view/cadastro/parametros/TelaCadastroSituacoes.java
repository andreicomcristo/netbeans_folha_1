/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroDeUsuarios.java
 *
 * Created on 08/12/2009, 08:35:08
 */

package br.com.folha.view.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.ControleCadastroSituacoes;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroSituacoes;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author André
 */
public class TelaCadastroSituacoes extends javax.swing.JFrame {

    
    ControleCadastroSituacoes controleCadastroSituacoes;
    BeanCadastroSituacoes beanCadastroSituacoes;
    
    /** Creates new form CadastroDeUsuarios */
    public TelaCadastroSituacoes() {
       
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        initComponents();
    }
    
    public TelaCadastroSituacoes(ControleCadastroSituacoes controleCadastroSituacoes, BeanCadastroSituacoes beanCadastroSituacoes) {
        this.controleCadastroSituacoes = controleCadastroSituacoes;  
        this.beanCadastroSituacoes = beanCadastroSituacoes;
        
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        initComponents();
        
        preencherJtable1d(controleCadastroSituacoes.selecionar());
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonExcluir = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Sexos");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Sexos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 390, 20);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel2.setText("Descrição do Sexo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(340, 60, 120, 20);

        jTextField1.addKeyListener(new KeyAdapter() {   
            public void keyTyped(KeyEvent e) { // <- alteração   

                if(e.getKeyChar()=='a'){e.setKeyChar('A');}
                if(e.getKeyChar()=='á'){e.setKeyChar('A');}
                if(e.getKeyChar()=='à'){e.setKeyChar('A');}
                if(e.getKeyChar()=='ã'){e.setKeyChar('A');}
                if(e.getKeyChar()=='â'){e.setKeyChar('A');}
                if(e.getKeyChar()=='b'){e.setKeyChar('B');}
                if(e.getKeyChar()=='c'){e.setKeyChar('C');}
                if(e.getKeyChar()=='ç'){e.setKeyChar('C');}
                if(e.getKeyChar()=='d'){e.setKeyChar('D');}
                if(e.getKeyChar()=='e'){e.setKeyChar('E');}
                if(e.getKeyChar()=='é'){e.setKeyChar('E');}
                if(e.getKeyChar()=='è'){e.setKeyChar('E');}
                if(e.getKeyChar()=='ê'){e.setKeyChar('E');}
                if(e.getKeyChar()=='f'){e.setKeyChar('F');}
                if(e.getKeyChar()=='g'){e.setKeyChar('G');}
                if(e.getKeyChar()=='h'){e.setKeyChar('H');}
                if(e.getKeyChar()=='i'){e.setKeyChar('I');}
                if(e.getKeyChar()=='í'){e.setKeyChar('I');}
                if(e.getKeyChar()=='ì'){e.setKeyChar('I');}
                if(e.getKeyChar()=='î'){e.setKeyChar('I');}
                if(e.getKeyChar()=='j'){e.setKeyChar('J');}
                if(e.getKeyChar()=='k'){e.setKeyChar('K');}
                if(e.getKeyChar()=='l'){e.setKeyChar('L');}
                if(e.getKeyChar()=='m'){e.setKeyChar('M');}
                if(e.getKeyChar()=='n'){e.setKeyChar('N');}
                if(e.getKeyChar()=='o'){e.setKeyChar('O');}
                if(e.getKeyChar()=='ó'){e.setKeyChar('O');}
                if(e.getKeyChar()=='ò'){e.setKeyChar('O');}
                if(e.getKeyChar()=='õ'){e.setKeyChar('O');}
                if(e.getKeyChar()=='ô'){e.setKeyChar('O');}
                if(e.getKeyChar()=='p'){e.setKeyChar('P');}
                if(e.getKeyChar()=='q'){e.setKeyChar('Q');}
                if(e.getKeyChar()=='r'){e.setKeyChar('R');}
                if(e.getKeyChar()=='s'){e.setKeyChar('S');}
                if(e.getKeyChar()=='t'){e.setKeyChar('T');}
                if(e.getKeyChar()=='u'){e.setKeyChar('U');}
                if(e.getKeyChar()=='ú'){e.setKeyChar('U');}
                if(e.getKeyChar()=='ù'){e.setKeyChar('U');}
                if(e.getKeyChar()=='û'){e.setKeyChar('U');}
                if(e.getKeyChar()=='v'){e.setKeyChar('V');}
                if(e.getKeyChar()=='w'){e.setKeyChar('W');}
                if(e.getKeyChar()=='x'){e.setKeyChar('X');}
                if(e.getKeyChar()=='y'){e.setKeyChar('Y');}
                if(e.getKeyChar()=='z'){e.setKeyChar('Z');}

                if(jTextField1.getText().length()>=100){e.setKeyChar('\0');}

                char c = e.getKeyChar();
                if ( 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || (c == KeyEvent.VK_SPACE)|| (c == KeyEvent.VK_BACK_SPACE) ){}else   
                {e.setKeyChar('\0');}   
            }   

        });
        jTextField1.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(70, 60, 150, 25);

        jButtonCadastrar.setFont(new java.awt.Font("Bookman Old Style", 0, 11)); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar);
        jButtonCadastrar.setBounds(20, 90, 690, 26);

        jButtonSair.setFont(new java.awt.Font("Bookman Old Style", 0, 11)); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(390, 310, 320, 26);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 690, 10);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 9)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SEQ","SEXO","DESCRIÇÃO DO SEXO"
            }
        ));
        jTable1.setRowHeight(14);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 690, 130);

        jButtonExcluir.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir);
        jButtonExcluir.setBounds(260, 130, 215, 25);

        jButtonBuscar.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonBuscar.setText("Busca");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar);
        jButtonBuscar.setBounds(490, 130, 215, 25);

        jTextField2.addKeyListener(new KeyAdapter() {   
            public void keyTyped(KeyEvent e) { // <- alteração   

                if(e.getKeyChar()=='a'){e.setKeyChar('A');}
                if(e.getKeyChar()=='á'){e.setKeyChar('A');}
                if(e.getKeyChar()=='à'){e.setKeyChar('A');}
                if(e.getKeyChar()=='ã'){e.setKeyChar('A');}
                if(e.getKeyChar()=='â'){e.setKeyChar('A');}
                if(e.getKeyChar()=='b'){e.setKeyChar('B');}
                if(e.getKeyChar()=='c'){e.setKeyChar('C');}
                if(e.getKeyChar()=='ç'){e.setKeyChar('C');}
                if(e.getKeyChar()=='d'){e.setKeyChar('D');}
                if(e.getKeyChar()=='e'){e.setKeyChar('E');}
                if(e.getKeyChar()=='é'){e.setKeyChar('E');}
                if(e.getKeyChar()=='è'){e.setKeyChar('E');}
                if(e.getKeyChar()=='ê'){e.setKeyChar('E');}
                if(e.getKeyChar()=='f'){e.setKeyChar('F');}
                if(e.getKeyChar()=='g'){e.setKeyChar('G');}
                if(e.getKeyChar()=='h'){e.setKeyChar('H');}
                if(e.getKeyChar()=='i'){e.setKeyChar('I');}
                if(e.getKeyChar()=='í'){e.setKeyChar('I');}
                if(e.getKeyChar()=='ì'){e.setKeyChar('I');}
                if(e.getKeyChar()=='î'){e.setKeyChar('I');}
                if(e.getKeyChar()=='j'){e.setKeyChar('J');}
                if(e.getKeyChar()=='k'){e.setKeyChar('K');}
                if(e.getKeyChar()=='l'){e.setKeyChar('L');}
                if(e.getKeyChar()=='m'){e.setKeyChar('M');}
                if(e.getKeyChar()=='n'){e.setKeyChar('N');}
                if(e.getKeyChar()=='o'){e.setKeyChar('O');}
                if(e.getKeyChar()=='ó'){e.setKeyChar('O');}
                if(e.getKeyChar()=='ò'){e.setKeyChar('O');}
                if(e.getKeyChar()=='õ'){e.setKeyChar('O');}
                if(e.getKeyChar()=='ô'){e.setKeyChar('O');}
                if(e.getKeyChar()=='p'){e.setKeyChar('P');}
                if(e.getKeyChar()=='q'){e.setKeyChar('Q');}
                if(e.getKeyChar()=='r'){e.setKeyChar('R');}
                if(e.getKeyChar()=='s'){e.setKeyChar('S');}
                if(e.getKeyChar()=='t'){e.setKeyChar('T');}
                if(e.getKeyChar()=='u'){e.setKeyChar('U');}
                if(e.getKeyChar()=='ú'){e.setKeyChar('U');}
                if(e.getKeyChar()=='ù'){e.setKeyChar('U');}
                if(e.getKeyChar()=='û'){e.setKeyChar('U');}
                if(e.getKeyChar()=='v'){e.setKeyChar('V');}
                if(e.getKeyChar()=='w'){e.setKeyChar('W');}
                if(e.getKeyChar()=='x'){e.setKeyChar('X');}
                if(e.getKeyChar()=='y'){e.setKeyChar('Y');}
                if(e.getKeyChar()=='z'){e.setKeyChar('Z');}

                if(jTextField2.getText().length()>=300){e.setKeyChar('\0');}

                char c = e.getKeyChar();
                if ( '0' <= c && c <= '9' ||  'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_SPACE) ){}else   
                {e.setKeyChar('\0');}   
            }   

        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(470, 60, 240, 25);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel3.setText("Sexo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 40, 14);

        jButtonAlterar.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar);
        jButtonAlterar.setBounds(20, 130, 215, 25);

        jButtonLimpar.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar);
        jButtonLimpar.setBounds(20, 310, 350, 25);

        setSize(new java.awt.Dimension(745, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:

        boolean cadastrou = controleCadastroSituacoes.cadastrar(jTextField1.getText().toUpperCase(), jTextField2.getText().toUpperCase());
        if(cadastrou){
            limparCampos();
            jTextField1.requestFocus();
        }
       
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        
        if(jTable1.getSelectedRowCount()==1){
            String seqSituacao  = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            controleCadastroSituacoes.excluir(seqSituacao);
        }else{JOptionPane.showMessageDialog(null, "Você deve selecionar uma linha na tabela.");}

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:

        preencherJtable1d(controleCadastroSituacoes.selecionar());
        
}//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount() == 1){
            String seqSituacao  = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();              
            String nomeSituacao = jTextField1.getText();
            String descricaoSituacao = jTextField2.getText();
            controleCadastroSituacoes.alterar(seqSituacao, nomeSituacao, descricaoSituacao);
        }else{JOptionPane.showMessageDialog(null, "Você deve selecionar uma linha na tabela.");}
        
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroSituacoes().setVisible(true);
            }
        });
    }

    
    
    public void limparCampos(){
        jTextField1.setText("");
        jTextField2.setText("");
    }
    
    public void preencherJtable1d(List<BeanCadastroSituacoes> dados  ){

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(280);
       
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
 
        for ( BeanCadastroSituacoes situacao : dados) {

            Object[] linha = new Object[] { situacao.getSeqSituacao(), situacao.getNomeSituacao(), situacao.getDescricaoSituacao()};
            modelo.addRow(linha);
        }
    }

   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
