package HolidayTravelVehicles;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // **Test 1: Customer - Update Address**
        System.out.println("===== Test 1: Customer - Update Address =====");
        Customer customer = new Customer(101, "John Doe", "123 Main St", "555-1234");
        System.out.println("Old Address: " + customer.getAddress());
        customer.updateAddress("456 New St");
        System.out.println("New Address: " + customer.getAddress());
        System.out.println(customer.getAddress().equals("456 New St") ? "✅ Passed" : "❌ Failed");

        // **Test 2: Vehicle - Apply Discount**
        System.out.println("\n===== Test 2: Vehicle - Apply Discount =====");
        Vehicle vehicle = new Vehicle("V12345", "Toyota", "Corolla", 2022, "Toyota", 20000);
        System.out.println("Original Price: $" + vehicle.getBaseCost());
        vehicle.applyDiscount(10); // ลดราคา 10%
        System.out.println("Discounted Price: $" + vehicle.getBaseCost());
        System.out.println(vehicle.getBaseCost() == 18000 ? "✅ Passed" : "❌ Failed");

        // **Test 3: SalesInvoice - Calculate Total Cost**
        System.out.println("\n===== Test 3: SalesInvoice - Calculate Total Cost =====");
        Set<DealerInstalledOption> options = new HashSet<>();
        options.add(new DealerInstalledOption("O001", "Sunroof", 1000));
        options.add(new DealerInstalledOption("O002", "Leather Seats", 1500));

        SalesInvoice invoice = new SalesInvoice("INV001", customer, vehicle, options, 2000, 500);
        System.out.println("Expected Total Price: $24000");
        System.out.println("Calculated Total Price: $" + invoice.getFinalNegotiatedPrice());
        System.out.println(invoice.getFinalNegotiatedPrice() == 24000 ? "✅ Passed" : "❌ Failed");
    }
}
