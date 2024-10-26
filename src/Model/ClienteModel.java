
package Model;

import java.util.ArrayList;

public class ClienteModel extends Pessoa{
    private int idCliente;
    private double consumo;
    private double saldo;
    private String bairro;
    private int quarteirao;
    private int nrDaCasa;
    private String dataContracto;
    private ArrayList<HistoricoHidrometroModel> historicosHidrometros;

    public ClienteModel() {
        historicosHidrometros = new ArrayList<>();
    }
    
    //HISTORICO DO HIDROMETRO
    //metodo para adicionar um historico de hidrometro
    public void adicionarHistoricoHidrometro(HistoricoHidrometroModel historicoHidrometro) {
        historicosHidrometros.add(historicoHidrometro);
    }

    //metodo para excluir um historico de hidrometro
    public void excluirHistoricoHidrometro(HistoricoHidrometroModel historicoHidrometro) {
        historicosHidrometros.remove(historicoHidrometro);
    }

    //metodo para ver o numero total de historico de hidrometro
    public int quantidadeHistoricoHidrometro() {
        return historicosHidrometros.size();
    }

    //metodo para pegar um historico de hidrometro especifico
    public HistoricoHidrometroModel getHistoricoHidrometro(int posicao) {
        return historicosHidrometros.get(posicao);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
        

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    
 
    
}
