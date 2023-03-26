<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp"/>
<div class="card text-center">
    <div class="card-header">
        <h1>Brinquedo</h1>
        <hr/>
        <div class="row">
            <div class="col-12">
                <a href="NovoBrinquedo" class="btn btn-primary">Novo Brinquedo</a>
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Voltar</a>
            </div>
        </div>
        <hr/>
        <c:if test="${mensagem != null}">
        <div class="alert alert-primary" role="alert">
            ${mensagem}
        </div>
        </c:if>
    </div>
    <div class="card-body">
        <table class="table">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="Brinquedo" items="${Brinquedos}">
                    <tr>
                        <td>${Brinquedo.codigoBrinquedo}</td>
                        <td>${Brinquedo.nomeBrinquedo}</td>
                        <td><a class="btn btn-info" href="ConsultarBrinquedo?codigoBrinquedo=${Brinquedo.codigoBrinquedo}">Alterar</a>
                        <a class="btn btn-danger" href="ExcluirBrinquedo?codigoBrinquedo=${Brinquedo.codigoBrinquedo}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="rodape.jsp"/>