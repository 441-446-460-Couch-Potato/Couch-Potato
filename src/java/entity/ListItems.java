/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shree
 */
@Entity
@Table(name = "list_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListItems.findAll", query = "SELECT l FROM ListItems l"),
    @NamedQuery(name = "ListItems.findByOrderId", query = "SELECT l FROM ListItems l WHERE l.listItemsPK.orderId = :orderId"),
    @NamedQuery(name = "ListItems.findByItemId", query = "SELECT l FROM ListItems l WHERE l.listItemsPK.itemId = :itemId"),
    @NamedQuery(name = "ListItems.findByItem", query = "SELECT l FROM ListItems l WHERE l.item = :item"),
    @NamedQuery(name = "ListItems.findByPrice", query = "SELECT l FROM ListItems l WHERE l.price = :price"),
    @NamedQuery(name = "ListItems.findByQuantity", query = "SELECT l FROM ListItems l WHERE l.quantity = :quantity")})
public class ListItems implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected ListItemsPK listItemsPK;
    @Basic(optional = false)
    @Column(name = "item")
    private String item;
    @Basic(optional = false)
    @Column(name = "price")
    private long price;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;

    /**
     *
     */
    public ListItems() {
    }

    /**
     *
     * @param listItemsPK
     */
    public ListItems(ListItemsPK listItemsPK) {
        this.listItemsPK = listItemsPK;
    }

    /**
     *
     * @param listItemsPK
     * @param item
     * @param price
     * @param quantity
     */
    public ListItems(ListItemsPK listItemsPK, String item, long price, int quantity) {
        this.listItemsPK = listItemsPK;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     *
     * @param orderId
     * @param itemId
     */
    public ListItems(String orderId, String itemId) {
        this.listItemsPK = new ListItemsPK(orderId, itemId);
    }

    /**
     *
     * @return
     */
    public ListItemsPK getListItemsPK() {
        return listItemsPK;
    }

    /**
     *
     * @param listItemsPK
     */
    public void setListItemsPK(ListItemsPK listItemsPK) {
        this.listItemsPK = listItemsPK;
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
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     *
     * @param menu
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     *
     * @return
     */
    public Orders getOrders() {
        return orders;
    }

    /**
     *
     * @param orders
     */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listItemsPK != null ? listItemsPK.hashCode() : 0);
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
        if (!(object instanceof ListItems)) {
            return false;
        }
        ListItems other = (ListItems) object;
        if ((this.listItemsPK == null && other.listItemsPK != null) || (this.listItemsPK != null && !this.listItemsPK.equals(other.listItemsPK))) {
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
        return "entity.ListItems[ listItemsPK=" + listItemsPK + " ]";
    }
    
}
