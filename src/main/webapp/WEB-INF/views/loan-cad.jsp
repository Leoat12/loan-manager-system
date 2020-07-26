<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Empréstimo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Cadastro de Contratos de Empréstimo</h1>

    <form action="<c:url value="/cadastro"/>" method="post">
        <div class="input-group mb-3">
            <label class="input-group-text" for="client-select" >Selecione o cliente</label>
            <select class="custom-select" id="client-select" name="client.id">
                <c:forEach var="cli" items="${clients}">
                    <option value="${cli.id}">${cli.name}</option>
                </c:forEach>
            </select>

        </div>

        <div class="input-group mb-3">
            <label class="input-group-text" for="collector-select">Selecione o coletor</label>
            <select class="custom-select" id="collector-select" name="collector.id">
                <c:forEach var="clt" items="${collectors}">
                    <option value="${clt.id}" name="collector">${clt.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="input-group mb-3">
            <label class="input-group-text" for="amountGivenInput">Total do empréstimo</label>
            <input class="form-control mr-3" required type="number" id="amountGivenInput" name="amountGiven"/>
            
            <label class="input-group-text" for="interestRateInput">Taxa de Juros</label>
            <input class="form-control" required type="number" min="0" max="100" id="interestRateInput" name="interestRate"/>
        </div>

        <input type="submit" class="btn btn-primary" value="Cadastrar" />
    </form>
    


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
