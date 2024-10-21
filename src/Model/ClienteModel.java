package Model;

public class ClienteModel extends Pessoa {

    private int id;
    private double consumo;
    private int contacto;
    private double saldo;
    private int quarteirao;
    private int nrDaCasa;
    private String dataContracto;
    private String hidrometro;
    private String bairro;

    public ClienteModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(int quarteirao) {
        this.quarteirao = quarteirao;
    }

    public int getNrDaCasa() {
        return nrDaCasa;
    }

    public void setNrDaCasa(int nrDaCasa) {
        this.nrDaCasa = nrDaCasa;
    }

    public String getDataContracto() {
        return dataContracto;
    }

    public void setDataContracto(String dataContracto) {
        this.dataContracto = dataContracto;
    }

    public String getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(String hidrometro) {
        this.hidrometro = hidrometro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    
}
