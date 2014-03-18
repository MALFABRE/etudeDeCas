package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Thibaut
 */
@Entity
@Table(name = "Utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll",
            query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByMail",
            query = "SELECT u FROM Utilisateur u WHERE (u.mail = :mail)"),
    @NamedQuery(name = "Utilisateur.findByName",
            query = "SELECT u FROM Utilisateur u WHERE (u.nom = :nom)")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Email(message = "L'email est invalide")
    private String mail;
 
    @NotNull
    @Size(min = 2, max = 255, message = "Le nom doit contenir au minimum 2 caractères")
    private String nom;
    
    @NotNull
    @Size(min = 2, max = 255, message =  "Le prénom doit contenir au minimum 2 caractères")
    private String prenom;
    
    @NotNull
    @Size(min = 6, max = 255, message = "Le mot de passe doit contenir au minimum 6 caractères")
    private String mdp;
    
    public Utilisateur() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mail != null ? mail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.mail == null && other.mail != null) || (this.mail != null && !this.mail.equals(other.mail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Utilisateur[ Email=" + mail + " | Nom=" + nom + " | Prénom=" + prenom + " | Mot de passe=" + mdp + "]";
    }
    
}
