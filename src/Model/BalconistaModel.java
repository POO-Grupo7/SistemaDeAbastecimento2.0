package Model;

import java.util.ArrayList;

public class BalconistaModel extends FuncionarioModel{
    private String perfilDeAcesso = "Balconista";
    private ArrayList<FacturacaoModel> listaFacturacao;

    public BalconistaModel() {
        listaFacturacao = new ArrayList<>();
    }
    
    private void adicionarBalconista(BalconistaModel balconista){
//        listaFacturacao.add(balconista);
    }

    public String getPerfilDeAcesso() {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso(String perfilDeAcesso) {
        this.perfilDeAcesso = perfilDeAcesso;
    }
    
    
}
