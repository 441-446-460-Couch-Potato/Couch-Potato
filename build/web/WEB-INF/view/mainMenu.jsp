<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 22 Apr, 2022, 11:45:36 AM
    Author     : shree
--%>

<%--<sql:query var="restaurants" dataSource="jdbc/couchpotato">
    SELECT * from restaurant;
</sql:query>--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/couchpotato.css">
    <title>Couch Potato</title>
    </head>
    
    <body>
        
        <div id="main">



            <div id="indexLeftColumn">
                <div id="welcomeText">
                    <p style="font-size: larger">Welcome to the online home of Couch Potato.</p>

                    <p>Enjoy browsing and learning more about our unique home delivery
                        service bringing you awesome food to your doorstep.</p>
                </div>
            </div>


            <div id="indexRightColumn">
                <c:forEach var="restaurant" items="${restaurants}">
                    <div class="categoryBox">
                        <a href="menu?${restaurant.restId}">

                            <span class="categoryLabelText">${restaurant.name}</span>

                            <img src="${initParam.categoryImagePath}${restaurant.name}.jpg"
                                 alt="${restaurant.name}">
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>

        
    </body>
</html>
