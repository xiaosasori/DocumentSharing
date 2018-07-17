<%-- 
    Document   : post
    Created on : Jul 17, 2018, 3:16:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FileUploadController" method="post" enctype="multipart/form-data">
             <label for="fileName"><b>Select File to Upload:</b></label>
            <input type="file" name="fileName">
            <br><br>
            <input type="submit" value="Upload">
        </form>
        <p>${message}</p>
    </body>
</html>
