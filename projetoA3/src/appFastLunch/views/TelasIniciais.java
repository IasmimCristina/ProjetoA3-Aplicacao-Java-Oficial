package appFastLunch.views;

import appFastLunch.controllers.TelasIniciaisController;
import appFastLunch.model.Cliente;
import java.text.ParseException;


public class TelasIniciais {
    //-----------PARTE VISUAL - Apresentação textual-------------------------
    //-----------------------------------------------------------------------
    //----Controller---- Não muda
    private final TelasIniciaisController controller; //As telas iniciais precisam de um controller.
    //-------------------
    //--------CONSTRUTOR-----------
    public TelasIniciais() {
        this.controller = new TelasIniciaisController(this);
    }//O this se refere às telas iniciais atuais.
    //--------------------------------

    //--------------------------------------------------------------
    //-----------------Métodos - Abertura das telas------------------

    public void mostrarTelaUsuario(Cliente usuario) {//A tela de usuário precisa de um cliente para trabalhar com seus atributos.
        System.out.println("   -----                                                                       __ Olá, "+usuario.getNomeUsuario()+"! __                                                                   -----   ");
        System.out.println("______________________________________________________________________________________________________________________________________________________________________");
        System.out.println("                                                                             LISTA DE PEDIDOS EFETUADOS      ");
        System.out.println("                                                                             --------------------------");
        controller.mostrarListaPedidos(); //Método que mostra a lista na tela do usuário.
        System.out.println("______________________________________________________________________________________________________________________________________________________________________");
        System.out.println("                                                                         _______________________________");
        System.out.println("                                                                         ||      1.Fazer pedido       ||");
        System.out.println("                                                                         ||     2.Visualizar conta    ||");
        System.out.println("                                                                         ||     3.Modificar conta     ||");
        System.out.println("                                                                         ||    4.Desconectar conta    ||");
        System.out.println("                                                                         ||      5.Excluir conta      ||");
        System.out.println("                                                                         ||    6.Fechar Fast Lunch    ||");
        System.out.println("                                                                         _______________________________");
        System.out.print("                                                                           Digite a sua escolha: ");
        controller.pegaEscolhaTelaUsuario();
    }
    public void mostrarTelaEntrarConfirmacao() {
        System.out.println("--------------------------");
        System.out.println("            ENTRAR");
        System.out.println("--------------------------");
        System.out.println("1. ||       Entrar      ||");
        System.out.println("2. || Esqueceu a senha? ||");
        System.out.println("3. ||      Voltar       ||");
        System.out.println("--------------------------");
        System.out.print("Digite a sua escolha:");
        controller.pegaEscolhaTelaEntrarConfirmacao();
    }
    public void mostrarTelaEntrar() {
        System.out.println("--------------------------");
        System.out.println("          ENTRAR");
        System.out.println("--------------------------");
        System.out.print("Digite o seu nome de usuário:");
        String nomeUsuario = controller.getLeitura().next();
        System.out.print("Digite a sua senha:");
        String senha = controller.getLeitura().next();
        controller.pegaDadosEntrada(nomeUsuario,senha);
    }
    public void mostrarTelaEsqueceuSenha() {
        System.out.println("------------------------------------------");
        System.out.println("             ESQUECEU A SENHA");
        System.out.print("Digite o seu endereço de e-mail cadastrado:");
        controller.pegaEscolhaEsqueceuSenha();
    }
    public  void mostrarTelaInicial(){
        boolean repetir; //Variável local que cuida da repetição
        do {

            System.out.println("--------------------------");
            System.out.println("1. ||     Cadatrar-se   ||");
            System.out.println("2. ||       Entrar      ||");
            System.out.println("3. || Fechar Fast Lunch ||");
            System.out.println("--------------------------");
            System.out.print("Digite a sua escolha:");
            repetir = controller.pegaEscolhaTelaInicial(); //Método que pega a resposta:
        } while (repetir);

    }
    public  void mostrarTelaCadastrarConfirmacao(){
        boolean repetir;//Variável local que cuida da repetição
        do {
            System.out.println("-----------------");
            System.out.println("1.| Cadatrar-se|");
            System.out.println("2.|   Voltar   |");
            System.out.println("-----------------");
            System.out.println("Digite a sua escolha: [1 para sim e 2 para não.]");
            repetir = controller.pegaEscolhaCadastrarConfirmacao();
        } while(repetir); //Pois a validação da repetição está sendo feita dentro da função acima.
    }
    public  void mostrarTelaCadastrarInfo() {
        //---Variáveis que pegam o dado  do usuário--
        String nomeUsuario, email, senha, senhaConfirmacao, cpf, numTel;
        //--------------------------------------------
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("**** Digite as informações pedidas abaixo para criar uma nova conta ****");
        boolean validacao;//Variável local que cuida da repetição e validação dos dados!
        do {
            System.out.print("||--> Nome de usuário: "); // Nome de usuário não se repete.
            nomeUsuario = controller.getLeitura().next();
            validacao = controller.validacaoNomeUsuario(nomeUsuario);
        }while (!validacao);
        do {
            System.out.print("||--> Email: ");
            email = controller.getLeitura().next();
            validacao = controller.validacaoEmail(email);
        } while (!validacao);
        do {
            System.out.print("||--> Senha: ");
            senha = controller.getLeitura().next();
            System.out.print("|Comfirmação|--> Senha novamente: ");
            senhaConfirmacao = controller.getLeitura().next();
            validacao = controller.validacaoSenha(senha,senhaConfirmacao);
        } while(!validacao);
         do {
             System.out.print("||--> CPF: ");
             cpf = controller.getLeitura().next();
             validacao = controller.validacaoCPF(cpf);
         } while(!validacao);
        try {//Cuida da exceção jogada pela função MaskFormatter.
            cpf = controller.formatarMascaraCPF(cpf); //Formata antes de criar o usuário.
        } catch (ParseException e) {
            e.printStackTrace();
        }
        do {
             System.out.print("||--> Número de telefone: ");
             numTel = controller.getLeitura().next();
             validacao = controller.validacaoNumTel(numTel);
         }while(!validacao);
        try {
            numTel = controller.formatarMascaraTel(numTel);//Formata antes de criar o usuário.
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean repetir;//Variável local que cuida da repetição.
        do {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("1.|                   Cadatrar-se                   |");
            //Levará a um método cadastrar usuario.
            System.out.println("2.|     Voltar *Não salvará os dados inseridos.*    |");
            System.out.println("Digite a sua escolha: [1 para sim e 2 para não.]");
            repetir = controller.pegaEscolhaTelaCadastrar(nomeUsuario,email,senha,cpf,numTel);
        } while(repetir);
    }
    public void abrirVisualizarConta() {
        System.out.println("___________________________________");
        System.out.println("||---      |Conta - "+controller.getUsuario().getNomeUsuario()+"|                  ---||");
        controller.mostrarDadosConta();//Método que mostra os dados cadastrados do cliente
        System.out.println("1. Voltar");
        System.out.println("2. Modificar conta");
        System.out.println("_____________");
        System.out.print("Digite a sua escolha: ");
        controller.pegaEscolhaVisualizarConta();//Método que pegará a escolha do usuário e redirecionará para a tela escolhida.
    }
    public void abrirTelaModificarConta() {
        System.out.println("___________________________________________________");
        System.out.println("||---            |Conta - "+controller.getUsuario().getNomeUsuario()+"|              ---||");
        controller.mostrarDadosConta();//Método que mostra os dados cadastrados do cliente.
        System.out.println("|--                     6.Voltar                --|");
        System.out.println("---------------------------------------------------");
        System.out.print("Digite qual dado você deseja modificar ou '6' se desejar voltar: ");
        controller.pegaEscolhaModificarConta();
    }
    //-------------------------Abertura das telas - Pedido e restaurante------------------------
    public void abrirTelaPagamento(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("----                              PAGAMENTO                        ----");
        controller.mostraPedidoTelaPagamento();
        //Método que exibe o pedido ATUAL e seu preço total. CRIE
        System.out.println("----                          1. Durante a entrega                 ----");
        System.out.println("----                          2. Por cartão de crédito             ----");
        System.out.println("----                          3. Por cartão de débito              ----");
        System.out.println("----                          4. Por Pix.                          ----");
        System.out.print("||--->>Digite a forma de pagamento desejada:");
        controller.pegaEscolhaTelaPagamento();  //Método que pega a escolha de pagamento e mostra as respectivas configurações do escolhido.
    }
    public void abrirTelaPedidoRestaurante() {
        System.out.println("___________________________________");
        System.out.println("________Pedido - Configuração______");
        System.out.println("Selecione o restaurante desejado:");
        controller.mostrarDescricaoRestaurantes();//Método que mostra as descrições do restaurante
        System.out.print("Digite a sua escolha: ");
        controller.pegaEscolhaRestaurante(); //Leitura e validação.
    }
    public void abrirTelaRestauranteInternacional(){
        System.out.println("________________________________________");
        System.out.println("____________SABOR ESTRANGEIRO___________");
        System.out.println("-----   1. Cárdapio de pizzas     ------");
        System.out.println("---- 2. Cárdapio de almoço/jantar ------");
        System.out.println("----   3. Cárdapio de bebidas     ------");
        System.out.println("________________________________________");
        System.out.print("Digite a sua escolha:");
        controller.pegaEscolhaCardapioSEstrangeiro();//Método que pega a escolha do cardápio.
    }
    public void abrirTelaRestauranteBR(){
        System.out.println("________________________________________");
        System.out.println("_____________TEMPERO BAIANO_____________");
        System.out.println("----- 1. Cárdapio de café da manhã------");
        System.out.println("----    2. Cárdapio de salgados   ------");
        System.out.println("----     3. Cárdapio de doces     ------");
        System.out.println("----    4. Cárdapio de bebidas    ------");
        System.out.println("________________________________________");

        System.out.println("Digite a sua escolha:");
        controller.pegaEscolhaCardapioTBaiano();//Método que pega a escolha do cardápio.
    }
    //---------------------------------------------------------------------------------------------------

}
