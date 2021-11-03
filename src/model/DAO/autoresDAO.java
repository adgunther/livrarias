/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import connection.bancoMysql;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.autores;
import model.editoras;

/**
 *
 * @author diego.menegazzi
 */
public class autoresDAO {

    public void cadastrar(autores a) {

        Connection conn = bancoMysql.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO autores (nome,endereco,numero,bairro,cidade,cpf) VALUES (?,?,?,?,?,?");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEndereco());
            stmt.setInt(3, a.getNumero());
            stmt.setString(4, a.getBairro());
            stmt.setString(5, a.getCidade());
            stmt.setBigDecimal(6, new BigDecimal(a.getCpf()));

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Autor cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o autor! Por favor, tente mais tarde.");
            Logger.getLogger(autoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<autores> listar() {

        Connection conn = bancoMysql.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<autores> autores = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM autores");
            rs = stmt.executeQuery();

            while (rs.next()) {
                autores e = new autores();
                e.setId(rs.getInt("id_autor"));
                e.setNome(rs.getString("nome"));
                e.setNome(rs.getString("endereco"));
                e.setId(rs.getInt("numero"));
                e.setNome(rs.getString("bairro"));
                e.setNome(rs.getString("cidade"));
                e.setNome(new BigDecimal(rs.getString("cpf")).toString());
                autores.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(autoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return autores;
    }

}
