package model;

public class Usuario {
    private String nomeUsuario;
    private String cpf;
    private String senha;  
    private String tipoAcesso;

    public Usuario(String nomeCliente, String cpf, String senha, String tipoAcesso) {
        this.nomeUsuario = nomeCliente;
        this.cpf = cpf;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
    }

    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    
    
    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    
    public String getCpf() {
        return cpf;
    }

    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public String getSenha() {
        return senha;
    }

   
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }
    
    
}
