/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package folha.parametros.cadastros.classe;

import conexao.banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andrei
 */
public class acoesCadastroCH_SEMANAL {

    acoesCadastroCH_SEMANAL acoesCadastroCH_SEMANAL;
    CadastroCH_SEMANAL cadastroCH_SEMANAL;
    CH_SEMANAL ch_semanal = new CH_SEMANAL();
    DaoCH_SEMANAL daoCH_SEMANAL = new DaoCH_SEMANAL();
    
    
    

    public boolean inserirCH(CH_SEMANAL ch_semanal){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.CH_SEMANAL (CH, DESCRICAO_CH ) values ( ?,? )");

            stmt.setInt(1, ch_semanal.getCH());
            stmt.setString(2, ch_semanal.getDESCRICAO_CH());

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
    
    public boolean excluir_CH_SEMANAL(CH_SEMANAL ch_semanal){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.CH_SEMANAL where public.CH_SEMANAL.CH = ? ");

                        stmt.setInt(1, ch_semanal.getSEQ_CH_SEMANAL());

			stmt.execute();
			stmt.close();

			con.close();
                        executou = true;

		} catch (SQLException e) {
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

    public boolean alterar_CH_SEMANAL(CH_SEMANAL ch_semanal){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.CH_SEMANAL set CH = ?, DESCRICAO_CH = ?  where public.CH_SEMANAL.SEQ_CH_SEMANAL = ? ");

                        stmt.setInt(1, ch_semanal.getCH());
                        stmt.setString(2, ch_semanal.getDESCRICAO_CH());
                        stmt.setInt(3, ch_semanal.getSEQ_CH_SEMANAL());

			stmt.execute();
			stmt.close();

			con.close();
                        executou = true;

		} catch (SQLException e) {
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
         
    public List<CH_SEMANAL> selectCH() {

        List<CH_SEMANAL> listaConsulta = new ArrayList<CH_SEMANAL>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select SEQ_CH_SEMANAL, CH, DESCRICAO_CH from public.CH_SEMANAL order by CH");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   int SEQ_CH_SEMANAL = rs.getInt("SEQ_CH_SEMANAL");
                   int CH = rs.getInt("CH");
                   String DESCRICAO_CH = rs.getString("DESCRICAO_CH");

                 listaConsulta.add(new CH_SEMANAL(SEQ_CH_SEMANAL, CH, DESCRICAO_CH));

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
