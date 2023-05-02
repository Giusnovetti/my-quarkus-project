package it.qp.resource;

import it.qp.entity.Personale;
import it.qp.service.PersonaleService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;


@Path("personale")
public class PersonaleResource {


    @Inject
    PersonaleService personaleService;

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll() {

        System.out.println("getAll");

        return Response.ok(personaleService.getAll()).build();


    }

    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @POST
    public Response add( Personale p){

      return Response.ok(personaleService.add(p)).build();
    }


}

