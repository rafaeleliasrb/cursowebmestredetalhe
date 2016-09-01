package br.com.cursowebrws.exception;

/**
 * Classe de excecao disparada pela camada de negocio.
 */
public class VeiculoNaoEncontradoException extends Exception {

	private static final long serialVersionUID = -1071896537277884578L;

	public VeiculoNaoEncontradoException() {
		super("Veículo não encontrado!");
	}
}
