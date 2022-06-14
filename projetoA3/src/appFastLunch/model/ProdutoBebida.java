package appFastLunch.model;

public class ProdutoBebida extends Produto {

    //----------ATRIBUTOS------
    private double litroGarrafa;

    //-------CONSTRUTOR---------
      //Para o cardápio:
    public ProdutoBebida( String nome, double litroGarrafa, double precoProduto) {
        super.nome = nome;
        this.litroGarrafa = litroGarrafa;
        super.precoProduto = precoProduto;
    }

    //----Getters e setters-------
    public double getLitroGarrafa() {
        return litroGarrafa;
    }

}
