package Model;

public class GestorModel extends FuncionarioModel{
    private String perfilDeAcesso = "Gestor";

    public GestorModel() {
    }

    public String getPerfilDeAcesso() {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso(String perfilDeAcesso) {
        this.perfilDeAcesso = perfilDeAcesso;
    }
    
}
