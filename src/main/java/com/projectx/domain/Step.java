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
@Table(name = "step")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Step.findAll", query = "SELECT s FROM Step s"),
    @NamedQuery(name = "Step.findById", query = "SELECT s FROM Step s WHERE s.id = :id"),
    @NamedQuery(name = "Step.findByNum", query = "SELECT s FROM Step s WHERE s.num = :num"),
    @NamedQuery(name = "Step.findByDescription", query = "SELECT s FROM Step s WHERE s.description = :description"),
    @NamedQuery(name = "Step.findByAction", query = "SELECT s FROM Step s WHERE s.action = :action")})
public class Step implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "action")
    private String action;
    @JoinColumn(name = "fk_step_status", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private StepStatus fkStepStatus;

    public Step() {
    }

    public Step(Integer id) {
        this.id = id;
    }

    public Step(Integer id, int num, String description, String action) {
        this.id = id;
        this.num = num;
        this.description = description;
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public StepStatus getFkStepStatus() {
        return fkStepStatus;
    }

    public void setFkStepStatus(StepStatus fkStepStatus) {
        this.fkStepStatus = fkStepStatus;
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
        if (!(object instanceof Step)) {
            return false;
        }
        Step other = (Step) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projectx.domain.Step[ id=" + id + " ]";
    }
    
}
