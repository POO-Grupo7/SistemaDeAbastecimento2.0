
package Model;

public class HidrometroModel {
    private ClienteModel cliente;
    private int IdHideometro;
    private int nrHidrometro;
    private boolean status;

    public HidrometroModel() {
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public int getIdHideometro() {
        return IdHideometro;
    }

    public void setIdHideometro(int IdHideometro) {
        this.IdHideometro = IdHideometro;
    }

    public int getNrHidrometro() {
        return nrHidrometro;
    }

    public void setNrHidrometro(int nrHidrometro) {
        this.nrHidrometro = nrHidrometro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
