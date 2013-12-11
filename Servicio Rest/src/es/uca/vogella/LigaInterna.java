package es.uca.vogella;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("flash")
public class LigaInterna {
	
	public static CorredorDAO BD = new CorredorDAO();
	
	@GET
	@Path("buscar/{pos}")
	@Produces(MediaType.APPLICATION_XML)
	public Corredor getCorredor(@PathParam("pos") Integer pos){return BD.buscar(pos);}
	
	@POST
	@Path("insertar/{pos}")
	@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertar(@PathParam("pos")Integer pos, Corredor c){
		return BD.insertar(pos,c);	
	}
	
	@PUT
	@Path("actualizar/{pos}")
	@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_JSON)
	public String actualizar(@PathParam("pos")Integer pos, Corredor c){
		BD.borrar(pos);
		BD.actualizar(pos,c);
		return "Actualizado";
	}
	
	
	@DELETE
	@Path("borrar/{pos}")
	@Produces("text/plain")
	public String borrarCorredor(@PathParam("pos")Integer pos){
		return BD.borrar(pos);
	}
	

}
