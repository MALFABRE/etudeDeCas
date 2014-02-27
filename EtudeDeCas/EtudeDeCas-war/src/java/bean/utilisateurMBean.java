/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entites.Utilisateur;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import manager.utilisateurManager;

/**
 *
 * @author Thibaut
 */
@ManagedBean
@SessionScoped
public class utilisateurMBean {

    @EJB
    private utilisateurManager utilisateurManager;
    private Utilisateur monUtilisateur;
    
    public utilisateurMBean() {
    }
    
    @PostConstruct
    public void init() {  
        monUtilisateur = new Utilisateur();
    }
    
    
        
    public void enregistrer(){
        try{
         
        utilisateurManager.enregistrerUtilisateur(monUtilisateur.getMail(), monUtilisateur.getNom(), monUtilisateur.getPrenom(), monUtilisateur.getMdp());
        }
        catch(Exception e) {
             System.out.print(e.getMessage());
        }
    }
    
    public Utilisateur getMonUtilisateur(){
        return this.monUtilisateur;
    }
    
    public void setMonUtilisateur(Utilisateur inUtilisateur){
        this.monUtilisateur = inUtilisateur;
    }
    
    
}
