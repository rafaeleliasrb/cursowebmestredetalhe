package br.com.cursowebmestredetalhe.exception;

/**
 * Classe de excecao disparada pela camada de negocio.
 */
public class EstadoNaoEncontradoException extends Exception {

	private static final long serialVersionUID = -1071896537277884578L;

	public EstadoNaoEncontradoException() {
		super("Estado não encontrado!");
	}
}
