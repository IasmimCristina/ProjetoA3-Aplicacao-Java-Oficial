package appFastLunch.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Pedido {

    //---------------ATRIBUTOS--------------
    //Um pedido precisa de um cliente:
    Cliente cliente;
    //-----------
    private  String dataPedido;
    private Random idGerador = new Random();
    private String idPedido;//Identificador específico de cada pedido feito na aplicação.
    private String estado;

    //Um pedido pode possuir diferentes tipos de lista de produtos:
    ArrayList<ProdutoComida> comidaEscolhidas = new ArrayList<>(); //Comida---
    ArrayList<ProdutoBebida> bebidasEscolhidas = new ArrayList<>(); //Bebida---
    ArrayList<ProdutoLanche> lanchesEscolhidos = new ArrayList<>(); //Lanches---
    //--------------------------------------------------------------------------
    private double precoTotalPedido;
    private String tipoPagamento; //Pode ser: Pix, cartão de crédito, de débito e na entrega.
    private String restauranteEscolhido;
    private int numProdutos; //Número de produtos.

    //---------Construtor---------------
    public Pedido(Cliente cliente, String restauranteEscolhido) { //Valores iniciais, irão mudar conforme o pedido se desenvolve.
        this.cliente = cliente;
        LocalDate geradorData = LocalDate.now(); //Pega a data atual.
        this.dataPedido = geradorData.getDayOfMonth() + "/" + geradorData.getMonthValue() + "/" + geradorData.getYear(); //Pega a data em dia/mês/ano.
        this.idPedido = String.valueOf(idGerador.nextInt(10000)); //Poderá se repetir! Ou seja, não é único para cada pedido, é somente um identificador para a melhor visualização de um pedido pelo cliente.
        this.estado = ("Em configuração..."); //Pode mudar. Sendo preparado, entregue, a caminho,  cancelado.
        this.precoTotalPedido = 0d;// Começa com 0.0
        this.tipoPagamento = ("Ainda não definido.");
        this.restauranteEscolhido = restauranteEscolhido;
        this.numProdutos = 0;
    }
    //------------------Getters e setters-----------------------
    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<ProdutoComida> getComidaEscolhidas() {
        return comidaEscolhidas;
    }

    public ArrayList<ProdutoBebida> getBebidasEscolhidas() {
        return bebidasEscolhidas;
    }

    public ArrayList<ProdutoLanche> getLanchesEscolhidos() {
        return lanchesEscolhidos;
    }

    public double getPrecoTotalPedido() {
        return precoTotalPedido;
    }

    public void setPrecoTotalPedido(double precoTotalPedido) {
        this.precoTotalPedido = precoTotalPedido;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getRestauranteEscolhido() {
        return restauranteEscolhido;
    }

    public int getNumProdutos() {
        return numProdutos;
    }

    public void setNumProdutos(int numProdutos) {
        this.numProdutos = numProdutos;
    }
}
