package rest.controller;
 
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import rest.dao.UserDAO;
import rest.model.User;
 
@Path("/users")
public class UserService {
 
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<User> getUsers() {
        return UserDAO.getAllUsers();
    }
 
    // Controle da resposta (status code, mensagem)
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getUser(@PathParam("id") int id) {
        return Response.status(Status.OK).entity(UserDAO.getUser(id)).build();
    }
 
    @GET
    @Path("/search")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public User getUserByName(@QueryParam("username") String username) {
        return UserDAO.getUserByUsername(username);
    }
 
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response addUser(@FormDataParam("image") InputStream uploadedInputStream,
            @FormDataParam("username") String username, @FormDataParam("password") String password,  @FormDataParam("nomecompleto") String nomecompleto,
            @FormDataParam("email") String email, @FormDataParam("endereco") String endereco, @FormDataParam("cidade") String cidade,
            @FormDataParam("estado") String estado,@FormDataParam("pais") String pais) {
               
        if(username == null || password == null || username.equals("null") || password.equals("null")) {
            return Response.status(400).build();
        }
        System.out.println(UserDAO.getUserByUsername(username));

        if(UserDAO.getUserByUsername(username)!=null) {
        	return Response.status(400).build();
        	//return null;
        }
      
        return Response.status(Status.OK).entity(UserDAO.addUser(username, password, nomecompleto, email, endereco,
    			cidade, estado, pais, uploadedInputStream)).build();
    }
 
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public User updateUser(@PathParam("id") int id, @FormDataParam("image") InputStream uploadedInputStream,
            @FormDataParam("image") FormDataContentDisposition contentDispositionHeader,
            @FormDataParam("username") String username, @FormDataParam("password") String password, @FormDataParam("nomecompleto") String nomecompleto,
            @FormDataParam("email") String email, @FormDataParam("endereco") String endereco, @FormDataParam("cidade") String cidade,
            @FormDataParam("estado") String estado,@FormDataParam("pais") String pais) {
    	System.out.println("oi");
        if(contentDispositionHeader.getFileName() == null) {
        	System.out.println("oi2");
            return UserDAO.updateUser(id, username, password, nomecompleto, email, endereco,
        			cidade, estado, pais, null);   
        } else {
        	System.out.println("oi3");
            return UserDAO.updateUser(id, username, password, nomecompleto, email, endereco,
        			cidade, estado, pais, uploadedInputStream);
        }
    }
 
    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteUser(@PathParam("id") int id) {
        UserDAO.deleteUser(id);
    }
}