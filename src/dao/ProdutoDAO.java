package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author Nicolas Ap
 */
public class ProdutoDAO {
    
    public void adicionarProduto(Produto produto){
        String sql = "INSERT INTO produto (nome, idCategoria, quantidade, preco) VALUES (?,?,?,?)";
        
        try (Connection conn = ConexaoBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getIdCategoria());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getPreco());
            ps.executeUpdate();
            
        } catch (SQLException e){
            System.err.println("Erro ao adicionar produto no banco: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public List<Produto> listarProdutos(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        
        try (Connection conn = ConexaoBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            
            while (rs.next()){
                produtos.add(new Produto(
                        rs.getString("nome"),
                        rs.getInt("idCategoria"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                ));
            }
            
        } catch (SQLException e){
            System.err.println("Erro ao listar produtos: " + e.getMessage());
            throw new RuntimeException(e);
        }
        
        return produtos;
    }
    
    public boolean removerProduto(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
    
        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
        
            ps.setInt(1, id);
            int removido = ps.executeUpdate();
            return removido > 0;
        
        } catch (SQLException e) {
            System.err.println("Erro ao remover produto: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public boolean editarProduto (Produto produto){
        String sql = "UPDATE produto SET nome = ?, idCategoria = ?, quantidade = ?, preco = ? WHERE id = ?";
        
        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getIdCategoria());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getPreco());
            ps.setInt(5, produto.getId());
            
            int atualizacao = ps.executeUpdate();
            return atualizacao>0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao editar produto: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public Produto buscarProdutoPorId(int id){
        String sql = "SELECT * FROM produto WHERE id = ?";
        
        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    return new Produto(
                        rs.getString("nome"),
                        rs.getInt("idCategoria"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                    );
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
            throw new RuntimeException(e);
        }
        
        return null;
    }
    
    
    public Produto buscarProdutoPorNome(String nome){
        String sql = "SELECT * FROM produto WHERE nome = ?";
        
        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nome);
            
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    return new Produto(
                        rs.getString("nome"),
                        rs.getInt("idCategoria"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                    );
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
            throw new RuntimeException(e);
        }
        
        return null;
    }
}
