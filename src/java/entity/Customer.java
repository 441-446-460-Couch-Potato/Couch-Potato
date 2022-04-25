/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shree
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustId", query = "SELECT c FROM Customer c WHERE c.custId = :custId"),
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
    @NamedQuery(name = "Customer.findByPhoneNum", query = "SELECT c FROM Customer c WHERE c.phoneNum = :phoneNum"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cust_id")
    private String custId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "phone_num")
    private String phoneNum;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private CustAddr custAddr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custId")
    private Collection<Orders> ordersCollection;

    /**
     *
     */
    public Customer() {
    }

    /**
     *
     * @param custId
     */
    public Customer(String custId) {
        this.custId = custId;
    }

    /**
     *
     * @param custId
     * @param name
     */
    public Customer(String custId, String name) {
        this.custId = custId;
        this.name = name;
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
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     *
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public CustAddr getCustAddr() {
        return custAddr;
    }

    /**
     *
     * @param custAddr
     */
    public void setCustAddr(CustAddr custAddr) {
        this.custAddr = custAddr;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    /**
     *
     * @param ordersCollection
     */
    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
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
        return "entity.Customer[ custId=" + custId + " ]";
    }
    
}
