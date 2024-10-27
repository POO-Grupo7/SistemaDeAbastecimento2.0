package Model;

public class HistoricoHidrometroModel {
    private int idHistoricoHidrometro;
    private ClienteModel cliente;
    private HidrometroModel hidrometro;
    private String dataInicial;
    private String dataFinal;

    public int getIdHistoricoHidrometro() {
        return idHistoricoHidrometro;
    }

    public void setIdHistoricoHidrometro(int idHistoricoHidrometro) {
        this.idHistoricoHidrometro = idHistoricoHidrometro;
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

    public String imprimir(){
        return "Numero do Hidrometro: " + hidrometro.getNrHidrometro() +"\n"
                + "Data de inicio: " + this.dataInicial +"\n"
                + "Nome do Cliente: "+ cliente.getNome()+ "\nQt: "+ cliente.getQuarteirao() +"\n" +"Casa Nr: "
                + cliente.getNrDaCasa() ;
    }
    
}

