package com.edteam.reservations.model;

import java.util.ArrayList;
import java.util.List;

public final class ReservationEvent {

    private final String id;
    private final String passengerName;
    private final Double price;
    private final List<String> emails;

    // Constructor con copias defensivas
    public ReservationEvent(String id, String passengerName, Double price, List<String> emails) {
        this.id = id;
        this.passengerName = passengerName;
        this.price = price;
        // Copia defensiva para proteger la inmutabilidad de la lista externa
        this.emails = (emails != null) ? new ArrayList<>(emails) : new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Double getPrice() {
        return price;
    }

    // Getter con copia defensiva
    public List<String> getEmails() {
        return new ArrayList<>(this.emails);
    }

    @Override
    public String toString() {
        return "ReservationEvent{" +
                "id='" + id + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", price=" + price +
                ", emails=" + emails +
                '}';
    }
}