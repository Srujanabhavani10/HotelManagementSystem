import model.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomService roomService = new RoomService(10);
        BookingService bookingService = new BookingService();

        while (true) {
            System.out.println("\n===== Hotel Management System =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Bookings");
            System.out.println("4. Checkout");
            System.out.println("5. View Revenue");
            System.out.println("6. Exit");
            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    roomService.showAllRooms();
                    break;
                case 2:
                    Room room = roomService.findAvailableRoom();
                    if (room == null) {
                        System.out.println("Sorry, no rooms available.");
                        break;
                    }
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter payment amount: ₹");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    Guest guest = new Guest(name);
                    bookingService.bookRoom(room, guest, amount);
                    System.out.println("Room " + room.getRoomNumber() + " booked successfully!");
                    break;
                case 3:
                    bookingService.viewBookings();
                    break;
                case 4:
                    System.out.print("Enter room number to checkout: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    if (bookingService.checkoutRoom(num)) {
                        System.out.println("Room " + num + " checked out successfully.");
                    } else {
                        System.out.println("No active booking found for that room.");
                    }
                    break;
                case 5:
                    System.out.println("Total Revenue: ₹" + bookingService.calculateTotalRevenue());
                    break;
                case 6:
                    System.out.println("Thank you! Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
