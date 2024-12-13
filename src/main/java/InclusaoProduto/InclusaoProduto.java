/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package InclusaoProduto;

import InclusaoProduto.collections.ProdutoCollection;
import InclusaoProduto.presenters.MenuPresenter;

/**
 *
 * @author Morrice
 */
public class InclusaoProduto {

    public static void main(String[] args) {

        ProdutoCollection produtos = new ProdutoCollection();

        MenuPresenter menu = new MenuPresenter(produtos);
        
        produtos.addObservador(menu);
    }
}
