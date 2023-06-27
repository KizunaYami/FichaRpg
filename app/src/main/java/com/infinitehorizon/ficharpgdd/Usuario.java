package com.infinitehorizon.ficharpgdd;

import java.io.Serializable;

public class Usuario implements Serializable {
    private Integer id;
    private String apelido;
    private String senha;

    public Usuario(String apelido, String senha) {
        this.apelido = apelido;
        this.senha= senha;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }

    public String getSenha() {
        return senha;
    }
}
