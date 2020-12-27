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

import br.com.folha.control.cadastro.parametros.ControleCadastroCargaHorariaSemanal;
import br.com.folha.model.cadastro.parametros.bean.BeanCargaHorariaSemanal;
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
 * @author aom
 */
public class CadastroVinculos extends javax.swing.JFrame {

    
    ControleCadastroCargaHorariaSemanal controleCadastroCargaHorariaSemanal;
    
    /** Creates new form CadastroDeUsuarios */
    public CadastroVinculos() {
       
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        initComponents();
    }
    
    public CadastroVinculos(ControleCadastroCargaHorariaSemanal controleCadastroCargaHorariaSemanal) {
        this.controleCadastroCargaHorariaSemanal = controleCadastroCargaHorariaSemanal;  
       
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        initComponents();
        
        preencherJtable1d(controleCadastroCargaHorariaSemanal.selecionar());
        
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
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Carga Horária");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Vínculo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 390, 20);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel2.setText("Descrição do vínculo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 60, 160, 14);

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

                if(jTextField1.getText().length()>=2){e.setKeyChar('\0');}

                char c = e.getKeyChar();
                if ( '0' <= c && c <= '9' || (c == KeyEvent.VK_BACK_SPACE) ){}else   
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
        jTextField1.setBounds(130, 60, 150, 25);

        jButton1.setFont(new java.awt.Font("Bookman Old Style", 0, 11)); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 90, 690, 26);

        jButton4.setFont(new java.awt.Font("Bookman Old Style", 0, 11)); // NOI18N
        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(390, 310, 320, 26);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 690, 10);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 9)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SEQ","CARGA HORARIA SEMANAL","DESCRICAO"
            }
        ));
        jTable1.setRowHeight(14);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 690, 130);

        jButton5.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(260, 130, 215, 25);

        jButton12.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButton12.setText("Busca");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12);
        jButton12.setBounds(490, 130, 215, 25);

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
        jTextField2.setBounds(450, 60, 260, 25);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel3.setText("Tipo de vínculo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 60, 110, 14);

        jButton2.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 130, 215, 25);

        jButton3.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 310, 350, 25);

        setSize(new java.awt.Dimension(745, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        boolean cadastrou = controleCadastroCargaHorariaSemanal.cadastrar(jTextField1.getText().toUpperCase(), jTextField2.getText().toUpperCase());
        if(cadastrou){
            limparCampos();
            jTextField1.requestFocus();
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        if(jTable1.getSelectedRowCount()==1){
            String seq_carga_horaria_sem  = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            controleCadastroCargaHorariaSemanal.excluir(seq_carga_horaria_sem);
        }else{JOptionPane.showMessageDialog(null, "Você deve selecionar uma linha na tabela.");}

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        preencherJtable1d(controleCadastroCargaHorariaSemanal.selecionar());
}//GEN-LAST:event_jButton12ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount() == 1){
            String seqCargaHorariaSem  = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String cargaHoraria = jTextField1.getText();
            String descricaoCargaHoraria = jTextField2.getText();
            controleCadastroCargaHorariaSemanal.alterar(seqCargaHorariaSem, cargaHoraria, descricaoCargaHoraria);
        }else{JOptionPane.showMessageDialog(null, "Você deve selecionar uma linha na tabela.");}
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVinculos().setVisible(true);
            }
        });
    }

    
    
    public void limparCampos(){
        jTextField1.setText("");
        jTextField2.setText("");
    }
    
    public void preencherJtable1d(List<BeanCargaHorariaSemanal> dados  ){

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(280);
       
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
 
        for ( BeanCargaHorariaSemanal pessoa : dados) {

            Object[] linha = new Object[] { pessoa.getSeqCargaHorariaSemanal(), pessoa.getCargaHoraria(), pessoa.getDescricaoCargaHoraria()};
            modelo.addRow(linha);

        }
 }

   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
