/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Fonction;
import entites.Salarie;
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
public class salarieManager {

    @PersistenceContext
    private EntityManager entityManager;
        
    //persist    
    public void             ajouterSalarie(String inNom, String inPrenom, Fonction inFonction, Utilisateur inUtilisateurMaitre){
        Salarie monSalarie = new Salarie();
        monSalarie.setNom(inNom);
        monSalarie.setPrenom(inPrenom);
        monSalarie.setFonction(inFonction);
        monSalarie.setUtilisateurMaitre(inUtilisateurMaitre);
        this.entityManager.persist(monSalarie);
    }
    public void             modifierSalarie(){
        
    }
    public void             supprimerSalarie(){
        
    }
    
    //requetes
    public List<Salarie>    tousSalarie() throws Exception {
        List<Salarie> salaries;
        TypedQuery<Salarie> findAll = null;

        findAll = this.entityManager.createNamedQuery("Salarie.findAll", Salarie.class);
        salaries = findAll.getResultList();

        return (salaries);
    }
    public Salarie          salarieParNum(String inNum) throws Exception {
        List<Salarie> salaries;
        TypedQuery<Salarie> findByNum = null;

        findByNum = this.entityManager.createNamedQuery("Salarie.findByNum", Salarie.class);
        findByNum.setParameter("num", inNum);

        salaries = findByNum.getResultList();

        if (salaries == null || salaries.isEmpty()) {
            throw new Exception("Aucun salarie ne correspond à ce num");
        }

        if (salaries.size() > 1) {
            throw new Exception("Plus d'un salarie trouvé");
        }

        return (salaries.get(0));
    }
    public List<Salarie>    salariesParNom(String inNom) throws Exception {
        List<Salarie> salaries;
        TypedQuery<Salarie> findByNom = null;

        findByNom = this.entityManager.createNamedQuery("Salarie.findByNom", Salarie.class);
        findByNom.setParameter("nom", inNom);

        salaries = findByNom.getResultList();

        if (salaries == null || salaries.isEmpty()) {
            throw new Exception("Aucun salarie ne correspond à cet nom");
        }
        
        return (salaries);
    }
    public List<Salarie>    salariesParFonction(Fonction inFonction) throws Exception {
        List<Salarie> salaries;
        TypedQuery<Salarie> findByFonction = null;

        findByFonction = this.entityManager.createNamedQuery("Salarie.findByFonction", Salarie.class);
        findByFonction.setParameter("fonction", inFonction);

        salaries = findByFonction.getResultList();

        if (salaries == null || salaries.isEmpty()) {
            throw new Exception("Aucun salarie ne correspond à cet nom");
        }

        return (salaries);
    }
    public List<Salarie>    salariesParMaitre(Utilisateur inUtilisateurMaitre) throws Exception {
        List<Salarie> salaries;
        TypedQuery<Salarie> findByUtilisateurMaitre = null;

        findByUtilisateurMaitre = this.entityManager.createNamedQuery("Salarie.findByUtilisateurMaitre", Salarie.class);
        findByUtilisateurMaitre.setParameter("utilisateurMaitre", inUtilisateurMaitre);

        salaries = findByUtilisateurMaitre.getResultList();

        if (salaries == null || salaries.isEmpty()) {
            throw new Exception("Aucun salarie ne correspond à cet nom");
        }

        return (salaries);
    }

}
