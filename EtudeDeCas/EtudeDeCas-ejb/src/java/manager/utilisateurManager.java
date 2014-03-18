/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Utilisateur;
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
public class utilisateurManager {
    
    @PersistenceContext
    private EntityManager entityManager;
        
    //persist
    public void enregistrerUtilisateur(String inMail, String inNom, String inPrenom, String inMdp) {
        Utilisateur monUtilisateur = new Utilisateur();
        monUtilisateur.setMail(inMail);
        monUtilisateur.setNom(inNom);
        monUtilisateur.setPrenom(inPrenom);
        monUtilisateur.setMdp(inMdp);
        this.entityManager.persist(monUtilisateur);
    }
    public void supprimerUtilisateur(String inMail) {
    }
    public void modifierUtilisateur() {
    }
    
    //requetes
    public List<Utilisateur> tousUtilisateur() throws Exception {
        List<Utilisateur> utilisateurs;
        TypedQuery<Utilisateur> findAll = null;

        findAll = this.entityManager.createNamedQuery("Utilisateur.findAll", Utilisateur.class);
        utilisateurs = findAll.getResultList();

        return (utilisateurs);
    }
    public Utilisateur utilisateurParMail(String inMail) throws Exception {
        List<Utilisateur> utilisateurs;
        TypedQuery<Utilisateur> findByMail = null;

        findByMail = this.entityManager.createNamedQuery("Utilisateur.findByMail", Utilisateur.class);
        findByMail.setParameter("mail", inMail);

        utilisateurs = findByMail.getResultList();

        if (utilisateurs == null || utilisateurs.isEmpty()) {
            throw new Exception("Aucun utilisateur ne correspond à cette adresse mail");
        }

        if (utilisateurs.size() > 1) {
            throw new Exception("Plus d'un Utilisateur trouvé");
        }

        return (utilisateurs.get(0));
    }
    public List<Utilisateur> utilisateurParNom(String inNom) throws Exception {
        List<Utilisateur> utilisateurs;
        TypedQuery<Utilisateur> findByNom = null;

        findByNom = this.entityManager.createNamedQuery("Utilisateur.findByName", Utilisateur.class);
        findByNom.setParameter("nom", inNom);

        utilisateurs = findByNom.getResultList();

        if (utilisateurs == null || utilisateurs.isEmpty()) {
            return (null);
        }

        return (utilisateurs);
    }    
}
