/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LUIZ FELIPE
 */
public class Conexao {

    public Conexao() {

    }

    private static final String url = "jdbc:mysql://127.0.0.1:3306/cadastropaciente";
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String drive = "com.mysql.jdbc.Driver";
    public static Connection con = null;

    public static Connection Conectar() throws SQLException {
        System.out.println("Conectando ao banco...");

        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado!");

        } catch (ClassNotFoundException ex) {

            System.out.println("Classe não enconrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException e) {

            System.out.println(e);
            throw new RuntimeException(e);
        }

        return con;

    }

}
