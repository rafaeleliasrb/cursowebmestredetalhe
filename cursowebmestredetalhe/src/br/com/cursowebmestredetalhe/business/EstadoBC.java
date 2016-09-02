package br.com.cursowebmestredetalhe.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.cursowebmestredetalhe.dao.Repositorio;
import br.com.cursowebmestredetalhe.exception.EstadoNaoEncontradoException;
import br.com.cursowebmestredetalhe.model.Estado;

/**
 * estado Business Component
 */
@ApplicationScoped
public class EstadoBC {
	
	@Inject
	private Repositorio repositorio;
	
	@PostConstruct
	public void inicializar() {

		/* Estado 1 */
		Estado estado = new Estado();
		estado.setSigla("Pedro de Alcantara");
		estado.setNome("ABC-1234");
		repositorio.inserir(estado);

		/* Estado 2 */
		estado = new Estado();
		estado.setSigla("Santos Dumont");
		estado.setNome("XYZ-9876");
		repositorio.inserir(estado);

		/* Estado 3 */
		estado = new Estado();
		estado.setSigla("Isabel de Braganca");
		estado.setNome("SUV-8523");
		repositorio.inserir(estado);
		
		/* Estado 4 */
		estado = new Estado();
		estado.setSigla("Pedro de Alcantara");
		estado.setNome("ABC-1234");
		repositorio.inserir(estado);
		
		/* Estado 5 */
		estado = new Estado();
		estado.setSigla("Pedro de Alcantara");
		estado.setNome("ABC-1234");
		repositorio.inserir(estado);
		
		/* Estado 6 */
		estado = new Estado();
		estado.setSigla("Pedro de Alcantara");
		estado.setNome("ABC-1234");
		repositorio.inserir(estado);
	}

	public List<Estado> selecionar() {
		return repositorio.selecionar(Estado.class);
	}
	
	public Estado selecionar(Long id) throws EstadoNaoEncontradoException {
		Estado estado = repositorio.selecionar(Estado.class, id);
		if (estado == null) {
			throw new EstadoNaoEncontradoException();
		}
		return estado;
	}
	
	public Long inserir(Estado estado) {
		return repositorio.inserir(estado);
	}
	
	public void atualizar(Estado estado) throws EstadoNaoEncontradoException {
		if(!repositorio.atualizar(estado)) {
			throw new EstadoNaoEncontradoException();
		}
	}
	
	public Estado excluir(Long id) throws EstadoNaoEncontradoException {
		Estado usuario = repositorio.excluir(Estado.class, id);
		if (usuario == null) {
			throw new EstadoNaoEncontradoException();
		}
		return usuario;
	}
}