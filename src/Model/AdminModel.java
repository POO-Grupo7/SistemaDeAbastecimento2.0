
package Model;

public class AdminModel extends FuncionarioModel{
    private String perfilDeAcesso = "Admin";

    public AdminModel() {
    }

    public String getPerfilDeAcesso() {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso(String perfilDeAcesso) {
        this.perfilDeAcesso = perfilDeAcesso;
    }
    
}
