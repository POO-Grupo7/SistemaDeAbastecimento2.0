package Model;
import java.util.ArrayList;

public class LeituristaModel extends FuncionarioModel{
    private String perfilDeAcesso = "Leiturista";
    private ArrayList<LeituraModel> listaLeituras;

    public LeituristaModel() {
        listaLeituras = new ArrayList();
    }        

    public String getPerfilDeAcesso() {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso(String perfilDeAcesso) {
        this.perfilDeAcesso = perfilDeAcesso;
    }
    
}
