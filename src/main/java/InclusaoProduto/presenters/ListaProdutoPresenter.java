/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InclusaoProduto.presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import InclusaoProduto.collections.ProdutoCollection;
import InclusaoProduto.views.ListaProdutoView;

/**
 *
 * @author Morrice
 */
public class ListaProdutoPresenter {

    private ListaProdutoView view;
    private ProdutoCollection produtos;

    public ListaProdutoPresenter(ProdutoCollection produtos) {
        this.produtos = produtos;
        this.view = new ListaProdutoView();
        configuraView();
    }

    private void configuraView() {
        carregaProdutos();

        this.view.getBtnVoltar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fechaView();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        this.view.getBtnRemoverProduto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removerProduto();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        this.view.setLocationRelativeTo(null);
    }

    private void removerProduto() throws Exception {
        int linhaSelecionada = this.view.getTblListaProduto().getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view, "Por favor, selecione um produto para remover.");
            return;
        }

        String nomeProduto = (String) view.getTblListaProduto().getValueAt(linhaSelecionada, 0);

        int resposta = JOptionPane.showConfirmDialog(
                view,
                "Tem certeza de que deseja remover o produto '" + nomeProduto + "'?",
                "Confirmação de Remoção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {

            produtos.remove(nomeProduto);

            carregaProdutos();

            JOptionPane.showMessageDialog(view, "Produto removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(view, "Remoção cancelada.");
        }
    }

    private void carregaProdutos() {
        DefaultTableModel model = (DefaultTableModel) view.getTblListaProduto().getModel();
        model.setRowCount(0);

        produtos.getProdutos().forEach(produto -> {
            model.addRow(new Object[] {
                    produto.getNome(),
                    produto.getPrecoVenda(),
                    produto.getPrecoCusto(),
                    produto.getPercentualLucro(),
            });
        });
    }

    public void abreView() {
        this.view.setVisible(true);
    }

    public void fechaView() {
        this.view.setVisible(false);
    }
}
