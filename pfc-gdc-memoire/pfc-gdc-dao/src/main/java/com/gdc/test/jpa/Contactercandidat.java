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
@Table(name = "contactercandidat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactercandidat.findAll", query = "SELECT c FROM Contactercandidat c"),
    @NamedQuery(name = "Contactercandidat.findByRecusername", query = "SELECT c FROM Contactercandidat c WHERE c.contactercandidatPK.recusername = :recusername"),
    @NamedQuery(name = "Contactercandidat.findByUsername", query = "SELECT c FROM Contactercandidat c WHERE c.contactercandidatPK.username = :username")})
public class Contactercandidat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContactercandidatPK contactercandidatPK;

    public Contactercandidat() {
    }

    public Contactercandidat(ContactercandidatPK contactercandidatPK) {
        this.contactercandidatPK = contactercandidatPK;
    }

    public Contactercandidat(String recusername, String username) {
        this.contactercandidatPK = new ContactercandidatPK(recusername, username);
    }

    public ContactercandidatPK getContactercandidatPK() {
        return contactercandidatPK;
    }

    public void setContactercandidatPK(ContactercandidatPK contactercandidatPK) {
        this.contactercandidatPK = contactercandidatPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactercandidatPK != null ? contactercandidatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactercandidat)) {
            return false;
        }
        Contactercandidat other = (Contactercandidat) object;
        if ((this.contactercandidatPK == null && other.contactercandidatPK != null) || (this.contactercandidatPK != null && !this.contactercandidatPK.equals(other.contactercandidatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Contactercandidat[ contactercandidatPK=" + contactercandidatPK + " ]";
    }
    
}
