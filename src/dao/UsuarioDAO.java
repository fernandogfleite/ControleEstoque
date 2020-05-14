package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {

    
    
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    
    public void insert(Usuario usuario) throws SQLException{
                   
        String sql = "insert into usuario(nome,cpf,senha,tipoacesso) values(?,?,?,?);";            
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNomeUsuario());
        statement.setString(2, usuario.getCpf());
        statement.setString(3, usuario.getSenha());
        statement.setString(4, usuario.getTipoAcesso());
        statement.execute();            
        connection.close();
    }
    
    public  boolean existePorCPFESenha(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where cpf = ? and senha = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getSenha());
        statement.execute(); 
        ResultSet resultSet = statement.getResultSet();
        
        return resultSet.next();
    }
    
    public String getTipoAcesso(Usuario usuario) throws SQLException{
        String sql = "select tipoacesso from usuario where cpf = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        ResultSet rs = statement.executeQuery();
        
        if(rs.next()){
            return rs.getString("tipoacesso");
        }
        return null;
    }
}
