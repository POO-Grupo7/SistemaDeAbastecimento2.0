package Model;

abstract public class Pessoa {

    private int id;
    private String nome;
    private String apelido;
    private String naturalidade;
    private String moradia;
    private String dataDeNascimento;
    private String genero;
    private String estadoCivil;
    private String email;
    private String Activo;
    private String disp; //estado de exixtencia apagar/recuperar

    //Construtor vazio
    public Pessoa() {
        Activo = "Sim";
    }

//    //Construtor de Pessoa com id, nome e moradia
//    public Pessoa(int id, String nome, String moradia) {
//        this.id = id;
//        this.nome = nome;
//        this.moradia = moradia;
//    }
//    
//    //Construtor de Pessoa com varios atributos
//    public Pessoa(int id, String nome, String bi, String moradia, String dataDeNascimento, String genero, String estadoCivil) {
//        this.id = id;
//        this.nome = nome;
//        this.bi = bi;
//        this.moradia = moradia;
//        this.dataDeNascimento = dataDeNascimento;
//        this.genero = genero;
//        this.estadoCivil = estadoCivil;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public void SetNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
//metodos get e set para "Naturalidade";

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

//metodos get e set para "Moradia";

    public String getMoradia() {
        return moradia;
    }

    public void SetMoradia(String moradia) {
        this.moradia = moradia;
    }
//metodos get e set para "Data de nascimento";

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void SetDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
//metodos get e set para "genero";

    public String getGenero() {
        return genero;
    }

    public void SetGenero(String genero) {
        this.genero = genero;
    }
//metodos get e set para "Estado Civil";

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void SetEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }
    
    

}
