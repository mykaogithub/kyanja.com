<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
href="<%=request.getContextPath()%>/resources/layout1/css/template.css"/>
</head>
<body>

<table border="1" style="border-collapse: collapse;" cellpadding="2" cellspacing="2" align="center" width="800">    <tbody><tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header" /></td>
    </tr>
    <tr>
        <td width="150" height="450" valign="top">

         <tiles:insertAttribute name="menu" />

        </td>
        <td valign="top" width="650">

         <tiles:insertAttribute name="body" />

        </td>
    </tr>
    <tr>
        <td height="30" colspan="2">

         <tiles:insertAttribute name="footer" />

        </td>
    </tr>
</tbody></table></body>
</html>