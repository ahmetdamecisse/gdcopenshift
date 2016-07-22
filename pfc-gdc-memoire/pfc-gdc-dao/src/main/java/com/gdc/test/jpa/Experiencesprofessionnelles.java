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
@Table(name = "experiencesprofessionnelles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencesprofessionnelles.findAll", query = "SELECT e FROM Experiencesprofessionnelles e"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByIdTypeDeProfil", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByDescription", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.description = :description"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByPeriode", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.periode = :periode"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByFonction", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.fonction = :fonction"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByEnvironnement", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.environnement = :environnement"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByProjet", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.projet = :projet"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByMissionsRealisees", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.missionsRealisees = :missionsRealisees")})
public class Experiencesprofessionnelles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private Integer idTypeDeProfil;
    @Column(name = "description")
    private String description;
    @Column(name = "periode")
    private String periode;
    @Column(name = "fonction")
    private String fonction;
    @Column(name = "environnement")
    private String environnement;
    @Column(name = "projet")
    private String projet;
    @Column(name = "missionsRealisees")
    private String missionsRealisees;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Profilgl profilgl;

    public Experiencesprofessionnelles() {
    }

    public Experiencesprofessionnelles(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Integer getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(String environnement) {
        this.environnement = environnement;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getMissionsRealisees() {
        return missionsRealisees;
    }

    public void setMissionsRealisees(String missionsRealisees) {
        this.missionsRealisees = missionsRealisees;
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
        if (!(object instanceof Experiencesprofessionnelles)) {
            return false;
        }
        Experiencesprofessionnelles other = (Experiencesprofessionnelles) object;
        if ((this.idTypeDeProfil == null && other.idTypeDeProfil != null) || (this.idTypeDeProfil != null && !this.idTypeDeProfil.equals(other.idTypeDeProfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Experiencesprofessionnelles[ idTypeDeProfil=" + idTypeDeProfil + " ]";
    }
    
}
