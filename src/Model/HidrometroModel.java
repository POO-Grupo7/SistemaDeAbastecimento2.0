package Model;

public class HidrometroModel {
    private int idHidrometro;
    private String nrHiodrometro;
    private boolean status;
    private boolean apagado;

    public HidrometroModel() {
    }

    public int getIdHidrometro() {
        return idHidrometro;
    }

    public void setIdHidrometro(int idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    public String getNrHiodrometro() {
        return nrHiodrometro;
    }

    public void setNrHiodrometro(String nrHiodrometro) {
        this.nrHiodrometro = nrHiodrometro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isApagado() {
        return apagado;
    }

    public void setApagado(boolean apagado) {
        this.apagado = apagado;
    }
    
    
    
    
    
    
}
