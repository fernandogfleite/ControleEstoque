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
import model.Usuario;
import view.LoginUsuarioView;
import view.MenuAdminView;
import view.MenuClienteView;

/**
 *
 * @author ferna
 */
public class LoginUsuarioController {

    private final LoginUsuarioView view;

    public LoginUsuarioController(LoginUsuarioView view) {
        this.view = view;
    }
    
    public void autenticar() throws SQLException{
        String cpf = view.getjTextFieldCPFLogin().getText();
        String senha = view.getjPasswordFieldSenhaLogin().getText();
        Usuario usuarioAutenticar = new Usuario(cpf, senha);
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        boolean existe = usuarioDao.existePorCPFESenha(usuarioAutenticar);
        
        if (existe){
            String tipoAcesso = usuarioDao.getTipoAcesso(usuarioAutenticar);
            if ("Cliente".equals(tipoAcesso)){
                MenuClienteView menu = new MenuClienteView();
                view.setVisible(false);
                menu.setVisible(true);
            }
            else{
                MenuAdminView menu = new MenuAdminView();
                view.setVisible(false);
                menu.setVisible(true);
            }
        }   
    }
}