<%-- 
    Document   : lista
    Created on : Jun 12, 2012, 3:33:05 PM
    Author     : Leonn Ferreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="../../css/geral.css"/>
    </head>
    <body>
        <h1>Lista de dependentes:</h1>
        <table id="tblist" cellspacing='0' cellpaddind="2">
            <thead>
            <th>Ações</th>
            <th>ID</th>
            <th>Nome</th>
            <th>Idade</th>
            <th>Sexo</th>
            <th>ID Abrigada</th>
        </thead>
        <tbody>
            <c:forEach items="${dependenteList}" var="dependente">
                <tr>
                    <td>
                        <a href="<c:url value='/dependente/deleta/${dependente.idAbrigada}/${dependente.id}'/>">DELETA</a>
                        <br>
                        <a href="<c:url value='/dependente/edita/${dependente.id}'/>">EDITA</a>
                    </td>
                    <td>${dependente.id}</td>
                    <td>${dependente.nome}</td>
                    <td>${dependente.idade}</td>
                    <td>${dependente.sexo}</td>
                    <td>${dependente.idAbrigada}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
