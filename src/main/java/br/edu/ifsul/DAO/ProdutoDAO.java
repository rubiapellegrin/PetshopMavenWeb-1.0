/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.DAO;

import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.conversores.ConverterOrdem;
import java.io.Serializable;
import javax.ejb.Stateful;


/**
 *
 * @author MASTER
 */
@Stateful
public class ProdutoDAO<TIPO> extends DAOGenerico<Produto> implements Serializable {
    
    public ProdutoDAO(){
        super();
        classePersistente = Produto.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        //listaOrdem.add(new Ordem("estado.nome", "Estado", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);  
    }
}
