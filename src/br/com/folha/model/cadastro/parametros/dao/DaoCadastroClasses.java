/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCarreiras;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroClasses;
import br.com.folha.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André
 */
public class DaoCadastroClasses {

    Connection con = null;
    public boolean inserirClasse(BeanCadastroClasses classe){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.classes (sigla_classe, nome_classe, descricao_classe) values ( ?,?,? )");
                        
            stmt.setString(1, classe.getSiglaClasse());
            stmt.setString(2, classe.getNomeClasse());
            stmt.setString(3, classe.getDescricaoClasse());
			stmt.execute();
			stmt.close();

			con.close();
                        executou = true;
                        
		} catch (Exception e) {
                    executou = false;
                    JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} finally{

			try{
				con.close();

			}catch (SQLException e){JOptionPane.showMessageDialog(null, e.getMessage());
			}
                }
    return executou;    
    }

    public boolean excluirClasse(BeanCadastroClasses classe){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.classes where public.classes.seq_classe = ? ");

                        stmt.setLong(1, classe.getSeqClasses());
			stmt.execute();
			stmt.close();

			con.close();
                        executou = true;

		} catch (Exception e) {
                    executou = false;
                    JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} finally{

			try{
				con.close();

			}catch (SQLException e){JOptionPane.showMessageDialog(null, e.getMessage());
			}
                }
    return executou;    
    }

    public boolean alterarClasse(BeanCadastroClasses classes) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.classes set sigla_classe = ?, nome_classe = ?, descricao_classe = ? where public.classes.seq_classe = ? ");

                        stmt.setString(1, classes.getSiglaClasse());
                        stmt.setString(2, classes.getNomeClasse());
                        stmt.setString(3, classes.getDescricaoClasse());
                        stmt.setLong(4, classes.getSeqClasses());
                        
                        
			stmt.execute();
			stmt.close();

			con.close();
                        executou = true;

		} catch (Exception e) {
                    executou = false;
                    JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} finally{

			try{
				con.close();

			}catch (SQLException e){JOptionPane.showMessageDialog(null, e.getMessage());
			}
                }
    return executou;    
    }
         

     public List<BeanCadastroClasses> selecionarClasses() {
        List<BeanCadastroClasses> listaClasse = new ArrayList<BeanCadastroClasses>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_classe, sigla_classe, nome_classe, descricao_classe from public.classes order by nome_classe");

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqClasse = rs.getLong("seq_classe");
                   String siglaClasse = rs.getString("sigla_classe");
                   String nomeClasses = rs.getString("nome_classe");
                   String descicaoClasse = rs.getString("descricao_classe");

                 listaClasse.add(new BeanCadastroClasses(seqClasse, siglaClasse, nomeClasses, descicaoClasse));
             }

         } finally {
             try {
                 con.close();
             } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());
                 e.printStackTrace();
             }
         }
     } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());
         e.printStackTrace();
     }

     return listaClasse;

 }
}
