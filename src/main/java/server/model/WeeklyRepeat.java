package server.model;

import java.time.LocalDate;

/**
 * Anuwat Angkuldee 5810401066
 */

public class WeeklyRepeat extends RepeatType {

    @Override
    public String getRepeat() {
        return "WEEKLY";
    }

    @Override
    public boolean compareDate(LocalDate appointmentDate, LocalDate date) {
        return appointmentDate.getDayOfWeek().getValue() == date.getDayOfWeek().getValue();
    }

    @Override
    public String toString(Appointment appointment) {
        return appointment.getId() + ": " + appointment.getDate().getDayOfWeek() + " " + super.toString(appointment);
    }
}