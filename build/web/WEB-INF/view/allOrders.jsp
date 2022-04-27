<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : order
    Created on : 18-Apr-2022, 2:37:37 PM
    Author     : shree
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <title>Orders Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/couchpotato.css">
        <title>Couch Potato</title>
    </head>
    <div id="widgetBar">

                    <div class="headerWidget">
                        <form action="changeProfile">
                            <input type='submit' value="Change Profile"/>
                        </form>
                    </div>

    </div>
    
<div id="centerColumn">
             
                <h2>The following orders are ready for delivery!!</h2>
                <table id="cartTable">

                    <tr class="header">
                        <th>Order ID</th>
                        <th>Restaurant ID</th>
                        <th>Restaurant Address</th>
                        <th></th>
                    </tr>

                   
                    <c:forEach var="order" items="${order}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                        <td>
                            ${order.getOrderId()}
                        </td>
                        <td>
                            ${order.getRestId().restId}
                        </td>
                        <td>
                            ${order.getRestId().getAddress()}
                        </td>
                        <td>
                           <form action="viewCustomerDetail" method="post">
                                <input type="hidden"
                                       name="custId"
                                       id="custID"
                                       value="${order.getCustId().custId}">
                                <input type="submit"
                                       value="Deliver this!">
                            </form>
                        </td>
                    </tr>
                </c:forEach>

                </table>

            </div>

        