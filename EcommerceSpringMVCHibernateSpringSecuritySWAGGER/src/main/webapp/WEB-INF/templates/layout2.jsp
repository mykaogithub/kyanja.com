<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
href="<%=request.getContextPath()%>/resources/layout2/css/template.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery/jquery-
1.8.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/eboutique.js"></script>
</head>
<body>

<table border="1" style="border-collapse: collapse;" cellpadding="1" cellspacing="1" align="center" width="1400">    <tbody><tr>
        <td height="5" colspan="2"><tiles:insertAttribute name="header" /></td>
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