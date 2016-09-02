$(function() {
	EstadosProxy
	.selecionarTodos()
	.done(buscarOk)
	.fail(function() {
		console.log("Erro selecionar todos");
	});
});


function buscarOk(estados) {
	var body = $("tbody")[0];
	console.log("body:" + body);
	
	/* limpa o corpo da tabela */
	$(body).empty();
	
	if(estados) {
		for(var i=0; i<estados.length; i++) {
			var estado = estado[i];
			
			/* linha da tabela contendo os dados do estado */
			var linha = document.createElement("tr");
			linha.setAttribute("id", "estado" + estado.id);
			
			/* coluna com a placa do estado no formato de link(para edicao) */
			var colunaNome = document.createElement("td");
			var nome = document.createTextNode(estado.nome);
			colunaPlaca.appendChild(nome);
			linha.appendChild(colunaNome);
			
			/* coluna com o nome do proprietario */
			var colunaSigla = document.createElement("td");
			var sigla = document.createTextNode(estado.sigla);
			colunaSigla.appendChild(sigla);
			linha.appendChild(colunaNomeProprietario);
			
			/* coluna com o botao de excluir o estado */
			/*var colunaExcluir = document.createElement("td");
			var excluir = document.createTextNode(" Excluir");
			var linkExcluir = document.createElement("a");
			linkExcluir.setAttribute("href", "");
			linkExcluir.setAttribute("class", "botao-remover btn btn-danger btn-xs");
			linkExcluir.setAttribute("id", estado.id);
			var iconeExcluir = document.createElement("span");
			iconeExcluir.setAttribute("class", "glyphicon glyphicon-remove");
			linkExcluir.appendChild(iconeExcluir);
			linkExcluir.appendChild(excluir);
			colunaExcluir.appendChild(linkExcluir);
			linha.appendChild(colunaExcluir);*/

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
				EstadosProxy
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
	var estadoExcluido = data;
	
	$("#global-message")
	.addClass("alert-success")
	.text("Estado de id=" + estadoExcluido.id + " excluido com sucesso.")
	.show(500);
}