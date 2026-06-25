package stockmanager_;

import stockmanager_dao.ProdutoDAO;
import stockmanager_dao_impl.ProdutoDAOImpl;
import stockmanager_model.Produto;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n=================================");
            System.out.println("       PAINEL DE ESTOQUE         ");
            System.out.println("=================================");
            System.out.println("1. Ver Estoque (Listar)");
            System.out.println("2. Adicionar Produto");
            System.out.println("3. Tirar Produto (Deletar)");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
                continue;
            }

            try {
                switch (opcao) {
                    case 1:
                        exibirEstoque(dao);
                        break;
                    case 2:
                        adicionarProdutoMenu(dao, scanner);
                        break;
                    case 3:
                        deletarProdutoMenu(dao, scanner);
                        break;
                    case 4:
                        System.out.println("Saindo do sistema... Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (SQLException e) {
                System.err.println("Erro no banco de dados: " + e.getMessage());
            }

        } while (opcao != 4);

        scanner.close();
    }

    private static void exibirEstoque(ProdutoDAO dao) throws SQLException {
        System.out.println("\n--- ESTOQUE ATUAL ---");
        List<Produto> produtos = dao.listar();
        
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println("ID: " + p.getId() + 
                               " | Nome: " + p.getNome() + 
                               " | Qtd: " + p.getQuantidade() + 
                               " | Preço: R$ " + String.format("%.2f", p.getPreco()));
        }
    }

   
    private static void adicionarProdutoMenu(ProdutoDAO dao, Scanner scanner) throws SQLException {
        System.out.println("\n--- ADICIONAR NOVO PRODUTO ---");
        Produto novoProduto = new Produto();

        System.out.print("Nome do produto: ");
        novoProduto.setNome(scanner.nextLine());

        System.out.print("Quantidade inicial: ");
        novoProduto.setQuantidade(Integer.parseInt(scanner.nextLine()));

        System.out.print("Preço: R$ ");
        novoProduto.setPreco(Double.parseDouble(scanner.nextLine()));

        dao.inserir(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    
    private static void deletarProdutoMenu(ProdutoDAO dao, Scanner scanner) throws SQLException {
        System.out.println("\n--- REMOVER PRODUTO ---");
        System.out.print("Digite o ID do produto que deseja remover: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean deletado = dao.deletar(id);
        if (deletado) {
            System.out.println("Produto com ID " + id + " removido com sucesso!");
        } else {
            System.out.println("Aviso: Nenhum produto encontrado com o ID " + id);
        }
    }
}
