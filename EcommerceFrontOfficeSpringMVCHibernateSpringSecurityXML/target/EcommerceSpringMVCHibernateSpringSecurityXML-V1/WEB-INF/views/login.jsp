<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@page session="true"%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
 <body>
<div class="cadre">
<form action="j_spring_security_check" method="post">
<table>
<tr>
<td>Login</td> <td><input type="text" name="j_username"></td>
</tr>
<tr>
<td>Pass word</td> <td><input type="password" name="j_password"></td>
</tr>
<tr> <td><input type="submit" value="Login"></td> </tr>
</table>
</form>
</div>
</body>
</html>