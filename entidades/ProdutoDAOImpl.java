package stockmanager_dao_impl;

import stockmanager_model.Produto;
import stockmanager_dao.ProdutoDAO;
import stockmanager_database.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    @Override
    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome_produto, quantidade, preco) VALUES (?, ?, ?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());

            stmt.execute();
        }
    }

    @Override
    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id_produto = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();

            return linhas > 0; 
        }
    }

    @Override
    public List<Produto> listar() throws SQLException {
        String sql = "SELECT * FROM produto ORDER BY id_produto ASC";
        List<Produto> lista = new ArrayList<>();

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                
              
                produto.setId(rs.getInt("id_produto")); 
                produto.setNome(rs.getString("nome_produto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));

                lista.add(produto); 
            }
        }
        return lista; 
    }
}
