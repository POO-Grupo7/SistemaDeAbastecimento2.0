package Model;

abstract public class Pessoa {
    
    private String nome;
    private String apelido;
    private String email;
    private int nrTelefone;
    private boolean status;
    private boolean disp; //estado de exixtencia apagar/recuperar

    public Pessoa() {
        this.status = true;
        this.disp = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(int nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }


}
