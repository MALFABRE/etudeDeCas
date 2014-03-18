package entites;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thibaut
 */

@Entity
@Table(name = "Tache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll",
            query = "SELECT t FROM Tache t"),
    @NamedQuery(name = "Tache.findByNum",
            query = "SELECT t FROM Tache t WHERE (t.num = :num)"),
    @NamedQuery(name = "Tache.findByTitre",
            query = "SELECT t FROM Tache t WHERE (t.titre = :titre)"),
    @NamedQuery(name = "Tache.findByDateDeb",
            query = "SELECT t FROM Tache t WHERE (t.dateDeb = :dateDeb)"),
    @NamedQuery(name = "Tache.findByDuree",
            query = "SELECT t FROM Tache t WHERE (t.duree = :duree)"),
    @NamedQuery(name = "Tache.findByProjet",
            query = "SELECT t FROM Tache t WHERE (t.projet = :projet)"),
    @NamedQuery(name = "Tache.findByTachePrec",
            query = "SELECT t FROM Tache t WHERE (t.tachePrec = :tachePrec)")
})


public class Tache implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long num;
    
    @NotNull
    @Size(min = 1, max = 255, message =  "Le titre doit contenir au minimum 1 caractère")
    private String titre;
    
    private String description;
    
    @NotNull
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dateDeb;

    @NotNull
    private long duree;

    @NotNull
    @OneToOne
    private Projet projet;
  
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

    public Calendar getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Calendar dateDeb) {
        this.dateDeb = dateDeb;
    }

    public long getDuree() {
        return duree;
    }

    public void setDuree(long duree) {
        this.duree = duree;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
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
