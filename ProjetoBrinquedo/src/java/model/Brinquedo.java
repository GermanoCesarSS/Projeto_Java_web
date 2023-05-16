package model;
public class Brinquedo {
    public Brinquedo() {
    }
    private int codigoBrinquedo;
    private String nomeBrinquedo;
    private Marca marca;

    public Brinquedo(int codigoBrinquedo, String nomeBrinquedo, Marca marca) {
        this.codigoBrinquedo = codigoBrinquedo;
        this.nomeBrinquedo = nomeBrinquedo;
        this.marca = marca;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
