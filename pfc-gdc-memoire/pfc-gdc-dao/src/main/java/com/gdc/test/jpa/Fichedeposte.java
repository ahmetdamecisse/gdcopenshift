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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "fichedeposte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichedeposte.findAll", query = "SELECT f FROM Fichedeposte f"),
    @NamedQuery(name = "Fichedeposte.findByIdFichePoste", query = "SELECT f FROM Fichedeposte f WHERE f.idFichePoste = :idFichePoste"),
    @NamedQuery(name = "Fichedeposte.findByIntitulePoste", query = "SELECT f FROM Fichedeposte f WHERE f.intitulePoste = :intitulePoste"),
    @NamedQuery(name = "Fichedeposte.findByDescription", query = "SELECT f FROM Fichedeposte f WHERE f.description = :description"),
    @NamedQuery(name = "Fichedeposte.findByQualiteRequise", query = "SELECT f FROM Fichedeposte f WHERE f.qualiteRequise = :qualiteRequise"),
    @NamedQuery(name = "Fichedeposte.findByConnaissanceTechni", query = "SELECT f FROM Fichedeposte f WHERE f.connaissanceTechni = :connaissanceTechni"),
    @NamedQuery(name = "Fichedeposte.findByVersion", query = "SELECT f FROM Fichedeposte f WHERE f.version = :version")})
public class Fichedeposte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFichePoste")
    private Integer idFichePoste;
    @Column(name = "intitulePoste")
    private String intitulePoste;
    @Column(name = "description")
    private String description;
    @Column(name = "qualiteRequise")
    private String qualiteRequise;
    @Column(name = "connaissanceTechni")
    private String connaissanceTechni;
    @Column(name = "version")
    @Version
    private Integer version;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Recruteur username;

    public Fichedeposte() {
    }

    public Fichedeposte(Integer idFichePoste) {
        this.idFichePoste = idFichePoste;
    }

    public Integer getIdFichePoste() {
        return idFichePoste;
    }

    public void setIdFichePoste(Integer idFichePoste) {
        this.idFichePoste = idFichePoste;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualiteRequise() {
        return qualiteRequise;
    }

    public void setQualiteRequise(String qualiteRequise) {
        this.qualiteRequise = qualiteRequise;
    }

    public String getConnaissanceTechni() {
        return connaissanceTechni;
    }

    public void setConnaissanceTechni(String connaissanceTechni) {
        this.connaissanceTechni = connaissanceTechni;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Recruteur getUsername() {
        return username;
    }

    public void setUsername(Recruteur username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFichePoste != null ? idFichePoste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichedeposte)) {
            return false;
        }
        Fichedeposte other = (Fichedeposte) object;
        if ((this.idFichePoste == null && other.idFichePoste != null) || (this.idFichePoste != null && !this.idFichePoste.equals(other.idFichePoste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Fichedeposte[ idFichePoste=" + idFichePoste + " ]";
    }
    
}
