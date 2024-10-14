package Model;

public class BalconistaModel extends FuncionarioModel{
    private String perfilDeAcesso = "Balconista";

    public BalconistaModel() {
    }

    public String getPerfilDeAcesso() {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso(String perfilDeAcesso) {
        this.perfilDeAcesso = perfilDeAcesso;
    }
    
    
}
