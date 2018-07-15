<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        ${message}
        <div class="bigLeft">
             <c:choose>
                <c:when test = "${sessionuser != null}">
                    <h1>Wellcome <a href="UserInfo?username=${sessionuser}">${sessionuser}</a> <a href="LogoutController">Logout</a></h1>
                </c:when>
                <c:otherwise>
                    <h1>You are not login <a href="LoginController">Login or Sign up</a></h1>
                </c:otherwise>
            </c:choose>
        </div>
        <c:if test = "${sessionuser != null}">
        <div class="bigRight">
            <br>
            <jsp:include page="AllRequestFriendSent"/>
            
        </div>
        </c:if>
    </body>
</html>
