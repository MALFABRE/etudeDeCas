/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Projet;
import entites.Salarie;
import entites.Tache;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Thibaut
 */
@Stateless
@LocalBean
public class tacheManager {
    
    Tache maTache = new Tache();
    
    public void nouvelleTache(String titre, String description, Date dateDeb, Date duree, Projet monProjet, Collection<Salarie> listeSalarie, Tache tachePrec){
        maTache.setTitre(titre);
        maTache.setDescription(description);
        maTache.setDateDeb(titre);
        maTache.setDuree(duree);
        maTache.setProjet(monProjet);
        maTache.setListeSalarie(listeSalarie);
        maTache.setTachePrec(maTache);
    }
    
    public void editerTache(){
        
    }
    
    public void supprimerTache(){
        
    }
    
}
