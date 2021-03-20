package com.example.rest;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/reservation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationWebservice {

    @Inject
    @SuppressWarnings("unused")
    private ReservationDAO dao;

    @Inject
    @SuppressWarnings("unused")
    private CheckIfReservationIsPossible checkIfReservationIsPossible;

    @GET
    public Response listReservations() {
        return Response.ok(dao.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getReservation(@PathParam("id") @Min(0) Integer id) {
        Reservation reservation = dao.getById(id);
        if (reservation != null) {
            return Response.ok(reservation).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    public Response updateReservation(@PathParam("id") @Min(0) Integer id, @Valid Reservation reservation) {
        boolean hasReservation = dao.getById(id) != null;
        if (hasReservation) {
            if (checkIfReservationIsPossible.reservationIsPossible(reservation, dao)){
                dao.updateReservation(id, reservation);
                return Response.noContent().build();
            }
            return Response.ok("Nie mozna z zmienic rezerwacji. Wybrany termin jest juz zajety dla wybranego stolika").build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteReservation(@PathParam("id") @Min(0) Integer id) {
        Reservation reservation = dao.deleteReservation(id);
        if (reservation != null) {
            return Response.ok(reservation).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createReservation(@Valid Reservation reservation) {
        if (checkIfReservationIsPossible.reservationIsPossible(reservation, dao)){
            int newId = dao.createReservation(reservation);
            URI location;
            try {
                location = new URI("reservations/" + newId);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            return Response.created(location).build();
        }
        return Response.ok("Nie mozna zalazyc nowej rezerwacji. Wybrany termin jest juz zajety dla wybranego stolika").build();
    }
}
