package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {

    
    
    private final Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    
    public void insert(Produto produto) throws SQLException{
                   
        String sql = "insert into produto(nome,valor) values(?,?);";            
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, produto.getNomeProduto());
        statement.setDouble(2, produto.getValorProduto());    
        statement.execute();            
        connection.close();
    }
    
    public  boolean existePorId(Produto produto) throws SQLException {
        String sql = "select * from produto where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, produto.getIdProduto());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }
    
   
    
    public List<Produto> getInfo() throws SQLException{
        String sql = "select * from produto";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while (rs.next()){
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("id"));
            produto.setNomeProduto(rs.getString("nome"));
            produto.setValorProduto(rs.getDouble("valor"));
            
            produtos.add(produto);
            
            
        }
        
        return produtos;
        
        
    }
}
