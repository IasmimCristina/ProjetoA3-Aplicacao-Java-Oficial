package appFastLunch.model;

public abstract class  Produto {
    //Um restaurante pode possuir cardápios com: comida, bebidas e lanches.
    //Produto é uma classe abstrata.

    //---------------ATRIBUTOS---------------
    protected String nome;
    protected double precoProduto;

    // Getters e setters:

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }
}
