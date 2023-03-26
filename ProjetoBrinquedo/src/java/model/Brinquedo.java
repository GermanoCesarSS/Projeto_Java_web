package model;
public class Brinquedo {

    public Brinquedo(int codigoBrinquedo, String nomeBrinquedo) {
        this.codigoBrinquedo = codigoBrinquedo;
        this.nomeBrinquedo = nomeBrinquedo;
    }

    public int getCodigoBrinquedo() {
        return codigoBrinquedo;
    }

    public void setCodigoBrinquedo(int codigoBrinquedo) {
        this.codigoBrinquedo = codigoBrinquedo;
    }

    public String getNomeBrinquedo() {
        return nomeBrinquedo;
    }

    public void setNomeBrinquedo(String nomeBrinquedo) {
        this.nomeBrinquedo = nomeBrinquedo;
    }

    public Brinquedo() {
    }
    private int codigoBrinquedo;
    private String nomeBrinquedo;
}
