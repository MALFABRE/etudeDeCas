package entites;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Thibaut
 */

@Entity
@Table(name = "Projet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projet.findAll",
            query = "SELECT p FROM Projet p"),
    @NamedQuery(name = "Projet.findByNum",
            query = "SELECT p FROM Projet p WHERE (p.num = :num)"),
    @NamedQuery(name = "Projet.findByDateDebut",
            query = "SELECT p FROM Projet p WHERE (p.dateDebut = :dateDebut)"),
   @NamedQuery(name = "Projet.findByDateFin",
            query = "SELECT p FROM Projet p WHERE (p.dateFin = :dateFin)"),
    @NamedQuery(name = "Projet.findByUtilisateur",
            query = "SELECT p FROM Projet p WHERE (p.utilisateur = :utilisateur)"),
})
public class Projet implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long num;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @NotNull
    private Calendar dateDebut;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dateFin;
    
    
    private String description;
    
    @OneToOne
    @NotNull
    private Utilisateur utilisateur;

    public Projet() {
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Calendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Calendar getDateFin() {
        return dateFin;
    }

    public void setDateFin(Calendar dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Projet[ Numéro=" + num + " ]";
    }
    
}
