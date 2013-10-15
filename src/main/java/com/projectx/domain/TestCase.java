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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vera
 */
@Entity
@Table(name = "test_case")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestCase.findAll", query = "SELECT t FROM TestCase t ORDER BY name ASC"),
    @NamedQuery(name = "TestCase.findById", query = "SELECT t FROM TestCase t WHERE t.id = :id"),
    @NamedQuery(name = "TestCase.findByName", query = "SELECT t FROM TestCase t WHERE t.name = :name"),
    @NamedQuery(name = "TestCase.findByDescription", query = "SELECT t FROM TestCase t WHERE t.description = :description")})
public class TestCase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = true)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "fk_test_case_status", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TestCaseStatus fkTestCaseStatus;

    public TestCase() {
    }

    public TestCase(Integer id) {
        this.id = id;
    }

    public TestCase(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TestCaseStatus getFkTestCaseStatus() {
        return fkTestCaseStatus;
    }

    public void setFkTestCaseStatus(TestCaseStatus fkTestCaseStatus) {
        this.fkTestCaseStatus = fkTestCaseStatus;
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
        if (!(object instanceof TestCase)) {
            return false;
        }
        TestCase other = (TestCase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projectx.domain.TestCase[ id=" + id + " ]";
    }
    
}
