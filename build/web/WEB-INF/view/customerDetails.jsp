<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : order
    Created on : 18-Apr-2022, 2:37:37 PM
    Author     : shree
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <title>Customer Details Page</title>
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
             
                <h2>Please follow these details to reach the customer!!</h2>
                <table id="cartTable">

                    <tr class="header">
                        <th>Customer Name</th>
                        <th>Customer Phone</th>
                        <th>Customer Address</th>
                    </tr>

                   
                    
                    <tr>
                        <td>
                           
                            ${customer.getName()}
                        </td>
                        <td>
                            ${customer.getPhoneNum()}
                        </td>
                        <td>
                           ${customer.getCustAddr().getAddress()}
                        </td>
                        
                    </tr>

                </table>

            </div>

        