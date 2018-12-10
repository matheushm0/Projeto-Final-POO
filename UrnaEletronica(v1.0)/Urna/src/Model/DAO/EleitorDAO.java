/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Candidato;
import Model.bean.Eleitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan's PC
 */
public class EleitorDAO {
     
    public void create(Eleitor e) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO eleitor (nome,cpf,cep,rua,bairro,numero)VALUES(?,?,?,?,?,?)");
            stmt.setString(1,e.getNomeEleitor());
            stmt.setString(2,e.getCpf());
            stmt.setString(3,e.getCep());
            stmt.setString(4,e.getRua());
            stmt.setString(5,e.getBairro());
            stmt.setString(6,e.getNumero());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     public List <Eleitor> read(){
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Eleitor> eleitores = new ArrayList<>();
        
        
       try {
           stmt = con.prepareStatement("SELECT * FROM eleitor");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               Eleitor e = new Eleitor();
               e.setIdEleitor(rs.getInt("id_eleitor"));
               e.setNomeEleitor(rs.getString("nome"));
               e.setCpf(rs.getString("cpf"));
               e.setCep(rs.getString("cep"));
               e.setRua(rs.getString("rua"));
               e.setBairro(rs.getString("bairro"));
               e.setNumero(rs.getString("numero"));
               eleitores.add(e);
               
           }
                   
                   } catch (SQLException ex) {
           Logger.getLogger(EleitorDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
       
       return eleitores;
   }
   
     public void delete(Eleitor e) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM eleitor WHERE nome = ?");
           
            
            stmt.setString(1, e.getNomeEleitor());
            stmt.executeUpdate();
            

            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar. " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
