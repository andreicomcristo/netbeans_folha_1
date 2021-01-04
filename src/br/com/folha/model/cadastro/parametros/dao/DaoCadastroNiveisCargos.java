/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroClasses;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroNiveisCargos;
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
public class DaoCadastroNiveisCargos {

    Connection con = null;
    public boolean inserirNivelCargo(BeanCadastroNiveisCargos nivelCargos){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.niveis_cargo (sigla_nivel_cargo, nome_nivel_cargo, descricao_nivel_cargo) values ( ?,?,? )");
                        
            stmt.setString(1, nivelCargos.getSiglaNivelCargo());
            stmt.setString(2, nivelCargos.getNomeNivelCargo());
            stmt.setString(3, nivelCargos.getDescricaoNivelCargo());
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

    public boolean excluirNivelCargo(BeanCadastroNiveisCargos nivelCargos){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.niveis_cargo where public.niveis_cargo.seq_nivel_cargo = ? ");

                        stmt.setLong(1, nivelCargos.getSeqNivelCargo());
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

    public boolean alterarNivelCargo(BeanCadastroNiveisCargos nivelCargos) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.niveis_cargo set sigla_nivel_cargo = ?, nome_nivel_cargo = ?, descricao_nivel_cargo = ? where public.niveis_cargo.seq_nivel_cargo = ? ");

                        stmt.setString(1, nivelCargos.getSiglaNivelCargo());
                        stmt.setString(2, nivelCargos.getNomeNivelCargo());
                        stmt.setString(3, nivelCargos.getDescricaoNivelCargo());
                        stmt.setLong(4, nivelCargos.getSeqNivelCargo());
                        
                        
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
         

     public List<BeanCadastroNiveisCargos> selecionarNiveisCargo() {
        List<BeanCadastroNiveisCargos> listaNivelCargos = new ArrayList<BeanCadastroNiveisCargos>();

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

                 listaNivelCargos.add(new BeanCadastroNiveisCargos(seqNivelCargo, siglaNivelCargo, nomeNivelCargo, descicaoNIvelCargo));
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

     return listaNivelCargos;

 }
}
