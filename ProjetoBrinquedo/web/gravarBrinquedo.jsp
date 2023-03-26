<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp"/>
<div class="card">
    <div class="card-header text-center">
        <h1>Gravar Brinquedo</h1>
    </div>
    <div class="card-body">
        <form action="GravarBrinquedo" method="post">
            <div class="row">
                <div class="col-6">
                    <label for="codigoBrinquedo">Código:</label>
                    <input type="text" id="codigoBrinquedo" class="form-control" name="codigoBrinquedo" value="${Brinquedo.codigoBrinquedo == 0 ? "" : Brinquedo.codigoBrinquedo}" readonly />
                </div>
                <div class="col-6">
                    <label for="nomeBrinquedo">Nome: </label>
                    <input type="text" id="nomeBrinquedo" class="form-control" name="nomeBrinquedo" value="${Brinquedo.nomeBrinquedo}" />
                </div>
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