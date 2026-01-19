package service;

import model.Booking;
import model.Guest;
import model.Room;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();

    public Booking bookRoom(Room room, Guest guest, double amount) {
        Booking booking = new Booking(room, guest, amount);
        bookings.add(booking);
        return booking;
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        for (Booking b : bookings) {
            System.out.println(b.getDetails());
        }
    }

    public boolean checkoutRoom(int roomNumber) {
        for (Booking b : bookings) {
            if (b.getRoom().getRoomNumber() == roomNumber && b.isActive()) {
                b.checkout();
                return true;
            }
        }
        return false;
    }

    public double calculateTotalRevenue() {
        double total = 0;
        for (Booking b : bookings) {
            total += b.getPayment();
        }
        return total;
    }
}
