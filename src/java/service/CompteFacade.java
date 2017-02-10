/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.Operation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ayoub
 */
@Stateless
public class CompteFacade extends AbstractFacade<Compte> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    public CompteFacade() {
        super(Compte.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     public List<Compte> findCompte(Double min, Double max) {
        String req = "SELECT c FROM Compte c WHERE 1=1 ";
       if(min!=null && max!=null){
           return em.createQuery("SELECT c FROM Compte c WHERE c.solde >= "+min+" AND c.solde <="+max).getResultList();
       }
        if (min != null) {
            req += " AND c.solde >=" + min;
        }
        if (max != null) {
            req += " AND c.solde <=" + max;
        }
        return em.createQuery(req).getResultList();

    }

    public int debiter(String ribCompte, Double montantDebit) {
        Compte compte = find(ribCompte);
        if (compte.getSolde() < montantDebit) {
            return -1;
        } else {
            compte.setSolde(compte.getSolde() - montantDebit);
            edit(compte);
            return 1;
        }
    }

 
    
}
