package com.example.visumed.entidades;

public class User {
    private String nome;
    private String cpf;
    private String email;

    public User(String nome, String cpf, String email, String foto) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public User(){}

    public String getNome() {
        return  nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
