package model;

public class Booking {
    private Room room;
    private Guest guest;
    private double payment;
    private boolean active;

    public Booking(Room room, Guest guest, double payment) {
        this.room = room;
        this.guest = guest;
        this.payment = payment;
        this.active = true;
        room.setBooked(true);
    }

    public void checkout() {
        this.active = false;
        room.setBooked(false);
    }

    public boolean isActive() {
        return active;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public double getPayment() {
        return payment;
    }

    public String getDetails() {
        return "Room " + room.getRoomNumber() +
                " | Guest: " + guest.getName() +
                " | Status: " + (active ? "Active" : "Checked Out") +
                " | Paid: ₹" + payment;
    }
}
