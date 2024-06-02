package rest.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import rest.dao.ComFilmesDAO;
import rest.model.ComFilmes;

@Path("/comfilmes")
public class ComFilmesService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ComFilmes> getUsers() {
		return ComFilmesDAO.getAllUsers();
	}

	// Controle da resposta (status code, mensagem)
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getUser(@PathParam("id") int id) {
		return Response.status(Status.OK).entity(ComFilmesDAO.getUser(id)).build();
	}

	@GET
	@Path("/search")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ComFilmes getUserByName(@QueryParam("username") String username) {
		return ComFilmesDAO.getUserByUsername(username);
	}
	
	@POST 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ComFilmes addPostFilmes(@FormDataParam("image") InputStream uploadedInputStream,
			@FormDataParam("idautor") int idautor,@FormDataParam("idtopico") int idtopico,  @FormDataParam("texto") String texto) {
		return ComFilmesDAO.addComFilmes(idautor, idtopico, texto, uploadedInputStream);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ComFilmes updateUser(@PathParam("id") int id, @FormDataParam("image") InputStream uploadedInputStream,
			@FormDataParam("image") FormDataContentDisposition contentDispositionHeader, @FormDataParam("idAutor") int idAutor,
			@FormDataParam("idtopico") int idtopico, @FormDataParam("password") String password) {
		
		if(contentDispositionHeader.getFileName() == null) {
			return ComFilmesDAO.updateUser(id, idAutor, idtopico, password, null);	
		} else {
			return ComFilmesDAO.updateUser(id, idAutor, idtopico, password, uploadedInputStream);
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteUser(@PathParam("id") int id) {
		ComFilmesDAO.deletePostFilme(id);
	}
	
	//Session
	@POST
	@Path("/oi")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public Response hello(@Context HttpServletRequest req, @FormDataParam("name") String name) {
        HttpSession session = req.getSession(true);
        Object foo = session.getAttribute("foo");
        System.out.println(session.getId());
        
        if (foo != null) {
            System.out.println(foo.toString());
        } else {
            foo = "bar";
            session.setAttribute("foo", foo);
            System.out.println("first");
        }
        
        return Response.status(Status.OK).entity(foo.toString()).build();
    }
}