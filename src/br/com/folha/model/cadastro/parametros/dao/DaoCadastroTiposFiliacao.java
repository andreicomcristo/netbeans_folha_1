/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroTiposFiliacao;
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
public class DaoCadastroTiposFiliacao {

    Connection con = null;
    
    public boolean inserirFiliacao(BeanCadastroTiposFiliacao filiacao){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.tipos_de_filiacao "
                                + "(nome_tipo_filiacao, descricao_tipo_filiacao) values ( ?,? )");
                        
            stmt.setString(1, filiacao.getNomeTipoFiliacao());
            stmt.setString(2, filiacao.getDescricaoTipoFiliacao());
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

    public boolean excluirFiliacao(BeanCadastroTiposFiliacao filiacao){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.tipos_de_filiacao "
                                + "where public.tipos_de_filiacao.seq_tipo_filiacao = ? ");

                        stmt.setLong(1, filiacao.getSeqTipoFiliacao());
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

    public boolean alterarFiliacao(BeanCadastroTiposFiliacao filiacao) {
            boolean executou = false;
            try {
		con = ConnectionFactory.getConnection();
                                                                      // nome da tebela
		PreparedStatement stmt = con.prepareStatement("UPDATE public.tipos_de_filiacao"
                        + " set nome_tipo_filiacao = ?, descricao_tipo_filiacao = ?  where public.tipos_de_filiacao.seq_tipo_filiacao = ? ");

                        
                        stmt.setString(1, filiacao.getNomeTipoFiliacao());
                        stmt.setString(2, filiacao.getDescricaoTipoFiliacao());
                        stmt.setLong(3, filiacao.getSeqTipoFiliacao());
                                    
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
         
    public List<BeanCadastroTiposFiliacao> selecionarFiliacao() {
         
        List<BeanCadastroTiposFiliacao> listafiliacao = new ArrayList<BeanCadastroTiposFiliacao>();

        try {

            con = ConnectionFactory.getConnection();

            try {

                PreparedStatement stmt = con.prepareStatement("select seq_tipo_filiacao, nome_tipo_filiacao, descricao_tipo_filiacao"
                        + " from public.tipos_de_filiacao order by nome_tipo_filiacao");
              
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                   long seqFiliacao = rs.getLong("seq_tipo_filiacao");
                   String nomesfiliacao = rs.getString("nome_tipo_filiacao");
                   String descricaoFiliacao = rs.getString("descricao_tipo_filiacao");

                 listafiliacao.add(new BeanCadastroTiposFiliacao(seqFiliacao, nomesfiliacao, descricaoFiliacao));
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
        return listafiliacao;
    }
}
