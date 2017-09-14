/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author pedro
 */
public class Login {

    private Connection con = ConnectionFactory.getConnection();

    public void create(Usuario usuario) {
        PreparedStatement stmt = null;

        String sql
                = "INSERT INTO lpoo.usuario ( nome, email, cpf) VALUES(?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso, string sql: " + sql);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro no metodo, string sql: " + sql + ". Exessao: " + ex);
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
}
