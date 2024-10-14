package Model;

public class LeituristaModel extends FuncionarioModel{
    private String perfilDeAcesso = "Leiturista";

    public LeituristaModel() {
    }

    public String getPerfilDeAcesso() {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso(String perfilDeAcesso) {
        this.perfilDeAcesso = perfilDeAcesso;
    }
    
}
