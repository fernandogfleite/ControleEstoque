package controller;

import dao.Conexao;
import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import model.Produto;
import view.FazerCompraView;
import java.util.List;
import javax.swing.JOptionPane;

public class FazerCompraController {
    private final FazerCompraView view;
    public FazerCompraController(FazerCompraView view) {
        this.view = view;
    }
    
    public void addCarrinho() throws SQLException{
        Produto produtoV = new Produto(Integer.parseInt(view.getjTextFieldIdProduto().getText()), Integer.parseInt(view.getjTextFieldQntdProduto().getText()));
        Connection conexao = new Conexao().getConnection();
        ProdutoDAO produtoDao = new ProdutoDAO(conexao);
        List<Produto> produtos = produtoDao.getInfo();
        int tamanho = produtos.size();
        int cont = 0;
        for (Produto produto: produtos){
            if(produtoV.getIdProduto() == produto.getIdProduto()){
                produtoV = produto;
                break;
            }
            if (cont == tamanho){
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
                break;
            }
            cont++;
        }       
            view.subtotal += Double.parseDouble(view.getjTextFieldQntdProduto().getText())*produtoV.getValorProduto();
            view.getjLabelSubtotal().setText(String.valueOf(view.subtotal));
            
    }
    
    
}
