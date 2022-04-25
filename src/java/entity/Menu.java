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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByItemId", query = "SELECT m FROM Menu m WHERE m.itemId = :itemId"),
    @NamedQuery(name = "Menu.findByItem", query = "SELECT m FROM Menu m WHERE m.item = :item"),
    @NamedQuery(name = "Menu.findByMealType", query = "SELECT m FROM Menu m WHERE m.mealType = :mealType"),
    @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "item_id")
    private String itemId;
    @Basic(optional = false)
    @Column(name = "item")
    private String item;
    @Column(name = "meal_type")
    private String mealType;
    @Basic(optional = false)
    @Column(name = "price")
    private long price;
    @JoinColumn(name = "rest_id", referencedColumnName = "rest_id")
    @ManyToOne(optional = false)
    private Restaurant restId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private Collection<ListItems> listItemsCollection;

    /**
     *
     */
    public Menu() {
    }

    /**
     *
     * @param itemId
     */
    public Menu(String itemId) {
        this.itemId = itemId;
    }

    /**
     *
     * @param itemId
     * @param item
     * @param price
     */
    public Menu(String itemId, String item, long price) {
        this.itemId = itemId;
        this.item = item;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getItemId() {
        return itemId;
    }

    /**
     *
     * @param itemId
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     *
     * @return
     */
    public String getItem() {
        return item;
    }

    /**
     *
     * @param item
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     *
     * @return
     */
    public String getMealType() {
        return mealType;
    }

    /**
     *
     * @param mealType
     */
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    /**
     *
     * @return
     */
    public long getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(long price) {
        this.price = price;
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
        hash += (itemId != null ? itemId.hashCode() : 0);
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
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
        return "entity.Menu[ itemId=" + itemId + " ]";
    }
    
}
