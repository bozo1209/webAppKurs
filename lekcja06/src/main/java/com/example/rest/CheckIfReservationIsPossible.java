package com.example.rest;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CheckIfReservationIsPossible {


    public boolean reservationIsPossible(Reservation reservation, ReservationDAO dao){

        for (Reservation res : dao.getAll()){
            if (res.getTableNumber().equals(reservation.getTableNumber())){
                if ((reservation.getStart().isAfter(res.getStart()) || reservation.getStart().isEqual(res.getStart())) && (reservation.getEnd().isBefore(res.getEnd()) || reservation.getEnd().isEqual(res.getEnd())) && (reservation.getStart().isBefore(res.getEnd()) && reservation.getEnd().isAfter(res.getStart()))){
                    return false;
                }else if ((reservation.getStart().isBefore(res.getStart()) || reservation.getStart().isEqual(res.getStart())) && (reservation.getEnd().isBefore(res.getEnd()) || reservation.getEnd().isEqual(res.getEnd()))&& (reservation.getStart().isBefore(res.getEnd()) && reservation.getEnd().isAfter(res.getStart()))){
                    return false;
                }else if ((reservation.getStart().isAfter(res.getStart()) || reservation.getStart().isEqual(res.getStart())) && (reservation.getEnd().isAfter(res.getEnd()) || reservation.getEnd().isEqual(res.getEnd()))&& (reservation.getStart().isBefore(res.getEnd()) && reservation.getEnd().isAfter(res.getStart()))){
                    return false;
                }else if ((reservation.getStart().isBefore(res.getStart()) || reservation.getStart().isEqual(res.getStart())) && (reservation.getEnd().isAfter(res.getEnd()) || reservation.getEnd().isEqual(res.getEnd()))){
                    return false;
                }
            }
        }

        return true;
    }
}
