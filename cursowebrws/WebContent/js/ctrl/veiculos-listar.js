$(function() {
	VeiculosProxy
	.selecionarTodos()
	.done(buscarOk)
	.fail(function() {
		console.log("Erro selecionar todos");
	});
});


function buscarOk(veiculos) {
	var body = $("tbody")[0];
	console.log("body:" + body);
	
	/* limpa o corpo da tabela */
	$(body).empty();
	
	if(veiculos) {
		for(var i=0; i<veiculos.length; i++) {
			var veiculo = veiculos[i];
			
			/* linha da tabela contendo os dados do veiculo */
			var linha = document.createElement("tr");
			linha.setAttribute("id", "veiculo" + veiculo.id);
			
			/* coluna com a placa do veiculo no formato de link(para edicao) */
			var colunaPlaca = document.createElement("td");
			var placa = document.createTextNode(veiculo.placa);
			var linkEditar = document.createElement("a");
			linkEditar.setAttribute("href", "veiculos-editar.html?id=" + veiculo.id);
			linkEditar.appendChild(placa);
			colunaPlaca.appendChild(linkEditar);
			linha.appendChild(colunaPlaca);
			
			/* coluna com o nome do proprietario */
			var colunaNomeProprietario = document.createElement("td");
			var nomeProprietario = document.createTextNode(veiculo.nomeProprietario);
			colunaNomeProprietario.appendChild(nomeProprietario);
			linha.appendChild(colunaNomeProprietario);
			
			/* coluna com o valor do ipva */
			var colunaValorIpva = document.createElement("td");
			var valorIpva = document.createTextNode("R$ " + veiculo.valorIpva);
			colunaValorIpva.appendChild(valorIpva);
			linha.appendChild(colunaValorIpva);
			
			/* coluna com a data do emplacamento */
			var colunaDataEmplacamento = document.createElement("td");
			var dataEmplacamento = document.createTextNode(veiculo.dataEmplacamento);
			colunaDataEmplacamento.appendChild(dataEmplacamento);
			linha.appendChild(colunaDataEmplacamento);
			
			/* coluna com o botao de excluir o veiculo */
			var colunaExcluir = document.createElement("td");
			var excluir = document.createTextNode(" Excluir");
			var linkExcluir = document.createElement("a");
			linkExcluir.setAttribute("href", "");
			linkExcluir.setAttribute("class", "botao-remover btn btn-danger btn-xs");
			linkExcluir.setAttribute("id", veiculo.id);
			var iconeExcluir = document.createElement("span");
			iconeExcluir.setAttribute("class", "glyphicon glyphicon-remove");
			linkExcluir.appendChild(iconeExcluir);
			linkExcluir.appendChild(excluir);
			colunaExcluir.appendChild(linkExcluir);
			linha.appendChild(colunaExcluir);

			/* adiciona a linha no body */
			body.appendChild(linha);
		}
		
		/* evento ao clicar no botao excluir */
		$(".botao-remover").click(function(event) {
			//event.preventDefault();

			/* pega o valor do atributo id */
			var id = $(this).attr("id");
			console.log("id attr: " + id);
			
			/* remove o arquivo da lista */
			if(id) {
				VeiculosProxy
				.excluir(id)
				.done(excluirOk)
				.fail(tratarErro);
			}
			
			/* animacao ao remover */
			var tr = $(this).closest('tr');
			tr.css("background-color","#d43f3a");
			tr.fadeOut(400, function(){
				tr.remove();
			});
		});
		
		/* popup de confirmacao */
		$(".botao-remover").popConfirm({
			title: "Confirmação", // The title of the confirm
	        content: "Você tem certeza que quer apagar o registro?", // The message of the confirm
	        placement: "bottom", // The placement of the confirm (Top, Right, Bottom, Left)
	        yesBtn: "Sim",
	        noBtn: "Não"
		});
	}
	else {
		var tabela = $("table")[0];
		var rodape = document.createElement("tfoot");

		var linhaVazia = document.createElement("tr");
		var colunaVazia = document.createElement("td");
		var nenhumRegistroEncontrado = document.createTextNode("Nenhum registro encontrado.");
		colunaVazia.appendChild(nenhumRegistroEncontrado);
		colunaVazia.setAttribute("colspan", 4);
		linhaVazia.appendChild(colunaVazia);

		rodape.appendChild(linhaVazia);
		tabela.appendChild(rodape);
	}
}

function excluirOk(data, textStatus, jqXHR) {
	var veiculoExcluido = data;
	
	$("#global-message")
	.addClass("alert-success")
	.text("Veículo de id=" + veiculoExcluido.id + " excluido com sucesso.")
	.show(500);
}