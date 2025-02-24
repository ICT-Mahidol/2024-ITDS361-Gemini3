public class SalesInvoice {
    private String invoiceNumber;
    private Customer customer;
    private Vehicle purchasedVehicle;
    private DealerInstalledOption[] dealerInstalledOptions;
    private double taxes;
    private double licenseFees;
    private double finalNegotiatedPrice;

    public SalesInvoice(String invoiceNumber, Customer customer, Vehicle purchasedVehicle,
                        DealerInstalledOption[] dealerInstalledOptions, double taxes, double licenseFees) {
        this.invoiceNumber = invoiceNumber;
        this.customer = customer;
        this.purchasedVehicle = purchasedVehicle;
        this.dealerInstalledOptions = dealerInstalledOptions;
        this.taxes = taxes;
        this.licenseFees = licenseFees;
        this.finalNegotiatedPrice = calculateTotalCost();
    }

    // Calculate total cost including options, taxes, and fees
    public double calculateTotalCost() {
        double optionsCost = 0;
        for (DealerInstalledOption option : dealerInstalledOptions) {
            optionsCost += option.getPrice();
        }
        return purchasedVehicle.getBaseCost() + optionsCost + taxes + licenseFees;
    }

    public double getFinalNegotiatedPrice() {
        return this.finalNegotiatedPrice;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getPurchasedVehicle() {
        return purchasedVehicle;
    }

    public void setPurchasedVehicle(Vehicle purchasedVehicle) {
        this.purchasedVehicle = purchasedVehicle;
    }

    public DealerInstalledOption[] getDealerInstalledOptions() {
        return dealerInstalledOptions;
    }

    public void setDealerInstalledOptions(DealerInstalledOption[] dealerInstalledOptions) {
        this.dealerInstalledOptions = dealerInstalledOptions;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getLicenseFees() {
        return licenseFees;
    }

    public void setLicenseFees(double licenseFees) {
        this.licenseFees = licenseFees;
    }

    public void setFinalNegotiatedPrice(double finalNegotiatedPrice) {
        this.finalNegotiatedPrice = finalNegotiatedPrice;
    }
}
