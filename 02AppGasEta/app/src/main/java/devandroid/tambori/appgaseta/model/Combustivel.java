package devandroid.tambori.appgaseta.model;

public class Combustivel {

    private int id;
    private String nomeDoCombustivel;
    private String recomendacao;
    private double precoDoCombustivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoCombustivel() {
        return nomeDoCombustivel;
    }

    public void setNomeDoCombustivel(String nomeDoCombustivel) {
        this.nomeDoCombustivel = nomeDoCombustivel;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public double getPrecoDoCombustivel() {
        return precoDoCombustivel;
    }

    public void setPrecoDoCombustivel(double precoDoCombustivel) {
        this.precoDoCombustivel = precoDoCombustivel;
    }
}
