import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

// Represents a car
class Car {
    private String model;
    private String carId;
    private double dailyRate;
    private boolean isAvailable;

    public Car(String model, String carId, double dailyRate) {
        this.model = model;
        this.carId = carId;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }

    public String getModel() {
        return model;
    }

    public String getCarId() {
        return carId;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", carId='" + carId + '\'' +
                ", dailyRate=" + dailyRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

// Represents a rental
class Rental {
    private Car car;
    private String customerName;
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private double totalCost;

    public Rental(Car car, String customerName, LocalDateTime pickupDate, LocalDateTime returnDate) {
        this.car = car;
        this.customerName = customerName;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.totalCost = calculateCost();
    }

    private double calculateCost() {
        long days = ChronoUnit.DAYS.between(pickupDate, returnDate);
        return car.getDailyRate() * days;
    }

    public Car getCar() {
        return car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void printConfirmationSlip() {
        System.out.println("--- Rental Confirmation ---");
        System.out.println("Customer: " + customerName);
        System.out.println("Car: " + car.getModel() + " (" + car.getCarId() + ")");
        System.out.println("Pickup: " + pickupDate);
        System.out.println("Return: " + returnDate);
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
        System.out.println("-------------------------");
    }

    @Override
    public String toString() {
        return "Rental{" +
                "car=" + car +
                ", customerName='" + customerName + '\'' +
                ", pickupDate=" + pickupDate +
                ", returnDate=" + returnDate +
                ", totalCost=" + totalCost +
                '}';
    }
}

// Manages car rentals
class RentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

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

public class CarRentalApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalSystem rentalSystem = new RentalSystem();

        // Add some cars
        rentalSystem.addCar(new Car("Toyota Camry", "CAM123", 50.0));
        rentalSystem.addCar(new Car("Honda Civic", "CIV456", 45.0));
        rentalSystem.addCar(new Car("Ford F-150", "F150", 70.0));

        int choice;
        do {
            System.out.println("\n--- Car Rental System ---");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rentalSystem.rentCar(scanner);
                    break;
                case 2:
                    rentalSystem.returnCar(scanner);
                    break;
                case 3:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        scanner.close();
    }
}