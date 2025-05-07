// Represents a car
class Car {
    private final String model;
    private final String carId;
    private final double dailyRate;
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
