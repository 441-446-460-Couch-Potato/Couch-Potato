/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shree
 */
@Entity
@Table(name = "delivery_agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryAgent.findAll", query = "SELECT d FROM DeliveryAgent d"),
    @NamedQuery(name = "DeliveryAgent.findByDaId", query = "SELECT d FROM DeliveryAgent d WHERE d.daId = :daId"),
    @NamedQuery(name = "DeliveryAgent.findByName", query = "SELECT d FROM DeliveryAgent d WHERE d.name = :name")})
public class DeliveryAgent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "da_id")
    private String daId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    /**
     *
     */
    public DeliveryAgent() {
    }

    /**
     *
     * @param daId
     */
    public DeliveryAgent(String daId) {
        this.daId = daId;
    }

    /**
     *
     * @param daId
     * @param name
     */
    public DeliveryAgent(String daId, String name) {
        this.daId = daId;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDaId() {
        return daId;
    }

    /**
     *
     * @param daId
     */
    public void setDaId(String daId) {
        this.daId = daId;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (daId != null ? daId.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryAgent)) {
            return false;
        }
        DeliveryAgent other = (DeliveryAgent) object;
        if ((this.daId == null && other.daId != null) || (this.daId != null && !this.daId.equals(other.daId))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "entity.DeliveryAgent[ daId=" + daId + " ]";
    }
    
}
