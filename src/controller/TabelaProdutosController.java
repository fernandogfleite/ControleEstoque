package controller;

import dao.Conexao;
import model.Produto;
import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import view.TabelaProdutosView;

public class TabelaProdutosController {
    private final TabelaProdutosView view;
    public TabelaProdutosController(TabelaProdutosView view) {
        this.view = view;
    }
    
    public void lerTabela() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) view.getjTable2().getModel();
        Connection conexao = new Conexao().getConnection();
        ProdutoDAO produtoDao = new ProdutoDAO(conexao);
        
        for (Produto p: produtoDao.getInfo()){
            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getNomeProduto(),
                p.getValorProduto()
            });
        }
    }
    
}
