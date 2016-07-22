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
@Table(name = "consulternotification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulternotification.findAll", query = "SELECT c FROM Consulternotification c"),
    @NamedQuery(name = "Consulternotification.findByUsername", query = "SELECT c FROM Consulternotification c WHERE c.consulternotificationPK.username = :username"),
    @NamedQuery(name = "Consulternotification.findByIdNotification", query = "SELECT c FROM Consulternotification c WHERE c.consulternotificationPK.idNotification = :idNotification")})
public class Consulternotification implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsulternotificationPK consulternotificationPK;

    public Consulternotification() {
    }

    public Consulternotification(ConsulternotificationPK consulternotificationPK) {
        this.consulternotificationPK = consulternotificationPK;
    }

    public Consulternotification(String username, int idNotification) {
        this.consulternotificationPK = new ConsulternotificationPK(username, idNotification);
    }

    public ConsulternotificationPK getConsulternotificationPK() {
        return consulternotificationPK;
    }

    public void setConsulternotificationPK(ConsulternotificationPK consulternotificationPK) {
        this.consulternotificationPK = consulternotificationPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consulternotificationPK != null ? consulternotificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulternotification)) {
            return false;
        }
        Consulternotification other = (Consulternotification) object;
        if ((this.consulternotificationPK == null && other.consulternotificationPK != null) || (this.consulternotificationPK != null && !this.consulternotificationPK.equals(other.consulternotificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.test.jpa.Consulternotification[ consulternotificationPK=" + consulternotificationPK + " ]";
    }
    
}
