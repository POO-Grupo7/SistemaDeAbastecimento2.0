
package Model;

public class LeituraModel {

    private int idLeitura;
    private HistoricoHidrometroModel historicoHidrometro;
//    private FuncionarioModel funcionario;
    private double leituraActual;
    private double leituraAnterior;
    private double consumoMes;
    private String ocorrencia;
    private String dataEmissao;
    private String mesReferencia;
    private String nrLeitura;
    private boolean statusLeitura;
    private boolean estadoFacturacao;
    

    public LeituraModel() {
        this.statusLeitura = true;
        this.estadoFacturacao = false;
    }
    
    public int getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(int idLeitura) {
        this.idLeitura = idLeitura;
    }

    public HistoricoHidrometroModel getHistoricoHidrometro() {
        return historicoHidrometro;
    }

    public void setHistoricoHidrometro(HistoricoHidrometroModel historicoHidrometro) {
        this.historicoHidrometro = historicoHidrometro;
    }

    public double getLeituraActual() {
        return leituraActual;
    }

    public void setLeituraActual(double leituraActual) {
        this.leituraActual = leituraActual;
    }

    public double getLeituraAnterior() {
        return leituraAnterior;
    }

    public void setLeituraAnterior(double leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
    }

    public double getConsumoMes() {
        return consumoMes;
    }

    public void setConsumoMes(double consumoMes) {
        this.consumoMes = consumoMes;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getNrLeitura() {
        return nrLeitura;
    }

    public void setNrLeitura(String nrLeitura) {
        this.nrLeitura = nrLeitura;
    }

    public boolean getStatusLeitura() {
        return statusLeitura;
    }

    public void setStatusLeitura(boolean statusLeitura) {
        this.statusLeitura = statusLeitura;
    }

    public boolean getEstadoFacturacao() {
        return estadoFacturacao;
    }

    public void setEstadoFacturacao(boolean estadoFacturacao) {
        this.estadoFacturacao = estadoFacturacao;
    }

    
}
