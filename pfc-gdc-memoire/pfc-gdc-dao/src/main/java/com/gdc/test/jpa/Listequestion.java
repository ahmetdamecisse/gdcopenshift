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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "listequestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listequestion.findAll", query = "SELECT l FROM Listequestion l"),
    @NamedQuery(name = "Listequestion.findByIdQuestion", query = "SELECT l FROM Listequestion l WHERE l.idQuestion = :idQuestion"),
    @NamedQuery(name = "Listequestion.findByQuestion", query = "SELECT l FROM Listequestion l WHERE l.question = :question")})
public class Listequestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQuestion")
    private Integer idQuestion;
    @Column(name = "question")
    private String question;
    @JoinTable(name = "avoirreponse", joinColumns = {
        @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")}, inverseJoinColumns = {
        @JoinColumn(name = "idReponse", referencedColumnName = "idReponse")})
    @ManyToMany
    private List<Listereponse> listereponseList;
    @ManyToMany(mappedBy = "listequestionList")
    private List<Fichedetest> fichedetestList;

    public Listequestion() {
    }

    public Listequestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @XmlTransient
    public List<Listereponse> getListereponseList() {
        return listereponseList;
    }

    public void setListereponseList(List<Listereponse> listereponseList) {
        this.listereponseList = listereponseList;
    }

    @XmlTransient
    public List<Fichedetest> getFichedetestList() {
        return fichedetestList;
    }

    public void setFichedetestList(List<Fichedetest> fichedetestList) {
        this.fichedetestList = fichedetestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestion != null ? idQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listequestion)) {
            return false;
        }
        Listequestion other = (Listequestion) object;
        if ((this.idQuestion == null && other.idQuestion != null) || (this.idQuestion != null && !this.idQuestion.equals(other.idQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Listequestion[ idQuestion=" + idQuestion + " ]";
    }
    
}
