package appFastLunch.controllers;

import appFastLunch.model.*;
import appFastLunch.views.TelasIniciais;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TelasIniciaisController {
    //-------------------------------------------Classe que possui a lógica por trás das telas da aplicação-------------------------------------
    //Não possuirá métodos estáticos! Ela contém uma intância das telas da aplicação para poder controlá-las, não necessitando ter métodos estáticos.
    //------------------------------------------------------------------------------------------------------------------------------------------

    //Telas - Atributo
    private final TelasIniciais telas;//Um controller precisa controlar uma tela. Ela não poderá ser modificada depois, por isso é uma variável final.
    //----------------

    //Clientes - Atributo
    private Cliente usuario;
    ArrayList<Cliente> clientesCadastrados;
    //---------------------------

    //Restaurantes - Atributos - Não mudam.
    private final RestauranteBR temperoBaiano;
    private final RestauranteInternacional saborEstrangeiro;
    //----------------------------

    //Pedido - Cliente - Atributos
    private Pedido pedidoModelo;
    private ProdutoComida comida;
    private ProdutoBebida bebida;
    private ProdutoLanche lanche;
    //----------------------------

    //Leitura - Scanner - Atributo - Ela não muda.
    private final Scanner leitura = new Scanner(System.in); //Será usado várias vezes em muitas funções, por isso não é apenas uma variável local em cada função.
    //----------------------------------------

    //-------------------------CONSTRUTOR--------------------------
    public TelasIniciaisController(TelasIniciais telas) {
        this.telas = telas;
        //Inicialização - Restaurantes
        this.temperoBaiano = new RestauranteBR();
        this.saborEstrangeiro = new RestauranteInternacional();
        //-----------------------------


        //-----------------Clientes já cadastrados-----------------
        //Variáveis locais usadas:
        double precoTotal = 0d;
        double preco;
        //------------------------

        //--------------------------------------------------
        //----------------USUÁRIOS CADASTRADOS--------------
        clientesCadastrados = new ArrayList<>();
        //Criação de um usuário novo:
        usuario = new Cliente("Johnny", "john@gmail.com", "123", "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioPizzas().get(2);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioPizzas().get(2);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioPizzas().get(2);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por cartão de crédito."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("10/02/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //--------------------
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioSalgados().get(2);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioSalgados().get(5);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioSalgados().get(5);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("10/02/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //--------------------
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(4);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(4);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(4);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(2);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(1);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por cartão de débito."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getBebidasEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("12/02/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //--------------------------------------------------------------------------------------------------------------
        //Criação de um usuário novo:
        usuario = new Cliente("Pamela", "ppp@gmail.com", "456",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(4);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(4);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(2);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("10/04/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //--------------------
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(4);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Durante a entrega."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("11/04/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //--------------------
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(1);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(1);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(1);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        bebida = temperoBaiano.getCardapioBebidasBR().get(1);
        pedidoModelo.getBebidasEscolhidas().add(bebida);
        preco = bebida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por cartão de débito."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getBebidasEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("12/04/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //--------------------------------------------------------------------------------------------------------------
        //Criação de um usuário novo:
        usuario = new Cliente("Samanta", "sam@gmail.com", "123",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(3);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(6);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(3);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Durante a entrega."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("1/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("7/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //--------------------
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(4);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(7);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(7);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Durante a entrega."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("7/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //--------------------------------------------------------------------------------------------------------------
        usuario = new Cliente("Tom", "tom@gmail.com", "123",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(4);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(4);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(6);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Durante a entrega."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("8/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("10/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //-----------------------------
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Durante a entrega."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("10/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("10/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //-----------------------------
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(5);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(5);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("11/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("11/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //--------------------------------------------------------------------------------------------------------------
        usuario = new Cliente("Peter", "peter@gmail.com", "123",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(5);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(5);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Durante a entrega."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        pedidoModelo.setDataPedido("11/06/2022"); //Data fictícia do pedido atual.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("11/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //-------------------------------------------------------------------------------------------------------------
        usuario = new Cliente("Silvio", "silvio@gmail.com", "123",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(1);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(0);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Durante a entrega."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("11/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("11/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //-------------------------------------------------------------------------------------------------------------
        usuario = new Cliente("Iann", "iann@gmail.com", "123",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(2);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(2);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("14/03/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //-------------------------------------------------------------------------------------------------------------
        usuario = new Cliente("Alana", "alana@gmail.com", "123",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(2);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("20/04/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //-------------------------------------------------------------------------------------------------------------
        usuario = new Cliente("Andy", "andy@gmail.com", "123",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(0);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioAlmocoJantar().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por Pix."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("19/05/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

        //-------------------------------------------------------------------------------------------------------------
        usuario = new Cliente("Fabiana", "fabiana@gmail.com", "123",  "111.111.111-11", "(11)11111-1111");
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        //--
        lanche = temperoBaiano.getCardapioDoces().get(5);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(5);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(4);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(0);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        lanche = temperoBaiano.getCardapioDoces().get(0);
        pedidoModelo.getLanchesEscolhidos().add(lanche);
        preco = lanche.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Durante a entrega."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("09/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        precoTotal = 0d; //Esvaziando a variável local do preço.
        //Novo pedido desse cliente--------------
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        //--
        comida = saborEstrangeiro.getCardapioPizzas().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioPizzas().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioPizzas().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        comida = saborEstrangeiro.getCardapioPizzas().get(9);
        pedidoModelo.getComidaEscolhidas().add(comida);
        preco = comida.getPrecoProduto();
        precoTotal += preco;
        //--
        //Adição do pedido à lista de pedidos do cliente--------
        pedidoModelo.setPrecoTotalPedido(precoTotal);
        pedidoModelo.setEstado("Entregue.");
        pedidoModelo.setTipoPagamento("Por cartão de débito."); //Configuração do pagamento.
        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size()); //Adição do número de produtos.
        pedidoModelo.setDataPedido("11/06/2022"); //Data fictícia do pedido atual.
        usuario.getPedidosCliente().add(pedidoModelo);
        usuario.setNumPedidos(usuario.getPedidosCliente().size()); //Atualização do número de pedidos.
        //----------------------------------------------------------
        //Adição do cliente à lista daqueles que foram cadastrados:
        clientesCadastrados.add(usuario);

    }

    //-----------------------------------------------------MÉTODOS----------------------------------------

    //-----------Validação — Métodos-------------
    //Elas retornam se o valor digitado pelo usuário é válido ou não à tela.
    public boolean validacaoNomeUsuario(String nomeUsuario) {
        if (nomeUsuario.matches("[0-9]*")) {//O nome de usuário não pode ser composto somente de números. Se for, será mostrada uma mensagem de erro.
            System.out.println("-----------------------------------------");
            System.out.println("                   Erro!");
            System.out.println("O nome de usuário inserido é inválido! Digite novamente.");
            System.out.println("-----------------------------------------");
            return false;
        }
        for (Cliente clienteCadastrado : clientesCadastrados) {//O nome de usuário não pode ser igual a outro já cadastrado.
            if (nomeUsuario.equals(clienteCadastrado.getNomeUsuario())) {
                System.out.println("-----------------------------------------");
                System.out.println("                   Erro!");
                System.out.println("O nome de usuário inserido já está cadastrado! Digite novamente.");
                System.out.println("-----------------------------------------");
                return false;
            }
        }
        return true;
    }

    public boolean validacaoEmail(String email) { //Também irá comparar com os usuários cadastrados.
        if (email.contains("@") && email.contains(".com")) { //O email não se repete em usuários cadastrados..
            for (Cliente clienteCadastrado : clientesCadastrados) {
                if (email.equals(clienteCadastrado.getEmail())) {
                    System.out.println("-----------------------------------------");
                    System.out.println("                   Erro!");
                    System.out.println("O endereço de e-mail inserido já está cadastrado! Digite novamente.");
                    System.out.println("-----------------------------------------");
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("                   Erro!");
            System.out.println("O email inserido é inválido! Digite novamente.");
            System.out.println("-----------------------------------------");
            return false;
        }
    }

    public boolean validacaoSenha(String senha, String senhaConfirmacao) { //A senha pode ser composta de qualquer caractere.
        if (senha.equals(senhaConfirmacao)) {//A tela pede a senha duas vezes e esta função compara as duas. Se forem idênticas, a senha é válida.
            return true;
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("                     Erro!");
            System.out.println("As senhas inseridas não são idênticas. Digite novamente.");
            System.out.println("-----------------------------------------");
            return false;

        }
    }

    public boolean validacaoCPF(String cpf) { //Também irá ser compararado com os usuários cadastrados.
        if (cpf.length() == 11 && cpf.matches("[0-9]*")) { //Validação contra letras! - O cpf não pode ser composto de letras. - Deve apenas ter 11 dígitos.
            for (Cliente clienteCadastrado : clientesCadastrados) {
                if (cpf.equals(clienteCadastrado.getCpf())) {
                    System.out.println("-----------------------------------------");
                    System.out.println("                   Erro!");
                    System.out.println("O CPF inserido já está cadastrado! Digite novamente.");
                    System.out.println("-----------------------------------------");
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("                   Erro!");
            System.out.println("O número de CPF inserido é inválido! Digite novamente.");
            System.out.println("-----------------------------------------");
            return false;
        }
    }

    public boolean validacaoNumTel(String numTel) { //Também irá comparar com os usuários cadastrados.
        if (numTel.length() == 11 && numTel.matches("[0-9]*")) { //Validação contra letras! - O número de telefone não pode ser composto de letras. - Deve apenas ter 11 dígitos.
            for (Cliente clienteCadastrado : clientesCadastrados) {
                if (numTel.equals(clienteCadastrado.getNumTelefone())) {
                    System.out.println("-----------------------------------------");
                    System.out.println("                   Erro!");
                    System.out.println("O número de telefone inserido já está cadastrado! Digite novamente.");
                    System.out.println("-----------------------------------------");
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("                   Erro!");
            System.out.println("O número de telefone inserido é inválido! Digite novamente.");
            System.out.println("-----------------------------------------");
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------


    //------------------Cadastrar um novo usuario - Métodos------------------------------------------------

    public Cliente cadastrarNovoUsuario(String nomeUsuario, String email, String senha, String cpf, String numTelefone) {//Ela retorna um cliente para ser usado pela tela de usuário.
        this.usuario = new Cliente(nomeUsuario, email, senha, cpf, numTelefone);
        clientesCadastrados.add(usuario); //O usuário criado é adicionado à lista.
        return this.usuario;
    }

    //---------------------------------------------------
    //-------------------Máscaras - Métodos-----------
    public String formatarMascaraCPF(String cpfSemFormatacao) throws ParseException {//Há uma exceção criada para que funcione.
        MaskFormatter mascara = new MaskFormatter("###.###.###-##"); //CPF - Configuração da exibição.
        mascara.setValueContainsLiteralCharacters(false);
        return mascara.valueToString(cpfSemFormatacao);//Adiciona a formatação ao dado recebido
    }

    public String formatarMascaraTel(String telSemFormatacao) throws ParseException {//Há uma exceção criada para que funcione.
        MaskFormatter mascara = new MaskFormatter("(##)#####-####"); // Número de telefone -Configuração da exibição.
        mascara.setValueContainsLiteralCharacters(false);
        return mascara.valueToString(telSemFormatacao);//Adiciona a formatação ao dado recebido
    }

    //-----------------------------------------------------
    //----------------Métodos de controle---------------
    // Métodos que pegam as escolhas ou dados das telas e abrem outras telas.
    public void pegaEscolhaCardapioSEstrangeiro() {
        int escolha;
        try {
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1 -> mostrarTelaCardapioPizzas();
                case 2 -> mostrarTelaCardapioAlmocoJantar();
                case 3 -> mostrarTelaCardapioBebidasSEstrangeiro();
                default -> {
                    System.out.println("-----------------------------------------");
                    System.out.println("----                Erro!            ----");
                    System.out.println("----    O dado inserido é inválido.  ----");
                    System.out.println("-----------------------------------------");
                    telas.abrirTelaModificarConta();
                }
            }
        } catch (InputMismatchException e) { //Cuida de uma exceção caso o usuário digite um valor inválido como letras.
            System.out.println("|-----------------------------------------|");
            System.out.println("|----                Erro!            ----|");
            System.out.println("|----    O dado inserido é inválido.  ----|");
            System.out.println("|-----------------------------------------|");
            telas.abrirTelaRestauranteInternacional();
        }
    }

    public void pegaEscolhaCardapioTBaiano() {
        int escolha;
        try {
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1 -> mostrarTelaCardapioCafeManha();
                case 2 -> mostrarTelaCardapioSalgados();
                case 3 -> mostrarTelaCardapioDoces();
                case 4 -> mostrarTelaCardapioBebidasBR();
                default -> {
                    System.out.println("-----------------------------------------");
                    System.out.println("----                Erro!            ----");
                    System.out.println("----    O dado inserido é inválido.  ----");
                    System.out.println("-----------------------------------------");
                    telas.abrirTelaModificarConta();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("|-----------------------------------------|");
            System.out.println("|----                Erro!            ----|");
            System.out.println("|----    O dado inserido é inválido.  ----|");
            System.out.println("|-----------------------------------------|");
            telas.abrirTelaRestauranteBR();
        }
    }

    public void pegaEscolhaModificarConta() {
        int escolha;
        try {
            escolha = leitura.nextInt();
            String dadoNovo;//A nova informação que ocupará o lugar da antiga.
            boolean validacao; //Validador local que receberá o valor true se tudo for válido.
            switch (escolha) {
                case 1 -> {
                    do {
                        System.out.println("_______________________________________");
                        System.out.print("||--Digite o novo nome de usuário:");
                        dadoNovo = leitura.next();
                        validacao = validacaoNomeUsuario(dadoNovo);
                        if (dadoNovo.equals(usuario.getNomeUsuario())) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("-------------------------Erro!--------------------------------");
                            System.out.println("O nome  de usuário digitado é igual ao que já está cadastrado.");
                            System.out.println("--------------------------------------------------------------");
                            validacao = false;
                        }
                        if (validacao) {
                            usuario.setNomeUsuario(dadoNovo);
                            System.out.println("||--     Alteração efetuada com sucesso!     --||");
                        }
                    } while (!validacao);
                    telas.abrirVisualizarConta();
                }
                case 2 -> {
                    do {
                        System.out.println("_______________________________________");
                        System.out.print("||--Digite o novo endereço de e-mail:");
                        dadoNovo = leitura.next();
                        validacao = validacaoEmail(dadoNovo);
                        if (dadoNovo.equals(usuario.getEmail())) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("-------------------------Erro!--------------------------------");
                            System.out.println("O endereço de e-mail digitado é igual ao que já está cadastrado.");
                            System.out.println("--------------------------------------------------------------");
                            validacao = false;
                        }
                        if (validacao) {
                            usuario.setEmail(dadoNovo);
                            System.out.println("||--     Alteração efetuada com sucesso!     --||");
                        }
                    } while (!validacao);
                    telas.abrirVisualizarConta();
                }
                case 3 -> {
                    do {
                        System.out.println("_______________________________________");
                        System.out.print("||--Digite a nova senha:");
                        dadoNovo = leitura.next();
                        System.out.print("||--Digite a nova senha novamente:");
                        String senhaConfirmacao = leitura.next();
                        validacao = validacaoSenha(dadoNovo, senhaConfirmacao);
                        if (dadoNovo.equals(usuario.getSenha()) && validacao) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("-------------------------Erro!--------------------------------");
                            System.out.println("       A senha digitada é igual à que já está cadastrada.    ");
                            System.out.println("--------------------------------------------------------------");
                            validacao = false;
                        }
                        if (validacao) {
                            usuario.setSenha(dadoNovo);
                            System.out.println("||--     Alteração efetuada com sucesso!     --||");
                        }
                    } while (!validacao);
                    telas.abrirVisualizarConta();
                }
                case 4 -> {
                    do {
                        System.out.println("_______________________________________");
                        System.out.print("||--Digite o novo número de CPF:");
                        dadoNovo = leitura.next();
                        validacao = validacaoCPF(dadoNovo);
                        try {
                            dadoNovo = formatarMascaraCPF(dadoNovo);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (dadoNovo.equals(usuario.getCpf())) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("-------------------------Erro!--------------------------------");
                            System.out.println("        O CPF digitado é igual ao que já está cadastrado.     ");
                            System.out.println("--------------------------------------------------------------");
                            validacao = false;
                        }
                        if (validacao) {
                            usuario.setCpf(dadoNovo);
                            System.out.println("||--     Alteração efetuada com sucesso!     --||");
                        }
                    } while (!validacao);
                    telas.abrirVisualizarConta();
                }
                case 5 -> {
                    do {
                        System.out.println("_______________________________________");
                        System.out.print("||--Digite o novo número de telefone:");
                        dadoNovo = leitura.next();
                        validacao = validacaoNumTel(dadoNovo);
                        try {
                            dadoNovo = formatarMascaraTel(dadoNovo);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (dadoNovo.equals(usuario.getNumTelefone())) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("-------------------------Erro!--------------------------------");
                            System.out.println("O número de telefone digitado é igual ao que já está cadastrado.");
                            System.out.println("--------------------------------------------------------------");
                            validacao = false;
                        }
                        if (validacao) {
                            usuario.setNumTelefone(dadoNovo);
                            System.out.println("||--     Alteração efetuada com sucesso!     --||");
                        }
                    } while (!validacao);
                    telas.abrirVisualizarConta();
                }
                case 6 -> telas.mostrarTelaUsuario(usuario);
                default -> {
                    System.out.println("-----------------------------------------");
                    System.out.println("----                Erro!            ----");
                    System.out.println("----    O dado inserido é inválido.  ----");
                    System.out.println("-----------------------------------------");
                    telas.abrirTelaModificarConta();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("-----------------------------------------");
            System.out.println("----                Erro!            ----");
            System.out.println("----    O dado inserido é inválido.  ----");
            System.out.println("-----------------------------------------");
            telas.abrirTelaModificarConta();
        }
    }

    public void pegaEscolhaVisualizarConta() {
        try {
            int escolha = leitura.nextInt();
            if (escolha == 1) {
                telas.mostrarTelaUsuario(usuario);

            } else if (escolha == 2) {
                telas.abrirTelaModificarConta();

            } else {
                System.out.println("___________Erro!___________");
                System.out.println("O valor digitado é inválido.");
                System.out.println("___________________________");
                telas.abrirVisualizarConta();

            }

        } catch (InputMismatchException e) {
            System.out.println("___________Erro!___________");
            System.out.println("O valor digitado é inválido.");
            System.out.println("___________________________");
            telas.abrirVisualizarConta();
        }
    }

    public boolean pegaEscolhaTelaInicial() {
        try {
            int escolha = leitura.nextInt();
            switch (escolha) {
                case 1 -> {
                    telas.mostrarTelaCadastrarConfirmacao();
                    return false;
                }
                case 2 -> {
                    telas.mostrarTelaEntrarConfirmacao();
                    return false;
                }
                case 3 -> {
                    fecharFastLunch(1);//Tela anterior 1 se refere a tela inicial.
                    return false;
                }
                default -> {
                    System.out.println("O que foi digitado é inválido, tente novamente.");
                    return true;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("O que foi digitado é inválido, tente novamente.");
            leitura.nextLine();
            return true;
        }
    }

    public void pegaEscolhaRestaurante() {
        try {
            int escolha = leitura.nextInt();
            if (escolha == 1) {
                telas.abrirTelaRestauranteInternacional();//Método que abre as opções dos cárdapios do restaurante 1. - Sabor Etrangeiro

            } else if (escolha == 2) {
                telas.abrirTelaRestauranteBR();//Método que abre as opções dos cárdapios do restaurante 2. - Tempero Baiano
            } else {
                System.out.println("___________Erro!___________");
                System.out.println("O valor digitado é inválido.");
                System.out.println("___________________________");
                telas.abrirTelaPedidoRestaurante();
            }
        } catch (InputMismatchException e) {
            System.out.println("___________Erro!___________");
            System.out.println("O valor digitado é inválido.");
            System.out.println("___________________________");
            leitura.nextLine();
            telas.abrirTelaPedidoRestaurante();
        }
    }

    public void pegaEscolhaTelaUsuario() {
        try {
            int escolha = leitura.nextInt();
            //A tela anterior 2 se refere à tela de usuário.
            switch (escolha) {
                case 1 -> telas.abrirTelaPedidoRestaurante();
                case 2 -> telas.abrirVisualizarConta();
                case 3 -> telas.abrirTelaModificarConta();
                case 4 -> desconectarConta();
                case 5 -> excluirConta();
                case 6 -> fecharFastLunch(2); //Como essa função dá a opção de voltar, a tela anterior deve ser informada para que a correta apareça.
                default -> {
                    System.out.println("___________Erro!___________");
                    System.out.println("O valor digitado é inválido.");
                    System.out.println("___________________________");
                    telas.mostrarTelaUsuario(usuario);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("___________Erro!___________");
            System.out.println("O valor digitado é inválido.");
            System.out.println("___________________________");
            telas.mostrarTelaUsuario(usuario);
            leitura.nextLine();
        }
    }

    //-------------------------------------MÉTODOS TELA ENTRAR E ESQUECEU SENHA-----------------------------------------
    public void pegaEscolhaTelaEntrarConfirmacao() {
        try {
            int escolha = leitura.nextInt();
            switch (escolha) {
                case 1 -> telas.mostrarTelaEntrar();
                case 2 -> telas.mostrarTelaEsqueceuSenha();
                case 3 -> telas.mostrarTelaInicial();
                default -> {
                    System.out.println("O que foi digitado é inválido, tente novamente.");
                    telas.mostrarTelaEntrarConfirmacao();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("O que foi digitado é inválido, tente novamente.");
            leitura.nextLine();
            telas.mostrarTelaEntrarConfirmacao();
        }
    }

    public void pegaDadosEntrada(String nomeUsuario, String senha) { //Ligada à tela Entrar
        boolean dadosInvalidos = true;
        for (Cliente clienteCadastrado : clientesCadastrados) { //Validação com os clientes já cadastrados.
            if (senha.equals(clienteCadastrado.getSenha()) && nomeUsuario.equals(clienteCadastrado.getNomeUsuario())) {
                dadosInvalidos = false;
                usuario = clienteCadastrado;
                telas.mostrarTelaUsuario(usuario);
            } else {
                dadosInvalidos = true;
            }
        }
        if (dadosInvalidos) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Informações incorretas! Não há uma conta cadastrada com esses dados.");
            System.out.println("--------------------------------------------------------------------");
            telas.mostrarTelaEntrarConfirmacao();
        }
    }

    public void pegaEscolhaEsqueceuSenha() { //Ao digitar o código, o usuário pode mudar a senha.
        String resposta;
        resposta = leitura.next();
        for (Cliente clienteCadastrado : clientesCadastrados) {
            if (resposta.equals(clienteCadastrado.getEmail())) { //Validação do e-mail.
                System.out.println("------------------------------------------------------------------");
                System.out.print("Digite o código que foi enviado para o seu endereço de e-mail:");
                resposta = leitura.next();
                if (resposta.equals("ABCD123")) { //O código sempre é o mesmo.
                    usuario = clienteCadastrado;
                    modificarSenhaEsqueceuSenha(usuario); //Método que pega a senha nova e faz a modificação.
                    telas.mostrarTelaUsuario(usuario);
                } else {
                    System.out.println("----------------------------------");
                    System.out.println("Código incorreto! Tente novamente.");
                    System.out.println("----------------------------------");
                    telas.mostrarTelaEntrarConfirmacao();
                }
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("Endereço de e-mail incorreto! Tente novamente.");
                System.out.println("----------------------------------------------");
                telas.mostrarTelaEntrarConfirmacao();
            }
        }
    }

    public boolean pegaEscolhaCadastrarConfirmacao() {
        try {
            int escolha = leitura.nextInt();
            switch (escolha) {
                case 1 -> {
                    telas.mostrarTelaCadastrarInfo();
                    return false;
                }
                case 2 -> {
                    telas.mostrarTelaInicial();
                    return false;
                }
                default -> {
                    System.out.println("O que foi digitado é inválido, tente novamente.");
                    return true;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("O que foi digitado é inválido, tente novamente.");
            leitura.nextLine();
            return true;
        }
    }

    public boolean pegaEscolhaTelaCadastrar(String nomeUsuario, String email, String senha, String cpf, String
            numTel) {//Função que pode cadastrar um novo usuário.
        try {
            int resposta = leitura.nextInt();
            switch (resposta) {
                case 1 -> {
                    Cliente usuario = cadastrarNovoUsuario(nomeUsuario, email, senha, cpf, numTel);
                    telas.mostrarTelaUsuario(usuario);
                    return false;
                }
                case 2 -> {
                    System.out.println("||-- Os dados inseridos não serão salvos. --||");
                    telas.mostrarTelaInicial();
                    return false;
                }
                default -> {
                    System.out.println("O que foi digitado é inválido, tente novamente.");
                    return true;
                }
            }
        } catch (
                InputMismatchException e) {
            System.out.println("O que foi digitado é inválido, tente novamente.");
            leitura.nextLine();
            return true;
        }
    }
    //---------------------------------------
    //-----------------------------Exibição das telas - Métodos--------------------
    //Restaurantes: TEMPERO BAIANO // SABOR ESTRANGEIRO -

    //--------------SABOR ESTRANGEIRO - Exibição - Cardápios------------------
    public void mostrarTelaCardapioAlmocoJantar() {
        System.out.println("__________                           " + saborEstrangeiro.getNome() + "               _____________");
        boolean repetir; //Variável local que controla a repetição.
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        do {
            System.out.println("||___________________________Cardápio ALmoço/Jantar__________________________||");
            for (int i = 0; i < saborEstrangeiro.getCardapioAlmocoJantar().size(); i++) {
                comida = saborEstrangeiro.getCardapioAlmocoJantar().get(i);
                System.out.println((i + 1) + ".   --" + comida.getNome() + "--  --Tamanho: " + comida.getTamanho() + "--  --Preço: R$" + comida.getPrecoProduto() + "--");
            }
            System.out.println("-------------------------------------------------------------------------------");
            mostrarComidaSelecionada();
            System.out.println("      ||--Quantidade de produtos escolhida até agora: " + pedidoModelo.getNumProdutos() + "  ||");
            System.out.println("      ||--Peço total do pedido:  R$" + pedidoModelo.getPrecoTotalPedido() + "                  ||");
            pegaEscolhaProdutoEQtdAlmocoJantar();
            mostrarComidaSelecionada();
            remocaoComidaSelecionada();
            if (pedidoModelo.getComidaEscolhidas().size() == 0) {
                repetir = true;
            } else {
                System.out.println("--Deseja prosseguir com o pedido atual e configurar o pagamento ou continuar selecionando produtos?--");
                System.out.print("--->>>Digite 1 para ir para tela de pagamento e 2 para continuar selecionando itens: ");
                repetir = pegaEscolhaTelaCardapios();
            }

        } while (repetir);
    }

    public void mostrarTelaCardapioPizzas() {
        System.out.println("__________                       " + saborEstrangeiro.getNome() + "              _____________");
        boolean repetir;
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        do {
            System.out.println("||___________________________  Cardápio - Pizzas   __________________________||");
            for (int i = 0; i < saborEstrangeiro.getCardapioPizzas().size(); i++) {
                comida = saborEstrangeiro.getCardapioPizzas().get(i);
                System.out.println((i + 1) + ".   --" + comida.getNome() + "--  --Tamanho: " + comida.getTamanho() + "--  --Preço: R$" + comida.getPrecoProduto() + "--");
            }
            System.out.println("-------------------------------------------------------------------------------");
            mostrarComidaSelecionada();
            System.out.println("      ||--Quantidade de produtos escolhida até agora: " + pedidoModelo.getNumProdutos() + "  ||");
            System.out.println("      ||--Peço total do pedido:  R$" + pedidoModelo.getPrecoTotalPedido() + "                  ||");
            pegaEscolhaProdutoEQtdPizzas();
            mostrarComidaSelecionada();
            remocaoComidaSelecionada();
            if (pedidoModelo.getComidaEscolhidas().size() == 0) {
                repetir = true;
            } else {
                System.out.println("--Deseja prosseguir com o pedido atual e configurar o pagamento ou continuar selecionando produtos?--");
                System.out.print("--->>>Digite 1 para ir para tela de pagamento e 2 para continuar selecionando itens: ");
                repetir = pegaEscolhaTelaCardapios();
            }
        } while (repetir);
    }

    public void mostrarTelaCardapioBebidasSEstrangeiro() {
        System.out.println("__________                        " + saborEstrangeiro.getNome() + "              _____________");
        boolean repetir;
        pedidoModelo = new Pedido(usuario, "Sabor Estrangeiro");
        do {
            System.out.println("||___________________________  Cardápio - Bebidas   __________________________||");
            for (int i = 0; i < saborEstrangeiro.getCardapioBebidas().size(); i++) {
                bebida = saborEstrangeiro.getCardapioBebidas().get(i);
                System.out.println((i + 1) + ".   --" + bebida.getNome() + "--  --Litro/ml: " + bebida.getLitroGarrafa() + "--  --Preço: R$" + bebida.getPrecoProduto() + "--");
            }
            System.out.println("-------------------------------------------------------------------------------");
            mostrarBebidasSelecionadas();
            System.out.println("      ||--Quantidade de produtos escolhida até agora: " + pedidoModelo.getNumProdutos() + "  ||");
            System.out.println("      ||--Peço total do pedido:  R$" + pedidoModelo.getPrecoTotalPedido() + "                  ||");
            pegaEscolhaProdutoEQtdBebidas();
            mostrarBebidasSelecionadas();
            remocaoBebidas();
            if (pedidoModelo.getBebidasEscolhidas().size() == 0) {
                repetir = true;
            } else {
                System.out.println("--Deseja prosseguir com o pedido atual e configurar o pagamento ou continuar selecionando produtos?--");
                System.out.print("--->>>Digite 1 para ir para tela de pagamento e 2 para continuar selecionando itens: ");
                repetir = pegaEscolhaTelaCardapios();
            }
        } while (repetir);
    }

    //---------------------------------CARDÁPIOS - Tempero Baiano - Exibição----------------------------------
    public void mostrarTelaCardapioCafeManha() {
        System.out.println("__________                         " + temperoBaiano.getNome() + "              _____________");
        boolean repetir;
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        do {
            System.out.println("||___________________________ Cardápio - Café da manhã  __________________________||");
            for (int i = 0; i < temperoBaiano.getCardapioCafeDaManha().size(); i++) {
                comida = temperoBaiano.getCardapioCafeDaManha().get(i);
                System.out.println((i + 1) + ".   --" + comida.getNome() + "--  --Tamanho: " + comida.getTamanho() + "--  --Preço: R$" + comida.getPrecoProduto() + "--");
            }
            System.out.println("-------------------------------------------------------------------------------");
            mostrarComidaSelecionada();
            System.out.println("      ||--Quantidade de produtos escolhida até agora: " + pedidoModelo.getNumProdutos() + "  ||");
            System.out.println("      ||--Peço total do pedido:  R$" + pedidoModelo.getPrecoTotalPedido() + "                  ||");
            pegaEscolhaProdutoEQtdCafeManha();
            mostrarComidaSelecionada();
            remocaoComidaSelecionada();
            if (pedidoModelo.getComidaEscolhidas().size() == 0) {
                repetir = true;
            } else {
                System.out.println("--Deseja prosseguir com o pedido atual e configurar o pagamento ou continuar selecionando produtos?--");
                System.out.print("--->>>Digite 1 para ir para tela de pagamento e 2 para continuar selecionando itens: ");
                repetir = pegaEscolhaTelaCardapios();
            }
        } while (repetir);
    }

    public void mostrarTelaCardapioBebidasBR() {
        System.out.println("__________                       " + temperoBaiano.getNome() + "              _____________");
        boolean repetir;
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        do {
            System.out.println("||___________________________  Cardápio - Bebidas   __________________________||");
            for (int i = 0; i < temperoBaiano.getCardapioBebidasBR().size(); i++) {
                bebida = temperoBaiano.getCardapioBebidasBR().get(i);
                System.out.println((i + 1) + ".   --" + bebida.getNome() + "--  --Litro/ml: " + bebida.getLitroGarrafa() + "--  --Preço: R$" + bebida.getPrecoProduto() + "--");
            }
            System.out.println("-------------------------------------------------------------------------------");
            mostrarBebidasSelecionadas();
            System.out.println("      ||--Quantidade de produtos escolhida até agora: " + pedidoModelo.getNumProdutos() + "  ||");
            System.out.println("      ||--Peço total do pedido:  R$" + pedidoModelo.getPrecoTotalPedido() + "                  ||");
            pegaEscolhaProdutoEQtdBebidas();
            mostrarBebidasSelecionadas();
            remocaoBebidas();
            if (pedidoModelo.getBebidasEscolhidas().size() == 0) {
                repetir = true;
            } else {
                System.out.println("--Deseja prosseguir com o pedido atual e configurar o pagamento ou continuar selecionando produtos?--");
                System.out.print("--->>>Digite 1 para ir para tela de pagamento e 2 para continuar selecionando itens: ");
                repetir = pegaEscolhaTelaCardapios();
            }
        } while (repetir);
    }

    public void mostrarTelaCardapioSalgados() {
        System.out.println("__________                       " + temperoBaiano.getNome() + "              _____________");
        boolean repetir;
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        do {
            System.out.println("||___________________________   Cardápio - Salgados   __________________________||");
            for (int i = 0; i < temperoBaiano.getCardapioSalgados().size(); i++) {
                lanche = temperoBaiano.getCardapioSalgados().get(i);
                System.out.println((i + 1) + ".   --" + lanche.getNome() + "--  --Tamanho: " + lanche.getTamanho() + "-- --Qtd/Pacote: " + lanche.getQtdPacote() + "-- --Preço: R$" + lanche.getPrecoProduto() + "--");
            }
            System.out.println("-------------------------------------------------------------------------------");
            mostrarLanchesSelecionados();
            System.out.println("      ||--Quantidade de produtos escolhida até agora: " + pedidoModelo.getNumProdutos() + "  ||");
            System.out.println("      ||--Peço total do pedido:  R$" + pedidoModelo.getPrecoTotalPedido() + "                  ||");
            pegaEscolhaProdutoEQtdLanches(true); //Varia conforme o tipo de lanche.
            mostrarLanchesSelecionados();
            remocaoLanches();
            if (pedidoModelo.getLanchesEscolhidos().size() == 0) {
                repetir = true;
            } else {
                System.out.println("--Deseja prosseguir com o pedido atual e configurar o pagamento ou continuar selecionando produtos?--");
                System.out.print("--->>>Digite 1 para ir para tela de pagamento e 2 para continuar selecionando itens: ");
                repetir = pegaEscolhaTelaCardapios();
            }
        } while (repetir);
    }

    public void mostrarTelaCardapioDoces() {
        System.out.println("__________                        " + temperoBaiano.getNome() + "                _____________");
        boolean repetir;
        pedidoModelo = new Pedido(usuario, "Tempero Baiano");
        do {
            System.out.println("||___________________________  Cardápio - Doces  __________________________||");
            for (int i = 0; i < temperoBaiano.getCardapioDoces().size(); i++) {
                lanche = temperoBaiano.getCardapioDoces().get(i);
                System.out.println((i + 1) + ".   --" + lanche.getNome() + "--  --Tamanho: " + lanche.getTamanho() + "-- --Qtd/Pacote: " + lanche.getQtdPacote() + "-- --Preço: R$" + lanche.getPrecoProduto() + "--");
            }
            System.out.println("-------------------------------------------------------------------------------");
            mostrarLanchesSelecionados();
            System.out.println("      ||--Quantidade de produtos escolhida até agora: " + pedidoModelo.getNumProdutos() + "  ||");
            System.out.println("      ||--Peço total do pedido:  R$" + pedidoModelo.getPrecoTotalPedido() + "                  ||");
            pegaEscolhaProdutoEQtdLanches(false);
            mostrarLanchesSelecionados();
            remocaoLanches();
            if (pedidoModelo.getLanchesEscolhidos().size() == 0) {
                repetir = true;
            } else {
                System.out.println("--Deseja prosseguir com o pedido atual e configurar o pagamento ou continuar selecionando produtos?--");
                System.out.print("--->>>Digite 1 para ir para tela de pagamento e 2 para continuar selecionando itens: ");
                repetir = pegaEscolhaTelaCardapios();
            }
        } while (repetir);
    }

    //----------------------------------------------------------------------------------------------------------------
    //--------------------------------Métodos que pegam a escolha - Cardápios-------------------------
    public boolean pegaEscolhaTelaCardapios() {
        try {
            int escolha = leitura.nextInt();
            if (escolha == 1) {
                usuario.getPedidosCliente().add(pedidoModelo);
                usuario.setNumPedidos(usuario.getPedidosCliente().size());
                telas.abrirTelaPagamento();//Quando a tela de pagamento é aberta, o pedido atual já é passado para a lista de pedidos do usuário.
                return false;
            } else if (escolha == 2) {
                return true;
            } else {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("_______________________________________________________________");
            System.out.println("||-----                     ERRO!                       -----||");
            System.out.println("              O valor digitado é inválido.                      ");
            leitura.nextLine();
            return true;
        }
    }

    //------------------------Exibição das listas de produtos selecionados----------------------------
    //Três versões pois um pedido possui três tipos de lista de produtos: lanches, comida e bebida.
    public void mostrarBebidasSelecionadas() {
        System.out.println("----------------------Lista de produtos selecionados---------------------------");
        if (pedidoModelo.getBebidasEscolhidas().size() == 0) {
            System.out.println("-----------            Nenhum selecionado até agora!                 ----------");
        } else {
            for (int i = 0; i < pedidoModelo.getBebidasEscolhidas().size(); i++) { //Talvez troque para  numPedidos.
                bebida = pedidoModelo.getBebidasEscolhidas().get(i);
                System.out.println((i + 1) + ".   --" + bebida.getNome() + "--   --Litro/ml:" + bebida.getLitroGarrafa() + "-- --Preço: R$" + bebida.getPrecoProduto() + "--");
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void mostrarLanchesSelecionados() {
        System.out.println("----------------------Lista de produtos selecionados---------------------------");
        if (pedidoModelo.getLanchesEscolhidos().size() == 0) {
            System.out.println("-----------            Nenhum selecionado até agora!                 ----------");
        } else {
            for (int i = 0; i < pedidoModelo.getLanchesEscolhidos().size(); i++) { //Talvez troque para  numPedidos.
                lanche = pedidoModelo.getLanchesEscolhidos().get(i);
                System.out.println((i + 1) + ".   --" + lanche.getNome() + "--   --" + lanche.getTamanho() + "--  --Qtd/pacote: " + lanche.getQtdPacote() + "--   --Preço: R$" + lanche.getPrecoProduto() + "--");
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void mostrarComidaSelecionada() {
        System.out.println("----------------------Lista de produtos selecionados---------------------------");
        if (pedidoModelo.getComidaEscolhidas().size() == 0) {
            System.out.println("-----------          Nenhum selecionado até agora!               ----------");
        } else {
            for (int i = 0; i < pedidoModelo.getComidaEscolhidas().size(); i++) { //Talvez troque para  numPedidos.
                comida = pedidoModelo.getComidaEscolhidas().get(i);
                System.out.println((i + 1) + ".   --" + comida.getNome() + "--   --" + comida.getTamanho() + "-- --Preço: R$" + comida.getPrecoProduto() + "--");
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    //----------------------------Métodos de Tempero Baiano e Sabor Estrangeiro--------------------------
    public void pegaEscolhaProdutoEQtdBebidas() {
        boolean repetir;
        do {
            System.out.print("--->>>Digite o número do produto desejado:");
            //Método que pega a escolha do índice do produto.
            try {
                int indice = leitura.nextInt();
                if (pedidoModelo.getRestauranteEscolhido().equals("Tempero Baiano")) {
                    if (indice <= 0 || indice > temperoBaiano.getCardapioBebidasBR().size()) {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    } else {
                        indice--;
                        bebida = temperoBaiano.getCardapioBebidasBR().get(indice);
                        repetir = false;
                    }
                } else {
                    if (indice <= 0 || indice > saborEstrangeiro.getCardapioBebidas().size()) {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    } else {
                        indice--;
                        bebida = saborEstrangeiro.getCardapioBebidas().get(indice);
                        repetir = false;
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;
            }
        } while (repetir);
        do {
            System.out.print("--->>>Digite a quantidade desejada:"); //Para doces e salgados, seria quantidade de pacotes.
            // Método que define a quantidade.
            try {
                int qtd = leitura.nextInt();
                if (qtd <= 0) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    repetir = true;
                } else {
                    double precoTotal = 0d;
                    for (int i = 0; i < qtd; i++) {
                        pedidoModelo.getBebidasEscolhidas().add(bebida);
                        precoTotal += bebida.getPrecoProduto();
                    }
                    pedidoModelo.setPrecoTotalPedido(precoTotal);
                    pedidoModelo.setNumProdutos(pedidoModelo.getBebidasEscolhidas().size());
                    repetir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;
            }
        } while (repetir);
    }

    //------------------------------------------------------------------------------
    //---------Tempero Baiano - Telas de cardápios e métodos de controle-----------
    public void pegaEscolhaProdutoEQtdLanches(boolean ehSalgado) {
        boolean repetir; //Variável local que controla a repetição.
        do {
            System.out.print("--->>>Digite o número do produto desejado:");
            //Método que pega a escolha do índice do produto.
            try {
                int indice = leitura.nextInt();
                if (ehSalgado) {
                    if (indice <= 0 || indice > temperoBaiano.getCardapioSalgados().size()) {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    } else {
                        indice--;
                        lanche = temperoBaiano.getCardapioSalgados().get(indice);
                        repetir = false;
                    }
                } else {
                    if (indice <= 0 || indice > temperoBaiano.getCardapioDoces().size()) {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    } else {
                        indice--;
                        lanche = temperoBaiano.getCardapioDoces().get(indice);
                        repetir = false;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;
            }
        } while (repetir);
        do {
            System.out.print("--->>>Digite a quantidade desejada de pacotes:"); //Para doces e salgados, seria quantidade de pacotes.
            // Método que define a quantidade.
            try {
                int qtd = leitura.nextInt();
                if (qtd <= 0) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    repetir = true;
                } else {
                    double precoTotal = 0d;
                    for (int i = 0; i < qtd; i++) {
                        pedidoModelo.getLanchesEscolhidos().add(lanche);
                        precoTotal += lanche.getPrecoProduto();
                    }
                    pedidoModelo.setPrecoTotalPedido(precoTotal);
                    pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size());
                    repetir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;
            }
        } while (repetir);
    }

    public void pegaEscolhaProdutoEQtdCafeManha() {
        boolean repetir;
        do {
            System.out.print("--->>>Digite o número do produto desejado:");
            //Método que pega a escolha do índice do produto.
            try {
                int indice = leitura.nextInt();

                if (indice <= 0 || indice > temperoBaiano.getCardapioCafeDaManha().size()) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    repetir = true;
                } else {
                    indice--;
                    comida = temperoBaiano.getCardapioCafeDaManha().get(indice);
                    repetir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;

            }
        } while (repetir);
        do {
            System.out.print("--->>>Digite a quantidade desejada:"); //Para doces e salgados, seria quantidade de pacotes.
            // Método que define a quantidade.
            try {
                int qtd = leitura.nextInt();
                if (qtd <= 0) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    repetir = true;
                } else {
                    double precoTotal = 0d;
                    for (int i = 0; i < qtd; i++) {
                        pedidoModelo.getComidaEscolhidas().add(comida);
                        precoTotal += comida.getPrecoProduto();
                    }
                    pedidoModelo.setPrecoTotalPedido(precoTotal);
                    pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size());
                    repetir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;
            }
        } while (repetir);
    }

    //---------------------Sabor Estrangeiro - Métodos que pegam  o item escolhido-------------------------
    public void pegaEscolhaProdutoEQtdPizzas() {
        boolean repetir;
        do {
            System.out.print("--->>>Digite o número do produto desejado:");
            //Método que pega a escolha do índice do produto.
            try {
                int indice = leitura.nextInt();

                if (indice <= 0 || indice > saborEstrangeiro.getCardapioPizzas().size()) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    repetir = true;
                } else {
                    indice--;
                    comida = saborEstrangeiro.getCardapioPizzas().get(indice);
                    repetir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;
            }
        } while (repetir);
        do {
            System.out.print("--->>>Digite a quantidade desejada:"); //Para doces e salgados, seria quantidade de pacotes.
            // Método que define a quantidade.
            try {
                int qtd = leitura.nextInt();
                if (qtd <= 0) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    repetir = true;
                } else {
                    double precoTotal = 0d;
                    for (int i = 0; i < qtd; i++) {
                        pedidoModelo.getComidaEscolhidas().add(comida);
                        precoTotal += comida.getPrecoProduto();
                    }
                    pedidoModelo.setPrecoTotalPedido(precoTotal);
                    pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size());
                    repetir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;
            }
        } while (repetir);
    }
    public void pegaEscolhaProdutoEQtdAlmocoJantar() {
        boolean repetir;
        do {
            System.out.print("--->>>Digite o número do produto desejado:");
            //Método que pega a escolha do índice do produto.
            try {
                int indice = leitura.nextInt();
                if (indice <= 0 || indice > saborEstrangeiro.getCardapioAlmocoJantar().size()) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    repetir = true;
                } else {
                    indice--;
                    comida = saborEstrangeiro.getCardapioAlmocoJantar().get(indice);
                    repetir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;

            }
        } while (repetir);
        do {
            System.out.print("--->>>Digite a quantidade desejada:"); //Para doces e salgados, seria quantidade de pacotes.
            // Método que define a quantidade.
            try {
                int qtd = leitura.nextInt();
                if (qtd <= 0) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    repetir = true;
                } else {
                    double precoTotal = 0d;
                    for (int i = 0; i < qtd; i++) {
                        pedidoModelo.getComidaEscolhidas().add(comida);
                        precoTotal += comida.getPrecoProduto();
                    }
                    pedidoModelo.setPrecoTotalPedido(precoTotal);
                    pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size());
                    repetir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                leitura.nextLine();
                repetir = true;
            }
        } while (repetir);
    }
    //-------------------Méwtodos de remoção de itens selecionados durante  a configuração do pedido---------------------
    public void remocaoLanches() {
        boolean repetir;
        if (pedidoModelo.getComidaEscolhidas().size() > 1) {
            do {
                System.out.print("--->>>Se desejar remover todos os itens do seu pedido, digite '1', caso contrário digite '0':");
                //Método que deleta tudo dependendo da escolha do usuário.
                try {
                    int respostaDeletar = leitura.nextInt();
                    if (respostaDeletar == 0) {
                        repetir = false;
                    } else if (respostaDeletar == 1) {
                        pedidoModelo.getLanchesEscolhidos().clear();
                        pedidoModelo.setNumProdutos(0);
                        pedidoModelo.setPrecoTotalPedido(0d);
                        System.out.println("-----   Os itens foram removidos!  ----");
                        mostrarLanchesSelecionados();
                        repetir = false;
                    } else {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    leitura.nextLine();
                    repetir = true;
                }
            } while (repetir);
        }
        if (pedidoModelo.getLanchesEscolhidos().size() > 0) {
            do {
                System.out.print("--->>>Se desejar remover algum item do seu pedido, digite o número dele da sua lista de pedidos, caso contrário digite '0':");
                //Método que remove um item específico da lista de produtos.
                try {
                    int indiceItem = leitura.nextInt();
                    if (indiceItem == 0) {
                        repetir = false;
                    } else if (indiceItem < 0 || indiceItem > pedidoModelo.getLanchesEscolhidos().size()) {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    } else {
                        indiceItem--;
                        double precoRemover = pedidoModelo.getLanchesEscolhidos().get(indiceItem).getPrecoProduto();
                        double precoTotalAtual = pedidoModelo.getPrecoTotalPedido();
                        precoTotalAtual -= precoRemover;
                        pedidoModelo.setPrecoTotalPedido(precoTotalAtual);
                        pedidoModelo.getLanchesEscolhidos().remove(indiceItem);
                        pedidoModelo.setNumProdutos(pedidoModelo.getLanchesEscolhidos().size());
                        System.out.println("-----   O item foi removido!  ----");
                        mostrarLanchesSelecionados();
                        repetir = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    leitura.nextLine();
                    repetir = true;
                }
            } while (repetir);
        }
    }
    public void remocaoBebidas() {
        boolean repetir;
        if (pedidoModelo.getBebidasEscolhidas().size() > 1) {
            do {
                System.out.print("--->>>Se desejar remover todos os itens do seu pedido, digite '1', caso contrário digite '0':");
                //Método que deleta tudo dependendo da escolha do usuário.
                try {
                    int respostaDeletar = leitura.nextInt();
                    if (respostaDeletar == 0) {
                        repetir = false;
                    } else if (respostaDeletar == 1) {
                        pedidoModelo.getBebidasEscolhidas().clear();
                        pedidoModelo.setNumProdutos(0);
                        pedidoModelo.setPrecoTotalPedido(0d);
                        System.out.println("-----   Os itens foram removidos!  ----");
                        mostrarBebidasSelecionadas();
                        repetir = false;
                    } else {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    leitura.nextLine();
                    repetir = true;
                }
            } while (repetir);
        }
        if (pedidoModelo.getBebidasEscolhidas().size() > 0) {
            do {
                System.out.print("--->>>Se desejar remover algum item do seu pedido, digite o número dele da sua lista de pedidos, caso contrário digite '0':");
                //Método que remove um item específico da lista de produtos.
                try {
                    int indiceItem = leitura.nextInt();
                    if (indiceItem == 0) {
                        repetir = false;
                    } else if (indiceItem < 0 || indiceItem > pedidoModelo.getComidaEscolhidas().size()) {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    } else {
                        indiceItem--;
                        double precoRemover = pedidoModelo.getBebidasEscolhidas().get(indiceItem).getPrecoProduto();
                        double precoTotalAtual = pedidoModelo.getPrecoTotalPedido();
                        precoTotalAtual -= precoRemover;
                        pedidoModelo.setPrecoTotalPedido(precoTotalAtual);
                        pedidoModelo.getBebidasEscolhidas().remove(indiceItem);
                        pedidoModelo.setNumProdutos(pedidoModelo.getBebidasEscolhidas().size());
                        System.out.println("-----   O item foi removido!  ----");
                        mostrarBebidasSelecionadas();
                        repetir = false;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    leitura.nextLine();
                    repetir = true;
                }
            } while (repetir);
        }
    }
    public void remocaoComidaSelecionada() {
        boolean repetir;

        if (pedidoModelo.getComidaEscolhidas().size() > 1) {
            do {
                System.out.print("--->>>Se desejar remover todos os itens do seu pedido, digite '1', caso contrário digite '0':");
                //Método que deleta tudo dependendo da escolha do usuário.
                try {
                    int respostaDeletar = leitura.nextInt();
                    if (respostaDeletar == 0) {
                        repetir = false;

                    } else if (respostaDeletar == 1) {
                        pedidoModelo.getComidaEscolhidas().clear();
                        pedidoModelo.setNumProdutos(0);
                        pedidoModelo.setPrecoTotalPedido(0d);

                        System.out.println("-----   Os itens foram removidos!  ----");
                        mostrarComidaSelecionada();
                        repetir = false;
                    } else {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;

                    }
                } catch (InputMismatchException e) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    leitura.nextLine();
                    repetir = true;

                }
            } while (repetir);
        }
        if (pedidoModelo.getComidaEscolhidas().size() > 0) {
            do {
                System.out.print("--->>>Se desejar remover algum item do seu pedido, digite o número dele da sua lista de pedidos, caso contrário digite '0':");
                //Método que remove um item específico da lista de produtos.
                try {
                    int indiceItem = leitura.nextInt();
                    if (indiceItem == 0) {
                        repetir = false;
                    } else if (indiceItem < 0 || indiceItem > pedidoModelo.getComidaEscolhidas().size()) {
                        System.out.println("_______________________________________________________________");
                        System.out.println("||-----                     ERRO!                       -----||");
                        System.out.println("              O valor digitado é inválido.                      ");
                        repetir = true;
                    } else {
                        indiceItem--;
                        double precoRemover = pedidoModelo.getComidaEscolhidas().get(indiceItem).getPrecoProduto();
                        double precoTotalAtual = pedidoModelo.getPrecoTotalPedido();
                        precoTotalAtual -= precoRemover;
                        pedidoModelo.setPrecoTotalPedido(precoTotalAtual);
                        pedidoModelo.getComidaEscolhidas().remove(indiceItem);
                        pedidoModelo.setNumProdutos(pedidoModelo.getComidaEscolhidas().size());
                        System.out.println("-----   O item foi removido!  ----");
                        mostrarComidaSelecionada();
                        repetir = false;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("||-----                     ERRO!                       -----||");
                    System.out.println("              O valor digitado é inválido.                      ");
                    leitura.nextLine();
                    repetir = true;
                }
            } while (repetir);
        }
    }
    //---------------------------------------------------------------
    //----------------------------Informações da tela de pagamento - Métodos-------------------------
    public void mostraPedidoTelaPagamento() {// Mostra o pedido feito.
        System.out.println("Pedido ID: " + pedidoModelo.getIdPedido() + " || Qtd de produtos: " + pedidoModelo.getNumProdutos() + " || Data: " + pedidoModelo.getDataPedido() + " || Preço total: R$" + pedidoModelo.getPrecoTotalPedido() + ".");
        System.out.println("-----------------------------------------------------------------");
    }
    public void pegaEscolhaTelaPagamento() { //Define o tipo de pagamento.
        int escolha;
        try {
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1 -> pagarNaEntrega();
                case 2 -> pagarCartaoCredito();
                case 3 -> pagarCartaoDebito();
                case 4 -> pagarPorPix();
                default -> {
                    System.out.println("_______________________________________________");
                    System.out.println("||-----          ERRO!                   -----||");
                    System.out.println("       O valor digitado é inválido.             ");
                    System.out.println("_______________________________________________");
                    telas.abrirTelaPagamento();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("_______________________________________________");
            System.out.println("||-----          ERRO!                   -----||");
            System.out.println("       O valor digitado é inválido.             ");
            System.out.println("_______________________________________________");
            telas.abrirTelaPagamento();
        }
    }
    //--------------------Métodos do pagamento--------------
    public void pagarPorPix() {
        System.out.println("_____________________________________________________________________________");
        System.out.println("  Pix do restaurante " + pedidoModelo.getRestauranteEscolhido() + ": XXXXXXXXXXXXX   ");
        System.out.println("-----");
        System.out.println("Tipo de pagamento: por Pix.");
        System.out.println("Pedido: ID" + pedidoModelo.getIdPedido() + " | Qtd de produtos:" + pedidoModelo.getNumProdutos() + " | Data: " + pedidoModelo.getDataPedido() + ".");
        System.out.println("Valor total: R$" + pedidoModelo.getPrecoTotalPedido() + ".");
        System.out.println("-----");
        System.out.println("||             O pagamento está sendo efetuado...              ||");
        System.out.println("||---             Agradecemos pela preferência!             ---||");
        pedidoModelo.setEstado("Em produção...");
        pedidoModelo.setTipoPagamento("Por Pix.");
        telas.mostrarTelaUsuario(usuario);
    }
    public void pagarNaEntrega() {
        System.out.println("_________________________________________________________________________");
        System.out.print("Digite o endereço[Bairro, rua e número da residência ou prédio] de entrega:");
        String endereco = leitura.next();
        if (endereco.matches("[0-9]*")) { //Um endereço não pode ser formado de números.
            System.out.println("_______________________________________________");
            System.out.println("||-----          ERRO!                   -----||");
            System.out.println("       O endereço digitado é inválido.             ");
            System.out.println("_______________________________________________");

            telas.abrirTelaPagamento();
        } else {
            System.out.println("-----");
            System.out.println("Local de entrega: " + endereco + ".");
            System.out.println("Pedido ID: " + pedidoModelo.getIdPedido() + " | Qtd de produtos:" + pedidoModelo.getNumProdutos() + " | Data: " + pedidoModelo.getDataPedido() + ".");
            System.out.println("Valor total: R$" + pedidoModelo.getPrecoTotalPedido() + ".");
            System.out.println("-----");
            System.out.println("Certifique-se de possuir a quantia quanto seus produtos chegarem.");
            System.out.println("||---             Agradecemos pela preferência!             ---||");
            pedidoModelo.setEstado("Em produção...");
            pedidoModelo.setTipoPagamento("Durante a entrega.");
            telas.mostrarTelaUsuario(usuario);
        }
    }
    public void pagarCartaoCredito() {
        System.out.println("_____________________________________________________________________________");
        System.out.print("Digite o cartão de crédito para efetuar o pagamento:");
        String cartaoCredito = leitura.next();
        if (cartaoCredito.matches("[0-9]*")) {
            if (pedidoModelo.getPrecoTotalPedido() % 5d == 0) { //PARCELAS DE 2 OU 5 para este caso!
                double valorParcela = pedidoModelo.getPrecoTotalPedido() / 5;
                System.out.println("_________________________________________________________");
                System.out.println("||---      O pagamento será efetuado com parcelas       ---||");
                System.out.println("-----");
                System.out.println("Cartão: " + cartaoCredito + ".");
                System.out.println("Pedido ID: " + pedidoModelo.getIdPedido() + " | Qtd de produtos:" + pedidoModelo.getNumProdutos() + " | Data: " + pedidoModelo.getDataPedido() + ".");
                System.out.println("Valor total: R$" + pedidoModelo.getPrecoTotalPedido());
                System.out.println("Número de parcelas: 5 ");
                System.out.println("Valor ṕor parcela: R$" + valorParcela);
                System.out.println("-----");
                System.out.println("||             O pagamento está sendo efetuado...              ||");
                System.out.println("||---             Agradecemos pela preferência!             ---||");
                pedidoModelo.setEstado("Em produção...");
                pedidoModelo.setTipoPagamento("Por cartão de crédito.");
                telas.mostrarTelaUsuario(usuario);
            } else if (pedidoModelo.getPrecoTotalPedido() % 2d == 0) {
                //O else dirá que é impossível e redirecionará para o cartão de débito!
                double valorParcela = pedidoModelo.getPrecoTotalPedido() / 2;
                System.out.println("_________________________________________________________");
                System.out.println("||---      O pagamento será efetuado com parcelas       ---||");
                System.out.println("-----");
                System.out.println("Cartão: " + cartaoCredito + ".");
                System.out.println("Pedido ID: " + pedidoModelo.getIdPedido() + " | Qtd de produtos:" + pedidoModelo.getNumProdutos() + " | Data: " + pedidoModelo.getDataPedido() + ".");
                System.out.println("Valor total: R$" + pedidoModelo.getPrecoTotalPedido() + ".");
                System.out.println("Número de parcelas: 2 ");
                System.out.println("Valor ṕor parcela: R$" + valorParcela);
                System.out.println("-----");
                System.out.println("||             O pagamento está sendo efetuado...              ||");
                System.out.println("||---             Agradecemos pela preferência!             ---||");
                pedidoModelo.setEstado("Em produção...");
                pedidoModelo.setTipoPagamento("Por cartão de crédito.");
                telas.mostrarTelaUsuario(usuario);
            } else {
                System.out.println("_____________________________________________________________");
                System.out.println("  Não há possibilidade de pagamento por parcelas sem juros!  ");
                System.out.println("||-O pagamento será efetuado sem parcelas*Cartão de débito-||");
                System.out.println("-----");
                System.out.println("Cartão: " + cartaoCredito + ".");
                System.out.println("Pedido ID: " + pedidoModelo.getIdPedido() + " | Qtd de produtos:" + pedidoModelo.getNumProdutos() + " | Data: " + pedidoModelo.getDataPedido() + ".");
                System.out.println("Valor total: R$" + pedidoModelo.getPrecoTotalPedido() + ".");
                System.out.println("-----");
                System.out.println("||             O pagamento está sendo efetuado...              ||");
                System.out.println("||---             Agradecemos pela preferência!             ---||");
                pedidoModelo.setEstado("Em produção...");
                pedidoModelo.setTipoPagamento("Por cartão de débito.");
                telas.mostrarTelaUsuario(usuario);
            }
        } else {
            System.out.println("_______________________________________________");
            System.out.println("||-----          ERRO!                   -----||");
            System.out.println("       O cartão digitado é inválido.             ");
            System.out.println("_______________________________________________");
            telas.abrirTelaPagamento();
        }
    }
    public void pagarCartaoDebito() {
        System.out.println("_____________________________________________________________________________");
        System.out.print("Digite o cartão de débito para efetuar o pagamento:");
        String cartaoDebito = leitura.next();
        if (cartaoDebito.matches("[0-9*]")) { // Cartão - Deve possuir apenas números.
            System.out.println("_____________________________________________________________");
            System.out.println("                  PAGAMENTO - Cartâo de débito               ");
            System.out.println("-----");
            System.out.println("Cartão: " + cartaoDebito + ".");
            System.out.println("Pedido ID: " + pedidoModelo.getIdPedido() + " | Qtd de produtos:" + pedidoModelo.getNumProdutos() + " | Data: " + pedidoModelo.getDataPedido() + ".");
            System.out.println("Valor total: R$" + pedidoModelo.getPrecoTotalPedido() + ".");
            System.out.println("-----");
            System.out.println("||             O pagamento está sendo efetuado...              ||");
            System.out.println("||---             Agradecemos pela preferência!             ---||");
            pedidoModelo.setEstado("Em produção...");
            pedidoModelo.setTipoPagamento("Por cartão de débito.");
            telas.mostrarTelaUsuario(usuario);
        } else {
            System.out.println("_______________________________________________");
            System.out.println("||-----          ERRO!                   -----||");
            System.out.println("       O cartão digitado é inválido.             ");
            System.out.println("_______________________________________________");
            telas.abrirTelaPagamento();
        }
    }
    //------------------------------------------
    //--------------------Informações da tela de usuário - Métodos-------------
    public void mostrarDescricaoRestaurantes() { //Dois restaurantes.
        System.out.println("___________________________________");
        System.out.println("1.Restaurante " + saborEstrangeiro.getNome() + "---||- Descrição: " + saborEstrangeiro.getDescricaoRestaurante());
        System.out.println("___________________________________");
        System.out.println("2.Restaurante " + temperoBaiano.getNome() + "---||- Descrição: " + temperoBaiano.getDescricaoRestaurante());
        System.out.println("___________________________________");
    }
    public void mostrarDadosConta() {
        System.out.println("|--1.  Nome de usuário: " + usuario.getNomeUsuario());
        System.out.println("|--2.  Email: " + usuario.getEmail());
        System.out.println("|--3.  Senha: " + usuario.getSenha());
        System.out.println("|--4.  CPF: " + usuario.getCpf());
        System.out.println("|--5.  Número de telefone: " + usuario.getNumTelefone());
        System.out.println("|----> Número de pedidos: " + usuario.getNumPedidos());
    }
    public void modificarSenhaEsqueceuSenha(Cliente usuarioEsqueceuSenha) {
        String senha, senhaConfirmacao;
        System.out.print("Digite a nova senha: ");
        senha = leitura.next();
        System.out.print("Digite a nova senha novamente: ");
        senhaConfirmacao = leitura.next();
        if (senha.equals(senhaConfirmacao)) {
            usuarioEsqueceuSenha.setSenha(senha);
            System.out.println("--A senha foi modificada com sucesso!--");
        } else {
            System.out.println("________________________________________");
            System.out.println("||-----          ERRO!           -----||");
            System.out.println(" As senhas digitadas não são idênticas. ");
            modificarSenhaEsqueceuSenha(usuarioEsqueceuSenha); //Indica uma repetição desse método caso a validação das senhas seja falsa.
        }
    }
    public void desconectarConta() {
        System.out.println("_____________________|DESCONECTAR CONTA|_______________________");
        System.out.println("Sua conta será desconectada e você voltará para a tela inicial.");
        System.out.println("_______________________________________________________________");
        System.out.println("||-----                 Desconectando...                -----||");
        telas.mostrarTelaInicial();
    }
    public void excluirConta() { //EXCLUI A CONTA - Ela é retirada da lista de clientes cadastrados.
        System.out.println("_____________________|EXCLUIR CONTA|___________________________");
        System.out.println("      Tem certeza de que deseja excluir a sua conta atual?     ");
        System.out.print("----->>>Digite 1 para sim e 2 para não: ");
        try {
            int escolha = leitura.nextInt();
            if (escolha == 1) {
                clientesCadastrados.remove(usuario);
                System.out.println("_______________________________________________________________");
                System.out.println("_____________      Conta excluída com sucesso.     ____________");
                System.out.println("                Voltando para a tela inicial...                ");
                telas.mostrarTelaInicial();
            } else if (escolha == 2) {
                telas.mostrarTelaUsuario(usuario);
            } else {
                System.out.println("_______________________________________________________________");
                System.out.println("||-----                     ERRO!                       -----||");
                System.out.println("              O valor digitado é inválido.                      ");
                telas.mostrarTelaUsuario(usuario);
            }
        } catch (InputMismatchException e) {
            System.out.println("_______________________________________________________________");
            System.out.println("||-----                     ERRO!                       -----||");
            System.out.println("              O valor digitado é inválido.                      ");
            telas.mostrarTelaUsuario(usuario);
        }
    }
    public void mostrarListaPedidos() { //Exibe a lista na tela do usuário.
        if (usuario.getPedidosCliente().size() == 0) { //Se estiver vazia.
            System.out.println("                                                                             ----------NENHUM----------");
        } else {
            for (int i = 0; i < usuario.getPedidosCliente().size(); i++) {
                pedidoModelo = usuario.getPedidosCliente().get(i);
                System.out.println("-- |" + (i + 1) + "º pedido| - ID: " + pedidoModelo.getIdPedido() + "-- || --ESTADO: " + pedidoModelo.getEstado() + "-- || --RESTAURANTE: " + pedidoModelo.getRestauranteEscolhido() + "-- || --DATA: " + pedidoModelo.getDataPedido() + "-- || --PREÇO TOTAL: R$" + pedidoModelo.getPrecoTotalPedido() + "--");
            }
        }
    }
    //--------------------------------------------
    //----------------Fechamento de telas - Métodos--------------------
    public void fecharFastLunch(int telaAnterior) {
        int resposta;
        //Monitora se a mensagem de erro deve aparecer ou não.
        boolean repetir; //Vaiável local de validação para a repetição.
        do {
            System.out.println("___________________________________________________________________");
            System.out.println("Tem certeza de que deseja sair? [Digite 1 para sim ou 2 para não.]");
            System.out.println("___________________________________________________________________");
            try {
                resposta = leitura.nextInt();
                if (resposta == 1) {
                    System.out.println("--- Fechando Fast Lunch... ---");
                    repetir = false;
                    System.exit(0);
                } else if (resposta == 2) {
                    repetir = false;
                    if (telaAnterior == 1) {
                        telas.mostrarTelaInicial();
                    } else {
                        telas.mostrarTelaUsuario(usuario);
                    }
                } else {
                    System.out.println("----------Erro!---------");
                    System.out.println("O valor digitado é inválido!");
                    repetir = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("----------Erro!---------");
                System.out.println("O valor digitado é inválido!");
                repetir = true;
                leitura.nextLine();
            }
        } while (repetir);
    }
    //------------------Getters e setters------------------------

    public Cliente getUsuario() {
        return usuario;
    }

    public Scanner getLeitura() {
        return leitura;
    }

}
