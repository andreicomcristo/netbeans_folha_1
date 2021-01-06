/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroUnidadesRegime;
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
public class DaoCadastroUnidadesRegime {

    Connection con = null;
    public boolean inserirUnidadeRegime(BeanCadastroUnidadesRegime unidadeRegime){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.unidades_regime (sigla_regime_unid_lotacao, nome_regime_unid_lotacao, descricao_regime_unid_lotacao) values ( ?,?,? )");
                        
            stmt.setString(1, unidadeRegime.getSiglaRegimeUnidLotacao());
            stmt.setString(2, unidadeRegime.getNomeRegimeUnidLotacao());
            //stmt.setString(3, unidadeRegime.getDescricaoNivelCargo());
            stmt.setString(3, unidadeRegime.getDescricaoRegimeUnidLotacao());
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

    public boolean excluirUnidadeRegime(BeanCadastroUnidadesRegime unidadeRegime){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.unidades_regime where public.unidades_regime.seq_regime_unid_lotacao = ? ");

                        stmt.setLong(1, unidadeRegime.getSeqRegimeUnidLotacao());
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

    public boolean alterarUnidadeRegime(BeanCadastroUnidadesRegime unidadesRegime) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.unidades_regime set sigla_regime_unid_lotacao = ?, nome_regime_unid_lotacao = ?, descricao_regime_unid_lotacao = ? where public.unidades_regime.seq_regime_unid_lotacao = ? ");

                        stmt.setString(1, unidadesRegime.getSiglaRegimeUnidLotacao());
                        stmt.setString(2, unidadesRegime.getNomeRegimeUnidLotacao());
                        stmt.setString(3, unidadesRegime.getDescricaoRegimeUnidLotacao());
                        stmt.setLong(4, unidadesRegime.getSeqRegimeUnidLotacao());
                        
                        
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
         

     public List<BeanCadastroUnidadesRegime> selecionarUnidadesRegime() {
        List<BeanCadastroUnidadesRegime> listaUnidadesRegime = new ArrayList<BeanCadastroUnidadesRegime>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_regime_unid_lotacao, sigla_regime_unid_lotacao, nome_regime_unid_lotacao, descricao_regime_unid_lotacao from public.unidades_regime order by nome_regime_unid_lotacao");

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqRegime = rs.getLong("seq_regime_unid_lotacao");
                   String siglaRegime = rs.getString("sigla_regime_unid_lotacao");
                   String nomeRegime = rs.getString("nome_regime_unid_lotacao");
                   String descicaoRegime = rs.getString("descricao_regime_unid_lotacao");

                 listaUnidadesRegime.add(new BeanCadastroUnidadesRegime(seqRegime, siglaRegime, nomeRegime, descicaoRegime));
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

     return listaUnidadesRegime;

 }
}
