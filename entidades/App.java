package entidades;

public class App {
    public static void main(String[] args) throws Exception {

        //Criar 5 produtos e exibir suas informações
        
        Produto produto1 = new Produto ("{-----Carne-----}", 15, 60);
        
       System.out.println(produto1.getNome());
       System.out.println(produto1.getQuantidade());
       System.out.println(produto1.getPreco());

       Produto produto2 = new Produto ("{-----Arroz-----}", 100, 10);
        
       System.out.println(produto2.getNome());
       System.out.println(produto2.getQuantidade());
       System.out.println(produto2.getPreco());
       
       Produto produto3 = new Produto ("{-----Feijão-----}", 67, 15);
        
       System.out.println(produto3.getNome());
       System.out.println(produto3.getQuantidade());
       System.out.println(produto3.getPreco());

        Produto produto4 = new Produto ("{-----Farinha-----}", 20, 12);
        
        System.out.println(produto4.getNome());
       System.out.println(produto4.getQuantidade());
       System.out.println(produto4.getPreco());

        Produto produto5 = new Produto ("{-----Cerveja-----}", 9, 15);
        
       System.out.println(produto5.getNome());
       System.out.println(produto5.getQuantidade());
       System.out.println(produto5.getPreco());

    }
}
    

