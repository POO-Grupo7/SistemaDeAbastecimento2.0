/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author mac
 */
public class TaxaModel {
    private int id;
    private String nome;
    private String tipoconsumo;
    private double valortaxa;
    private String processada;

    public TaxaModel() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoconsumo() {
        return tipoconsumo;
    }

    public void setTipoconsumo(String tipoconsumo) {
        this.tipoconsumo = tipoconsumo;
    }

    public double getValortaxa() {
        return valortaxa;
    }

    public void setValortaxa(double valortaxa) {
        this.valortaxa = valortaxa;
    }

    public String getProcessada() {
        return processada;
    }

    public void setProcessada(String processada) {
        this.processada = processada;
    }


}
