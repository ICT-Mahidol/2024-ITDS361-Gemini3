import java.util.Date;
import java.util.ArrayList;
import java.util.List;
public class DealerInstalledOption {
    private String optionCode;
    private String description;
    private Double price;
    private List<InvoiceOption> invoiceOptions; // ความสัมพันธ์กับใบเสนอราคา

    // Constructor
    public DealerInstalledOption(String optionCode, String description, Double price) {
        this.optionCode = optionCode;
        this.description = description;
        this.price = price;
        this.invoiceOptions = new ArrayList<>();
    }

    // Getters and Setters
    public String getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<InvoiceOption> getInvoiceOptions() {
        return invoiceOptions;
    }

    public void addInvoiceOption(InvoiceOption invoiceOption) {
        invoiceOptions.add(invoiceOption);
    }
}
