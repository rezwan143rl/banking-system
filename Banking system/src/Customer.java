public class Customer {

        private String firstName;
        private String lastName;

        public Customer() {
        }                        // constructor without parameter

        public Customer(String firstName, String lastName) {
            this.firstName = firstName;   
            this.lastName = lastName;                // constructor with parameter 
        }

        public String getFirstName() {
            return firstName;                //getter method to access private variables 
        }

        public void setFirstName(String FName) {
            this.firstName = FName;                //setter method to set private variables 
        }

        public String getLastName() {
            return lastName;                //getter method to access private variables 
        }

        public void setLastName(String LName) {        
            this.lastName = lastName;                //setter method to set private variables 
        }
    }

