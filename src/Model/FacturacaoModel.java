
package Model;

public class FacturacaoModel{

    private int idFacturacao;
    private LeituraModel leitura;
    private BalconistaModel balconista;
    private HistoricoHidrometroModel historicoHidrometro;
    private double taxa;
    private String prazoDePagamento;
    private double descontos, iva,subTotal, totalFactura, dividaAnterior, dividaActual, consumoMensal;
    private String dataFacturacao, mesDeReferencia, processada;
    private int nrDaFactura;
    private String nrLeitura;
    private String nome, disp;

    public int getIdFacturacao() {
        return idFacturacao;
    }

    public void setIdFacturacao(int idFacturacao) {
        this.idFacturacao = idFacturacao;
    }

    public LeituraModel getLeitura() {
        return leitura;
    }

    public void setLeitura(LeituraModel leitura) {
        this.leitura = leitura;
    }

    public BalconistaModel getBalconista() {
        return balconista;
    }

    public void setBalconista(BalconistaModel balconista) {
        this.balconista = balconista;
    }

    public HistoricoHidrometroModel getHistoricoHidrometro() {
        return historicoHidrometro;
    }

    public void setHistoricoHidrometro(HistoricoHidrometroModel historicoHidrometro) {
        this.historicoHidrometro = historicoHidrometro;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public String getPrazoDePagamento() {
        return prazoDePagamento;
    }

    public void setPrazoDePagamento(String prazoDePagamento) {
        this.prazoDePagamento = prazoDePagamento;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public double getDividaAnterior() {
        return dividaAnterior;
    }

    public void setDividaAnterior(double dividaAnterior) {
        this.dividaAnterior = dividaAnterior;
    }

    public double getDividaActual() {
        return dividaActual;
    }

    public void setDividaActual(double dividaActual) {
        this.dividaActual = dividaActual;
    }

    public double getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(double consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public String getDataFacturacao() {
        return dataFacturacao;
    }

    public void setDataFacturacao(String dataFacturacao) {
        this.dataFacturacao = dataFacturacao;
    }

    public String getMesDeReferencia() {
        return mesDeReferencia;
    }

    public void setMesDeReferencia(String mesDeReferencia) {
        this.mesDeReferencia = mesDeReferencia;
    }

    public String getProcessada() {
        return processada;
    }

    public void setProcessada(String processada) {
        this.processada = processada;
    }

    public int getNrDaFactura() {
        return nrDaFactura;
    }

    public void setNrDaFactura(int nrDaFactura) {
        this.nrDaFactura = nrDaFactura;
    }

    public String getNrLeitura() {
        return nrLeitura;
    }

    public void setNrLeitura(String nrLeitura) {
        this.nrLeitura = nrLeitura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

        
}
