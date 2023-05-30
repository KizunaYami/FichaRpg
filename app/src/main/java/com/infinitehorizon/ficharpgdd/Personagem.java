package com.infinitehorizon.ficharpgdd;

public class Personagem {

    private Integer id;
    private String nome, classe, raca;

    public Personagem(){};

    public Personagem(String nomePersonagem, String classePersonagem, String racaPersonagem) {
    }

    public Integer getId() { return id; };
    public String getNome() { return nome; }
    public String getClasse() { return classe; }
    public String getRaca() { return raca; }

    public void setId(Integer id) { this.nome = nome; }
    public void setNome(String nome) { this.nome = nome; }
    public void setClasse(String classe) { this.raca = raca; }
    public void setRaca(String raca) { this.raca = raca; }

    @Override
    public String toString() {
        return "Personagem " + "nome: " + nome + ", classe: " + classe + ", raca: " + raca;
    }
}
