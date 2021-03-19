package przyklady;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/reservation")
public class ReservationWebservice {

    @GET
    public Response listReservations(){
        return Response.ok("wszystkie rezerwacje: ").build();
    }

    @GET
    @Path("{id}")
    public Response getReservation(@PathParam("id") Integer id){
        return Response.ok("oto rezerwacja o id " + id + " :").build();
    }

    @PUT
    @Path("{id}")
    public Response updateReservation(@PathParam("id") Integer id){
        return Response.ok("zmodyfikowano rezerwację o id " + id + " :").build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteReservation(@PathParam("id") Integer id){
        return Response.ok("rezerwacja o id " + id + " została usunięta").build();
    }

    @POST
    public Response createReservation(){
        return Response.ok("rezerwacja zostałą utworzona").build();
    }
}
