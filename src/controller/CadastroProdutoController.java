package controller;

import dao.Conexao;
import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Produto;
import view.CadastroProdutoView;

public class CadastroProdutoController {

    private final CadastroProdutoView view;

    public CadastroProdutoController(CadastroProdutoView view) {
        this.view = view;
    }
    
    
    public void salvaProduto(){
        String nomeProduto = view.getjTextFieldNomeProduto().getText();
        double valorProduto = Double.parseDouble(view.getjTextFieldValorProduto().getText());
        
        
        Produto produtoCriar = new Produto(nomeProduto, valorProduto, 0);
        
        try {
            Connection conexao = new Conexao().getConnection();
            ProdutoDAO produtoDao = new ProdutoDAO(conexao);
            produtoDao.insert(produtoCriar);
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");
            view.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
