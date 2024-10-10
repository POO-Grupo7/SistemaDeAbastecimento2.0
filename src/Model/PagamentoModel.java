package Model;

public class PagamentoModel {

    private int idPagamento;
    private ClienteModel cliente;
    private String dataPagamento;
    private String prazoPagamento;
    private boolean statusPagamento;
    private int nrDaFactura;
    private double valorDaFactura;
    private double multa;
    private double valorTotal;
    private double valorPago;
    private double trocos;
    private String nomeDoCliente;
    private int nrRecibo;

    public PagamentoModel() {
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPrazoPagamento() {
        return prazoPagamento;
    }

    public void setPrazoPagamento(String prazoPagamento) {
        this.prazoPagamento = prazoPagamento;
    }

    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public int getNrDaFactura() {
        return nrDaFactura;
    }

    public void setNrDaFactura(int nrDaFactura) {
        this.nrDaFactura = nrDaFactura;
    }

    public double getValorDaFactura() {
        return valorDaFactura;
    }

    public void setValorDaFactura(double valorDaFactura) {
        this.valorDaFactura = valorDaFactura;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getTrocos() {
        return trocos;
    }

    public void setTrocos(double trocos) {
        this.trocos = trocos;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public int getNrRecibo() {
        return nrRecibo;
    }

    public void setNrRecibo(int nrRecibo) {
        this.nrRecibo = nrRecibo;
    }
    
    
}
