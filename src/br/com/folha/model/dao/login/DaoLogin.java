/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.dao.login;

import br.com.folha.model.banco.postgres.ConnectionFactory;
import br.com.folha.model.bean.login.BeanOperadorLogado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andrei
 */
public class DaoLogin {

    
     Connection con = null;

     // MÉTODO AINDA POR SER IMPLEMENTADO parte do SQL
     public boolean selecionarOperadorValido(String cpf1, String senha) {
            List<BeanOperadorLogado> listaConsulta = new ArrayList<BeanOperadorLogado>();
            boolean resposta = false;
        try {
            con = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = con.prepareStatement(""+
                    "select distinct \n" +
                    "pessoas.nome as OPERADOR,\n" +
                    "pessoas.cpf as CPF, \n" +
                    "privilegios.nome_privilegio as PRIVILEGIO,\n" +
                    "operadores.seq_operador as SEQ_OPERADOR,\n" +
                    "privilegios.seq_privilegio as SEQ_PRIVILEGIO\n" +
                    "from public.operadores\n" +
                    "inner join public.pessoas on public.operadores.seq_pessoa = public.pessoas.seq_pessoa\n" +
                    "inner join public.privilegios on public.operadores.seq_privilegio = public.operadores.seq_privilegio\n" +
                    "where \n" +
                    "pessoas.cpf = ? and operadores.senha = ?\n" +
                    "and operadores.dt_cancelamento is null\n" +
                    "order by pessoas.cpf"
                );
                stmt.setString(1, cpf1);
                stmt.setString(2, senha);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    String nome = rs.getString("operador");
                    String cpf = rs.getString("cpf");
                    String privilegio = rs.getString("privilegio");
                    long seqOperador = rs.getInt("seq_operador");
                    long seqPrivilegio = rs.getInt("seq_privilegio");
                    
                    listaConsulta.add( new BeanOperadorLogado(nome, cpf, privilegio, seqOperador, seqPrivilegio));
                }

                if(!listaConsulta.isEmpty()){resposta = true;}

            } finally {
                try {
                    con.close();
                } catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        
        
            return resposta;
    }
     
     
    // MÉTODO AINDA POR SER IMPLEMENTADO parte do SQL
    public BeanOperadorLogado selecionarOperadorLogado(String cpf1) {
            List<BeanOperadorLogado> listaConsulta = new ArrayList<BeanOperadorLogado>();
            BeanOperadorLogado resposta = null;
        try {
            con = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = con.prepareStatement(""+
                    "select distinct \n" +
                    "pessoas.nome as OPERADOR,\n" +
                    "pessoas.cpf as CPF, \n" +
                    "privilegios.nome_privilegio as PRIVILEGIO,\n" +
                    "operadores.seq_operador as SEQ_OPERADOR,\n" +
                    "privilegios.seq_privilegio as SEQ_PRIVILEGIO\n" +
                    "from public.operadores\n" +
                    "inner join public.pessoas on public.operadores.seq_pessoa = public.pessoas.seq_pessoa\n" +
                    "inner join public.privilegios on public.operadores.seq_privilegio = public.operadores.seq_privilegio\n" +
                    "where \n" +
                    "pessoas.cpf = ?\n" +
                    "and operadores.dt_cancelamento is null\n" +
                    "order by pessoas.cpf"
                    );
                stmt.setString(1, cpf1);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    String nome = rs.getString("operador");
                    String cpf = rs.getString("cpf");
                    String privilegio = rs.getString("privilegio");
                    long seqOperador = rs.getInt("seq_operador");
                    long seqPrivilegio = rs.getInt("seq_privilegio");
                    
                    
                    listaConsulta.add( new BeanOperadorLogado(nome, cpf, privilegio, seqOperador, seqPrivilegio));
                }

                if(!listaConsulta.isEmpty()){resposta = listaConsulta.get(0);}

            } finally {
                try {
                    con.close();
                } catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        
            return resposta;
    }
    
    

    
    
    
    
    

}
