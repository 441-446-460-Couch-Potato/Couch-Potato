/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author shree
 */
@Embeddable
public class ListItemsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "order_id")
    private String orderId;
    @Basic(optional = false)
    @Column(name = "item_id")
    private String itemId;

    /**
     *
     */
    public ListItemsPK() {
    }

    /**
     *
     * @param orderId
     * @param itemId
     */
    public ListItemsPK(String orderId, String itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
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
        if (!(object instanceof ListItemsPK)) {
            return false;
        }
        ListItemsPK other = (ListItemsPK) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
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
        return "entity.ListItemsPK[ orderId=" + orderId + ", itemId=" + itemId + " ]";
    }
    
}
