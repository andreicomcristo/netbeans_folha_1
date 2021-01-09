    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.pessoas.dao;

import br.com.folha.model.cadastro.parametros.dao.*;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
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
public class DaoCadastroPessoas {

    Connection con = null;
    public boolean inserirCidade(BeanCadastroCidades cidade){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.cidades (nome_cidade, sigla_estado, seq_pais) values ( ?,?,?  )");

                        
            stmt.setString(1, cidade.getNomeCidade());
            stmt.setString(2, cidade.getSiglaEstado());
            stmt.setLong(3, cidade.getSeqPais());

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

    public boolean excluirCidade(BeanCadastroCidades cidade){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.cidades where public.cidades.seq_cidade = ? ");

                        stmt.setLong(1, cidade.getSeqCidade());
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

    public boolean alterarCidade(BeanCadastroCidades cidade) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.cidades set nome_cidade = ?, sigla_estado = ?, seq_pais = ?  where public.cidades.seq_cidade = ? ");

                        
                        stmt.setString(1, cidade.getNomeCidade());
                        stmt.setString(2, cidade.getSiglaEstado());
                        stmt.setLong(3, cidade.getSeqPais());
                        stmt.setLong(4, cidade.getSeqCidade());
                        
                        
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
         

     public List<BeanCadastroCidades> selecionarCidade(String consulta) {
        List<BeanCadastroCidades> listaConsulta = new ArrayList<BeanCadastroCidades>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_cidade, nome_cidade, sigla_estado, cidades.seq_pais, nome_pais from public.cidades inner join public.paises on public.cidades.seq_pais = public.paises.seq_pais where nome_cidade like ? order by nome_cidade");

              stmt.setString(1, "%"+consulta+"%");

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqCidade = rs.getLong("seq_cidade");
                   String nomeCidada = rs.getString("nome_cidade");
                   String siglaCidade = rs.getString("Sigla_estado");
                   long seqPais = rs.getLong("seq_Pais");
                   String nomePais = rs.getString("nome_Pais");

                 listaConsulta.add(new BeanCadastroCidades(seqCidade, nomeCidada, siglaCidade, seqPais, nomePais));

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
     
     public List<BeanSequenciaTexto> selecionarPaises() {
        List<BeanSequenciaTexto> listaConsulta = new ArrayList<BeanSequenciaTexto>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_pais, nome_pais from public.paises order by nome_pais");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long sequencia = rs.getLong("seq_pais");
                   String texto = rs.getString("nome_pais");
                   

                 listaConsulta.add(new BeanSequenciaTexto(sequencia, texto));

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
     


}
