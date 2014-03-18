/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Projet;
import entites.Salarie;
import entites.Tache;
import java.util.Calendar;
import java.util.Collection;
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
public class tacheManager {
    
    @PersistenceContext
    private EntityManager entityManager;
        
    //persist    
    public void nouvelleTache(String inTitre,
                              String inDescription,
                              Calendar inDateDeb,
                              long inDuree,
                              Projet inProjet,
                              Collection<Salarie> inListeSalarie, 
                              Tache inTachePrec){
        Tache maTache = new Tache();
        maTache.setTitre(inTitre);
        maTache.setDescription(inDescription);
        maTache.setDateDeb(inDateDeb);
        maTache.setDuree(inDuree);
        maTache.setProjet(inProjet);
        maTache.setListeSalarie(inListeSalarie);
        maTache.setTachePrec(inTachePrec);
        this.entityManager.persist(maTache);

    }
    public void editerTache(){
        
    }
    public void supprimerTache(){
        
    }
    
    
    //requetes
    public List<Tache> toutesTaches() throws Exception {
        List<Tache> taches;
        TypedQuery<Tache> findAll = null;

        findAll = this.entityManager.createNamedQuery("Tache.findAll", Tache.class);
        taches = findAll.getResultList();

        return (taches);
    }
    public Tache tacheParNum(String inNum) throws Exception {
        List<Tache> taches;
        TypedQuery<Tache> findByNum = null;

        findByNum = this.entityManager.createNamedQuery("Tache.findByNum", Tache.class);
        findByNum.setParameter("num", inNum);

        taches = findByNum.getResultList();

        if (taches == null || taches.isEmpty()) {
            throw new Exception("Aucune tache ne correspond à ce num");
        }

        if (taches.size() > 1) {
            throw new Exception("Plus d'une tache trouve");
        }

        return (taches.get(0));
    }
    public List<Tache> tachesParDateDeb(Calendar inDateDeb) throws Exception {
        List<Tache> taches;
        TypedQuery<Tache> findByDateDeb = null;

        findByDateDeb = this.entityManager.createNamedQuery("Tache.findByDateDeb", Tache.class);
        findByDateDeb.setParameter("dateDeb", inDateDeb);

        taches = findByDateDeb.getResultList();

        if (taches == null || taches.isEmpty()) {
            throw new Exception("Aucune tache ne correspond à cette date de debut");
        }

        return (taches);
    }
    public List<Tache> tachesParDuree(long inDuree) throws Exception {
        List<Tache> taches;
        TypedQuery<Tache> findByDuree = null;

        findByDuree = this.entityManager.createNamedQuery("Tache.findByDuree", Tache.class);
        findByDuree.setParameter("duree", inDuree);

        taches = findByDuree.getResultList();

        if (taches == null || taches.isEmpty()) {
            throw new Exception("Aucune tache ne correspond à cette duree");
        }

        return (taches);
    }
    public List<Tache> tachesParProjet(Projet inProjet) throws Exception {
        List<Tache> taches;
        TypedQuery<Tache> findByProjet = null;

        findByProjet = this.entityManager.createNamedQuery("Tache.findByProjet", Tache.class);
        findByProjet.setParameter("projet", inProjet);

        taches = findByProjet.getResultList();

        if (taches == null || taches.isEmpty()) {
            throw new Exception("Aucune tache ne correspond à cet projet");
        }

        return (taches);
    }
    public List<Tache> tachesParTachePrec(Projet inTachePrec) throws Exception {
        List<Tache> taches;
        TypedQuery<Tache> findByTachePrec = null;

        findByTachePrec = this.entityManager.createNamedQuery("Tache.findByTachePrec", Tache.class);
        findByTachePrec.setParameter("tachePrec", inTachePrec);

        taches = findByTachePrec.getResultList();

        if (taches == null || taches.isEmpty()) {
            throw new Exception("Aucune tache ne correspond à cette tache precedente");
        }

        return (taches);
    }
    
}
