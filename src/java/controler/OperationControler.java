/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import bean.Operation;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import service.OperationFacade;

/**
 *
 * @author ayoub
 */
@Named(value = "operationControler")
@SessionScoped
public class OperationControler implements Serializable {

    @EJB
    private OperationFacade ejbFacade;
    private Operation selected;
    private List<Operation> items;

    public String createop() {
        ejbFacade.createOperation(selected);
        selected=new Operation();
        return "/compte/List";
    }

    public Operation getSelected() {
        if (selected == null) {
            selected = new Operation();
        }
        return selected;
    }

    public void setSelected(Operation selected) {
        this.selected = selected;
    }

    public OperationFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(OperationFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Operation> getItems() {
        if(items==null){
            items=new ArrayList();
        }
        return items;
    }

    public void setItems(List<Operation> items) {
        this.items = items;
    }

    /**
     * Creates a new instance of OperationControler
     */
    public OperationControler() {
    }

}
