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

import br.com.folha.control.cadastro.parametros.ControleCadastroCargosEspecialidade;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCargosEspecialidade;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
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
public class TelaCadastroCargosEspecialidade extends javax.swing.JFrame {

    
    ControleCadastroCargosEspecialidade controleCadastroCargosEspecialidade;
    BeanCadastroCargosEspecialidade beanCargosEspecialidede;
    
    /** Creates new form CadastroDeUsuarios */
    public TelaCadastroCargosEspecialidade() {
       
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        initComponents();
    }
    
    public TelaCadastroCargosEspecialidade(ControleCadastroCargosEspecialidade controleCadastroCargosEspecialidade, BeanCadastroCargosEspecialidade beanCargosEspecialidade) {
        this.controleCadastroCargosEspecialidade = controleCadastroCargosEspecialidade;  
        this.beanCargosEspecialidede = beanCargosEspecialidade;
        
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        initComponents();
        
        //preencherJtable1d(ControleCadastroCidades.selecionar());
        preencherJtable1d(controleCadastroCargosEspecialidade.selecionar());
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Especialidades");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Especialidades");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 390, 20);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel2.setText("Descrição");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(480, 60, 70, 14);

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
                if ( 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || (c == KeyEvent.VK_SPACE)|| (c == KeyEvent.VK_BACK_SPACE) ){

                }else   
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
        jTextField1.setBounds(120, 60, 280, 25);

        jButtonCadastrar.setFont(new java.awt.Font("Bookman Old Style", 0, 11)); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar);
        jButtonCadastrar.setBounds(20, 120, 690, 26);

        jButtonSair.setFont(new java.awt.Font("Bookman Old Style", 0, 11)); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(390, 320, 320, 26);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 690, 10);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 9)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SEQ","ESPECIALIDADE","DESCRIÇÃO", "SEQ CARGO", "CARGO"
            }
        ));
        jTable1.setRowHeight(14);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 690, 130);

        jButtonExcluir.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir);
        jButtonExcluir.setBounds(260, 150, 215, 25);

        jButtonBuscar.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonBuscar.setText("Busca");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar);
        jButtonBuscar.setBounds(490, 150, 215, 25);

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

                if(jTextField2.getText().length()>=100){e.setKeyChar('\0');}

                char c = e.getKeyChar();
                if (   'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || (c == KeyEvent.VK_BACK_SPACE) ){}else   
                {e.setKeyChar('\0');}   
            }   

        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(550, 60, 160, 25);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel3.setText("País");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 90, 50, 14);

        jButtonAlterar.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar);
        jButtonAlterar.setBounds(20, 150, 215, 25);

        jButtonLimpar.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar);
        jButtonLimpar.setBounds(20, 320, 350, 25);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(80, 90, 630, 25);

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 11)); // NOI18N
        jLabel4.setText("Especialidade");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 60, 100, 14);

        setSize(new java.awt.Dimension(745, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:

        String especialidadeCargo = jTextField1.getText().toUpperCase();
        String descricao = jTextField2.getText().toUpperCase();
        int indice = jComboBox1.getSelectedIndex();
        
        boolean cadastrou = controleCadastroCargosEspecialidade.cadastrar(especialidadeCargo, descricao, indice );
        if(cadastrou){
            limparCampos();
            jTextField1.requestFocus();
        }
       
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        
        if(jTable1.getSelectedRowCount()==1){
            String seqCidade  = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            controleCadastroCargosEspecialidade.excluir(seqCidade);
        }else{JOptionPane.showMessageDialog(null, "Você deve selecionar uma linha na tabela.");}

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:

        preencherJtable1d(controleCadastroCargosEspecialidade.selecionar());
        
}//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount() == 1){
            String seqEspecialidadeCargo  = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();              
            String nomeEspecialidadeCargo = jTextField1.getText();
            String descricaoEspecialidadeCargo = jTextField2.getText();
            int indice = jComboBox1.getSelectedIndex();
            controleCadastroCargosEspecialidade.alterar(seqEspecialidadeCargo, nomeEspecialidadeCargo, descricaoEspecialidadeCargo, indice);
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
                new TelaCadastroCargosEspecialidade().setVisible(true);
            }
        });
    }
   
    public void limparCampos(){
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedItem("");
    }
    
    public void preencherComboBox1(List<BeanSequenciaTexto> listaCargos){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("");
        if(!listaCargos.isEmpty()){
            for(int i=0;i<listaCargos.size();i++){
                jComboBox1.addItem(listaCargos.get(i).getTexto());
            }
            // fazendo uma pré-seleção
            //jComboBox1.setSelectedItem("BRASIL");
        }
    };
    
    public void preencherJtable1d(List<BeanCadastroCargosEspecialidade> dados  ){

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(130);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
       
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
 
        for ( BeanCadastroCargosEspecialidade cargosEspecialidade : dados) {

            Object[] linha = new Object[] { cargosEspecialidade.getSeqEspecialidadeCargo(), cargosEspecialidade.getNomeEspecialidadeCargo(), cargosEspecialidade.getDescriçãoEspecialidadeCargo(), cargosEspecialidade.getSeqCargo(), cargosEspecialidade.getNomeCargo()};
            
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
