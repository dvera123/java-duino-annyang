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
@Table(name = "test_case_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestCaseStatus.findAll", query = "SELECT t FROM TestCaseStatus t"),
    @NamedQuery(name = "TestCaseStatus.findById", query = "SELECT t FROM TestCaseStatus t WHERE t.id = :id"),
    @NamedQuery(name = "TestCaseStatus.findByName", query = "SELECT t FROM TestCaseStatus t WHERE t.name = :name")})
public class TestCaseStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public TestCaseStatus() {
    }

    public TestCaseStatus(Integer id) {
        this.id = id;
    }

    public TestCaseStatus(Integer id, String name) {
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
        if (!(object instanceof TestCaseStatus)) {
            return false;
        }
        TestCaseStatus other = (TestCaseStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projectx.domain.TestCaseStatus[ id=" + id + " ]";
    }
    
}
