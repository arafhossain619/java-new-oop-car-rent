# Car Rental System

## Overview
This is a simple console-based Car Rental System implemented in Java. It allows users to rent and return cars. The system tracks available cars, calculates rental costs based on the number of days, and generates rental confirmation slips.

### Features:
- **Car Management**: Add cars to the system with details like model, car ID, and daily rental rate.
- **Renting a Car**: Customers can select an available car, specify pickup and return dates, and the system calculates the total rental cost.
- **Returning a Car**: Customers can return rented cars, and the system updates the car's availability.
- **Cost Calculation**: Rental cost is automatically calculated based on the number of days a car is rented.
- **Confirmation Slip**: After renting a car, the system generates a confirmation slip showing rental details (car model, rental period, and total cost).

## Classes

### `Car`
Represents a car in the system.

**Attributes:**
- `model`: The car's model (e.g., "Toyota Camry").
- `carId`: A unique identifier for the car.
- `dailyRate`: The daily rental cost for the car.
- `isAvailable`: A flag indicating if the car is available for rent.

**Methods:**
- `getModel()`: Returns the car's model.
- `getCarId()`: Returns the car's unique identifier.
- `getDailyRate()`: Returns the daily rental rate.
- `isAvailable()`: Checks if the car is available for rent.
- `setAvailable()`: Updates the availability status of the car.
- `toString()`: Returns a string representation of the car.

### `Rental`
Represents a rental transaction.

**Attributes:**
- `car`: The car being rented.
- `customerName`: The name of the customer renting the car.
- `pickupDate`: The date and time when the car is picked up.
- `returnDate`: The date and time when the car is returned.
- `totalCost`: The total cost of the rental.

**Methods:**
- `calculateCost()`: Calculates the total cost of the rental based on the daily rate and rental duration.
- `printConfirmationSlip()`: Prints the rental confirmation with details of the car, rental period, and total cost.
- `toString()`: Returns a string representation of the rental transaction.

### `RentalSystem`
Manages the car rental system.

**Methods:**
- `addCar()`: Adds a car to the system.
- `rentCar()`: Handles the process of renting a car, including selecting a car, entering rental details, and generating a confirmation slip.
- `returnCar()`: Handles the process of returning a rented car.
- `findCar()`: Finds a car by its unique car ID.

### `CarRentalApp`
The main class that runs the application. It interacts with the user to perform various tasks like renting and returning cars.

## How to Run
1. Clone or download the repository.
2. Compile and run the `CarRentalApp` class.
3. The program will display a menu with the following options:
   - **Rent a Car**: Rent an available car by selecting a car ID and providing rental details.
   - **Return a Car**: Return a rented car by entering its car ID.
   - **Exit**: Exit the program.

## Example Usage

### Renting a Car:

--- Car Rental System ---

Rent a Car

Return a Car

Exit
Enter your choice: 1
Available Cars:
Car{model='Toyota Camry', carId='CAM123', dailyRate=50.0, isAvailable=true}
Car{model='Honda Civic', carId='CIV456', dailyRate=45.0, isAvailable=true}
Car{model='Ford F-150', carId='F150', dailyRate=70.0, isAvailable=true}
Enter Car ID to rent: CAM123
Enter Customer Name: John Doe
Enter Pickup Date (YYYY-MM-DDTHH:MM): 2025-05-08T10:00
Enter Return Date (YYYY-MM-DDTHH:MM): 2025-05-10T10:00
Car rented successfully!
--- Rental Confirmation ---
Customer: John Doe
Car: Toyota Camry (CAM123)
Pickup: 2025-05-08T10:00
Return: 2025-05-10T10:00
Total Cost: $100.00

shell
Copy
Edit

### Returning a Car:

Enter Car ID to return: CAM123
Car returned successfully.

markdown
Copy
Edit

## Requirements
- **Java 8** or later.

## License
This project is licensed under the MIT License.


## Requirements
- **Java 8** or later.

## License
This project is licensed under the MIT License.

