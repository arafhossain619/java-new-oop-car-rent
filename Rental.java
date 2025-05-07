// Represents a rental
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Rental {
    private final Car car;
    private final String customerName;
    private final LocalDateTime pickupDate;
    private final LocalDateTime returnDate;
    private final double totalCost;

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
