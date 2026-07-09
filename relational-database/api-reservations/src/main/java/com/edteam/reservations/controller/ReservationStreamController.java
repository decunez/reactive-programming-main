package com.edteam.reservations.controller;

import com.edteam.reservations.model.ReservationEvent;
import com.edteam.reservations.util.ReservationFilters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationStreamController {

    @GetMapping("/stream")
    public Flux<ReservationEvent> getReservationStream() {

        ReservationEvent valido1 = new ReservationEvent("EVT-101", "Alan Turing", 250.0, List.of("turing@mail.com"));
        ReservationEvent valido2 = new ReservationEvent("EVT-102", "Grace Hopper", 310.5, List.of("grace@mail.com", "hopper@corp.com"));
        ReservationEvent valido3 = new ReservationEvent("EVT-103", "Ada Lovelace", 180.0, List.of("ada@mail.com"));

        ReservationEvent invalidoPrecio = new ReservationEvent("EVT-104", "Linus Torvalds", -5.0, List.of("linus@mail.com"));
        ReservationEvent invalidoEmail = new ReservationEvent("EVT-105", "Margaret Hamilton", 400.0, List.of());

        ReservationEvent reservaDefecto = new ReservationEvent("EVT-EMPTY", "Pasajero Anonimo", 0.0, List.of("soporte@aerolinea.com"));

        return Flux.just(valido1, valido2, valido3, invalidoPrecio, invalidoEmail)
                .filter(ReservationFilters.isValidPriceAndEmail)
                .doOnNext(ReservationFilters.logEvent)
                .defaultIfEmpty(reservaDefecto);
    }
}