public class Vehicle {
        private String serialNumber;
        private String name;
        private String model;
        private int year;
        private String manufacturer;
        private double baseCost;
    
        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Vehicle(String serialNumber, String name, String model, int year, String manufacturer, double baseCost) {
            this.serialNumber = serialNumber;
            this.name = name;
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.baseCost = baseCost;
        }
    
        // Apply discount to the vehicle
        public void applyDiscount(double percentage) {
            this.baseCost -= this.baseCost * (percentage / 100);
        }
    
        public double getBaseCost() {
            return this.baseCost;
        }
    }

