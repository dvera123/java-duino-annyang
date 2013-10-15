/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectx.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vera
 */
@Entity
@Table(name = "step_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StepStatus.findAll", query = "SELECT s FROM StepStatus s"),
    @NamedQuery(name = "StepStatus.findById", query = "SELECT s FROM StepStatus s WHERE s.id = :id"),
    @NamedQuery(name = "StepStatus.findByName", query = "SELECT s FROM StepStatus s WHERE s.name = :name")})
public class StepStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public StepStatus() {
    }

    public StepStatus(Integer id) {
        this.id = id;
    }

    public StepStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StepStatus)) {
            return false;
        }
        StepStatus other = (StepStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projectx.domain.StepStatus[ id=" + id + " ]";
    }
    
}
