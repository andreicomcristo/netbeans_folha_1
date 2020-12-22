/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.dao.login;

import br.com.folha.banco.postgres.ConnectionFactory;
import br.com.folha.model.login.BeanOperadorLogado;
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
                PreparedStatement stmt = con.prepareStatement("select distinct ");
                //stmt.setString(1, cpf1);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    String nome = rs.getString("operador");
                    String cpf = rs.getString("operador");
                    String privilegio = rs.getString("operador");
                    int seqOperador = rs.getInt("operador");
                    int seqPrivilegio = rs.getInt("operador");
                    
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
        
        resposta = true;
            return resposta;
    }
     
     
    // MÉTODO AINDA POR SER IMPLEMENTADO parte do SQL
    public BeanOperadorLogado selecionarOperadorLogado(String cpf1) {
            List<BeanOperadorLogado> listaConsulta = new ArrayList<BeanOperadorLogado>();
            BeanOperadorLogado resposta = null;
        try {
            con = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = con.prepareStatement("select distinct ");
                //stmt.setString(1, cpf1);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    String nome = rs.getString("operador");
                    String cpf = rs.getString("operador");
                    String privilegio = rs.getString("operador");
                    int seqOperador = rs.getInt("operador");
                    int seqPrivilegio = rs.getInt("operador");
                    
                    
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
        resposta = new BeanOperadorLogado("ANDREI MAGALHAES", "12345678910", "MASTER", 1, 1);
            return resposta;
    }
    
    

    
    
    
    
    

}
