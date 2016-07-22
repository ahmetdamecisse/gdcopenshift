/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.test.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "suivreentrtien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suivreentrtien.findAll", query = "SELECT s FROM Suivreentrtien s"),
    @NamedQuery(name = "Suivreentrtien.findByUsername", query = "SELECT s FROM Suivreentrtien s WHERE s.suivreentrtienPK.username = :username"),
    @NamedQuery(name = "Suivreentrtien.findByIdEntretien", query = "SELECT s FROM Suivreentrtien s WHERE s.suivreentrtienPK.idEntretien = :idEntretien")})
public class Suivreentrtien implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SuivreentrtienPK suivreentrtienPK;

    public Suivreentrtien() {
    }

    public Suivreentrtien(SuivreentrtienPK suivreentrtienPK) {
        this.suivreentrtienPK = suivreentrtienPK;
    }

    public Suivreentrtien(String username, int idEntretien) {
        this.suivreentrtienPK = new SuivreentrtienPK(username, idEntretien);
    }

    public SuivreentrtienPK getSuivreentrtienPK() {
        return suivreentrtienPK;
    }

    public void setSuivreentrtienPK(SuivreentrtienPK suivreentrtienPK) {
        this.suivreentrtienPK = suivreentrtienPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suivreentrtienPK != null ? suivreentrtienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suivreentrtien)) {
            return false;
        }
        Suivreentrtien other = (Suivreentrtien) object;
        if ((this.suivreentrtienPK == null && other.suivreentrtienPK != null) || (this.suivreentrtienPK != null && !this.suivreentrtienPK.equals(other.suivreentrtienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Suivreentrtien[ suivreentrtienPK=" + suivreentrtienPK + " ]";
    }
    
}
