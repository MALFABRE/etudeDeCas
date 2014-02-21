/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Fonction;
import entites.Salarie;
import entites.Utilisateur;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Thibaut
 */
@Stateless
@LocalBean
public class salarieManager {

    Salarie monSalarie = new Salarie();
    
    public void ajouterSalarie(String nom, String prenom, Fonction maFonction, Utilisateur utilisateurMaitre){
        monSalarie.setNom(nom);
        monSalarie.setPrenom(prenom);
        monSalarie.setFonction(maFonction);
        monSalarie.setUtilisateurMaitre(utilisateurMaitre);
    }
    
    public void modifierSalarie(){
        
    }
    
    public void supprimerSalarie(){
        
    }
}
