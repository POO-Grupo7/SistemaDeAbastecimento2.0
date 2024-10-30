package Model;

import java.util.ArrayList;


public class HidrometroModel {
    private int idHidrometro;
    private String nrHidrometro;
    private String dataRegisto;
    private String estado;
    private boolean apagado;
    private ArrayList<LeituraModel> leituras;
    private ArrayList<HistoricoHidrometroModel> historicosHidrometros;

    public HidrometroModel() {
        this.estado = "operacional";
        this.apagado = false;
        leituras = new ArrayList<>();
        historicosHidrometros = new ArrayList<>();
    }

    //LEITURAS
    //metodo para adicionar uma leitura
    public void adicionarLeitura(LeituraModel leitura) {
        leituras.add(leitura);
    }

    //metodo para excluir uma leitura
    public void excluirLeitura(LeituraModel leitura) {
        leituras.remove(leitura);
    }

    //metodo para ver o numero total de facturacoes
    public int quantidadeLeitura() {
        return leituras.size();
    }

    //metodo para pegar uma leitura especifica
    public LeituraModel getLeituraModel(int posicao) {
        return leituras.get(posicao);
    }

    //HISTORICO DE HIDROMETRO
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

    //metodo para pegar um historico de hidrometro especifica
    public HistoricoHidrometroModel getHistoricoHidrometro(int posicao) {
        return historicosHidrometros.get(posicao);
    }

    public int getIdHidrometro() {
        return idHidrometro;
    }

    public void setIdHidrometro(int idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    public String getNrHidrometro() {
        return nrHidrometro;
    }

    public void setNrHidrometro(String nrHidrometro) {
        this.nrHidrometro = nrHidrometro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public boolean getApagado() {
        return apagado;
    }

    public void setApagado(boolean apagado) {
        this.apagado = apagado;
    }

    public String getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(String dataRegisto) {
        this.dataRegisto = dataRegisto;
    }
    
    

}
