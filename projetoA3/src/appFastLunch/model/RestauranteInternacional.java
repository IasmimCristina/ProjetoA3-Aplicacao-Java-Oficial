package appFastLunch.model;

import java.util.ArrayList;

public class RestauranteInternacional extends Restaurante {
    //----------SABOR ESTRANGEIRO------------
    //---------------------------
    //Cardápios:
    private  ArrayList<ProdutoComida> cardapioAlmocoJantar; //Os cardápios não são finais, pois podem mudar.
    private  ArrayList<ProdutoComida> cardapioPizzas;
    private  ArrayList<ProdutoBebida> cardapioBebidas;
    //-------CONSTRUTOR--------------
    public RestauranteInternacional() {
        //Informações - Restaurante
        super.nome = "Sabor Estrangeiro";
        super.descricaoRestaurante = "Pizzas e pratos internacionais.";
        //---------------------------
        //------- Cardápios -------
        //Inicialização:
        cardapioPizzas = new ArrayList<>();
        cardapioAlmocoJantar = new ArrayList<>();
        cardapioBebidas = new ArrayList<>();
        //--------------------------------
        //------------------Cardápio - Pizzas-------------------------------
        ProdutoComida comida = new ProdutoComida( "Pizza de 4 queijos com pepperoni", "Grande", 45d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida( "Pizza de salame picante", "Pequeno", 14.5d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida("Pizza de salame picante", "Grande", 40d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida( "Pizza de calabresa com cebola", "Médio", 45d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida("Pizza Marguerita", "Médio", 25d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida( "Pizza Marguerita", "Grande", 45d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida( "Pizza de churrasco", "Grande", 45d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida( "Pizza de churrasco", "Médio", 30d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida( "Pizza de frango com catupiry", "Médio", 25d);
        cardapioPizzas.add(comida);
        comida = new ProdutoComida( "Pizza de frango com catupiry", "Grande", 40d);
        cardapioPizzas.add(comida);
        //---------------------------------------------------------------------
        //----------------------Cardápio - Bebidas---------------------------------
        ProdutoBebida bebida = new ProdutoBebida( "Garrafa de suco de uva", 2.5d, 4.5d);
        cardapioBebidas.add(bebida);
        bebida = new ProdutoBebida( "Garrafa de suco de morango", 2.5d, 4.5d);
        cardapioBebidas.add(bebida);
        bebida = new ProdutoBebida( "Garrafa de suco de laranja", 2.5d, 4.5d);
        cardapioBebidas.add(bebida);
        bebida = new ProdutoBebida("Garrafa de suco de limão", 1.5d, 4d);
        cardapioBebidas.add(bebida);
        bebida = new ProdutoBebida( "Garrafa de suco de manga", 1.5d, 4d);
        cardapioBebidas.add(bebida);
        bebida = new ProdutoBebida( "Garrafa de refrigerante de uva", 2.5d, 4.5d);
        cardapioBebidas.add(bebida);
        bebida = new ProdutoBebida( "Garrafa de refrigerante de limão", 2.5d, 4.5d);
        cardapioBebidas.add(bebida);
        bebida = new ProdutoBebida( "Garrafa Coca-Cola", 2.5, 5d);
        cardapioBebidas.add(bebida);
        bebida = new ProdutoBebida( "Garrafa Pepsi", 2.5d, 4.5d);
        cardapioBebidas.add(bebida);
        //-------------------------------------------------------------------------
        //--------------------------------Cardápio - Almoço e jantar--------------------------------------
        comida = new ProdutoComida( "Porção de yakisoba de frango", "Grande", 35d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida( "Porção de yakisoba de vegetais", "Médio", 25d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida( "Porção mista de churrasco", "Grande", 45d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida( "Tigela de lámen", "Grande", 35d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida( "Porção de espaghetti alla carbonara", "Grande", 30d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida( "Porção de ratatouille", "Grande", 15d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida( "Porção de sashimi e tempurá", "Médio", 30d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida( "Porção de sushi com hot roll", "Grande", 55d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida( "Porção de sushi com hot roll", "Médio", 30d);
        cardapioAlmocoJantar.add(comida);
        comida = new ProdutoComida("Porção de sushi com hot roll", "Pequeno", 15d);
        cardapioAlmocoJantar.add(comida);
        //----------------------------------------------------------------------------------------------
    }

    //----------------Getters e setters--------------
    public ArrayList<ProdutoComida> getCardapioAlmocoJantar() {
        return cardapioAlmocoJantar;
    }
    public ArrayList<ProdutoComida> getCardapioPizzas() {
        return cardapioPizzas;
    }
    public ArrayList<ProdutoBebida> getCardapioBebidas() {
        return cardapioBebidas;
    }

}
