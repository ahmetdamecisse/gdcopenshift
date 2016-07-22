/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.test.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author a618092
 */
@Embeddable
public class ContactercandidatPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Rec_username")
    private String recusername;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    public ContactercandidatPK() {
    }

    public ContactercandidatPK(String recusername, String username) {
        this.recusername = recusername;
        this.username = username;
    }

    public String getRecusername() {
        return recusername;
    }

    public void setRecusername(String recusername) {
        this.recusername = recusername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recusername != null ? recusername.hashCode() : 0);
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactercandidatPK)) {
            return false;
        }
        ContactercandidatPK other = (ContactercandidatPK) object;
        if ((this.recusername == null && other.recusername != null) || (this.recusername != null && !this.recusername.equals(other.recusername))) {
            return false;
        }
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.ContactercandidatPK[ recusername=" + recusername + ", username=" + username + " ]";
    }
    
}
