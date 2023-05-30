package com.infinitehorizon.ficharpgdd;

public class Usuario {

    private Integer id;

    private String apelido;
    private String senha;

    public Usuario(){};

    public Usuario(String apelido, String senha){ this.apelido = apelido; this.senha= senha;}

    public Integer getId() { return id; }
    public String getApelido() {
        return apelido;
    }
    public String getSenha(){
        return senha;
    }

    public void setId(Integer id) { this.id = id; }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
}