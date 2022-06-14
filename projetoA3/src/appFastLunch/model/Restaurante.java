package appFastLunch.model;


public abstract class Restaurante { //Dois restaurantes cadastrados, com cardápios  de diferentes tipos.

    //---ATRIBUTOS----
    protected String nome;
    protected String descricaoRestaurante;

    //----Getters e setters-------
    public String getNome() {
        return nome;
    }
    public String getDescricaoRestaurante() {
        return descricaoRestaurante;
    }
}
