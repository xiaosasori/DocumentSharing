<%-- 
    Document   : user
    Created on : Jul 14, 2018, 7:06:35 PM
    Author     : Hoang Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.userName}</title>
    </head>
    <body>
        <h2><a href="./">Home</a></h2>
        <h2>${err}</h2>
        <h3>Name: ${user.userName}</h3>
        <h3>Email: ${user.email}</h3>
        <h2>Post:</h2>
    </body>
</html>
