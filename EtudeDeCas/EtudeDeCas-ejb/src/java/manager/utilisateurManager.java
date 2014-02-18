/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Utilisateur;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Thibaut
 */
@Stateless
@LocalBean
public class utilisateurManager {
    
    Utilisateur monUtilisateur = new Utilisateur();
    
    public void enregistrerUtilisateur(String mail, String nom, String prenom, String mdp){
        monUtilisateur.setMail(mail);
        monUtilisateur.setNom(nom);
        monUtilisateur.setPrenom(prenom);
        monUtilisateur.setMdp(mdp);
    }
    
    public void supprimerUtilisateur (String mail){
    }
    
     public void modifierUtilisateur (){
    }
    
    
    
}
