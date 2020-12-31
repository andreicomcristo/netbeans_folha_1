/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroUnidadesNaturezaJuridica;
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
public class DaoCadastroUnidadesNaturezaJurudica {

    Connection con = null;
    
    public boolean inserirNaturezaJuridica(BeanCadastroUnidadesNaturezaJuridica naturezaJuridica){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.unidades_natureza_juridica "
                                + "(nome_natureza_juridica, descricao_natureza_juridica) values ( ?,? )");
                        
            stmt.setString(1, naturezaJuridica.getNomeNaturazaJuridica());
            stmt.setString(2, naturezaJuridica.getDescricaoNaturezaJuridica());
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

    public boolean excluirNaturezaJuridica(BeanCadastroUnidadesNaturezaJuridica naturezaJuridica){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.unidades_natureza_juridica "
                                + "where public.unidades_natureza_juridica.seq_unidade_natureza_juridica = ? ");

                        stmt.setLong(1, naturezaJuridica.getSeqUnidadeNaturezaJurudica());
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

    public boolean alterarNaturezaJuridica(BeanCadastroUnidadesNaturezaJuridica naturezaJuridica) {
            boolean executou = false;
            try {
		con = ConnectionFactory.getConnection();
                                                                      // nome da tebela
		PreparedStatement stmt = con.prepareStatement("UPDATE public.unidades_natureza_juridica "
                        + "set nome_natureza_juridica = ?, descricao_natureza_juridica = ? "
                        + " where public.unidades_natureza_juridica.seq_unidade_natureza_juridica = ? ");

                        
                        stmt.setString(1, naturezaJuridica.getNomeNaturazaJuridica());
                        stmt.setString(2, naturezaJuridica.getDescricaoNaturezaJuridica());
                        stmt.setLong(3, naturezaJuridica.getSeqUnidadeNaturezaJurudica());
                                    
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
         
    public List<BeanCadastroUnidadesNaturezaJuridica> selecionarNaturezaJuridica() {
         
        List<BeanCadastroUnidadesNaturezaJuridica> listaNaturezaJuridica = new ArrayList<BeanCadastroUnidadesNaturezaJuridica>();

        try {

            con = ConnectionFactory.getConnection();

            try {

                PreparedStatement stmt = con.prepareStatement("select seq_unidade_natureza_juridica, nome_natureza_juridica,"
                        + " descricao_matureza_juridica from public.unidades_natureza_juridica order by nome_natureza_juridica");
              
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                   long seqNaturezaJuridica = rs.getLong("seq_unidade_natureza_juridica");
                   String nomesNaturezaJuridica = rs.getString("nome_natureza_juridica");
                   String descricaoNaturezaJuridica = rs.getString("descricao_natureza_juridica");

                 listaNaturezaJuridica.add(new BeanCadastroUnidadesNaturezaJuridica(seqNaturezaJuridica, nomesNaturezaJuridica, descricaoNaturezaJuridica));
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
        return listaNaturezaJuridica;
    }
}
