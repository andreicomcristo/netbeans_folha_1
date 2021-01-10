    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.pessoas.dao;

import br.com.folha.model.cadastro.parametros.dao.*;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.pessoas.bean.BeanCadastroPessoas;
import br.com.folha.model.principal.bean.BeanPrincipal;
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
public class DaoConsultaCadastroPessoas {

    Connection con = null;
    public boolean inserirPessoa(BeanCadastroPessoas beanCadastroPessoas, BeanPrincipal beanPrincipal){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.pessoa (cpf, nome, seq_operador_cadastro, dt_cadastro) values ( ?,?,?, current_date  )");

                        
            stmt.setString(1, beanCadastroPessoas.getCpfPessoa());
            stmt.setString(2, beanCadastroPessoas.getNomePessoa());
            stmt.setLong(3, beanPrincipal.getSeqOperador());
            

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

    public boolean excluirPessoa(BeanCadastroPessoas beanCadastroPessoas, BeanPrincipal beanPrincipal, String motivo){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("update public.pessoa set seq_operador_cancelamento = ?, motivo_cancelamento = ?, dt_cancelamento = current_date where public.pessoa.seq_pessoa = ? ");

                        
                        stmt.setLong(1, beanPrincipal.getSeqOperador());
                        stmt.setString(2, motivo);
                        stmt.setLong(3, beanCadastroPessoas.getSeqPessoa());
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
    
    public List<BeanCadastroPessoas> selecionarPessoaPorNome(String consulta) {
        List<BeanCadastroPessoas> listaConsulta = new ArrayList<BeanCadastroPessoas>();

     try {

       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_pessoa, cpf, nome from public.pessoa where nome like ? and dt_cancelamento is null order by nome");

              stmt.setString(1, "%"+consulta+"%");

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seq_pessoa = rs.getLong("seq_pessoa");
                   String cpfPessoa = rs.getString("cpf");
                   String nomePessoa = rs.getString("nome");
                   
                   BeanCadastroPessoas beanCadastroPessoas = new BeanCadastroPessoas();
                   beanCadastroPessoas.setSeqPessoa(seq_pessoa);
                   beanCadastroPessoas.setCpfPessoa(cpfPessoa);
                   beanCadastroPessoas.setNomePessoa(nomePessoa);

                 listaConsulta.add(beanCadastroPessoas);

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

     return listaConsulta;

 }
     
    public List<BeanCadastroPessoas> selecionarPessoaPorCpf(String consulta) {
        List<BeanCadastroPessoas> listaConsulta = new ArrayList<BeanCadastroPessoas>();

     try {

       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_pessoa, cpf, nome from public.pessoa where cpf = ? and dt_cancelamento is null order by nome");

              stmt.setString(1, consulta);

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seq_pessoa = rs.getLong("seq_pessoa");
                   String cpfPessoa = rs.getString("cpf");
                   String nomePessoa = rs.getString("nome");
                   
                   BeanCadastroPessoas beanCadastroPessoas = new BeanCadastroPessoas();
                   beanCadastroPessoas.setSeqPessoa(seq_pessoa);
                   beanCadastroPessoas.setCpfPessoa(cpfPessoa);
                   beanCadastroPessoas.setNomePessoa(nomePessoa);

                 listaConsulta.add(beanCadastroPessoas);

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

     return listaConsulta;

 }
     
    public Long selecionarSeqPessoaPorCpf(String consulta) {
         Long resposta = new Long(0);
        List<Long> listaConsulta = new ArrayList<Long>();

     try {

       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_pessoa from public.pessoa where cpf = ? and dt_cancelamento is null order by seq_pessoa desc");

              stmt.setString(1, consulta);

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seq_pessoa = rs.getLong("seq_pessoa");
                   

                 listaConsulta.add(seq_pessoa);

             }
             
             if(!listaConsulta.isEmpty()){resposta = listaConsulta.get(0);}
             

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

     return resposta;

 }
     
     
    public boolean cpfPessoaCadastrado(String cpfConsulta) {
        boolean resposta = false;
        List<String> listaConsulta = new ArrayList<String>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select cpf,  from public.pessoa where cpf = ? and dt_cancelamento is null order by 1");

              stmt.setString(1, cpfConsulta);

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   
                   String cpf = rs.getString("cpf");
                   

                 listaConsulta.add(cpf);

             }

             if(!listaConsulta.isEmpty()){resposta = true;}
             
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

     return resposta;

 }
     


}
