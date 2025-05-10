import java.util.Date;
import java.util.ArrayList;
import java.util.List;
public class Salesperson {
    private String salespersonID;
    private String name;
    private String contactInfo;
    private List<SalesInvoice> salesInvoices; // ความสัมพันธ์ 1:many กับใบเสนอราคา

    // Constructor
    public Salesperson(String salespersonID, String name, String contactInfo) {
        this.salespersonID = salespersonID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.salesInvoices = new ArrayList<>();
    }

    // Getters and Setters
    public String getSalespersonID() {
        return salespersonID;
    }

    public void setSalespersonID(String salespersonID) {
        this.salespersonID = salespersonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<SalesInvoice> getSalesInvoices() {
        return salesInvoices;
    }

    public void addSalesInvoice(SalesInvoice salesInvoice) {
        salesInvoices.add(salesInvoice);
    }
}
