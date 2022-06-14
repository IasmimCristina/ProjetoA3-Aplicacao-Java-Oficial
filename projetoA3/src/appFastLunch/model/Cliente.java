package appFastLunch.model;

import java.util.LinkedList;

public class Cliente {
    //Será o cliente do restaurante e usuário da aplicação.
    //------ATRIBUTOS--------
    private String nomeUsuario;
    private String email;
    private String senha;
    private String cpf;
    private String numTelefone;
    private LinkedList<Pedido> pedidosCliente;
    private Integer numPedidos;
    //-------------
    //--------CONSTRUTOR---------
    //Para novos usuários:
    public Cliente(String nomeUsuario, String email, String senha, String cpf, String numTelefone) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.numTelefone = numTelefone;
        this.pedidosCliente = new LinkedList<>(); //A lista é criada e preenchida após a configuração quando a aplicação estiver funcionando.
        this.numPedidos = 0;//Um cliente começa com 0 pedidos.
    }
    //-------------------Getters e setters----------------------
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public LinkedList<Pedido> getPedidosCliente() {
        return pedidosCliente;
    }

    public Integer getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(Integer numPedidos) {
        this.numPedidos = numPedidos;
    }
}
