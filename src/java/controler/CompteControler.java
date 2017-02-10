/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import bean.Compte;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import service.CompteFacade;
import service.OperationFacade;

/**
 *
 * @author ayoub
 */
@ManagedBean(name = "compteContrlor")
@SessionScoped
public class CompteControler implements Serializable {

    private Compte selected;
    private List<Compte> items;
    private Double soldeMin;
    private Double soldeMax;
    @EJB
    private CompteFacade ejbFacade;
    @EJB
    private OperationFacade operationFacade;
    private Double montantDebit;

    public void detail(){
     
             selected.setOperations(operationFacade.findAll());
     
    }
    public void findByCreteria() {
        items = ejbFacade.findCompte(soldeMin, soldeMax);
        initParam();
    }

    public Double getSoldeMin() {
        if (soldeMin == null) {
            soldeMin = new Double(0);
        }
        return soldeMin;
    }

    public void setSoldeMin(Double soldeMin) {
        this.soldeMin = soldeMin;
    }

    public Double getSoldeMax() {
        if (soldeMax == null) {
            soldeMax = new Double(0);
        }
        return soldeMax;
    }

    public void setSoldeMax(Double soldeMax) {
        this.soldeMax = soldeMax;
    }

    private void initParam() {
        selected = new Compte();
        soldeMax = new Double(0);
        soldeMin = new Double(0);
    }

    public String create() {
        ejbFacade.create(selected);
        initParam();
        return "/compte/List";
    }

    public void delete(Compte compte) {
        ejbFacade.remove(compte);
        items.remove(items.indexOf(compte));
        initParam();
    }

    public void editCompte(Compte c) {
        Compte compte = ejbFacade.find(c.getId());
        compte = selected;
        ejbFacade.create(compte);
        ejbFacade.remove(c);
        items.add(compte);
        initParam();
    }

    public String debiter() {
        int res = ejbFacade.debiter(selected.getId(), montantDebit);
        initParam();
        return "/compte/List";

    }

    public Double getMontantDebit() {

        return montantDebit;
    }

    public void setMontantDebit(Double montantDebit) {
        this.montantDebit = montantDebit;
    }

    public Compte getSelected() {
        if (selected == null) {
            selected = new Compte();
        }
        return selected;
    }

    public void setSelected(Compte selected) {
        this.selected = selected;
    }

    public List<Compte> getItems() {
        items = ejbFacade.findAll();
        return items;
    }

    public void setItems(List<Compte> items) {
        this.items = items;
    }

    public CompteFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(CompteFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    /**
     * Creates a new instance of compteContrlor
     */
    public CompteControler() {
    }

}
