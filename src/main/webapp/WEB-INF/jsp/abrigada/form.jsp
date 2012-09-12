<%-- 
    Document   : form
    Created on : Jun 10, 2012, 10:30:17 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="../css/geral.css"/>
    </head>
    <body>
        <c:if test="${errors != null}">
            <div id="erro">
                Erros:<br />
                <c:forEach var="error" items="${errors}">
                    ${error.category} ${error.message}<br />
                </c:forEach>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${empty action}" >
                <form action="<c:url value="/abrigada/adiciona"/>" method="post">
                </c:when>
                <c:otherwise>
                    <form action="<c:url value="/abrigada/atualizar"/>" method="post">
                    </c:otherwise>
                </c:choose>
                <input type="hidden" name="abrigada.id" value="${abrigada.id}" />
                Nome: <input type="text" name="abrigada.nome" value="${abrigada.nome}" /><br/>
                Cpf: <input type="text" name="abrigada.cpf" value="${abrigada.cpf}" /><br/>
                RG: <input type="text" name="abrigada.rg" value="${abrigada.rg}" /><br/>
                Endere&ccedil;o: <input type="text" name="abrigada.endereco" value="${abrigada.endereco}" /><br/>
                Cep: <input type="text" name="abrigada.cep" value="${abrigada.cep}" /><br/>
                Data de Entrada: <input type="text" name="abrigada.dataEntrada" value="${abrigada.dataEntrada}" /><br/>
                Data de Nascimento: <input type="text" name="abrigada.dataNascimento" value="${abrigada.dataNascimento}" /><br/>
                Estado Civil:<input type="text" name="abrigada.estadoCivil" value="${abrigada.estadoCivil}" /><br/>
                Profiss&atilde;o: <input type="text" name="abrigada.profissao" value="${abrigada.profissao}" /><br/>
                Nacionalidade: <input type="text" name="abrigada.nacionalidade" value="${abrigada.nacionalidade}" /><br/>
                Naturalidade: <input type="text" name="abrigada.naturalidade" value="${abrigada.naturalidade}" /><br/>
                Escolaridade: <input type="text" name="abrigada.escolaridade" value="${abrigada.escolaridade}" /><br/>
                Telefone: <input type="text" name="abrigada.telefone" value="${abrigada.telefone}" /><br/>
                Celular: <input type="text" name="abrigada.celular" value="${abrigada.celular}" /><br/>
                <input type="submit" value="Salvar" />
            </form>
    </body>
</html>
