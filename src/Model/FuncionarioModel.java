
package Model;

public class FuncionarioModel extends Pessoa {
    private int idFuncionario;
    private String senhaFuncionario;
    private String nomeFuncionario;
    private String dataNascimento;
    private String funcaoFuncionario;
    private String perfilDeAcesso;
    private String NaturalidadeFuncionario;
    
//    private byte[] imagemBytes;
    
    //Construtor vazio
    public FuncionarioModel() {
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getNaturalidadeFuncionario() {
        return NaturalidadeFuncionario;
    }

    public void setNaturalidadeFuncionario(String NaturalidadeFuncionario) {
        this.NaturalidadeFuncionario = NaturalidadeFuncionario;
    }

   

    

}