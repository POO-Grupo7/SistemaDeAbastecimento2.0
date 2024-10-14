
package Model;

public class UsuarioModel extends Pessoa {
    private String senhaUsuario;
    private String nomeUsuario;
    private String funcaoUsuario;
    private String perfilDeAcesso;
    private byte[] imagemBytes;

    
    //Construtor vazio
    public UsuarioModel() {
    }
 
    //Getters e Setters

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    public String getSenha() {
        return senhaUsuario;
    }

    public void setSenha(String senha) {
        this.senhaUsuario = senha;
    }

    public String getFuncaoUsuario() {
        return funcaoUsuario;
    }

    public void setFuncaoUsuario(String funcaoUsuario) {
        this.funcaoUsuario = funcaoUsuario;
    }
    

    public String getPerfilDeAcesso() {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso(String perfilDeAcesso) {
        this.perfilDeAcesso = perfilDeAcesso;
    }

  

}