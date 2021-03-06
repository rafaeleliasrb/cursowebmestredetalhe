package br.com.cursowebrws.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cursowebrws.business.VeiculoBC;
import br.com.cursowebrws.exception.VeiculoNaoEncontradoException;
import br.com.cursowebrws.model.Veiculo;

@Path("veiculos")
public class VeiculoRS {

	@Inject
	private VeiculoBC veiculoBC;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Veiculo> selecionarTodos() {
		return veiculoBC.selecionar();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Veiculo selecionaPorId(@PathParam("id") Long id) {
		try {
			return veiculoBC.selecionar(id);
		} catch (VeiculoNaoEncontradoException e) {
			throw new NotFoundException();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(Veiculo veiculo) {
		Long id = veiculoBC.inserir(veiculo);
		String url = "/api/veiculos" + id;
		
		return Response
				.status(Status.CREATED)
				.header("Location", url)
				.entity(id)
				.build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, Veiculo veiculo) {
		try {
			veiculo.setId(id);
			veiculoBC.atualizar(veiculo);
			return Response
					.status(Status.OK)
					.entity(id)
					.build();
		} catch (VeiculoNaoEncontradoException e) {
			throw new NotFoundException();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Long id) {
		try {
			Veiculo veiculo = veiculoBC.excluir(id);
			
			return Response
					.status(Status.OK)
					.entity(veiculo)
					.build();
		} catch (VeiculoNaoEncontradoException e) {
			throw new NotFoundException();
		}
	}
}
