<%-- 
    Document   : login
    Created on : 27-Apr-2022, 9:40:01 am
    Author     : Sejal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Select your profile</h2>
        <h3>Login as:</h3>
        <form action="deliveryAgentLogin">
                            <input type='submit' value="Delivery Agent"/>
        </form>
        <h1></h1>
        <form action="customerLogin">
                            <input type='submit' value="Customer"/>
        </form>
        
        </form>
        
        <h1></h1>
        <form action="restManagerLogin">
                            <input type='submit' value="Restaurant Manager"/>
        </form>
    </body>
</html>
