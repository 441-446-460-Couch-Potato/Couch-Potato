<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : order
    Created on : 18-Apr-2022, 2:37:37 PM
    Author     : shree
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <title>Menu Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/couchpotato.css">
        <title>Couch Potato</title>
    </head>
    
    
<div id="centerColumn">

                <p>Your order contains ${order.getNumItems()} items.</p>

             

                <h4 id="subtotal">Total: ${order.getTotal()}</h4>

                <table id="cartTable">

                    <tr class="header">
                        <th>product</th>
                        <th>name</th>
                        <th>price</th>
                    </tr>

                   
                    <c:forEach var="item" items="${orderItems}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                        <td>
                            <img src="${initParam.productImagePath}${item.getItem()}.png" alt="${item.getItem()}">        
                        </td>
                        <td>
                            ${item.getItem()}
                            <br>
                        </td>
                        <td>
                            Rs. ${item.getPrice()} / unit
                        </td>
                    </tr>
                </c:forEach>

                </table>

            </div>

        