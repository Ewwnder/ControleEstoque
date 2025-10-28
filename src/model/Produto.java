package model;

/**
 *
 * @author Nicolas Ap
 */
public class Produto {
    
    private int id;
    private String nome;
    private int idCategoria;
    private int quantidade;
    private double preco;

    public Produto(String nome, int idCategoria, int quantidade, double preco) {
        this.nome = nome;
        this.idCategoria = idCategoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

