$(function() {
	var id = obterParametroDaUrl("id");
	if(id) {
		VeiculosProxy
		.selecionarPorId(id)
		.done(selecionarOk)
		.fail(tratarErro);
	}
	console.log("id: " + id);
	
	$("#salvar").click(function(event) {

		var estado = {
			id: $("#id").val(),
			nome: $("#nome").val(),
			sigla: $("#sigla").val()
		}

		console.log(estado);
		
		if(estado.id) {
			VeiculosProxy
				.atualizar(estado.id, estado)
				.done(atualizarOk)
				.fail(tratarErro);
		}
		else {
			VeiculosProxy
				.inserir(estado)
				.done(inserirOk)
				.fail(tratarErro);
		}
	});
});

function inserirOk(data, textStatus, jqXHR) {
	$("id").val(data);
	$("#global-message")
		.addClass("alert-success")
		.text("Estado de id=" + data + " incluido com sucesso.")
		.show();
}

function selecionarOk(estado) {
	$("#id").val(estado.id);
	$("#nome").val(estado.nome);
	$("#sigla").val(veiculo.sigla);
}

function atualizarOk(data, textStatus, jqXHR) {
	$("#global-message")
		.addClass("alert-success")
		.text("Estado de id=" + data + " incluido com sucesso.")
		.show();
}