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
    
    public void listarProdutos(){
        List<Produto> produtos = produtoService.listarProdutos();
        produtos.forEach(p -> System.out.println(p.getId() + " - " + p.getNome() + " | " + p.getQuantidade() + " unidades | R$ " + p.getPreco() + " valor unitário"));
    }
    
    public void removerProduto(int id){
        boolean removeu = produtoService.removerProduto(id);
        System.out.println(removeu ? "Produto removido com sucesso!" : "Produto não encontrado!");
    }
    
    public void editarProduto(Produto produto){
        boolean atualizou = produtoService.editarProduto(produto);
        System.out.println(atualizou ? "Produto atualizado com sucesso!" : "Produto não encontrado!");
    }
    
    public void buscarProdutoId(int id){
        try{
            Produto produto = produtoService.buscarProdutoId(id);
            System.out.println("Produto com o ID informado: " + produto.getNome());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void buscarProdutoNome(String nome){
        try{
            Produto produto = produtoService.buscarProdutoNome(nome);
            System.out.println("Produto com o nome informado: " + produto.getNome());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
