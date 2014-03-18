package bean;

import entites.Projet;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import manager.projetManager;

/**
 *
 * @author maligejulien
 */

@ManagedBean
@RequestScoped
public class projetMBean implements Serializable {
       
    private static final long serialVersionUID = 1L;

    @EJB
    private projetManager projetManager;
    
    private Projet projetCourant;
    private boolean newProjetForm;
    
    
    public projetMBean() {
    }
       
    @PostConstruct
    public void init() {  
        this.projetCourant = new Projet(); 
        this.newProjetForm = false;
    }

    //========================================================================== getters et setters
    //=============================================================================================
    public Projet getProjetCourant() {
        return projetCourant;
    }
    public void setProjetCourant(Projet projetCourant) {
        this.projetCourant = projetCourant;
    }

    public boolean isNewProjetForm() {
        return newProjetForm;
    }
    public void setNewProjetForm(boolean newProjetForm) {
        this.newProjetForm = newProjetForm;
    }
    public void showNewProjetForm() {
        this.newProjetForm=true;
    }
    public void hideNewProjetForm() {
        this.newProjetForm=false;
        this.projetCourant= new Projet(); 
    }
    
    //========================================================================== Action
    //=============================================================================================
    
    public void nouveauProjet(){
    
    };
    public void ouvrirProjet(){};
    public void modifierProjet(){};
    public void sauvegarderProjet(){};
    public void supprimerProjet(){};
    public void exporterProjet(){};
    
}
