/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
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
public class PartidoDAO {
   public void create(Partido p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO partido (nome) VALUES (?)");
            stmt.setString(1,p.getNome());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
   
   public List <Partido> read(){
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Partido> partidos = new ArrayList<>();
        
        
       try {
           stmt = con.prepareStatement("SELECT * FROM partido");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               Partido p = new Partido();
               p.setIdPartido(rs.getInt("id_partido"));
               p.setNome(rs.getString("nome"));
               partidos.add(p);
               
           }
                   
                   } catch (SQLException ex) {
           Logger.getLogger(PartidoDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
       
       return partidos;
   }
   
   public void delete (Partido p){
    Connection con = ConnectionFactory.getConnection();
        
    PreparedStatement stmt = null;

    try {
        stmt = con.prepareStatement("DELETE FROM partido WHERE nome = ?");
           
            
        stmt.setString(1, p.getNome());
        stmt.executeUpdate();
            

        JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao apagar. " + ex);
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
   
   
   }
   

}
