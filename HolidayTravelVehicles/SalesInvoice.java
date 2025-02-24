import java.util.Date;
import java.util.ArrayList;
import java.util.List;
public class SalesInvoice {
    private String invoiceID;
    private Date date;
    private Double negotiatedPrice;
    private Double tax;
    private Double registrationFee;
    private Double totalPrice;
    private String status;
    private Customer customer; // ความสัมพันธ์กับลูกค้า
    private Salesperson salesperson; // ความสัมพันธ์กับพนักงานขาย
    private Vehicle vehicle; // ความสัมพันธ์กับรถ
    private TradeInVehicle tradeInVehicle; // ความสัมพันธ์กับรถนำมาแลก (อาจเป็น null)
    private List<InvoiceOption> invoiceOptions; // ความสัมพันธ์กับอุปกรณ์แต่งรถ

    // Constructor
    public SalesInvoice(String invoiceID, Date date, Customer customer, Salesperson salesperson, Vehicle vehicle) {
        this.invoiceID = invoiceID;
        this.date = date;
        this.customer = customer;
        this.salesperson = salesperson;
        this.vehicle = vehicle;
        this.invoiceOptions = new ArrayList<>();
        this.status = "Created"; // สถานะเริ่มต้น
        
        // อัพเดทความสัมพันธ์ระหว่างคลาส
        customer.addSalesInvoice(this);
        salesperson.addSalesInvoice(this);
        vehicle.setSalesInvoice(this);
    }

    // Getters and Setters
    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getNegotiatedPrice() {
        return negotiatedPrice;
    }

    public void setNegotiatedPrice(Double negotiatedPrice) {
        this.negotiatedPrice = negotiatedPrice;
        calculateTotalPrice();
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
        calculateTotalPrice();
    }

    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
        calculateTotalPrice();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public TradeInVehicle getTradeInVehicle() {
        return tradeInVehicle;
    }

    public void setTradeInVehicle(TradeInVehicle tradeInVehicle) {
        this.tradeInVehicle = tradeInVehicle;
        calculateTotalPrice();
    }

    public List<InvoiceOption> getInvoiceOptions() {
        return invoiceOptions;
    }

    public void addInvoiceOption(DealerInstalledOption option, Integer quantity) {
        InvoiceOption invoiceOption = new InvoiceOption(this, option, quantity);
        invoiceOptions.add(invoiceOption);
        calculateTotalPrice();
    }
    
    // คำนวณราคารวมทั้งหมด
    void calculateTotalPrice() {
        double optionsCost = 0.0;
        for (InvoiceOption option : invoiceOptions) {
            optionsCost += option.getDealerInstalledOption().getPrice() * option.getQuantity();
        }
        
        double tradeInAmount = (tradeInVehicle != null) ? tradeInVehicle.getTradeInAllowance() : 0.0;
        
        this.totalPrice = (negotiatedPrice != null ? negotiatedPrice : 0.0) 
                         + (tax != null ? tax : 0.0) 
                         + (registrationFee != null ? registrationFee : 0.0) 
                         + optionsCost 
                         - tradeInAmount;
    }
}
