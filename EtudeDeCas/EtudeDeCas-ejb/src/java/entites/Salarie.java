/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thibaut
 */


@Entity
@Table(name = "Salarie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salarie.findAll",
            query = "SELECT s FROM Salarie s"),
    @NamedQuery(name = "Salarie.findByNum",
            query = "SELECT s FROM Salarie s WHERE (s.num = :num)"),
    @NamedQuery(name = "Salarie.findByNom",
            query = "SELECT s FROM Salarie s WHERE (s.nom = :nom)"),
    @NamedQuery(name = "Salarie.findByFonction",
            query = "SELECT s FROM Salarie s WHERE (s.fonction = :fonction)"),
    @NamedQuery(name = "Salarie.findByUtilisateurMaitre",
            query = "SELECT s FROM Salarie s WHERE (s.utilisateurMaitre = :utilisateurMaitre)")

})

public class Salarie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long num;
    
    @NotNull
    @Size(min = 2, max = 255, message = "Le nom doit contenir au minimum 2 caractères")
    private String nom;

    @NotNull
    @Size(min = 2, max = 255, message = "Le prenom doit contenir au minimum 2 caractères")
    private String prenom;
    
    @NotNull
    @OneToOne
    private Fonction fonction;
    
    @NotNull
    @OneToOne
    private Utilisateur utilisateurMaitre;

    public Salarie() {
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
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

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public Utilisateur getUtilisateurMaitre() {
        return utilisateurMaitre;
    }

    public void setUtilisateurMaitre(Utilisateur utilisateurMaitre) {
        this.utilisateurMaitre = utilisateurMaitre;
    }
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (num != null ? num.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salarie)) {
            return false;
        }
        Salarie other = (Salarie) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Salarie[ num=" + num + " nom=" + nom + " prenom=" + prenom + " ]";
    }
    
}
