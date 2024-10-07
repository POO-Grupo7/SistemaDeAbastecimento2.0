
package Model;

import java.util.Date;

public class ClienteModel extends Pessoa{

    private String status;
    private double consumo;
    private int contacto;
    private double saldo;
    private int quarteirao;
    private int nrDaCasa;
    private String dataContracto;
    private String hidrometro;
    private String nomeDoCliente;


    public ClienteModel() {
        status="Sim";
    }

    public String getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(String hidrometro) {
        this.hidrometro = hidrometro;
    }
    

    public String getDataContracto() {
        return dataContracto;
    }

    public void setDataContracto(String dataContracto) {
        this.dataContracto = dataContracto;
    }

    
    public int getNrDaCasa() {
        return nrDaCasa;
    }

    public void setNrDaCasa(int nrDaCasa) {
        this.nrDaCasa = nrDaCasa;
    }
    

    public int getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(int quarteirao) {
        this.quarteirao = quarteirao;
    }
    

    public String Status() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    

//    public float getPagamento() {
//        return pagamento;
//    }
//
//    public void setPagamento(float pagamento) {
//        this.pagamento = pagamento;
//    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }
    
    
}
