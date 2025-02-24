import java.util.Date;
import java.util.ArrayList;
import java.util.List;
public class Customer {
    private String customerID;
    private String name;
    private String address;
    private String phoneNumber;
    private List<SalesInvoice> salesInvoices; // ความสัมพันธ์ 1:many กับใบเสนอราคา

    // Constructor
    public Customer(String customerID, String name, String address, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salesInvoices = new ArrayList<>();
    }

    // Getters and Setters
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<SalesInvoice> getSalesInvoices() {
        return salesInvoices;
    }

    public void addSalesInvoice(SalesInvoice salesInvoice) {
        salesInvoices.add(salesInvoice);
    }
}
