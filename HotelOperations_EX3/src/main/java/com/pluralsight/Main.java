package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Room room = null;
        Reservation reservation = null;
        Employee employee = null;
        Hotel hotel = null;

        while (true) {
            System.out.println("\n--- Hotel Operations Menu ---");
            System.out.println("1. Create Room");
            System.out.println("2. Create Reservation");
            System.out.println("3. Create Employee");
            System.out.println("4. Create Hotel");
            System.out.println("5. Book Room in Hotel");
            System.out.println("6. Punch In (Employee)");
            System.out.println("7. Punch Out (Employee)");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    int beds = getIntInput(scanner, "Enter number of beds:");
                    double price = getDoubleInput(scanner, "Enter room price:");
                    boolean occupied = getBooleanInput(scanner, "Is room occupied? (true/false):");
                    boolean dirty = getBooleanInput(scanner, "Is room dirty? (true/false):");
                    room = new Room(beds, price, occupied, dirty);
                    System.out.println("Room created. Available: " + room.isAvailable());
                    break;

                case 2:
                    scanner.nextLine();
                    String type;
                    while (true) {
                        System.out.print("Enter room type (king/double): ");
                        type = scanner.nextLine().toLowerCase();
                        if (type.equals("king") || type.equals("double")) break;
                        System.out.println("Invalid room type.");
                    }
                    int nights = getIntInput(scanner, "Enter number of nights:");
                    boolean weekend = getBooleanInput(scanner, "Is the stay over a weekend? (true/false):");
                    reservation = new Reservation(type, nights, weekend);
                    System.out.printf("Reservation total: $%.2f%n", reservation.getReservationTotal());
                    break;

                case 3:
                    int id = getIntInput(scanner, "Enter employee ID:");
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    double payRate = getDoubleInput(scanner, "Enter pay rate:");
                    double hoursWorked = getDoubleInput(scanner, "Enter initial hours worked:");
                    employee = new Employee(id, name, department, payRate, hoursWorked);
                    System.out.println("Employee created.");
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("Enter hotel name: ");
                    String hotelName = scanner.nextLine();
                    int suites = getIntInput(scanner, "Enter total number of suites:");
                    int basicRooms = getIntInput(scanner, "Enter total number of basic rooms:");

                    boolean useFullConstructor = getBooleanInput(scanner, "Do you want to specify booked rooms? (true/false):");
                    if (useFullConstructor) {
                        int bookedSuites = getIntInput(scanner, "Enter number of booked suites:");
                        int bookedBasicRooms = getIntInput(scanner, "Enter number of booked basic rooms:");
                        hotel = new Hotel(hotelName, suites, basicRooms, bookedSuites, bookedBasicRooms);
                    } else {
                        hotel = new Hotel(hotelName, suites, basicRooms);
                    }

                    System.out.println("Hotel created: " + hotelName);
                    System.out.println("Available Suites: " + hotel.getAvailableSuites());
                    System.out.println("Available Basic Rooms: " + hotel.getAvailableRooms());
                    break;

                case 5:
                    if (hotel == null) {
                        System.out.println("Create a hotel first.");
                        break;
                    }
                    boolean isSuite = getBooleanInput(scanner, "Book a suite? (true for suite / false for basic):");
                    int roomsToBook = getIntInput(scanner, "How many rooms to book?");
                    boolean booked = hotel.bookRoom(roomsToBook, isSuite);
                    System.out.println(booked ? "Booking successful." : "Not enough rooms available.");
                    System.out.println("Available Suites: " + hotel.getAvailableSuites());
                    System.out.println("Available Basic Rooms: " + hotel.getAvailableRooms());
                    break;

                case 6:
                    if (employee == null) {
                        System.out.println("Create an employee first.");
                        break;
                    }
                    employee.punchIn();
                    break;

                case 7:
                    if (employee == null) {
                        System.out.println("Create an employee first.");
                        break;
                    }
                    employee.punchOut();
                    System.out.printf("Total hours worked: %.2f (Regular: %.2f, Overtime: %.2f)%n",
                            employee.getHoursWorked(), employee.getRegularHours(), employee.getOvertimeHours());
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Helper methods
    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid number. Try again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return getIntInput(scanner);
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid number. Try again: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static boolean getBooleanInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextBoolean()) {
            System.out.print("Invalid input. Enter true or false: ");
            scanner.next();
        }
        return scanner.nextBoolean();
    }
}
