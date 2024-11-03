/*
This HotelReservationSystem Java program is a simple console-based application for managing hotel reservations. It allows users to search for available rooms, make reservations, view booking details, and process payments. Here's a breakdown of each component:

1. Class Room
Represents a hotel room with the following fields:
roomId: Unique identifier for each room.
type: Type of the room (e.g., "Single," "Double," "Suite").
isAvailable: Boolean indicating if the room is available for booking.
pricePerNight: Price per night for the room.
Constructor: Initializes a Room object with specific values for roomId, type, isAvailable, and pricePerNight.
2. Class Reservation
Represents a reservation with the following fields:
reservationId: Unique identifier for each reservation.
roomId: The ID of the reserved room.
guestName: Name of the guest making the reservation.
nights: Number of nights the guest will stay.
totalCost: Total cost of the reservation (calculated as pricePerNight * nights).
Constructor: Initializes a Reservation object with specific values for reservationId, roomId, guestName, nights, and totalCost.
3. Class HotelReservationSystem
The main class containing the core functionality and the main method. This class manages the rooms and reservations and handles the user interface and interactions.
Fields
rooms: An ArrayList of Room objects representing all rooms in the hotel.
reservations: A HashMap that stores reservations, with reservationId as the key and Reservation objects as values.
reservationCounter: A counter to generate unique reservation IDs.
Main Method
The entry point of the application. It initializes the rooms, displays a menu, and handles user input to perform actions like searching for rooms, making reservations, viewing bookings, and exiting.
Core Methods
initializeRooms()

Adds a predefined list of Room objects to the rooms list. Each room has an ID, type, availability status, and price per night.
searchAvailableRooms(Scanner scanner)

Prompts the user to enter a room type (e.g., "Single," "Double," "Suite") to search for available rooms.
Loops through rooms to find rooms that match the type and are available. Prints room details if found, otherwise, indicates no rooms of that type are available.
makeReservation(Scanner scanner)

Prompts the user to enter a room ID to book, guest name, and the number of nights.
Checks if the room is available, then calculates the total cost, creates a Reservation object, and adds it to the reservations map. Marks the room as unavailable.
Calls processPayment() to simulate payment processing.
viewBookingDetails(Scanner scanner)

Prompts the user for a reservation ID to view.
Looks up the reservation in reservations. If found, prints the details; if not, informs the user the reservation is not found.
processPayment(double amount)

Simulates payment processing by printing a message with the payment amount.
Usage
> The user runs the program, chooses options from the menu, and the program handles the input through a switch case:
Option 1: Searches for available rooms based on the specified type.
Option 2: Makes a reservation for a specified room, guest name, and stay duration.
Option 3: Views booking details for a specified reservation ID.
Option 4: Exits the program.*/

/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
                                                                   Code is Given below 
/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Room {
    int roomId;
    String type;
    boolean isAvailable;
    double pricePerNight;

    public Room(int roomId, String type, boolean isAvailable, double pricePerNight) {
        this.roomId = roomId;
        this.type = type;
        this.isAvailable = isAvailable;
        this.pricePerNight = pricePerNight;
    }
}

class Reservation {
    int reservationId;
    int roomId;
    String guestName;
    int nights;
    double totalCost;

    public Reservation(int reservationId, int roomId, String guestName, int nights, double totalCost) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.guestName = guestName;
        this.nights = nights;
        this.totalCost = totalCost;
    }
}

public class HotelReservationSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static HashMap<Integer, Reservation> reservations = new HashMap<>();
    private static int reservationCounter = 1;

    public static void main(String[] args) {
        initializeRooms();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchAvailableRooms(scanner);
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookingDetails(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", true, 100.0));
        rooms.add(new Room(102, "Single", true, 100.0));
        rooms.add(new Room(103, "Single", true, 100.0));
        rooms.add(new Room(104, "Single", true, 100.0));
        rooms.add(new Room(105, "Single", true, 100.0));
        rooms.add(new Room(201, "Double", true, 200.0));
        rooms.add(new Room(202, "Double", true, 200.0));
        rooms.add(new Room(203, "Double", true, 200.0));
        rooms.add(new Room(204, "Double", true, 200.0));
        rooms.add(new Room(205, "Double", true, 200.0));
        rooms.add(new Room(301, "Suite", true, 300.0));
        rooms.add(new Room(302, "Suite", true, 300.0));
        rooms.add(new Room(303, "Suite", true, 300.0));
        rooms.add(new Room(304, "Suite", true, 300.0));
        rooms.add(new Room(304, "Suite", true, 300.0));
    }

    private static void searchAvailableRooms(Scanner scanner) {
        System.out.print("Enter room type to search (Single, Double, Suite): ");
        String roomType = scanner.next();

        System.out.println("\nAvailable rooms of type '" + roomType + "':");
        boolean found = false;
        for (Room room : rooms) {
            if (room.type.equalsIgnoreCase(roomType) && room.isAvailable) {
                System.out.println("Room ID: " + room.roomId + ", Price per night: $" + room.pricePerNight);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available rooms of this type.");
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter Room ID to book: ");
        int roomId = scanner.nextInt();
        Room roomToBook = null;

        for (Room room : rooms) {
            if (room.roomId == roomId && room.isAvailable) {
                roomToBook = room;
                break;
            }
        }

        if (roomToBook == null) {
            System.out.println("Room not available or does not exist.");
            return;
        }

        System.out.print("Enter guest name: ");
        String guestName = scanner.next();
        System.out.print("Enter number of nights: ");
        int nights = scanner.nextInt();

        double totalCost = roomToBook.pricePerNight * nights;
        int reservationId = reservationCounter++;
        Reservation reservation = new Reservation(reservationId, roomId, guestName, nights, totalCost);
        reservations.put(reservationId, reservation);

        roomToBook.isAvailable = false;
        System.out.println("Reservation successful! Your reservation ID is: " + reservationId);
        processPayment(totalCost);
    }

    private static void viewBookingDetails(Scanner scanner) {
        System.out.print("Enter reservation ID to view details: ");
        int reservationId = scanner.nextInt();
        Reservation reservation = reservations.get(reservationId);

        if (reservation != null) {
            System.out.println("\n--- Booking Details ---");
            System.out.println("Reservation ID: " + reservationId);
            System.out.println("Guest Name: " + reservation.guestName);
            System.out.println("Room ID: " + reservation.roomId);
            System.out.println("Nights: " + reservation.nights);
            System.out.println("Total Cost: $" + reservation.totalCost);
        } else {
            System.out.println("Reservation not found.");
        }
    }

    private static void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + "...");
        System.out.println("Payment successful!");
    }
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
                          To run this HotelReservationSystem Java program, follow these steps:
/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
1. Save the Code
> Save the code in a file named - HotelReservationSystem.java.

2. Compile the Program
> Open a terminal or command prompt, navigate to the directory where the file is saved, and compile it with:
                   > javac HotelReservationSystem.java

> If there are no errors, this will generate a HotelReservationSystem.class file.

3. Run the Program
> Run the compiled program with:
                  > java HotelReservationSystem

/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
                                                   Example Interaction
/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
Here's an example of how the program might run:

--- Hotel Reservation System ---
1. Search for Available Rooms
2. Make a Reservation
3. View Booking Details
4. Exit
Choose an option: 1

Enter room type to search (Single, Double, Suite): Double

Available rooms of type 'Double':
Room ID: 201, Price per night: $200.0
Room ID: 202, Price per night: $200.0
Room ID: 203, Price per night: $200.0
Room ID: 204, Price per night: $200.0
Room ID: 205, Price per night: $200.0

--- Hotel Reservation System ---
1. Search for Available Rooms
2. Make a Reservation
3. View Booking Details
4. Exit
Choose an option: 2

Enter Room ID to book: 202
Enter guest name: JohnDoe
Enter number of nights: 3

Reservation successful! Your reservation ID is: 1
Processing payment of $600.0...
Payment successful!

--- Hotel Reservation System ---
1. Search for Available Rooms
2. Make a Reservation
3. View Booking Details
4. Exit
Choose an option: 3

Enter reservation ID to view details: 1

--- Booking Details ---
Reservation ID: 1
Guest Name: JohnDoe
Room ID: 202
Nights: 3
Total Cost: $600.0

--- Hotel Reservation System ---
1. Search for Available Rooms
2. Make a Reservation
3. View Booking Details
4. Exit
Choose an option: 4
Exiting the system. Goodbye!

> In this example:

   • The user searches for available "Double" rooms.
   • They proceed to make a reservation for Room ID: 202 under the name "JohnDoe" for 3 nights.
   • They then view the booking details using the reservation ID 1.
   • Finally, they choose to exit the system.