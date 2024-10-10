
package Model;

public class FacturacaoModel{

    private ClienteModel cliente;
    private static final double TAXA = 55.0;
    private String prazoDePagamento;
    private double descontos, iva,subTotal, totalFactura, dividaAnterior, dividaActual, consumoMensal;
    private String dataFacturacao, mesDeReferencia;
    private int nrDaFactura;
    private String nrLeitura;
    private boolean processada;

    public FacturacaoModel() {
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
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

    public boolean isProcessada() {
        return processada;
    }

    public void setProcessada(boolean processada) {
        this.processada = processada;
    }

            
}
