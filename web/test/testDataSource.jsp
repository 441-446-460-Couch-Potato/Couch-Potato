<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : testDataSource
    Created on : 19 Apr, 2022, 12:32:30 PM
    Author     : shree
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <sql:query var="result" dataSource="jdbc/couchpotato">
        SELECT * from customer;
    </sql:query>
    
    <table border="1">
        <!-- column headers -->
        <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
        <c:forEach var="column" items="${row}">
            <td><c:out value="${column}"/></td>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
    </body>
</html>
