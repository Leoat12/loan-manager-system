<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Listagem de Contratos de Empréstimo</h1>

    <h3><a href="<c:url value="/cadastro"/>">Cadastrar novo empréstimo</a></h3>

    <table class="table">
        <thead>
        <tr>
            <th>ID Transação</th>
            <th>Nome Cliente</th>
            <th>Data do Empréstimo</th>
            <th>Valor concedido</th>
            <th>Taxa de Juros</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contract" items="${contracts}">
            <tr>
                <td>${contract.transactionId}</td>
                <td>${contract.client.name}</td>
                <td>${contract.dateLoanGiven}</td>
                <td>${contract.amountGiven}</td>
                <td>${contract.interestRate}</td>
                <td>
                    <a href="<c:url value="/formedit/${contract.transactionId}"/>">
                        <button class="btn btn-primary" type="button">Editar</button>
                    </a>
                    <a href="<c:url value="/delete/${contract.transactionId}"/>">
                        <button class="btn btn-danger" type="button">Excluir</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
