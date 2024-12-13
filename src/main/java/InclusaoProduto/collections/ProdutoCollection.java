/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InclusaoProduto.collections;

import InclusaoProduto.interfaces.Observer;
import InclusaoProduto.models.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Morrice
 */
public class ProdutoCollection {

    private List<Produto> produtos;
    private List<Observer> observadores = new ArrayList<>();

    public ProdutoCollection() {
        produtos = new ArrayList<>();
    }
    
    public void addObservador(Observer observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observer observador) {
        observadores.remove(observador);
    }

    public void incluir(Produto produto) throws Exception {
        if (produto == null) {
            throw new IllegalArgumentException("Informe um produto válido");
        }
        
        try {
            produtos.add(produto);
            this.notificaObservadores();
        } catch (Exception e) {
             throw new Exception("Não foi possível adicionar o produto, erro: " + e.getMessage());
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Optional<Produto> findProdutoByNome(String nome) {
        Optional<Produto> optProduto = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return optProduto.of(produto);
            }
        }
        return optProduto.empty();
    }

    public void remove(String nome) throws Exception {
        Optional<Produto> produto = this.findProdutoByNome(nome);

        if (produto.isEmpty()) {
            throw new Exception("Produto não encontrado");
        }

        try {
            produtos.remove(produto.get());
            this.notificaObservadores();
        } catch (Exception e) {
             throw new Exception("Não foi possível remover o produto, erro: " + e.getMessage());
        }
    }
    
    public int size() {
        return produtos.size();
    }
    
    private void notificaObservadores() {
        for (Observer observador : observadores) {
            observador.update(produtos);
        }
    }
}
