/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroNiveisCargos;
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
        List<BeanCadastroUnidadesRegime> listaUnidadesRegime = new ArrayList<BeanCadastroNiveisCargos>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_nivel_cargo, sigla_nivel_cargo, nome_nivel_cargo, descricao_nivel_cargo from public.niveis_cargo order by nome_nivel_cargo");

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqNivelCargo = rs.getLong("seq_nivel_cargo");
                   String siglaNivelCargo = rs.getString("sigla_nivel_cargo");
                   String nomeNivelCargo = rs.getString("nome_nivel_cargo");
                   String descicaoNIvelCargo = rs.getString("descricao_nivel_cargo");

                 listaUnidadesRegime.add(new BeanCadastroNiveisCargos(seqNivelCargo, siglaNivelCargo, nomeNivelCargo, descicaoNIvelCargo));
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
