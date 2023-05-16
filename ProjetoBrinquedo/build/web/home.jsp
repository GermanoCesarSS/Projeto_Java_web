<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp"/>
<div class="card text-center">
    <div class="card-header">
        <h1>Menu principal</h1>
    </div>
    <div class="card-body">
        <a href="ListarBrinquedo" class="btn btn-primary">Brinquedos</a>
        <a href="ListarMarca" class="btn btn-primary">Marcas</a>
        <a href="EfetuarLogout" class="btn btn-danger">Sair</a>
    </div>
</div>
<jsp:include page="rodape.jsp"/>