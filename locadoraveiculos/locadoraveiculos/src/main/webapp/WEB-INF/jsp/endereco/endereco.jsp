<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>

<div class="row border border-secondary rounded mb-4">
    <div class="form-group col-sm-6 mb-4 mt-4">
      <label for="cep" class="form-label">Cep:</label>
      <form:input type="text" id="cep" class="form-control" placeholder="Entre com o seu cep" path="endereco.cep" />
    </div>

    <div class="form-group col-sm-6 mb-4 mt-4">
      <label for="logradouro" class="form-label">Logradouro:</label>
      <form:input type="text" id="logradouro" class="form-control" placeholder="Entre com o seu logradouro" path="endereco.logradouro" />
    </div>

    <div class="form-group col-sm-6 mb-4">
      <label for="complemento" class="form-label">Complemento:</label>
      <form:input type="text" id="complemento" class="form-control" placeholder="Entre com o seu complemento" path="endereco.complemento" />
    </div>

    <div class="form-group col-sm-6 mb-4">
      <label for="bairro" class="form-label">Bairro:</label>
      <form:input type="text" id="bairro" class="form-control" placeholder="Entre com o seu bairro" path="endereco.bairro" />
    </div>

    <div class="form-group col-sm-6 mb-4">
      <label for="localidade" class="form-label">Localidade:</label>
      <form:input type="text" id="localidade" class="form-control" placeholder="Entre com o seu localidade" path="endereco.localidade" />
    </div>

    <div class="form-group col-sm-6 mb-4">
      <label for="uf" class="form-label">UF:</label>
      <form:input type="text" id="uf" class="form-control" placeholder="Entre com o seu uf" path="endereco.uf" minlength="2" maxlength="2" />
    </div>
</div>