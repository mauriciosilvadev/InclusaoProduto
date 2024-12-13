/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InclusaoProduto.interfaces;

import InclusaoProduto.models.Produto;
import java.util.List;

/**
 *
 * @author Morrice
 */
public interface Observer {
    
    void update(List<Produto> produtos);
    
}
