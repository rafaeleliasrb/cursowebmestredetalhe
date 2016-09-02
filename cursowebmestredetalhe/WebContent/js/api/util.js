function obterParametroDaUrl(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	console.log("name:" + name);
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	results = regex.exec(location.search);

	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function tratarErro(request) {
	switch (request.status) {
		case 404: 
			$("#global-message")
				.addClass("alert-danger")
				.text("Registro não encontrado.")
				.show();
		default:
			$("#global-message")
				.addClass("alert-danger")
				.text("Erro inesperado.")
				.show();
			break;
	}
}