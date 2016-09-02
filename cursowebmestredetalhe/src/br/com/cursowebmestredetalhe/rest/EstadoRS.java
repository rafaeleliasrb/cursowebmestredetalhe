package br.com.cursowebmestredetalhe.rest;

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

import br.com.cursowebmestredetalhe.business.EstadoBC;
import br.com.cursowebmestredetalhe.exception.EstadoNaoEncontradoException;
import br.com.cursowebmestredetalhe.model.Estado;

@Path("estados")
public class EstadoRS {

	@Inject
	private EstadoBC estadoBC;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estado> selecionarTodos() {
		return estadoBC.selecionar();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estado selecionaPorId(@PathParam("id") Long id) {
		try {
			return estadoBC.selecionar(id);
		} catch (EstadoNaoEncontradoException e) {
			throw new NotFoundException();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(Estado estado) {
		Long id = estadoBC.inserir(estado);
		String url = "/api/estados" + id;
		
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
	public Response atualizar(@PathParam("id") Long id, Estado estado) {
		try {
			estado.setId(id);
			estadoBC.atualizar(estado);
			return Response
					.status(Status.OK)
					.entity(id)
					.build();
		} catch (EstadoNaoEncontradoException e) {
			throw new NotFoundException();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Long id) {
		try {
			Estado estado = estadoBC.excluir(id);
			
			return Response
					.status(Status.OK)
					.entity(estado)
					.build();
		} catch (EstadoNaoEncontradoException e) {
			throw new NotFoundException();
		}
	}
}
