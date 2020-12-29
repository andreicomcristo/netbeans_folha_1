/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCargaHorariaSemanal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroPrivilegios;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroVinculos;
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
 * @author andrei / André
 */
public class DaoCadastroPrivilegios {

    Connection con = null;
    
    public boolean inserirPrivilegios(BeanCadastroPrivilegios privilegio){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.privilegios (nome_privilegio, descricao_privilegio) values ( ?,? )");

                        
            stmt.setString(1, privilegio.getNomePrivilegio());
            stmt.setString(2, privilegio.getDescricaoPrivilegio());

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

    public boolean excluirPrivilegio(BeanCadastroPrivilegios privilegio){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.privilegios where public.privilegios.seq_privilegio = ? ");

                        stmt.setLong(1, privilegio.getSeqPrivilegio());
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

    public boolean alterarPrivilegio(BeanCadastroPrivilegios privilegio) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.privilegios set nome_privilegio = ?, descricao_privilegio = ?  where public.privilegios.seq_privilegio = ? ");

                        
                        stmt.setString(1, privilegio.getNomePrivilegio());
                        stmt.setString(2, privilegio.getDescricaoPrivilegio());
                        stmt.setLong(3, privilegio.getSeqPrivilegio());
                        
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
         
    public List<BeanCadastroPrivilegios> selecionarPrivilegio() {
        List<BeanCadastroPrivilegios> listaConsulta = new ArrayList<BeanCadastroPrivilegios>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_privilegio, nome_privilegio, descricao_privilegio from public.privilegios order by nome_privilegio");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqPrivilegio = rs.getLong("seq_privilegio");
                   String nomePrivilegio = rs.getString("nome_privilegio");
                   String descricaoPrivilegio = rs.getString("descricao_privilegio");

                 listaConsulta.add(new BeanCadastroPrivilegios(seqPrivilegio, nomePrivilegio, descricaoPrivilegio));

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
