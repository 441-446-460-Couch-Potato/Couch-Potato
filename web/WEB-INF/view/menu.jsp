<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : menu
    Created on : 18-Apr-2022, 2:36:52 PM
    Author     : shree
--%>

<%--<sql:query var="restaurants" dataSource="jdbc/couchpotato">
    SELECT * FROM restaurant
</sql:query>

    
<sql:query var="selectedRestaurant" dataSource="jdbc/couchpotato">
    SELECT name FROM restaurant WHERE rest_id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>   

<sql:query var="items" dataSource="jdbc/couchpotato">
    SELECT * FROM menu WHERE rest_id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>--%>
            
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Menu Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/couchpotato.css">
        <title>Couch Potato</title>
    </head>
    
<body>
    <div id="widgetBar">

                    <div class="headerWidget">
                        <form action="viewOrder">
                            <input type='submit' value="View Order"/>
                        </form>
                    </div>
                    
                    <div class="headerWidget">
                        <form action="changeProfile">
                            <input type='submit' value="Log out"/>
                        </form>
                    </div>

    </div>

    <div id="categoryLeftColumn">
        <c:forEach var="restaurant" items="${restaurants}">

            <c:choose>
                <c:when test="${restaurant.restId == pageContext.request.queryString}"> 
                   <div class="categoryButton" id="selectedCategory">
                        <span class="categoryText">
                            ${restaurant.name}
                        </span>
                    </div>
                </c:when>
                <c:otherwise>
                    <a href="menu?${restaurant.restId}" class="categoryButton">
                        <div class="categoryText">
                            ${restaurant.name}
                        </div>
                    </a>
                </c:otherwise>
            </c:choose>

        </c:forEach>

    </div>

        <div id="categoryRightColumn">
            <p id="categoryTitle">
                <span style="background-color: #f5eabe; padding: 7px;">${selectedRestaurant.name}</span>
            </p>

            <table id="productTable">
                <c:forEach var="item" items="${items}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                        <td>
                            <img src="${initParam.productImagePath}${item.item}.png" alt="${item.item}">        
                        </td>
                        <td>
                            ${item.item}
                            <br>
                            <span class="smallText">${item.mealType}</span>
                        </td>
                        <td>
                            Rs. ${item.price} / unit
                        </td>
                        <td>
                            <form action="addToOrder" method="post">
                                <input type="hidden"
                                       name="itemId"
                                       id="itemID"
                                       value="${item.itemId}">
                                <input type="submit"
                                       value="add to order">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

</body>
</html>
