package com.example.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDateTime;

class CheckIfReservationIsPossibleTest {

//    nie działa wstrzykiwanie zależności nie wiem czemu
//    @Inject
    ReservationDAO dao = new ReservationDAO();
//    @Inject
    CheckIfReservationIsPossible checkIfReservationIsPossible = new CheckIfReservationIsPossible();

    Reservation res;
    Reservation res1;
    Reservation res2;

    @BeforeEach
    public void setUp(){
        res = new Reservation();
        LocalDateTime start = LocalDateTime.of(2022, 1,1,1,1);
        LocalDateTime end = LocalDateTime.of(2022, 1,1,1,10);
        res.setName("kkk");
        res.setTableNumber(1);
        res.setStart(start);
        res.setEnd(end);
        dao.createReservation(res);

        res1 = new Reservation();
        LocalDateTime start1 = LocalDateTime.of(2022, 1,1,1,20);
        LocalDateTime end1 = LocalDateTime.of(2022, 1,1,1,30);
        res1.setName("Stefan");
        res1.setTableNumber(1);
        res1.setStart(start1);
        res1.setEnd(end1);
        dao.createReservation(res1);

        res2 = new Reservation();
        LocalDateTime start2 = LocalDateTime.of(2022, 1,1,1,40);
        LocalDateTime end2 = LocalDateTime.of(2022, 1,1,1,50);
        res2.setName("Stefan");
        res2.setTableNumber(1);
        res2.setStart(start2);
        res2.setEnd(end2);
        dao.createReservation(res2);

    }


    @Test
    public void reservationIsPossible() {
        Reservation resTest1 = new Reservation();
        LocalDateTime start1 = LocalDateTime.of(2022, 1,1,1,1);
        LocalDateTime end1 = LocalDateTime.of(2022, 1,1,1,5);
        resTest1.setName("kkk");
        resTest1.setTableNumber(1);
        resTest1.setStart(start1);
        resTest1.setEnd(end1);

        Reservation resTest2 = new Reservation();
        LocalDateTime start2 = LocalDateTime.of(2022, 1,1,1,11);
        LocalDateTime end2 = LocalDateTime.of(2022, 1,1,1,25);
        resTest2.setName("kkk");
        resTest2.setTableNumber(1);
        resTest2.setStart(start2);
        resTest2.setEnd(end2);

        Reservation resTest3 = new Reservation();
        LocalDateTime start3 = LocalDateTime.of(2022, 1,1,1,25);
        LocalDateTime end3 = LocalDateTime.of(2022, 1,1,1,35);
        resTest3.setName("kkk");
        resTest3.setTableNumber(1);
        resTest3.setStart(start3);
        resTest3.setEnd(end3);

        Reservation resTest4 = new Reservation();
        LocalDateTime start4 = LocalDateTime.of(2022, 1,1,1,15);
        LocalDateTime end4 = LocalDateTime.of(2022, 1,1,1,35);
        resTest4.setName("kkk");
        resTest4.setTableNumber(1);
        resTest4.setStart(start4);
        resTest4.setEnd(end4);

        Reservation resTest5 = new Reservation();
        LocalDateTime start5 = LocalDateTime.of(2022, 1,1,1,31);
        LocalDateTime end5 = LocalDateTime.of(2022, 1,1,1,39);
        resTest5.setName("kkk");
        resTest5.setTableNumber(1);
        resTest5.setStart(start5);
        resTest5.setEnd(end5);

        Assertions.assertAll(
                () -> Assertions.assertFalse(checkIfReservationIsPossible.reservationIsPossible(resTest1, dao)),
                () -> Assertions.assertFalse(checkIfReservationIsPossible.reservationIsPossible(resTest2, dao)),
                () -> Assertions.assertFalse(checkIfReservationIsPossible.reservationIsPossible(resTest3, dao)),
                () -> Assertions.assertFalse(checkIfReservationIsPossible.reservationIsPossible(resTest4, dao)),
                () -> Assertions.assertTrue(checkIfReservationIsPossible.reservationIsPossible(resTest5, dao))
        );
    }
}