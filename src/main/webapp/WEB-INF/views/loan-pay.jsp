<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pagamento do Contrato</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1>Listagem de Contratos de Empréstimo</h1>

    <form action="<c:url value="/pay-contract"/>" method="post">
        <c:if test="${belowMinimum}">
            <div class="alert alert-danger" role="alert">
                A quantia está abaixo do pagamento mínimo.
            </div>
        </c:if>
        <input type="hidden" name="client.id" value="${payment.client.id}"/>
        <input type="hidden" name="loanContract.transactionId" value="${payment.loanContract.transactionId}"/>

        <div class="form-group">
            <label for="amount">Quantia</label>
            <input class="form-control" type="number" id="amount" name="amount"/>
        </div>

        <div class="form-group">
            <label for="observations">Observações</label>
            <textarea class="form-control" id="observations" name="observations"></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Pagar</button>
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
