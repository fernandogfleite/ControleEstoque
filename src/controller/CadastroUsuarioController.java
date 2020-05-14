/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadastroUsuarioView;

/**
 *
 * @author ferna
 */
public class CadastroUsuarioController {

    private final CadastroUsuarioView view;

    public CadastroUsuarioController(CadastroUsuarioView view) {
        this.view = view;
    }
    
    public void salvaUsuario(String tipoAcesso){
        String nome = view.getjTextFieldNome().getText();
        String cpf = view.getjTextFieldCPF().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        Usuario usuarioCriar = new Usuario(nome, cpf, senha, tipoAcesso);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuarioCriar);
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso");
            view.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    
    }
    
}
