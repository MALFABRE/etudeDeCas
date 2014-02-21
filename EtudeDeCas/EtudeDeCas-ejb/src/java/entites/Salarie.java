/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

import entites.Utilisateur;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Thibaut
 */
@Entity
public class Salarie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long num;
    private String nom;
    private String prenom;
    private Fonction maFonction;
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
        return maFonction;
    }

    public void setFonction(Fonction maFonction) {
        this.maFonction = maFonction;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salarie)) {
            return false;
        }
        Salarie other = (Salarie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Salarie[ id=" + id + " ]";
    }
    
}
