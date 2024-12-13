/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InclusaoProduto.presenters;

import InclusaoProduto.collections.ProdutoCollection;
import InclusaoProduto.models.Produto;
import InclusaoProduto.views.InclusaoProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Morrice
 */
public class InclusaoProdutoPresenter {

    private Produto produto;
    private InclusaoProdutoView view;
    private ProdutoCollection produtos;

    public InclusaoProdutoPresenter(ProdutoCollection produtos) {
        this.produtos = produtos;
        this.view = new InclusaoProdutoView();
        configuraView();
    }
    
    public void abreView() {
        this.view.setVisible(true);
    }
    
    public void fechaView() {
        this.view.setVisible(false);
    }

    private void configuraView() {
        this.view.getBtnConcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        
        this.view.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        
        this.view.setLocationRelativeTo(null);
    }
    
    private void salvar() throws Exception {
        String nome = view.getTxtNome().getText();
        
        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome do produto é obrigatório");
        }
        
        double precoCusto = Double.parseDouble(view.getTxtPrecoCusto().getText());
        
        if (precoCusto  <= 0) {
            throw new Exception("Preço de custo deve ser maior que zero");
        }
        
        double percentualLucro = Double.parseDouble(view.getTxtPercentualLucro().getText());
        
        if (percentualLucro <= 0) {
            throw new Exception("Percentual de lucro deve ser maior que zero");
        }
        
        double precoVenda = Double.parseDouble(view.getTxtPrecoVenda().getText());
        
        if (precoVenda <= 0) {
            throw new Exception("Preço de venda deve ser maior que zero");
        }
        
        produto = new Produto(nome, precoCusto, percentualLucro, precoVenda);
        
        produtos.incluir(produto);
        
        JOptionPane.showMessageDialog(view, "Produto incluído com sucesso!");
    }

}
