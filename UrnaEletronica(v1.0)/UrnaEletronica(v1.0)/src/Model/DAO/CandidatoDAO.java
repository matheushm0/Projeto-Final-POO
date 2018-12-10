/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Candidato;
import Model.bean.Partido;
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
public class CandidatoDAO {

    public void create(Candidato c) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO candidato (nome,numero,voto)VALUES(?,?,?)");
            stmt.setString(1,c.getNomeCandidato());
            stmt.setInt(2,c.getNumeroCandidato());
            stmt.setInt(3, c.getVotos());
            
            
           
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
     public List <Candidato> read(){
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList<>();
        
        
       try {
           stmt = con.prepareStatement("SELECT * FROM candidato");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               Candidato c = new Candidato();
               c.setNomeCandidato(rs.getString("nome"));
               c.setNumeroCandidato(rs.getInt("numero"));
               c.setIdPartido((Partido)rs.getObject("id_partido"));
               c.setVotos(rs.getInt("voto"));
               
               
              
               candidatos.add(c);
               
           }
                   
                   } catch (SQLException ex) {
           Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
       
       return candidatos;
   }
     
    public List <Candidato> readCandidato(String n){
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList<>();
        
        
       try {
           stmt = con.prepareStatement("SELECT * FROM candidato WHERE numero LIKE ?");
           stmt.setString(1,"%"+n+"%");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               Candidato c = new Candidato();
               c.setNomeCandidato(rs.getString("nome"));
               c.setNumeroCandidato(rs.getInt("numero"));
               c.setIdPartido((Partido)rs.getObject("id_partido"));
               
              
               candidatos.add(c);
               
           }
                   
                   } catch (SQLException ex) {
           Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
       
       return candidatos;
   }
    public void update(Candidato c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE candidato SET voto=voto+1 WHERE numero = ?");
           
            
            stmt.setInt(1, c.getNumeroCandidato());
            stmt.executeUpdate();
            

            JOptionPane.showMessageDialog(null, "Fim!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao votar. " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Candidato c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM candidato WHERE numero = ?");
           
            
            stmt.setInt(1, c.getNumeroCandidato());
            stmt.executeUpdate();
            

            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar. " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
     
   
}
