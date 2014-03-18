package bean;

import entites.Utilisateur;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import manager.utilisateurManager;

/**
 *
 * @author Thibaut
 */
@ManagedBean
@SessionScoped
public class utilisateurMBean implements Serializable {

    private static final long serialVersionUID = 1L;
      
    @EJB
    private utilisateurManager utilisateurManager;
    
    private Utilisateur utilisateurCourant;
    
    public utilisateurMBean() {
    }
    
    @PostConstruct
    public void init() {  
        utilisateurCourant = new Utilisateur(); 
    }
    
    //========================================================================== getters et setters
    //=============================================================================================
    public Utilisateur getUtilisateurCourant(){
        return this.utilisateurCourant;
    }
    public void setUtilisateurCourant(Utilisateur inUtilisateur){
        this.utilisateurCourant = inUtilisateur;
    }
    
    //========================================================================== Action
    //=============================================================================================
    public void enregistrer(){
        try{
        System.out.println("Ajout nouvel utilisateur : "+this.utilisateurCourant.toString());
        this.utilisateurManager.enregistrerUtilisateur(this.utilisateurCourant.getMail(),
                                                       this.utilisateurCourant.getNom(),
                                                       this.utilisateurCourant.getPrenom(),
                                                       this.utilisateurCourant.getMdp());
        }
        catch(Exception e) {
             System.out.print(e.getMessage());
        }   
    }
    public void modifier(){};
    public void supprimer(){};
    
    public String seConnecter() {
        System.out.print("connexion de : " + this.utilisateurCourant.getMail());

        try {
            //controle du mail
            Utilisateur utilisateurTrouve = this.utilisateurManager.utilisateurParMail(this.utilisateurCourant.getMail());
            System.out.print("utilisateurTrouve : " + utilisateurTrouve);

            //controle du mdp
            if (this.utilisateurCourant.getMdp().equals(utilisateurTrouve.getMdp())) {
                System.out.println("Connexion");
                this.utilisateurCourant = utilisateurTrouve;
                return "app/main.xhtml?faces-redirect=true";
            } else {
                System.out.println("Mot de passe invalide");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mot de passe invalide", ""));
                return "index.xhtml";
            }

        } catch (Exception e) {
            System.out.println("utilisateur non trouvée : " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
            return "index.xhtml";
        }
    }
    
    
}
