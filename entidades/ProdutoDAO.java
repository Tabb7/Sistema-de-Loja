package stockmanager_dao;

import java.sql.SQLException;
import java.util.List;
import stockmanager_model.Produto;

public interface ProdutoDAO {
    
    void inserir(Produto produto) throws SQLException;
    
    boolean deletar(int id) throws SQLException;
    
    List<Produto> listar() throws SQLException;
}
