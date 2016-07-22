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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "listereponse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listereponse.findAll", query = "SELECT l FROM Listereponse l"),
    @NamedQuery(name = "Listereponse.findByIdReponse", query = "SELECT l FROM Listereponse l WHERE l.idReponse = :idReponse"),
    @NamedQuery(name = "Listereponse.findByReponse", query = "SELECT l FROM Listereponse l WHERE l.reponse = :reponse")})
public class Listereponse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReponse")
    private Integer idReponse;
    @Column(name = "reponse")
    private String reponse;
    @ManyToMany(mappedBy = "listereponseList")
    private List<Listequestion> listequestionList;

    public Listereponse() {
    }

    public Listereponse(Integer idReponse) {
        this.idReponse = idReponse;
    }

    public Integer getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Integer idReponse) {
        this.idReponse = idReponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @XmlTransient
    public List<Listequestion> getListequestionList() {
        return listequestionList;
    }

    public void setListequestionList(List<Listequestion> listequestionList) {
        this.listequestionList = listequestionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReponse != null ? idReponse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listereponse)) {
            return false;
        }
        Listereponse other = (Listereponse) object;
        if ((this.idReponse == null && other.idReponse != null) || (this.idReponse != null && !this.idReponse.equals(other.idReponse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Listereponse[ idReponse=" + idReponse + " ]";
    }
    
}
