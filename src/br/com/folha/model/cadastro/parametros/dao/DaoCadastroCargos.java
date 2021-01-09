    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCargos;
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
public class DaoCadastroCargos {

    Connection con = null;
    
    public boolean inserirCargos(BeanCadastroCargos cargos){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.cargos (nome_cargo, descricao_cargo, seq_nivel_cargo) values ( ?,?,?  )");

                        
            stmt.setString(1, cargos.getNomeCargo());
            stmt.setString(2, cargos.getDescricaoCargo());
            stmt.setLong(3, cargos.getSeqNivelCargo());

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

    public boolean excluirCargos(BeanCadastroCargos cargos){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.cargos where public.cargos.seq_cargo = ? ");

                        stmt.setLong(1, cargos.getSeqCargo());
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

    public boolean alterarCargos(BeanCadastroCargos cargos) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.cargos set nome_cargo = ?, descricao_cargo = ?, seq_nivel_cargo = ?  where public.cargos.seq_cargo = ? ");

                        
                        stmt.setString(1, cargos.getNomeCargo());
                        stmt.setString(2, cargos.getDescricaoCargo());
                        stmt.setLong(3, cargos.getSeqNivelCargo());
                        stmt.setLong(4, cargos.getSeqCargo());
                        
                        
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
         
    public List<BeanCadastroCargos> selecionarCargos(String consulta) {
        List<BeanCadastroCargos> listaConsulta = new ArrayList<BeanCadastroCargos>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_cargo, nome_cargo,  descricao_cargo, cargos.seq_nivel_cargo, nome_nivel_cargo from public.cargos  inner join public.niveis_cargo on public.cargos.seq_cargo = public.niveis_cargo.seq_nivel_cargo where nome_cargo like ? order by nome_cargo");
                                                          

              stmt.setString(1, "%"+consulta+"%");

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqCargo = rs.getLong("seq_cargo");
                   String nomeCargo = rs.getString("nome_cargo");
                   String descricaoCargo = rs.getString("descricao_cargo");
                   long seqNivelCargo = rs.getLong("seq_nivel_cargo");
                   String nomeNivelCargo = rs.getString("nome_nivel_cargo");

                 listaConsulta.add(new BeanCadastroCargos(seqCargo, nomeCargo, descricaoCargo, seqNivelCargo, nomeNivelCargo));

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

             PreparedStatement stmt = con.prepareStatement("select seq_nivel_cargo, nome_nivel_cargo from public.niveis_cargo order by nome_nivel_cargo");

             
             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long sequencia = rs.getLong("seq_nivel_cargo");
                   String texto = rs.getString("nome_nivel_cargo");
                   

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
