/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.test.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "modelisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelisation.findAll", query = "SELECT m FROM Modelisation m"),
    @NamedQuery(name = "Modelisation.findByIdTypeDeProfil", query = "SELECT m FROM Modelisation m WHERE m.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Modelisation.findByDomaine", query = "SELECT m FROM Modelisation m WHERE m.domaine = :domaine"),
    @NamedQuery(name = "Modelisation.findByNiveau", query = "SELECT m FROM Modelisation m WHERE m.niveau = :niveau")})
public class Modelisation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private Integer idTypeDeProfil;
    @Column(name = "domaine")
    private String domaine;
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Profilgl profilgl;

    public Modelisation() {
    }

    public Modelisation(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Integer getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Profilgl getProfilgl() {
        return profilgl;
    }

    public void setProfilgl(Profilgl profilgl) {
        this.profilgl = profilgl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeDeProfil != null ? idTypeDeProfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelisation)) {
            return false;
        }
        Modelisation other = (Modelisation) object;
        if ((this.idTypeDeProfil == null && other.idTypeDeProfil != null) || (this.idTypeDeProfil != null && !this.idTypeDeProfil.equals(other.idTypeDeProfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Modelisation[ idTypeDeProfil=" + idTypeDeProfil + " ]";
    }
    
}
