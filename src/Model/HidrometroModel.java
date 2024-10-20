package Model;

import java.util.ArrayList;

public class HidrometroModel {
    private int idHidrometro;
    private String nrHidrometro;
    private boolean status;
    private boolean apagado;
    private ArrayList<FacturacaoModel> listaFacturacao;
    private ArrayList<HistoricoHidrometroModel> listaHistorico;

    public HidrometroModel() {
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

    public void setNrHiodrometro(String nrHidrometro) {
        this.nrHidrometro = nrHidrometro;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getApagado() {
        return apagado;
    }

    public void setApagado(boolean apagado) {
        this.apagado = apagado;
    }
    
    
    
    
    
    
}
