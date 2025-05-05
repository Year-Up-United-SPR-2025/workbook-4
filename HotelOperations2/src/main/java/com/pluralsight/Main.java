package com.pluralsight;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Room Input
        System.out.println("Enter number of beds in the room:");
        int beds = scanner.nextInt();

        System.out.println("Enter price of the room:");
        double price = scanner.nextDouble();

        System.out.println("Is the room occupied? (true/false):");
        boolean occupied = scanner.nextBoolean();

        System.out.println("Is the room dirty? (true/false):");
        boolean dirty = scanner.nextBoolean();

        Room room = new Room(beds, price, occupied, dirty);
        System.out.println("Room is available: " + room.isAvailable());

        //Reservation Input
        scanner.nextLine();
        System.out.println("\nEnter room type (king/double):");
        String roomType = scanner.nextLine();

        System.out.println("Enter number of nights:");
        int nights = scanner.nextInt();

        System.out.println("Is this stay over a weekend? (true/false):");
        boolean isWeekend = scanner.nextBoolean();

        Reservation reservation = new Reservation(roomType, nights, isWeekend);
        System.out.printf("Reservation total: $%.2f%n", reservation.getReservationTotal());

        //Employee Input
        System.out.println("\nEnter employee ID:");
        int empId = scanner.nextInt();

        scanner.nextLine(); // Clear newline
        System.out.println("Enter employee name:");
        String name = scanner.nextLine();

        System.out.println("Enter department:");
        String department = scanner.nextLine();

        System.out.println("Enter pay rate:");
        double payRate = scanner.nextDouble();

        System.out.println("Enter hours worked:");
        double hoursWorked = scanner.nextDouble();

        Employee employee = new Employee(empId, name, department, payRate, hoursWorked);
        //Menu
        boolean running = true;
        while (running) {
            System.out.println("\n---- Hotel Operations Menu ----");
            System.out.println("1. Check into room");
            System.out.println("2. Check out of room");
            System.out.println("3. Clean room");
            System.out.println("4. Punch employee time card");
            System.out.println("5. Show room status");
            System.out.println("6. Show employee info");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.next();
            switch (input) {
                case "1":
                    room.checkIn();
                    break;
                case "2":
                    room.checkIn();
                    break;
                case "3":
                    room.cleanRoom();
                    break;
                case  "4":
                    System.out.println("Enter Time (ex 9.0 for 9:00 AM): \n");
                    try {
                        double time = Double.parseDouble(scanner.next());
                        employee.punchTimeCard(time);
                    }catch (NumberFormatException e){
                        System.out.println("Invalid Time Format Try Again");
                    }
                    break;
                case "5":
                System.out.println("Room occupied: " + room.isOccupied());
                System.out.println("Room dirty: " + room.isDirty());
                System.out.println("Room availability: " + room.getAvailabilityStatus());
                break;
                case "6":
                    System.out.println("Employee: " + employee.getName());
                    System.out.println("Hours worked: " + employee.getHoursWorked());
                    System.out.printf("Total pay: $%.2f%n", employee.getTotalPay());
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}