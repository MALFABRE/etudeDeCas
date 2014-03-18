/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Projet;
import java.util.Calendar;
import java.util.Date;
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
public class projetManager {

    @PersistenceContext
    private EntityManager entityManager;

    public void Projet() {
    }

    //persist
    public void nouveauProjet(Calendar inDateDebut, Calendar inDateFin, String inDescription) {
        Projet monProjet = new Projet();
        monProjet.setDateDebut(inDateDebut);
        monProjet.setDateFin(inDateFin);
        monProjet.setDescription(inDescription);
        this.entityManager.persist(monProjet);
    }
    public void supprimerProjet() {
    }
    public void modifierProjet() {
    }
    
    //requetes
    public List<Projet> tousProjet() throws Exception {
        List<Projet> projets;
        TypedQuery<Projet> findAll = null;

        findAll = this.entityManager.createNamedQuery("Projet.findAll", Projet.class);
        projets = findAll.getResultList();

        return (projets);
    }    
    public Projet utilisateurParNum(String inNum) throws Exception {
        List<Projet> projets;
        TypedQuery<Projet> findByNum = null;

        findByNum = this.entityManager.createNamedQuery("Projet.findByNum", Projet.class);
        findByNum.setParameter("num", inNum);

        projets = findByNum.getResultList();

        if (projets == null || projets.isEmpty()) {
            throw new Exception("Aucun projet ne correspond à ce numéro");
        }

        if (projets.size() > 1) {
            throw new Exception("Plus d'un projet trouvé");
        }

        return (projets.get(0));
    }
}
