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
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shree
 */
@Entity
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findByRestId", query = "SELECT r FROM Restaurant r WHERE r.restId = :restId"),
    @NamedQuery(name = "Restaurant.findByName", query = "SELECT r FROM Restaurant r WHERE r.name = :name"),
    @NamedQuery(name = "Restaurant.findByRating", query = "SELECT r FROM Restaurant r WHERE r.rating = :rating"),
    @NamedQuery(name = "Restaurant.findByAddress", query = "SELECT r FROM Restaurant r WHERE r.address = :address")})
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rest_id")
    private String restId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Integer rating;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restId")
    private Collection<Orders> ordersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restId")
    private Collection<Menu> menuCollection;

    /**
     *
     */
    public Restaurant() {
    }

    /**
     *
     * @param restId
     */
    public Restaurant(String restId) {
        this.restId = restId;
    }

    /**
     *
     * @param restId
     * @param name
     * @param address
     */
    public Restaurant(String restId, String name, String address) {
        this.restId = restId;
        this.name = name;
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getRestId() {
        return restId;
    }

    /**
     *
     * @param restId
     */
    public void setRestId(String restId) {
        this.restId = restId;
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
    public Integer getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
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
    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    /**
     *
     * @param menuCollection
     */
    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restId != null ? restId.hashCode() : 0);
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
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.restId == null && other.restId != null) || (this.restId != null && !this.restId.equals(other.restId))) {
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
        return "entity.Restaurant[ restId=" + restId + " ]";
    }
    
}
