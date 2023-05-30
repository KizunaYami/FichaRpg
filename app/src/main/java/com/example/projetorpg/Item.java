package com.example.projetorpg;

public class Item {

    private String descricao;
    private Integer id;

    public Item(){};


    public Integer getId() { return id; }
    public String getDescricao() { return descricao; }

    public void setId(Integer id) { this.id = id; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String toString(){

        return "Item: " + descricao;

    }


}
