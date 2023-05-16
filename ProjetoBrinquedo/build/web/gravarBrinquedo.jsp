<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp"/>
<div class="card">
    <div class="card-header text-center">
        <h1>Novo Brinquedo</h1>
    </div>
    <div class="card-body">
        <c:if test="${mensagem != null}">
            <div class="alert alert-primary text-center" role="alert">
                ${mensagem}
            </div>
        </c:if>

        <form action="GravarBrinquedo" method="post">
            <input class="form-control" type="text" id="codigoBrinquedo" name="codigoBrinquedo" readonly hidden value="${brinquedo.codigoBrinquedo == 0 ? "" : brinquedo.codigoBrinquedo}"/>
            <div class="row">
                <div class="col-6">
                    <label for="nomeBrinquedo">Nome: </label>
                    <input type="text" id="nomeBrinquedo" class="form-control" name="nomeBrinquedo" value="${brinquedo.nomeBrinquedo}" />
                </div>
            </div>
                 <div class="form-group col-4">
                    <label for="codigoMarca">Marca:</label>
                    <select id="codigoMarca" name="codigoMarca" class="form-control" required>
                        <option value="">Selecione...</option>
                        <c:forEach var="marca" items="${marcas}">
                            <option value="${marca.codigoMarca}" ${marca.codigoMarca == brinquedo.marca.codigoMarca ? "selected" : ""}>${marca.nomeMarca}</option>
                        </c:forEach>
                    </select>
                </div>
            <div class="row mt-3">
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-success">Cadastrar</button>
                    <a href="ListarBrinquedo" class="btn btn-secondary">Voltar</a>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="rodape.jsp"/>