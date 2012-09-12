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
        <link type="text/css" rel="stylesheet" href="../css/geral.css"/>
    </head>
    <body>
        <h1>Lista de abrigadas:</h1>
        <a href="<c:url value='/abrigada/form'/>">Cadastrar</a><br />
        <table id="tblist">
            <thead>
            <th>Ações</th>
            <th>ID</th>
            <th>Nome</th>
            <th>Cpf</th>
            <th>Rg</th>
            <th>Endere&ccedil;o</th>
            <th>Cep</th>
            <th>Data de Entrada</th>
            <th>Data de Nascimento</th>
            <th>Estado Civil</th>
            <th>Profiss&atilde;o</th>
            <th>Nacionalidade</th>
            <th>Naturalidade</th>
            <th>Escolaridade</th>
            <th>Telefone</th>
            <th>Celular</th>
        </thead>
        <tbody>
            <c:forEach items="${abrigadaList}" var="abrigada">
                <tr>
                    <td>
                        <a href="<c:url value='/abrigada/deleta/${abrigada.id}'/>">DELETA</a>
                        <br>
                        <a href="<c:url value='/abrigada/edita/${abrigada.id}'/>">EDITA</a>
                        <br>
                        <a href="<c:url value='/dependente/form/${abrigada.id}?nome=${abrigada.nome}' />">CADASTRAR DEPENDENTE</a>
                        <br>
                        <a href="<c:url value='/dependente/lista/${abrigada.id}?nome=${abrigada.nome}' />">VISUALIZA DEPENDENTES</a>
                        <br>
                        <a href="<c:url value='/pertence/form/${abrigada.id}?nome=${abrigada.nome}' />">CADASTRAR PERTENCE</a>
                        <br>
                        <a href="<c:url value='/pertence/lista/${abrigada.id}?nome=${abrigada.nome}' />">VISUALIZA PERTENCE</a>
                        <br>
                    </td>
                    <td>${abrigada.id}</td>
                    <td>${abrigada.nome}</td>
                    <td>${abrigada.cpf}</td>
                    <td>${abrigada.rg}</td>
                    <td>${abrigada.endereco}</td>
                    <td>${abrigada.cep}</td>
                    <td>${abrigada.dataEntrada}</td>
                    <td>${abrigada.dataNascimento}</td>
                    <td>${abrigada.estadoCivil}</td>
                    <td>${abrigada.profissao}</td>
                    <td>${abrigada.nacionalidade}</td>
                    <td>${abrigada.naturalidade}</td>
                    <td>${abrigada.escolaridade}</td>
                    <td>${abrigada.telefone}</td>
                    <td>${abrigada.celular}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
