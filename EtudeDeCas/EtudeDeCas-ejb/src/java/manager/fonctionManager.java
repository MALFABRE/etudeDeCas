/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Fonction;
import entites.Tache;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Thibaut
 */
@Stateless
@LocalBean
public class fonctionManager {

    @PersistenceContext
    private EntityManager entityManager;
        
    //persist 
    public void ajouterFonction(String inLibelle){
        Fonction maFonction = new Fonction();
        maFonction.setLibelle(inLibelle);
        this.entityManager.persist(maFonction);
    }
    
    public void editerFonction(){
        
    }
    public void supprimerFonction(){
        
    }
    
    public List<Fonction> toutesFonctions() throws Exception {
        List<Fonction> fonctions;
        TypedQuery<Fonction> findAll = null;

        findAll = this.entityManager.createNamedQuery("Fonction.findAll", Fonction.class);
        fonctions = findAll.getResultList();

        return (fonctions);
    }
    public Fonction fonctionParNum(String inNum) throws Exception {
        List<Fonction> fonctions;
        TypedQuery<Fonction> findByNum = null;

        findByNum = this.entityManager.createNamedQuery("Fonction.findByNum", Fonction.class);
        findByNum.setParameter("num", inNum);

        fonctions = findByNum.getResultList();

        if (fonctions == null || fonctions.isEmpty()) {
            throw new Exception("Aucune fonction ne correspond à ce num");
        }

        if (fonctions.size() > 1) {
            throw new Exception("Plus d'une fonction trouve");
        }

        return (fonctions.get(0));
    }
    
}
