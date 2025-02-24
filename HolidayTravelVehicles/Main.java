public class Main {
    public static void main(String[] args) {
        // Create Vehicle objects
        Vehicle vehicle1 = new Vehicle("VHC001", "Luxury Camper", "Deluxe-2023", 2023, "CamperTech", 1250000.00);
        Vehicle vehicle2 = new Vehicle("VHC002", "Family Travel", "Explorer-XL", 2024, "TravelMaster", 980000.00);
        Vehicle vehicle3 = new Vehicle("VHC003", "Adventure Pro", "Offroad-360", 2022, "WildJourney", 1450000.00);

        // Display Vehicle information
        System.out.println("=== Holiday Travel Vehicles Inventory ===");
        displayVehicleDetails(vehicle1);
        displayVehicleDetails(vehicle2);
        displayVehicleDetails(vehicle3);

        // Display total value of all vehicles
        double totalInventoryValue = vehicle1.getBaseCost() + vehicle2.getBaseCost() + vehicle3.getBaseCost();
        System.out.println("\nTotal inventory value: $" + String.format("%,.2f", totalInventoryValue));
    }


private static void displayVehicleDetails(Vehicle vehicle) {
    System.out.println("\nVehicle Serial Number: " + vehicle.getSerialNumber());
    System.out.println("Name: " + vehicle.getName());
    System.out.println("Model: " + vehicle.getModel());
    System.out.println("Year: " + vehicle.getYear());
    System.out.println("Manufacturer: " + vehicle.getManufacturer());
    System.out.println("Base Cost: $" + String.format("%,.2f", vehicle.getBaseCost()));
    System.out.println("-------------------------------------");}
}