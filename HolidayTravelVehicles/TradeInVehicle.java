public class TradeInVehicle {
    private String serialNumber;
    private String make;
    private String model;
    private Integer year;
    private Double tradeInAllowance;
    private SalesInvoice salesInvoice; // ความสัมพันธ์กับใบเสนอราคา

    // Constructor
    public TradeInVehicle(String serialNumber, String make, String model, Integer year, Double tradeInAllowance) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.tradeInAllowance = tradeInAllowance;
    }

    // Getters and Setters
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getTradeInAllowance() {
        return tradeInAllowance;
    }

    public void setTradeInAllowance(Double tradeInAllowance) {
        this.tradeInAllowance = tradeInAllowance;
        if (salesInvoice != null) {
            // อัพเดทราคาในใบเสนอราคาเมื่อมีการเปลี่ยนแปลงเงินที่ได้จากการแลกรถ
            salesInvoice.setTradeInVehicle(this);
        }
    }

    public SalesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
    }
}
