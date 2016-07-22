/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.test.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "fichedetest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichedetest.findAll", query = "SELECT f FROM Fichedetest f"),
    @NamedQuery(name = "Fichedetest.findByIdFicheTest", query = "SELECT f FROM Fichedetest f WHERE f.idFicheTest = :idFicheTest"),
    @NamedQuery(name = "Fichedetest.findByVersion", query = "SELECT f FROM Fichedetest f WHERE f.version = :version")})
public class Fichedetest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFicheTest")
    private Integer idFicheTest;
    @Column(name = "version")
    @Version
    private Integer version;
    @JoinTable(name = "avoirquestion", joinColumns = {
        @JoinColumn(name = "idFicheTest", referencedColumnName = "idFicheTest")}, inverseJoinColumns = {
        @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")})
    @ManyToMany
    private List<Listequestion> listequestionList;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Recruteur username;

    public Fichedetest() {
    }

    public Fichedetest(Integer idFicheTest) {
        this.idFicheTest = idFicheTest;
    }

    public Integer getIdFicheTest() {
        return idFicheTest;
    }

    public void setIdFicheTest(Integer idFicheTest) {
        this.idFicheTest = idFicheTest;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @XmlTransient
    public List<Listequestion> getListequestionList() {
        return listequestionList;
    }

    public void setListequestionList(List<Listequestion> listequestionList) {
        this.listequestionList = listequestionList;
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
        hash += (idFicheTest != null ? idFicheTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichedetest)) {
            return false;
        }
        Fichedetest other = (Fichedetest) object;
        if ((this.idFicheTest == null && other.idFicheTest != null) || (this.idFicheTest != null && !this.idFicheTest.equals(other.idFicheTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Fichedetest[ idFicheTest=" + idFicheTest + " ]";
    }
    
}
