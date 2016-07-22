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
public class FaireuntestPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "idFicheTest")
    private int idFicheTest;

    public FaireuntestPK() {
    }

    public FaireuntestPK(String username, int idFicheTest) {
        this.username = username;
        this.idFicheTest = idFicheTest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdFicheTest() {
        return idFicheTest;
    }

    public void setIdFicheTest(int idFicheTest) {
        this.idFicheTest = idFicheTest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (int) idFicheTest;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaireuntestPK)) {
            return false;
        }
        FaireuntestPK other = (FaireuntestPK) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        if (this.idFicheTest != other.idFicheTest) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.FaireuntestPK[ username=" + username + ", idFicheTest=" + idFicheTest + " ]";
    }
    
}
