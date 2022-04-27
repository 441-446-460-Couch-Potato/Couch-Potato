/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import entity.ListItems;
import entity.ListItemsPK;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import session.RestaurantFacade;
import entity.Restaurant;
import entity.Menu;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;
import session.ListItemsFacade;
import session.MenuFacade;
import session.OrdersFacade;
import entity.Orders;
import session.CustomerFacade;

/**
 *
 * @author shree
 */
@WebServlet(name = "ControllerServlet", loadOnStartup = 1, urlPatterns = {"/menu", "/addToOrder", "/viewOrder", "/updateOrder","/customerLogin","/deliveryAgentLogin","/viewCustomerDetail","/changeProfile"})
public class ControllerServlet extends HttpServlet {
    
    @EJB
    private RestaurantFacade restaurantFacade;
    
    @EJB
    private MenuFacade menuFacade;
    
    @EJB
    private ListItemsFacade liFacade;
    
    @EJB
    private OrdersFacade ordersFacade;
    
    @EJB
    private CustomerFacade customerFacade;        
    
            
    String restId;
    String cur_order;
    String cust_id="1"; //Default
    
    int flag=0;
    
    Orders o;
    
    @Override
    public void init() throws ServletException {

        // store restaurant list in servlet context
        getServletContext().setAttribute("restaurants", restaurantFacade.findAll());
        Collection<Orders> orders = ordersFacade.findAll();
        int maxOrder=0;
        for(Orders or:orders){
            String orderID=or.getOrderId();
            if(orderID!=null){
                if (Integer.parseInt(orderID)>maxOrder){
                    maxOrder=Integer.parseInt(orderID);
                }
            }
        }
        maxOrder=maxOrder+1;
        cur_order=Integer.toString(maxOrder);
        getServletContext().setAttribute("cur_order", cur_order);
        
        Customer customer = customerFacade.find(cust_id);
        
        
        o = new Orders(cur_order, 0, 0);
        o.setCustId(customer);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();        
        // if category page is requested
        if(userPath.equals("/menu")) {
            
            restId = request.getQueryString();
            
            if (restId != null) {

                // get selected category
                Restaurant selectedRestaurant = restaurantFacade.find(restId);

                // place selected category in request scope
                request.setAttribute("selectedRestaurant", selectedRestaurant);

                // get all products for selected category
                Collection<Menu> items = selectedRestaurant.getMenuCollection();
                
                // place category products in request scope
                request.setAttribute("items", items);
                
                if (flag==0){
                o.setRestId(selectedRestaurant);
                ordersFacade.create(o);
                flag++;
                }
            }

        // if cart page is requested
        } else if (userPath.equals("/viewOrder")) {
            // TODO: Implement cart page request
            
            Orders current=ordersFacade.find(cur_order);
            Collection<ListItems> cur_items= new ArrayList<>();//current.getListItemsCollection();
            Collection<ListItems> all_items=liFacade.findAll();
            for(ListItems li:all_items){
            if(li.getListItemsPK().getOrderId().equals(cur_order)){
                    cur_items.add(li);
                    System.out.println("HERE");
                }
            }
            
            System.out.println(cur_items.size());
            
            request.setAttribute("orderItems", cur_items);
            request.setAttribute("order", current);
            userPath = "/order";
            
         //if login as delivery agent
        }else if (userPath.equals("/deliveryAgentLogin")) {
            // TODO: Implement view order for delivery Agent page
            Collection<Orders> existingOrders= new ArrayList<>();
            Collection<Orders> order=ordersFacade.findAll();
            for(Orders or:order){
                existingOrders.add(or);
            }
             //System.out.println(existingOrders);
             request.setAttribute("order", existingOrders);
            userPath = "/allOrders";
            
           // if login as customer
        }else if (userPath.equals("/customerLogin")) {
            // TODO: Implement view order for customer
            userPath = "/mainMenu";
        }
            

        // if checkout page is requested
        

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";
        if (userPath.equals("/changeProfile")) {
            // TODO: Implement view order for customer
             url = "/index.jsp";
        }
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if addToCart action is called
        if (userPath.equals("/addToOrder")) {
            // TODO: Implement add item to order action
            //String body = request.getParameter("itemId");
            String itemID = request.getParameter("itemId");
            int itemID_int=Integer.parseInt(itemID);
            System.out.println(itemID_int);
            if(itemID!=null)
            {
                //ListItems li = new ListItems();
                Menu menuItem = menuFacade.find(itemID);
                ListItems li = new ListItems(cur_order, itemID);
                li.setItem(menuItem.getItem());
                li.setPrice(menuItem.getPrice());
                li.setQuantity(1);
                liFacade.create(li);
                o.setNumItems(o.getNumItems()+1);
                o.setTotal(o.getTotal()+li.getPrice());
                ordersFacade.edit(o);
                userPath="/menu";
            }       
        }else if(userPath.equals("/viewCustomerDetail")){
            String custID = request.getParameter("custId");
            //int custID_int=Integer.parseInt(custID);
            if(custID!=null){
             Customer c = customerFacade.find(custID);
             request.setAttribute("customer",c);
             System.out.println(c);
             
            }
            userPath="/customerDetails";
        }

        // use RequestDispatcher to forward request internally
        

        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
