/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.dao.login.dao;

import br.com.folha.util.ConnectionFactory;
import br.com.folha.model.bean.principal.beanSwing.BeanPrincipal;
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
            List<BeanPrincipal> listaConsulta = new ArrayList<BeanPrincipal>();
            boolean resposta = false;
        try {
            con = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = con.prepareStatement(""+
                    "select distinct \n" +
                    "pessoa.nome as OPERADOR,\n" +
                    "pessoa.cpf as CPF, \n" +
                    "privilegios.nome_privilegio as PRIVILEGIO,\n" +
                    "pessoa_operadores.seq_operador as SEQ_OPERADOR,\n" +
                    "privilegios.seq_privilegio as SEQ_PRIVILEGIO\n" +
                    "from public.pessoa_operadores\n" +
                    "inner join public.pessoa on public.pessoa_operadores.seq_pessoa = public.pessoa.seq_pessoa\n" +
                    "inner join public.privilegios on public.pessoa_operadores.seq_privilegio = public.pessoa_operadores.seq_privilegio\n" +
                    "where \n" +
                    "pessoa.cpf = ? and pessoa_operadores.senha = ?\n" +
                    "and pessoa_operadores.dt_cancelamento is null\n" +
                    "order by pessoa.cpf"
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
                    
                    listaConsulta.add( new BeanPrincipal(nome, cpf, privilegio, seqOperador, seqPrivilegio));
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
    public BeanPrincipal selecionarOperadorLogado(String cpf1) {
            List<BeanPrincipal> listaConsulta = new ArrayList<BeanPrincipal>();
            BeanPrincipal resposta = null;
        try {
            con = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = con.prepareStatement(""+
                    "select distinct \n" +
                    "pessoa.nome as OPERADOR,\n" +
                    "pessoa.cpf as CPF, \n" +
                    "privilegios.nome_privilegio as PRIVILEGIO,\n" +
                    "pessoa_operadores.seq_operador as SEQ_OPERADOR,\n" +
                    "privilegios.seq_privilegio as SEQ_PRIVILEGIO\n" +
                    "from public.pessoa_operadores\n" +
                    "inner join public.pessoa on public.pessoa_operadores.seq_pessoa = public.pessoa.seq_pessoa\n" +
                    "inner join public.privilegios on public.pessoa_operadores.seq_privilegio = public.pessoa_operadores.seq_privilegio\n" +
                    "where \n" +
                    "pessoa.cpf = ?\n" +
                    "and pessoa_operadores.dt_cancelamento is null\n" +
                    "order by pessoa.cpf"
                    );
                stmt.setString(1, cpf1);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    String nome = rs.getString("operador");
                    String cpf = rs.getString("cpf");
                    String privilegio = rs.getString("privilegio");
                    long seqOperador = rs.getInt("seq_operador");
                    long seqPrivilegio = rs.getInt("seq_privilegio");
                    
                    
                    listaConsulta.add( new BeanPrincipal(nome, cpf, privilegio, seqOperador, seqPrivilegio));
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
