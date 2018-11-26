package model;

public class Digitos {

    private int id;
    private String qntDeDigitos;

    public Digitos(int id, String qntDeDigitos) {
        this.id = id;
        this.qntDeDigitos = qntDeDigitos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQntDeDigitos() {
        return qntDeDigitos;
    }

    public void setQntDeDigitos(String qntDeDigitos) {
        this.qntDeDigitos = qntDeDigitos;
    }

    @Override
    public String toString() {
        return getQntDeDigitos();
    }
}
