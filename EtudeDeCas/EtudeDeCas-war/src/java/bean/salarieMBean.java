/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entites.Salarie;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import manager.salarieManager;

/**
 *
 * @author Thibaut
 */
@ManagedBean
@SessionScoped
public class salarieMBean {

    @EJB
    private salarieManager salarieManager;
    
    @ManagedProperty(value="#{utilisateurEnSession}")
    private utilisateurMBean utilisateurSession;
    
    private Salarie salarieCourant;
    private boolean newSalarieForm;
    
    public salarieMBean() {
    }

    @PostConstruct
    public void init(){
        salarieCourant = new Salarie();
        newSalarieForm = false;
    }
    
    //========================================================================== getters et setters
    //=============================================================================================
    public Salarie getSalarieCourant() {
        return salarieCourant;
    }
    public void setSalarieCourant(Salarie inSalarie) {
        this.salarieCourant = inSalarie;
    }
    
    //========================================================================== pop up
    //=============================================================================================   
    public boolean isNewSalarieForm() {
        return newSalarieForm;
    }
    public void setNewSalarieForm(boolean newSalarieForm) {
        this.newSalarieForm = newSalarieForm;
    }
    public void showNewSalarieForm() {
        this.newSalarieForm=true;
    }
    public void hideNewSalarieForm() {
        this.newSalarieForm=false;
        this.salarieCourant= new Salarie(); 
    }
    //========================================================================== Action
    //=============================================================================================
    public void enregistrer(){
        try{
        System.out.println("Ajout nouvel utilisateur : "+this.salarieCourant.toString());
        this.salarieManager.ajouterSalarie(this.salarieCourant.getNom(),
                                           this.salarieCourant.getPrenom(),
                                           this.salarieCourant.getFonction(),
                                           this.utilisateurSession.getUtilisateurCourant());
        }
        catch(Exception e) {
             System.out.print(e.getMessage());
        }
    }
 
    
        public void setUtilisateurSession(utilisateurMBean inUtilisateurEnSession) {
            this.utilisateurSession = inUtilisateurEnSession;
	}
    
}
