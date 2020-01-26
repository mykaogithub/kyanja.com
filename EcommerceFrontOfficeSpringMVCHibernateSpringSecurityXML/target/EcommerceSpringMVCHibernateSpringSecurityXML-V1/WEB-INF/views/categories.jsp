<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" >
<%--     <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script> --%>
<%--     <script src="<c:url value="/resources/js/main.js" />"></script> --%>
</head>
<%-- <c:url value="/j_spring_security_logout" var="logoutUrl" /> --%>
<%-- <a href="${logoutUrl}">Log Out</a> --%>
<a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
<a href="<c:url value="/login" />" > Login</a>
<a href="<c:url value="/adminProd/index" />"> Produits</a>
<a href="<c:url value="/" />"> Home</a>
<div id="formCat" class="cadre">
<f:form modelAttribute="categorie" action="saveCat" method="post"
enctype="multipart/form-data">
<table>
<tr>
<td>ID Catégorie:</td>
<td>${categorie.idCategorie}<f:input type="hidden" path="idCategorie"/></td>
<td><f:errors path="idCategorie"></f:errors> </td>
</tr>
<tr>
<td>Nom Catégorie</td><td><f:input path="nomCategorie"/></td>
<td><f:errors path="nomCategorie"></f:errors> </td>
</tr>
<tr>
<td>Description</td>
<td><f:textarea path="description"/></td>
<td><f:errors path="description"></f:errors> </td>
</tr>
<tr>
<td>Photo</td>
<c:if test="${categorie.idCategorie!=null}">
<td><img src="photoCat?idCat=${categorie.idCategorie}"></td>
</c:if>
<td>
<input type="file" name="file"></td>
</tr>
<tr>
<td><input type="submit" value="Save"></td>
</tr>
</table>
</f:form>
</div>
<div id="tabCategories" class="cadre">
<table class="tabStyle1">
<tr>
<th>ID</th><th>NOM CAT</th><th>DESCRIPTION</th><th>PHOTO</th>
<th></th><th></th>
</tr>
<c:forEach items="${categories}" var="cat">
<tr>
<td>${cat.idCategorie}</td>
<td>${cat.nomCategorie}</td>
<td>${cat.description}</td>
<td><img src="photoCat?idCat=${cat.idCategorie}"></td>
<td><a href="suppCat?idCat=${cat.idCategorie}">Supprimer</a></td>
<td><a href="editCat?idCat=${cat.idCategorie}">Edit</a></td>
</tr>
</c:forEach>
</table>
</div>
