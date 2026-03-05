package entidades;

//Criar a classe Produto com os atributos nome, quantidade e preço.//

public class Produto {
    private String nome;
    private int quantidade;
    private int preco;

    public Produto (String nome, int quantidade, int preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto(Object nome2, Object quantidade2, Object preco2) {
        
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getPreco() {
        return preco;
    }

}
