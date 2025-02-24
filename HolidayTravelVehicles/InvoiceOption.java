public class InvoiceOption {
    private SalesInvoice salesInvoice;
    private DealerInstalledOption dealerInstalledOption;
    private Integer quantity;

    // Constructor
    public InvoiceOption(SalesInvoice salesInvoice, DealerInstalledOption dealerInstalledOption, Integer quantity) {
        this.salesInvoice = salesInvoice;
        this.dealerInstalledOption = dealerInstalledOption;
        this.quantity = quantity;

        // อัพเดทความสัมพันธ์ระหว่างคลาส
        dealerInstalledOption.addInvoiceOption(this);
    }

    // Getters and Setters
    public SalesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    public DealerInstalledOption getDealerInstalledOption() {
        return dealerInstalledOption;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        // อัพเดทการคำนวณราคาในใบเสนอราคา
        salesInvoice.calculateTotalPrice();
    }
}