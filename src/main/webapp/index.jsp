<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SICA</title>
        <link type="text/css" rel="stylesheet" href="css/geral.css"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="well">
                <div class="row offset1">
                    <h1 class="title">Sistema Integrado da Casa Abrigo</h1>                        
                </div>

                <div class="row offset1">
                    <div class="btn-group">
                        <a class="btn btn-large btn-primary" href="<c:url value='/abrigada/form'/>">Cadastrar Abrigada</a>
                        <a class="btn btn-large btn-primary" href="<c:url value='/abrigada/lista'/>">Ver lista de Abrigada</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
