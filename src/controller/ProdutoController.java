package controller;

import java.util.List;
import model.Produto;
import service.ProdutoService;

/**
 *
 * @author Nicolas Ap
 */
public class ProdutoController {
    
    private final ProdutoService produtoService;
    
    public ProdutoController(){
        this.produtoService = new ProdutoService();
    }
    
    public void adicionarProduto(Produto produto){
        produtoService.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso no sistema!");
    }
    
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }
    
    public void removerProduto(int id){
        boolean removeu = produtoService.removerProduto(id);
        System.out.println(removeu ? "Produto removido com sucesso!" : "Produto não encontrado!");
    }
    
    public void editarProduto(Produto produto){
        boolean atualizou = produtoService.editarProduto(produto);
        System.out.println(atualizou ? "Produto atualizado com sucesso!" : "Produto não encontrado!");
    }
    
    public Produto buscarProdutoId(int id){
        try{
            Produto produto = produtoService.buscarProdutoId(id);
            return produto;
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Produto buscarProdutoNome(String nome){
        try{
            Produto produto = produtoService.buscarProdutoNome(nome);
            return produto;
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
