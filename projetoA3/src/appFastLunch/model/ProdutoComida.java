package appFastLunch.model;

public class ProdutoComida extends Produto {
    //----------ATRIBUTOS--------
    private String tamanho;

    //-------CONSTRUTOR-------
    //Para o cardápio:
    public ProdutoComida(String nome, String tamanho, double precoProduto) {
        super.nome = nome;
        this.tamanho = tamanho;
        super.precoProduto = precoProduto;
    }

    //------Getters e setters-------

    public String getTamanho() {
        return tamanho;
    }




}
