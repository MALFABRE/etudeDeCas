/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Utilisateur;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thibaut
 */
@Stateless
@LocalBean
public class utilisateurManager {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    Utilisateur monUtilisateur = new Utilisateur();
    
    public void enregistrerUtilisateur(String mail, String nom, String prenom, String mdp){
        monUtilisateur.setMail(mail);
        monUtilisateur.setNom(nom);
        monUtilisateur.setPrenom(prenom);
        monUtilisateur.setMdp(mdp);
        entityManager.persist(monUtilisateur);
    }
    
    public void supprimerUtilisateur (String mail){
    }
    
     public void modifierUtilisateur (){
    }
    
    
    
}
