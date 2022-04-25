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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shree
 */
@Entity
@Table(name = "cust_addr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustAddr.findAll", query = "SELECT c FROM CustAddr c"),
    @NamedQuery(name = "CustAddr.findByCustId", query = "SELECT c FROM CustAddr c WHERE c.custId = :custId"),
    @NamedQuery(name = "CustAddr.findByAddress", query = "SELECT c FROM CustAddr c WHERE c.address = :address")})
public class CustAddr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cust_id")
    private String custId;
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;

    /**
     *
     */
    public CustAddr() {
    }

    /**
     *
     * @param custId
     */
    public CustAddr(String custId) {
        this.custId = custId;
    }

    /**
     *
     * @return
     */
    public String getCustId() {
        return custId;
    }

    /**
     *
     * @param custId
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
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
        if (!(object instanceof CustAddr)) {
            return false;
        }
        CustAddr other = (CustAddr) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
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
        return "entity.CustAddr[ custId=" + custId + " ]";
    }
    
}
