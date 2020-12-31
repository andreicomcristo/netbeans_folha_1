/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroTiposLogradouro;
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
public class DaoCadastroTiposLogradouros {

    Connection con = null;
    
    public boolean inserirLogradouro(BeanCadastroTiposLogradouro logradouro){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.tipos_logradouro "
                                + "(nome_tipo_logradouro, descricao_tipo_logradouro) values ( ?,? )");
                        
            stmt.setString(1, logradouro.getNomeTipoLogradouro());
            stmt.setString(2, logradouro.getDescricaoTipoLogradouro());
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

    public boolean excluirLogradouro(BeanCadastroTiposLogradouro logradouro){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.tipos_logradouro "
                                + "where public.tipos_logradouro.seq_tipo_logradouro = ? ");

                        stmt.setLong(1, logradouro.getSeqTipoLogradouro());
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

    public boolean alterarFiliacao(BeanCadastroTiposLogradouro logradouro) {
            boolean executou = false;
            try {
		con = ConnectionFactory.getConnection();
                                                                      // nome da tebela
		PreparedStatement stmt = con.prepareStatement("UPDATE public.tipos_logradouro "
                        + "set nome_tipo_logradouro = ?, descricao_tipo_logradouro = ? "
                        + " where public.tipos_logradouro.seq_tipo_logradouro = ? ");

                        
                        stmt.setString(1, logradouro.getNomeTipoLogradouro());
                        stmt.setString(2, logradouro.getDescricaoTipoLogradouro());
                        stmt.setLong(3, logradouro.getSeqTipoLogradouro());
                                    
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
         
    public List<BeanCadastroTiposLogradouro> selecionarLogradouro() {
         
        List<BeanCadastroTiposLogradouro> listaLogradouro = new ArrayList<BeanCadastroTiposLogradouro>();

        try {

            con = ConnectionFactory.getConnection();

            try {

                PreparedStatement stmt = con.prepareStatement("select seq_tipo_logradouro, nome_tipo_logradouro,"
                        + " descricao_tipo_logradouro from public.tipos_logradouro order by nome_tipo_logradouro");
              
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                   long seqLogradouro = rs.getLong("seq_tipo_logradouro");
                   String nomesLogradouro = rs.getString("nome_tipo_logradouro");
                   String descricaoLogradouro = rs.getString("descricao_tipo_logradouro");

                 listaLogradouro.add(new BeanCadastroTiposLogradouro(seqLogradouro, nomesLogradouro, descricaoLogradouro));
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
        return listaLogradouro;
    }
}
