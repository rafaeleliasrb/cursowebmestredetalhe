package br.com.cursowebrws.business;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.cursowebrws.dao.Repositorio;
import br.com.cursowebrws.exception.VeiculoNaoEncontradoException;
import br.com.cursowebrws.model.Veiculo;

/**
 * Veiculo Business Component
 */
@ApplicationScoped
public class VeiculoBC {
	
	@Inject
	private Repositorio repositorio;
	
	@PostConstruct
	public void inicializar() {
		Calendar data = Calendar.getInstance();

		/* Veiculo 1 */
		Veiculo veiculo = new Veiculo();
		veiculo.setNomeProprietario("Pedro de Alcantara");
		veiculo.setPlaca("ABC-1234");
		veiculo.setValorIpva(650.35);
		data.set(2013, 9, 12);
		veiculo.setDataEmplacamento(data.getTime());
		repositorio.inserir(veiculo);

		/* Veiculo 2 */
		veiculo = new Veiculo();
		veiculo.setNomeProprietario("Santos Dumont");
		veiculo.setPlaca("XYZ-9876");
		veiculo.setValorIpva(812.35);
		data.set(2014, 6, 20);
		veiculo.setDataEmplacamento(data.getTime());
		repositorio.inserir(veiculo);

		/* Veiculo 3 */
		veiculo = new Veiculo();
		veiculo.setNomeProprietario("Isabel de Braganca");
		veiculo.setPlaca("SUV-8523");
		veiculo.setValorIpva(436.40);
		data.set(2010, 6, 29);
		veiculo.setDataEmplacamento(data.getTime());
		repositorio.inserir(veiculo);
		
		/* Veiculo 4 */
		veiculo = new Veiculo();
		veiculo.setNomeProprietario("Pedro de Alcantara");
		veiculo.setPlaca("ABC-1234");
		veiculo.setValorIpva(650.35);
		data.set(2013, 9, 12);
		veiculo.setDataEmplacamento(data.getTime());
		repositorio.inserir(veiculo);
		
		veiculo = new Veiculo();
		veiculo.setNomeProprietario("Pedro de Alcantara");
		veiculo.setPlaca("ABC-1234");
		veiculo.setValorIpva(650.35);
		data.set(2013, 9, 12);
		veiculo.setDataEmplacamento(data.getTime());
		repositorio.inserir(veiculo);
		
		veiculo = new Veiculo();
		veiculo.setNomeProprietario("Pedro de Alcantara");
		veiculo.setPlaca("ABC-1234");
		veiculo.setValorIpva(650.35);
		data.set(2013, 9, 12);
		veiculo.setDataEmplacamento(data.getTime());
		repositorio.inserir(veiculo);
	}

	public List<Veiculo> selecionar() {
		return repositorio.selecionar(Veiculo.class);
	}
	
	public Veiculo selecionar(Long id) throws VeiculoNaoEncontradoException {
		Veiculo veiculo = repositorio.selecionar(Veiculo.class, id);
		if (veiculo == null) {
			throw new VeiculoNaoEncontradoException();
		}
		return veiculo;
	}
	
	public Long inserir(Veiculo veiculo) {
		return repositorio.inserir(veiculo);
	}
	
	public void atualizar(Veiculo veiculo) throws VeiculoNaoEncontradoException {
		if(!repositorio.atualizar(veiculo)) {
			throw new VeiculoNaoEncontradoException();
		}
	}
	
	public Veiculo excluir(Long id) throws VeiculoNaoEncontradoException {
		Veiculo usuario = repositorio.excluir(Veiculo.class, id);
		if (usuario == null) {
			throw new VeiculoNaoEncontradoException();
		}
		return usuario;
	}
}