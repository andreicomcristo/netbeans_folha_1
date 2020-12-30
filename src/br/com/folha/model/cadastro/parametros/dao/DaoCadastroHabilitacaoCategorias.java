/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroHabilitacaoCategorias;
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
public class DaoCadastroHabilitacaoCategorias {

    Connection con = null;
    public boolean inserirHabilitacaoCategorias(BeanCadastroHabilitacaoCategorias HabilitacaoCategorias){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.habilitcao_categorias (nome_habilitacao_categoria, descricao_habilitacao_categoria) values ( ?,? )");

                        
            stmt.setString(1, HabilitacaoCategorias.getNomeHabilitacaoCategoria());
            stmt.setString(2, HabilitacaoCategorias.getDescricaoHabilitacaoCategoria());
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

    public boolean excluirHabilitacaoCategorias(BeanCadastroHabilitacaoCategorias HabilitacaoCategorias){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.habilitacao_categorias where public.sexos.seq_habilitacao_categoria = ? ");

                        stmt.setLong(1, HabilitacaoCategorias.getSeqHabilitacaoCategoria());
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

    public boolean alterarHabilitacaoCategorias(BeanCadastroHabilitacaoCategorias HabilitacaoCategoria) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.habilitacao_categorias set nome_habilitacao_categoria = ?, descricao_habilitacao_categoria = ?  where public.habilitacao_categorias.seq_habilitacao_categoria = ? ");

                        
                        stmt.setString(1, HabilitacaoCategoria.getNomeHabilitacaoCategoria());
                        stmt.setString(2, HabilitacaoCategoria.getDescricaoHabilitacaoCategoria());
                        stmt.setLong(3, HabilitacaoCategoria.getSeqHabilitacaoCategoria());
                        
                        
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
         

     public List<BeanCadastroHabilitacaoCategorias> selecionarHabilitacao() {
         
        List<BeanCadastroHabilitacaoCategorias> listaHabilitacao = new ArrayList<BeanCadastroHabilitacaoCategorias>();

     try {

       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_habilitacao_categoria, nome_habilitacao_categoria, descricao_habilitacao_categoria from public.habilitacao_categorias order by nome_habilitacao_categoria");
              
             ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                   long seqHabilitacao = rs.getLong("seq_habilitacao_categoria");
                   String nomesHabilitacao = rs.getString("nome_habilitacao_categoria");
                   String descricaoHabilitacao = rs.getString("descricao_habilitacao_categoria");

                 listaHabilitacao.add(new BeanCadastroHabilitacaoCategorias(seqHabilitacao, nomesHabilitacao, descricaoHabilitacao));
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

     return listaHabilitacao;

 }
}
