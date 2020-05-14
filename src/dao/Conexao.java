package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://motty.db.elephantsql.com:5432/bpnrgfld","bpnrgfld", "yKnFom1EQMPDKlUHItF1Y5LlgoxK9XOG");
        return conexao;
    }
    
}