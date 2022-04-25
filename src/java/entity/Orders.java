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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shree
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Orders.findByNumItems", query = "SELECT o FROM Orders o WHERE o.numItems = :numItems"),
    @NamedQuery(name = "Orders.findByTotal", query = "SELECT o FROM Orders o WHERE o.total = :total")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "order_id")
    private String orderId;
    @Basic(optional = false)
    @Column(name = "num_items")
    private int numItems;
    @Basic(optional = false)
    @Column(name = "total")
    private long total;
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    @ManyToOne(optional = false)
    private Customer custId;
    @JoinColumn(name = "rest_id", referencedColumnName = "rest_id")
    @ManyToOne(optional = false)
    private Restaurant restId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private Collection<ListItems> listItemsCollection;

    /**
     *
     */
    public Orders() {
    }

    /**
     *
     * @param orderId
     */
    public Orders(String orderId) {
        this.orderId = orderId;
    }

    /**
     *
     * @param orderId
     * @param numItems
     * @param total
     */
    public Orders(String orderId, int numItems, long total) {
        this.orderId = orderId;
        this.numItems = numItems;
        this.total = total;
    }

    /**
     *
     * @return
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     *
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     *
     * @return
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     *
     * @param numItems
     */
    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    /**
     *
     * @return
     */
    public long getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public Customer getCustId() {
        return custId;
    }

    /**
     *
     * @param custId
     */
    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    /**
     *
     * @return
     */
    public Restaurant getRestId() {
        return restId;
    }

    /**
     *
     * @param restId
     */
    public void setRestId(Restaurant restId) {
        this.restId = restId;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<ListItems> getListItemsCollection() {
        return listItemsCollection;
    }

    /**
     *
     * @param listItemsCollection
     */
    public void setListItemsCollection(Collection<ListItems> listItemsCollection) {
        this.listItemsCollection = listItemsCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
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
        return "entity.Orders[ orderId=" + orderId + " ]";
    }
    
}
