// Represents a rental

// Manages car rentals

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RentalSystem {
    private final List<Car> cars = new ArrayList<>();
    private final List<Rental> rentals = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void rentCar(Scanner scanner) {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }

        System.out.print("Enter Car ID to rent: ");
        String carId = scanner.next();
        Car carToRent = findCar(carId);

        if (carToRent == null || !carToRent.isAvailable()) {
            System.out.println("Car not available.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.next();

        System.out.print("Enter Pickup Date (YYYY-MM-DDTHH:MM): ");
        LocalDateTime pickupDate = LocalDateTime.parse(scanner.next());

        System.out.print("Enter Return Date (YYYY-MM-DDTHH:MM): ");
        LocalDateTime returnDate = LocalDateTime.parse(scanner.next());

        carToRent.setAvailable(false);
        Rental rental = new Rental(carToRent, customerName, pickupDate, returnDate);
        rentals.add(rental);

        System.out.println("Car rented successfully!");
        rental.printConfirmationSlip();
    }

    public void returnCar(Scanner scanner) {
        System.out.print("Enter Car ID to return: ");
        String carId = scanner.next();
        Car carToReturn = findCar(carId);

        if (carToReturn == null || carToReturn.isAvailable()) {
            System.out.println("Invalid car ID or car not rented.");
            return;
        }

        carToReturn.setAvailable(true);
        System.out.println("Car returned successfully.");
    }

    private Car findCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equalsIgnoreCase(carId)) {
                return car;
            }
        }
        return null;
    }
}