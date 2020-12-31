/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroSexos;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroSituacoes;
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
public class DaoCadastroSituacoes {

    Connection con = null;
    
    public boolean inserirSituacao(BeanCadastroSituacoes situacao){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.situacoes (nome_situacao, descricao_situacao) values ( ?,? )");

                        
            stmt.setString(1, situacao.getNomeSituacao());
            stmt.setString(2, situacao.getDescricaoSituacao());
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

    public boolean excluirSituacao(BeanCadastroSituacoes situacao){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.situacoes "
                                + "where public.situacoes.seq_situacao = ? ");

                        stmt.setLong(1, situacao.getSeqSituacao());
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

    public boolean alterarSituacao(BeanCadastroSituacoes situacao) {
            boolean executou = false;
            try {
		con = ConnectionFactory.getConnection();
                                                                      // nome da tebela
		PreparedStatement stmt = con.prepareStatement("UPDATE public.situacoes"
                        + " set nome_situacao = ?, descricao_situacao = ?  where public.situacoes.seq_situacao = ? ");

                        
                        stmt.setString(1, situacao.getNomeSituacao());
                        stmt.setString(2, situacao.getDescricaoSituacao());
                        stmt.setLong(3, situacao.getSeqSituacao());
                                    
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
         

     public List<BeanCadastroSituacoes> selecionarSituacao() {
         
        List<BeanCadastroSituacoes> listaSituacao = new ArrayList<BeanCadastroSituacoes>();

        try {

            con = ConnectionFactory.getConnection();

            try {

                PreparedStatement stmt = con.prepareStatement("select seq_situacao, nome_situacao, descricao_situacao"
                        + " from public.situacoes order by nome_situacao");
              
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                   long seqSituacao = rs.getLong("seq_situacao");
                   String nomesSituacao = rs.getString("nome_situacao");
                   String descricaoSituacao = rs.getString("descricao_situacao");

                 listaSituacao.add(new BeanCadastroSituacoes(seqSituacao, nomesSituacao, descricaoSituacao));
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
        return listaSituacao;
    }
}
