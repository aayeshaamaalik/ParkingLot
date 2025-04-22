
# Parking Lot System

This project implements a **Parking Lot Management System** using Object-Oriented Design (OOD) principles. It supports the parking and retrieval of different vehicle types (car, bus, motorcycle), handles spot allocation dynamically across levels and rows, and calculates parking fees using time-based billing.

**Design Reference:**  
This system follows design inspiration from the [Parking Lot design in ycwkatie’s OOD repo](https://github.com/ycwkatie/OOD-Object-Oriented-Design/blob/main/ood/parking_lot.md).

---

## Key Components and Interacting Objects

The system is composed of multiple components that work together to simulate real-world parking lot behavior:

- **ParkingLot**: Central controller that manages multiple levels, each with rows and spots. Handles vehicle entry, exit, and fee calculation.
- **Level → Row → Spot**: Hierarchical structure representing the physical layout of the parking lot.
- **Spot**: Represents a single parking space, tracks whether it's available or occupied.
- **Vehicle**: Abstract class for vehicles, implemented by concrete types:
  - `Car`, `Bus`, `Motorcycle`
- **Ticket**: Issued when a vehicle is parked, includes assigned spots and entry time.
- **Exceptions**:
  - `ParkFullException`: Thrown when no suitable spot is found.
  - `InvalidTicketException`: Thrown during invalid exit attempts.

---

## User Action Flow

The system supports the complete lifecycle of a parking session, managed via methods in the `ParkingLot` class:

1. `parkVehicle(Vehicle vehicle)`  
   - Checks if the lot has a sequence of `availableCount` matching the vehicle's required size.
   - Allocates contiguous spots to the vehicle and issues a `Ticket`.

2. `findSpots(Vehicle vehicle)`  
   - Iterates through levels and rows to find a fitting set of contiguous available spots.
   - Returns `null` if no suitable space is found.

3. `clearSpot(Ticket ticket)`  
   - Marks all spots in the ticket as available again.
   - Updates the global and level-specific available spot counts.
   - Throws `InvalidTicketException` if the ticket is malformed.

4. `calculateFee(Ticket ticket)`  
   - Computes the total fee based on hours elapsed between parking and exit.
   - Applies a default minimum of 1 hour and multiplies by `hourlyRate`.

5. `getAvailableCount()`  
   - Returns the total number of unoccupied spots across all levels.

---

## Getting Started

To set up and run this project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/parking-lot-system.git
   ```

2. Navigate to the project folder:
   ```bash
   cd parking-lot-system
   ```

3. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, etc.)

4. Build and run the project  
   Ensure your system supports **Java 8+**.

---

## Project Structure

| Component              | Description                                                      |
|------------------------|------------------------------------------------------------------|
| `ParkingLot`           | Manages vehicle parking, level coordination, and fee calculation|
| `Level`, `Row`, `Spot` | Represent the structural layout of the parking lot              |
| `Vehicle`, `Car`, etc. | Models different vehicle types and their space needs            |
| `Ticket`               | Tracks parking metadata (vehicle, entry time, assigned spots)   |
| `Exceptions`           | Custom exceptions to handle full lot or invalid exits           |

