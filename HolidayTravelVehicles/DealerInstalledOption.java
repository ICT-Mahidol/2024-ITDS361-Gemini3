package HolidayTravelVehicles;

public class DealerInstalledOption {
    
        private String optionCode;
        private String description;
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

        private double price;
    
        public DealerInstalledOption(String optionCode, String description, double price) {
            this.optionCode = optionCode;
            this.description = description;
            this.price = price;
        }
    
        public double getPrice() {
            return this.price;
        }
    }

