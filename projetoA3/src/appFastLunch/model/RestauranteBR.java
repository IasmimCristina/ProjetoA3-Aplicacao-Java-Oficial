package appFastLunch.model;

import java.util.ArrayList;

public class RestauranteBR extends Restaurante {
    // -----TEMPERO BAIANO------
    //---------------------------
    //Cardápios:
    private ArrayList<ProdutoComida> cardapioCafeDaManha; //Os cardápios não são finais, pois podem mudar.
    private ArrayList<ProdutoBebida> cardapioBebidasBR;
    private ArrayList<ProdutoLanche> cardapioDoces;
    private ArrayList<ProdutoLanche> cardapioSalgados;
    //-----------------------------

    //---CONSTRUTOR---------
    public RestauranteBR() {
        //Informações - Restaurante
        super.nome = "Tempero Baiano";
        super.descricaoRestaurante = "Café da manhã brasileiro além de salgados e doces.";
        //------------------------
        //------- Cardápios -------
        //Inicialização:
        cardapioCafeDaManha = new ArrayList<>();
        cardapioBebidasBR = new ArrayList<>();
        cardapioSalgados = new ArrayList<>();
        cardapioDoces = new ArrayList<>();
        //----------------------------------
        //---------------Cardápio - Café da manha - Comida--------------------------
        ProdutoComida comida = new ProdutoComida("Porção de pastéis de forno de carne", "Pequeno", 8d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Mingau de aveia com morango e maças", "Pequeno", 3.5d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Mingau de aveia com bananas e maçãs", "Pequeno", 3.5d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Mingau de aveia com morango e maças", "Pequeno", 3.5d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Tapioca de carne e frango", "Grande", 10d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Esfirra de presunto", "Pequeno", 4.5d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Esfirra de peixe", "Médio", 4.5d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Esfirra de salame", "Grande", 6.5d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Esfirra de carne", "Grande", 6.5d);
        cardapioCafeDaManha.add(comida);
        comida = new ProdutoComida("Tigela de salada de frutas vermelhas", "Grande", 12.5d);
        cardapioCafeDaManha.add(comida);
        //-------------------------------------------------------------------------------
        //-------Cárdapio - Café da manhã - Bebidas-------------
        ProdutoBebida bebida = new ProdutoBebida("Café com leite", 0.190d, 2d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Café com canela", 0.190d, 2d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Café com chocolate e canela", 0.190d, 3.5d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Café preto", 0.190d, 2d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Capuccino", 0.300d, 5d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Suco da açerola", 2.5d, 4.5d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Suco de laranja", 2.5d, 4.5d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Suco de cajá", 1.5d, 3.5d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Chá Matte", 0.100d, 3.5d);
        cardapioBebidasBR.add(bebida);
        bebida = new ProdutoBebida("Chá de limão e hortelã", 0.100d, 3.5d);
        cardapioBebidasBR.add(bebida);
        //-----------------------------------------------------------
        //---------------------Cárdapio - Lanches - Salgados *A quantidade limite reflete a quantidade por pacote.---------
        ProdutoLanche lanche = new ProdutoLanche("Pastel de carne seca", "Médio", 5, 15.5d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Pastél de queijo", "Médio", 5, 10.5d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Pastél de carne", "Grande", 5, 15.5d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Bolinho de queijo", "Pqueno", 10, 10.5d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Bolinho de camarão", "Pqueno", 10, 10d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Enroladinho de salsicha e queijo", "Médio", 5, 15.5d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Croquete", "Pequeno", 10, 10.5d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Nugget de frango", "Médio", 10, 20.5d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Quibe", "Pequeno", 10, 10.5d);
        cardapioSalgados.add(lanche);
        lanche = new ProdutoLanche("Empanada de carne", "Pequeno", 10, 10.5d);
        cardapioSalgados.add(lanche);
        //-----------------------------------------------------------------------------------------------
        //-------------------Cárdapio - Lanches - Doces-------------------
        lanche = new ProdutoLanche("Bala de coco caramelizada", "Grande", 5, 15d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Alfajor de doce de leite", "Pequeno", 5, 6.5d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Cocada de colher", "Pequeno", 5, 8.5d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Trufa de maracujá", "Pequeno", 5, 10.5d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Espeto de brigadeiro", "Pequeno", 10, 12d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Bolo de chocolate no copo", "Pequeno", 5, 10.5d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Brigadeiro de Nutella", "Pequeno", 10, 7.5d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Pudim no copo", "Pequeno", 5, 10d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Cupcake de chocolate e baunilha", "Médio", 5, 15.5d);
        cardapioDoces.add(lanche);
        lanche = new ProdutoLanche("Cupcake de coco", "Médio", 5, 15.5d);
        cardapioDoces.add(lanche);
        //----------------------------------------------------------------
    }

    //------------------------Getters e setters-----------------------
    public ArrayList<ProdutoComida> getCardapioCafeDaManha() {
        return cardapioCafeDaManha;
    }
    public ArrayList<ProdutoBebida> getCardapioBebidasBR() {
        return cardapioBebidasBR;
    }
    public ArrayList<ProdutoLanche> getCardapioDoces() {
        return cardapioDoces;
    }
    public ArrayList<ProdutoLanche> getCardapioSalgados() {
        return cardapioSalgados;
    }
}





