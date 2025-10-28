package service;

import dao.ProdutoDAO;
import java.util.List;
import model.Produto;

/**
 *
 * @author Nicolas Ap
 */
public class ProdutoService {
    
    private final ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }
    
    public void adicionarProduto(Produto produto){
        if (produto.getNome()==null || produto.getNome().trim().isEmpty()){
            throw new IllegalArgumentException("O nome do produto não pode estar em branco!");
        }
        if (produto.getPreco()<=0){
            throw new IllegalArgumentException("O preço do produto deve ser maior que 0 (zero)!");
        }
        if (produto.getQuantidade()<0){
            throw new IllegalArgumentException("A quantidade de produto não pode ser negativa!");
        }
        
        produtoDAO.adicionarProduto(produto);
    }
    
    public List<Produto> listarProdutos(){
        return produtoDAO.listarProdutos();
    }
    
    public Produto buscarProdutoId(int id){
        Produto produto = produtoDAO.buscarProdutoPorId(id);
        
        if (produto==null){
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
        
        return produto;
    }
    
    public Produto buscarProdutoNome(String nome){
        if (nome==null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome do produto não pode estar vazio!");
        }
        
        Produto produto = produtoDAO.buscarProdutoPorNome(nome);
        
        if (produto==null){
            throw new RuntimeException("Produto não encontrado com o nome: " + nome);
        }
        
        return produto;
    }
    
    public boolean editarProduto(Produto produto){
        if (produto.getId()<=0){
            throw new IllegalArgumentException("Esse ID é inválido para edição.");
        }
        
        return produtoDAO.editarProduto(produto);
    }
    
    public boolean removerProduto(int id){
        if (id<=0){
            throw new IllegalArgumentException("ID inválido para remoção");
        }
        
        return produtoDAO.removerProduto(id);
    }
}
