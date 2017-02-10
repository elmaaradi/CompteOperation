/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.Operation;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ayoub
 */
@Stateless
public class OperationFacade extends AbstractFacade<Operation> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;
    @EJB
    private CompteFacade ejbFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Operation> findByCompte(Compte compte) {
//        List<Operation> list = em.createQuery("SELECT op FROM Operation op WHERE op.compte.id Like '" + compte.getId() + "'").getResultList();
//        System.out.println(list1);
        if (compte == null) {
            System.out.println("llllllllllll");
        }
        try {
           List<Operation> list = findAll();
        List<Operation> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Operation get = list.get(i);
            if (get.getCompte().getId().equals(compte.getId())) {
                list1.add(get);
            }
            return list1;
        }
        System.out.println(list1);  
        } catch (Exception e) {
            
        }
       
        return new ArrayList<>();
    }

    public int createOperation(Operation operation) {
        Compte compte = ejbFacade.find(operation.getCompte().getId());

        if (compte != null) {
            if (operation.getType() == 2 && operation.getMontant() <= compte.getSolde()) {
                ejbFacade.debiter(compte.getId(), operation.getMontant());
                create(operation);
                return 1;
            } else if (operation.getType() == 1) {
                compte.setSolde(operation.getMontant() + compte.getSolde());
                ejbFacade.edit(compte);
                create(operation);
                return 1;
            }
            operation.setCompte(compte);
            List<Operation> list = compte.getOperations();
            list.add(operation);
            compte.setOperations(list);
            ejbFacade.edit(compte);
            edit(operation);
        }
        return -3;
    }

    public OperationFacade() {
        super(Operation.class);
    }

}
