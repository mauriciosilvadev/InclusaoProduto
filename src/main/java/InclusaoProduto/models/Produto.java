/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InclusaoProduto.models;

/**
 *
 * @author Morrice
 */
public class Produto {

    private String nome;
    private double precoCusto;
    private double precoVenda;
    private double percentualLucro;

    public Produto(String nome, double precoCusto, double precoVenda, double percentualLucro) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.percentualLucro = percentualLucro;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public double getPercentualLucro() {
        return percentualLucro;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" + "Preco de custo: " + precoCusto + "\n" + "Preco de Venda: " + precoVenda + "\n" + "Percentual de lucro: " + percentualLucro + "\n";
    }
}
