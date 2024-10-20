
package Model;

public class FuncionarioModel extends Pessoa {
    private String senhaFuncionario;
    private String nomeFuncionario;
    private String dataNascimento;
    private String funcaoFuncionario;
    private String perfilDeAcesso;
//    private byte[] imagemBytes;
    
    //Construtor vazio
    public FuncionarioModel() {
    }
 
    //Getters e Setters

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    
    public String getSenha() {
        return senhaFuncionario;
    }

    public void setSenha(String senha) {
        this.senhaFuncionario = senha;
    }

    public String getFuncaoFuncionario() {
        return funcaoFuncionario;
    }

    public void setFuncaoFuncionario(String funcaoFuncionario) {
        this.funcaoFuncionario = funcaoFuncionario;
    }
    

    public String getPerfilDeAcesso() {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso(String perfilDeAcesso) {
        this.perfilDeAcesso = perfilDeAcesso;
    }

  

}