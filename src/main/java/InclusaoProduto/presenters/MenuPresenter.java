/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InclusaoProduto.presenters;

import InclusaoProduto.collections.ProdutoCollection;
import InclusaoProduto.interfaces.Observer;
import InclusaoProduto.models.Produto;
import InclusaoProduto.views.MenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Morrice
 */
public final class MenuPresenter implements Observer {

    private MenuView view;
    private ProdutoCollection produtos;

    public MenuPresenter(ProdutoCollection produtos) {
        this.produtos = produtos;

        this.view = new MenuView();
        this.view.setVisible(false);
        configuraView();
        this.view.setVisible(true);
    }

    public void configuraView() {
        this.view.getBtnIncluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    (new InclusaoProdutoPresenter(produtos)).abreView();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        this.view.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    (new ListaProdutoPresenter(produtos)).abreView();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        this.view.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    view.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        
        this.view.getLblTotalProdutos().setText(String.valueOf(produtos.size()));

        this.view.setLocationRelativeTo(null);
    }

    @Override
    public void update(List<Produto> produtos) {
        this.view.getLblTotalProdutos().setText(String.valueOf(produtos.size()));
    }

}
