/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.test.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "cherchercandidat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cherchercandidat.findAll", query = "SELECT c FROM Cherchercandidat c"),
    @NamedQuery(name = "Cherchercandidat.findByRecusername", query = "SELECT c FROM Cherchercandidat c WHERE c.cherchercandidatPK.recusername = :recusername"),
    @NamedQuery(name = "Cherchercandidat.findByUsername", query = "SELECT c FROM Cherchercandidat c WHERE c.cherchercandidatPK.username = :username")})
public class Cherchercandidat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CherchercandidatPK cherchercandidatPK;
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Candidat candidat;

    public Cherchercandidat() {
    }

    public Cherchercandidat(CherchercandidatPK cherchercandidatPK) {
        this.cherchercandidatPK = cherchercandidatPK;
    }

    public Cherchercandidat(String recusername, String username) {
        this.cherchercandidatPK = new CherchercandidatPK(recusername, username);
    }

    public CherchercandidatPK getCherchercandidatPK() {
        return cherchercandidatPK;
    }

    public void setCherchercandidatPK(CherchercandidatPK cherchercandidatPK) {
        this.cherchercandidatPK = cherchercandidatPK;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cherchercandidatPK != null ? cherchercandidatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cherchercandidat)) {
            return false;
        }
        Cherchercandidat other = (Cherchercandidat) object;
        if ((this.cherchercandidatPK == null && other.cherchercandidatPK != null) || (this.cherchercandidatPK != null && !this.cherchercandidatPK.equals(other.cherchercandidatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Cherchercandidat[ cherchercandidatPK=" + cherchercandidatPK + " ]";
    }
    
}
