    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCargosEspecialidade;
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
public class DaoCadastroCargosEspecialidade {

    Connection con = null;
    public boolean inserirCargoEspecialidade(BeanCadastroCargosEspecialidade cargoEspecialidade){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.cargos_especialidade (nome_especialidade_cargo, descricao_especialidade_cargo, seq_cargo) values ( ?,?,?)");
                        
                        
            stmt.setString(1, cargoEspecialidade.getNomeCargo());
            stmt.setString(2, cargoEspecialidade.getDescriçãoEspecialidadeCargo());
            stmt.setLong(3, cargoEspecialidade.getSeqCargo());

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

    public boolean excluirCargoEspecialidade(BeanCadastroCargosEspecialidade cargoEspecialidade){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.cargos_especialidade where public.cargos_especialidade.seq_especialidade_cargo = ? ");

                        stmt.setLong(1, cargoEspecialidade.getSeqEspecialidadeCargo());
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

    public boolean alterarCargoEspecialidade(BeanCadastroCargosEspecialidade cargoEspecialidade) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.cargos_especialidade set nome_especialidade_cargo = ?, descricao_especialidade_cargo = ?, seq_cargo = ?  where public.cargos_especialidade.seq_especialidade_cargo = ? ");

                        
                        stmt.setString(1, cargoEspecialidade.getNomeCargo());
                        stmt.setString(2, cargoEspecialidade.getDescriçãoEspecialidadeCargo());
                        stmt.setLong(3, cargoEspecialidade.getSeqCargo());
                        stmt.setLong(4, cargoEspecialidade.getSeqEspecialidadeCargo());
                        
                        
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
         

     public List<BeanCadastroCargosEspecialidade> selecionarCargosEspecialidade() {
        List<BeanCadastroCargosEspecialidade> listaConsulta = new ArrayList<BeanCadastroCargosEspecialidade>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_especialidade_cargo, nome_especialidade_cargo, descricao_especialidade_cargo, cargos.seq_cargo, nome_cargo from public.cargos_especialidade inner join public.cargos on public.cargos_especialidade.seq_cargo = public.cargos.seq_cargo order by nome_cargo");
              
             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqEsoecialidadeCargo = rs.getLong("seq_especialidade_cargo");
                   String nomeEspecialidadeCargo = rs.getString("nome_especialidade_cargo");
                   String descricaoEspecialidadeCargo = rs.getString("descricao_especialidade_cargo");
                   long seqCargo = rs.getLong("seq_cargo");
                   String nomeCargo = rs.getString("nome_cargo");

                 listaConsulta.add(new BeanCadastroCargosEspecialidade(seqEsoecialidadeCargo, nomeEspecialidadeCargo, descricaoEspecialidadeCargo, seqCargo, nomeCargo));

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
     
     public List<BeanSequenciaTexto> selecionarCargos() {
        List<BeanSequenciaTexto> listaConsulta = new ArrayList<BeanSequenciaTexto>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_cargo, nome_cargo from public.cargos order by nome_cargo");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long sequencia = rs.getLong("seq_cargo");
                   String texto = rs.getString("nome_cargo");
                   

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
