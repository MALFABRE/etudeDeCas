/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Thibaut
 */
@Entity
public class Tache implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long num;
    private String titre;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeb;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date duree;
    @OneToOne
    private Projet monProjet;
    @OneToMany
    private Collection<Salarie> listeSalarie;
    @OneToOne
    private Tache tachePrec;

    public Tache() {
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
    }

    public Projet getProjet() {
        return monProjet;
    }

    public void setProjet(Projet monProjet) {
        this.monProjet = monProjet;
    }

    public Collection<Salarie> getListeSalarie() {
        return listeSalarie;
    }

    public void setListeSalarie(Collection listeSalarie) {
        this.listeSalarie = listeSalarie;
    }

    public Tache getTachePrec() {
        return tachePrec;
    }

    public void setTachePrec(Tache tachePrec) {
        this.tachePrec = tachePrec;
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
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Tache[ num=" + num + " ]";
    }
    
}
