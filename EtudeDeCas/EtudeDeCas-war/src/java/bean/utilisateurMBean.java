/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entites.Utilisateur;
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
        
    public void enregistrer(){
        utilisateurManager.enregistrerUtilisateur(monUtilisateur.getMail(), monUtilisateur.getNom(), monUtilisateur.getPrenom(), monUtilisateur.getMdp());
    }
    
    public Utilisateur getMonUtilisateur(){
        return this.monUtilisateur;
    }
    
    public void setMonUtilisateur(Utilisateur inUtilisateur){
        this.monUtilisateur = inUtilisateur;
    }
    
    
}
