/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class LeituraModel {

    private int idLeitura;
    private HistoricoHidrometroModel cliente;
    private double leituraActual;
    private double leituraAnterior;
    private double consumoMes;
    private String ocorrencia;
    private String dataEmissao;
    private String mesReferencia;
    private String nrLeitura;
    private boolean statusLeitura;

    public LeituraModel() {
    }

    public int getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(int idLeitura) {
        this.idLeitura = idLeitura;
    }

    public HistoricoHidrometroModel getCliente() {
        return cliente;
    }

    public void setCliente(HistoricoHidrometroModel cliente) {
        this.cliente = cliente;
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

    public boolean isStatusLeitura() {
        return statusLeitura;
    }

    public void setStatusLeitura(boolean statusLeitura) {
        this.statusLeitura = statusLeitura;
    }

    

}
