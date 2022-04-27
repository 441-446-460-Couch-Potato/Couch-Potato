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
                        <form action="changeProfile">
                            <input type='submit' value="Log out"/>
                        </form>
                    </div>

    </div>


    <div>
        <h2>The total number of orders placed from your restaurant today are: </h2>
        <h1>${count}</h1>
    </div>
</body>
</html>
