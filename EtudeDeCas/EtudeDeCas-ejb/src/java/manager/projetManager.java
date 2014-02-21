/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Projet;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Thibaut
 */
@Stateless
@LocalBean
public class projetManager {
    
    Projet monProjet = new Projet();
    
    public void nouveauProjet(Date dateDebut, Date dateFin, String description){
        monProjet.setDateDebut(dateDebut);
        monProjet.setDateFin(dateFin);
        monProjet.setDescription(description);
    }
    
    public void supprimerProjet(){

    }
    
    public void modifierProjet(){
        
    }
}
