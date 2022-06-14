package appFastLunch.model;

public class ProdutoLanche extends Produto{

    //----ATRIBUTOS-----
    private String tamanho;
    private int qtdPacote;

    //------CONSTRUTOR------
    //Para o cardápio:
    public ProdutoLanche( String nome, String tamanho, int qtdPacote, double precoProduto) {
        super.nome = nome;
        this.tamanho = tamanho;
        this.qtdPacote = qtdPacote;
        super.precoProduto = precoProduto;
    }

    //---------Getters e setters-----------
    public String getTamanho() {
        return tamanho;
    }

    public int getQtdPacote() {
        return qtdPacote;
    }




}
