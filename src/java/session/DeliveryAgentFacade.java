/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import entity.DeliveryAgent;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author shree
 */
@Stateless
public class DeliveryAgentFacade extends AbstractFacade<DeliveryAgent> {

    @PersistenceContext(unitName = "CouchPotatoPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public DeliveryAgentFacade() {
        super(DeliveryAgent.class);
    }
    
}
