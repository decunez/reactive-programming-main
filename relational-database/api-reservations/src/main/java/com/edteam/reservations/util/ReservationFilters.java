package com.edteam.reservations.util;

import com.edteam.reservations.model.ReservationEvent;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReservationFilters {

    // Evalúa que el precio sea positivo (> 0) y que existan emails registrados
    public static final Predicate<ReservationEvent> isValidPriceAndEmail = event ->
            event.getPrice() != null && event.getPrice() > 0
                    && event.getEmails() != null && !event.getEmails().isEmpty();

    // Efecto secundario que imprime en la consola de IntelliJ el objeto procesado
    public static final Consumer<ReservationEvent> logEvent = event ->
            System.out.println("[STREAM LOG] Procesando exitosamente: " + event);
}