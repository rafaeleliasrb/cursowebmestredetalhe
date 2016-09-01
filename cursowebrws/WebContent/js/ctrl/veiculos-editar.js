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

		var veiculo = {
			id: $("#id").val(),
			placa: $("#placa").val(),
			nomeProprietario: $("#nomeProprietario").val(),
			valorIpva: $("#valorIpva").val(),
			dataEmplacamento: $("#dataEmplacamento").val()
		}

		console.log(veiculo);
		
		if(veiculo.id) {
			VeiculosProxy
				.atualizar(veiculo.id, veiculo)
				.done(atualizarOk)
				.fail(tratarErro);
		}
		else {
			VeiculosProxy
				.inserir(veiculo)
				.done(inserirOk)
				.fail(tratarErro);
		}
	});
	
	/*https://github.com/RobinHerbots/jquery.inputmask*/
	$("#placa").inputmask("AAA-9999");
	$("#valorIpva").inputmask({alias: "currency"});
	$("#dataEmplacamento").inputmask({alias: "date"});
});

function inserirOk(data, textStatus, jqXHR) {
	$("id").val(data);
	$("#global-message")
		.addClass("alert-success")
		.text("Veículo de id=" + data + " incluido com sucesso.")
		.show();
}

function selecionarOk(veiculo) {
	$("#id").val(veiculo.id);
	$("#placa").val(veiculo.placa);
	$("#nomeProprietario").val(veiculo.nomeProprietario);
	$("#valorIpva").val(veiculo.valorIpva);
	$("#dataEmplacamento").val(veiculo.dataEmplacamento);
}

function atualizarOk(data, textStatus, jqXHR) {
	$("#global-message")
		.addClass("alert-success")
		.text("Veículo de id=" + data + " incluido com sucesso.")
		.show();
}