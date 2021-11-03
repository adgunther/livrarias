/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.bancoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.editoras;

/**
 *
 * @author adriana.gunther
 */
public class livrosDAO {
   public class editorasDAO {
   
    public void cadastrar(livros 1){
         
        Connection conn = bancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = conn.prepareStatement("INSERT INTO livros (id_editoras,id_autor,titulo,ano)" + "VALUES (?,?,?,?)");
            stmt.setInt(1, 1.getEditoras ().getId());
            stmt.setInt(2, 1.getAutores ().getId());
            stmt.setString(3, 1.getTitulo());
            stmt.setInt(4, 1.getAno());
            
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                                   
        } catch(SQLException ex){  
            Logger.getLogger(livrosDAO.class.getName()).log(Level.SEVERE,null,ex);
        }                      
        }
                
    } 
}
