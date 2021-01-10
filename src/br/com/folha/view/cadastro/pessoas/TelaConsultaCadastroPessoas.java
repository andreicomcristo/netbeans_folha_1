/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroDeUsuarios.java
 *
 * Created on 08/12/2009, 08:35:08
 */

package br.com.folha.view.cadastro.pessoas;

import br.com.folha.control.cadastro.pessoas.ControleContultaCadastroPessoas;
import br.com.folha.model.cadastro.pessoas.bean.BeanCadastroPessoas;
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
public class TelaConsultaCadastroPessoas extends javax.swing.JFrame {

    
    ControleContultaCadastroPessoas controleContultaCadastroPessoas;
    BeanCadastroPessoas beanCadastroPessoas;
    
    /** Creates new form CadastroDeUsuarios */
    public TelaConsultaCadastroPessoas() {
       
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        initComponents();
    }
    
    public TelaConsultaCadastroPessoas(ControleContultaCadastroPessoas controleContultaCadastroPessoas, BeanCadastroPessoas beanCadastroPessoas) {
        this.controleContultaCadastroPessoas = controleContultaCadastroPessoas;  
        this.beanCadastroPessoas = beanCadastroPessoas;
        
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        initComponents();
        
        preencherJtable1d(controleContultaCadastroPessoas.selecionarPorNome(""));
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
        jButtonLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonBuscar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Cadastro de Pessoas");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Cadastro de Pessoas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 390, 20);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel2.setText("Consultar");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 90, 14);

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

                if(jTextField1.getText().length()>=11){e.setKeyChar('\0');}

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
        jTextField1.setBounds(60, 210, 150, 25);

        jButtonCadastrar.setFont(new java.awt.Font("Bookman Old Style", 0, 11)); // NOI18N
        jButtonCadastrar.setText("Cadastrar/Alterar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar);
        jButtonCadastrar.setBounds(20, 240, 690, 23);

        jButtonSair.setFont(new java.awt.Font("Bookman Old Style", 0, 11)); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(20, 330, 690, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 690, 10);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 9)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SEQ","CPF","NOME"
            }
        ));
        jTable1.setRowHeight(14);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 690, 110);

        jButtonExcluir.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir);
        jButtonExcluir.setBounds(390, 280, 320, 21);

        jButtonBuscar.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonBuscar.setText("Busca por Nome");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar);
        jButtonBuscar.setBounds(460, 60, 120, 25);

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

                if(jTextField2.getText().length()>=150){e.setKeyChar('\0');}

                char c = e.getKeyChar();
                if (   'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) ){}else   
                {e.setKeyChar('\0');}   
            }   

        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(300, 210, 410, 25);

        jButtonLimpar.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar);
        jButtonLimpar.setBounds(20, 280, 350, 21);

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel4.setText("CPF");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 210, 50, 14);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(90, 60, 350, 25);

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel5.setText("Nome");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 210, 90, 14);

        jButtonBuscar1.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonBuscar1.setText("Busca por CPF");
        jButtonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar1);
        jButtonBuscar1.setBounds(590, 60, 120, 25);

        setSize(new java.awt.Dimension(745, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:

        
        if(jTable1.getSelectedRowCount()==1){
            // para o caso de alteracao
            int linhaJTable1 = jTable1.getSelectedRow();
            controleContultaCadastroPessoas.indicaPessoaAAlterar(linhaJTable1);
            dispose();
            controleContultaCadastroPessoas.abrirFrameCadastroPessoas();
            
        }else{
            // para o caso de novo cadastro
            if(jTable1.getSelectedRowCount()==0){
        
                String cpfPessoa = jTextField1.getText().toUpperCase();
                String nomePessoa = jTextField2.getText().toUpperCase();

                boolean cadastrou = controleContultaCadastroPessoas.cadastrar(cpfPessoa, nomePessoa);
                    if(cadastrou==true){
                        dispose();
                        controleContultaCadastroPessoas.abrirFrameCadastroPessoas();
                    }
            }
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        
        if(jTable1.getSelectedRowCount()==1){
            int linhajTable1  = jTable1.getSelectedRow();
            String motivo = JOptionPane.showInputDialog("Informe o motivo para a exclusão;");
            controleContultaCadastroPessoas.excluir(linhajTable1, motivo);
        }else{JOptionPane.showMessageDialog(null, "Você deve selecionar uma linha na tabela.");}

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        
        preencherJtable1d(controleContultaCadastroPessoas.selecionarPorNome(jTextField3.getText()));
        
}//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscar1ActionPerformed
        // TODO add your handling code here:
        preencherJtable1d(controleContultaCadastroPessoas.selecionarPorCpf(jTextField3.getText()));
    }//GEN-LAST:event_jButtonBuscar1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaCadastroPessoas().setVisible(true);
            }
        });
    }

    
    
    public void limparCampos(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
    }
    
    
    public void preencherJtable1d(List<BeanCadastroPessoas> dados  ){

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(360);
        
       
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
 
        for ( BeanCadastroPessoas pessoa : dados) {

            Object[] linha = new Object[] { pessoa.getSeqPessoa(), pessoa.getCpfPessoa(), pessoa.getNomePessoa()};
            modelo.addRow(linha);

        }
 }

   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscar1;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
