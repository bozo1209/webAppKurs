package przyklady;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/reservation")
public class ReservationWebservice {

//    test
    @GET
    public Response listReservations(){
        return Response.ok("wszystkie rezerwacje: ").build();
    }
}
