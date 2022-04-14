/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.DAO.ProdutoDAO;
import br.edu.ifsul.modelo.Produto;
import br.ifsul.edu.Util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author MASTER
 */
@Named(value = "ControleProduto")
@ViewScoped
public class ControleProduto implements Serializable {

    @EJB
    private ProdutoDAO<Produto> dao;
    private Produto objeto;

    public ControleProduto() {

    }

    public String listar() {
        return "/privado/produto/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Produto();
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }

    }

    public void excluir(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso! ");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso! ");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }


    public ProdutoDAO<Produto> getDao() {
        return dao;
    }

 
    public void setDao(ProdutoDAO<Produto> dao) {
        this.dao = dao;
    }


    public Produto getObjeto() {
        return objeto;
    }

    public void setObjeto(Produto objeto) {
        this.objeto = objeto;
    }

}
