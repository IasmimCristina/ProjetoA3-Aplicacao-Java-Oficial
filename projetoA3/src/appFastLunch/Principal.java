package appFastLunch;

import appFastLunch.views.TelasIniciais;
import java.text.ParseException;

public class Principal {
    public static void main(String[] args) throws ParseException {
        //-------------------------------------------------------------------------------------------
        //Aplicação ue efetua o cadastro e entrada de clientes, além dos seus pedidos a restaurantes.
        //Nome: Fast Lunch
        //-------------------------------------------------------------------------------------------
        //------------------------------------------
        //              INÍCIO
        //------------------------------------------
        TelasIniciais telasIniciais = new TelasIniciais();
        telasIniciais.mostrarTelaInicial();   //-------Mostrará a tela inicial--------
    }
}
