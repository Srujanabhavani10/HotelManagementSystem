package service;

import model.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private List<Room> rooms = new ArrayList<>();

    public RoomService(int count) {
        for (int i = 1; i <= count; i++) {
            rooms.add(new Room(i));
        }
    }

    public void showAllRooms() {
        for (Room room : rooms) {
            System.out.println("Room " + room.getRoomNumber() + " - " + room.getStatus());
        }
    }

    public Room findAvailableRoom() {
        for (Room room : rooms) {
            if (!room.isBooked()) {
                return room;
            }
        }
        return null;
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
