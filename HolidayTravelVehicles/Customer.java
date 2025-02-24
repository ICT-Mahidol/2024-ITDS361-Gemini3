package HolidayTravelVehicles;

public class Customer {
        private int customerID;
        private String name;
        private String address;
        private String phoneNumber;
    
        public int getCustomerID() {
            return customerID;
        }

        public void setCustomerID(int customerID) {
            this.customerID = customerID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Customer(int customerID, String name, String address, String phoneNumber) {
            this.customerID = customerID;
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }
    
        // Update customer address
        public void updateAddress(String newAddress) {
            this.address = newAddress;
        }
    
        public String getAddress() {
            return this.address;
        }
    }
