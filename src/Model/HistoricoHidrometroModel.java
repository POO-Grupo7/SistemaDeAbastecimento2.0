package Model;

public class HistoricoHidrometroModel {
    private ClienteModel cliente;
    private HidrometroModel hidrometro;
    private String dataInicial;
    private String dataFinal;

    public HistoricoHidrometroModel() {
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public HidrometroModel getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(HidrometroModel hidrometro) {
        this.hidrometro = hidrometro;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    
}

